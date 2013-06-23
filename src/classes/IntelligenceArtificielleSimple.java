package classes;

import java.util.ArrayList;
import java.util.Random;

/**
 * Cette classe est une Intelligence Artificielle simple
 * 
 */
public class IntelligenceArtificielleSimple {
	private Equipe equipe;

	/**
	 * Constructeur de la classe Intelligence Artificielle simple
	 * 
	 * @param equipe
	 *            equipe de l'intelligence artificielle
	 */
	public IntelligenceArtificielleSimple(Equipe equipe) {
		this.equipe = equipe;
	}

	/**
	 * Permet à l'intelligence artificielle de choisir un robot.
	 * 
	 * @param liste
	 *            La liste des robots
	 * @return l'indice du robot qui doit faire une action
	 */
	public static int quelRobot(ArrayList<Robot> liste) {
		int s = -1;
		while (s == -1) {
			s = new Random().nextInt(liste.size());
			boolean tmp = new DeplacementOuAttaqueValide(liste.get(s), liste
					.get(s).getVue().getPlateau()).peutAttaquer();
			boolean tmp2 = new DeplacementOuAttaqueValide(liste.get(s), liste
					.get(s).getVue().getPlateau()).peutSeDeplacer();
			if (!tmp && !tmp2) {
				s = -1;
			}
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
			if (tmp == 0 && !tmp1) {
				tmp = -1;
			}
			if (tmp == 1 && !tmp2) {
				tmp = -1;
			}
		}
		if (tmp == 1) {
			tmp = new Random().nextInt(r1.getDeplacement().size());
			Coordonnees tmp2 = new DeplacementOuAttaqueValide(r1, grille)
					.deplacementValide(r1.getDeplacement().get(tmp));
			while (tmp2 == null) {
				tmp = new Random().nextInt(r1.getDeplacement().size());
				tmp2 = new DeplacementOuAttaqueValide(r1, grille)
						.deplacementValide(r1.getDeplacement().get(tmp));

			}
			new Deplacement(r1, tmp2).agit();
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
