package packModelo;

import javax.swing.table.DefaultTableModel;

import org.junit.Test;

import packControlador.Controlador;
import packGestores.GestorRanking;
import packPrincipal.BarBestial;

//MAITANE

public class TestRanking {
	
	public static void main(String[] args) throws Exception {
		Controlador controlador = new Controlador();
        controlador.iniciarAplicacion();
    }
	
    public void cargarMejoresPartidas() throws Exception {
    	DefaultTableModel tabla = BarBestial.getBarBestial().cargarMejoresPartidas();
    	System.out.println("**Mejores Partidas**");
    	 
    	 
	}
    
    public void cargarMejoresJugadores() throws Exception {
    	DefaultTableModel tabla = BarBestial.getBarBestial().cargarMejoresJugadores();
	}
    
    public void cargarMisMejoresPartidas(String pIdUsuario) throws Exception {
    	String pIdUsuario1 = "1";
    	DefaultTableModel tabla = BarBestial.getBarBestial().cargarMisMejoresPartidas(pIdUsuario1);
    	
	}
    
    public void cargarMejoresPartidasDia() throws Exception {
    	DefaultTableModel tabla = BarBestial.getBarBestial().cargarMejoresPartidasDia();
	}
}
