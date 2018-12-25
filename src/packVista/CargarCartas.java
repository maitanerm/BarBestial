package packVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CargarCartas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CargarCartas frame = new CargarCartas();
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
	public CargarCartas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Canguro");
		panel_3.add(lblNewLabel);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		JButton btnCargar = new JButton("cargar");
		panel_3.add(btnCargar);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7, BorderLayout.NORTH);
		
		JLabel lblLoro = new JLabel("Loro");
		panel_7.add(lblLoro);
		
		textField_1 = new JTextField();
		panel_7.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCargar_1 = new JButton("cargar");
		panel_7.add(btnCargar_1);
		
		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_8.add(panel_9, BorderLayout.NORTH);
		panel_9.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_8.add(panel_10, BorderLayout.CENTER);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_10.add(panel_11, BorderLayout.NORTH);
		
		JLabel lblMono = new JLabel("Mono");
		panel_11.add(lblMono);
		
		textField_2 = new JTextField();
		panel_11.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnCargar_2 = new JButton("cargar");
		panel_11.add(btnCargar_2);
		
		JPanel panel_12 = new JPanel();
		panel_10.add(panel_12, BorderLayout.CENTER);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_13 = new JPanel();
		panel_12.add(panel_13, BorderLayout.NORTH);
		panel_13.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_12.add(panel_14, BorderLayout.CENTER);
		panel_14.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_15 = new JPanel();
		panel_14.add(panel_15, BorderLayout.NORTH);
		
		JLabel lblCebra = new JLabel("Cebra");
		panel_15.add(lblCebra);
		
		textField_3 = new JTextField();
		panel_15.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnCargar_3 = new JButton("cargar");
		panel_15.add(btnCargar_3);
		
		JPanel panel_16 = new JPanel();
		panel_14.add(panel_16, BorderLayout.CENTER);
		panel_16.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_17 = new JPanel();
		panel_16.add(panel_17, BorderLayout.NORTH);
		panel_17.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_18 = new JPanel();
		panel_16.add(panel_18, BorderLayout.CENTER);
		panel_18.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_19 = new JPanel();
		panel_18.add(panel_19, BorderLayout.NORTH);
		
		JLabel lblFoca = new JLabel("Foca");
		panel_19.add(lblFoca);
		
		textField_4 = new JTextField();
		panel_19.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnCargar_4 = new JButton("cargar");
		panel_19.add(btnCargar_4);
		
		JPanel panel_20 = new JPanel();
		panel_18.add(panel_20, BorderLayout.CENTER);
		panel_20.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_21 = new JPanel();
		panel_20.add(panel_21, BorderLayout.NORTH);
		
		JLabel lblLeon = new JLabel("Leon");
		panel_21.add(lblLeon);
		
		textField_5 = new JTextField();
		panel_21.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnCargar_5 = new JButton("cargar");
		panel_21.add(btnCargar_5);
		
		JPanel panel_22 = new JPanel();
		panel_20.add(panel_22, BorderLayout.CENTER);
		panel_22.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_23 = new JPanel();
		panel_22.add(panel_23, BorderLayout.NORTH);
		
		JLabel lblJirafa = new JLabel("Jirafa");
		panel_23.add(lblJirafa);
		
		textField_6 = new JTextField();
		panel_23.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnCargar_6 = new JButton("cargar");
		panel_23.add(btnCargar_6);
		
		JPanel panel_24 = new JPanel();
		panel_22.add(panel_24, BorderLayout.SOUTH);
		panel_24.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_25 = new JPanel();
		panel_22.add(panel_25, BorderLayout.CENTER);
		panel_25.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_26 = new JPanel();
		panel_25.add(panel_26, BorderLayout.NORTH);
		panel_26.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_27 = new JPanel();
		panel_25.add(panel_27, BorderLayout.CENTER);
		panel_27.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_28 = new JPanel();
		panel_27.add(panel_28, BorderLayout.NORTH);
		
		JLabel lblHipopotamo = new JLabel("Hipopotamo");
		panel_28.add(lblHipopotamo);
		
		textField_7 = new JTextField();
		panel_28.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnCargar_7 = new JButton("cargar");
		panel_28.add(btnCargar_7);
		
		JPanel panel_29 = new JPanel();
		panel_27.add(panel_29, BorderLayout.CENTER);
		panel_29.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_30 = new JPanel();
		panel_29.add(panel_30, BorderLayout.NORTH);
		
		JLabel lblMofeta = new JLabel("Mofeta");
		panel_30.add(lblMofeta);
		
		textField_8 = new JTextField();
		panel_30.add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnCargar_8 = new JButton("cargar");
		panel_30.add(btnCargar_8);
		
		JPanel panel_31 = new JPanel();
		panel_29.add(panel_31, BorderLayout.CENTER);
		panel_31.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_32 = new JPanel();
		panel_31.add(panel_32, BorderLayout.NORTH);
		
		JLabel lblCocodrilo = new JLabel("Cocodrilo");
		panel_32.add(lblCocodrilo);
		
		textField_9 = new JTextField();
		panel_32.add(textField_9);
		textField_9.setColumns(10);
		
		JButton btnCargar_9 = new JButton("cargar");
		panel_32.add(btnCargar_9);
		
		JPanel panel_33 = new JPanel();
		panel_31.add(panel_33, BorderLayout.CENTER);
		panel_33.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_34 = new JPanel();
		panel_33.add(panel_34, BorderLayout.NORTH);
		
		JLabel lblSerpiente = new JLabel("Serpiente");
		panel_34.add(lblSerpiente);
		
		textField_10 = new JTextField();
		panel_34.add(textField_10);
		textField_10.setColumns(10);
		
		JButton btnCargar_10 = new JButton("cargar");
		panel_34.add(btnCargar_10);
		
		JPanel panel_35 = new JPanel();
		panel_33.add(panel_35, BorderLayout.CENTER);
		panel_35.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_36 = new JPanel();
		panel_35.add(panel_36);
		
		JLabel lblCamaleon = new JLabel("Camaleon");
		panel_36.add(lblCamaleon);
		
		textField_11 = new JTextField();
		panel_36.add(textField_11);
		textField_11.setColumns(10);
		
		JButton btnCargar_11 = new JButton("cargar");
		panel_36.add(btnCargar_11);
		
		JPanel panel_37 = new JPanel();
		panel_35.add(panel_37);
		panel_37.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnOk = new JButton("OK");
		panel_37.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		panel_37.add(btnCancelar);
	}

}
