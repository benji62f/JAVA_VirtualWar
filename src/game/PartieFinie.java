package game;

import javax.swing.JOptionPane;

public class PartieFinie {
	
	public PartieFinie(int equipe, VirtualWar jeu) {
		// TODO Auto-generated constructor stub
		if(equipe == 1){
			JOptionPane.showMessageDialog (null, "L'�quipe 2 a gagn�e !", "Message", JOptionPane.INFORMATION_MESSAGE);
			jeu.dispose();
		}
		if(equipe == 2){
			JOptionPane.showMessageDialog (null, "L'�quipe 1 a gagn�e !", "Message", JOptionPane.INFORMATION_MESSAGE);
			jeu.dispose();
		}
	}
}
