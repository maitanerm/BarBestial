package packVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONArray;
import org.json.JSONObject;

import net.miginfocom.swing.MigLayout;
import packModelo.Carta;
import packPrincipal.BarBestial;

public class IUElegirCartaAyuda extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IUElegirCartaAyuda frame = new IUElegirCartaAyuda();
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
	public IUElegirCartaAyuda() {
		setTitle("Seleccionar carta oponente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[28px][][][][][][]", "[20px][][][][][]"));
		
		JComboBox comboBox = new JComboBox();
		
		//JSON con las cartas
		JSONArray cartas = BarBestial.getBarBestial().getCartasBarOponente();
		for (int i = 0; i < cartas.length(); i++) {
			JSONObject pos = cartas.getJSONObject(i);
			Carta cartaPos = (Carta) pos.get("carta");
			comboBox.addItem(cartaPos.getEspecie());
		}
		
		comboBox.setSelectedIndex(0);
		panel.add(comboBox, "cell 6 4,alignx left,aligny top");
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BarBestial.getBarBestial().insertarEnCola(comboBox.getSelectedItem().toString());
				dispose();
			}
		});
		panel.add(btnAceptar, "flowx,cell 6 5");
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(btnCancelar, "cell 6 5");
	}

}
