package game;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.LineBorder;

import classes.*;

public class VirtualWar extends JFrame {
	
	private boolean retro;
	
	private String choixDeJeuEquipe1; 
	private String choixDeJeuEquipe2;
	private ActionListener listener = new VirtualWarButtonListener(this);

	private JLabel equipeQuiJoueDisplay = new JLabel("C'est au tour de l'équipe 1");
	private int equipeQuiJoue = 1;
	
	private JLabel robot0, robot1, robot2, robot3, robot4;
	private JLabel robot5, robot6, robot7, robot8, robot9;
	private JPanel robotsDisplay1, robotsDisplay2;
	
	private JButton bouton0Equipe1;
	private JButton bouton1Equipe1;
	private JButton bouton2Equipe1;
	private JButton bouton3Equipe1;
	private JButton bouton4Equipe1;

	private JButton bouton0Equipe2;
	private JButton bouton1Equipe2;
	private JButton bouton2Equipe2;
	private JButton bouton3Equipe2;
	private JButton bouton4Equipe2;
	
	private JButton passerTour;
	
	private JButton quitter = new JButton("Quitter la partie");
	
	private Equipe equipe1;
	private Equipe equipe2;
	private Plateau plateauDeJeu;
	
	private JPanel plateau;
	private JPanel indicateurs;
	private JPanel conteneurBoutons, boutons1, boutons2;
	private JSplitPane plateauEtIndicateurs;
	private JSplitPane virtualWarConteneur;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VirtualWar(String choixDeJeuEquipe1, String choixDeJeuEquipe2, int nbRobotsParEquipe, String[] typesRobotsEquipe1, String[] typesRobotsEquipe2, boolean retro) {
		
		this.retro = retro;
		
		/*
		 * Initialisation du plateau de jeu
		 */
		plateauDeJeu = new Plateau(16, 20); // 10,5 par defaut
		boolean valide = new PlateauValide(plateauDeJeu).agit(); // ici, la méthode agit() vérifie l'existance d'un chemin entre les 2 bases
		while (!valide) {
			plateauDeJeu = new Plateau(15, 18);
			valide = new PlateauValide(plateauDeJeu).agit();
		}
		this.choixDeJeuEquipe1=choixDeJeuEquipe1;
		this.choixDeJeuEquipe2=choixDeJeuEquipe2;

		equipe1 = new Equipe(1, plateauDeJeu.getGrille());
		equipe2 = new Equipe(2, plateauDeJeu.getGrille());
		Vue v1 = new Vue(1, plateauDeJeu, equipe1);
		Vue v2 = new Vue(2, plateauDeJeu, equipe2);
		for (int i = 0; i < nbRobotsParEquipe; i++) {
			equipe1.ajouterRobot(choixRobot(1, v1, typesRobotsEquipe1[i]));
		}
		for (int i = 0; i < nbRobotsParEquipe; i++) {
			equipe2.ajouterRobot(choixRobot(2, v2, typesRobotsEquipe2[i]));
		}
		plateau = this.genererPanelGrille(plateauDeJeu.getGrille(), 1);
		
		/*
		 * Initialisation du panel indicateurs de données de jeu
		 */
		indicateurs = new JPanel();
		
		robot0 = new JLabel();
		robot1 = new JLabel();
		robot2 = new JLabel();
		robot3 = new JLabel();
		robot4 = new JLabel();
		robot5 = new JLabel();
		robot6 = new JLabel();
		robot7 = new JLabel();
		robot8 = new JLabel();
		robot9 = new JLabel();
		robotsDisplay1 = new JPanel();
		robotsDisplay2 = new JPanel();
		robotsDisplay1.setLayout(new GridLayout(5,1));
		robotsDisplay2.setLayout(new GridLayout(5,1));
		
		boutons1 = this.genererBoutonsEquipe1(plateauDeJeu.getGrille(), equipe1);
		boutons2 = this.genererBoutonsEquipe2(plateauDeJeu.getGrille(), equipe2);
		conteneurBoutons = new JPanel();
		conteneurBoutons.add(boutons1);
		plateauEtIndicateurs = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, plateau, indicateurs);
		virtualWarConteneur = new JSplitPane(JSplitPane.VERTICAL_SPLIT, plateauEtIndicateurs, conteneurBoutons);
		initIndicateursPanel(robotsDisplay1);
		
		/*
		 * Mise en forme de la fenêtre
		 */
		this.getContentPane().add(virtualWarConteneur);
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Virtual War by La Source");
		this.setVisible(true);
		
		quitter.addActionListener(listener);
	}
	
	public JPanel genererPanelGrille(Cellule[][] grille, int equipe) {
		JPanel panel = new JPanel();
		if(!retro){
			panel.setBackground(new Color(6, 172, 7));
		} else {
			panel.setBackground(Color.GRAY);
		}
		panel.setLayout(new GridLayout(grille.length, grille[0].length));
		if(retro == false){
			for (int i = 0; i < grille.length; i++) {
				for (int j = 0; j < grille[0].length; j++) {
					if (grille[i][j].contientMine() == equipe) {
						if (equipe == 1) {
							panel.add(new JLabel(new ImageIcon(this.getClass().getResource("/img/Mine1.png"))));
						} else {
						panel.add(new JLabel(new ImageIcon(this.getClass().getResource("/img/Mine2.png"))));
						}
					} else if (grille[i][j].estBase() != 0) {
						if (grille[i][j].estBase() == 1) {
							panel.add(new JLabel(new ImageIcon(this.getClass().getResource("/img/Base1.png"))));
						} else {
							panel.add(new JLabel(new ImageIcon(this.getClass().getResource("/img/Base2.png"))));
						}
					} else if (grille[i][j].estObstacle()) {
						panel.add(new JLabel(new ImageIcon(this.getClass().getResource("/img/Obstacle.png"))));
					} else if (grille[i][j].getImage().equals("T")) {
						panel.add(new JLabel(new ImageIcon(this.getClass().getResource("/img/Tireur1.png"))));
					} else if (grille[i][j].getImage().equals("t")) {
						panel.add(new JLabel(new ImageIcon(this.getClass().getResource("/img/Tireur2.png"))));
					} else if (grille[i][j].getImage().equals("P")) {
						panel.add(new JLabel(new ImageIcon(this.getClass().getResource("/img/Piegeur1.png"))));
					} else if (grille[i][j].getImage().equals("p")) {
						panel.add(new JLabel(new ImageIcon(this.getClass().getResource("/img/Piegeur2.png"))));
					} else if (grille[i][j].getImage().equals("C")) {
						panel.add(new JLabel(new ImageIcon(this.getClass().getResource("/img/Char1.png"))));
					} else if (grille[i][j].getImage().equals("c")) {
						panel.add(new JLabel(new ImageIcon(this.getClass().getResource("/img/Char2.png"))));
					} else {
						panel.add(new JLabel(new ImageIcon(this.getClass().getResource("/img/CaseVide.png"))));
					}
				}
			}
		} else {
			for (int i = 0; i < grille.length; i++) {
				for (int j = 0; j < grille[0].length; j++) {
					if (grille[i][j].contientMine() == equipe) {
						if (equipe == 1) {
							panel.add(new JLabel(new ImageIcon(this.getClass().getResource("/img/Mine1Retro.png"))));
						} else {
						panel.add(new JLabel(new ImageIcon(this.getClass().getResource("/img/Mine2Retro.png"))));
						}
					} else if (grille[i][j].estBase() != 0) {
						if (grille[i][j].estBase() == 1) {
							panel.add(new JLabel(new ImageIcon(this.getClass().getResource("/img/Base1Retro.png"))));
						} else {
							panel.add(new JLabel(new ImageIcon(this.getClass().getResource("/img/Base2Retro.png"))));
						}
					} else if (grille[i][j].estObstacle()) {
						panel.add(new JLabel(new ImageIcon(this.getClass().getResource("/img/ObstacleRetro.png"))));
					} else if (grille[i][j].getImage().equals("T")) {
						panel.add(new JLabel(new ImageIcon(this.getClass().getResource("/img/Tireur1Retro.png"))));
					} else if (grille[i][j].getImage().equals("t")) {
						panel.add(new JLabel(new ImageIcon(this.getClass().getResource("/img/Tireur2Retro.png"))));
					} else if (grille[i][j].getImage().equals("P")) {
						panel.add(new JLabel(new ImageIcon(this.getClass().getResource("/img/Piegeur1Retro.png"))));
					} else if (grille[i][j].getImage().equals("p")) {
						panel.add(new JLabel(new ImageIcon(this.getClass().getResource("/img/Piegeur2Retro.png"))));
					} else if (grille[i][j].getImage().equals("C")) {
						panel.add(new JLabel(new ImageIcon(this.getClass().getResource("/img/Char1Retro.png"))));
					} else if (grille[i][j].getImage().equals("c")) {
						panel.add(new JLabel(new ImageIcon(this.getClass().getResource("/img/Char2Retro.png"))));
					} else {
						panel.add(new JLabel(new ImageIcon(this.getClass().getResource("/img/CaseVideRetro.png"))));
					}
				}
			}
		}
		return panel;
	}
	
	public JPanel genererBoutonsEquipe1(Cellule[][] grille, Equipe equipe){
		JPanel panelBoutons = new JPanel();
		boolean bouton = false;
		int nbRobots = 1;
		robotsDisplay1.removeAll();
		
		/*
		 * Vérifie les robots pouvants etre deplace ou attaquant
		 */
		for(int i = 0 ; i < equipe.getListe().size() ; i++){
			boolean peutAttaquer = new DeplacementOuAttaqueValide(equipe.getListe().get(i), grille).peutAttaquer();
			boolean peutSeDeplacer = new DeplacementOuAttaqueValide(equipe.getListe().get(i), grille).peutSeDeplacer();
			String type = equipe.getListe().get(i).getType();
			if(peutAttaquer || peutSeDeplacer){
				if(i == 0){
					bouton0Equipe1 = new JButton();
					bouton0Equipe1.setBorder(new LineBorder(Color.darkGray, 1));
					bouton0Equipe1 = genererIcone(bouton0Equipe1, type);
					robot5.setText("Robot n°"+nbRobots+"  :  "+equipe.getListe().get(i)+"");
					robotsDisplay1.add(robot5);
					bouton0Equipe1.addActionListener(listener);
					panelBoutons.add(bouton0Equipe1);
					bouton = true;
					nbRobots++;
				}
				if(i == 1){
					bouton1Equipe1 = new JButton();
					bouton1Equipe1.setBorder(new LineBorder(Color.darkGray, 1));
					bouton1Equipe1 = genererIcone(bouton1Equipe1, type);
					robot6.setText("Robot n°"+nbRobots+"  :  "+equipe.getListe().get(i)+"");
					robotsDisplay1.add(robot6);
					bouton1Equipe1.addActionListener(listener);
					panelBoutons.add(bouton1Equipe1);
					bouton = true;
					nbRobots++;
				}
				if(i == 2){
					bouton2Equipe1 = new JButton();
					bouton2Equipe1.setBorder(new LineBorder(Color.darkGray, 1));
					bouton2Equipe1 = genererIcone(bouton2Equipe1, type);
					robot7.setText("Robot n°"+nbRobots+"  :  "+equipe.getListe().get(i)+"");
					robotsDisplay1.add(robot7);
					bouton2Equipe1.addActionListener(listener);
					panelBoutons.add(bouton2Equipe1);
					bouton = true;
					nbRobots++;
				}
				if(i == 3){
					bouton3Equipe1 = new JButton();
					bouton3Equipe1.setBorder(new LineBorder(Color.darkGray, 1));
					bouton3Equipe1 =  genererIcone(bouton3Equipe1, type);
					robot8.setText("Robot n°"+nbRobots+"  :  "+equipe.getListe().get(i)+"");
					robotsDisplay1.add(robot8);
					bouton3Equipe1.addActionListener(listener);
					panelBoutons.add(bouton3Equipe1);
					bouton = true;
					nbRobots++;
				}
				if(i == 4){
					bouton4Equipe1 = new JButton();
					bouton4Equipe1.setBorder(new LineBorder(Color.darkGray, 1));
					bouton4Equipe1 = genererIcone(bouton4Equipe1, type);
					robot9.setText("Robot n°"+nbRobots+"  :  "+equipe.getListe().get(i)+"");
					robotsDisplay1.add(robot9);
					bouton4Equipe1.addActionListener(listener);
					panelBoutons.add(bouton4Equipe1);
					bouton = true;
					nbRobots++;
				}
			}
		}
		if(bouton == false){
			passerTour = new JButton("Passer le tour");
			passerTour.addActionListener(listener);
			panelBoutons.add(passerTour);
		}
		robotsDisplay1.repaint();
		return panelBoutons;
	}
	
	public JPanel genererBoutonsEquipe2(Cellule[][] grille, Equipe equipe){
		JPanel panelBoutons = new JPanel();
		boolean bouton = false;
		int nbRobots = 1;
		robotsDisplay2.removeAll();
		
		/*
		 * Vérifie les robots pouvants etre deplace ou attaquant
		 */
		for(int i = 0 ; i < equipe.getListe().size() ; i++){
			boolean peutAttaquer = new DeplacementOuAttaqueValide(equipe.getListe().get(i), grille).peutAttaquer();
			boolean peutSeDeplacer = new DeplacementOuAttaqueValide(equipe.getListe().get(i), grille).peutSeDeplacer();
			String type = equipe.getListe().get(i).getType();
			if(peutAttaquer || peutSeDeplacer){
				if(i == 0){
					bouton0Equipe2 = new JButton();
					bouton0Equipe2.setBorder(new LineBorder(Color.darkGray, 1));
					bouton0Equipe2 = genererIcone(bouton0Equipe2, type);
					robot0.setText("Robot n°"+nbRobots+"  :  "+equipe.getListe().get(i)+"");
					robotsDisplay2.add(robot0);
					bouton0Equipe2.addActionListener(listener);
					panelBoutons.add(bouton0Equipe2);
					bouton = true;
					nbRobots++;
				}
				if(i == 1){
					bouton1Equipe2 = new JButton();
					bouton1Equipe2.setBorder(new LineBorder(Color.darkGray, 1));
					bouton1Equipe2 = genererIcone(bouton1Equipe2, type);
					robot1.setText("Robot n°"+nbRobots+"  :  "+equipe.getListe().get(i)+"");
					robotsDisplay2.add(robot1);
					bouton1Equipe2.addActionListener(listener);
					panelBoutons.add(bouton1Equipe2);
					bouton = true;
					nbRobots++;
				}
				if(i == 2){
					bouton2Equipe2 = new JButton();
					bouton2Equipe2.setBorder(new LineBorder(Color.darkGray, 1));
					bouton2Equipe2 = genererIcone(bouton2Equipe2, type);
					robot2.setText("Robot n°"+nbRobots+"  :  "+equipe.getListe().get(i)+"");
					robotsDisplay2.add(robot2);
					bouton2Equipe2.addActionListener(listener);
					panelBoutons.add(bouton2Equipe2);
					bouton = true;
					nbRobots++;
				}
				if(i == 3){
					bouton3Equipe2 = new JButton();
					bouton3Equipe2.setBorder(new LineBorder(Color.darkGray, 1));
					bouton3Equipe2 =  genererIcone(bouton3Equipe2, type);
					robot3.setText("Robot n°"+nbRobots+"  :  "+equipe.getListe().get(i)+"");
					robotsDisplay2.add(robot3);
					bouton3Equipe2.addActionListener(listener);
					panelBoutons.add(bouton3Equipe2);
					bouton = true;
					nbRobots++;
				}
				if(i == 4){
					bouton4Equipe2 = new JButton();
					bouton4Equipe2.setBorder(new LineBorder(Color.darkGray, 1));
					bouton4Equipe2 = genererIcone(bouton4Equipe2, type);
					robot4.setText("Robot n°"+nbRobots+"  :  "+equipe.getListe().get(i)+"");
					robotsDisplay2.add(robot4);
					bouton4Equipe2.addActionListener(listener);
					panelBoutons.add(bouton4Equipe2);
					bouton = true;
					nbRobots++;
				}
			}
		}
		if(bouton == false){
			passerTour = new JButton("Passer le tour");
			passerTour.addActionListener(listener);
			panelBoutons.add(passerTour);
		}
		robotsDisplay2.repaint();
		return panelBoutons;
	}

	public static Robot choixRobot(int equipe, Vue v, String type) {
		Robot r = null;
		if (type.equals("Piegeur")) {
			r = new Piegeur(v, 0, 0, equipe);
		} else if (type.equals("Tireur")) {
			r = new Tireur(v, 0, 0, equipe);
		} else if (type.equals("Char")) {
			r = new Char(v, 0, 0, equipe);
		}
		return r;
	}
	
	public void initIndicateursPanel(JPanel robotsDisplay){
		indicateurs.removeAll();
		indicateurs.add(equipeQuiJoueDisplay);
		indicateurs.add(new JLabel("                                                                                                            "));	
		indicateurs.add(robotsDisplay);
		indicateurs.add(new JLabel("                                                                                                            "));	
		indicateurs.add(quitter);
		indicateurs.revalidate();
		indicateurs.repaint();
	}
	
	public JButton genererIcone(JButton bouton, String type){
		if(type.equals("Tireur")){
			if(!retro){
				bouton.setIcon(new ImageIcon(this.getClass().getResource("/img/BoutonTireur.png")));
			} else {
				bouton.setIcon(new ImageIcon(this.getClass().getResource("/img/BoutonTireurRetro.png")));
			}
		}
		if(type.equals("Piegeur")){
			if(!retro){
				bouton.setIcon(new ImageIcon(this.getClass().getResource("/img/BoutonMine.png")));
			} else {
				bouton.setIcon(new ImageIcon(this.getClass().getResource("/img/BoutonMineRetro.png")));
			}
		}
		if(type.equals("Char")){
			if(!retro){
				bouton.setIcon(new ImageIcon(this.getClass().getResource("/img/BoutonChar.png")));
			} else {
				bouton.setIcon(new ImageIcon(this.getClass().getResource("/img/BoutonCharRetro.png")));
			}
		}
		return bouton;
	}
	/*
	 * Getters & Setters
	 */

	public boolean isRetro() {
		return retro;
	}

	public void setRetro(boolean retro) {
		this.retro = retro;
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

	public ActionListener getListener() {
		return listener;
	}

	public void setListener(ActionListener listener) {
		this.listener = listener;
	}

	public JLabel getEquipeQuiJoueDisplay() {
		return equipeQuiJoueDisplay;
	}

	public void setEquipeQuiJoueDisplay(JLabel equipeQuiJoueDisplay) {
		this.equipeQuiJoueDisplay = equipeQuiJoueDisplay;
	}

	public int getEquipeQuiJoue() {
		return equipeQuiJoue;
	}

	public void setEquipeQuiJoue(int equipeQuiJoue) {
		this.equipeQuiJoue = equipeQuiJoue;
	}

	public JLabel getRobot0() {
		return robot0;
	}

	public void setRobot0(JLabel robot0) {
		this.robot0 = robot0;
	}

	public JLabel getRobot1() {
		return robot1;
	}

	public void setRobot1(JLabel robot1) {
		this.robot1 = robot1;
	}

	public JLabel getRobot2() {
		return robot2;
	}

	public void setRobot2(JLabel robot2) {
		this.robot2 = robot2;
	}

	public JLabel getRobot3() {
		return robot3;
	}

	public void setRobot3(JLabel robot3) {
		this.robot3 = robot3;
	}

	public JLabel getRobot4() {
		return robot4;
	}

	public void setRobot4(JLabel robot4) {
		this.robot4 = robot4;
	}

	public JLabel getRobot5() {
		return robot5;
	}

	public void setRobot5(JLabel robot5) {
		this.robot5 = robot5;
	}

	public JLabel getRobot6() {
		return robot6;
	}

	public void setRobot6(JLabel robot6) {
		this.robot6 = robot6;
	}

	public JLabel getRobot7() {
		return robot7;
	}

	public void setRobot7(JLabel robot7) {
		this.robot7 = robot7;
	}

	public JLabel getRobot8() {
		return robot8;
	}

	public void setRobot8(JLabel robot8) {
		this.robot8 = robot8;
	}

	public JLabel getRobot9() {
		return robot9;
	}

	public void setRobot9(JLabel robot9) {
		this.robot9 = robot9;
	}

	public JPanel getRobotsDisplay1() {
		return robotsDisplay1;
	}

	public void setRobotsDisplay1(JPanel robotsDisplay1) {
		this.robotsDisplay1 = robotsDisplay1;
	}

	public JPanel getRobotsDisplay2() {
		return robotsDisplay2;
	}

	public void setRobotsDisplay2(JPanel robotsDisplay2) {
		this.robotsDisplay2 = robotsDisplay2;
	}

	public JButton getBouton0Equipe1() {
		return bouton0Equipe1;
	}

	public void setBouton0Equipe1(JButton bouton0Equipe1) {
		this.bouton0Equipe1 = bouton0Equipe1;
	}

	public JButton getBouton1Equipe1() {
		return bouton1Equipe1;
	}

	public void setBouton1Equipe1(JButton bouton1Equipe1) {
		this.bouton1Equipe1 = bouton1Equipe1;
	}

	public JButton getBouton2Equipe1() {
		return bouton2Equipe1;
	}

	public void setBouton2Equipe1(JButton bouton2Equipe1) {
		this.bouton2Equipe1 = bouton2Equipe1;
	}

	public JButton getBouton3Equipe1() {
		return bouton3Equipe1;
	}

	public void setBouton3Equipe1(JButton bouton3Equipe1) {
		this.bouton3Equipe1 = bouton3Equipe1;
	}

	public JButton getBouton4Equipe1() {
		return bouton4Equipe1;
	}

	public void setBouton4Equipe1(JButton bouton4Equipe1) {
		this.bouton4Equipe1 = bouton4Equipe1;
	}

	public JButton getBouton0Equipe2() {
		return bouton0Equipe2;
	}

	public void setBouton0Equipe2(JButton bouton0Equipe2) {
		this.bouton0Equipe2 = bouton0Equipe2;
	}

	public JButton getBouton1Equipe2() {
		return bouton1Equipe2;
	}

	public void setBouton1Equipe2(JButton bouton1Equipe2) {
		this.bouton1Equipe2 = bouton1Equipe2;
	}

	public JButton getBouton2Equipe2() {
		return bouton2Equipe2;
	}

	public void setBouton2Equipe2(JButton bouton2Equipe2) {
		this.bouton2Equipe2 = bouton2Equipe2;
	}

	public JButton getBouton3Equipe2() {
		return bouton3Equipe2;
	}

	public void setBouton3Equipe2(JButton bouton3Equipe2) {
		this.bouton3Equipe2 = bouton3Equipe2;
	}

	public JButton getBouton4Equipe2() {
		return bouton4Equipe2;
	}

	public void setBouton4Equipe2(JButton bouton4Equipe2) {
		this.bouton4Equipe2 = bouton4Equipe2;
	}

	public JButton getPasserTour() {
		return passerTour;
	}

	public void setPasserTour(JButton passerTour) {
		this.passerTour = passerTour;
	}

	public JButton getQuitter() {
		return quitter;
	}

	public void setQuitter(JButton quitter) {
		this.quitter = quitter;
	}

	public Equipe getEquipe1() {
		return equipe1;
	}

	public void setEquipe1(Equipe equipe1) {
		this.equipe1 = equipe1;
	}

	public Equipe getEquipe2() {
		return equipe2;
	}

	public void setEquipe2(Equipe equipe2) {
		this.equipe2 = equipe2;
	}

	public Plateau getPlateauDeJeu() {
		return plateauDeJeu;
	}

	public void setPlateauDeJeu(Plateau plateauDeJeu) {
		this.plateauDeJeu = plateauDeJeu;
	}

	public JPanel getPlateau() {
		return plateau;
	}

	public void setPlateau(JPanel plateau) {
		this.plateau = plateau;
	}

	public JPanel getIndicateurs() {
		return indicateurs;
	}

	public void setIndicateurs(JPanel indicateurs) {
		this.indicateurs = indicateurs;
	}

	public JPanel getConteneurBoutons() {
		return conteneurBoutons;
	}

	public void setConteneurBoutons(JPanel conteneurBoutons) {
		this.conteneurBoutons = conteneurBoutons;
	}

	public JPanel getBoutons1() {
		return boutons1;
	}

	public void setBoutons1(JPanel boutons1) {
		this.boutons1 = boutons1;
	}

	public JPanel getBoutons2() {
		return boutons2;
	}

	public void setBoutons2(JPanel boutons2) {
		this.boutons2 = boutons2;
	}

	public JSplitPane getPlateauEtIndicateurs() {
		return plateauEtIndicateurs;
	}

	public void setPlateauEtIndicateurs(JSplitPane plateauEtIndicateurs) {
		this.plateauEtIndicateurs = plateauEtIndicateurs;
	}

	public JSplitPane getVirtualWarConteneur() {
		return virtualWarConteneur;
	}

	public void setVirtualWarConteneur(JSplitPane virtualWarConteneur) {
		this.virtualWarConteneur = virtualWarConteneur;
	}
}