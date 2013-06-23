package classes;

/**
 * Case est un type de Cellule.
 * 
 */
public class Case extends Cellule {
	@SuppressWarnings("unused")
	private int equipe;

	/**
	 * Constructeur de la classe Case
	 * 
	 * @param x
	 *            Coordonnees en x de la base
	 * @param y
	 *            Coordonnees en y de la base
	 */
	public Case(int x, int y) {
		super(x, y);
	}
}
