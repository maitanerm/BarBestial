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
		String[] titulos = { "Id Jugador", "Id Partida", "Puntuacion", "Fecha-Hora" };
		DefaultTableModel tabla = new DefaultTableModel(null, titulos);
		String SQL_1 = "SELECT TOP(10) idJ, idP, puntuacion, fechaHora\r\n" + 
				"FROM Partida ORDER BY puntuacion;";
		ResultSet datos = SGBD.getSGBD().execQuery(SQL_1);
		while (datos.next()) {
			registro[0] = datos.getString("idJ");
			registro[1] = datos.getString("idP");
			registro[2] = datos.getString("puntuacion");
			registro[3] = datos.getString("fechaHora");
			tabla.addRow(registro);
		}
		return tabla;
	}

	// CONSULTAR RANKING MEJORES JUGADORES (MAITANE)
	public DefaultTableModel obtenerMejoresJugadores() throws Exception {
		String[] registro = new String[4];
		String[] titulos = { "Id Jugador", "Id Partida", "Puntuacion", "Fecha-Hora" };
		DefaultTableModel tabla = new DefaultTableModel(null, titulos);
		String SQL_2 = "SELECT TOP(10) idJ, AVG(puntuacion) AS 'puntuacion " + 
				"FROM Partida ORDER BY puntuacion;";
		ResultSet datos = SGBD.getSGBD().execQuery(SQL_2);
		while (datos.next()) {
			registro[0] = datos.getString("idJ");
			registro[1] = datos.getString("idP");
			registro[2] = datos.getString("puntuacion");
			registro[3] = datos.getString("fechaHora");
			tabla.addRow(registro);
		}
		return tabla;
	}

	// CONSULTAR RANKING MIS MEJORES PARTIDAS (MAITANE)
	public DefaultTableModel obtenerMisMejoresPartidas(String pIdUsuario) throws Exception {
		String[] registro = new String[4];
		String[] titulos = { "Id Jugador", "Id Partida", "Puntuacion", "Fecha-Hora" };
		DefaultTableModel tabla = new DefaultTableModel(null, titulos);
		String SQL_3 = "SELECT TOP(10) idJ, idP, puntuacion, fechaHora " + 
				"FROM Partida WHERE idJ =" + pIdUsuario + " ORDER BY puntuacion;";
		ResultSet datos = SGBD.getSGBD().execQuery(SQL_3);
		while (datos.next()) {
			registro[0] = datos.getString("idJ");
			registro[1] = datos.getString("idP");
			registro[2] = datos.getString("puntuacion");
			registro[3] = datos.getString("fechaHora");
			tabla.addRow(registro);
		}
		return tabla;
	}

	// CONSULTAR RANKING MEJORES PARTIDAS DEL DIA (MAITANE)
	public DefaultTableModel obtenerMejoresPartidasDia() throws Exception {
		String[] registro = new String[4];
		String[] titulos = { "Id Jugador", "Id Partida", "Puntuacion", "Fecha-Hora" };
		DefaultTableModel tabla = new DefaultTableModel(null, titulos);
		String SQL_4 = "SELECT TOP(10) idJ, idP, puntuacion, fechaHora FROM Partida " + 
				"WHERE CONVERT (date, fechaHora) = CONVERT (date, CURRENT_TIMESTAMP) ORDER BY puntuacion;";
		ResultSet datos = SGBD.getSGBD().execQuery(SQL_4);
		while (datos.next()) {
			registro[0] = datos.getString("idJ");
			registro[1] = datos.getString("idP");
			registro[2] = datos.getString("puntuacion");
			registro[3] = datos.getString("fechaHora");
			tabla.addRow(registro);
		}
		return tabla;
	}

	

}
