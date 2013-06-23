package ihm;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Stats extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private GridLayout g = new GridLayout(2, 2);

	private JLabel victoire = new JLabel("Victoire : ");
	private JLabel defaite = new JLabel("Defaite : ");
	private JLabel nbreVictoire = new JLabel("1");
	private JLabel nbreDefaite = new JLabel("0");

	public Stats() {
		panel = new JPanel(g);

		victoire.setHorizontalAlignment(SwingConstants.CENTER);
		defaite.setHorizontalAlignment(SwingConstants.CENTER);
		nbreVictoire.setHorizontalAlignment(SwingConstants.CENTER);
		nbreDefaite.setHorizontalAlignment(SwingConstants.CENTER);

		panel.add(victoire);
		panel.add(nbreVictoire);
		panel.add(defaite);
		panel.add(nbreDefaite);

		this.getContentPane().add(panel);
		this.setTitle("Statistiques");
		this.setBounds(200, 200, 500, 250);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}
}
