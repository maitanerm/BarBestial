package packGestores;

import packModelo.Bar;
import packModelo.JugadorReal;
import packModelo.Maquina;
import packModelo.Tablero;
import org.json.JSONArray;
import org.json.JSONArray;
public class GestorPartida {
	
	private static JugadorReal jugador;
	private static Maquina ordenador;
	private static GestorPartida gPartida;
	
	private GestorPartida(){
		
	}
	public static GestorPartida getGestorPartida(){
		if(gPartida==null){
			gPartida = new GestorPartida(); 
		}
		return gPartida;
	}

	
	public void guardarPartida(String idp){
		
		JSONArray manoJugador= jugador.crearJsonMano();
		JSONArray mazoJugador= jugador.crearJsonMazo();
		JSONArray manoOrdenador= ordenador.crearJsonMano();
		JSONArray mazoOrdenador= ordenador.crearJsonMazo();
		JSONArray cartasBar= Bar.getMiBar().crearJsonBar();
		JSONArray cartasCola= Tablero.getMiTablero().crearJsonCola();
		
		JSONArray datos = new JSONArray();
		datos.put(mazoJugador);
		datos.put(mazoJugador);
		datos.put(manoOrdenador);
		datos.put(mazoOrdenador);
		datos.put(cartasBar);
		datos.put(cartasCola);
		
		volcarEnBD(datos);
		
		
	}
	
	public void volcarEnBD( JSONArray datosPartida){
		
		
	}

}
