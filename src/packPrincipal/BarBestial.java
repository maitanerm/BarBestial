package packPrincipal;

import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import packControlador.Controlador;
import packGestores.GestorJugador;
import packGestores.GestorPartida;
import packGestores.GestorRanking;
import packModelo.Jugador;
import packModelo.Partida;

public class BarBestial {
	
	private static BarBestial mBarBestial;
	
	private BarBestial() {
	}
	
    public static void main(String[] args) throws Exception {
        Controlador controlador = new Controlador();
        controlador.iniciarAplicacion();
    }
    
    public static BarBestial getBarBestial() {
		if (mBarBestial == null)
			mBarBestial = new BarBestial();
		return mBarBestial;
	}	
    
    //MAITANE
    public String getIdJugador() {
    	String idJ = Partida.getMiPartida().cogerIdJugador();
    	return idJ;
    }
    //MAITANE
    public DefaultTableModel cargarMejoresPartidas() throws Exception {
    	DefaultTableModel tabla = GestorRanking.getGestorRanking().obtenerMejoresPartidas();
		return tabla;
	}
    //MAITANE
    public DefaultTableModel cargarMejoresJugadores() throws Exception {
    	DefaultTableModel tabla = GestorRanking.getGestorRanking().obtenerMejoresJugadores();
		return tabla;
	}
    //MAITANE
    public DefaultTableModel cargarMisMejoresPartidas(String pIdUsuario) throws Exception {
    	DefaultTableModel tabla = GestorRanking.getGestorRanking().obtenerMisMejoresPartidas(pIdUsuario);
		return tabla;
	}
    //MAITANE
    public DefaultTableModel cargarMejoresPartidasDia() throws Exception {
    	DefaultTableModel tabla = GestorRanking.getGestorRanking().obtenerMejoresPartidasDia();
		return tabla;
	}
    
    //ANDONI
    public void anadirAyuda() {
    	GestorJugador.getGestorJugador().anadirAyuda();
    }
    
    //ANDONI
    public JSONObject usarAyuda() {
    	int numAyudas = GestorJugador.getGestorJugador().getNumAyudas();
    	int cartasOponenteBar = GestorPartida.getGestorPartida().getNumCartasBarOponente();
    	int usadas = GestorPartida.getGestorPartida().getAyudasUsadas();
    	JSONObject info = new JSONObject();
    	info.put("numAyudas", numAyudas);
    	info.put("cartas", cartasOponenteBar);
    	info.put("usadas", usadas);
    	return info;
    }

    
    public JSONArray getCartasBarOponente() {
    	return GestorPartida.getGestorPartida().getCartasBarOponente();
    }
    
    public void insertarEnCola(String pNombreCarta) {
    	GestorPartida.getGestorPartida().insertarEnCola(pNombreCarta);
    	GestorJugador.getGestorJugador().actualizarDatosAyuda();
    	GestorPartida.getGestorPartida().actualizarAyudasUsadas();
    }
    
    public void guardarPartida(String idp){
    	GestorPartida.getGestorPartida().guardarPartida(idp);
    }
    
    public void cargarPartida(String idp) throws JSONException, SQLException{
    	GestorPartida.getGestorPartida().cargarPartida();
    }
	
	//Imanol
	public void desactivarConfiguracion() {
	   GestorJugador.getGestorJugador().desactivarConfiguracion();
	}
	public void seleccionarConfiguracion(String s) {
		GestorJugador.getGestorJugador().seleccionarConfiguracion(s);
	}
	public void crearConfiguracion(String s) {
		GestorJugador.getGestorJugador().crearConfiguracion(s);
	}
	public void borrarConfiguracion(String s) {
		GestorJugador.getGestorJugador().borrarConfiguracion(s);
	}
    
}
