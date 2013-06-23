package ihm;

import game.VirtualWar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JOptionPane;

public class MenuPrincipalButtonListener implements ActionListener {

	private MenuPrincipal menuPrincipal;
	
	public MenuPrincipalButtonListener(MenuPrincipal menuPrincipal) {
		// TODO Auto-generated constructor stub
		this.menuPrincipal = menuPrincipal;
	}
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(menuPrincipal.getJouer())){
			new ChoixParametrageDeJeu(menuPrincipal.isRetro());
		}
		if(e.getSource().equals(menuPrincipal.getPartieRapide())){
			String tireur = "Tireur";
			String piegeur = "Piegeur";
			String tank = "Char";
			
			String[] typesRobotsEquipe1 = new String[5];
			String[] typesRobotsEquipe2 = new String[5];
			
			int alea;
			
			for(int i=0 ; i < 5 ; i++){
				Random r = new Random();
				alea = r.nextInt(3);
				if(alea == 0){
					typesRobotsEquipe1[i] = tireur;
				}
				if(alea == 1){
					typesRobotsEquipe1[i] = piegeur;
				}
				if(alea == 2){
					typesRobotsEquipe1[i] = tank;
				}
			}
			for(int i=0 ; i < 5 ; i++){
				Random r = new Random();
				alea = r.nextInt(3);
				if(alea == 0){
					typesRobotsEquipe2[i] = tireur;
				}
				if(alea == 1){
					typesRobotsEquipe2[i] = piegeur;
				}
				if(alea == 2){
					typesRobotsEquipe2[i] = tank;
				}
			}
			
			new VirtualWar("Jeu manuel", "IA - Niveau complexe", 5, typesRobotsEquipe1, typesRobotsEquipe2, menuPrincipal.isRetro());
		}
		if(e.getSource().equals(menuPrincipal.getStats())){
			new Stats();
		}
		if(e.getSource().equals(menuPrincipal.getOptions())){
			new Options(menuPrincipal);
		}
		if(e.getSource().equals(menuPrincipal.getCredits())){
			JOptionPane.showMessageDialog(menuPrincipal, "Créé par La Source\nEtudiants en DUT 1ère année\nIUT Lille 'A' - Université Lille 1", "À propos de : Virtual War", JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource().equals(menuPrincipal.getQuitter())){
			menuPrincipal.disable();
			new Quitter(menuPrincipal);
		}
	}

}
