package ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OptionsButtonListener implements ActionListener{

	private Options screenOptions;
	
	public OptionsButtonListener(Options screenOptions){
		this.screenOptions = screenOptions;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(screenOptions.getSouris())){
			this.screenOptions.getModeDeJeu().setText("Mode de jeu défini sur : souris");
		}
		if(e.getSource().equals(screenOptions.getClavier())){
			this.screenOptions.getModeDeJeu().setText("Mode de jeu défini sur : clavier");
		}
		if(e.getSource().equals(screenOptions.getActiver())){
			screenOptions.getMenuPrincipal().setRetro(true);
			this.screenOptions.getModeRetro().setText("Mode rétro défini sur : activé");
		}
		if(e.getSource().equals(screenOptions.getDesactiver())){
			screenOptions.getMenuPrincipal().setRetro(false);
			this.screenOptions.getModeRetro().setText("Mode rétro défini sur : désactivé");
		}
		if(e.getSource().equals(screenOptions.getConfigurationClavier())){
			new ScreenConfigurationClavier();
		}
		if(e.getSource().equals(screenOptions.getRetour())){
			screenOptions.dispose();
		}
	}
	
}
