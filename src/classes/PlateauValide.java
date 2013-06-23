package classes;

/**
 * Cette classe permet de tester si un robot est valide ou non
 */
public class PlateauValide {

	private Plateau plateau;
	private boolean[] grilleLogique;
	private Robot r;
	private Equipe e;
	private Robot r2D2;

	/**
	 * Constructeur de la classe PlateauValide
	 * 
	 * @param grille
	 *            grille du jeu a tester
	 */
	public PlateauValide(Plateau grille) {
		this.plateau = grille;
		this.grilleLogique = new boolean[grille.getGrille()[0].length];

		for (int j = 0; j < grille.getGrille()[0].length; j++) {
			this.grilleLogique[j] = false;
		}
		e = new Equipe(1, grille.getGrille());
		r = new Testeur(new Vue(1, grille, e), 0, 0, 1);
		e.ajouterRobot(r);
		r2D2 = new Testeur(new Vue(1, grille, e), 0, 0, 1);
		e.ajouterRobot(r2D2);
	}

	/**
	 * Permet de tester si il existe un chemin entre les bases de la grille
	 * 
	 * @return true s'il existe un chemin, false sinon
	 */
	public boolean agit() {
		plateau.poserRobot(plateau.getGrille().length - 1, 0, r2D2);

		for (int i = 0; i < 100000; i++) {
			new IntelligenceArtificielleSimple(e).agit();
			if (this.plateau.getGrille()[r.getCoordonnees().getLargeur()][r
					.getCoordonnees().getHauteur()].estBase() == 1) {
				this.r.setEnergie(-1);
				this.r2D2.setEnergie(-1);
				e.actualiserEquipe();
				return true;
			}
		}
		this.r.setEnergie(-1);
		this.r2D2.setEnergie(-1);
		e.actualiserEquipe();
		return false;
	}
}