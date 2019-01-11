package packModelo;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

import org.json.JSONObject;
import org.json.JSONArray;


public class Bar {
    private static Bar miBar;
    private ListaCartas lista;

    private Bar() {
        lista = new ListaCartas();
    }

    public static Bar getMiBar() {
        if (miBar == null) {
            miBar = new Bar();
        }
        return miBar;
    }

    public EnumColor calcularGanador() {
        EnumColor colorGanador;
        colorGanador = this.lista.obtenerColorMasNumeroso();
        if (colorGanador != null) {
            return colorGanador;
        } else { /* Empate en numero de cartas */
            colorGanador = this.lista.obtenerColorMenosFuerza();

            if (colorGanador != null) { /* Empate en fuerza de cartas */
                return colorGanador;
            } else {
                return null;
            }
        }
    }

    public int obtenerNumeroDeCartasColor(EnumColor pColor) {
        return this.lista.obtenerNumeroDeCartasColor(pColor);
    }
    public int obtenerNumeroDeCartas(){
    	return this.lista.obtenerNumeroDeCartas();
    }

    public int obtenerFuerzaColor(EnumColor pColor) {
        return this.lista.obtenerFuerzaDeCartasColor(pColor);
    }

    public void vaciar() {
        this.lista.vaciar();
    }

    public void anadirCarta(Carta pCarta) {
        this.lista.anadirCarta(pCarta);
    }
    
    public ListaCartas devolverListaCartasBar() {
    	return lista;
    }
   /* public JSONArray crearJsonBar(){
    	int i= obtenerNumeroDeCartas();
    	JSONArray list= new JSONArray();
    	ArrayList<Carta> cartas= lista.getListaCartas();
    	for(int j=0; j<i;j++){
    		JSONObject obj= new JSONObject();
    		obj.put("Animal", cartas.get(j).getFuerza());
    		obj.put("color", cartas.get(j).getColor());
    		list.put(obj);
    	}
    	return list;
    }*/
    
    public JSONArray getCartasBarOponente() {
    	JSONArray cartas = new JSONArray();
    	for (int i = 0; i < lista.obtenerNumeroDeCartas(); i++) {
    		Carta cartaPos = lista.obtenerCartaEnPosicion(i);
    		if (cartaPos.getColor() == EnumColor.VERDE) {
    			JSONObject pos = new JSONObject();
    			pos.put("carta", cartaPos);
    			cartas.put(pos);
    		}
    	}
    	return cartas;
    }
    
    public void eliminarCarta(Carta pCarta) {
    	lista.sacarCarta(pCarta);
    }
}
