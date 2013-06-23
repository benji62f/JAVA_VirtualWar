package classes;

/**
 * La classe Coordonnees permet de reperer facilement les cellules du Plateau.
 * 
 */
public class Coordonnees {
	private int x;
	private int y;

	/**
	 * Constructeur permettant de creer des coordonnees
	 * 
	 * @param x
	 *            Coordonnes en x
	 * @param y
	 *            Coordonnes en y
	 */
	public Coordonnees(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Permet de recuperer la coordonnee en abscisse de la Cellule.
	 * 
	 * @return la coordonnee en abscisse de la Cellule.
	 */
	public int getLargeur() {
		return x;
	}

	/**
	 * Permet de recuperer la coordonnee en ordonnee de la Cellule.
	 * 
	 * @return la coordonnee en ordonnee de la Cellule.
	 */
	public int getHauteur() {
		return y;
	}

	public String toString() {
		return " " + x + ", " + y;
	}

	/**
	 * Permet de faire une addition de Coordonnees.
	 * 
	 * @param coordonnees
	 *            Coordonnees a ajouter.
	 * @return La somme des deux Coordonnees.
	 */
	public Coordonnees ajout(Coordonnees coordonnees) {
		return new Coordonnees(this.x + coordonnees.getLargeur(), this.y
				+ coordonnees.getHauteur());
	}
}
