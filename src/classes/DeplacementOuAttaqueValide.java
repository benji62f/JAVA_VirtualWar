package classes;

/**
 * Classe qui permet de faire tous les tests sur les possibilites d'attaques ou
 * de deplacements.
 * 
 */
public class DeplacementOuAttaqueValide {
	private Robot r;
	@SuppressWarnings("unused")
	private Cellule[][] grille;

	/**
	 * Constructeur de la classe DeplacementOuAttaqueValide
	 * 
	 * @param r
	 *            le robot a qui on veut tester le deplacement ou l'attaque
	 * @param grille
	 *            la grille du jeu
	 */
	public DeplacementOuAttaqueValide(Robot r, Cellule[][] grille) {
		this.r = r;
		this.grille = grille;
	}

	/**
	 * Permet de savoir si le robot peut se deplacer dans la direction indique
	 * en parametre.
	 * 
	 * @param direction
	 *            Direction vers laquelle le test doit etre effectue.
	 * @return True si le robot peut se deplacer dans cette direction, false
	 *         sinon
	 */
	public Coordonnees deplacementValide(Coordonnees direction) {
		if (this.r.getVue().estOK(
				new Coordonnees(this.r.getCoordonnees().getLargeur()
						+ direction.getLargeur(), this.r.getCoordonnees()
						.getHauteur() + direction.getHauteur()))) {
			if (this.r.getType().equals("Char")) {
				if (this.r.getVue().estOK(
						new Coordonnees(this.r.getCoordonnees().getLargeur()
								+ direction.getLargeur()
								+ direction.getLargeur(), this.r
								.getCoordonnees().getHauteur()
								+ direction.getHauteur()
								+ direction.getHauteur()))) {
					return (new Coordonnees(direction.getLargeur()
							+ direction.getLargeur(), direction.getHauteur()
							+ direction.getHauteur()));
				} else {
				}
			}
		} else {
			return null;
		}

		return direction;
	}

	/**
	 * Permet de tester si le robot peut se deplacer dans au moins une direction
	 * ou pas
	 * 
	 * @return true s'il peut se deplacer, false sinon
	 */
	public boolean peutSeDeplacer() {
		if (this.r.getType().equals("Char")) {
			return (this.deplacementValide(Constante.HAUT) != null
					|| this.deplacementValide(Constante.DROITE) != null
					|| this.deplacementValide(Constante.GAUCHE) != null || this
						.deplacementValide(Constante.BAS) != null);
		} else {
			return (this.deplacementValide(Constante.HAUT) != null
					|| this.deplacementValide(Constante.HAUTDROITE) != null
					|| this.deplacementValide(Constante.HAUTGAUCHE) != null
					|| this.deplacementValide(Constante.DROITE) != null
					|| this.deplacementValide(Constante.GAUCHE) != null
					|| this.deplacementValide(Constante.BAS) != null
					|| this.deplacementValide(Constante.BASDROITE) != null || this
						.deplacementValide(Constante.BASGAUCHE) != null);
		}
	}

	/**
	 * Permet de savoir si le robot peut attaquer dans la direction indique en
	 * parametre.
	 * 
	 * @param direction
	 *            Direction vers laquelle le test doit etre effectue.
	 * @return True si le robot peut attaquer dans cette direction, false sinon
	 */
	public Coordonnees attaqueValide(Coordonnees direction) {
		if (this.r.getType().equals("Char")) {
			if (this.r.peutTirer(direction)) {
				return direction;
			} else if (this.r.getCoordonnees().getLargeur()
					+ direction.getLargeur() >= 0
					&& this.r.getCoordonnees().getLargeur()
							+ direction.getLargeur() < this.r.getVue().getPlateau().length
					&& this.r.getCoordonnees().getHauteur()
							+ direction.getHauteur() >= 0
					&& this.r.getCoordonnees().getHauteur()
							+ direction.getHauteur() < this.r.getVue().getPlateau()[0].length
					&& (!r.getVue().getPlateau()[this.r.getCoordonnees()
							.getLargeur() + direction.getLargeur()][this.r
							.getCoordonnees().getHauteur()
							+ direction.getHauteur()].estObstacle() && (!r
							.getVue().getPlateau()[this.r.getCoordonnees()
							.getLargeur() + direction.getLargeur()][this.r
							.getCoordonnees().getHauteur()
							+ direction.getHauteur()].getContenu().isEmpty() && r
							.getVue().getPlateau()[this.r.getCoordonnees()
							.getLargeur() + direction.getLargeur()][this.r
							.getCoordonnees().getHauteur()
							+ direction.getHauteur()].getContenu().get(0)
							.getEquipe() == this.r.getEquipe()))) {
				for (int i = 2; i <= 11; i++) {
					if (this.r.peutTirer(this.aideCoordChar(direction, i))) {
						return this.aideCoordChar(direction, i);
					} else if (this.r.getCoordonnees().getLargeur()
							+ this.aideCoordChar(direction, i).getLargeur() >= 0
							&& this.r.getCoordonnees().getLargeur()
									+ this.aideCoordChar(direction, i)
											.getLargeur() < this.r.getVue().getPlateau().length
							&& this.r.getCoordonnees().getHauteur()
									+ this.aideCoordChar(direction, i)
											.getHauteur() >= 0
							&& this.r.getCoordonnees().getHauteur()
									+ this.aideCoordChar(direction, i)
											.getHauteur() < this.r.getVue().getPlateau()[0].length
							&& (r.getVue().getPlateau()[this.r
									.getCoordonnees().getLargeur()
									+ direction.getLargeur()][this.r
									.getCoordonnees().getHauteur()
									+ direction.getHauteur()].estObstacle() || (!(r
									.getVue().getPlateau()[this.r
									.getCoordonnees().getLargeur()
									+ direction.getLargeur()][this.r
									.getCoordonnees().getHauteur()
									+ direction.getHauteur()].getContenu()
									.isEmpty()) && r.getVue().getPlateau()[this.r
									.getCoordonnees().getLargeur()
									+ direction.getLargeur()][this.r
									.getCoordonnees().getHauteur()
									+ direction.getHauteur()].getContenu()
									.get(0).getEquipe() == this.r.getEquipe()))) {
						return null;
					}
					if (i == 11) {
						return null;
					}
				}
			} else {
				return null;
			}
		} else if ((this.r.getType().equals("Tireur") || this.r.getType()
				.equals("Piegeur")) && this.r.peutTirer(direction)) {

		} else {
			return null;
		}
		return direction;
	}

	/**
	 * Permet de tester si le robot peut attaquer dans au moins une direction ou
	 * pas
	 * 
	 * @return true s'il peut attaquer, false sinon
	 */
	public boolean peutAttaquer() {
		return (this.attaqueValide(Constante.HAUT) != null
				|| this.attaqueValide(Constante.BAS) != null
				|| this.attaqueValide(Constante.DROITE) != null || this
					.attaqueValide(Constante.GAUCHE) != null);
	}

	/**
	 * Classe permettant de générer les cases dans la direction vers laquelle le
	 * char veut attaquer
	 * 
	 * @param direction
	 *            direction vers laquelle le char veut attaquer
	 * @param nombre
	 *            nombre de cases vers laquelle le char veut tirer
	 * @return les coordonnees de la case dans la direction vers laquelle le
	 *         char veut attaquer
	 */
	private Coordonnees aideCoordChar(Coordonnees direction, int nombre) {
		int largeur = direction.getLargeur();
		int hauteur = direction.getHauteur();
		int l = 0;
		int h = 0;
		for (int i = 0; i < nombre; i++) {
			l = l + largeur;
			h = h + hauteur;
		}
		return new Coordonnees(l, h);
	}

	/**
	 * Permet de savoir si au moins robot de l'equipe passee en parametre peut
	 * faire une action
	 * 
	 * @param e
	 *            equipe qui doit subir le test
	 * @return true si un robot de l'equipe peut faire une action, false sinon
	 */
	public boolean peutSeDeplacerOuAttaque(Equipe e) {
		boolean tmp = false;
		for (int i = 0; i < e.getListe().size(); i++) {
			boolean tmp1 = new DeplacementOuAttaqueValide(e.getListe().get(i),
					e.getListe().get(i).getVue().getPlateau()).peutAttaquer();
			boolean tmp2 = new DeplacementOuAttaqueValide(e.getListe().get(i),
					e.getListe().get(i).getVue().getPlateau()).peutSeDeplacer();
			if (tmp1 || tmp2) {
				return true;
			}
		}
		return tmp;
	}
}
