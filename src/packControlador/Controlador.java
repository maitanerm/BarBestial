package packControlador;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.json.JSONException;
import org.json.JSONObject;

import packGestores.GestorPartida;
import packModelo.Jugador;
import packModelo.Partida;
import packModelo.RankingDB;
import packModelo.Tablero;
import packPrincipal.BarBestial;
import packVista.GuardarPartida;
import packVista.IURanking;
import packVista.VentanaAyuda;
import packVista.VentanaInicio;
import packVista.VentanaJuego;
import packVista.VentanaRanking;
import packVista.Error;
import packVista.*;

public class Controlador {
	private static Controlador miControlador;
	
	/* Modelo */
	private Partida partida;
	private Tablero tablero;
	private RankingDB rankingDB;
	private GestorPartida gestorPartida;
	
	/* Vista */
	private VentanaInicio ventanaInicio;
	private VentanaJuego ventanaJuego;
	private VentanaAyuda ventanaAyuda;
	private IURanking ventanaRanking;
	private Error ventanaError;
	private GuardarPartida guardarPartida;
	private CargarPartida cargarPartida;
	
	//Imanol
	private VentanaPersonalizacion ventanaPersonalizacion;
	private VentanaPersonalizacionCrear ventanaPersonalizacionCrear;
	
	public Controlador() throws Exception {
		this.partida = Partida.getMiPartida();
		this.tablero = Tablero.getMiTablero();
		this.rankingDB = RankingDB.getRankingDB();
		
		this.ventanaInicio = new VentanaInicio();
		this.ventanaJuego = new VentanaJuego();
		this.ventanaAyuda = new VentanaAyuda();
		this.ventanaError = new Error();
		 //MAITANE
		this.ventanaRanking = null;

		//david
		this.guardarPartida = new GuardarPartida();
		this.cargarPartida = new CargarPartida();
		
		/* Listeners VentanaInicio */
		this.ventanaInicio.addListeners(new JugarListener(), new AyudaListener(), new RankingListener(), new MostrarVentanaPersonalizacion());

		/* Listeners VentanaJuego */
		this.ventanaJuego.addJugarTurnoListener(new JugarTurnoListener());
		this.ventanaJuego.addElegirCarta1Listener(new ElegirCarta1Listener());
		this.ventanaJuego.addElegirCarta2Listener(new ElegirCarta2Listener());
		this.ventanaJuego.addElegirCarta3Listener(new ElegirCarta3Listener());
		this.ventanaJuego.addElegirCarta4Listener(new ElegirCarta4Listener());
		this.ventanaJuego.addSiguienteListener(new SiguienteListener());
		this.ventanaJuego.addGuardarListener(new GuardarListener());
		this.ventanaJuego.desactivarBotonJugarTurno();
		this.ventanaJuego.desactivarBotonSiguiente();
		this.ventanaJuego.addAyudaListener(new AyudaJuegoListener());
		this.guardarPartida.addGuardarVentanaPartidaListener(new GuardarVentanaPartida());
		this.guardarPartida.addCancelarGuardarPartidaListener(new CancelarGuardarPartida());
		this.cargarPartida.addCancelarCargarPartidaListener(new CancelarCargarPartida());
		this.cargarPartida.addCancelarCargarPartidaListener(new CargarVentanaPartida());
		
		//Imanol
		//TODO: Funciones de Personalizar deshabilitadas mediante comentario para evitar errores
		System.out.println("Funciones de Personalizar deshabilitadas mediante comentario para evitar errores.");
		/*
		ventanaPersonalizacion = new VentanaPersonalizacion();
		ventanaPersonalizacion.addListeners(new ActivarPersonalizacion(), new MostrarVentanaPersonalizacionCrear(), new BorrarPersonalizacion(), new CerrarVentanaPersonalizacion());
		ventanaPersonalizacionCrear = new VentanaPersonalizacionCrear();
		ventanaPersonalizacionCrear.addListeners(new CrearPersonalizacion(), new CerrarVentanaPersonalizacionCrear());
		ventanaJuego.actualizarImagenes(BarBestial.getBarBestial().getPersonalizacionActualDatos());
		*/
		
	}
	
	public static Controlador getMiControlador() throws Exception {
        if (miControlador == null) {
        	miControlador = new Controlador();
        }
        return miControlador;
    }
	
	public void iniciarAplicacion() {
		this.mostrarVentanaInicio();
	}
	
	private void mostrarVentanaInicio() {
		this.ventanaInicio.setVisible(true);
	}
	
	private void mostrarVentanaJuego() {
		this.ventanaJuego.setVisible(true);
	}

	private void mostrarVentanaAyuda(){
	    this.ventanaAyuda.setVisible(true);
    }
	
	private void mostrarVentanaRanking(String pIdUsuario) throws Exception{
		ventanaRanking = new IURanking(pIdUsuario);
        this.ventanaRanking.setVisible(true);
    }
	
	private void mostrarVentanaGuardarPartida(){
		this.guardarPartida.setVisible(true);
	}
	
	private void mostrarVentanaCargarPartida(){
		this.cargarPartida.setVisible(true);
	}
	
	private void setUpObservers() {
		ArrayList<Jugador> jugadores = this.partida.obtenerJugadores();
		for(Jugador jug : jugadores) {
			jug.anadirObservador(ventanaJuego);
			/* Notificacion artificial para el inicio de la partida
			 * los jugadores no eran observados mientras se repartian
			 * las cartas. */
			jug.notificar(jug.obtenerInformacionCartas());
		}
		tablero.addObserver(ventanaJuego);
		partida.addObserver(ventanaJuego);
	}
	
	
	class JugarListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String nombre = ventanaInicio.getTextFieldNombreValue();
			
			if(nombre.length() > 0) {
				//ocultarVentanaInicio();
				mostrarVentanaJuego();
				partida.inicializarPartida(nombre);;
				setUpObservers();
			}			
			else ventanaInicio.showNombreErrorMessage();			
		}
	}
	
	class AyudaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
		    mostrarVentanaAyuda();
		}
	}
	
	class RankingListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String nombre = ventanaInicio.getTextFieldNombreValue();
			if(nombre.length() > 0) {
				//ocultarVentanaInicio();
				try {
					mostrarVentanaRanking(nombre);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}			
			else ventanaInicio.showNombreErrorMessage();			
		}
	}
	
	class ElegirCarta1Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			partida.obtenerJugadorTurnoActual().elegirCartaMano(0);
			ventanaJuego.desactivarBotonesElegir();
			ventanaJuego.desactivarBotonSiguiente();
			ventanaJuego.activarBotonJugarTurno();
		}
	}
	
	class ElegirCarta2Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			partida.obtenerJugadorTurnoActual().elegirCartaMano(1);
			ventanaJuego.desactivarBotonesElegir();
			ventanaJuego.desactivarBotonSiguiente();
			ventanaJuego.activarBotonJugarTurno();
		}
	}
	
	class ElegirCarta3Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			partida.obtenerJugadorTurnoActual().elegirCartaMano(2);
			ventanaJuego.desactivarBotonesElegir();
			ventanaJuego.desactivarBotonSiguiente();
			ventanaJuego.activarBotonJugarTurno();
		}
	}
	
	class ElegirCarta4Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			partida.obtenerJugadorTurnoActual().elegirCartaMano(3);
			ventanaJuego.desactivarBotonesElegir();
			ventanaJuego.desactivarBotonSiguiente();
			ventanaJuego.activarBotonJugarTurno();
		}
	}
	
	class JugarTurnoListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			partida.jugarTurno();				
			
			ventanaJuego.desactivarBotonJugarTurno();
			ventanaJuego.activarBotonSiguiente();
		}
	}
	
	class SiguienteListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			partida.obtenerJugadorTurnoActual().elegirCartaMano(0);
			partida.jugarTurno();
			
			ventanaJuego.activarBotonesElegir();
			ventanaJuego.desactivarBotonJugarTurno();
			ventanaJuego.desactivarBotonSiguiente();
		}
	}
	class GuardarListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			mostrarVentanaGuardarPartida();	
			
		}
		
	}
	class GuardarVentanaPartida implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String idp=guardarPartida.cogerIDPartida();
			BarBestial.getBarBestial().guardarPartida(idp);
			mostrarVentanaGuardarPartida();
			
			
		}
		
	}

class CargarVentanaPartida implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String idp=cargarPartida.cogerIDPartida();
			try {
				BarBestial.getBarBestial().cargarPartida(idp);
			} catch (JSONException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			mostrarVentanaCargarPartida();
		}
		
	}

	
	public class CancelarGuardarPartida implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			guardarPartida.cerrarVentanaPartida();
		}
		
	}
	
	class CancelarCargarPartida implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			cargarPartida.cerrarVentanaPartidaCargar();
			
		}
		
	}
	class CargarPartidaInicio implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			cargarPartida.setVisible(true);
			
		}	
	}

	
	//Controlador para boton ayuda de la VentanaJuego
	class AyudaJuegoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JSONObject info = BarBestial.getBarBestial().usarAyuda();
			int numAyudas = info.getInt("numAyudas");
			int cartasOponente = info.getInt("cartas");
			int ayudasUsadas = info.getInt("usadas");
			if ((numAyudas > 0) && (cartasOponente > 0) && (ayudasUsadas <= 2)) {
				IUElegirCartaAyuda elegir = new IUElegirCartaAyuda();
				elegir.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "No se pueden utilizar ayudas en este momento. Sigue jugando.");
			}
		}
		
	}
	
	
	
	//---------------------------------------------------------------- Imanol / VentanaPersonalizacion >>>> ----------------------------------------------------------------
	
	//TODO: Imanol / VentanaPersonalizacion
	
	//Muestra la ventana
	class MostrarVentanaPersonalizacion implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO: Funciones de Personalizar deshabilitadas mediante comentario para evitar errores
			System.out.println("Funciones de Personalizar deshabilitadas mediante comentario para evitar errores.");
			/*
			ventanaPersonalizacion.setVisible(true);
			try {
				ventanaPersonalizacion.actualizarLista(BarBestial.getBarBestial().getListaPersonalizaciones());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			*/
		}
	}
	
	//Activa la personalizacion seleccionada
	class ActivarPersonalizacion implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = ventanaPersonalizacion.getSeleccionLista();
			//Si la personalizacion seleccionada es "Ninguna", desactiva la personalizacion y usa las imagenes por defecto
			if (s != "Ninguna") {
				BarBestial.getBarBestial().activarPersonalizacion(s);
			}
			else {
				BarBestial.getBarBestial().desactivarPersonalizacion();
			}
		}
	}
	
	//Borra la personalizacion seleccionada
	class BorrarPersonalizacion implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = ventanaPersonalizacion.getSeleccionLista();
			if (s != "Ninguna") {
				BarBestial.getBarBestial().borrarPersonalizacion(s);
			}
		}
	}
	
	//Cierra la ventana
	class CerrarVentanaPersonalizacion implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ventanaPersonalizacion.cerrarVentana();
		}
	}
	
	//---------------------------------------------------------------- >>>> Imanol / VentanaPersonalizacion ----------------------------------------------------------------
	
	
	
	//---------------------------------------------------------------- Imanol / VentanaPersonalizacionCrear >>>> ----------------------------------------------------------------
	
	//TODO: Imanol / VentanaPersonalizacionCrear
	
	//Muestra la ventana
	class MostrarVentanaPersonalizacionCrear implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ventanaPersonalizacionCrear.setVisible(true);
		}
	}
	
	//Crea una nueva personalizacion
	class CrearPersonalizacion implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JSONObject json = ventanaPersonalizacionCrear.getDatosPersonalizacion();
			BarBestial.getBarBestial().crearPersonalizacion(json);
		}
	}
	
	//Cierra la ventana
	class CerrarVentanaPersonalizacionCrear implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ventanaPersonalizacionCrear.cerrarVentana();
		}
	}
	
	//---------------------------------------------------------------- >>>> Imanol / VentanaPersonalizacionCrear ----------------------------------------------------------------
	
	
	
}
