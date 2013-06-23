package ihm;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class ScreenConfigurationClavier extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal, panelTouches, panelTirer, panelTirerCase, panelPieger, panelPiegerCase, panelBoutonOK;
	private JLabel labelTouches, labelTirer, labelPieger;
	private JTextField textFieldTirer, textFieldPieger;
	private JButton boutonOK;
	
	public ScreenConfigurationClavier(){
		panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new GridLayout(4,1));
		textFieldPieger = new JTextField(); 
		textFieldTirer = new JTextField();
		this.build();
		this.getContentPane().add(panelPrincipal);
		this.setBounds(200, 200, 400, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	public void build(){
		/*
		 * Creation de dimension pour la taille de notre boutonOK et nos JTextField
		 */
		Dimension dimBoutonOK = new Dimension(50,50);
		Dimension dimTextFieldTirer = new Dimension(50,50);
		Dimension dimTextFieldPieger = new Dimension(50,50);
		
		/*
		 * initialisation des composants
		 */
		panelTouches = new JPanel();
		panelTirer = new JPanel();
		panelPieger = new JPanel();
		panelBoutonOK = new JPanel();
		
		labelTouches = new JLabel("Touches");
		labelTirer = new JLabel("Tirer");
		labelPieger = new JLabel("Pieger");
		
		boutonOK = new JButton("OK");
		
		/*
		 * Mise en place des layout pour nos panels
		 */
	
		panelTouches.setLayout(new GridLayout());
		panelTirer.setLayout(new GridLayout(1,4));
		panelPieger.setLayout(new GridLayout(1,4));
		panelBoutonOK.setLayout(new FlowLayout());
		
		/*
		 * mise en place des composants pour l'entete
		 */
		panelTouches.add(labelTouches);
		labelTouches.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		panelTouches.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));

		/*
		 * Mise en place des composants pour la partie "tirer"
		 */
		JPanel panelFieldTirer = new JPanel();
		panelFieldTirer.setLayout(new FlowLayout());
		panelFieldTirer.add(textFieldTirer);
		panelTirer.add(labelTirer);
		panelTirer.add(new JLabel());
		textFieldTirer.setPreferredSize(dimTextFieldTirer);
		labelTirer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		panelTirer.add(panelFieldTirer);
		panelTirer.add(new JLabel());

		/*
		 * Mise en place des composants pour la "pieger"
		 */
		JPanel panelFieldPieger = new JPanel();
		panelFieldPieger.setLayout(new FlowLayout());
		panelFieldPieger.add(textFieldPieger);
		panelPieger.add(labelPieger);
		panelPieger.add(new JLabel());
		textFieldPieger.setPreferredSize(dimTextFieldPieger);
		labelPieger.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		panelPieger.add(panelFieldPieger);
		panelPieger.add(new JLabel());
		
		/*
		 * Mise en place du boutonOK
		 */
		boutonOK.setPreferredSize(dimBoutonOK);
		panelBoutonOK.add(new JLabel());
		panelBoutonOK.add(boutonOK);
		panelBoutonOK.add(new JLabel());
		//panelBoutonOK.setPreferredSize(dim);

		panelPrincipal.add(panelTouches);
		panelPrincipal.add(panelTirer);
		panelPrincipal.add(panelPieger);
		panelPrincipal.add(panelBoutonOK);
	}

	public JPanel getPanelPrincipal() {
		return panelPrincipal;
	}

	public void setPanelPrincipal(JPanel panelPrincipal) {
		this.panelPrincipal = panelPrincipal;
	}

	public JPanel getPanelTouches() {
		return panelTouches;
	}

	public void setPanelTouches(JPanel panelTouches) {
		this.panelTouches = panelTouches;
	}

	public JPanel getPanelTirer() {
		return panelTirer;
	}

	public void setPanelTirer(JPanel panelTirer) {
		this.panelTirer = panelTirer;
	}

	public JPanel getPanelTirerCase() {
		return panelTirerCase;
	}

	public void setPanelTirerCase(JPanel panelTirerCase) {
		this.panelTirerCase = panelTirerCase;
	}

	public JPanel getPanelPieger() {
		return panelPieger;
	}

	public void setPanelPieger(JPanel panelPieger) {
		this.panelPieger = panelPieger;
	}

	public JPanel getPanelPiegerCase() {
		return panelPiegerCase;
	}

	public void setPanelPiegerCase(JPanel panelPiegerCase) {
		this.panelPiegerCase = panelPiegerCase;
	}

	public JPanel getPanelBoutonOK() {
		return panelBoutonOK;
	}

	public void setPanelBoutonOK(JPanel panelBoutonOK) {
		this.panelBoutonOK = panelBoutonOK;
	}

	public JLabel getLabelTouches() {
		return labelTouches;
	}

	public void setLabelTouches(JLabel labelTouches) {
		this.labelTouches = labelTouches;
	}

	public JLabel getLabelTirer() {
		return labelTirer;
	}

	public void setLabelTirer(JLabel labelTirer) {
		this.labelTirer = labelTirer;
	}

	public JLabel getLabelPieger() {
		return labelPieger;
	}

	public void setLabelPieger(JLabel labelPieger) {
		this.labelPieger = labelPieger;
	}

	public JTextField getTextFieldTirer() {
		return textFieldTirer;
	}

	public void setTextFieldTirer(JTextField textFieldTirer) {
		this.textFieldTirer = textFieldTirer;
	}

	public JTextField getTextFieldPieger() {
		return textFieldPieger;
	}

	public void setTextFieldPieger(JTextField textFieldPieger) {
		this.textFieldPieger = textFieldPieger;
	}

	public JButton getBoutonOK() {
		return boutonOK;
	}

	public void setBoutonOK(JButton boutonOK) {
		this.boutonOK = boutonOK;
	}
}
