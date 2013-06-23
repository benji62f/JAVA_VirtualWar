package game;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import classes.Robot;

public class Attaquer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton haut;
	private JButton gauche;
	private JButton droite;
	private JButton bas;

	private Robot robotEnCoursDeTraitement;
	private VirtualWar jeu;

	ActionListener listener = new AttaquerButtonListener(this);

	public Attaquer(Robot robotEnCoursDeTraitement, VirtualWar jeu) {
		// TODO Auto-generated constructor stub
		this.robotEnCoursDeTraitement = robotEnCoursDeTraitement;
		this.jeu = jeu;

		JPanel conteneurBoutonsDirectionnels = new JPanel();
		conteneurBoutonsDirectionnels.setLayout(new GridLayout(3, 3));

		haut = new JButton();
		gauche = new JButton();
		droite = new JButton();
		bas = new JButton();

		haut.setIcon(new ImageIcon(this.getClass().getResource("/img/fleches/haut.png")));
		gauche.setIcon(new ImageIcon(this.getClass().getResource("/img/fleches/gauche.png")));
		droite.setIcon(new ImageIcon(this.getClass().getResource("/img/fleches/droite.png")));
		bas.setIcon(new ImageIcon(this.getClass().getResource("/img/fleches/bas.png")));
		
		conteneurBoutonsDirectionnels.add(new JLabel());
		conteneurBoutonsDirectionnels.add(haut);
		conteneurBoutonsDirectionnels.add(new JLabel());
		conteneurBoutonsDirectionnels.add(gauche);
		conteneurBoutonsDirectionnels.add(new JLabel());
		conteneurBoutonsDirectionnels.add(droite);
		conteneurBoutonsDirectionnels.add(new JLabel());
		conteneurBoutonsDirectionnels.add(bas);
		conteneurBoutonsDirectionnels.add(new JLabel());
		this.setTitle("Direction");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.getContentPane().add(conteneurBoutonsDirectionnels);
		this.setSize(300, 300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		haut.addActionListener(listener);
		gauche.addActionListener(listener);
		droite.addActionListener(listener);
		bas.addActionListener(listener);
	}

	public JButton getHaut() {
		return haut;
	}

	public void setHaut(JButton haut) {
		this.haut = haut;
	}

	public JButton getGauche() {
		return gauche;
	}

	public void setGauche(JButton gauche) {
		this.gauche = gauche;
	}

	public JButton getDroite() {
		return droite;
	}

	public void setDroite(JButton droite) {
		this.droite = droite;
	}

	public JButton getBas() {
		return bas;
	}

	public void setBas(JButton bas) {
		this.bas = bas;
	}

	public Robot getRobotEnCoursDeTraitement() {
		return robotEnCoursDeTraitement;
	}

	public void setRobotEnCoursDeTraitement(Robot robotEnCoursDeTraitement) {
		this.robotEnCoursDeTraitement = robotEnCoursDeTraitement;
	}

	public VirtualWar getJeu() {
		return jeu;
	}

	public void setJeu(VirtualWar jeu) {
		this.jeu = jeu;
	}

	public ActionListener getListener() {
		return listener;
	}

	public void setListener(ActionListener listener) {
		this.listener = listener;
	}
	
}
