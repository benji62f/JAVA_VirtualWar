package ihm;

import game.VirtualWar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ChoixParametrageDeJeuButtonListener implements ActionListener {

	private ChoixParametrageDeJeu param;
	
	public ChoixParametrageDeJeuButtonListener(ChoixParametrageDeJeu param) {
		// TODO Auto-generated constructor stub
		this.param = param;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/*
		 * Si un bouton de décrémentation de compteur a été cliqué (compteur : nb de Robots)
		 */
		if(e.getSource().equals(param.getNbTireursEquipe1Moins())){
			if(Integer.parseInt(param.getNbTireursEquipe1().getText()) > 0){
				int newValue = Integer.parseInt(param.getNbTireursEquipe1().getText())-1;
				param.getNbTireursEquipe1().setText(""+newValue);
			}
		}
		if(e.getSource().equals(param.getNbTireursEquipe2Moins())){
			if(Integer.parseInt(param.getNbTireursEquipe2().getText()) > 0){
				int newValue = Integer.parseInt(param.getNbTireursEquipe2().getText())-1;
				param.getNbTireursEquipe2().setText(""+newValue);
			}
		}
		if(e.getSource().equals(param.getNbPiegeursEquipe1Moins())){
			if(Integer.parseInt(param.getNbPiegeursEquipe1().getText()) > 0){
				int newValue = Integer.parseInt(param.getNbPiegeursEquipe1().getText())-1;
				param.getNbPiegeursEquipe1().setText(""+newValue);
			}
		}
		if(e.getSource().equals(param.getNbPiegeursEquipe2Moins())){
			if(Integer.parseInt(param.getNbPiegeursEquipe2().getText()) > 0){
				int newValue = Integer.parseInt(param.getNbPiegeursEquipe2().getText())-1;
				param.getNbPiegeursEquipe2().setText(""+newValue);
			}
		}
		if(e.getSource().equals(param.getNbTanksEquipe1Moins())){
			if(Integer.parseInt(param.getNbTanksEquipe1().getText()) > 0){
				int newValue = Integer.parseInt(param.getNbTanksEquipe1().getText())-1;
				param.getNbTanksEquipe1().setText(""+newValue);
			}
		}
		if(e.getSource().equals(param.getNbTanksEquipe2Moins())){
			if(Integer.parseInt(param.getNbTanksEquipe2().getText()) > 0){
				int newValue = Integer.parseInt(param.getNbTanksEquipe2().getText())-1;
				param.getNbTanksEquipe2().setText(""+newValue);
			}
		}
		
		/*
		 * Si un bouton d'incrémentation de compteur a été cliqué (compteur : nb de Robots)
		 */
		if(e.getSource().equals(param.getNbTireursEquipe1Plus())){
			if(Integer.parseInt(param.getNbTireursEquipe1().getText()) < 5){
				int newValue = Integer.parseInt(param.getNbTireursEquipe1().getText())+1;
				param.getNbTireursEquipe1().setText(""+newValue);
			}
		}
		if(e.getSource().equals(param.getNbTireursEquipe2Plus())){
			if(Integer.parseInt(param.getNbTireursEquipe2().getText()) < 5){
				int newValue = Integer.parseInt(param.getNbTireursEquipe2().getText())+1;
				param.getNbTireursEquipe2().setText(""+newValue);
			}
		}
		if(e.getSource().equals(param.getNbPiegeursEquipe1Plus())){
			if(Integer.parseInt(param.getNbPiegeursEquipe1().getText()) < 5){
				int newValue = Integer.parseInt(param.getNbPiegeursEquipe1().getText())+1;
				param.getNbPiegeursEquipe1().setText(""+newValue);
			}
		}
		if(e.getSource().equals(param.getNbPiegeursEquipe2Plus())){
			if(Integer.parseInt(param.getNbPiegeursEquipe2().getText()) < 5){
				int newValue = Integer.parseInt(param.getNbPiegeursEquipe2().getText())+1;
				param.getNbPiegeursEquipe2().setText(""+newValue);
			}
		}
		if(e.getSource().equals(param.getNbTanksEquipe1Plus())){
			if(Integer.parseInt(param.getNbTanksEquipe1().getText()) < 5){
				int newValue = Integer.parseInt(param.getNbTanksEquipe1().getText())+1;
				param.getNbTanksEquipe1().setText(""+newValue);
			}
		}
		if(e.getSource().equals(param.getNbTanksEquipe2Plus())){
			if(Integer.parseInt(param.getNbTanksEquipe2().getText()) < 5){
				int newValue = Integer.parseInt(param.getNbTanksEquipe2().getText())+1;
				param.getNbTanksEquipe2().setText(""+newValue);
			}
		}
		
		/*
		 * Si le bouton OK est pressé
		 */
		if(e.getSource().equals(param.getOk())){
			int nbTireursEquipe1, nbPiegeursEquipe1, nbTanksEquipe1;
			int somme1;
			int nbTireursEquipe2, nbPiegeursEquipe2, nbTanksEquipe2;
			int somme2;
			
			nbTireursEquipe1 = Integer.parseInt(param.getNbTireursEquipe1().getText());
			nbPiegeursEquipe1 = Integer.parseInt(param.getNbPiegeursEquipe1().getText());
			nbTanksEquipe1 = Integer.parseInt(param.getNbTanksEquipe1().getText());
			somme1 = nbTireursEquipe1+nbPiegeursEquipe1+nbTanksEquipe1;
			nbTireursEquipe2 = Integer.parseInt(param.getNbTireursEquipe2().getText());
			nbPiegeursEquipe2 = Integer.parseInt(param.getNbPiegeursEquipe2().getText());
			nbTanksEquipe2 = Integer.parseInt(param.getNbTanksEquipe2().getText());
			somme2 = nbTireursEquipe2+nbPiegeursEquipe2+nbTanksEquipe2;
			
			if(somme1==param.nbRobotsParEquipe && somme2==param.nbRobotsParEquipe){
				param.typesRobotsEquipe1 = new String[param.nbRobotsParEquipe];
				int index = 0;
				for(int i=0 ; i < nbTireursEquipe1 ; i++){
					param.typesRobotsEquipe1[index] = "Tireur";
					index++;
				}
				for(int i=0 ; i < nbPiegeursEquipe1 ; i++){
					param.typesRobotsEquipe1[index] = "Piegeur";
					index++;
				}
				for(int i=0 ; i < nbTanksEquipe1 ; i++){
					param.typesRobotsEquipe1[index] = "Char";
					index++;
				}
				
				param.typesRobotsEquipe2 = new String[param.nbRobotsParEquipe];
				index = 0;
				for(int i=0 ; i < nbTireursEquipe2 ; i++){
					param.typesRobotsEquipe2[index] = "Tireur";
					index++;
				}
				for(int i=0 ; i < nbPiegeursEquipe2 ; i++){
					param.typesRobotsEquipe2[index] = "Piegeur";
					index++;
				}
				for(int i=0 ; i < nbTanksEquipe2 ; i++){
					param.typesRobotsEquipe2[index] = "Char";
					index++;
				}
				
				/*
				 * Affichage des paramètres saisis dans System.out
				 */
				System.out.println("---- Paramètres saisis ----\n\nNombre de robots pas équipe : "+param.nbRobotsParEquipe+"\n");
				for(int i=0 ; i < param.typesRobotsEquipe1.length ; i++){
					System.out.println("Robot équipe 1 : "+param.typesRobotsEquipe1[i]);
				}
				System.out.println("");
				for(int i=0 ; i < param.typesRobotsEquipe2.length ; i++){
					System.out.println("Robot équipe 2 : "+param.typesRobotsEquipe2[i]);
				}
				System.out.println("\n");
				
				System.out.println("Type de jeu / Equipe 1 : "+param.choixDeJeuEquipe1);
				System.out.println("Type de jeu / Equipe 2 : "+param.choixDeJeuEquipe2);
				
				/*
				 * Lance le jeu avec les paramètres saisis par l'utilisateur
				 */
				param.dispose();
				new VirtualWar(param.choixDeJeuEquipe1, param.choixDeJeuEquipe2, param.nbRobotsParEquipe, param.typesRobotsEquipe1, param.typesRobotsEquipe2, param.isRetro());
			} else {
    		    JOptionPane.showMessageDialog(param, "Veuillez définir un total de "+param.nbRobotsParEquipe+" robots par équipes.", "Avertissement", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
