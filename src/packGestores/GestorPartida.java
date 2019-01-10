package packGestores;

import packModelo.Bar;
import packModelo.JugadorReal;
import packModelo.ListaCartas;
import packModelo.Maquina;
import packModelo.Partida;
import packModelo.Tablero;

import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
public class GestorPartida {
	
	private  JugadorReal jugador;
	private  Maquina ordenador;
	private static GestorPartida gPartida;
	
	private GestorPartida(){
		
	}
	public static GestorPartida getGestorPartida(){
		if(gPartida==null){
			gPartida = new GestorPartida(); 
		}
		return gPartida;
	}

	//DAVID	
	public void guardarPartida(String idp){
		jugador= Partida.getMiPartida().cogerJugador();
		ordenador= Partida.getMiPartida().cogerMaquina();
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
		JSONObject datosPartida= new JSONObject();
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
		String idJ=jugador.getNombre();
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
		
		SGBD.getSGBD().insertarDatosPartida(numAyudasUsadas, idp, idJ);
		SGBD.getSGBD().insertarCartasManoJugador(datosManoJugador, numAyudasUsadas, idp);
		SGBD.getSGBD().insertarCartasManoOrdenador(datosManoOrdenador, numAyudasUsadas, idp);
		SGBD.getSGBD().insertarCartasMazoJugador(datosMazoJugador, numAyudasUsadas, idp);
		SGBD.getSGBD().insertarCartasMazoOrdenador(datosMazoOrdenador, numAyudasUsadas, idp);
		SGBD.getSGBD().insertarCartasBar(datosBar, numAyudasUsadas, idp);
		SGBD.getSGBD().insertarCartasManoJugador(datosCola, numAyudasUsadas, idp);
		
		
		
	}
	public void cargarPartida(String idp) throws JSONException, SQLException{
		ListaCartas manoOrdenador= new ListaCartas();
		ListaCartas manoJugador = new ListaCartas();
		ListaCartas mazoJugador= new ListaCartas();
		ListaCartas mazoOrdenador= new ListaCartas();
		ListaCartas bar= new ListaCartas();
		ListaCartas cola= new ListaCartas();
		String colorJugador= jugador.getColorJugador().toString();
		String colorOrdenador= ordenador.getColorJugador().toString();
		
		JSONArray jsonmazojugador= SGBD.getSGBD().cargarMazoJugador(idp, colorJugador);
		JSONArray jsonmazoordenador=SGBD.getSGBD().cargarMazoOrdenador(idp, colorOrdenador);
		JSONArray jsonmanojugador=SGBD.getSGBD().cargarManoJugador(idp, colorJugador);
		JSONArray jsonmanoordenador=SGBD.getSGBD().cargarManoOrdenador(idp, colorOrdenador);
		JSONArray jsonbar=SGBD.getSGBD().cargarBar(idp);
		JSONArray jsoncola=SGBD.getSGBD().cargarCola(idp);
		
		
		
		
		
	}
	
	//DAVID	
	public int getNumCartasBarOponente() {
		return Partida.getMiPartida().obtenerNumeroDeCartasOponente();
	}
	//DAVID	
	public int getAyudasUsadas() {
		return Partida.getMiPartida().getAyudasUsadas();
	}

}
