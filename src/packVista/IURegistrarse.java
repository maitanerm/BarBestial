package packVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONArray;
import org.json.JSONObject;

import packModelo.Partida;
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

public class IURegistrarse extends JFrame {

	private JPanel contentPane;
	private JTextField usuario;
	private JTextField pass;
	private JTextField preg;
	private JTextField resp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IURegistrarse frame = new IURegistrarse();
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
	public IURegistrarse() {
		setTitle("Registrarse");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 279);
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
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblSeleccioneUnaDe = new JLabel("Introduce los siguientes datos para registrarse:");
		GridBagConstraints gbc_lblSeleccioneUnaDe = new GridBagConstraints();
		gbc_lblSeleccioneUnaDe.insets = new Insets(0, 0, 5, 0);
		gbc_lblSeleccioneUnaDe.gridx = 0;
		gbc_lblSeleccioneUnaDe.gridy = 0;
		panel_1.add(lblSeleccioneUnaDe, gbc_lblSeleccioneUnaDe);
		
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
		
		JPanel panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 5, 0);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 4;
		panel_1.add(panel_7, gbc_panel_7);
		
		JLabel lblEmail = new JLabel("Pregunta seguridad:");
		panel_7.add(lblEmail);
		
		preg = new JTextField();
		preg.setColumns(10);
		panel_7.add(preg);
		
		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 5, 0);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 5;
		panel_1.add(panel_8, gbc_panel_8);
		
		JLabel lblRespuesta = new JLabel("Respuesta:");
		panel_8.add(lblRespuesta);
		
		resp = new JTextField();
		resp.setColumns(10);
		panel_8.add(resp);
		
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 6;
		panel_1.add(panel_6, gbc_panel_6);
		
		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JSONObject obj = new JSONObject();
				obj.put("idJ", usuario.getText());
				obj.put("password", pass.getText());
				obj.put("pregunta", preg.getText());
				obj.put("respuesta", resp.getText());
				if (BarBestial.getBarBestial().registro (obj)) {
					IUAcceder ac = new IUAcceder();
					setVisible(false);
					ac.setVisible(true);
				}else {
					Error err = new Error();
					setVisible(false);
					err.setVisible(true);
				}
			}
		});
		panel_6.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
	}

}
