package game;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import classes.Robot;

public class Deplacer extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton hautGauche, haut, hautDroite;
	private JButton gauche, droite;
	private JButton basGauche, bas, basDroite;
	
	private Robot robotEnCoursDeTraitement;
	private VirtualWar jeu;
	
	private ActionListener listener = new DeplacerButtonListener(this);
	
	public Deplacer(Robot robotEnCoursDeTraitement, VirtualWar jeu) {
		// TODO Auto-generated constructor stub
		this.robotEnCoursDeTraitement = robotEnCoursDeTraitement;
		this.jeu = jeu;
		
		JPanel conteneurBoutonsDirectionnels = new JPanel();
		conteneurBoutonsDirectionnels.setLayout(new GridLayout(3,3));
		
		hautGauche = new JButton();
		haut = new JButton();
		hautDroite = new JButton();
		gauche = new JButton();
		droite = new JButton();
		basGauche = new JButton();
		bas = new JButton();
		basDroite = new JButton();

		hautGauche.setIcon(new ImageIcon(this.getClass().getResource("/img/fleches/hautGauche.png")));
		haut.setIcon(new ImageIcon(this.getClass().getResource("/img/fleches/haut.png")));
		hautDroite.setIcon(new ImageIcon(this.getClass().getResource("/img/fleches/hautDroite.png")));
		gauche.setIcon(new ImageIcon(this.getClass().getResource("/img/fleches/gauche.png")));
		droite.setIcon(new ImageIcon(this.getClass().getResource("/img/fleches/droite.png")));
		basGauche.setIcon(new ImageIcon(this.getClass().getResource("/img/fleches/basGauche.png")));
		bas.setIcon(new ImageIcon(this.getClass().getResource("/img/fleches/bas.png")));
		basDroite.setIcon(new ImageIcon(this.getClass().getResource("/img/fleches/basDroite.png")));
		
		if(robotEnCoursDeTraitement.getImage().equals("c") || robotEnCoursDeTraitement.getImage().equals("C")){
			conteneurBoutonsDirectionnels.add(new JLabel());
			conteneurBoutonsDirectionnels.add(haut);
			conteneurBoutonsDirectionnels.add(new JLabel());
			conteneurBoutonsDirectionnels.add(gauche);
			conteneurBoutonsDirectionnels.add(new JLabel());
			conteneurBoutonsDirectionnels.add(droite);
			conteneurBoutonsDirectionnels.add(new JLabel());
			conteneurBoutonsDirectionnels.add(bas);
			conteneurBoutonsDirectionnels.add(new JLabel());
		} else {
			conteneurBoutonsDirectionnels.add(hautGauche);
			conteneurBoutonsDirectionnels.add(haut);
			conteneurBoutonsDirectionnels.add(hautDroite);
			conteneurBoutonsDirectionnels.add(gauche);
			conteneurBoutonsDirectionnels.add(new JLabel());
			conteneurBoutonsDirectionnels.add(droite);
			conteneurBoutonsDirectionnels.add(basGauche);
			conteneurBoutonsDirectionnels.add(bas);
			conteneurBoutonsDirectionnels.add(basDroite);
		}
		this.setTitle("Direction");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.getContentPane().add(conteneurBoutonsDirectionnels);
		this.setSize(300, 300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		hautGauche.addActionListener(listener);
		haut.addActionListener(listener);
		hautDroite.addActionListener(listener);
		gauche.addActionListener(listener);
		droite.addActionListener(listener);
		basGauche.addActionListener(listener);
		bas.addActionListener(listener);
		basDroite.addActionListener(listener);
	}

	public JButton getHautGauche() {
		return hautGauche;
	}

	public void setHautGauche(JButton hautGauche) {
		this.hautGauche = hautGauche;
	}

	public JButton getHaut() {
		return haut;
	}

	public void setHaut(JButton haut) {
		this.haut = haut;
	}

	public JButton getHautDroite() {
		return hautDroite;
	}

	public void setHautDroite(JButton hautDroite) {
		this.hautDroite = hautDroite;
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

	public JButton getBasGauche() {
		return basGauche;
	}

	public void setBasGauche(JButton basGauche) {
		this.basGauche = basGauche;
	}

	public JButton getBas() {
		return bas;
	}

	public void setBas(JButton bas) {
		this.bas = bas;
	}

	public JButton getBasDroite() {
		return basDroite;
	}

	public void setBasDroite(JButton basDroite) {
		this.basDroite = basDroite;
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
