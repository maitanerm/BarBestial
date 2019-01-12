package packGestores;

import java.sql.ResultSet;
import java.sql.SQLException;

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
		JSONObject info = jugador.getInfo();
		String jugador = info.getString("nombre");
		
		//comprobar nombre duplicado ^ != "Ninguna"
		
		query = "INSERT INTO Personalizacion (idJ, idPer) VALUES ('" + jugador + "', '" + json.getString("personalizacion") + "')";
		SGBD.getSGBD().execUpdate(query);
		
		//query = "INSERT INTO Carta (idC, puntos, idPer, imagen) VALUES ('', '12', '" + json.getString("personalizacion") + "','" + json.getString("leon") + "')";
		//SGBD.getSGBD().execUpdate(query);
		
	}
	public void borrarPersonalizacion(String s) {
		String query;
		//Borramos la personalizacion
		query = "DELETE * FROM Personalizacion WHERE idPer ='" + s + "'";
		SGBD.getSGBD().execUpdate(query);
		//Borramos las tuplas de PersonalizacionActual que aun esten usando la personalizacion borrada
		query = "DELETE * FROM PersonalizacionActual WHERE idPer ='" + s + "'";
		SGBD.getSGBD().execUpdate(query);
	}
	
}
