package classes;

import java.util.Random;

/**
 * Le Plateau est une grille de Cellule.
 * 
 */
public class Plateau {
	
	private Cellule[][] grille;
	private char[][] tab;

	/**
	 * Constructeur permettant de creer un plateau de la taille placee en
	 * parametre.
	 * 
	 * @param x
	 *            largeur du plateau
	 * @param y
	 *            hauteur du plateau
	 */
	public Plateau(int x, int y) {
		Random r = new Random();
		grille = new Cellule[x][y];
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[i].length; j++) {
				grille[i][j] = new Case(i, j);
				if (r.nextInt(100) < Constante.TAUXOBSTACLES) {
					grille[i][j].setObstacle(true);
				}
			}
		}

		grille[0][0] = new Base(0, 0, 1);
		grille[grille.length - 1][grille[0].length - 1] = new Base(
				grille.length - 1, grille[0].length - 1, 2);
	}

	/**
	 * Permet de savoir si une cellule est une base
	 * 
	 * @param x
	 *            coordonnee en abscisse de la cellule
	 * @param y
	 *            coordonnee en ordonnee de la cellule
	 * @return le numéro de l'equipe a qui appartient la Base.
	 * @see Cellule
	 */
	public int estBase(int x, int y) {
		return grille[x][y].estBase();
	}

	/**
	 * Permet de savoir si une cellule est une mine
	 * 
	 * @param x
	 *            coordonnee en abscisse de la cellule
	 * @param y
	 *            coordonnee en ordonnee de la cellule
	 * @return le numÃ©ro de l'equipe a qui appartient la Mine.
	 * @see Cellule
	 */
	public int contientMine(int x, int y) {
		return grille[x][y].contientMine();
	}

	/**
	 * Permet de poser une Mine sur une Cellule
	 * 
	 * @param x
	 *            coordonnee en abscisse de la cellule
	 * @param y
	 *            coordonnee en ordonnee de la cellule
	 * @param equipe
	 *            numero de l'equipe qui pose cette mine
	 */
	public void poserMine(int x, int y, int equipe) {
		grille[x][y].poserMine(equipe);
	}

	/**
	 * Permet de savoir de quel equipe est le robot sur la cellule.
	 * 
	 * @param x
	 *            coordonnee en abscisse de la cellule
	 * @param y
	 *            coordonnee en ordonnee de la cellule
	 * @return le numero de l'equipe du Robot.
	 */
	public int estRobot(int x, int y) {
		return grille[x][y].getContenu().get(0).getEquipe();
	}

	/**
	 * Permet de positionner un robot sur une case.
	 * 
	 * @param x
	 *            coordonnee en abscisse de la cellule
	 * @param y
	 *            coordonnee en ordonnee de la cellule
	 * 
	 * @param robot
	 *            le Robot a poser.
	 */
	public void poserRobot(int x, int y, Robot robot) {
		grille[x][y].poserRobot(robot);
	}
	/**
	 * @return the grille
	 */
	public Cellule[][] getGrille() {
		return grille;
	}

	public String toString(int equipe) {
		tab = new char[grille.length * 2 + 1][(grille[0].length) * 4 + 1];
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {

				if (grille[(i - 1) / 2][(j - 1) / 4].contientMine() == equipe
						&& i % 2 != 0 && j % 4 != 0 && j % 2 == 0) {
					tab[i][j] = grille[(i - 1) / 2][(j - 1) / 4].toString()
							.charAt(0);
				} else {
					if (i % 2 != 0
							&& j % 4 != 0
							&& j % 2 == 0
							&& grille[(i - 1) / 2][(j - 1) / 4].contientMine() == 0) {

						tab[i][j] = grille[(i - 1) / 2][(j - 1) / 4].toString()
								.charAt(0);

					} else if (i % 2 == 0 && j % 4 == 0) {
						tab[i][j] = '+';
					} else if (i % 2 == 0 && j % 4 != 0) {
						tab[i][j] = '-';
					} else if (i % 2 != 0 && j % 4 == 0) {
						tab[i][j] = '|';

					} else {
						tab[i][j] = ' ';
					}
				}
			}
		}
		String resultat = "";
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				resultat = resultat + tab[i][j];
			}
			resultat = resultat + "\n";
		}
		return resultat;
	}
}
