package packVista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONObject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

public class VentanaPersonalizacionCrear extends JFrame {

	private JPanel contentPane;

	private JButton btnCrear;
	private JButton btnCancelar;
	
	private JTextField txtLeon;
	private JTextField txtHipopotamo;
	private JTextField txtCocodrilo;
	private JTextField txtSerpiente;
	private JTextField txtJirafa;
	private JTextField txtCebra;
	private JTextField txtFoca;
	private JTextField txtCamaleon;
	private JTextField txtMono;
	private JTextField txtCanguro;
	private JTextField txtLoro;
	private JTextField txtMofeta;
	private JTextField txtNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPersonalizacionCrear frame = new VentanaPersonalizacionCrear();
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
	public VentanaPersonalizacionCrear() {
		
		setTitle("Crear Personalizaci\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCrear.setBounds(126, 221, 110, 30);
		contentPane.add(btnCrear);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCancelar.setBounds(250, 221, 110, 30);
		contentPane.add(btnCancelar);
		
        txtLeon = new JTextField();
        txtLeon.setBounds(10, 11, 86, 20);
        contentPane.add(txtLeon);
        txtLeon.setColumns(10);
        
        txtHipopotamo = new JTextField();
        txtHipopotamo.setBounds(10, 42, 86, 20);
        contentPane.add(txtHipopotamo);
        txtHipopotamo.setColumns(10);

        txtCocodrilo = new JTextField();
        txtCocodrilo.setBounds(10, 73, 86, 20);
        contentPane.add(txtCocodrilo);
        txtCocodrilo.setColumns(10);

        txtSerpiente = new JTextField();
        txtSerpiente.setBounds(10, 104, 86, 20);
        contentPane.add(txtSerpiente);
        txtSerpiente.setColumns(10);

        txtJirafa = new JTextField();
        txtJirafa.setBounds(108, 11, 86, 20);
        contentPane.add(txtJirafa);
        txtJirafa.setColumns(10);

        txtCebra = new JTextField();
        txtCebra.setBounds(108, 42, 86, 20);
        contentPane.add(txtCebra);
        txtCebra.setColumns(10);

        txtFoca = new JTextField();
        txtFoca.setBounds(108, 73, 86, 20);
        contentPane.add(txtFoca);
        txtFoca.setColumns(10);

        txtCamaleon = new JTextField();
        txtCamaleon.setBounds(108, 104, 86, 20);
        contentPane.add(txtCamaleon);
        txtCamaleon.setColumns(10);

        txtMono = new JTextField();
        txtMono.setBounds(204, 11, 86, 20);
        contentPane.add(txtMono);
        txtMono.setColumns(10);

        txtCanguro = new JTextField();
        txtCanguro.setBounds(204, 42, 86, 20);
        contentPane.add(txtCanguro);
        txtCanguro.setColumns(10);

        txtLoro = new JTextField();
        txtLoro.setBounds(204, 73, 86, 20);
        contentPane.add(txtLoro);
        txtLoro.setColumns(10);

        txtMofeta = new JTextField();
        txtMofeta.setBounds(204, 104, 86, 20);
        contentPane.add(txtMofeta);
        txtMofeta.setColumns(10);

        txtNombre = new JTextField();
        txtNombre.setBounds(108, 135, 86, 20);
        contentPane.add(txtNombre);
        txtNombre.setColumns(10);
		
		
		//TODO:Selección de archivo para las rutas de imagen
        
		//JFileChooser fileChooser = new JFileChooser();
		//fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		
		
		
		
	}

	public void addListeners(ActionListener a, ActionListener b) {
		btnCrear.addActionListener(a);
		btnCancelar.addActionListener(b);
	}
	
	public JSONObject getDatosPersonalizacion() {
		JSONObject json = new JSONObject();
		json.put("leon", txtLeon.getText());
		json.put("hipopotamo", txtHipopotamo.getText());
		json.put("cocodrilo", txtCocodrilo.getText());
		json.put("serpiente", txtSerpiente.getText());
		json.put("jirafa", txtJirafa.getText());
		json.put("cebra", txtCebra.getText());
		json.put("foca", txtFoca.getText());
		json.put("camaleon", txtFoca.getText());
		json.put("mono", txtMono.getText());
		json.put("canguro", txtCanguro.getText());
		json.put("loro", txtLoro.getText());
		json.put("mofeta", txtMofeta.getText());
		json.put("personalizacion", txtNombre.getText());
		return json;
	}
	
	public void cerrarVentana(){
		dispose();
	}
}
