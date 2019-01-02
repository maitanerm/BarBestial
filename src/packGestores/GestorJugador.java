package packGestores;

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
		
	}
}
