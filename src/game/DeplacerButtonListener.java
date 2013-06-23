package game;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import classes.Constante;
import classes.Coordonnees;
import classes.Deplacement;
import classes.DeplacementOuAttaqueValide;
import classes.IntelligenceArtificielleComplexe;
import classes.IntelligenceArtificielleSimple;

public class DeplacerButtonListener implements ActionListener {

	private Deplacer deplacer;
	
	public DeplacerButtonListener(Deplacer deplacer) {
		// TODO Auto-generated constructor stub
		this.deplacer = deplacer;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(deplacer.getHautGauche())){
			Coordonnees deplacementValide = new DeplacementOuAttaqueValide(deplacer.getRobotEnCoursDeTraitement(), deplacer.getJeu().getPlateauDeJeu().getGrille()).deplacementValide(Constante.HAUTGAUCHE);
			deplacerRobot(deplacementValide);
		}
		if(e.getSource().equals(deplacer.getHaut())){
			Coordonnees deplacementValide = new DeplacementOuAttaqueValide(deplacer.getRobotEnCoursDeTraitement(), deplacer.getJeu().getPlateauDeJeu().getGrille()).deplacementValide(Constante.HAUT);
			deplacerRobot(deplacementValide);
		}
		if(e.getSource().equals(deplacer.getHautDroite())){
			Coordonnees deplacementValide = new DeplacementOuAttaqueValide(deplacer.getRobotEnCoursDeTraitement(), deplacer.getJeu().getPlateauDeJeu().getGrille()).deplacementValide(Constante.HAUTDROITE);
			deplacerRobot(deplacementValide);
		}
		if(e.getSource().equals(deplacer.getGauche())){
			Coordonnees deplacementValide = new DeplacementOuAttaqueValide(deplacer.getRobotEnCoursDeTraitement(), deplacer.getJeu().getPlateauDeJeu().getGrille()).deplacementValide(Constante.GAUCHE);
			deplacerRobot(deplacementValide);	
		}
		if(e.getSource().equals(deplacer.getDroite())){
			Coordonnees deplacementValide = new DeplacementOuAttaqueValide(deplacer.getRobotEnCoursDeTraitement(), deplacer.getJeu().getPlateauDeJeu().getGrille()).deplacementValide(Constante.DROITE);
			deplacerRobot(deplacementValide);
		}
		if(e.getSource().equals(deplacer.getBasGauche())){
			Coordonnees deplacementValide = new DeplacementOuAttaqueValide(deplacer.getRobotEnCoursDeTraitement(), deplacer.getJeu().getPlateauDeJeu().getGrille()).deplacementValide(Constante.BASGAUCHE);
			deplacerRobot(deplacementValide);
		}
		if(e.getSource().equals(deplacer.getBas())){
			Coordonnees deplacementValide = new DeplacementOuAttaqueValide(deplacer.getRobotEnCoursDeTraitement(), deplacer.getJeu().getPlateauDeJeu().getGrille()).deplacementValide(Constante.BAS);
			deplacerRobot(deplacementValide);
		}
		if(e.getSource().equals(deplacer.getBasDroite())){
			Coordonnees deplacementValide = new DeplacementOuAttaqueValide(deplacer.getRobotEnCoursDeTraitement(), deplacer.getJeu().getPlateauDeJeu().getGrille()).deplacementValide(Constante.BASDROITE);
			deplacerRobot(deplacementValide);
		}
	}
	
	@SuppressWarnings("deprecation")
	public void deplacerRobot(Coordonnees deplacementValide){
		if(deplacementValide == null){
			JOptionPane.showMessageDialog(null, "Déplacement impossible !", "Erreur", JOptionPane.ERROR_MESSAGE);
		} else {
			new Deplacement(deplacer.getRobotEnCoursDeTraitement(), deplacementValide).agit();
			deplacer.getJeu().getEquipe1().actualiserEquipe();
			deplacer.getJeu().getEquipe2().actualiserEquipe();
			if(deplacer.getJeu().getEquipeQuiJoue()==1){
				for(int i = 0 ; i < deplacer.getJeu().getEquipe2().size() ; i++){
					deplacer.getJeu().getEquipe2().get(i).regeneration();
				}
				if(deplacer.getJeu().getChoixDeJeuEquipe2().equals("Jeu manuel")){
					JPanel newPanel = deplacer.getJeu().genererPanelGrille(deplacer.getJeu().getPlateauDeJeu().getGrille(), 2);
					deplacer.getJeu().getPlateau().removeAll();
					deplacer.getJeu().getPlateau().setLayout(new BorderLayout());
					deplacer.getJeu().getPlateau().add(newPanel);
					deplacer.getJeu().getPlateau().revalidate();
					deplacer.getJeu().getPlateau().repaint();
					deplacer.getJeu().setEquipeQuiJoue(2);
					deplacer.getJeu().getEquipeQuiJoueDisplay().setText("C'est au tour de l'équipe 2");
					
					JPanel newBoutonsPanel = deplacer.getJeu().genererBoutonsEquipe2(deplacer.getJeu().getPlateauDeJeu().getGrille(), deplacer.getJeu().getEquipe2());
					deplacer.getJeu().getConteneurBoutons().removeAll();
					deplacer.getJeu().getConteneurBoutons().add(newBoutonsPanel);
					deplacer.getJeu().getConteneurBoutons().revalidate();
					deplacer.getJeu().getConteneurBoutons().repaint();
					
					deplacer.getJeu().initIndicateursPanel(deplacer.getJeu().getRobotsDisplay2());
				} else {
					if (deplacer.getJeu().getChoixDeJeuEquipe2().equals("IA - Niveau simple")) {
						new IntelligenceArtificielleSimple(deplacer.getJeu().getEquipe2()).agit();
					} else {
						new IntelligenceArtificielleComplexe(deplacer.getJeu().getEquipe2()).agit();
					}
					deplacer.getJeu().getEquipe1().actualiserEquipe();
					deplacer.getJeu().getEquipe2().actualiserEquipe();
					for(int i = 0 ; i < deplacer.getJeu().getEquipe1().size() ; i++){
						deplacer.getJeu().getEquipe1().get(i).regeneration();
					}
					JPanel newPanel = deplacer.getJeu().genererPanelGrille(deplacer.getJeu().getPlateauDeJeu().getGrille(), 1);
					deplacer.getJeu().getPlateau().removeAll();
					deplacer.getJeu().getPlateau().setLayout(new BorderLayout());
					deplacer.getJeu().getPlateau().add(newPanel);
					deplacer.getJeu().getPlateau().revalidate();
					deplacer.getJeu().getPlateau().repaint();
					deplacer.getJeu().setEquipeQuiJoue(1);
					deplacer.getJeu().getEquipeQuiJoueDisplay().setText("C'est au tour de l'équipe 1");
					
					JPanel newBoutonsPanel = deplacer.getJeu().genererBoutonsEquipe1(deplacer.getJeu().getPlateauDeJeu().getGrille(), deplacer.getJeu().getEquipe1());
					deplacer.getJeu().getConteneurBoutons().removeAll();
					deplacer.getJeu().getConteneurBoutons().add(newBoutonsPanel);
					deplacer.getJeu().getConteneurBoutons().revalidate();
					deplacer.getJeu().getConteneurBoutons().repaint();
				}
			} else {
				for(int i = 0 ; i < deplacer.getJeu().getEquipe1().size() ; i++){
					deplacer.getJeu().getEquipe1().get(i).regeneration();
				}
				if(deplacer.getJeu().getChoixDeJeuEquipe1().equals("Jeu manuel")){
					JPanel newPanel = deplacer.getJeu().genererPanelGrille(deplacer.getJeu().getPlateauDeJeu().getGrille(), 1);
					deplacer.getJeu().getPlateau().removeAll();
					deplacer.getJeu().getPlateau().setLayout(new BorderLayout());
					deplacer.getJeu().getPlateau().add(newPanel);
					deplacer.getJeu().getPlateau().revalidate();
					deplacer.getJeu().getPlateau().repaint();
					deplacer.getJeu().setEquipeQuiJoue(1);
					deplacer.getJeu().getEquipeQuiJoueDisplay().setText("C'est au tour de l'équipe 1");
					
					JPanel newBoutonsPanel = deplacer.getJeu().genererBoutonsEquipe1(deplacer.getJeu().getPlateauDeJeu().getGrille(), deplacer.getJeu().getEquipe1());
					deplacer.getJeu().getConteneurBoutons().removeAll();
					deplacer.getJeu().getConteneurBoutons().add(newBoutonsPanel);
					deplacer.getJeu().getConteneurBoutons().revalidate();
					deplacer.getJeu().getConteneurBoutons().repaint();
					
					deplacer.getJeu().initIndicateursPanel(deplacer.getJeu().getRobotsDisplay1());
				} else {
					if (deplacer.getJeu().getChoixDeJeuEquipe1().equals("IA - Niveau simple")) {
						new IntelligenceArtificielleSimple(deplacer.getJeu().getEquipe1()).agit();
						
					}else{
						new IntelligenceArtificielleComplexe(deplacer.getJeu().getEquipe1()).agit();		
					}
					deplacer.getJeu().getEquipe1().actualiserEquipe();
					deplacer.getJeu().getEquipe2().actualiserEquipe();
					for(int i = 0 ; i < deplacer.getJeu().getEquipe2().size() ; i++){
						deplacer.getJeu().getEquipe2().get(i).regeneration();
					}
					JPanel newPanel = deplacer.getJeu().genererPanelGrille(deplacer.getJeu().getPlateauDeJeu().getGrille(), 2);
					deplacer.getJeu().getPlateau().removeAll();
					deplacer.getJeu().getPlateau().setLayout(new BorderLayout());
					deplacer.getJeu().getPlateau().add(newPanel);
					deplacer.getJeu().getPlateau().revalidate();
					deplacer.getJeu().getPlateau().repaint();
					deplacer.getJeu().setEquipeQuiJoue(2);
					deplacer.getJeu().getEquipeQuiJoueDisplay().setText("C'est au tour de l'équipe 2");
					
					JPanel newBoutonsPanel = deplacer.getJeu().genererBoutonsEquipe2(deplacer.getJeu().getPlateauDeJeu().getGrille(), deplacer.getJeu().getEquipe2());
					deplacer.getJeu().getConteneurBoutons().removeAll();
					deplacer.getJeu().getConteneurBoutons().add(newBoutonsPanel);
					deplacer.getJeu().getConteneurBoutons().revalidate();
					deplacer.getJeu().getConteneurBoutons().repaint();
				}
			}
		}
		deplacer.dispose();
		deplacer.getJeu().enable();
		deplacer.getJeu().toFront();
		
		if(deplacer.getJeu().getEquipe1().estVide()){
			new PartieFinie(1, deplacer.getJeu());
		}
		if(deplacer.getJeu().getEquipe2().estVide()){
			new PartieFinie(2, deplacer.getJeu());
		}
	}
}
