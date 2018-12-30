package packVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import packPrincipal.BarBestial;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class IURanking extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public String column[]={"Id Jugador","Id Partida","Puntuacion","Fecha-Hora"}; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IURanking frame = new IURanking();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IURanking() {
		setTitle("Visualizaci\u00F3n del ranking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.WEST);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.EAST);
		
		
		JButton btnMejoresPartidas = new JButton("Mejores partidas ");
		btnMejoresPartidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource()==btnMejoresPartidas) {
					setTitle("Mejores partidas");
					try{
						DefaultTableModel datosRanking = null;
						datosRanking = BarBestial.getBarBestial().cargarMejoresPartidas();
						table = new JTable(datosRanking);      
						panel.add(table);
						
					} catch(Exception excep) {
					}
				}
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(btnMejoresPartidas);
		
		
		JButton btnMejoresJugadores = new JButton("Mejores jugadores");
		btnMejoresJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				if (arg1.getSource()==btnMejoresPartidas) {
					setTitle("Mejores jugadores");
					try{
						DefaultTableModel datosRanking = null;
						datosRanking = BarBestial.getBarBestial().cargarMejoresJugadores();
						table = new JTable(datosRanking);      
						panel.add(table);
						
					} catch(Exception excep) {
					}
				}
			}
		});
		panel.add(btnMejoresJugadores);
		
		
		JButton btnMisMejoresPartidas = new JButton("Mis mejores partidas");
		btnMisMejoresPartidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg2) {
				if (arg2.getSource()==btnMisMejoresPartidas) {
					setTitle("Mis mejores partidas");
					try{
						DefaultTableModel datosRanking = null;
						datosRanking = BarBestial.getBarBestial().cargarMisMejoresPartidas();
						table = new JTable(datosRanking);      
						panel.add(table);
						
					} catch(Exception excep) {
					}
				}
			}
		});		
		panel.add(btnMisMejoresPartidas);
		
		
		JButton btnMejoresPartidasDel = new JButton("Mejores partidas del d\u00EDa");
		btnMejoresPartidasDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg3) {
				if (arg3.getSource()==btnMejoresPartidas) {
					setTitle("Mejores partidas del d\\u00EDa");
					try{
						DefaultTableModel datosRanking = null;
						datosRanking = BarBestial.getBarBestial().cargarMejoresPartidasDia();
						table = new JTable(datosRanking);      
						panel.add(table);
						
					} catch(Exception excep) {
					}
				}
			}
		});
		panel.add(btnMejoresPartidasDel);
	
	}

}
