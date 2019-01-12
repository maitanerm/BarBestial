package packGestores;

import java.sql.ResultSet;
import java.sql.SQLException;

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
}
