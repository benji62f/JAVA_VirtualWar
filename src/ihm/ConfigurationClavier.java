package ihm;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConfigurationClavier extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel touches, tirer, pieger;
	private JTextField textTirer, textPieger;
	private JPanel panelPrincipal;
	
	public ConfigurationClavier(){
		touches = new JLabel("Touches");
		tirer = new JLabel("Tirer");
		pieger = new JLabel("Pieger");
		
		panelPrincipal = new JPanel();
		this.buildEnTete();
		this.getContentPane().add(panelPrincipal);
		
		this.setBounds(200, 200, 700, 700);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	public void buildEnTete(){
		GridBagLayout repartiteur = new GridBagLayout();
		JPanel panel = new JPanel();
		panelPrincipal.setLayout(repartiteur);
		GridBagConstraints contraintes;
		
		contraintes = new GridBagConstraints();
		contraintes.gridx = 3;
		contraintes.gridy = 3;
		contraintes.gridheight = 5;
		contraintes.gridwidth = 5;
		contraintes.fill = GridBagConstraints.BOTH;
		
		repartiteur.setConstraints(panel, contraintes);
		panelPrincipal.add(panel);
		
	}
	
	public void buildCentre(){
		GridBagLayout repartiteur = new GridBagLayout();
		JPanel panel = new JPanel();
		panelPrincipal.setLayout(repartiteur);
		GridBagConstraints contraintes = new GridBagConstraints();
		
		contraintes.gridx = 50;
		contraintes.gridy = 0;
		contraintes.gridheight = 2;
		contraintes.gridwidth = 2;
		contraintes.fill = GridBagConstraints.BOTH;
		
		repartiteur.setConstraints(panel, contraintes);
		panelPrincipal.add(panel);
	}

	public JLabel getTouches() {
		return touches;
	}

	public void setTouches(JLabel touches) {
		this.touches = touches;
	}

	public JLabel getTirer() {
		return tirer;
	}

	public void setTirer(JLabel tirer) {
		this.tirer = tirer;
	}

	public JLabel getPieger() {
		return pieger;
	}

	public void setPieger(JLabel pieger) {
		this.pieger = pieger;
	}

	public JTextField getTextTirer() {
		return textTirer;
	}

	public void setTextTirer(JTextField textTirer) {
		this.textTirer = textTirer;
	}

	public JTextField getTextPieger() {
		return textPieger;
	}

	public void setTextPieger(JTextField textPieger) {
		this.textPieger = textPieger;
	}

	public JPanel getPanelPrincipal() {
		return panelPrincipal;
	}

	public void setPanelPrincipal(JPanel panelPrincipal) {
		this.panelPrincipal = panelPrincipal;
	}
	
}
