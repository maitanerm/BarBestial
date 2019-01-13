package packGestores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SGBD {

	private static SGBD miSGBD;

	// DATOS PARA EL ACCESO DE LA BD
	private Statement Instruccion;
	private ResultSet Resultado;
	private String SentenciaSQL;

	private Connection con = null;
	private String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
	private String url = "jdbc:ucanaccess://src/barbestial.accdb";

	// CONSTRUCCTORA
	private SGBD() {
	}

	public static SGBD getSGBD() {
		if (miSGBD == null) {
			miSGBD = new SGBD();
		}
		return miSGBD;
	}

	public Connection abrirConexion() {
		try {
			if (con == null) {
				Class.forName(driver);
				con = DriverManager.getConnection(url);
				JOptionPane.showMessageDialog(null,"Conexion correcta.");
			}
		} catch (SQLException SQLE) {
			JOptionPane.showMessageDialog(null, "ERROR EN LA CONEXION CON BD\nERROR : " + SQLE.getMessage());
		} catch (ClassNotFoundException CNFE) {
			JOptionPane.showMessageDialog(null, "ERROR DRIVER BD JAVA\nERROR : " + CNFE.getMessage());
		}
		return con;
	}
	
	// INSERTAR PUNTUACION MAITANE
		
		public void insertarPuntuacion(String idJ, String idP, int puntos) {			
			con = abrirConexion();
			try {
				String p = Integer.toString(puntos);
				PreparedStatement pst = con.prepareStatement(
						"INSERT INTO puntuacion(idJ, puntos, fecha) VALUES (?,?,DATE())");
				pst.setString(1, idJ);
				pst.setString(2, p);
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "LA PUNTUACION SE AGREGO CON EXITO A LA BD");
			} catch (SQLException SQLE) {
				JOptionPane.showMessageDialog(null,
						"ERROR AL INSERTAR LA PUNTUACION DE LA BD \n ERROR : " + SQLE.getMessage());
			}
		}
		//insertar mazos, manos, cola y bar (falta personalizacion e id de jugador)
	//DAVID	
	public void insertarDatosPartida(int numAyudasUsadas, String idp, String idJ, String colorJ, String colorM){
		con=abrirConexion();
		Date fecha= new Date();
		try{
			PreparedStatement pst= con.prepareStatement( 
					"INSERT INTO partida (idJ, idP,fechaHora, ayudas, colorIA, colorJ) VALUES (?, ?, ?, ?)");
			pst.setString(1, idJ);
			pst.setString(2, idp);
			pst.setString(3, new SimpleDateFormat("yyyy-MM-dd / hh:mm").format(fecha));
			pst.setInt(4, numAyudasUsadas);
			pst.setString(5, colorM);
			pst.setString(6, colorJ);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "LA PARTIDA SE GUARDO CORRECTAMENTE");
		}catch(SQLException SQLE){
			JOptionPane.showMessageDialog(null,
					"ERROR AL INSERTAR LA PARTIDA DE LA BD \n ERROR : " + SQLE.getMessage());
		}
		
	}
	
	public JSONArray cogerPartidasJugador(String idj) throws JSONException, SQLException{//falta hacer la llamada desde la ventana de cargarpartida y crear la nueva ventana cargar con los datos de las partidas
		JSONArray json= new JSONArray();
		
		con= abrirConexion();
		ResultSet res= execQuery("SELECT idp FROM partida WHERE idj="+idj);
		while (res.next()){
			JSONObject obj= new JSONObject();
			String nombre=res.getString("idp");
			obj.put("idp", nombre);
			json.put(obj);
		}
		return json;
		
	}
	
	//DAVID	
	public void insertarCartasManoJugador(JSONArray datosPartida, int numAyudasUsadas, String idp) {
		con= abrirConexion();
		Date fecha= new Date();
		if(datosPartida.length()!=0){
		for(int i=0;i<datosPartida.length();i++) {
			try {
				JSONObject obj=(JSONObject) datosPartida.get(i);
				String color=obj.getString("colorJugadorMano");
				int fuerza=obj.getInt("fuerzaJugadorMano");
				PreparedStatement st= con.prepareStatement(
					"INSERT INTO manojugador (idc, idp) VALUES(?,?)");
							
				st.setString(2, idp);
				st.setInt(1, fuerza);
				
				st.executeUpdate();
				//st.setString(2,  );
							
			}catch(SQLException SQLE) {
				JOptionPane.showMessageDialog(null,
					"ERROR AL INSERTAR LA MANO DEL JUGADOR DE LA BD \n ERROR : " + SQLE.getMessage());
			}
		}
		}
	}
	//DAVID				
	public void insertarCartasManoOrdenador(JSONArray datosPartida, int numAyudasUsadas, String idp) {
		con= abrirConexion();
		Date fecha= new Date();
		if(datosPartida.length()!=0){
		for(int i=0;i<datosPartida.length();i++) {
			try {
				JSONObject obj=(JSONObject) datosPartida.get(i);
				String color=obj.getString("colorManoOrdenador");
				int fuerza=obj.getInt("fuerzaManoOrdenador");
				PreparedStatement st= con.prepareStatement(
					"INSERT INTO manoordenador (idc, idp) VALUES(?,?)");
							
				st.setString(2, idp);
				st.setInt(1, fuerza);
				
				st.executeUpdate();
				//st.setString(2,  );
							
			}catch(SQLException SQLE) {
				JOptionPane.showMessageDialog(null,
					"ERROR AL INSERTAR LA MANO DEL ORDENADOR DE LA BD \n ERROR : " + SQLE.getMessage());
			}
		}
		}
	}
	//DAVID				
	public void insertarCartasMazoJugador(JSONArray datosPartida, int numAyudasUsadas, String idp) {
		con= abrirConexion();
		Date fecha= new Date();
		if(datosPartida.length()!=0){
		for(int i=0;i<datosPartida.length();i++) {
		try {
			JSONObject obj=(JSONObject) datosPartida.get(i);
			String color=obj.getString("colorMazoJugador");
			int fuerza=obj.getInt("fuerzaMazoJugador");
			PreparedStatement st= con.prepareStatement(
				"INSERT INTO mazojugador (idc, idp) VALUES(?,?)");
							
			st.setString(2, idp);
			st.setInt(1, fuerza);
			
			st.executeUpdate();
			//st.setString(2,  );
							
			}catch(SQLException SQLE) {
				JOptionPane.showMessageDialog(null,
					"ERROR AL INSERTAR EL MAZO DEL JUGADOR DE LA BD \n ERROR : " + SQLE.getMessage());
					}
			}
		}
		}
	//DAVID	
	public void insertarCartasMazoOrdenador(JSONArray datosPartida, int numAyudasUsadas, String idp) {
		con= abrirConexion();
		Date fecha= new Date();
		if(datosPartida.length()!=0){
		for(int i=0;i<datosPartida.length();i++) {
			try {
				JSONObject obj=(JSONObject) datosPartida.get(i);
				String color=obj.getString("colorMazoOrdenador");
				int fuerza=obj.getInt("fuerzaMazoOrdenador");
				PreparedStatement st= con.prepareStatement(
					"INSERT INTO mazoordenador (idc, idp) VALUES(?,?)");
				
				st.setString(2, idp);
				st.setInt(1, fuerza);
				
				st.executeUpdate();
				//st.setString(2,  );
				
			}catch(SQLException SQLE) {
				JOptionPane.showMessageDialog(null,
					"ERROR AL INSERTAR EL MAZO DEL ORDENADOR DE LA BD \n ERROR : " + SQLE.getMessage());
			}
		}
		}
	}
	//DAVID	
	public void insertarCartasBar(JSONArray datosPartida, int numAyudasUsadas, String idp) {
		con= abrirConexion();
		Date fecha= new Date();
		if(datosPartida.length()!=0){
		for(int i=0;i<datosPartida.length();i++) {
			try {
				JSONObject obj=(JSONObject) datosPartida.get(i);
				String color=obj.getString("colorBar");
				int fuerza=obj.getInt("fuerzaBar");
				PreparedStatement st= con.prepareStatement(
					"INSERT INTO bar (idc, idp, color) VALUES(?,?)");
				
				st.setString(2, idp);
				st.setInt(1, fuerza);
				st.setString(3, color);
				
				st.executeUpdate();
				//st.setString(2,  );
				
			}catch(SQLException SQLE) {
				JOptionPane.showMessageDialog(null,
					"ERROR AL INSERTAR EL BAR DE LA BD \n ERROR : " + SQLE.getMessage());
			}
		}
		}
	}
	//DAVID	
	public void insertarCartasCola(JSONArray datosPartida, int numAyudasUsadas, String idp) {
		con= abrirConexion();
		Date fecha= new Date();
		if(datosPartida.length()!=0){
			
		for(int i=0;i<datosPartida.length();i++) {
			try {
				JSONObject obj=(JSONObject) datosPartida.get(i);
				String color=obj.getString("colorCola");
				int fuerza=obj.getInt("fuerzaCola");
				PreparedStatement st= con.prepareStatement(
					"INSERT INTO cola (idc, idp, color) VALUES(?,?, ?)");
				
				st.setString(2, idp);
				st.setInt(1, fuerza);
				st.setString(3, color);
				
				st.executeUpdate();
				//st.setString(2,  );
				
			}catch(SQLException SQLE) {
				JOptionPane.showMessageDialog(null,
					"ERROR AL INSERTAR LA COLA DE LA BD \n ERROR : " + SQLE.getMessage());
			}
		}
		}
	}
	
	public JSONObject cargarPartida(String idj) throws SQLException{
		JSONObject obj= new JSONObject();
		con= abrirConexion();
		ResultSet res= execQuery("SELECT idP, ayudas FROM partida WHERE idJ="+idj);
		String idp=res.getString("idP");
		String numAyudasUsadas= res.getString("numAyudasUsadas");
		obj.put("idP", idp);
		obj.put("numAyudasUsadas", numAyudasUsadas);
		return obj;
	}
	
	public JSONArray cargarMazoJugador(String idp, String color) throws JSONException, SQLException{
		JSONArray json= new JSONArray();
		
		
		con= abrirConexion();
		ResultSet res= execQuery("SELECT Carta.idc, Carta.puntos, carta.color FROM CARTA INNER JOIN (mazojugador INNER JOIN partida ON mazojugador.idp="+idp+
				") ON carta.idc=mazojugador.idc WHERE carta.color = "+color);
		while (res.next()){
			JSONObject obj= new JSONObject();
			String puntos=res.getString("puntos");
			String nombre=res.getString("idc");
			obj.put("fuerza",puntos);
			obj.put("idc", nombre);
			json.put(obj);
		}
		return json;
		
	}
	
	public JSONArray cargarMazoOrdenador(String idp, String color) throws JSONException, SQLException{
		JSONArray json= new JSONArray();
		
		con= abrirConexion();
		ResultSet res= execQuery("SELECT Carta.idc, Carta.puntos, carta.color FROM CARTA INNER JOIN (mazoordenador INNER JOIN partida ON mazoordenador.idp="+idp+
				") ON carta.idc=mazoordenador.idc WHERE carta.color = "+color);
		while (res.next()){
			JSONObject obj= new JSONObject();
			String puntos=res.getString("puntos");
			String nombre=res.getString("idc");
			obj.put("fuerza",puntos);
			obj.put("idc", nombre);
			json.put(obj);
		}
		
		return json;
	}
	
	public JSONArray cargarManoJugador(String idp, String color) throws JSONException, SQLException{
		JSONArray json= new JSONArray();
		
		con= abrirConexion();
		ResultSet res= execQuery("SELECT Carta.idc, Carta.puntos, carta.color FROM CARTA INNER JOIN (mazojugador INNER JOIN partida ON mazojugador.idp="+idp+
				") ON carta.idc=mazojugador.idc WHERE carta.color = "+color);
		while (res.next()){
			JSONObject obj= new JSONObject();
			String puntos=res.getString("puntos");
			String nombre=res.getString("idc");
			obj.put("fuerza",puntos);
			obj.put("idc", nombre);
			json.put(obj);
		}
		return json;
	}
	
	public JSONArray cargarManoOrdenador(String idp, String color) throws JSONException, SQLException{
		JSONArray json= new JSONArray();
		
		
		con= abrirConexion();
		ResultSet res= execQuery("SELECT Carta.idc, Carta.puntos, carta.color FROM CARTA INNER JOIN (manoordenador INNER JOIN partida ON manoordenador.idp="+idp+
				") ON carta.idc=manoordenador.idc WHERE carta.color = "+color);
		while (res.next()){
			JSONObject obj= new JSONObject();
			String puntos=res.getString("puntos");
			String nombre=res.getString("idc");
			obj.put("fuerza",puntos);
			obj.put("idc", nombre);
			json.put(obj);
		}
		return json;
	}
	
	public JSONArray cargarBar(String idp) throws JSONException, SQLException{
		JSONArray json= new JSONArray();
		con= abrirConexion();
		ResultSet res= execQuery("SELECT Carta.idc, Carta.puntos, carta.color FROM CARTA INNER JOIN (bar INNER JOIN partida ON bar.idp="+idp+
				") ON carta.idc=mazojugador.idc");
		while (res.next()){
			JSONObject obj= new JSONObject();
			String puntos=res.getString("puntos");
			String nombre=res.getString("idc");
			String color=res.getString("color");
			obj.put("fuerza",puntos);
			obj.put("idc", nombre);
			obj.put("color", color);
			json.put(obj);
		}
		return json;
	}
	
	public JSONArray cargarCola(String idp) throws SQLException{
		JSONArray json= new JSONArray();
		
		con= abrirConexion();
		ResultSet res= execQuery("SELECT Carta.idc, Carta.puntos, carta.color FROM CARTA INNER JOIN (cola INNER JOIN partida ON cola.idp="+idp+
				") ON carta.idc=mazojugador.idc");
		while (res.next()){
			JSONObject obj= new JSONObject();
			String puntos=res.getString("puntos");
			String nombre=res.getString("idc");
			obj.put("fuerza",puntos);
			obj.put("idc", nombre);
			json.put(obj);
		}
		return json;
	}
	
	public ResultSet execQuery(String SentenciaSQL) {
		// Ejecuta una sentecia sql que devuelve un resultado (SELECT, etc.)
		// https://docs.oracle.com/javase/7/docs/api/java/sql/Connection.html
		// https://docs.oracle.com/javase/7/docs/api/java/sql/Statement.html
		// https://docs.oracle.com/javase/7/docs/api/java/sql/ResultSet.html
		try {
			con = abrirConexion();
			Statement st=con.createStatement();
			Resultado = st.executeQuery(SentenciaSQL);
			
		} catch (SQLException SQLE) {
			JOptionPane.showMessageDialog(null, "ERROR AL CARGAR LOS DATOS DE LA BD \n ERROR : " + SQLE.getMessage());
		}
		return Resultado;
	}

	public int execUpdate(String SentenciaSQL) {
		// Ejecuta una sentecia sql que NO devuelve un resultado (UPDATE, INSERT, etc.)
		// Devuelve el n�mero de filas afectadas por la operaci�n
		// https://docs.oracle.com/javase/7/docs/api/java/sql/Connection.html
		// https://docs.oracle.com/javase/7/docs/api/java/sql/Statement.html
		// https://docs.oracle.com/javase/7/docs/api/java/sql/ResultSet.html
		int resultado = 0;
		try {
			con = abrirConexion();
			Statement st=con.createStatement();
			resultado = st.executeUpdate(SentenciaSQL);
		} catch (SQLException SQLE) {
			JOptionPane.showMessageDialog(null, "ERROR AL CARGAR LOS DATOS DE LA BD \n ERROR : " + SQLE.getMessage());
		}
		return resultado;
	}

	/*public void UpdateModificar(String SentenciaSQL) {
		this.SentenciaSQL = SentenciaSQL;

		try {
			this.Instruccion.executeUpdate(this.SentenciaSQL);
			JOptionPane.showMessageDialog(null, "LA CANCION SE MODIFICO CON EXITO A LA BD");
		} catch (SQLException SQLE) {
			JOptionPane.showMessageDialog(null,
					"ERROR AL MODIFICAR LA CANCION DE LA BD \n ERROR : " + SQLE.getMessage());
		}
	}

	public void DeleteEliminar(String SentenciaSQL) {
		this.SentenciaSQL = SentenciaSQL;

		try {
			this.Instruccion.executeUpdate(this.SentenciaSQL);
			JOptionPane.showMessageDialog(null, "LA CANCION SE ELIMINO CON EXITO A LA BD");
		} catch (SQLException SQLE) {
			JOptionPane.showMessageDialog(null,
					"ERROR AL ELIMINAR LA CANCION DE LA BD \n ERROR : " + SQLE.getMessage());
		}
	}*/
	
	
	
	//---------------------------------------------------------------- Imanol / Get >>>> ----------------------------------------------------------------
	
	//TODO: Imanol / Get
	
	//Devuelve la lista de personalizaciones del jugador
	public JSONArray getListaPersonalizaciones(String idJ) throws SQLException {
		JSONArray json= new JSONArray();
		con = abrirConexion();
		String query = "SELECT idPer FROM Personalizacion WHERE idJ='" + idJ + "'";
		ResultSet res = execQuery(query);
		while (res.next()){
			json.put(res.getString("idPer"));
		}
		return json;
	}
	
    //Devuelve la personalizacion activa del jugador
	public String getPersonalizacionActual(String idJ) throws SQLException {
		String personalizacion = "";
		con = abrirConexion();
		String query = "SELECT idPer FROM PersonalizacionActual WHERE idJ='" + idJ + "'";
		ResultSet res = execQuery(query);
		while (res.next()){
			personalizacion = res.getString("idPer");
		}
		if (personalizacion == "") {
			personalizacion = "Ninguna";
		}
		return personalizacion;
	}
	
    //Devuelve los datos de la personalizacion activa del jugador
	public JSONObject getPersonalizacionActualDatos(String idPer) throws SQLException {
		JSONObject json = new JSONObject();
		con = abrirConexion();
		String query = "SELECT puntos, imagen, color FROM Carta WHERE idPer='" + idPer + "'";
		ResultSet res = execQuery(query);
		while (res.next()){
			switch (res.getInt("puntos")) {
				case 12:
					json.put("Leon" + res.getString("color"), res.getString("imagen"));
					break;
				case 11:
					json.put("Hipopotamo" + res.getString("color"), res.getString("imagen"));
					break;
				case 10:
					json.put("Cocodrilo" + res.getString("color"), res.getString("imagen"));
					break;
				case 9:
					json.put("Serpiente" + res.getString("color"), res.getString("imagen"));
					break;
				case 8:
					json.put("Jirafa" + res.getString("color"), res.getString("imagen"));
					break;
				case 7:
					json.put("Cebra" + res.getString("color"), res.getString("imagen"));
					break;
				case 6:
					json.put("Foca" + res.getString("color"), res.getString("imagen"));
					break;
				case 5:
					json.put("Camaleon" + res.getString("color"), res.getString("imagen"));
					break;
				case 4:
					json.put("Mono" + res.getString("color"), res.getString("imagen"));
					break;
				case 3:
					json.put("Canguro" + res.getString("color"), res.getString("imagen"));
					break;
				case 2:
					json.put("Loro" + res.getString("color"), res.getString("imagen"));
					break;
				case 1:
					json.put("Mofeta" + res.getString("color"), res.getString("imagen"));
					break;
			}
		}
		return json;
	}
	
	//---------------------------------------------------------------- >>>> Imanol / Get ----------------------------------------------------------------
	
	
	
}
