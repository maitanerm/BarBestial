package packVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;

public class VentanaGuardar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaGuardar frame = new VentanaGuardar();
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
	public VentanaGuardar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton_3 = new JButton("slot1");
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("slot2");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("slot3");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("slot4");
		panel.add(btnNewButton);
	}
	
	private void mensajeActualizacion() {
		Object [] opciones = {"Aceptar", "Cancelar"};
		
	}

}
