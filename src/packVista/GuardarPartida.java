package packVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GuardarPartida extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblGuardarPartida;
	private JPanel panel_1;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JPanel panel_2;
	private JLabel lblIntroduceIdDe;
	private JTextField idp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuardarPartida frame = new GuardarPartida();
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
	public GuardarPartida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getPanel_1(), BorderLayout.SOUTH);
		contentPane.add(getPanel_2(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getLblGuardarPartida());
		}
		return panel;
	}
	private JLabel getLblGuardarPartida() {
		if (lblGuardarPartida == null) {
			lblGuardarPartida = new JLabel("Guardar Partida");
			lblGuardarPartida.setFont(new Font("Tahoma", Font.PLAIN, 40));
		}
		return lblGuardarPartida;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_1.add(getBtnAceptar());
			panel_1.add(getBtnCancelar());
		}
		return panel_1;
	}
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Guardar");
		}
		return btnAceptar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");	
		}
		return btnCancelar;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.add(getLabel_1());
			panel_2.add(getIdp());
		}
		return panel_2;
	}
	private JLabel getLabel_1() {
		if (lblIntroduceIdDe == null) {
			lblIntroduceIdDe = new JLabel("Introduce ID de Partida");
		}
		return lblIntroduceIdDe;
	}
	private JTextField getIdp() {
		if (idp == null) {
			idp = new JTextField();
			idp.setColumns(10);
		}
		return idp;
	}
	
	public void addGuardarVentanaPartidaListener (ActionListener listenForBtnAceptar){
		btnAceptar.addActionListener(listenForBtnAceptar);
	}
	
	public void addCancelarGuardarPartidaListener (ActionListener listenForBtnCancelar){
		btnCancelar.addActionListener(listenForBtnCancelar);
	}
	
	public String cogerIDPartida(){
		return this.idp.getText();
	}
	public void cerrarVentanaPartida(){
		System.exit(0);
	}
}

