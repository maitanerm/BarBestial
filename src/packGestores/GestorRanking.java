package packGestores;

import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import packGestores.SGBD;

public class GestorRanking {

	

	private static GestorRanking mGestorRanking;

	private GestorRanking() {
		// TODO Auto-generated constructor stub
	}

	public static GestorRanking getGestorRanking() {
		if (mGestorRanking == null)
			mGestorRanking = new GestorRanking();
		return mGestorRanking;
	}	
	
	public void guardarPuntuacion(String pNombre, String idP, int puntos) throws Exception {
		SGBD.getSGBD().insertarPuntuacion(pNombre, idP, puntos);
	}
	
	// CONSULTAR RANKING MEJORES PARTIDAS (MAITANE)
	public DefaultTableModel obtenerMejoresPartidas() throws Exception {
		String[] registro = new String[4];
		String[] titulos = { "Id Jugador", "Id Partida", "Puntuacion", "Fecha" };
		DefaultTableModel tabla = new DefaultTableModel(null, titulos);
		String SQL_1 = "SELECT TOP(10) idJ,  idP, puntos, fecha" + 
				"		FROM puntuacion" + 
				"		ORDER BY puntos;";
		ResultSet datos = SGBD.getSGBD().execQuery(SQL_1);
		while (datos.next()) {
			registro[0] = datos.getString("idJ");
			registro[1] = datos.getString("idP");
			registro[2] = datos.getString("puntos");
			registro[3] = datos.getString("fecha");
			tabla.addRow(registro);
		}
		return tabla;
	}

	// CONSULTAR RANKING MEJORES JUGADORES (MAITANE)
	public DefaultTableModel obtenerMejoresJugadores() throws Exception {
		String[] registro = new String[4];
		String[] titulos = { "Id Jugador", "Puntuacion" };
		DefaultTableModel tabla = new DefaultTableModel(null, titulos);
		String SQL_2 = "SELECT TOP(10) idJ, AVG(puntos) AS 'puntos " + 
				"FROM puntuacion ORDER BY puntos;";
		ResultSet datos = SGBD.getSGBD().execQuery(SQL_2);
		while (datos.next()) {
			registro[0] = datos.getString("idJ");
			registro[1] = datos.getString("puntos");
			tabla.addRow(registro);
		}
		return tabla;
	}

	// CONSULTAR RANKING MIS MEJORES PARTIDAS (MAITANE)
	public DefaultTableModel obtenerMisMejoresPartidas(String pIdUsuario) throws Exception {
		String[] registro = new String[4];
		String[] titulos = { "Id Jugador", "Id Partida", "Puntuacion", "Fecha" };
		DefaultTableModel tabla = new DefaultTableModel(null, titulos);
		String SQL_3 = "SELECT TOP(10) idJ,  idP, puntos, fecha" + 
				"		FROM puntuacion" + 
				"		WHERE idJ =" + pIdUsuario + 
				"		ORDER BY puntos;";
		ResultSet datos = SGBD.getSGBD().execQuery(SQL_3);
		while (datos.next()) {
			registro[0] = datos.getString("idJ");
			registro[1] = datos.getString("idP");
			registro[2] = datos.getString("puntos");
			registro[3] = datos.getString("fecha");
			tabla.addRow(registro);
		}
		return tabla;
	}

	// CONSULTAR RANKING MEJORES PARTIDAS DEL DIA (MAITANE)
	public DefaultTableModel obtenerMejoresPartidasDia() throws Exception {
		String[] registro = new String[4];
		String[] titulos = { "Id Jugador", "Id Partida", "Puntuacion", "Fecha" };
		DefaultTableModel tabla = new DefaultTableModel(null, titulos);
		String SQL_4 = "SELECT TOP(10) idJ, idP, puntos, fecha FROM puntuacion " + 
				"WHERE CONVERT (date, fecha) = CONVERT (date, CURRENT_TIMESTAMP) ORDER BY puntos;";
		ResultSet datos = SGBD.getSGBD().execQuery(SQL_4);
		while (datos.next()) {
			registro[0] = datos.getString("idJ");
			registro[1] = datos.getString("idP");
			registro[2] = datos.getString("puntos");
			registro[3] = datos.getString("fecha");
			tabla.addRow(registro);
		}
		return tabla;
	}

	

}
