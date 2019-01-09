package packModelo;

import javax.swing.table.DefaultTableModel;

import org.junit.Test;

import packGestores.GestorRanking;
import packPrincipal.BarBestial;

//MAITANE

public class TestRanking {
	
	@Test
    public void cargarMejoresPartidas() throws Exception {
    	DefaultTableModel tabla = BarBestial.getBarBestial().cargarMejoresPartidas();
	}
    
    @Test
    public void cargarMejoresJugadores() throws Exception {
    	DefaultTableModel tabla = BarBestial.getBarBestial().cargarMejoresJugadores();
	}
    
    @Test
    public void cargarMisMejoresPartidas(String pIdUsuario) throws Exception {
    	String pIdUsuario1 = "1";
    	DefaultTableModel tabla = BarBestial.getBarBestial().cargarMisMejoresPartidas(pIdUsuario1);
	}
    
    @Test
    public void cargarMejoresPartidasDia() throws Exception {
    	DefaultTableModel tabla = BarBestial.getBarBestial().cargarMejoresPartidasDia();
	}
}
