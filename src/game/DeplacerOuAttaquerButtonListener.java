package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeplacerOuAttaquerButtonListener implements ActionListener {

	private DeplacerOuAttaquer choix;
	
	public DeplacerOuAttaquerButtonListener(DeplacerOuAttaquer choix) {
		// TODO Auto-generated constructor stub
		this.choix = choix;
	}
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(choix.getDeplacer())){
			new Deplacer(choix.getRobotEnCoursDeTraitement(), choix.getJeu());
			choix.dispose();
		}
		if(e.getSource().equals(choix.getAttaquer())){
			new Attaquer(choix.getRobotEnCoursDeTraitement(), choix.getJeu());
			choix.dispose();
		}
		if(e.getSource().equals(choix.getAnnuler())){
			choix.dispose();
			choix.getJeu().enable();
			choix.getJeu().toFront();
		}
	}

}
