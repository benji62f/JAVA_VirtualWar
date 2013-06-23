package game;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import classes.Attaque;
import classes.Constante;
import classes.Coordonnees;
import classes.DeplacementOuAttaqueValide;
import classes.IntelligenceArtificielleComplexe;
import classes.IntelligenceArtificielleSimple;

public class AttaquerButtonListener implements ActionListener {

	private Attaquer attaquer;
	
	public AttaquerButtonListener(Attaquer attaquer) {
		// TODO Auto-generated constructor stub
		this.attaquer = attaquer;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(attaquer.getHaut())){
			Coordonnees attaqueValide = new DeplacementOuAttaqueValide(attaquer.getRobotEnCoursDeTraitement(), attaquer.getJeu().getPlateauDeJeu().getGrille()).attaqueValide(Constante.HAUT);
			attaquerRobot(attaqueValide);
		}
		if(e.getSource().equals(attaquer.getGauche())){
			Coordonnees attaqueValide = new DeplacementOuAttaqueValide(attaquer.getRobotEnCoursDeTraitement(), attaquer.getJeu().getPlateauDeJeu().getGrille()).attaqueValide(Constante.GAUCHE);
			attaquerRobot(attaqueValide);	
		}
		if(e.getSource().equals(attaquer.getDroite())){
			Coordonnees attaqueValide = new DeplacementOuAttaqueValide(attaquer.getRobotEnCoursDeTraitement(), attaquer.getJeu().getPlateauDeJeu().getGrille()).attaqueValide(Constante.DROITE);
			attaquerRobot(attaqueValide);
		}
		if(e.getSource().equals(attaquer.getBas())){
			Coordonnees attaqueValide = new DeplacementOuAttaqueValide(attaquer.getRobotEnCoursDeTraitement(), attaquer.getJeu().getPlateauDeJeu().getGrille()).attaqueValide(Constante.BAS);
			attaquerRobot(attaqueValide);
		}
	}
	
	@SuppressWarnings("deprecation")
	public void attaquerRobot(Coordonnees attaqueValide){
		if(attaqueValide == null){
			JOptionPane.showMessageDialog(null, "Attaque impossible !", "Erreur", JOptionPane.ERROR_MESSAGE);
		} else {
			new Attaque(attaquer.getRobotEnCoursDeTraitement(), attaqueValide).agit();
			attaquer.getJeu().getEquipe1().actualiserEquipe();
			attaquer.getJeu().getEquipe2().actualiserEquipe();
			if(attaquer.getJeu().getEquipeQuiJoue()==1){
				for(int i = 0 ; i < attaquer.getJeu().getEquipe2().size() ; i++){
					attaquer.getJeu().getEquipe2().get(i).regeneration();
				}
				if(attaquer.getJeu().getChoixDeJeuEquipe2().equals("Jeu manuel")){
					JPanel newPanel = attaquer.getJeu().genererPanelGrille(attaquer.getJeu().getPlateauDeJeu().getGrille(), 2);
					attaquer.getJeu().getPlateau().removeAll();
					attaquer.getJeu().getPlateau().setLayout(new BorderLayout());
					attaquer.getJeu().getPlateau().add(newPanel);
					attaquer.getJeu().getPlateau().revalidate();
					attaquer.getJeu().getPlateau().repaint();
					attaquer.getJeu().setEquipeQuiJoue(2);
					attaquer.getJeu().getEquipeQuiJoueDisplay().setText("C'est au tour de l'équipe 2");
	
					JPanel newBoutonsPanel = attaquer.getJeu().genererBoutonsEquipe2(attaquer.getJeu().getPlateauDeJeu().getGrille(), attaquer.getJeu().getEquipe2());
					attaquer.getJeu().getConteneurBoutons().removeAll();
					attaquer.getJeu().getConteneurBoutons().add(newBoutonsPanel);
					attaquer.getJeu().getConteneurBoutons().revalidate();
					attaquer.getJeu().getConteneurBoutons().repaint();
					
					attaquer.getJeu().initIndicateursPanel(attaquer.getJeu().getRobotsDisplay2());
				} else {
					if (attaquer.getJeu().getChoixDeJeuEquipe2().equals("IA - Niveau simple")) {
						new IntelligenceArtificielleSimple(attaquer.getJeu().getEquipe2()).agit();
					} else {
						new IntelligenceArtificielleComplexe(attaquer.getJeu().getEquipe2()).agit();
					}
					attaquer.getJeu().getEquipe1().actualiserEquipe();
					attaquer.getJeu().getEquipe2().actualiserEquipe();
					for(int i = 0 ; i < attaquer.getJeu().getEquipe1().size() ; i++){
						attaquer.getJeu().getEquipe1().get(i).regeneration();
					}
					JPanel newPanel = attaquer.getJeu().genererPanelGrille(attaquer.getJeu().getPlateauDeJeu().getGrille(), 1);
					attaquer.getJeu().getPlateau().removeAll();
					attaquer.getJeu().getPlateau().setLayout(new BorderLayout());
					attaquer.getJeu().getPlateau().add(newPanel);
					attaquer.getJeu().getPlateau().revalidate();
					attaquer.getJeu().getPlateau().repaint();
					attaquer.getJeu().setEquipeQuiJoue(1);
					attaquer.getJeu().getEquipeQuiJoueDisplay().setText("C'est au tour de l'équipe 1");
					
					JPanel newBoutonsPanel = attaquer.getJeu().genererBoutonsEquipe1(attaquer.getJeu().getPlateauDeJeu().getGrille(), attaquer.getJeu().getEquipe1());
					attaquer.getJeu().getConteneurBoutons().removeAll();
					attaquer.getJeu().getConteneurBoutons().add(newBoutonsPanel);
					attaquer.getJeu().getConteneurBoutons().revalidate();
					attaquer.getJeu().getConteneurBoutons().repaint();
				}
			} else {
				for(int i = 0 ; i < attaquer.getJeu().getEquipe1().size() ; i++){
					attaquer.getJeu().getEquipe1().get(i).regeneration();
				}
				if(attaquer.getJeu().getChoixDeJeuEquipe1().equals("Jeu manuel")){
					JPanel newPanel = attaquer.getJeu().genererPanelGrille(attaquer.getJeu().getPlateauDeJeu().getGrille(), 1);
					attaquer.getJeu().getPlateau().removeAll();
					attaquer.getJeu().getPlateau().setLayout(new BorderLayout());
					attaquer.getJeu().getPlateau().add(newPanel);
					attaquer.getJeu().getPlateau().revalidate();
					attaquer.getJeu().getPlateau().repaint();
					attaquer.getJeu().setEquipeQuiJoue(1);
					attaquer.getJeu().getEquipeQuiJoueDisplay().setText("C'est au tour de l'équipe 1");
					
					JPanel newBoutonsPanel = attaquer.getJeu().genererBoutonsEquipe1(attaquer.getJeu().getPlateauDeJeu().getGrille(), attaquer.getJeu().getEquipe1());
					attaquer.getJeu().getConteneurBoutons().removeAll();
					attaquer.getJeu().getConteneurBoutons().add(newBoutonsPanel);
					attaquer.getJeu().getConteneurBoutons().revalidate();
					attaquer.getJeu().getConteneurBoutons().repaint();
					
					attaquer.getJeu().initIndicateursPanel(attaquer.getJeu().getRobotsDisplay1());
				} else {
					if (attaquer.getJeu().getChoixDeJeuEquipe1().equals("IA - Niveau simple")) {
						new IntelligenceArtificielleSimple(attaquer.getJeu().getEquipe2()).agit();
					} else {
						new IntelligenceArtificielleComplexe(attaquer.getJeu().getEquipe2()).agit();
					}
					attaquer.getJeu().getEquipe1().actualiserEquipe();
					attaquer.getJeu().getEquipe2().actualiserEquipe();
					for(int i = 0 ; i < attaquer.getJeu().getEquipe2().size() ; i++){
						attaquer.getJeu().getEquipe2().get(i).regeneration();
					}
					JPanel newPanel = attaquer.getJeu().genererPanelGrille(attaquer.getJeu().getPlateauDeJeu().getGrille(), 2);
					attaquer.getJeu().getPlateau().removeAll();
					attaquer.getJeu().getPlateau().setLayout(new BorderLayout());
					attaquer.getJeu().getPlateau().add(newPanel);
					attaquer.getJeu().getPlateau().revalidate();
					attaquer.getJeu().getPlateau().repaint();
					attaquer.getJeu().setEquipeQuiJoue(2);
					attaquer.getJeu().getEquipeQuiJoueDisplay().setText("C'est au tour de l'équipe 2");

					JPanel newBoutonsPanel = attaquer.getJeu().genererBoutonsEquipe2(attaquer.getJeu().getPlateauDeJeu().getGrille(),attaquer.getJeu().getEquipe2());
					attaquer.getJeu().getConteneurBoutons().removeAll();
					attaquer.getJeu().getConteneurBoutons().add(newBoutonsPanel);
					attaquer.getJeu().getConteneurBoutons().revalidate();
					attaquer.getJeu().getConteneurBoutons().repaint();
				}
			}
		}
		attaquer.dispose();
		attaquer.getJeu().enable();
		attaquer.getJeu().toFront();

		if(attaquer.getJeu().getEquipe1().estVide()){
			new PartieFinie(1, attaquer.getJeu());
		}
		if(attaquer.getJeu().getEquipe2().estVide()){
			new PartieFinie(2, attaquer.getJeu());
		}
	}
}
