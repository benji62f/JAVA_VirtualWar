package classes;

/**
 * Classe qui permet aux Robots de faire les Actions : Deplacement et Attaque.
 */
public abstract class Action {
	private Robot robot;
	private Coordonnees direction;

	/**
	 * Constructeur pour les actions avec choix manuel.
	 * 
	 * @param robot
	 *            Robot qui veut faire une action
	 */
	public Action(Robot robot) {
		this.robot = robot;
	}

	/**
	 * Constructeur pour les actions des IA
	 * 
	 * @param robot
	 *            Robot qui veut faire une action
	 * @param direction
	 *            Direction vers laquelle le robot veut effectuer son action
	 */
	public Action(Robot robot, Coordonnees direction) {
		this.robot = robot;
		this.direction = direction;
	}

	/**
	 * Permet de choisir une direction
	 * 
	 * @return une direction sous forme de coordonnees
	 */

	public abstract Coordonnees choixDirection(Robot r1);

	/**
	 * Permet de recuperer le Robot qui fait l'action.
	 * 
	 * @return le Robot qui fait l'action.
	 */
	public Robot getRobot() {
		return robot;
	}

	/**
	 * Permet de modifier la direction vers laquelle l'action doit se faire.
	 * 
	 */
	public void setDirection(Coordonnees direction) {
		this.direction = direction;
	}

	/**
	 * Permet de recuperer la direction vers laquelle l'action doit se faire.
	 * 
	 * @return la direction vers laquelle l'action doit se faire.
	 */
	public Coordonnees getDirection() {
		return direction;
	}

	/**
	 * Permet d'executer l'action.
	 */
	abstract void agit();
}
