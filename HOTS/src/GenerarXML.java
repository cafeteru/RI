import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import alb.util.jdbc.Jdbc;

public class GenerarXML {
	static Connection con;
	static PreparedStatement ps;
	static ResultSet rs;

	public static void main(String[] args) {
		// crearXMLMapas();
		// crearXMLMonturas();
		String aux = "";
		try {
			con = Jdbc.getConnection();
			ps = con.prepareStatement("SELECT * FROM HEROE");
			rs = ps.executeQuery();
			aux += "<heroes>\n";
			while (rs.next()) {
				aux += "\t<heroe>\n";
				aux += "\t\t<nombre_heroe>" + rs.getString("heroe_id") + "</nombre_heroe>\n";
				aux += "\t\t<introduccion_heroe>" + rs.getString("introduccion") + "</introduccion_heroe>\n";
				aux += "\t\t<universo juego = \"" + rs.getString("universo") + "\"></universo>\n";
				aux += "\t\t<tipo_heroe clase = \"" + rs.getString("tipo") + "\"></tipo_heroe>\n";
				aux += "\t\t<tipo_montura tipo = \"" + rs.getInt("montura_caballo") + "\"></tipo_montura>\n";
				aux += "\t\t<precio_monedas_heroe>" + rs.getInt("precio_monedas") + "</precio_monedas_heroe>\n";
				aux += "\t\t<precio_real_heroe>" + rs.getDouble("precio_real") + "</precio_real_heroe>\n";
				PreparedStatement ps2 = con.prepareStatement("SELECT * FROM traje WHERE heroe_id = ?");
				ps2.setString(1, rs.getString("heroe_id"));
				ResultSet rs2 = ps2.executeQuery();
				while (rs2.next()) {
					aux += "\t\t<traje>\n";
					aux += "\t\t\t<nombre_traje>" + rs2.getString("nombre_traje") + "</nombre_traje>\n";
					aux += "\t\t\t<precio_monedas_traje>" + rs2.getInt("precio_monedas") + "</precio_monedas_traje>\n";
					aux += "\t\t\t<precio_real_traje>" + rs2.getDouble("precio_real") + "</precio_real_traje>\n";
					aux += "\t\t\t<imagen_traje>" + rs2.getString("imagen") + "</imagen_traje>\n";
					aux += "\t\t</traje>\n";
				}
				rs2.close();
				ps2.close();

				ps2 = con.prepareStatement("SELECT * FROM talento WHERE heroe_id = ? order by nivel asc");
				ps2.setString(1, rs.getString("heroe_id"));
				rs2 = ps2.executeQuery();
				while (rs2.next()) {
					aux += "\t\t<talento>\n";
					aux += "\t\t\t<nombre_talento>" + rs2.getString("talento_id") + "</nombre_talento>\n";
					aux += "\t\t\t<imagen_talento>" + rs2.getString("imagen") + "</imagen_talento>\n";
					aux += "\t\t\t<descripcion_talento>" + rs2.getString("descripcion") + "</descripcion_talento>\n";
					aux += "\t\t\t<nivel_talento nivel = \"" + rs2.getInt("nivel") + "\"></nivel_talento>\n";
					aux += "\t\t</talento>\n";
				}
				rs2.close();
				ps2.close();

				ps2 = con.prepareStatement("SELECT * FROM rasgo WHERE heroe_id = ?");
				ps2.setString(1, rs.getString("heroe_id"));
				rs2 = ps2.executeQuery();
				while (rs2.next()) {
					aux += "\t\t<rasgo>\n";
					aux += "\t\t\t<nombre_rasgo>" + rs2.getString("rasgo_id") + "</nombre_rasgo>\n";
					aux += "\t\t\t<descripcion_rasgo>" + rs2.getString("descripcion") + "</descripcion_rasgo>\n";
					aux += "\t\t\t<imagen_rasgo>" + rs2.getString("imagen") + "</imagen_rasgo>\n";
					aux += "\t\t</rasgo>\n";
				}
				rs2.close();
				ps2.close();

				ps2 = con.prepareStatement("SELECT * FROM habilidad WHERE heroe_id = ?");
				ps2.setString(1, rs.getString("heroe_id"));
				rs2 = ps2.executeQuery();
				while (rs2.next()) {
					aux += "\t\t<habilidad>\n";
					aux += "\t\t\t<nombre_habilidad>" + rs2.getString("habilidad_id") + "</nombre_habilidad>\n";
					aux += "\t\t\t<imagen_habilidad>" + rs2.getString("imagen") + "</imagen_habilidad>\n";
					aux += "\t\t\t<descripcion_habilidad>" + rs2.getString("descripcion")
							+ "</descripcion_habilidad>\n";
					aux += "\t\t\t<tecla_habilidad tecla = \"" + rs2.getString("tecla") + "\"></tecla_habilidad>\n";
					aux += "\t\t</habilidad>\n";
				}
				rs2.close();
				ps2.close();

				ps2 = con.prepareStatement("SELECT * FROM extra WHERE heroe_id = ?");
				ps2.setString(1, rs.getString("heroe_id"));
				rs2 = ps2.executeQuery();
				while (rs2.next()) {
					aux += "\t\t<extra>\n";
					aux += "\t\t\t<trailer_extra>" + rs2.getString("trailer") + "</trailer_extra>\n";
					aux += "\t\t\t<presentacion_extra>" + rs2.getString("presentacion") + "</presentacion_extra>\n";
					aux += "\t\t</extra>\n";
				}
				rs2.close();
				ps2.close();

				ps2 = con.prepareStatement("SELECT * FROM estadisticasgenerales WHERE heroe_id = ?");
				ps2.setString(1, rs.getString("heroe_id"));
				rs2 = ps2.executeQuery();
				while (rs2.next()) {
					aux += "\t\t<estadisticasGenerales>\n";
					aux += "\t\t\t<daño>" + rs2.getInt("daño") + "</daño>\n";
					aux += "\t\t\t<utilidad>" + rs2.getInt("utilidad") + "</utilidad>\n";
					aux += "\t\t\t<supervivencia>" + rs2.getInt("supervivencia") + "</supervivencia>\n";
					aux += "\t\t\t<complejidad>" + rs2.getInt("complejidad") + "</complejidad>\n";
					aux += "\t\t</estadisticasGenerales>\n";
				}
				rs2.close();
				ps2.close();

				ps2 = con.prepareStatement("SELECT * FROM estadisticasespecificas WHERE heroe_id = ?");
				ps2.setString(1, rs.getString("heroe_id"));
				rs2 = ps2.executeQuery();
				while (rs2.next()) {
					aux += "\t\t<estadisticasEspecificas>\n";
					aux += "\t\t\t<puntos_vida>" + rs2.getDouble("puntos_vida") + "</puntos_vida>\n";
					aux += "\t\t\t<regeneracion_vida>" + rs2.getDouble("regeneracion_vida") + "</regeneracion_vida>\n";
					aux += "\t\t\t<vida_nivel>" + rs2.getDouble("vida_nivel") + "</vida_nivel>\n";
					aux += "\t\t\t<puntos_mana>" + rs2.getDouble("puntos_mana") + "</puntos_mana>\n";
					aux += "\t\t\t<regeneracion_mana>" + rs2.getDouble("regeneracion_mana") + "</regeneracion_mana>\n";
					aux += "\t\t\t<mana_nivel>" + rs2.getDouble("mana_nivel") + "</mana_nivel>\n";
					aux += "\t\t\t<daño_nivel>" + rs2.getDouble("daño_nivel") + "</daño_nivel>\n";
					aux += "\t\t\t<velocidad_ataque>" + rs2.getDouble("velocidad_ataque") + "</velocidad_ataque>\n";
					aux += "\t\t\t<velocidad_movimiento>" + rs2.getDouble("velocidad_movimiento")
							+ "</velocidad_movimiento>\n";
					aux += "\t\t</estadisticasEspecificas>\n";
				}
				/*rs2.close();
				ps2.close();*/
				aux += "\t</heroe>\n";
			}
			aux += "</heroes>\n";
			grabarReserva(aux);
			System.out.println("adasd");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(rs, ps, con);
		}
	}

	public static void grabarReserva(String aux) {
		try {
			BufferedWriter fichero = new BufferedWriter(new FileWriter("files/heroes.xml"));
			String[] linea = aux.split("\n");
			for (int i = 0; i < linea.length; i++)
				fichero.write(linea[i] + "\r\n");
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	
	}

	private static void crearXMLMonturas() {
		String aux = "";
		try {
			con = Jdbc.getConnection();
			ps = con.prepareStatement("SELECT * FROM MONTURA");
			rs = ps.executeQuery();
			aux += "<monturas>\n";
			while (rs.next()) {
				aux += "\t<montura>\n";
				aux += "\t\t<nombre_montura>" + rs.getString("nombre_montura") + "</nombre_montura>\n";
				aux += "\t\t<descripcion_montura>" + rs.getString("descripcion") + "</descripcion_montura>\n";
				aux += "\t\t<tipo_montura tipo = \"" + rs.getString("tipo") + "\"></tipo_montura>\n";
				aux += "\t\t<precio_moneda_montura>" + rs.getInt("precio_monedas") + "</precio_moneda_montura>\n";
				aux += "\t\t<precio_real_montura>" + rs.getDouble("precio_real") + "</precio_real_montura>\n";
				aux += "\t\t<nota>" + rs.getString("nota") + "</nota>\n";
				PreparedStatement ps2 = con.prepareStatement("SELECT * FROM MONTURACOLORES WHERE nombre_montura = ?");
				ps2.setString(1, rs.getString("nombre_montura"));
				ResultSet rs2 = ps2.executeQuery();
				while (rs2.next()) {
					aux += "\t\t<monturaColores>\n";
					aux += "\t\t\t<nombre_colores>" + rs2.getString("nombre_colores") + "</nombre_colores>\n";
					aux += "\t\t\t<imagen_colores>" + rs2.getString("imagen") + "</imagen_colores>\n";
					aux += "\t\t</monturaColores>\n";
				}
				rs2.close();
				ps2.close();
				aux += "\t</montura>\n";
			}
			aux += "</monturas>\n";
			System.out.println(aux);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(rs, ps, con);
		}
	}

	private static void crearXMLMapas() {
		String aux = "";
		try {
			con = Jdbc.getConnection();
			ps = con.prepareStatement("SELECT * FROM MAPA");
			rs = ps.executeQuery();
			aux += "<mapas>\n";
			while (rs.next()) {
				aux += "\t<mapa>\n";
				aux += "\t\t<nombre_mapa>" + rs.getString("nombre") + "</nombre_mapa>\n";
				aux += "\t\t<descripcion_mapa>" + rs.getString("descripcion") + "</descripcion_mapa>\n";
				aux += "\t\t<imagen_mapa>" + rs.getString("imagen") + "</imagen_mapa>\n";
				aux += "\t\t<video_mapa>" + rs.getString("video") + "</video_mapa>\n";

				PreparedStatement ps2 = con.prepareStatement("SELECT * FROM CARACTERISTiCA WHERE MAPA_NOMBRE = ?");
				ps2.setString(1, rs.getString("nombre"));
				ResultSet rs2 = ps2.executeQuery();
				while (rs2.next()) {
					aux += "\t\t<caracteristica_mapa>\n";
					aux += "\t\t\t<nombre_caracteristica>" + rs2.getString("nombre") + "</nombre_caracteristica>\n";
					aux += "\t\t\t<descripcion_caracteristica>" + rs2.getString("descripcion")
							+ "</descripcion_caracteristica>\n";
					aux += "\t\t\t<imagen_caracteristica>" + rs2.getString("imagen") + "</imagen_caracteristica>\n";
					aux += "\t\t</caracteristica_mapa>\n";
				}
				rs2.close();
				ps2.close();
				aux += "\t</mapa>\n";
			}
			aux += "</mapas>\n";
			System.out.println(aux);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(rs, ps, con);
		}
	}

}
