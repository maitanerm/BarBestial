package packPrincipal;

import org.json.JSONObject;

import packControlador.Controlador;

public class BarBestial {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        controlador.iniciarAplicacion();
    }
    
    public JSONObject cargarMejoresPartidas() {
		return null;
	}
    
    public JSONObject cargarMejoresJugadores() {
		return null;
	}

    public JSONObject cargarMisMejoresPartidas() {
		return null;
	}

    public JSONObject cargarMejoresPartidasDia() {
		return null;
	}
}
