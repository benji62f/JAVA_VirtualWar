package game;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import classes.DeplacementOuAttaqueValide;
import classes.Robot;

public class VirtualWarButtonListener implements ActionListener {
	
	private VirtualWar jeu;
	
	public VirtualWarButtonListener(VirtualWar jeu){
		this.jeu = jeu;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource().equals(jeu.getPasserTour())){
			if(jeu.getEquipeQuiJoue()==1){
				for(int i = 0 ; i < jeu.getEquipe2().size() ; i++){
					jeu.getEquipe2().get(i).regeneration();
				}
				JPanel newPanel = jeu.genererPanelGrille(jeu.getPlateauDeJeu().getGrille(), 2);
				jeu.getPlateau().removeAll();
				jeu.getPlateau().setLayout(new BorderLayout());
				jeu.getPlateau().add(newPanel);
				jeu.getPlateau().revalidate();
				jeu.getPlateau().repaint();
				jeu.setEquipeQuiJoue(2);
				jeu.getEquipeQuiJoueDisplay().setText("C'est au tour de l'équipe 2");
					
				JPanel newBoutonsPanel = jeu.genererBoutonsEquipe2(jeu.getPlateauDeJeu().getGrille(), jeu.getEquipe2());
				jeu.getConteneurBoutons().removeAll();
				jeu.getConteneurBoutons().add(newBoutonsPanel);
				jeu.getConteneurBoutons().revalidate();
				jeu.getConteneurBoutons().repaint();
			} else {
				for(int i = 0 ; i < jeu.getEquipe1().size() ; i++){
					jeu.getEquipe1().get(i).regeneration();
				}
				JPanel newPanel = jeu.genererPanelGrille(jeu.getPlateauDeJeu().getGrille(), 1);
				jeu.getPlateau().removeAll();
				jeu.getPlateau().setLayout(new BorderLayout());
				jeu.getPlateau().add(newPanel);
				jeu.getPlateau().revalidate();
				jeu.getPlateau().repaint();
				jeu.setEquipeQuiJoue(1);
				jeu.getEquipeQuiJoueDisplay().setText("C'est au tour de l'équipe 1");
				
				JPanel newBoutonsPanel = jeu.genererBoutonsEquipe1(jeu.getPlateauDeJeu().getGrille(), jeu.getEquipe1());
				jeu.getConteneurBoutons().removeAll();
				jeu.getConteneurBoutons().add(newBoutonsPanel);
				jeu.getConteneurBoutons().revalidate();
				jeu.getConteneurBoutons().repaint();
			}
		}
		
		/*
		 * Si un bouton concernant un robot de l'équipe 1 est pressé
		 */
		if(e.getSource().equals(jeu.getQuitter())){
			jeu.dispose();
		}
		if(e.getSource().equals(jeu.getBouton0Equipe1())){
			Robot robot = jeu.getEquipe1().getListe().get(0);
			boolean peutAttaquer = new DeplacementOuAttaqueValide(jeu.getEquipe1().getListe().get(0), jeu.getPlateauDeJeu().getGrille()).peutAttaquer();
			boolean peutSeDeplacer = new DeplacementOuAttaqueValide(jeu.getEquipe1().getListe().get(0), jeu.getPlateauDeJeu().getGrille()).peutSeDeplacer();
			
			if(peutAttaquer && peutSeDeplacer){
				new DeplacerOuAttaquer(0, robot, jeu);
			} else if(peutAttaquer){
				new DeplacerOuAttaquer(1, robot, jeu);
			} else if(peutSeDeplacer){
				new DeplacerOuAttaquer(2, robot, jeu);				
			}
		}
		if(e.getSource().equals(jeu.getBouton1Equipe1())){
			Robot robot = jeu.getEquipe1().getListe().get(1);
			boolean peutAttaquer = new DeplacementOuAttaqueValide(jeu.getEquipe1().getListe().get(1), jeu.getPlateauDeJeu().getGrille()).peutAttaquer();
			boolean peutSeDeplacer = new DeplacementOuAttaqueValide(jeu.getEquipe1().getListe().get(1), jeu.getPlateauDeJeu().getGrille()).peutSeDeplacer();
			
			if(peutAttaquer && peutSeDeplacer){
				new DeplacerOuAttaquer(0, robot, jeu);
			} else if(peutAttaquer){
				new DeplacerOuAttaquer(1, robot, jeu);
			} else if(peutSeDeplacer){
				new DeplacerOuAttaquer(2, robot, jeu);				
			}
		}
		if(e.getSource().equals(jeu.getBouton2Equipe1())){
			Robot robot = jeu.getEquipe1().getListe().get(2);
			boolean peutAttaquer = new DeplacementOuAttaqueValide(jeu.getEquipe1().getListe().get(2), jeu.getPlateauDeJeu().getGrille()).peutAttaquer();
			boolean peutSeDeplacer = new DeplacementOuAttaqueValide(jeu.getEquipe1().getListe().get(2), jeu.getPlateauDeJeu().getGrille()).peutSeDeplacer();
			
			if(peutAttaquer && peutSeDeplacer){
				new DeplacerOuAttaquer(0, robot, jeu);
			} else if(peutAttaquer){
				new DeplacerOuAttaquer(1, robot, jeu);
			} else if(peutSeDeplacer){
				new DeplacerOuAttaquer(2, robot, jeu);				
			}
		}
		if(e.getSource().equals(jeu.getBouton3Equipe1())){
			Robot robot = jeu.getEquipe1().getListe().get(3);
			boolean peutAttaquer = new DeplacementOuAttaqueValide(jeu.getEquipe1().getListe().get(3), jeu.getPlateauDeJeu().getGrille()).peutAttaquer();
			boolean peutSeDeplacer = new DeplacementOuAttaqueValide(jeu.getEquipe1().getListe().get(3), jeu.getPlateauDeJeu().getGrille()).peutSeDeplacer();
			
			if(peutAttaquer && peutSeDeplacer){
				new DeplacerOuAttaquer(0, robot, jeu);
			} else if(peutAttaquer){
				new DeplacerOuAttaquer(1, robot, jeu);
			} else if(peutSeDeplacer){
				new DeplacerOuAttaquer(2, robot, jeu);				
			}
		}
		if(e.getSource().equals(jeu.getBouton4Equipe1())){
			Robot robot = jeu.getEquipe1().getListe().get(4);
			boolean peutAttaquer = new DeplacementOuAttaqueValide(jeu.getEquipe1().getListe().get(4), jeu.getPlateauDeJeu().getGrille()).peutAttaquer();
			boolean peutSeDeplacer = new DeplacementOuAttaqueValide(jeu.getEquipe1().getListe().get(4), jeu.getPlateauDeJeu().getGrille()).peutSeDeplacer();
			
			if(peutAttaquer && peutSeDeplacer){
				new DeplacerOuAttaquer(0, robot, jeu);
			} else if(peutAttaquer){
				new DeplacerOuAttaquer(1, robot, jeu);
			} else if(peutSeDeplacer){
				new DeplacerOuAttaquer(2, robot, jeu);				
			}
		}
		
		/*
		 * Si un bouton concernant un robot de l'équipe 2 est pressé
		 */
		if(e.getSource().equals(jeu.getBouton0Equipe2())){
			Robot robot = jeu.getEquipe2().getListe().get(0);
			boolean peutAttaquer = new DeplacementOuAttaqueValide(jeu.getEquipe2().getListe().get(0), jeu.getPlateauDeJeu().getGrille()).peutAttaquer();
			boolean peutSeDeplacer = new DeplacementOuAttaqueValide(jeu.getEquipe2().getListe().get(0), jeu.getPlateauDeJeu().getGrille()).peutSeDeplacer();
			
			if(peutAttaquer && peutSeDeplacer){
				new DeplacerOuAttaquer(0, robot, jeu);
			} else if(peutAttaquer){
				new DeplacerOuAttaquer(1, robot, jeu);
			} else if(peutSeDeplacer){
				new DeplacerOuAttaquer(2, robot, jeu);				
			}
		}
		if(e.getSource().equals(jeu.getBouton1Equipe2())){
			Robot robot = jeu.getEquipe2().getListe().get(1);
			boolean peutAttaquer = new DeplacementOuAttaqueValide(jeu.getEquipe2().getListe().get(1), jeu.getPlateauDeJeu().getGrille()).peutAttaquer();
			boolean peutSeDeplacer = new DeplacementOuAttaqueValide(jeu.getEquipe2().getListe().get(1), jeu.getPlateauDeJeu().getGrille()).peutSeDeplacer();
			
			if(peutAttaquer && peutSeDeplacer){
				new DeplacerOuAttaquer(0, robot, jeu);
			} else if(peutAttaquer){
				new DeplacerOuAttaquer(1, robot, jeu);
			} else if(peutSeDeplacer){
				new DeplacerOuAttaquer(2, robot, jeu);				
			}
		}
		if(e.getSource().equals(jeu.getBouton2Equipe2())){
			Robot robot = jeu.getEquipe2().getListe().get(2);
			boolean peutAttaquer = new DeplacementOuAttaqueValide(jeu.getEquipe2().getListe().get(2), jeu.getPlateauDeJeu().getGrille()).peutAttaquer();
			boolean peutSeDeplacer = new DeplacementOuAttaqueValide(jeu.getEquipe2().getListe().get(2), jeu.getPlateauDeJeu().getGrille()).peutSeDeplacer();
			
			if(peutAttaquer && peutSeDeplacer){
				new DeplacerOuAttaquer(0, robot, jeu);
			} else if(peutAttaquer){
				new DeplacerOuAttaquer(1, robot, jeu);
			} else if(peutSeDeplacer){
				new DeplacerOuAttaquer(2, robot, jeu);				
			}
		}
		if(e.getSource().equals(jeu.getBouton3Equipe2())){
			Robot robot = jeu.getEquipe2().getListe().get(3);
			boolean peutAttaquer = new DeplacementOuAttaqueValide(jeu.getEquipe2().getListe().get(3), jeu.getPlateauDeJeu().getGrille()).peutAttaquer();
			boolean peutSeDeplacer = new DeplacementOuAttaqueValide(jeu.getEquipe2().getListe().get(3), jeu.getPlateauDeJeu().getGrille()).peutSeDeplacer();
			
			if(peutAttaquer && peutSeDeplacer){
				new DeplacerOuAttaquer(0, robot, jeu);
			} else if(peutAttaquer){
				new DeplacerOuAttaquer(1, robot, jeu);
			} else if(peutSeDeplacer){
				new DeplacerOuAttaquer(2, robot, jeu);				
			}
		}
		if(e.getSource().equals(jeu.getBouton4Equipe2())){
			Robot robot = jeu.getEquipe2().getListe().get(4);
			boolean peutAttaquer = new DeplacementOuAttaqueValide(jeu.getEquipe2().getListe().get(4), jeu.getPlateauDeJeu().getGrille()).peutAttaquer();
			boolean peutSeDeplacer = new DeplacementOuAttaqueValide(jeu.getEquipe2().getListe().get(4), jeu.getPlateauDeJeu().getGrille()).peutSeDeplacer();
			
			if(peutAttaquer && peutSeDeplacer){
				new DeplacerOuAttaquer(0, robot, jeu);
			} else if(peutAttaquer){
				new DeplacerOuAttaquer(1, robot, jeu);
			} else if(peutSeDeplacer){
				new DeplacerOuAttaquer(2, robot, jeu);				
			}
		}
	}

}
