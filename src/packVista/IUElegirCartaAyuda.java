package packVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import net.miginfocom.swing.MigLayout;

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
		panel.setLayout(new MigLayout("", "[28px][][][][][][]", "[20px][][][][]"));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Selecciona una carta del oponente");
		String nombre = "Selecciona una carta del oponente";
		comboBox.addItem(nombre);
		comboBox.setSelectedIndex(0);
		panel.add(comboBox, "cell 6 4,alignx left,aligny top");
	}

}
