package classes;

/**
 * Base est un type de Cellule.
 * 
 */
public class Base extends Cellule {
	@SuppressWarnings("unused")
	private int equipe;

	/**
	 * Constructeur de la classe Base
	 * 
	 * @param x
	 *            Coordonnees en x de la base
	 * @param y
	 *            Coordonnees en y de la base
	 * @param equipe
	 *            numero de l'equipe a qui appartient la base
	 */
	public Base(int x, int y, int equipe) {
		super(x, y);
		this.equipe = equipe;
		if (equipe == 1) {
			this.setImage("B");
		} else {
			this.setImage("b");
		}
		this.setBase(equipe);
	}
}
