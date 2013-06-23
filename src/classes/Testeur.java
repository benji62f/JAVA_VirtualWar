package classes;

import java.util.List;

/**
 * Testeur est un robot qui est utilise pour le test de la generation
 * d'obstacle. Ce robot a les memes deplacements que les Chars sauf qu'il ne
 * perd pas d'energie en se deplacant et qu'il ne peut pas attaquer.
 * 
 * @see Robot
 */
public class Testeur extends Robot {
	/**
	 * Classe qui permet de creer un Testeur
	 * 
	 * @param vue
	 *            Vue du robot
	 * @param x
	 *            Coordonnees en x du robot
	 * @param y
	 *            Coordonnees en y du robot
	 * @param equipe
	 *            numero de l'equipe dans laquelle il sera
	 */
	public Testeur(Vue vue, int x, int y, int equipe) {
		super(vue, x, y, equipe);
		this.setImage("O");
		this.setEnergie(Constante.PIEGEURPVMAX);
		if (this.getEquipe() == 2) {
			this.getVue().poserRobot(this, new Coordonnees(0, 0));
		} else {
			this.getVue().poserRobot(
					this, new Coordonnees(this.getVue().getPlateau().length - 1, this.getVue().getPlateau()[0].length - 1));
		}
	}

	public int getCoutAction() {
		return 0;
	}

	public int getDegatTir() {
		return 0;
	}

	public String getType() {
		return "Char";
	}

	public boolean peutTirer(Coordonnees direction) {
		return false;
	}

	public int getCoutDep() {
		return 0;
	}

	public int getDegatMine() {
		return 0;
	}

	public List<Coordonnees> getDeplacement() {
		return Constante.depCharEtAttaqueAll;
	}

	public void regeneration() {

	}
}
