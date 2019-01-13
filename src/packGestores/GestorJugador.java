package packGestores;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONObject;

import packModelo.EnumColor;
import packModelo.Jugador;
import packModelo.JugadorReal;
import packModelo.Maquina;
import packModelo.Partida;

public class GestorJugador {

	private static JugadorReal jugador;
	private static Maquina ordenador;
	private static GestorJugador gJugador;
	
	private GestorJugador(){
		
	}
	
	public static GestorJugador getGestorJugador(){
		if(gJugador==null){
			gJugador = new GestorJugador(); 
		}
		return gJugador;
	}
	
	public void anadirAyuda() {
		jugador.sumarAyuda();
		JSONObject info = jugador.getInfo();
		String nombre = info.getString("nombre");
		int numAyudas = info.getInt("numAyudas");
		String sqlAyudas = "UPDATE jugador SET numAyudas = \" + numAyudas + \" WHERE idJ =\" + nombre + \"";
		SGBD.getSGBD().execUpdate(sqlAyudas);
	}
	
	public int getNumAyudas(){
		Jugador miJ = Partida.getMiPartida().obtenerJugadorTurnoActual();
		return miJ.getNumAyudas();
	}

	public void actualizarDatosAyuda() {
		Jugador miJugador = Partida.getMiPartida().obtenerJugadorTurnoActual();
		miJugador.restarAyuda();
	}
	
	
	
	//---------------------------------------------------------------- Imanol / Get >>>> ----------------------------------------------------------------
	
	//TODO: Imanol / Get
	
	public JSONArray getListaPersonalizaciones() throws SQLException {
		JSONObject info = jugador.getInfo();
		String jugador = info.getString("nombre");
		JSONArray json = SGBD.getSGBD().getListaPersonalizaciones(jugador);
		return json;
	}
	
    public JSONObject getPersonalizacionActualDatos() throws SQLException {
    	JSONObject json = null;
		JSONObject info = jugador.getInfo();
		String jugador = info.getString("nombre");
		String idPer = SGBD.getSGBD().getPersonalizacionActual(jugador);
		if (idPer != "") {
			json = SGBD.getSGBD().getPersonalizacionActualDatos(idPer);
		}
    	return json;
    }
    
    //---------------------------------------------------------------- >>>> Imanol / Get ----------------------------------------------------------------
    
    
    
	//---------------------------------------------------------------- Imanol / Set >>>> ----------------------------------------------------------------
    
	//TODO: Imanol / Set
    
	public void desactivarPersonalizacion() {
		String query;
		JSONObject info = jugador.getInfo();
		String jugador = info.getString("nombre");
		//Borramos la tupla con la personalizacion vieja
		query = "DELETE * FROM PersonalizacionActual WHERE idJ ='" + jugador + "'";
		SGBD.getSGBD().execUpdate(query);
	}
	
	public void seleccionarPersonalizacion(String s) {
		String query;
		JSONObject info = jugador.getInfo();
		String jugador = info.getString("nombre");
		//Borramos la tupla con la personalizacion vieja
		query = "DELETE * FROM PersonalizacionActual WHERE idJ ='" + jugador + "'";
		SGBD.getSGBD().execUpdate(query);
		//Insertamos la tupla con la personalizacion nueva
		query = "INSERT INTO PersonalizacionActual (idJ, idPer) VALUES ('" + jugador + "', '" + s + "')";
		SGBD.getSGBD().execUpdate(query);
	}
	
	public void crearPersonalizacion(JSONObject json) {
		String query;
		int cont;
		JSONObject info = jugador.getInfo();
		String jugador = info.getString("nombre");
		//Comprobamos que el nombre no este vacio
		if (json.getString("personalizacion") != "") {
			//Comprobamos que el nombre no este duplicado
			query = "SELECT COUNT(*) FROM Personalizacion WHERE idPer='" + json.getString("personalizacion") + "'";
			cont = SGBD.getSGBD().execUpdate(query);
			if ((json.getString("personalizacion") != "Ninguna") && (cont == 0)) {
				//Guardamos la personalizacion
				query = "INSERT INTO Personalizacion (idJ, idPer) VALUES ('" + jugador + "', '" + json.getString("personalizacion") + "')";
				SGBD.getSGBD().execUpdate(query);
				//Guardamos las cartas azules
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen, color) VALUES ('" + json.getString("personalizacion") + json.getString("LeonAzul") + "', 12, '" + json.getString("personalizacion") + "','" + json.getString("LeonAzul") + "', 'Azul')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen, color) VALUES ('" + json.getString("personalizacion") + json.getString("HipopotamoAzul") + "', 11, '" + json.getString("personalizacion") + "','" + json.getString("HipopotamoAzul") + "', 'Azul')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen, color) VALUES ('" + json.getString("personalizacion") + json.getString("CocodriloAzul") + "', 10, '" + json.getString("personalizacion") + "','" + json.getString("CocodriloAzul") + "', 'Azul')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen, color) VALUES ('" + json.getString("personalizacion") + json.getString("SerpienteAzul") + "', 9, '" + json.getString("personalizacion") + "','" + json.getString("SerpienteAzul") + "', 'Azul')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen, color) VALUES ('" + json.getString("personalizacion") + json.getString("JirafaAzul") + "', 8, '" + json.getString("personalizacion") + "','" + json.getString("JirafaAzul") + "', 'Azul')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen, color) VALUES ('" + json.getString("personalizacion") + json.getString("CebraAzul") + "', 7, '" + json.getString("personalizacion") + "','" + json.getString("CebraAzul") + "', 'Azul')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen, color) VALUES ('" + json.getString("personalizacion") + json.getString("FocaAzul") + "', 6, '" + json.getString("personalizacion") + "','" + json.getString("FocaAzul") + "', 'Azul')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen, color) VALUES ('" + json.getString("personalizacion") + json.getString("CamaleonAzul") + "', 5, '" + json.getString("personalizacion") + "','" + json.getString("CamaleonAzul") + "', 'Azul')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen, color) VALUES ('" + json.getString("personalizacion") + json.getString("MonoAzul") + "', 4, '" + json.getString("personalizacion") + "','" + json.getString("MonoAzul") + "', 'Azul')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen, color) VALUES ('" + json.getString("personalizacion") + json.getString("CanguroAzul") + "', 3, '" + json.getString("personalizacion") + "','" + json.getString("CanguroAzul") + "', 'Azul')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen, color) VALUES ('" + json.getString("personalizacion") + json.getString("LoroAzul") + "', 2, '" + json.getString("personalizacion") + "','" + json.getString("LoroAzul") + "', 'Azul')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen, color) VALUES ('" + json.getString("personalizacion") + json.getString("MofetaAzul") + "', 1, '" + json.getString("personalizacion") + "','" + json.getString("MofetaAzul") + "', 'Azul')";
				SGBD.getSGBD().execUpdate(query);
				//Guardamos las cartas verdes
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen, color) VALUES ('" + json.getString("personalizacion") + json.getString("LeonVerde") + "', 12, '" + json.getString("personalizacion") + "','" + json.getString("LeonVerde") + "', 'Verde')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen, color) VALUES ('" + json.getString("personalizacion") + json.getString("HipopotamoVerde") + "', 11, '" + json.getString("personalizacion") + "','" + json.getString("HipopotamoVerde") + "', 'Verde')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen, color) VALUES ('" + json.getString("personalizacion") + json.getString("CocodriloVerde") + "', 10, '" + json.getString("personalizacion") + "','" + json.getString("CocodriloVerde") + "', 'Verde')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen, color) VALUES ('" + json.getString("personalizacion") + json.getString("SerpienteVerde") + "', 9, '" + json.getString("personalizacion") + "','" + json.getString("SerpienteVerde") + "', 'Verde')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen, color) VALUES ('" + json.getString("personalizacion") + json.getString("JirafaVerde") + "', 8, '" + json.getString("personalizacion") + "','" + json.getString("JirafaVerde") + "', 'Verde')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen, color) VALUES ('" + json.getString("personalizacion") + json.getString("CebraVerde") + "', 7, '" + json.getString("personalizacion") + "','" + json.getString("CebraVerde") + "', 'Verde')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen, color) VALUES ('" + json.getString("personalizacion") + json.getString("FocaVerde") + "', 6, '" + json.getString("personalizacion") + "','" + json.getString("FocaVerde") + "', 'Verde')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen, color) VALUES ('" + json.getString("personalizacion") + json.getString("CamaleonVerde") + "', 5, '" + json.getString("personalizacion") + "','" + json.getString("CamaleonVerde") + "', 'Verde')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen, color) VALUES ('" + json.getString("personalizacion") + json.getString("MonoVerde") + "', 4, '" + json.getString("personalizacion") + "','" + json.getString("MonoVerde") + "', 'Verde')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen, color) VALUES ('" + json.getString("personalizacion") + json.getString("CanguroVerde") + "', 3, '" + json.getString("personalizacion") + "','" + json.getString("CanguroVerde") + "', 'Verde')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen, color) VALUES ('" + json.getString("personalizacion") + json.getString("LoroVerde") + "', 2, '" + json.getString("personalizacion") + "','" + json.getString("LoroVerde") + "', 'Verde')";
				SGBD.getSGBD().execUpdate(query);
				query = "INSERT INTO Carta (idC, puntos, idPer, imagen, color) VALUES ('" + json.getString("personalizacion") + json.getString("MofetaVerde") + "', 1, '" + json.getString("personalizacion") + "','" + json.getString("MofetaVerde") + "', 'Verde')";
				SGBD.getSGBD().execUpdate(query);
			}
			else {
				JOptionPane.showMessageDialog(null, "ERROR: El nombre de la personalizacion ya está en uso.");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "ERROR: El nombre de la personalizacion no puede estar vacio.");
		}
	}
	
	public void borrarPersonalizacion(String s) {
		String query;
		//Borramos la personalizacion
		query = "DELETE * FROM Personalizacion WHERE idPer ='" + s + "'";
		SGBD.getSGBD().execUpdate(query);
		//Borramos las cartas de la personalizacion
		query = "DELETE * FROM Carta WHERE idPer ='" + s + "'";
		SGBD.getSGBD().execUpdate(query);
		//Borramos las tuplas de PersonalizacionActual que aun esten usando la personalizacion borrada
		query = "DELETE * FROM PersonalizacionActual WHERE idPer ='" + s + "'";
		SGBD.getSGBD().execUpdate(query);
	}
	
	//---------------------------------------------------------------- >>>> Imanol / Set ----------------------------------------------------------------
	
	
	
}
