package packPrincipal;

import javax.swing.table.DefaultTableModel;

import org.json.JSONObject;

import packControlador.Controlador;
import packGestores.GestorRanking;

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
}
