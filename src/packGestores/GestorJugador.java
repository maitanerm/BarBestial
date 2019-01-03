package packGestores;

import org.json.JSONObject;

import packModelo.JugadorReal;
import packModelo.Maquina;

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
}
