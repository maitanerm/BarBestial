package packVista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class VentanaConfiguracion extends JFrame {

	private JPanel contentPane;

	private JButton btnDesactivar;
	private JButton btnSeleccionar;
	private JButton btnCrear;
	private JButton btnBorrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConfiguracion frame = new VentanaConfiguracion();
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
	public VentanaConfiguracion() {
		
		setTitle("Configuraci\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnDesactivar = new JButton("Desactivar");
		btnDesactivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnDesactivar.setBounds(10, 221, 110, 30);
		contentPane.add(btnDesactivar);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSeleccionar.setBounds(130, 221, 110, 30);
		contentPane.add(btnSeleccionar);
		
		btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCrear.setBounds(250, 221, 110, 30);
		contentPane.add(btnCrear);
		
		DefaultListModel listModel = new DefaultListModel();
		listModel.addElement("Configuración de ejemplo 1");
		listModel.addElement("Configuración de ejemplo 2");
		listModel.addElement("Configuración de ejemplo 3");
		
		JList list = new JList(listModel);
		list.setBounds(10, 11, 470, 191);
		contentPane.add(list);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnBorrar.setBounds(370, 221, 110, 30);
		contentPane.add(btnBorrar);
		
	}
	
	public void cerrar(){
		System.exit(0);
	}

}
