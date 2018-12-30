package packPrincipal;

import javax.swing.table.DefaultTableModel;

import org.json.JSONObject;

import packControlador.Controlador;
import packGestores.GestorRanking;

public class BarBestial {
	
	private static BarBestial mBarBestial;
	
	private BarBestial() {
	}
	
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        controlador.iniciarAplicacion();
    }
    
    public static BarBestial getBarBestial() {
		if (mBarBestial == null)
			mBarBestial = new BarBestial();
		return mBarBestial;
	}	
    
    public DefaultTableModel cargarMejoresPartidas() throws Exception {
    	DefaultTableModel tabla = GestorRanking.getGestorRanking().obtenerMejoresPartidas();
		return tabla;
	}
    
    public DefaultTableModel cargarMejoresJugadores() throws Exception {
    	DefaultTableModel tabla = GestorRanking.getGestorRanking().obtenerMejoresJugadores();
		return tabla;
	}

    public DefaultTableModel cargarMisMejoresPartidas() throws Exception {
    	//---------------------------
    	//Introducir aqui el id del usuario
    	String pIdUsuario = "poner aqui!!!!!!!";
    	DefaultTableModel tabla = GestorRanking.getGestorRanking().obtenerMisMejoresPartidas(pIdUsuario);
		return tabla;
	}

    public DefaultTableModel cargarMejoresPartidasDia() throws Exception {
    	DefaultTableModel tabla = GestorRanking.getGestorRanking().obtenerMejoresPartidasDia();
		return tabla;
	}
}
