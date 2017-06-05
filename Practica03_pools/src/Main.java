import java.sql.*;
import java.util.*;

import javax.sql.*;

import com.mchange.v2.c3p0.DataSources;

public class Main {
	static String[] oracle = { "jdbc:oracle:thin:@156.35.94.99:1521:DESA",
			"uo239795", "uo239795" };
	static String[] hsqldb = { "jdbc:hsqldb:hsql://localhost", "sa", "" };

	static String consulta;
	static Connection connection;
	static Statement statement;
	static PreparedStatement preparedStatement;
	static ResultSet resultSet;

	public static void main(String[] args) throws SQLException {
		// ejercicio1(hsqldb);
		// ejercicio1(oracle);
		// ejercicio2(hsqldb);
		// ejercicio2(oracle);
		ejercicio3(hsqldb);
		ejercicio3(oracle);
	}

	public static void ejercicio1(String[] datos) throws SQLException {
		connection = DriverManager.getConnection(datos[0], datos[1], datos[2]);
		int totalStatement = 0, totalPreparement = 0;
		long inicio = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			consulta = "SELECT * FROM Tvehiculos v WHERE v.id = '" + i + "'";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(consulta);
			while (resultSet.next()) {
				if (resultSet.getObject(1) != null)
					totalStatement++;
			}
			resultSet.close();
			statement.close();
		}
		long fin = System.currentTimeMillis();

		System.out.println(totalStatement + " Tiempo Statement: "
				+ (fin - inicio));

		inicio = System.currentTimeMillis();
		consulta = "SELECT * FROM Tvehiculos v WHERE v.id = ?";
		for (int i = 0; i < 1000; i++) {
			preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setInt(1, i);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getObject(1) != null)
					totalPreparement++;
			}
			resultSet.close();
			preparedStatement.close();
		}
		fin = System.currentTimeMillis();
		System.out.println(totalPreparement + "Tiempo preparedStatement: "
				+ (fin - inicio));

		connection.close();
	}

	public static void ejercicio2(String[] datos) throws SQLException {
		int totalPreparement = 0;
		connection = DriverManager.getConnection(datos[0], datos[1], datos[2]);
		consulta = "SELECT * FROM Tvehiculos v WHERE v.id = ?";
		long inicio = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setInt(1, i);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getObject(1) != null)
					totalPreparement++;
			}
			resultSet.close();
			preparedStatement.close();
		}
		long fin = System.currentTimeMillis();
		System.out.println(totalPreparement + "Tiempo sin cerrar: "
				+ (fin - inicio));
		connection.close();

		sinPool(datos, totalPreparement);

	}

	private static void sinPool(String[] datos, int totalPreparement)
			throws SQLException {
		long inicio;
		long fin;
		inicio = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			connection = DriverManager.getConnection(datos[0], datos[1],
					datos[2]);
			consulta = "SELECT * FROM Tvehiculos v WHERE v.id = ?";
			preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setInt(1, i);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getObject(1) != null)
					totalPreparement++;
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		}
		fin = System.currentTimeMillis();
		System.out.println("Tiempo con cerrar: " + (fin - inicio));
	}

	public static void ejercicio3(String[] datos) throws SQLException {
		connection = DriverManager.getConnection(datos[0], datos[1], datos[2]);
		System.out.println("Sin pool");
		sinPool(datos, 0);
		long inicio = System.currentTimeMillis();
		
		for (int i = 0; i < 100; i++) {
			crearConexion(datos);
			hazAlgo(datos, 0);
			cerrarConexion();
		}
		
		long fin = System.currentTimeMillis();
		System.out.println("Tiempo con pool: " + (fin - inicio));
	}

	private static void cerrarConexion() throws SQLException {
		connection.close();
	}

	private static void crearConexion(String[] datos) throws SQLException {
		DataSource ds_unpooled = DataSources.unpooledDataSource(datos[0],
				datos[1], datos[2]);
		Map<String, Integer> overrides = new HashMap<String, Integer>();
		int maxPoolSize = 30;
		int minPoolSize = 3;
		int initialPoolSize = 3;
		overrides.put("maxPoolSize", maxPoolSize);
		overrides.put("minPoolSize", minPoolSize);
		overrides.put("initialPoolSize", initialPoolSize);

		DataSource ds_pooled = DataSources.pooledDataSource(ds_unpooled,
				overrides);
		connection = ds_pooled.getConnection();

	}

	private static void hazAlgo(String[] datos, int totalPreparement)
			throws SQLException {
		consulta = "SELECT * FROM Tvehiculos v WHERE v.id = ?";
		for (int i = 0; i < 100; i++) {
			preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setInt(1, i);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getObject(1) != null)
					totalPreparement++;
			}
			resultSet.close();
			preparedStatement.close();
		}
	}

}
