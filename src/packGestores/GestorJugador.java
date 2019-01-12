package packGestores;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONObject;

import packModelo.EnumColor;
import packModelo.Jugador;
import packModelo.JugadorReal;
import packModelo.Maquina;
import packModelo.Partida;

public class GestorJugador {

	private static JugadorReal jugador;
	private static Maquina ordenador;
	private static GestorJugador gJugador;
	
	private GestorJugador(){
		
	}
	
	public static GestorJugador getGestorJugador(){
		if(gJugador==null){
			gJugador = new GestorJugador(); 
		}
		return gJugador;
	}
	
	public void anadirAyuda() {
		jugador.sumarAyuda();
		JSONObject info = jugador.getInfo();
		String nombre = info.getString("nombre");
		int numAyudas = info.getInt("numAyudas");
		String sqlAyudas = "UPDATE jugador SET numAyudas = \" + numAyudas + \" WHERE idJ =\" + nombre + \"";
		SGBD.getSGBD().execUpdate(sqlAyudas);
	}
	
	public int getNumAyudas(){
		return jugador.getNumAyudas();
	}

	public void actualizarDatosAyuda() {
		Jugador miJugador = Partida.getMiPartida().obtenerJugadorTurnoActual();
		miJugador.restarAyuda();
	}
	
	//Imanol
	public void desactivarPersonalizacion() {
		String query;
		JSONObject info = jugador.getInfo();
		String jugador = info.getString("nombre");
		//Borramos la tupla con la personalizacion vieja
		query = "DELETE * FROM PersonalizacionActual WHERE idJ ='" + jugador + "'";
		SGBD.getSGBD().execUpdate(query);
	}
	public void seleccionarPersonalizacion(String s) {
		String query;
		JSONObject info = jugador.getInfo();
		String jugador = info.getString("nombre");
		//Borramos la tupla con la personalizacion vieja
		query = "DELETE * FROM PersonalizacionActual WHERE idJ ='" + jugador + "'";
		SGBD.getSGBD().execUpdate(query);
		//Insertamos la tupla con la personalizacion nueva
		query = "INSERT INTO PersonalizacionActual (idJ, idPer) VALUES ('" + jugador + "', '" + s + "')";
		SGBD.getSGBD().execUpdate(query);
	}
	public void crearPersonalizacion(JSONObject json) {
		String query;
		int cont;
		JSONObject info = jugador.getInfo();
		String jugador = info.getString("nombre");
		//Comprobamos que el nombre no este vacio
		if (json.getString("personalizacion") != "") {
			//Comprobamos que el nombre no este duplicado
			query = "SELECT COUNT(*) FROM Personalizacion WHERE idPer='" + json.getString("personalizacion") + "'";
			cont = SGBD.getSGBD().execUpdate(query);
			if ((json.getString("personalizacion") != "Ninguna") && (cont == 0)) {
				//Guardamos la personalizacion
				query = "INSERT INTO Personalizacion (idJ, idPer) VALUES ('" + jugador + "', '" + json.getString("personalizacion") + "')";
				SGBD.getSGBD().execUpdate(query);
				//Guardamos las cartas
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen) VALUES ('" + json.getString("personalizacion") +"-12', '12', '" + json.getString("personalizacion") + "','" + json.getString("leon") + "')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen) VALUES ('" + json.getString("personalizacion") +"-11', '11', '" + json.getString("personalizacion") + "','" + json.getString("hipopotamo") + "')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen) VALUES ('" + json.getString("personalizacion") +"-10', '10', '" + json.getString("personalizacion") + "','" + json.getString("cocodrilo") + "')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen) VALUES ('" + json.getString("personalizacion") +"-9', '9', '" + json.getString("personalizacion") + "','" + json.getString("serpiente") + "')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen) VALUES ('" + json.getString("personalizacion") +"-8', '8', '" + json.getString("personalizacion") + "','" + json.getString("jirafa") + "')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen) VALUES ('" + json.getString("personalizacion") +"-7', '7', '" + json.getString("personalizacion") + "','" + json.getString("cebra") + "')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen) VALUES ('" + json.getString("personalizacion") +"-6', '6', '" + json.getString("personalizacion") + "','" + json.getString("foca") + "')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen) VALUES ('" + json.getString("personalizacion") +"-5', '5', '" + json.getString("personalizacion") + "','" + json.getString("camaleon") + "')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen) VALUES ('" + json.getString("personalizacion") +"-4', '4', '" + json.getString("personalizacion") + "','" + json.getString("mono") + "')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen) VALUES ('" + json.getString("personalizacion") +"-3', '3', '" + json.getString("personalizacion") + "','" + json.getString("canguro") + "')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen) VALUES ('" + json.getString("personalizacion") +"-2', '2', '" + json.getString("personalizacion") + "','" + json.getString("loro") + "')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen) VALUES ('" + json.getString("personalizacion") +"-1', '1', '" + json.getString("personalizacion") + "','" + json.getString("mofeta") + "')";
				SGBD.getSGBD().execUpdate(query);
			}
			else {
				JOptionPane.showMessageDialog(null, "ERROR: El nombre de la personalizacion ya está en uso.");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "ERROR: El nombre de la personalizacion no puede estar vacio.");
		}
	}
	public void borrarPersonalizacion(String s) {
		String query;
		//Borramos la personalizacion
		query = "DELETE * FROM Personalizacion WHERE idPer ='" + s + "'";
		SGBD.getSGBD().execUpdate(query);
		//Borramos las cartas de la personalizacion
		query = "DELETE * FROM Carta WHERE idPer ='" + s + "'";
		SGBD.getSGBD().execUpdate(query);
		//Borramos las tuplas de PersonalizacionActual que aun esten usando la personalizacion borrada
		query = "DELETE * FROM PersonalizacionActual WHERE idPer ='" + s + "'";
		SGBD.getSGBD().execUpdate(query);
	}
	
}
