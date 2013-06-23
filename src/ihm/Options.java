package ihm;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class Options extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MenuPrincipal menuPrincipal;
	
	private JPanel panelRetro, panelRetroCase, panelModeDeJeu, panelModeDeJeuCase, panelConfigurationClavier, panelRetour, panelPrincipal;
	private JLabel modeRetro, modeDeJeu;
	private JButton activer, desactiver, clavier, souris, configurationClavier, retour;
	private ActionListener listener = new OptionsButtonListener(this);
	
	public Options(MenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
		
		panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new GridLayout(8,1,15,0));
		panelRetro = this.buildPanelRetro();
		panelRetro.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		panelRetroCase = this.buildPanelRetroCase();
		panelModeDeJeu = this.buildPanelModeDeJeu();
		panelModeDeJeu.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		panelModeDeJeuCase = this.buildPanelModeDeJeuCase();
		panelConfigurationClavier = this.buildPanelConfigurationClavier();
		panelRetour = this.buildPanelRetour();
		
		this.panelPrincipal.add(panelRetro);
		this.panelPrincipal.add(panelRetroCase);
		this.panelPrincipal.add(new JPanel());
		this.panelPrincipal.add(panelModeDeJeu);
		this.panelPrincipal.add(panelModeDeJeuCase);
		this.panelPrincipal.add(new JPanel());
		this.panelPrincipal.add(panelConfigurationClavier);
		this.panelPrincipal.add(panelRetour);
		this.getContentPane().add(panelPrincipal);
		
		this.setTitle("Options");
		this.setSize(700, 700);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		activer.addActionListener(listener);
		desactiver.addActionListener(listener);
		souris.addActionListener(listener);
		clavier.addActionListener(listener);
		configurationClavier.addActionListener(listener);
		retour.addActionListener(listener);
	}
	
	/*
	 * Construction du panel Retro
	 */
	
	public JPanel buildPanelRetro(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,1));
		
		if(!menuPrincipal.isRetro()){
			modeRetro = new JLabel("Mode rétro défini sur : désactivé");
		} else {
			modeRetro = new JLabel("Mode rétro défini sur : activé");
		}
		
		modeRetro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		
		
		panel.add(modeRetro);
	
		return panel;
	}
	
	/*
	 * Construction du panel du RetroCase
	 */

	public JPanel buildPanelRetroCase(){
		JPanel panel = new JPanel();
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();
		panel.setLayout(new GridLayout(1,5));
		
		activer = new JButton("Activer");
		desactiver = new JButton("Désactiver");
		
		panel.add(label1);
		panel.add(activer);
		panel.add(label2);
		panel.add(desactiver);
		panel.add(label3);
	
		return panel;
	}
	
	public JPanel buildPanelModeDeJeu(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,1));
		
		modeDeJeu = new JLabel("Mode de jeu défini sur : souris");
		modeDeJeu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		
		
		panel.add(modeDeJeu);

		return panel;
	}
	
	public JPanel buildPanelModeDeJeuCase(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,5));
		
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();
		
		
		clavier = new JButton("Clavier");
		souris = new JButton("Souris");
		
		panel.add(label1);
		panel.add(clavier);
		panel.add(label2);
		panel.add(souris);
		panel.add(label3);
		
		
		return panel;
	}
	
	public JPanel buildPanelConfigurationClavier(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,5));
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		
		configurationClavier = new JButton("Configuration Clavier");
		
		panel.add(label1);
		panel.add(configurationClavier);
		panel.add(label2);
		
		return panel;
	}
	
	public JPanel buildPanelRetour(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,5,15, 15));
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();
		JLabel label4 = new JLabel();
		
		retour = new JButton("Retour");
		
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		panel.add(retour);
		
		return panel;
	}

	public MenuPrincipal getMenuPrincipal() {
		return menuPrincipal;
	}

	public void setMenuPrincipal(MenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}

	public JPanel getPanelRetro() {
		return panelRetro;
	}

	public void setPanelRetro(JPanel panelRetro) {
		this.panelRetro = panelRetro;
	}

	public JPanel getPanelRetroCase() {
		return panelRetroCase;
	}

	public void setPanelRetroCase(JPanel panelRetroCase) {
		this.panelRetroCase = panelRetroCase;
	}

	public JPanel getPanelModeDeJeu() {
		return panelModeDeJeu;
	}

	public void setPanelModeDeJeu(JPanel panelModeDeJeu) {
		this.panelModeDeJeu = panelModeDeJeu;
	}

	public JPanel getPanelModeDeJeuCase() {
		return panelModeDeJeuCase;
	}

	public void setPanelModeDeJeuCase(JPanel panelModeDeJeuCase) {
		this.panelModeDeJeuCase = panelModeDeJeuCase;
	}

	public JPanel getPanelConfigurationClavier() {
		return panelConfigurationClavier;
	}

	public void setPanelConfigurationClavier(JPanel panelConfigurationClavier) {
		this.panelConfigurationClavier = panelConfigurationClavier;
	}

	public JPanel getPanelRetour() {
		return panelRetour;
	}

	public void setPanelRetour(JPanel panelRetour) {
		this.panelRetour = panelRetour;
	}

	public JPanel getPanelPrincipal() {
		return panelPrincipal;
	}

	public void setPanelPrincipal(JPanel panelPrincipal) {
		this.panelPrincipal = panelPrincipal;
	}

	public JLabel getModeRetro() {
		return modeRetro;
	}

	public void setModeRetro(JLabel modeRetro) {
		this.modeRetro = modeRetro;
	}

	public JLabel getModeDeJeu() {
		return modeDeJeu;
	}

	public void setModeDeJeu(JLabel modeDeJeu) {
		this.modeDeJeu = modeDeJeu;
	}

	public JButton getActiver() {
		return activer;
	}

	public void setActiver(JButton activer) {
		this.activer = activer;
	}

	public JButton getDesactiver() {
		return desactiver;
	}

	public void setDesactiver(JButton desactiver) {
		this.desactiver = desactiver;
	}

	public JButton getClavier() {
		return clavier;
	}

	public void setClavier(JButton clavier) {
		this.clavier = clavier;
	}

	public JButton getSouris() {
		return souris;
	}

	public void setSouris(JButton souris) {
		this.souris = souris;
	}

	public JButton getConfigurationClavier() {
		return configurationClavier;
	}

	public void setConfigurationClavier(JButton configurationClavier) {
		this.configurationClavier = configurationClavier;
	}

	public JButton getRetour() {
		return retour;
	}

	public void setRetour(JButton retour) {
		this.retour = retour;
	}

	public ActionListener getListener() {
		return listener;
	}

	public void setListener(ActionListener listener) {
		this.listener = listener;
	}
	
}
