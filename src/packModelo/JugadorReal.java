package packModelo;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class JugadorReal extends Jugador {
	public JugadorReal(String pNombre, EnumColor pColorJugador) {
		super(pNombre, pColorJugador);
	}

	public void elegirCartaMano(int pPos) {
		super.cartaElegidaMano = super.obtenerCartaManoEnPosicion(pPos);
	}

	public void elegirSaltosCanguro() {
		this.notificar("saltos- ");
	}

	public void elegirEspecieCola() {
		Tablero tablero = Tablero.getMiTablero();
		String especies = tablero.obtenerEspeciesDeAnimalesEnLaCola();
		this.notificar("especiecola-" + especies);
	}

	public String obtenerInformacionCartasMano() {
		return "jugadorreal-" + this.mano.obtenerInformacionCartas();
	}

	public void actualizarEspecieElegida(String pEspecie) {
		this.especieElegidaCola = pEspecie;
	}

	public void actualizarSaltosCanguro(int pSaltos) {
		this.saltosElegidos = pSaltos;
	}

	/*public JSONArray crearJsonMano() {
		int i = super.obtenerNumeroDeCartasEnMano();
		JSONArray list = new JSONArray();
		ArrayList<Carta> cartas = mano.getListaCartas();
		for (int j = 0; j < i; j++) {
			JSONObject obj = new JSONObject();
			obj.put("Animal", cartas.get(j).getFuerza());
			obj.put("color", cartas.get(j).getColor());
			list.put(obj);
		}
		return list;
	}

	public JSONArray crearJsonMazo() {
		int i = super.obtenerNumeroDeCartasEnMano();
		JSONArray list = new JSONArray();
		ArrayList<Carta> cartas = mazo.getListaCartas();
		for (int j = 0; j < i; j++) {
			JSONObject obj = new JSONObject();
			obj.put("Animal", cartas.get(j).getFuerza());
			obj.put("color", cartas.get(j).getColor());
			list.put(obj);
		}
		return list;
	}*/
	//cambiado
		public ListaCartas devolverMano() {
			return mano;
		}
		
		public ListaCartas devolverMazo() {
			return mazo;
		}

	public void sumarAyuda() {
		numAyuda++;
	}
	
	// Devuelve un JSON con el nombre y las ayudas para actualizar en BD
	public JSONObject getInfo() {
		JSONObject info = new JSONObject();
		info.put("nombre", idJ);
		info.put("numAyudas", numAyuda);	
		return info;
	}
	
	public int getNumAyudas() {
		return numAyuda;
	}
	
	public String getNombre(){
		return super.getNombre();
	}
}