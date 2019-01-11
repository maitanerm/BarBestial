package packGestores;

import java.sql.ResultSet;
import java.sql.SQLException;

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
		return jugador.getNumAyudas();
	}

	//ENERITZ
	public boolean comprobarId(String idJ) {
		boolean res = false;
		if ((idJ).matches("([a-z]|[A-Z]|[0-9]|\\s)+")) { 
			res = true; 
		} 
		String sqlIdJug = "SELECT * FROM jugador WHERE idJ = \" + idJ + \"";
		ResultSet datos = SGBD.getSGBD().execQuery(sqlIdJug);
		return (res & (datos == null));
	}

	public void registrar(JSONObject obj) {
		String idJ = obj.getString("idJ");
		String pass = obj.getString("password");
		String preg = obj.getString("pregunta");
		String res = obj.getString("respuesta");
		String sqlRegistrar = "INSERT INTO jugador (idJ, password, pregunta, respuesta, numAyudas) " 
				+ "VALUES (\" + idJ + \", \" + pass + \", \" + preg + \", \" + res + \", 0)";
		SGBD.getSGBD().execUpdate(sqlRegistrar);
	}

	public boolean comprobarPass(String idJ, String pass) {
		String sqlIdCon = "SELECT * FROM jugador WHERE idJ = \" + idJ + \" AND password = \" + pass + \"";
		ResultSet datos = SGBD.getSGBD().execQuery(sqlIdCon);
		return (datos != null);
	}

	public void inicioSesion(String idJ) { 
		String sqlInicio = "SELECT numAyudas FROM jugador WHERE idJ = \" + idJ + \"";
		ResultSet datos = SGBD.getSGBD().execQuery(sqlInicio);
		try {
			int num = datos.getInt("numAyudas");
			JugadorReal jug = new JugadorReal(idJ, EnumColor.VERDE); //num
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void cambiar(String idJ, String passN) {
		String sqlCambiar = "UPDATE jugador SET password = \" + passN + \" WHERE idJ = \" + idJ + \"";
		SGBD.getSGBD().execUpdate(sqlCambiar);		
	}

	public boolean comprobarDatos(JSONObject obj3) {
		String idJ = obj3.getString("idJ");
		String preg = obj3.getString("pregunta");
		String res = obj3.getString("respuesta");
		String sqlDatos = "SELECT * FROM jugador WHERE idJ = \" + idJ + \" AND pregunta = \" + preg + \" AND respuesta = \" + res + \"";
		ResultSet datos = SGBD.getSGBD().execQuery(sqlDatos);
		return (datos != null);
	}

	public void actualizarDatosAyuda() {
		Jugador miJugador = Partida.getMiPartida().obtenerJugadorTurnoActual();
		miJugador.restarAyuda();
	}
}
