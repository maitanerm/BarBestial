package packVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import packModelo.Jugador;
import packPrincipal.BarBestial;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class IURanking extends JFrame {

	private JPanel contentPane;
	private JTable table;
	JScrollPane header;
	
	DefaultTableModel datosRanking =null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String pIdUsuario = null;
					IURanking frame = new IURanking(pIdUsuario);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public IURanking(String pIdUsuario) throws Exception {
		setTitle("Mejores partidas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		//Boton mejores partidas
		JButton btnMejoresPartidas = new JButton("Mejores partidas ");
		panel_1.add(btnMejoresPartidas);
		
		//Boton mejores jugadores
		JButton btnMejoresJugadores = new JButton("Mejores jugadores");
		panel_1.add(btnMejoresJugadores);
		
		//Boton mis mejores partidas
		JButton btnMisMejoresPartidas = new JButton("Mis mejores partidas");
		panel_1.add(btnMisMejoresPartidas);
		
		//Boton mejores partidas del dia
		JButton btnMejoresPartidasDia = new JButton("Mejores partidas del d\u00EDa");
		
		panel_1.add(btnMejoresPartidasDia);
		
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argS) {
				if (argS.getSource()==btnSalir) {
					setTitle("Mejores jugadores");
					try{
						setVisible(false);
				        dispose();
						
					} catch(Exception excep) {
					}
				}
				
			}
		});
		panel_1.add(btnSalir);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		//Cargar por defecto
		datosRanking = BarBestial.getBarBestial().cargarMejoresPartidas();
		
		table = new JTable(datosRanking);
		header = new JScrollPane(table);
		panel.add(header, BorderLayout.CENTER);
	
		//Funcionalidades de los botones		
		
		btnMisMejoresPartidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg2) {
				if (arg2.getSource()==btnMisMejoresPartidas) {
					setTitle("Mis mejores partidas");
					try{
						//**********************************************
						//**********************************************
				    	//*****Para realizar la prueba de funcionamiento 
						 //String pIdUsuario ="1";
				    	//**********************************************
				    	//**********************************************
				   
				    	
						System.out.println("El usuario "+pIdUsuario);
						datosRanking = BarBestial.getBarBestial().cargarMisMejoresPartidas(pIdUsuario);
						panel.remove(table);
						panel.remove(header);
						panel.revalidate();
						panel.repaint();
						table = new JTable(datosRanking);
						header = new JScrollPane(table);
						panel.add(header, BorderLayout.CENTER);
						
					} catch(Exception excep) {
					}
				}
			}
		});
		
		btnMejoresJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				if (arg1.getSource()==btnMejoresJugadores) {
					setTitle("Mejores jugadores");
					try{
						datosRanking = BarBestial.getBarBestial().cargarMejoresJugadores();
						panel.remove(table);
						panel.remove(header);
						panel.revalidate();
						panel.repaint();
						table = new JTable(datosRanking);
						header = new JScrollPane(table);
						panel.add(header, BorderLayout.CENTER);
						
					} catch(Exception excep) {
					}
				}
			}
		});
		btnMejoresPartidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource()==btnMejoresPartidas) {
					setTitle("Mejores partidas");
					try{
						datosRanking = BarBestial.getBarBestial().cargarMejoresPartidas();
						panel.remove(table);
						panel.remove(header);
						panel.revalidate();
						panel.repaint();
						table = new JTable(datosRanking);
						header = new JScrollPane(table);
						panel.add(header, BorderLayout.CENTER);
						
					} catch(Exception excep) {
					}
				}
			}
		});
		
		btnMejoresPartidasDia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg5) {
				if (arg5.getSource()==btnMejoresPartidasDia) {
					setTitle("Mejores partidas del dia");
					try{
						datosRanking = BarBestial.getBarBestial().cargarMejoresPartidasDia();
						panel.remove(table);
						panel.remove(header);
						panel.revalidate();
						panel.repaint();
						table = new JTable(datosRanking);
						header = new JScrollPane(table);
						panel.add(header, BorderLayout.CENTER);
						
					} catch(Exception excep) {
					}
				}
			}
		});
		
		
	}
	

}
