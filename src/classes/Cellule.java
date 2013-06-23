package classes;

import java.util.ArrayList;

/**
 * Une Cellule est une composante du Plateau.
 * 
 */
public abstract class Cellule {
	private int mine = 0;
	private int base = 0;
	private ArrayList<Robot> robot = new ArrayList<Robot>();
	private String image = " ";
	private Coordonnees coordonnees;
	private boolean obstacle = false;

	/**
	 * Constructeur qui permet de creer une cellule
	 * 
	 * @param x
	 *            Coordonnees en x de la Cellule
	 * @param y
	 *            Coordonnees en y de la Cellule
	 */
	public Cellule(int x, int y) {
		this.coordonnees = new Coordonnees(x, y);
	}

	/**
	 * Permet de verifier si la Cellule contient une mine.
	 * 
	 * @return vrai si la Cellule contient une mine, faux sinon.
	 */
	public int contientMine() {
		return this.mine;
	}

	/**
	 * Permet de verifier si la Cellule est une Base.
	 * 
	 * @return le numero de l'equipe qui est dans la base.
	 */
	public int estBase() {
		return this.base;
	}

	/**
	 * Permet de recuperer les Coordonnees de la Cellule.
	 * 
	 * @return les Coordonnees de la Cellule.
	 */
	public Coordonnees getCoordonnees() {
		return this.coordonnees;
	}

	/**
	 * Permet de recuperer le Contenu de la Cellule.
	 * 
	 * @return le Contenu de la Cellule.
	 */
	public ArrayList<Robot> getContenu() {
		return this.robot;
	}

	public String toString() {
		if (this.base == 1) {
			return "B";
		} else if (this.base == 2) {
			return "b";
		}
		return image;
	}

	/**
	 * Permet de positionner un Robot sur la Cellule.
	 * 
	 * @param robot
	 *            Robot a positionner.
	 */
	public void poserRobot(Robot robot) {
		if (robot.getVue().getPlateau()[robot.getCoordonnees().getLargeur()][robot
				.getCoordonnees().getHauteur()].robot.contains(robot)) {
			robot.getVue().getPlateau()[robot.getCoordonnees().getLargeur()][robot
					.getCoordonnees().getHauteur()].robot.remove(robot);
		}
		if (robot.getVue().getPlateau()[robot.getCoordonnees().getLargeur()][robot
				.getCoordonnees().getHauteur()].estBase() == 0) {
			robot.getVue().getPlateau()[robot.getCoordonnees().getLargeur()][robot
					.getCoordonnees().getHauteur()].image = " ";
		}
		robot.setCoordonnees(this.coordonnees);
		this.robot.add(robot);
		if (this.estBase() == 0) {
			this.image = robot.getImage();
		}
	}

	/**
	 * Permet de poser une mine sur la Cellule.
	 * 
	 * @param equipe
	 *            Equipe qui pose la mine.
	 */
	public void poserMine(int equipe) {
		this.mine = equipe;
		if (equipe == 1) {
			this.image = "M";
		} else if (equipe == 2) {
			this.image = "m";
		} else {
			this.image = " ";
		}
	}

	/**
	 * Permet de savoir si la Cellule contient un obstacle.
	 * 
	 * @return true s'il y a un obstacle, false sinon.
	 */
	public boolean estObstacle() {
		return this.obstacle;
	}

	/**
	 * Permet de mettre un obstacle sur la Cellule.
	 * 
	 * @param obstacle
	 *            true s'il y a un obstacle, false sinon.
	 */
	public void setObstacle(boolean obstacle) {
		this.obstacle = obstacle;
		this.image = "X";
	}

	/**
	 * Permet de définir une base sur la Cellule.
	 * 
	 * @param equipe
	 * 
	 */
	public void setBase(int equipe) {
		this.base = equipe;
	}

	/**
	 * @return l'image de la celulle.
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image
	 *            l'image a modifier
	 */
	public void setImage(String image) {
		this.image = image;
	}

}