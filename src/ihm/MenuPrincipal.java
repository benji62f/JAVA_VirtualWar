/*
 * Projet N2P2 - Virtual War
 * 
 * Virtual War est un jeu de plateau, mettant en scène 2 équipes se faisant la guerre.
 * Chaque équipe peut être composée de tireurs, de piégeurs (poseurs de mines) ou de chars.
 * 
 * LEFEBVRE Benjamin
 * DUMAZY Clément
 * ZIYADI Bader
 * EL KASHEF Ihab
 * QUENON Thomas
 * COTTON Alexandre
 * 
 * Université Lille 1 - IUT 'A'
 * Année 2013-2014 (Semestre 2)
 * 
 */

package ihm;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class MenuPrincipal extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean retro;
	
	private JButton jouer;
	private JButton credits;
	private JButton stats;
	private JButton partieRapide;
	private JButton quitter;
	private JButton options;
	
	private JSplitPane splitPane;
	private JPanel gauche, droite;
	
	private ActionListener listener = new MenuPrincipalButtonListener(this);
	
	public MenuPrincipal() throws IOException{
		
		retro = false;
		
		/*
		 * BootScreen Virtual War
		 */
		JLabel imageDeDemarrage = new JLabel(new ImageIcon(this.getClass().getResource("/img/ImageDeDemarrage.png")));
		JFrame boot = new JFrame();
		boot.add(imageDeDemarrage);
		boot.setBounds(0, 0, 500, 375);
		boot.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		boot.setResizable(false);
		boot.setLocationRelativeTo(null); //affiche la fenêtre au centre de l'écran
		boot.setUndecorated(true); //retire le contour de la fenêtre pour ne laisser apparaître que son contenu
		boot.setVisible(true);
		
		try{
			Thread.sleep(2500);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
		boot.dispose();
		
		/*
		 * Menu principal
		 */
		jouer = new JButton("Jouer");
		credits = new JButton("Crédits");
		stats = new JButton("Stats");
		partieRapide = new JButton("Partie Rapide");
		quitter = new JButton("Quitter");
		options = new JButton("Options");
		
		/*
		 * MERCI DE NE PAS SUPPRIMER CE COMMENTAIRE !
		 */
		/*
		jouer = new JButton("Jouer");
		jouer.setIcon(new ImageIcon(this.getClass().getResource("/img/menuPrincipal/jouer.png")));
		jouer.setContentAreaFilled(false);
		credits = new JButton("Crédits");
		credits.setIcon(new ImageIcon(this.getClass().getResource("/img/menuPrincipal/credits.png")));
		credits.setContentAreaFilled(false);
		stats = new JButton("Stats");
		stats.setIcon(new ImageIcon(this.getClass().getResource("/img/menuPrincipal/stats.png")));
		stats.setContentAreaFilled(false);
		partieRapide = new JButton();
		partieRapide.setIcon(new ImageIcon(this.getClass().getResource("/img/menuPrincipal/partieRapide.png")));
		partieRapide.setContentAreaFilled(false);
		quitter = new JButton("Quitter");
		quitter.setIcon(new ImageIcon(this.getClass().getResource("/img/menuPrincipal/quitter.png")));
		quitter.setContentAreaFilled(false);
		options = new JButton("Options");
		options.setIcon(new ImageIcon(this.getClass().getResource("/img/menuPrincipal/options.png")));
		options.setContentAreaFilled(false);
		*/
		
		droite = new JPanel();
		droite.setLayout(new GridLayout(6,1,15,15));
		gauche = new JPanel(new GridLayout(1,1));
		JLabel image = new JLabel(new ImageIcon(this.getClass().getResource("/img/VirtualWarHomePage.jpg")));
		gauche.add(image);
		gauche.setBackground(new Color(137,188,219));
		
		droite.add(jouer);
		droite.add(partieRapide);
		droite.add(stats);
		droite.add(options);
		droite.add(credits);
		droite.add(quitter);
		droite.setBackground(new Color(137,188,219));
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,gauche,droite);
		splitPane.setDividerLocation(500);
		splitPane.setEnabled(false);
		
		this.getContentPane().add(splitPane);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(200, 200, 700, 700);
		this.setTitle("Virtual War by La Source");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		jouer.addActionListener(listener);
		credits.addActionListener(listener);
		stats.addActionListener(listener);
		partieRapide.addActionListener(listener);
		quitter.addActionListener(listener);
		options.addActionListener(listener);
	}
	
	/*
	 * Getters & Setters
	 */
	public boolean isRetro() {
		return retro;
	}

	public void setRetro(boolean retro) {
		this.retro = retro;
	}

	public JButton getJouer() {
		return jouer;
	}

	public void setJouer(JButton jouer) {
		this.jouer = jouer;
	}

	public JButton getCredits() {
		return credits;
	}

	public void setCredits(JButton credits) {
		this.credits = credits;
	}

	public JButton getStats() {
		return stats;
	}

	public void setStats(JButton stats) {
		this.stats = stats;
	}

	public JButton getPartieRapide() {
		return partieRapide;
	}

	public void setPartieRapide(JButton partieRapide) {
		this.partieRapide = partieRapide;
	}

	public JButton getQuitter() {
		return quitter;
	}

	public void setQuitter(JButton quitter) {
		this.quitter = quitter;
	}

	public JButton getOptions() {
		return options;
	}

	public void setOptions(JButton options) {
		this.options = options;
	}

	public JSplitPane getSplitPane() {
		return splitPane;
	}

	public void setSplitPane(JSplitPane splitPane) {
		this.splitPane = splitPane;
	}

	public JPanel getGauche() {
		return gauche;
	}

	public void setGauche(JPanel gauche) {
		this.gauche = gauche;
	}

	public JPanel getDroite() {
		return droite;
	}

	public void setDroite(JPanel droite) {
		this.droite = droite;
	}

	public ActionListener getListener() {
		return listener;
	}

	public void setListener(ActionListener listener) {
		this.listener = listener;
	}
	
	/*
	 * Fonction main()
	 */
	public static void main(String[] args) throws IOException{
		new MenuPrincipal();
	}
}