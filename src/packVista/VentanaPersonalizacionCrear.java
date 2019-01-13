package packVista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONObject;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class VentanaPersonalizacionCrear extends JFrame {
	
	//-------------------------------- Atributos --------------------------------
	
	private JPanel contentPane;
	
	//Azul
	private JTextField txtLeonAzul;
	private JTextField txtHipopotamoAzul;
	private JTextField txtCocodriloAzul;
	private JTextField txtSerpienteAzul;
	private JTextField txtJirafaAzul;
	private JTextField txtCebraAzul;
	private JTextField txtFocaAzul;
	private JTextField txtCamaleonAzul;
	private JTextField txtMonoAzul;
	private JTextField txtCanguroAzul;
	private JTextField txtLoroAzul;
	private JTextField txtMofetaAzul;
	
	//Verde
	private JTextField txtLeonVerde;
	private JTextField txtHipopotamoVerde;
	private JTextField txtCocodriloVerde;
	private JTextField txtSerpienteVerde;
	private JTextField txtJirafaVerde;
	private JTextField txtCebraVerde;
	private JTextField txtFocaVerde;
	private JTextField txtCamaleonVerde;
	private JTextField txtMonoVerde;
	private JTextField txtCanguroVerde;
	private JTextField txtLoroVerde;
	private JTextField txtMofetaVerde;
	
	//Otros
	private JTextField txtNombre;
	private JButton btnCrear;
	private JButton btnCancelar;
	
	//-------------------------------- Metodos --------------------------------
	
	//Main
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
	
	//Constructora
	public VentanaPersonalizacionCrear() {
		
		setTitle("Crear Personalizaci\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl;
		
		//---------------------------------------------------------------- Azul ----------------------------------------------------------------
		
		//Campo de texto para la imagen de leon azul
		lbl = new JLabel("Leon azul:");
		lbl.setBounds(10, 14, 100, 14);
		contentPane.add(lbl);
		txtLeonAzul = new JTextField();
		txtLeonAzul.setBounds(116, 11, 100, 20);
		contentPane.add(txtLeonAzul);
		txtLeonAzul.setColumns(10);
		
		//Campo de texto para la imagen de hipopotamo azul
		lbl = new JLabel("Hipopotamo azul:");
		lbl.setBounds(10, 45, 100, 14);
		contentPane.add(lbl);
		txtHipopotamoAzul = new JTextField();
		txtHipopotamoAzul.setBounds(116, 42, 100, 20);
		contentPane.add(txtHipopotamoAzul);
		txtHipopotamoAzul.setColumns(10);
		
		//Campo de texto para la imagen de cocodrilo azul
		lbl = new JLabel("Cocodrilo azul:");
		lbl.setBounds(10, 76, 100, 14);
		contentPane.add(lbl);
		txtCocodriloAzul = new JTextField();
		txtCocodriloAzul.setBounds(116, 73, 100, 20);
		contentPane.add(txtCocodriloAzul);
		txtCocodriloAzul.setColumns(10);
		
		//Campo de texto para la imagen de serpiente azul
		lbl = new JLabel("Serpiente azul:");
		lbl.setBounds(10, 107, 100, 14);
		contentPane.add(lbl);
		txtSerpienteAzul = new JTextField();
		txtSerpienteAzul.setBounds(116, 104, 100, 20);
		contentPane.add(txtSerpienteAzul);
		txtSerpienteAzul.setColumns(10);
		
		//Campo de texto para la imagen de jirafa azul
		lbl = new JLabel("Jirafa azul:");
		lbl.setBounds(10, 138, 100, 14);
		contentPane.add(lbl);
		txtJirafaAzul = new JTextField();
		txtJirafaAzul.setBounds(116, 135, 100, 20);
		contentPane.add(txtJirafaAzul);
		txtJirafaAzul.setColumns(10);
		
		//Campo de texto para la imagen de cebra azul
		lbl = new JLabel("Cebra azul:");
		lbl.setBounds(10, 169, 100, 14);
		contentPane.add(lbl);
		txtCebraAzul = new JTextField();
		txtCebraAzul.setBounds(116, 166, 100, 20);
		contentPane.add(txtCebraAzul);
		txtCebraAzul.setColumns(10);
		
		//Campo de texto para la imagen de foca azul
		lbl = new JLabel("Foca azul:");
		lbl.setBounds(10, 200, 100, 14);
		contentPane.add(lbl);
		txtFocaAzul = new JTextField();
		txtFocaAzul.setBounds(116, 197, 100, 20);
		contentPane.add(txtFocaAzul);
		txtFocaAzul.setColumns(10);
		
		//Campo de texto para la imagen de camaleon azul
		lbl = new JLabel("Camaleon azul:");
		lbl.setBounds(10, 231, 100, 14);
		contentPane.add(lbl);
		txtCamaleonAzul = new JTextField();
		txtCamaleonAzul.setBounds(116, 228, 100, 20);
		contentPane.add(txtCamaleonAzul);
		txtCamaleonAzul.setColumns(10);
		
		//Campo de texto para la imagen de mono azul
		lbl = new JLabel("Mono azul:");
		lbl.setBounds(10, 262, 100, 14);
		contentPane.add(lbl);
		txtMonoAzul = new JTextField();
		txtMonoAzul.setBounds(116, 259, 100, 20);
		contentPane.add(txtMonoAzul);
		txtMonoAzul.setColumns(10);
		
		//Campo de texto para la imagen de canguro azul
		lbl = new JLabel("Canguro azul:");
		lbl.setBounds(10, 293, 100, 14);
		contentPane.add(lbl);
		txtCanguroAzul = new JTextField();
		txtCanguroAzul.setBounds(116, 290, 100, 20);
		contentPane.add(txtCanguroAzul);
		txtCanguroAzul.setColumns(10);
		
		//Campo de texto para la imagen de loro azul
		lbl = new JLabel("Loro azul:");
		lbl.setBounds(10, 324, 100, 14);
		contentPane.add(lbl);
		txtLoroAzul = new JTextField();
		txtLoroAzul.setBounds(116, 321, 100, 20);
		contentPane.add(txtLoroAzul);
		txtLoroAzul.setColumns(10);
		
		//Campo de texto para la imagen de mofeta azul
		lbl = new JLabel("Mofeta azul:");
		lbl.setBounds(10, 355, 100, 14);
		contentPane.add(lbl);
		txtMofetaAzul = new JTextField();
		txtMofetaAzul.setBounds(116, 352, 100, 20);
		contentPane.add(txtMofetaAzul);
		txtMofetaAzul.setColumns(10);
		
		//---------------------------------------------------------------- Verde ----------------------------------------------------------------
		
		//Campo de texto para la imagen de leon verde
		lbl = new JLabel("Leon verde:");
		lbl.setBounds(226, 14, 100, 14);
		contentPane.add(lbl);
		txtLeonVerde = new JTextField();
		txtLeonVerde.setBounds(336, 11, 100, 20);
		contentPane.add(txtLeonVerde);
		txtLeonVerde.setColumns(10);
		
		//Campo de texto para la imagen de hipopotamo verde
		lbl = new JLabel("Hipopotamo verde:");
		lbl.setBounds(226, 45, 100, 14);
		contentPane.add(lbl);
		txtHipopotamoVerde = new JTextField();
		txtHipopotamoVerde.setBounds(336, 42, 100, 20);
		contentPane.add(txtHipopotamoVerde);
		txtHipopotamoVerde.setColumns(10);
		
		//Campo de texto para la imagen de cocodrilo verde
		lbl = new JLabel("Cocodrilo verde:");
		lbl.setBounds(226, 76, 100, 14);
		contentPane.add(lbl);
		txtCocodriloVerde = new JTextField();
		txtCocodriloVerde.setBounds(336, 73, 100, 20);
		contentPane.add(txtCocodriloVerde);
		txtCocodriloVerde.setColumns(10);
		
		//Campo de texto para la imagen de serpiente verde
		lbl = new JLabel("Serpiente verde:");
		lbl.setBounds(226, 107, 100, 14);
		contentPane.add(lbl);
		txtSerpienteVerde = new JTextField();
		txtSerpienteVerde.setBounds(336, 104, 100, 20);
		contentPane.add(txtSerpienteVerde);
		txtSerpienteVerde.setColumns(10);
		
		//Campo de texto para la imagen de jirafa verde
		lbl = new JLabel("Jirafa verde:");
		lbl.setBounds(226, 138, 100, 14);
		contentPane.add(lbl);
		txtJirafaVerde = new JTextField();
		txtJirafaVerde.setBounds(336, 135, 100, 20);
		contentPane.add(txtJirafaVerde);
		txtJirafaVerde.setColumns(10);
		
		//Campo de texto para la imagen de cebra verde
		lbl = new JLabel("Cebra verde:");
		lbl.setBounds(226, 169, 100, 14);
		contentPane.add(lbl);
		txtCebraVerde = new JTextField();
		txtCebraVerde.setBounds(336, 166, 100, 20);
		contentPane.add(txtCebraVerde);
		txtCebraVerde.setColumns(10);
		
		//Campo de texto para la imagen de foca verde
		lbl = new JLabel("Foca verde:");
		lbl.setBounds(226, 200, 100, 14);
		contentPane.add(lbl);
		txtFocaVerde = new JTextField();
		txtFocaVerde.setBounds(336, 197, 100, 20);
		contentPane.add(txtFocaVerde);
		txtFocaVerde.setColumns(10);
		
		//Campo de texto para la imagen de camaleon verde
		lbl = new JLabel("Camaleon verde:");
		lbl.setBounds(226, 231, 100, 14);
		contentPane.add(lbl);
		txtCamaleonVerde = new JTextField();
		txtCamaleonVerde.setBounds(336, 228, 100, 20);
		contentPane.add(txtCamaleonVerde);
		txtCamaleonVerde.setColumns(10);
		
		//Campo de texto para la imagen de mono verde
		lbl = new JLabel("Mono verde:");
		lbl.setBounds(226, 262, 100, 14);
		contentPane.add(lbl);
		txtMonoVerde = new JTextField();
		txtMonoVerde.setBounds(336, 259, 100, 20);
		contentPane.add(txtMonoVerde);
		txtMonoVerde.setColumns(10);
		
		//Campo de texto para la imagen de canguro verde
		lbl = new JLabel("Canguro verde:");
		lbl.setBounds(226, 293, 100, 14);
		contentPane.add(lbl);
		txtCanguroVerde = new JTextField();
		txtCanguroVerde.setBounds(336, 290, 100, 20);
		contentPane.add(txtCanguroVerde);
		txtCanguroVerde.setColumns(10);
		
		//Campo de texto para la imagen de loro verde
		lbl = new JLabel("Loro verde:");
		lbl.setBounds(226, 324, 100, 14);
		contentPane.add(lbl);
		txtLoroVerde = new JTextField();
		txtLoroVerde.setBounds(336, 321, 100, 20);
		contentPane.add(txtLoroVerde);
		txtLoroVerde.setColumns(10);
		
		//Campo de texto para la imagen de mofeta verde
		lbl = new JLabel("Mofeta verde:");
		lbl.setBounds(226, 355, 100, 14);
		contentPane.add(lbl);
		txtMofetaVerde = new JTextField();
		txtMofetaVerde.setBounds(336, 352, 100, 20);
		contentPane.add(txtMofetaVerde);
		txtMofetaVerde.setColumns(10);
		
		//---------------------------------------------------------------- Otros ----------------------------------------------------------------
		
		//Campo de texto para el nombre de la personalizacion
		lbl = new JLabel("Nombre:");
		lbl.setBounds(10, 386, 100, 14);
		contentPane.add(lbl);
        txtNombre = new JTextField();
        txtNombre.setBounds(116, 383, 320, 20);
        contentPane.add(txtNombre);
        txtNombre.setColumns(10);
		
        //Boton para guardar la personalizacion
		btnCrear = new JButton("Crear");
		btnCrear.setBounds(106, 411, 110, 30);
		contentPane.add(btnCrear);
		
		//Boton para cancelar la operacion
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(226, 411, 110, 30);
		contentPane.add(btnCancelar);
		
		//TODO: Selección de archivo para las rutas de imagen?
		
	}
	
	//Listeners
	public void addListeners(ActionListener a, ActionListener b) {
		btnCrear.addActionListener(a);
		btnCancelar.addActionListener(b);
	}
	
	//Devuelve la informacion insertada en los TextField de VentanaPersonalizacionCrear
	public JSONObject getDatosPersonalizacion() {
		JSONObject json = new JSONObject();
		//Azul
		json.put("LeonAzul", txtLeonAzul.getText());
		json.put("HipopotamoAzul", txtHipopotamoAzul.getText());
		json.put("CocodriloAzul", txtCocodriloAzul.getText());
		json.put("SerpienteAzul", txtSerpienteAzul.getText());
		json.put("JirafaAzul", txtJirafaAzul.getText());
		json.put("CebraAzul", txtCebraAzul.getText());
		json.put("FocaAzul", txtFocaAzul.getText());
		json.put("CamaleonAzul", txtCamaleonAzul.getText());
		json.put("MonoAzul", txtMonoAzul.getText());
		json.put("CanguroAzul", txtCanguroAzul.getText());
		json.put("LoroAzul", txtLoroAzul.getText());
		json.put("MofetaAzul", txtMofetaAzul.getText());
		//Verde
		json.put("LeonVerde", txtLeonVerde.getText());
		json.put("HipopotamoVerde", txtHipopotamoVerde.getText());
		json.put("CocodriloVerde", txtCocodriloVerde.getText());
		json.put("SerpienteVerde", txtSerpienteVerde.getText());
		json.put("JirafaVerde", txtJirafaVerde.getText());
		json.put("CebraVerde", txtCebraVerde.getText());
		json.put("FocaVerde", txtFocaVerde.getText());
		json.put("CamaleonVerde", txtCamaleonVerde.getText());
		json.put("MonoVerde", txtMonoVerde.getText());
		json.put("CanguroVerde", txtCanguroVerde.getText());
		json.put("LoroVerde", txtLoroVerde.getText());
		json.put("MofetaVerde", txtMofetaVerde.getText());
		//Otros
		json.put("personalizacion", txtNombre.getText());
		return json;
	}
	
	//Cierra la ventana
	public void cerrarVentana(){
		dispose();
	}
	
}
