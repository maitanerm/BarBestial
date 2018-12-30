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

public class SGBD {

	private static SGBD miGestorBd;

	// DATOS PARA EL ACCESO DE LA BD
	private Statement Instruccion;
	private ResultSet Resultado;
	private String SentenciaSQL;

	private Connection con = null;
	private String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
	private String url = "jdbc:ucanaccess://src/battleship_bd.accdb";

	// CONSTRUCCTORA
	private SGBD() {
	}

	public static SGBD getGestorBD() {
		if (miGestorBd == null) {
			miGestorBd = new SGBD();
		}
		return miGestorBd;
	}

	public Connection abrirConexion() {
		try {
			if (con == null) {
				Class.forName(driver);
				con = DriverManager.getConnection(url);
				JOptionPane.showMessageDialog(null,"Conexión correcta.");
			}
		} catch (SQLException SQLE) {
			JOptionPane.showMessageDialog(null, "ERROR EN LA CONEXION CON BD\nERROR : " + SQLE.getMessage());
		} catch (ClassNotFoundException CNFE) {
			JOptionPane.showMessageDialog(null, "ERROR DRIVER BD JAVA\nERROR : " + CNFE.getMessage());
		}
		return con;
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
		// Devuelve el número de filas afectadas por la operación
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

	

}
