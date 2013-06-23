package ihm;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ChoixParametrageDeJeu extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean retro;
	
	private JPanel panel;
	
	private JLabel nbTireursEquipe1, nbPiegeursEquipe1, nbTanksEquipe1;
	private JLabel nbTireursEquipe2, nbPiegeursEquipe2, nbTanksEquipe2;
	private JButton ok;
	
	/*
	 * Boutons d'incrémentation / de décrémentation du nombre de robots
	 */
	private JButton nbTireursEquipe1Moins = new JButton("-");
	private JButton nbPiegeursEquipe1Moins = new JButton("-");
	private JButton nbTanksEquipe1Moins = new JButton("-");
	
	private JButton nbTireursEquipe1Plus = new JButton("+");
	private JButton nbPiegeursEquipe1Plus = new JButton("+");
	private JButton nbTanksEquipe1Plus = new JButton("+");
	
	private JButton nbTireursEquipe2Moins = new JButton("-");
	private JButton nbPiegeursEquipe2Moins = new JButton("-");
	private JButton nbTanksEquipe2Moins = new JButton("-");
	
	private JButton nbTireursEquipe2Plus = new JButton("+");
	private JButton nbPiegeursEquipe2Plus = new JButton("+");
	private JButton nbTanksEquipe2Plus = new JButton("+");
	
	private ActionListener listener = new ChoixParametrageDeJeuButtonListener(this);
	
	/*
	 * Paramètres de jeu stockés ici puis transmis au constructeur de jeu VirtualWar
	 */
	String choixDeJeuEquipe1;
	String choixDeJeuEquipe2;
	int nbRobotsParEquipe;
	String[] typesRobotsEquipe1;
	String[] typesRobotsEquipe2;
	
	public ChoixParametrageDeJeu(boolean retro){
		
		this.setRetro(retro);
		
		panel = this.buildPanel();
		
		this.getContentPane().add(panel);
		this.setTitle("Paramètres de jeu");
		this.setBounds(200, 200, 1000, 500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		
		/*
		 * Ajout des listeners
		 */
		nbTireursEquipe1Moins.addActionListener(listener);
		nbTireursEquipe1Plus.addActionListener(listener);
		nbPiegeursEquipe1Moins.addActionListener(listener);
		nbPiegeursEquipe1Plus.addActionListener(listener);
		nbTanksEquipe1Moins.addActionListener(listener);
		nbTanksEquipe1Plus.addActionListener(listener);
		
		nbTireursEquipe2Moins.addActionListener(listener);
		nbTireursEquipe2Plus.addActionListener(listener);
		nbPiegeursEquipe2Moins.addActionListener(listener);
		nbPiegeursEquipe2Plus.addActionListener(listener);
		nbTanksEquipe2Moins.addActionListener(listener);
		nbTanksEquipe2Plus.addActionListener(listener);
		
		ok.addActionListener(listener);
	}
	
	public JPanel buildPanel(){
		/*
		 * Panel conteneur sur toute la fenetre
		 */
		JPanel framePanel = new JPanel();
		framePanel.setLayout(new GridLayout(3,1));

		/*
		 * Panel contenant bouton OK
		 */
		JPanel panelOK = new JPanel();
		panelOK.setLayout(new GridLayout(1,3));
		ok = new JButton("Lancer la partie !");
		panelOK.add(new JLabel());
		panelOK.add(ok);
		panelOK.add(new JLabel());
		
		/*
		 * Panel du haut
		 */
		JPanel frameTop = new JPanel();
		frameTop.setLayout(new GridLayout(3,1));
		JLabel nom = new JLabel("Veuillez sélectionner le nombre de robots par équipe :");
		nom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		nbRobotsParEquipe = 3;
		final int SLIDER_MIN = 1;
		final int SLIDER_MAX = 5;
		final int SLIDER_INIT = 3;
		final JSlider nbRobotsParEquipeSlider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN, SLIDER_MAX, SLIDER_INIT);
		nbRobotsParEquipeSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                ChoixParametrageDeJeu.this.nbRobotsParEquipe = nbRobotsParEquipeSlider.getValue();
            }
        });
	    nbRobotsParEquipeSlider.setMinorTickSpacing(1);
	    nbRobotsParEquipeSlider.setMajorTickSpacing(1);
	    nbRobotsParEquipeSlider.setPaintTicks(true);
	    nbRobotsParEquipeSlider.setPaintLabels(true);
	    nbRobotsParEquipeSlider.setLabelTable(nbRobotsParEquipeSlider.createStandardLabels(1));
		frameTop.add(nom);
		frameTop.add(nbRobotsParEquipeSlider);
		frameTop.add(panelOK);
		
		/*
		 * Panel du milieu / cote gauche
		 */
		JPanel panelEquipe1Top = new JPanel();
		panelEquipe1Top.setLayout(new GridLayout(3,1));
		JLabel equipe1 = new JLabel("Equipe 1");
		equipe1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		choixDeJeuEquipe1 = "Jeu manuel";
		final JComboBox<String> typePartieEquipe1 = new JComboBox<String>();
		typePartieEquipe1.addItem("Jeu manuel");
		//typePartieEquipe1.addItem("IA - Niveau simple");
		//typePartieEquipe1.addItem("IA - Niveau complexe");
		typePartieEquipe1.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				choixDeJeuEquipe1 = typePartieEquipe1.getSelectedItem().toString();
			}
		});
		panelEquipe1Top.add(new JLabel());
		panelEquipe1Top.add(equipe1);
		panelEquipe1Top.add(typePartieEquipe1);
				
		/*
		 * Panel du milieu / cote droit
		 */
		JPanel panelEquipe2Top = new JPanel();
		panelEquipe2Top.setLayout(new GridLayout(3,1));
		JLabel equipe2 = new JLabel("Equipe 2");
		equipe2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		choixDeJeuEquipe2 = "Jeu manuel";
		final JComboBox<String> typePartieEquipe2 = new JComboBox<String>();
		typePartieEquipe2.addItem("Jeu manuel");
		typePartieEquipe2.addItem("IA - Niveau simple");
		typePartieEquipe2.addItem("IA - Niveau complexe");
		typePartieEquipe2.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				choixDeJeuEquipe2 = typePartieEquipe2.getSelectedItem().toString();
			}
		});
		panelEquipe2Top.add(new JLabel());
		panelEquipe2Top.add(equipe2);
		panelEquipe2Top.add(typePartieEquipe2);
				
		/*
		 * Panel du milieu contenant les 2 côtés : frameMiddle
		 */
		JPanel frameMiddle = new JPanel();
		frameMiddle.setLayout(new GridLayout(1,2,20,0));
		frameMiddle.add(panelEquipe1Top);
		frameMiddle.add(panelEquipe2Top);
		
		/*
		 * Panel du bas / côté gauche
		 */
		JPanel panelEquipe1Bottom = new JPanel();
		panelEquipe1Bottom.setLayout(new GridLayout(3,3,10,0));	
		JLabel tireur, piegeur, tank;
		tireur = new JLabel("Nb. de tireur(s)");
		tireur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		piegeur = new JLabel("Nb. de piégeur(s)");
		piegeur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		tank = new JLabel("Nb. de char(s)");
		tank.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		panelEquipe1Bottom.add(tireur);
		panelEquipe1Bottom.add(piegeur);
		panelEquipe1Bottom.add(tank);
		nbTireursEquipe1Moins = new JButton("-");
		nbPiegeursEquipe1Moins = new JButton("-");
		nbTanksEquipe1Moins = new JButton("-");
		nbTireursEquipe1Plus = new JButton("+");
		nbPiegeursEquipe1Plus = new JButton("+");
		nbTanksEquipe1Plus = new JButton("+");
		nbTireursEquipe1 = new JLabel("0");
		nbPiegeursEquipe1 = new JLabel("0");
		nbTanksEquipe1 = new JLabel("0");
		nbTireursEquipe1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		nbPiegeursEquipe1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		nbTanksEquipe1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		
		JPanel tireursEquipe1 = new JPanel();
		tireursEquipe1.setLayout(new GridLayout(1,3));
		JPanel piegeursEquipe1 = new JPanel();
		piegeursEquipe1.setLayout(new GridLayout(1,3));
		JPanel tanksEquipe1 = new JPanel();
		tanksEquipe1.setLayout(new GridLayout(1,3));
		
		tireursEquipe1.add(nbTireursEquipe1Moins);
		tireursEquipe1.add(nbTireursEquipe1);
		tireursEquipe1.add(nbTireursEquipe1Plus);
		piegeursEquipe1.add(nbPiegeursEquipe1Moins);
		piegeursEquipe1.add(nbPiegeursEquipe1);
		piegeursEquipe1.add(nbPiegeursEquipe1Plus);
		tanksEquipe1.add(nbTanksEquipe1Moins);
		tanksEquipe1.add(nbTanksEquipe1);
		tanksEquipe1.add(nbTanksEquipe1Plus);
		
		panelEquipe1Bottom.add(tireursEquipe1);
		panelEquipe1Bottom.add(piegeursEquipe1);
		panelEquipe1Bottom.add(tanksEquipe1);
		panelEquipe1Bottom.add(new JLabel());
		
		/*
		 * Panel du bas / côté droit
		 */
		JPanel panelEquipe2Bottom = new JPanel();
		panelEquipe2Bottom.setLayout(new GridLayout(3,3,10,0));	
		JLabel tireur2, piegeur2, tank2;
		tireur2 = new JLabel("Nb. de tireur(s)");
		tireur2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		piegeur2 = new JLabel("Nb. de piégeur(s)");
		piegeur2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		tank2 = new JLabel("Nb. de char(s)");
		tank2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		panelEquipe2Bottom.add(tireur2);
		panelEquipe2Bottom.add(piegeur2);
		panelEquipe2Bottom.add(tank2);
		nbTireursEquipe2Moins = new JButton("-");
		nbPiegeursEquipe2Moins = new JButton("-");
		nbTanksEquipe2Moins = new JButton("-");
		nbTireursEquipe2Plus = new JButton("+");
		nbPiegeursEquipe2Plus = new JButton("+");
		nbTanksEquipe2Plus = new JButton("+");
		nbTireursEquipe2 = new JLabel("0");
		nbPiegeursEquipe2 = new JLabel("0");
		nbTanksEquipe2 = new JLabel("0");
		nbTireursEquipe2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		nbPiegeursEquipe2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		nbTanksEquipe2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		
		JPanel tireursEquipe2 = new JPanel();
		tireursEquipe2.setLayout(new GridLayout(1,3));
		JPanel piegeursEquipe2 = new JPanel();
		piegeursEquipe2.setLayout(new GridLayout(1,3));
		JPanel tanksEquipe2 = new JPanel();
		tanksEquipe2.setLayout(new GridLayout(1,3));
		
		tireursEquipe2.add(nbTireursEquipe2Moins);
		tireursEquipe2.add(nbTireursEquipe2);
		tireursEquipe2.add(nbTireursEquipe2Plus);
		piegeursEquipe2.add(nbPiegeursEquipe2Moins);
		piegeursEquipe2.add(nbPiegeursEquipe2);
		piegeursEquipe2.add(nbPiegeursEquipe2Plus);
		tanksEquipe2.add(nbTanksEquipe2Moins);
		tanksEquipe2.add(nbTanksEquipe2);
		tanksEquipe2.add(nbTanksEquipe2Plus);
		
		panelEquipe2Bottom.add(tireursEquipe2);
		panelEquipe2Bottom.add(piegeursEquipe2);
		panelEquipe2Bottom.add(tanksEquipe2);
		panelEquipe2Bottom.add(new JLabel());
		
		/*
		 * Panel du bas contenants les 2 côtés : frameBottom
		 */
		JPanel frameBottom = new JPanel();
		frameBottom.setLayout(new GridLayout(1,2,20,0));
		frameBottom.add(panelEquipe1Bottom);
		frameBottom.add(panelEquipe2Bottom);

		/*
		 * Panel conteneur sur toute la fenetre
		 */
		framePanel.setToolTipText("Cette fenêtre sert à définir les paramètres de jeu");
		framePanel.add(frameTop);
		framePanel.add(frameMiddle);
		framePanel.add(frameBottom);
		
		return framePanel;
	}

	/*
	 * Getters & Setters
	 */
	public JLabel getNbTireursEquipe1() {
		return nbTireursEquipe1;
	}

	public void setNbTireursEquipe1(JLabel nbTireursEquipe1) {
		this.nbTireursEquipe1 = nbTireursEquipe1;
	}

	public JLabel getNbPiegeursEquipe1() {
		return nbPiegeursEquipe1;
	}

	public void setNbPiegeursEquipe1(JLabel nbPiegeursEquipe1) {
		this.nbPiegeursEquipe1 = nbPiegeursEquipe1;
	}

	public JLabel getNbTanksEquipe1() {
		return nbTanksEquipe1;
	}

	public void setNbTanksEquipe1(JLabel nbTanksEquipe1) {
		this.nbTanksEquipe1 = nbTanksEquipe1;
	}

	public JLabel getNbTireursEquipe2() {
		return nbTireursEquipe2;
	}

	public void setNbTireursEquipe2(JLabel nbTireursEquipe2) {
		this.nbTireursEquipe2 = nbTireursEquipe2;
	}

	public JLabel getNbPiegeursEquipe2() {
		return nbPiegeursEquipe2;
	}

	public void setNbPiegeursEquipe2(JLabel nbPiegeursEquipe2) {
		this.nbPiegeursEquipe2 = nbPiegeursEquipe2;
	}

	public JLabel getNbTanksEquipe2() {
		return nbTanksEquipe2;
	}

	public void setNbTanksEquipe2(JLabel nbTanksEquipe2) {
		this.nbTanksEquipe2 = nbTanksEquipe2;
	}
	
	public JButton getOk() {
		return ok;
	}

	public void setOk(JButton ok) {
		this.ok = ok;
	}

	public JButton getNbTireursEquipe1Moins() {
		return nbTireursEquipe1Moins;
	}

	public void setNbTireursEquipe1Moins(JButton nbTireursEquipe1Moins) {
		this.nbTireursEquipe1Moins = nbTireursEquipe1Moins;
	}

	public JButton getNbPiegeursEquipe1Moins() {
		return nbPiegeursEquipe1Moins;
	}

	public void setNbPiegeursEquipe1Moins(JButton nbPiegeursEquipe1Moins) {
		this.nbPiegeursEquipe1Moins = nbPiegeursEquipe1Moins;
	}

	public JButton getNbTanksEquipe1Moins() {
		return nbTanksEquipe1Moins;
	}

	public void setNbTanksEquipe1Moins(JButton nbTanksEquipe1Moins) {
		this.nbTanksEquipe1Moins = nbTanksEquipe1Moins;
	}

	public JButton getNbTireursEquipe1Plus() {
		return nbTireursEquipe1Plus;
	}

	public void setNbTireursEquipe1Plus(JButton nbTireursEquipe1Plus) {
		this.nbTireursEquipe1Plus = nbTireursEquipe1Plus;
	}

	public JButton getNbPiegeursEquipe1Plus() {
		return nbPiegeursEquipe1Plus;
	}

	public void setNbPiegeursEquipe1Plus(JButton nbPiegeursEquipe1Plus) {
		this.nbPiegeursEquipe1Plus = nbPiegeursEquipe1Plus;
	}

	public JButton getNbTanksEquipe1Plus() {
		return nbTanksEquipe1Plus;
	}

	public void setNbTanksEquipe1Plus(JButton nbTanksEquipe1Plus) {
		this.nbTanksEquipe1Plus = nbTanksEquipe1Plus;
	}

	public JButton getNbTireursEquipe2Moins() {
		return nbTireursEquipe2Moins;
	}

	public void setNbTireursEquipe2Moins(JButton nbTireursEquipe2Moins) {
		this.nbTireursEquipe2Moins = nbTireursEquipe2Moins;
	}

	public JButton getNbPiegeursEquipe2Moins() {
		return nbPiegeursEquipe2Moins;
	}

	public void setNbPiegeursEquipe2Moins(JButton nbPiegeursEquipe2Moins) {
		this.nbPiegeursEquipe2Moins = nbPiegeursEquipe2Moins;
	}

	public JButton getNbTanksEquipe2Moins() {
		return nbTanksEquipe2Moins;
	}

	public void setNbTanksEquipe2Moins(JButton nbTanksEquipe2Moins) {
		this.nbTanksEquipe2Moins = nbTanksEquipe2Moins;
	}

	public JButton getNbTireursEquipe2Plus() {
		return nbTireursEquipe2Plus;
	}

	public void setNbTireursEquipe2Plus(JButton nbTireursEquipe2Plus) {
		this.nbTireursEquipe2Plus = nbTireursEquipe2Plus;
	}

	public JButton getNbPiegeursEquipe2Plus() {
		return nbPiegeursEquipe2Plus;
	}

	public void setNbPiegeursEquipe2Plus(JButton nbPiegeursEquipe2Plus) {
		this.nbPiegeursEquipe2Plus = nbPiegeursEquipe2Plus;
	}

	public JButton getNbTanksEquipe2Plus() {
		return nbTanksEquipe2Plus;
	}

	public void setNbTanksEquipe2Plus(JButton nbTanksEquipe2Plus) {
		this.nbTanksEquipe2Plus = nbTanksEquipe2Plus;
	}

	public String getChoixDeJeuEquipe1() {
		return choixDeJeuEquipe1;
	}

	public void setChoixDeJeuEquipe1(String choixDeJeuEquipe1) {
		this.choixDeJeuEquipe1 = choixDeJeuEquipe1;
	}

	public String getChoixDeJeuEquipe2() {
		return choixDeJeuEquipe2;
	}

	public void setChoixDeJeuEquipe2(String choixDeJeuEquipe2) {
		this.choixDeJeuEquipe2 = choixDeJeuEquipe2;
	}

	public int getNbRobotsParEquipe() {
		return nbRobotsParEquipe;
	}

	public void setNbRobotsParEquipe(int nbRobotsParEquipe) {
		this.nbRobotsParEquipe = nbRobotsParEquipe;
	}

	public String[] getTypesRobotsEquipe1() {
		return typesRobotsEquipe1;
	}

	public void setTypesRobotsEquipe1(String[] typesRobotsEquipe1) {
		this.typesRobotsEquipe1 = typesRobotsEquipe1;
	}

	public String[] getTypesRobotsEquipe2() {
		return typesRobotsEquipe2;
	}

	public void setTypesRobotsEquipe2(String[] typesRobotsEquipe2) {
		this.typesRobotsEquipe2 = typesRobotsEquipe2;
	}

	public boolean isRetro() {
		return retro;
	}

	public void setRetro(boolean retro) {
		this.retro = retro;
	}
	
}