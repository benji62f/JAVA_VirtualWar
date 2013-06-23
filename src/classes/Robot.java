package classes;

import java.util.List;

/**
 * Robot est le type principal de ce jeu. Il y a plusieurs types de robots : le
 * tireur et le piegeur
 * 
 */
abstract public class Robot {
	private int energie;
	private int equipe;
	private Coordonnees coordonnees;
	private Vue vue;
	private String image;

	/**
	 * Constructeur permettant de creer un Robot.
	 * 
	 * @param vue
	 *            Vue du robot
	 * @param x
	 *            Coordonnees en x du robot
	 * @param y
	 *            Coordonnees en y du robot
	 * @param equipe
	 *            numero de l'equipe du Robot
	 */
	public Robot(Vue vue, int x, int y, int equipe) {
		this.vue = vue;
		this.equipe = equipe;
		this.coordonnees = new Coordonnees(x, y);

	}

	/**
	 * Permet de tester si le robot peut tirer.
	 * 
	 * @return return vrai si le personnage peut tirer, faux sinon.
	 */
	abstract public boolean peutTirer(Coordonnees direction);

	/**
	 * Permet de tester si le robot est sur la Base.
	 * 
	 * @return vrai si le Robot est sur sa base, faux sinon.
	 */
	public boolean estSurBase() {
		return vue.getPlateau()[this.coordonnees.getLargeur()][this.coordonnees
				.getHauteur()].estBase() == this.equipe;
	}

	/**
	 * Permet de tester si le Robot est mort
	 * 
	 * @return vrai si le Robot est mort, faux sinon.
	 */
	public boolean estMort() {
		return getEnergie() <= 0;
	}

	/**
	 * Permet de modifier les coordonnees d'un Robot.
	 * 
	 * @param c
	 *            nouvelles coordonnees du robot
	 */
	public void setCoordonnees(Coordonnees c) {
		this.coordonnees = c;
	}

	/**
	 * Permet de recuperer les coordonnees du robot.
	 * 
	 * @return les coordonnees du robot.
	 */
	public Coordonnees getCoordonnees() {
		return this.coordonnees;
	}

	/**
	 * Permet de recuperer la Vue du robot.
	 * 
	 * @return la Vue du robot.
	 */
	public Vue getVue() {
		return this.vue;
	}

	/**
	 * Permet de recuperer le nombre de points de vie du Robot.
	 * 
	 * @return le nombre de points de vie du Robot.
	 */
	public int getEnergie() {
		return this.energie;
	}

	/**
	 * Permet de modifier le nombre de points de vie d'un Robot.
	 * 
	 * @param energie
	 *            nouveau nombre de points de vie
	 */
	public void setEnergie(int energie) {
		this.energie = energie;
	}

	/**
	 * Permer de recuperer le numero de l'equipe.
	 * 
	 * @return le numero de l'equipe
	 */
	public int getEquipe() {
		return this.equipe;
	}

	/**
	 * Permer de recuperer le cout des actions.
	 * 
	 * @return le cout des actions.
	 */
	abstract public int getCoutAction();

	/**
	 * Permer de recuperer le cout de deplacement.
	 * 
	 * @return le cout de deplacement.
	 */
	abstract public int getCoutDep();

	/**
	 * Permer de recuperer le nombre de degats que fait un tir.
	 * 
	 * @return le nombre de degats que fait un tir.
	 */
	abstract public int getDegatTir();

	/**
	 * Permer de recuperer le nombre de degats que fait une mine.
	 * 
	 * @return le nombre de degats que fait un mine.
	 */
	abstract public int getDegatMine();

	/**
	 * Permet de recuperer le type du robot.
	 * 
	 * @return le type du robot
	 */
	abstract public String getType();

	/**
	 * Permet de recuperer la liste des deplacements possibles.
	 * 
	 * @return la liste des deplacements possibles.
	 */
	abstract public List<Coordonnees> getDeplacement();

	/**
	 * Permet de changer la Vue d'un Robot.
	 * 
	 * @param vue
	 *            Vue a changer
	 */
	public void setVue(Vue vue) {
		this.vue = vue;
	}

	public String toString() {
		return image + "  :  " + this.coordonnees + "  :  " + this.energie
				+ " Points de vie";
	}

	/**
	 * Permet d'appliquer les degats d'un tir sur l'energie du robot touche.
	 */
	public void subitTir(Robot robot) {
		this.energie -= robot.getDegatTir();
	}

	/**
	 * Permet d'appliquer les degats d'une mine sur l'energie du robot touche.
	 */
	public void subitMine() {
		this.energie -= 2;
	}

	/**
	 * Permet de regenerer l'energie d'un robot.
	 */
	abstract public void regeneration();

	/**
	 * @return l'image du robot
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image
	 *            l'image du robot à modifier
	 */
	public void setImage(String image) {
		this.image = image;
	}
}
