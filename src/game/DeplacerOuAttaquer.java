package game;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import classes.*;

public class DeplacerOuAttaquer extends JFrame {
	
	private Robot robotEnCoursDeTraitement;
	private VirtualWar jeu;

	private JButton deplacer = new JButton("Déplacer");
	private JButton attaquer = new JButton("Attaquer");
	private JButton annuler = new JButton("Annuler");
	
	private ActionListener listener = new DeplacerOuAttaquerButtonListener(this);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	public DeplacerOuAttaquer(int possibilites, Robot robotEnCoursDeTraitement, VirtualWar jeu){
		this.robotEnCoursDeTraitement = robotEnCoursDeTraitement;
		this.jeu = jeu;
		jeu.disable();
		JPanel conteneur = new JPanel();
		conteneur.setLayout(new GridLayout(1,2,50,0));
		JPanel framePanel = new JPanel(new FlowLayout());
		JLabel message = new JLabel("                              Que voulez-vous faire ?                              ");
		framePanel.add(message);
		framePanel.add(conteneur);
		
		if(possibilites == 0){
			conteneur.add(deplacer);
			conteneur.add(attaquer);
			conteneur.add(annuler);
		}
		if(possibilites == 1){
			conteneur.add(attaquer);
			conteneur.add(annuler);
		}
		if(possibilites == 2){
			conteneur.add(deplacer);
			conteneur.add(annuler);
		}
		this.setTitle("Question");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.getContentPane().add(framePanel);
		this.setBounds(200, 200, 400, 100);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
		deplacer.addActionListener(listener);
		attaquer.addActionListener(listener);
		annuler.addActionListener(listener);
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

	public JButton getDeplacer() {
		return deplacer;
	}

	public void setDeplacer(JButton deplacer) {
		this.deplacer = deplacer;
	}

	public JButton getAttaquer() {
		return attaquer;
	}

	public void setAttaquer(JButton attaquer) {
		this.attaquer = attaquer;
	}

	public JButton getAnnuler() {
		return annuler;
	}

	public void setAnnuler(JButton annuler) {
		this.annuler = annuler;
	}

	public ActionListener getListener() {
		return listener;
	}

	public void setListener(ActionListener listener) {
		this.listener = listener;
	}
}


