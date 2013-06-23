package classes;

import java.util.ArrayList;
import java.util.Random;

/**
 * Cette classe est une Intelligence Artificielle complexe
 * 
 */
public class IntelligenceArtificielleComplexe {
	private Equipe equipe;

	/**
	 * Constructeur de la classe Intelligence Artificielle complexe
	 * 
	 * @param equipe
	 *            equipe de l'intelligence artificielle
	 */
	public IntelligenceArtificielleComplexe(Equipe equipe) {
		this.equipe = equipe;
	}

	/**
	 * Fonction interne permettant de savoir si un robot peut se deplacer dans
	 * une direction donnee
	 * 
	 * @param r
	 *            le robot qui veut se deplacer
	 * @param direction
	 *            la direction a tester
	 * @param grille
	 *            la grille du jeu
	 * @return true si le robot peut se deplacer dans la direction, false sinon
	 */
	private static boolean possible(Robot r, Coordonnees direction,
			Cellule[][] grille) {
		Coordonnees tmp = new DeplacementOuAttaqueValide(r, grille)
				.deplacementValide(direction);
		return (tmp != null);
	}

	/**
	 * Permet à l'intelligence artificielle de choisir un robot.
	 * 
	 * @param listeRobot
	 *            La liste des robots
	 * @return l'indice du robot qui doit faire une action
	 */
	
	public static int quelRobot(ArrayList<Robot> listeRobot) {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		int s = -1;
		for (int i = 0; i < listeRobot.size(); i++) {
			boolean tmp = new DeplacementOuAttaqueValide(listeRobot.get(i),
					listeRobot.get(i).getVue().getPlateau()).peutAttaquer();
			if (tmp && !listeRobot.get(i).getType().equals("Piegeur")) {
				liste.add(i);
			}
		}
		if (liste.isEmpty()) {
			while (s == -1) {
				s = new Random().nextInt(listeRobot.size());
				boolean tmp = new DeplacementOuAttaqueValide(listeRobot.get(s),
						listeRobot.get(s).getVue().getPlateau()).peutAttaquer();
				boolean tmp2 = new DeplacementOuAttaqueValide(
						listeRobot.get(s), listeRobot.get(s).getVue()
								.getPlateau()).peutSeDeplacer();
				if (!tmp && !tmp2) {
					s = -1;
				}
			}
		} else {
			s = liste.get(new Random().nextInt(liste.size()));
		}
		return s;
	}

	/**
	 * Execute un deplacement ou une attaque pour le robot en parametre
	 * 
	 * @param r1
	 *            le robot qui va faire l'action
	 * @param grille
	 *            la grille du jeu
	 */
	public static void deplacementOuAttaque(Robot r1, Cellule[][] grille) {
		int tmp = -1;
		while (tmp == -1) {
			tmp = new Random().nextInt(2);
			boolean tmp1 = new DeplacementOuAttaqueValide(r1, grille)
					.peutAttaquer();
			boolean tmp2 = new DeplacementOuAttaqueValide(r1, grille)
					.peutSeDeplacer();
			if (tmp1 && !r1.getType().equals("Piegeur")) {
				tmp = 0;
			} else {
				if (tmp == 0 && !tmp1) {
					tmp = -1;
				}
				if (tmp == 1 && !tmp2) {
					tmp = -1;
				}
			}
		}
		if (tmp == 1) {
			Coordonnees tmpCoord;
			if (r1.getEquipe() == 1) {
				if (r1.getType().equals("Char")) {
					if (possible(r1, Constante.BAS, grille)) {
						tmpCoord = new DeplacementOuAttaqueValide(r1, grille)
								.deplacementValide(Constante.BAS);
						new Deplacement(r1, tmpCoord).agit();
					} else if (possible(r1, Constante.DROITE, grille)) {
						tmpCoord = new DeplacementOuAttaqueValide(r1, grille)
								.deplacementValide(Constante.DROITE);
						new Deplacement(r1, tmpCoord).agit();
					} else {
						tmp = new Random().nextInt(r1.getDeplacement().size());
						Coordonnees tmp2 = new DeplacementOuAttaqueValide(r1,
								grille).deplacementValide(r1.getDeplacement()
								.get(tmp));
						while (tmp2 == null) {
							tmp = new Random().nextInt(r1.getDeplacement()
									.size());
							tmp2 = new DeplacementOuAttaqueValide(r1, grille)
									.deplacementValide(r1.getDeplacement().get(
											tmp));
						}
						new Deplacement(r1, tmp2).agit();
					}
				} else {
					if (possible(r1, Constante.BASDROITE, grille)) {
						tmpCoord = new DeplacementOuAttaqueValide(r1, grille)
								.deplacementValide(Constante.BASDROITE);
						new Deplacement(r1, tmpCoord).agit();
					} else if (possible(r1, Constante.BAS, grille)) {
						tmpCoord = new DeplacementOuAttaqueValide(r1, grille)
								.deplacementValide(Constante.BAS);
						new Deplacement(r1, tmpCoord).agit();
					} else if (possible(r1, Constante.DROITE, grille)) {
						tmpCoord = new DeplacementOuAttaqueValide(r1, grille)
								.deplacementValide(Constante.DROITE);
						new Deplacement(r1, tmpCoord).agit();
					} else {
						tmp = new Random().nextInt(r1.getDeplacement().size());
						Coordonnees tmp2 = new DeplacementOuAttaqueValide(r1,
								grille).deplacementValide(r1.getDeplacement()
								.get(tmp));
						while (tmp2 == null) {
							tmp = new Random().nextInt(r1.getDeplacement()
									.size());
							tmp2 = new DeplacementOuAttaqueValide(r1, grille)
									.deplacementValide(r1.getDeplacement().get(
											tmp));
						}
						new Deplacement(r1, tmp2).agit();
					}
				}
			} else {
				if (r1.getType().equals("Char")) {
					if (possible(r1, Constante.HAUT, grille)) {
						tmpCoord = new DeplacementOuAttaqueValide(r1, grille)
								.deplacementValide(Constante.HAUT);
						new Deplacement(r1, tmpCoord).agit();
					} else if (possible(r1, Constante.GAUCHE, grille)) {
						tmpCoord = new DeplacementOuAttaqueValide(r1, grille)
								.deplacementValide(Constante.GAUCHE);
						new Deplacement(r1, tmpCoord).agit();
					} else {
						tmp = new Random().nextInt(r1.getDeplacement().size());
						Coordonnees tmp2 = new DeplacementOuAttaqueValide(r1,
								grille).deplacementValide(r1.getDeplacement()
								.get(tmp));
						while (tmp2 == null) {
							tmp = new Random().nextInt(r1.getDeplacement()
									.size());
							tmp2 = new DeplacementOuAttaqueValide(r1, grille)
									.deplacementValide(r1.getDeplacement().get(
											tmp));
						}
						new Deplacement(r1, tmp2).agit();
					}
				} else {
					if (possible(r1, Constante.HAUTGAUCHE, grille)) {
						tmpCoord = new DeplacementOuAttaqueValide(r1, grille)
								.deplacementValide(Constante.HAUTGAUCHE);
						new Deplacement(r1, tmpCoord).agit();
					} else if (possible(r1, Constante.HAUT, grille)) {
						tmpCoord = new DeplacementOuAttaqueValide(r1, grille)
								.deplacementValide(Constante.HAUT);
						new Deplacement(r1, tmpCoord).agit();
					} else if (possible(r1, Constante.GAUCHE, grille)) {
						tmpCoord = new DeplacementOuAttaqueValide(r1, grille)
								.deplacementValide(Constante.GAUCHE);
						new Deplacement(r1, tmpCoord).agit();
					} else {
						tmp = new Random().nextInt(r1.getDeplacement().size());
						Coordonnees tmp2 = new DeplacementOuAttaqueValide(r1,
								grille).deplacementValide(r1.getDeplacement()
								.get(tmp));
						while (tmp2 == null) {
							tmp = new Random().nextInt(r1.getDeplacement()
									.size());
							tmp2 = new DeplacementOuAttaqueValide(r1, grille)
									.deplacementValide(r1.getDeplacement().get(
											tmp));
						}
						new Deplacement(r1, tmp2).agit();
					}
				}
			}
		} else if (tmp == 0) {
			tmp = new Random().nextInt(Constante.depCharEtAttaqueAll.size());
			Coordonnees tmp2 = new DeplacementOuAttaqueValide(r1, grille)
					.attaqueValide(Constante.depCharEtAttaqueAll.get(tmp));
			while (tmp2 == null) {
				tmp = new Random()
						.nextInt(Constante.depCharEtAttaqueAll.size());
				tmp2 = new DeplacementOuAttaqueValide(r1, grille)
						.attaqueValide(Constante.depCharEtAttaqueAll.get(tmp));
			}
			new Attaque(r1, tmp2).agit();
		}
	}

	/**
	 * Cette méthode déroule automatiquement un tour de jeu
	 */
	public void agit() {
		deplacementOuAttaque(equipe.getListe()
				.get(quelRobot(equipe.getListe())), this.equipe.getGrille());
	}
}
