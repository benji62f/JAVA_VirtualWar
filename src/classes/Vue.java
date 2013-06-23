package classes;

/**
 * La classe vue permet de limiter la vue a certaines informations comme quel(s)
 * robot(s) sont dans la base par exemple.
 * 
 */
public class Vue {
	private Plateau plateau;
	private int equipe;
	private Equipe liste;

	/**
	 * Constructeur qui permet de creer une vue pour une equipe donnee
	 * 
	 * @param equipe
	 *            numero de l'equipe de la vue
	 * @param t
	 *            le plateau
	 * @param liste
	 *            l'equipe
	 */
	public Vue(int equipe, Plateau t, Equipe liste) {
		this.equipe = equipe;
		this.plateau = t;
		this.liste = liste;
	}

	/**
	 * Permet de positionner un robot sur une cellule du plateau
	 * 
	 * @param robot
	 *            le robot a deplacer
	 * @param position
	 *            les coordonnees de la cellule vers laquelle le robot va se
	 *            positionner
	 */
	public void poserRobot(Robot robot, Coordonnees position) {
		plateau.poserRobot(position.getLargeur(), position.getHauteur(), robot);
	}

	/**
	 * Permet de tester si la case est accessible par un robot (si ce n'est ni
	 * hors du plateau et si ce n'est pas un obstacle).
	 * 
	 * @param position
	 *            les coordonnees de la case a tester
	 * @return vrai si la case est accessible, faux sinon.
	 */
	public boolean estOK(Coordonnees position) {
		return (position.getLargeur() >= 0
				&& position.getLargeur() < this.plateau.getGrille().length
				&& position.getHauteur() >= 0
				&& position.getHauteur() < this.plateau.getGrille()[0].length
				&& (((plateau.getGrille()[position.getLargeur()][position
						.getHauteur()].estBase() == equipe && this.liste
						.peutAllerDansBase()) && (plateau.getGrille()[position
						.getLargeur()][position.getHauteur()].getContenu()
						.isEmpty() || !plateau.getGrille()[position.getLargeur()][position
						.getHauteur()].getContenu().isEmpty())) || plateau.getGrille()[position
						.getLargeur()][position.getHauteur()].estBase() == 0
						&& plateau.getGrille()[position.getLargeur()][position
								.getHauteur()].getContenu().isEmpty()) && !plateau.getGrille()[position
					.getLargeur()][position.getHauteur()].estObstacle());
	}

	/**
	 * Permet de tester si la case est une mine
	 * 
	 * @param position
	 *            coordonnees de la case a tester
	 * @return vrai si la case est un mine, faux sinon.
	 */
	public boolean estMine(Coordonnees position) {
		return (plateau.getGrille()[position.getLargeur()][position.getHauteur()]
				.contientMine() == this.equipe);
	}

	/**
	 * Permet a un robot "piegeur" de poser une mine.
	 * 
	 * @param robot
	 *            le robot "piegeur" qui veut poser une mine.
	 * @param position
	 *            la case sur laquelle la mine va etre posee.
	 */
	public void setMine(Robot robot, Coordonnees position) {
		plateau.getGrille()[position.getLargeur()][position.getHauteur()]
				.poserMine(equipe);
	}

	/**
	 * Permet de retourner le plateau
	 * 
	 * @return la grille du plateau
	 */
	public Cellule[][] getPlateau() {
		return this.plateau.getGrille();
	}
}
