package packGestores;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		String SQL_1 = "SELECT idJ, idP, puntos, fecha FROM puntuacion ORDER BY puntos DESC LIMIT 10;";
		ResultSet datos = SGBD.getSGBD().execQuery(SQL_1);
		while (datos.next()) {
			registro[0] = datos.getString("idJ");
			registro[1] = datos.getString("idP");
			registro[2] = datos.getString("puntos");
			java.sql.Date f = datos.getDate("fecha");
			registro[3] = new SimpleDateFormat("dd/MM/yyyy").format(f);
			tabla.addRow(registro);
		}
		return tabla;
	}

	// CONSULTAR RANKING MEJORES JUGADORES (MAITANE)
	public DefaultTableModel obtenerMejoresJugadores() throws Exception {
		String[] registro = new String[4];
		String[] titulos = { "Id Jugador", "Media Puntuacion" };
		DefaultTableModel tabla = new DefaultTableModel(null, titulos);
		String SQL_2 = "SELECT idJ, AVG(puntos) AS mediaPuntos FROM puntuacion GROUP BY idJ ORDER BY mediaPuntos DESC LIMIT 10;";
		ResultSet datos = SGBD.getSGBD().execQuery(SQL_2);
		while (datos.next()) {
			registro[0] = datos.getString("idJ");
			registro[1] = datos.getString("mediaPuntos");
			tabla.addRow(registro);
		}
		return tabla;
	}

	// CONSULTAR RANKING MIS MEJORES PARTIDAS (MAITANE)
	public DefaultTableModel obtenerMisMejoresPartidas(String pIdUsuario) throws Exception {
		String[] registro = new String[4];
		String[] titulos = { "Id Jugador", "Id Partida", "Puntuacion", "Fecha" };
		DefaultTableModel tabla = new DefaultTableModel(null, titulos);
		String SQL_3 = "SELECT idJ,  idP, puntos, fecha FROM puntuacion WHERE idJ =" + pIdUsuario + " ORDER BY puntos DESC LIMIT 10;";
		ResultSet datos = SGBD.getSGBD().execQuery(SQL_3);
		while (datos.next()) {
			registro[0] = datos.getString("idJ");
			registro[1] = datos.getString("idP");
			registro[2] = datos.getString("puntos");
			java.sql.Date f = datos.getDate("fecha");
			registro[3] = new SimpleDateFormat("dd/MM/yyyy").format(f);
			tabla.addRow(registro);
		}
		return tabla;
	}

	// CONSULTAR RANKING MEJORES PARTIDAS DEL DIA (MAITANE)
	public DefaultTableModel obtenerMejoresPartidasDia() throws Exception {
		String fechaHoy = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		String[] registro = new String[4];
		String[] titulos = { "Id Jugador", "Id Partida", "Puntuacion", "Fecha" };
		DefaultTableModel tabla = new DefaultTableModel(null, titulos);
		String SQL_4 = "SELECT idJ, idP, puntos, fecha FROM puntuacion WHERE fecha = DATE() ORDER BY puntos DESC LIMIT 10;";
		ResultSet datos = SGBD.getSGBD().execQuery(SQL_4);
		while (datos.next()) {
			registro[0] = datos.getString("idJ");
			registro[1] = datos.getString("idP");
			registro[2] = datos.getString("puntos");
			java.sql.Date f = datos.getDate("fecha");
			registro[3] = new SimpleDateFormat("dd/MM/yyyy").format(f);
			tabla.addRow(registro);
		}
		return tabla;
	}

	

}
