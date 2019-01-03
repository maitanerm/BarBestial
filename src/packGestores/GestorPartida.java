package packGestores;

import packModelo.Bar;
import packModelo.JugadorReal;
import packModelo.ListaCartas;
import packModelo.Maquina;
import packModelo.Partida;
import packModelo.Tablero;
import org.json.JSONArray;
import org.json.JSONObject;
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
		ListaCartas manoJugador= jugador.devolverMano();
		ListaCartas mazoJugador= jugador.devolverMazo();
		ListaCartas manoOrdenador= ordenador.devolverMano();
		ListaCartas mazoOrdenador= ordenador.devolverMazo();
		ListaCartas bar=Bar.getMiBar().devolverListaCartasBar();
		ListaCartas cola= Tablero.getMiTablero().devolverListaCartasCola();
		JSONArray datosManoJugador= new JSONArray();
		JSONArray datosMazoJugador= new JSONArray();
		JSONArray datosMazoOrdenador= new JSONArray();
		JSONArray datosManoOrdenador= new JSONArray();
		JSONArray datosBar= new JSONArray();
		JSONArray datosCola= new JSONArray();
		for (int i=0; i<manoJugador.obtenerNumeroDeCartas();i++) {
			JSONObject obj= new JSONObject();
			obj.put("colorJugadorMano", manoJugador.getListaCartas().get(i));
			obj.put("fuerzaJugadorMano",manoJugador.getListaCartas().get(i));
			datosManoJugador.put(obj);
		}
		for (int i=0; i<mazoJugador.obtenerNumeroDeCartas();i++) {
			JSONObject obj= new JSONObject();
			obj.put("colorJugadorMazo", mazoJugador.getListaCartas().get(i));
			obj.put("fuerzaJugadorMazo",mazoJugador.getListaCartas().get(i));
			datosMazoJugador.put(obj);
		}
		for (int i=0; i<manoOrdenador.obtenerNumeroDeCartas();i++) {
			JSONObject obj= new JSONObject();
			obj.put("colorOrdenadorMano", manoOrdenador.getListaCartas().get(i));
			obj.put("fuerzaOrdenadorMano",manoOrdenador.getListaCartas().get(i));
			datosManoOrdenador.put(obj);
		}
		for (int i=0; i<mazoOrdenador.obtenerNumeroDeCartas();i++) {
			JSONObject obj= new JSONObject();
			obj.put("colorOrdenadorMazo", mazoOrdenador.getListaCartas().get(i));
			obj.put("fuerzaOrdenadorMazo",mazoOrdenador.getListaCartas().get(i));
			datosMazoOrdenador.put(obj);
		}
		for (int i=0; i<bar.obtenerNumeroDeCartas();i++) {
			JSONObject obj= new JSONObject();
			obj.put("colorBar", bar.getListaCartas().get(i));
			obj.put("fuerzaBar",bar.getListaCartas().get(i));
			datosBar.put(obj);
		}
		for (int i=0; i<cola.obtenerNumeroDeCartas();i++) {
			JSONObject obj= new JSONObject();
			obj.put("colorCola", cola.getListaCartas().get(i));
			obj.put("fuerzaCola",cola.getListaCartas().get(i));
			datosCola.put(obj);
		}
		
		int numAyudasUsadas= Partida.getMiPartida().getAyudasUsadas();
		/*
		JSONArray manoJugador= jugador.crearJsonMano();
		JSONArray mazoJugador= jugador.crearJsonMazo();
		JSONArray manoOrdenador= ordenador.crearJsonMano();
		JSONArray mazoOrdenador= ordenador.crearJsonMazo();
		JSONArray cartasBar= Bar.getMiBar().crearJsonBar();
		JSONArray cartasCola= Tablero.getMiTablero().crearJsonCola();
		
		JSONArray datos = new JSONArray();
		int numAyudasUsadas= Partida.getMiPartida().getAyudasUsadas();
		datos.put(mazoJugador);
		datos.put(mazoJugador);
		datos.put(manoOrdenador);
		datos.put(mazoOrdenador);
		datos.put(cartasBar);
		datos.put(cartasCola);*/
		
		SGBD.getSGBD().insertarCartasManoJugador(datosManoJugador, numAyudasUsadas, idp);
		SGBD.getSGBD().insertarCartasManoOrdenador(datosManoOrdenador, numAyudasUsadas, idp);
		SGBD.getSGBD().insertarCartasMazoJugador(datosMazoJugador, numAyudasUsadas, idp);
		SGBD.getSGBD().insertarCartasMazoOrdenador(datosMazoOrdenador, numAyudasUsadas, idp);
		SGBD.getSGBD().insertarCartasBar(datosBar, numAyudasUsadas, idp);
		SGBD.getSGBD().insertarCartasManoJugador(datosCola, numAyudasUsadas, idp);
		
		
		
	}
	
	
	public int getNumCartasBarOponente() {
		return Partida.getMiPartida().obtenerNumeroDeCartasOponente();
	}
	
	public int getAyudasUsadas() {
		return Partida.getMiPartida().getAyudasUsadas();
	}

}
