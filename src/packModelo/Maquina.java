package packModelo;

import java.util.ArrayList;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;


public class Maquina extends Jugador {
    public Maquina(String pNombre, EnumColor colorJugador) {
        super(pNombre, colorJugador);
    }

    public void elegirCartaMano(int pPos) {
        super.cartaElegidaMano = super.mano.obtenerCartaAleatoria();
    }

    public void elegirEspecieCola() {
        Tablero tablero = Tablero.getMiTablero();
        this.especieElegidaCola = tablero.obtenerCartaAleatoria().getEspecie();
    }

    public void elegirSaltosCanguro() {
        int max = 2;
        int min = 1;
        this.saltosElegidos = new Random().nextInt(max - min) + min;
    }

    public String obtenerInformacionCartasMano() {
        return "maquina-" + this.mano.obtenerNumeroDeCartas();
    }
    
  //cambiado
  	public ListaCartas devolverMano() {
  		return mano;
  	}
  	
  	public ListaCartas devolverMazo() {
  		return mazo;
  	}
    
   /* public JSONArray crearJsonMano(){
    	int i= super.obtenerNumeroDeCartasEnMano();
    	JSONArray list= new JSONArray();
    	ArrayList<Carta> cartas= mano.getListaCartas();
    	for(int j=0; j<i;j++){
    		JSONObject obj= new JSONObject();
    		obj.put("Animal", cartas.get(j).getFuerza());
    		obj.put("color", cartas.get(j).getColor());
    		list.put(obj);
    	}
    	return list;	
    }
    
    public JSONArray crearJsonMazo(){
    	int i= super.obtenerNumeroDeCartasEnMazo();
    	JSONArray list= new JSONArray();
    	ArrayList<Carta> cartas= mazo.getListaCartas();
    	for(int j=0; j<i;j++){
    		JSONObject obj= new JSONObject();
    		obj.put("Animal", cartas.get(j).getFuerza());
    		obj.put("color", cartas.get(j).getColor());
    		list.put(obj);
    	}
    	return list;
    }*/
}