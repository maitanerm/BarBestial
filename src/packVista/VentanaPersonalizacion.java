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

public class VentanaPersonalizacion extends JFrame {

	private JPanel contentPane;

	private JButton btnDesactivar;
	private JButton btnSeleccionar;
	private JButton btnCrear;
	private JButton btnBorrar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPersonalizacion frame = new VentanaPersonalizacion();
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
	public VentanaPersonalizacion() {
		
		setTitle("Configuraci\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 339);
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

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCancelar.setBounds(140, 262, 110, 30);
		contentPane.add(btnCancelar);
		
	}

	public void addListeners(ActionListener a, ActionListener b, ActionListener c, ActionListener d, ActionListener e) {
		btnDesactivar.addActionListener(a);
		btnSeleccionar.addActionListener(b);
		btnCrear.addActionListener(c);
		btnBorrar.addActionListener(d);
		btnCancelar.addActionListener(e);
	}
	
	public void cerrarVentana(){
		dispose();
	}
	
}
