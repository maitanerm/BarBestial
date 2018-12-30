package packVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class IURanking extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IURanking frame = new IURanking();
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
	public IURanking() {
		setTitle("Visualizaci\u00F3n del ranking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Mis mejores partidas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnMejoresPartidas = new JButton("Mejores partidas ");
		panel.add(btnMejoresPartidas);
		
		JButton btnMejoresJugadores = new JButton("Mejores jugadores");
		panel.add(btnMejoresJugadores);
		panel.add(btnNewButton);
		
		JButton btnMejoresPartidasDel = new JButton("Mejores partidas del d\u00EDa");
		panel.add(btnMejoresPartidasDel);

		String data[][]={ {"01","Amit","670000"},    
                {"02","Jai","780000"},    
                {"03","Sachin","700000"}};    
		String column[]={"ID","NAME","SALARY"};   
		table = new JTable(data, column);      
		panel.add(table);
	}

}
