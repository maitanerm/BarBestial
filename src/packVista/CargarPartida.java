package packVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JComboBox;

public class CargarPartida extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblCargarPartida;
	private JPanel panel_2;
	private JButton btnOk;
	private JButton btnCancelar;
	private JPanel panel_3;
	private JComboBox partida;
	private JLabel lblPartidas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CargarPartida frame = new CargarPartida();
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
	public CargarPartida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getPanel_1(), BorderLayout.NORTH);
			panel.add(getPanel_2(), BorderLayout.SOUTH);
			panel.add(getPanel_3(), BorderLayout.CENTER);
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.add(getLblCargarPartida());
		}
		return panel_1;
	}
	private JLabel getLblCargarPartida() {
		if (lblCargarPartida == null) {
			lblCargarPartida = new JLabel("Cargar Partida");
			lblCargarPartida.setFont(new Font("Tahoma", Font.PLAIN, 40));
		}
		return lblCargarPartida;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.add(getBtnOk());
			panel_2.add(getBtnCancelar());
		}
		return panel_2;
	}
	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("OK");
		}
		return btnOk;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
		}
		return btnCancelar;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_3.add(getLblPartidas());
			panel_3.add(getPartida());
		}
		return panel_3;
	}
	private JComboBox getPartida() {
		if (partida == null) {
			partida = new JComboBox();
			partida.setMaximumRowCount(100);
		}
		return partida;
	}
	private JLabel getLblPartidas() {
		if (lblPartidas == null) {
			lblPartidas = new JLabel("Partidas");
		}
		return lblPartidas;
	}
	public void addGuardarVentanaPartidaListener (ActionListener listenForBtnOkCargar){
		btnOk.addActionListener(listenForBtnOkCargar);
	}
	
	public void addCancelarGuardarPartidaListener (ActionListener listenForBtnCancelarCargar){
		btnCancelar.addActionListener(listenForBtnCancelarCargar);
	}
	
	public String cogerIDPartida(){
		String id= (String)partida.getSelectedItem();
		return id;
	}
public void cerrarVentanaPartidaCargar(){
		System.exit(0);
	}
}
