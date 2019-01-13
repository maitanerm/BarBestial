package packVista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONArray;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class VentanaPersonalizacion extends JFrame {
	
	//-------------------------------- Atributos --------------------------------
	
	private JPanel contentPane;
	
	private JButton btnActivar;
	private JButton btnCrear;
	private JButton btnBorrar;
	private JButton btnCancelar;
	
	DefaultListModel<String> listModel;
	private JList<String> list;
	
	//-------------------------------- Metodos --------------------------------
	
	//Main
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
	
	//Constructora
	public VentanaPersonalizacion() {
		
		setTitle("Gestionar Personalizaciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Lista para las personalizaciones del jugador
		listModel = new DefaultListModel<String>();
		listModel.addElement("Ninguna");
		list = new JList<String>(listModel);
		list.setSelectedIndex(0);
		list.setBounds(10, 11, 470, 191);
		contentPane.add(list);
		
		//Boton para activar una personalizacion de la lista
		btnActivar = new JButton("Activar");
		btnActivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnActivar.setBounds(10, 221, 110, 30);
		contentPane.add(btnActivar);
		
		//Boton para crear una nueva personalizacion
		btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCrear.setBounds(130, 221, 110, 30);
		contentPane.add(btnCrear);
		
		//Boton para borrar unaa personalizacion de la lista
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnBorrar.setBounds(250, 221, 110, 30);
		contentPane.add(btnBorrar);
		
		//Boton para cancelar la operacion
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCancelar.setBounds(370, 221, 110, 30);
		contentPane.add(btnCancelar);
		
	}
	
	//Listeners
	public void addListeners(ActionListener a, ActionListener b, ActionListener c, ActionListener d) {
		btnActivar.addActionListener(a);
		btnCrear.addActionListener(b);
		btnBorrar.addActionListener(c);
		btnCancelar.addActionListener(d);
	}
	
	//Actualiza la lista con las personalizaciones del jugador
	public void actualizarLista(JSONArray json) {
		int i;
		for(i = 0; i < json.length(); i = i + 1){
			listModel.addElement(json.getString(i));
		}
	}
	
	//Devuelve el ultimo elemento seleccionado de la lista
	public String getSeleccionLista() {
		return list.getSelectedValue().toString();
	}
	
	//Cierra la ventana
	public void cerrarVentana(){
		dispose();
	}
	
}
