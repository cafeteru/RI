package uo.ri.persistence.impl;

import java.sql.*;
import java.util.Date;
import java.util.*;

import alb.util.date.DateUtil;
import alb.util.jdbc.Jdbc;
import alb.util.math.Round;
import uo.ri.common.BusinessException;
import uo.ri.common.TratamientoExcepciones;
import uo.ri.persistence.FacturasGateway;

public class FacturasGatewayImpl implements FacturasGateway {
	private Connection c;
	private PreparedStatement pst;
	private ResultSet rs;

	public FacturasGatewayImpl() throws SQLException, BusinessException {
		setConnection();
	}

	@Override
	public void setConnection() throws BusinessException {
		c = TratamientoExcepciones.setConnection();
	}

	@Override
	public Map<String, Object> crearFactura(List<Long> idsAveria) throws SQLException, BusinessException {
		verificarAveriasTerminadas(idsAveria);
		long numeroFactura = generarNuevoNumeroFactura();
		Date fechaFactura = DateUtil.today();
		double totalFactura = calcularImportesAverias(idsAveria);
		double iva = porcentajeIva(totalFactura, fechaFactura);
		double importe = totalFactura * (1 + iva / 100);
		importe = Round.twoCents(importe);

		long idFactura = crearFactura(numeroFactura, fechaFactura, iva, importe);
		vincularAveriasConFactura(idFactura, idsAveria);
		cambiarEstadoAverias(idsAveria, "FACTURADA");

		Map<String, Object> factura = new HashMap<String, Object>();
		factura.put("numeroFactura", numeroFactura);
		factura.put("fechaFactura", fechaFactura);
		factura.put("iva", iva);
		factura.put("totalFactura", totalFactura);
		factura.put("idsAveria", idsAveria);
		return factura;
	}

	private void verificarAveriasTerminadas(List<Long> idsAveria) throws SQLException, BusinessException {
		try {
			pst = TratamientoExcepciones.configurarPreparementStament(c, "SQL_VERIFICAR_ESTADO_AVERIA");
			for (Long idAveria : idsAveria) {
				TratamientoExcepciones.setLong(pst, 1, idAveria);
				rs = TratamientoExcepciones.executeQuery(pst);
				if (rs.next() == false)
					throw new BusinessException("No existe la averia " + idAveria);
				String status = rs.getString(1);
				if (!"TERMINADA".equalsIgnoreCase(status))
					throw new BusinessException("No está terminada la avería " + idAveria);
			}
			c.commit();
		} finally {
			Jdbc.close(rs, pst, c);
		}

	}

	private void cambiarEstadoAverias(List<Long> idsAveria, String status) throws SQLException, BusinessException {
		try {
			pst = TratamientoExcepciones.configurarPreparementStament(c, "SQL_ACTUALIZAR_ESTADO_AVERIA");
			for (Long idAveria : idsAveria) {
				TratamientoExcepciones.setString(pst, 1, status);
				TratamientoExcepciones.setLong(pst, 2, idAveria);
				TratamientoExcepciones.executeUpdate(pst);
			}
			c.commit();
		} finally {
			Jdbc.close(pst);
		}
	}

	private void vincularAveriasConFactura(long idFactura, List<Long> idsAveria)
			throws SQLException, BusinessException {
		try {
			pst = TratamientoExcepciones.configurarPreparementStament(c, "SQL_VINCULAR_AVERIA_FACTURA");
			for (Long idAveria : idsAveria) {
				TratamientoExcepciones.setLong(pst, 1, idFactura);
				TratamientoExcepciones.setLong(pst, 2, idAveria);
				TratamientoExcepciones.executeUpdate(pst);
			}
			c.commit();
		} finally {
			Jdbc.close(pst);
		}
	}

	private long crearFactura(long numeroFactura, Date fechaFactura, double iva, double totalConIva)
			throws SQLException, BusinessException {
		try {
			pst = TratamientoExcepciones.configurarPreparementStament(c, "SQL_INSERTAR_FACTURA");
			TratamientoExcepciones.setLong(pst, 1, numeroFactura);
			TratamientoExcepciones.setDate(pst, 2, new java.sql.Date(fechaFactura.getTime()));
			TratamientoExcepciones.setDouble(pst, 3, iva);
			TratamientoExcepciones.setDouble(pst, 4, totalConIva);
			TratamientoExcepciones.setString(pst, 5, "SIN_ABONAR");
			TratamientoExcepciones.executeUpdate(pst);
			c.commit();
			return getGeneratedKey(numeroFactura);
		} finally {
			Jdbc.close(pst);
		}
	}

	private long getGeneratedKey(long numeroFactura) throws SQLException, BusinessException {
		try {
			pst = TratamientoExcepciones.configurarPreparementStament(c, "SQL_RECUPERAR_CLAVE_GENERADA");
			TratamientoExcepciones.setLong(pst, 1, numeroFactura);
			rs = TratamientoExcepciones.executeQuery(pst);
			rs.next();
			c.commit();
			return rs.getLong(1);
		} finally {
			Jdbc.close(rs, pst);
		}
	}

	private Long generarNuevoNumeroFactura() throws SQLException, BusinessException {
		try {
			pst = TratamientoExcepciones.configurarPreparementStament(c, "SQL_ULTIMO_NUMERO_FACTURA");
			rs = TratamientoExcepciones.executeQuery(pst);
			c.commit();
			if (rs.next())
				return rs.getLong(1) + 1;
			else
				return 1L;
		} finally {
			Jdbc.close(rs, pst);
		}
	}

	private double porcentajeIva(double totalFactura, Date fechaFactura) {
		return DateUtil.fromString("1/7/2012").before(fechaFactura) ? 21.0 : 18.0;
	}

	protected double calcularImportesAverias(List<Long> idsAveria) throws BusinessException, SQLException {
		double totalFactura = 0.0;
		for (Long idAveria : idsAveria) {
			double importeManoObra = consultaImporteManoObra(idAveria);
			double importeRepuestos = consultaImporteRepuestos(idAveria);
			double totalAveria = importeManoObra + importeRepuestos;
			actualizarImporteAveria(idAveria, totalAveria);
			totalFactura += totalAveria;
		}
		return totalFactura;
	}

	private void actualizarImporteAveria(Long idAveria, double totalAveria) throws SQLException, BusinessException {
		try {
			pst = TratamientoExcepciones.configurarPreparementStament(c, "SQL_UPDATE_IMPORTE_AVERIA");
			TratamientoExcepciones.setDouble(pst, 1, totalAveria);
			TratamientoExcepciones.setLong(pst, 2, idAveria);
			TratamientoExcepciones.executeUpdate(pst);
		} finally {
			Jdbc.close(pst);
		}
	}

	private double consultaImporteRepuestos(Long idAveria) throws SQLException, BusinessException {
		try {
			pst = TratamientoExcepciones.configurarPreparementStament(c, "SQL_IMPORTE_REPUESTOS");
			TratamientoExcepciones.setLong(pst, 1, idAveria);
			rs = TratamientoExcepciones.executeQuery(pst);
			c.commit();
			if (rs.next() == false)
				return 0.0;
			return rs.getDouble(1);
		} finally {
			Jdbc.close(rs, pst);
		}
	}

	private double consultaImporteManoObra(Long idAveria) throws BusinessException, SQLException {
		try {
			pst = TratamientoExcepciones.configurarPreparementStament(c, "SQL_IMPORTE_MANO_OBRA");
			TratamientoExcepciones.setLong(pst, 1, idAveria);
			rs = TratamientoExcepciones.executeQuery(pst);
			c.commit();
			if (rs.next() == false)
				throw new BusinessException("La averia no existe o no se puede facturar");
			return rs.getDouble(1);
		} catch (BusinessException e) {
			throw e;
		} finally {
			Jdbc.close(rs, pst);
		}
	}

}
