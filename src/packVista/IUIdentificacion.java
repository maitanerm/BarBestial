package packVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import packPrincipal.BarBestial;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IUIdentificacion extends JFrame {

	private JPanel contentPane;
	private JTextField usuario;
	private JTextField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IUIdentificacion frame = new IUIdentificacion();
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
	public IUIdentificacion() {
		setTitle("Identificarse");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblSeleccioneUnaDe = new JLabel("Seleccione una de las redes sociales siguientes para identificarse:");
		GridBagConstraints gbc_lblSeleccioneUnaDe = new GridBagConstraints();
		gbc_lblSeleccioneUnaDe.insets = new Insets(0, 0, 5, 0);
		gbc_lblSeleccioneUnaDe.gridx = 0;
		gbc_lblSeleccioneUnaDe.gridy = 0;
		panel_1.add(lblSeleccioneUnaDe, gbc_lblSeleccioneUnaDe);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		panel_1.add(panel_3, gbc_panel_3);
		
		JButton button = new JButton("");
		panel_3.add(button);
		//button.setIcon(new ImageIcon(IUIdentificacion.class.getResource("/images/LogoGoogle.png")));
		
		JButton button_1 = new JButton("");
		panel_3.add(button_1);
		//button_1.setIcon(new ImageIcon(IUIdentificacion.class.getResource("/images/LogoTwitter.png")));
		
		JButton btnFace = new JButton("");
		panel_3.add(btnFace);
		//btnFace.setIcon(new ImageIcon(IUIdentificacion.class.getResource("/images/LogoFacebook.png")));
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 2;
		panel_1.add(panel_4, gbc_panel_4);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		panel_4.add(lblNewLabel);
		
		usuario = new JTextField();
		panel_4.add(usuario);
		usuario.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 3;
		panel_1.add(panel_5, gbc_panel_5);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		panel_5.add(lblNewLabel_1);
		
		pass = new JTextField();
		panel_5.add(pass);
		pass.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 4;
		panel_1.add(panel_6, gbc_panel_6);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (BarBestial.getBarBestial().inicioSesion(usuario.getText(), pass.getText())) {
					VentanaInicio in = new VentanaInicio();
					setVisible(false);
					in.setVisible(true);
				}else {
					Error err = new Error();
					setVisible(false);
					err.setVisible(true);
				}
			}
		});
		panel_6.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Recuperar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IURecuperar rec = new IURecuperar();
				setVisible(false);
				rec.setVisible(true);
			}
		});
		panel_6.add(btnNewButton_1);
		
		JButton button_2 = new JButton("Cambiar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IUCambiar cam = new IUCambiar();
				setVisible(false);
				cam.setVisible(true);
			}
		});
		panel_6.add(button_2);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
	}

}
