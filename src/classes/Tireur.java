package classes;

import java.util.List;

import javax.swing.JOptionPane;

/**
 * Tireur est l'un des types de Robot. Ce robot peut tirer a une case de
 * distance.
 * 
 * @see Robot
 * 
 */
public class Tireur extends Robot {
	/**
	 * Classe qui permet de creer un Tireur
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
	public Tireur(Vue vue, int x, int y, int equipe) {
		super(vue, x, y, equipe);
		if (equipe == 1) {
			this.setImage("T");

		} else {
			this.setImage("t");
		}

		this.setEnergie(Constante.TIREURPVMAX);
		if (this.getEquipe() == 1) {
			this.getVue().poserRobot(this, new Coordonnees(0, 0));
		} else {
			this.getVue().poserRobot(
					this,
					new Coordonnees(this.getVue().getPlateau().length - 1,
							this.getVue().getPlateau()[0].length - 1));
		}
	}

	public int getCoutAction() {
		return 2;
	}

	public int getCoutDep() {
		return 1;
	}

	public int getDegatTir() {
		return 3;
	}

	public String getType() {
		return "Tireur";
	}

	public int getDegatMine() {
		return 0;
	}

	public boolean peutTirer(Coordonnees direction) {
		return (this.getCoordonnees().getLargeur() + direction.getLargeur() >= 0
				&& this.getCoordonnees().getLargeur() + direction.getLargeur() < this
						.getVue().getPlateau().length
				&& this.getCoordonnees().getHauteur() + direction.getHauteur() >= 0
				&& this.getCoordonnees().getHauteur() + direction.getHauteur() < this
						.getVue().getPlateau()[0].length
				&& (!this.getVue().getPlateau()[this.getCoordonnees()
						.getLargeur() + direction.getLargeur()][this
						.getCoordonnees().getHauteur() + direction.getHauteur()]
						.getContenu().isEmpty())
				&& (this.getVue().getPlateau()[this.getCoordonnees()
						.getLargeur() + direction.getLargeur()][this
						.getCoordonnees().getHauteur() + direction.getHauteur()]
						.getContenu().get(0).getEquipe() != this.getEquipe() && (this
						.getVue().getPlateau()[this.getCoordonnees()
						.getLargeur() + direction.getLargeur()][this
						.getCoordonnees().getHauteur() + direction.getHauteur()]
						.estBase() == 0))
				&& this.getVue().getPlateau()[this.getCoordonnees()
						.getLargeur() + direction.getLargeur()][this
						.getCoordonnees().getHauteur() + direction.getHauteur()]
						.contientMine() == 0 && !this.getVue().getPlateau()[this
				.getCoordonnees().getLargeur() + direction.getLargeur()][this
				.getCoordonnees().getHauteur() + direction.getHauteur()]
					.estObstacle());
	}

	public List<Coordonnees> getDeplacement() {
		return Constante.depTireurPiegeur;
	}

	public void regeneration() {
		if (this.estSurBase()) {
			if (Constante.TIREURPVMAX - this.getEnergie() > (Constante.TAUXREGEN * (Constante.TIREURPVMAX))) {
				System.out.println(this.getImage()
						+ " a gagne "
						+ ((int) (this.getEnergie() + Constante.TAUXREGEN
								* (Constante.TIREURPVMAX)) - this.getEnergie())
						+ " Points de vie parce qu'il est sur sa base !");
				JOptionPane.showMessageDialog(null, this.getImage()
						+ " a gagne "
						+ ((int) (this.getEnergie() + Constante.TAUXREGEN
								* (Constante.TIREURPVMAX)) - this.getEnergie())
						+ " Points de vie parce qu'il est sur sa base !",
						"Message", JOptionPane.INFORMATION_MESSAGE);

				this.setEnergie((int) (this.getEnergie() + Constante.TAUXREGEN
						* (Constante.TIREURPVMAX)));
			} else if (Constante.TIREURPVMAX - this.getEnergie() == 0) {
			} else {
				System.out.println(this.getImage() + " a gagne "
						+ (Constante.TIREURPVMAX - this.getEnergie())
						+ " Points de vie parce qu'il est sur sa base !");
				JOptionPane
						.showMessageDialog(
								null,
								this.getImage()
										+ " a gagne "
										+ (Constante.TIREURPVMAX - this
												.getEnergie())
										+ " Points de vie parce qu'il est sur sa base !",
								"Message", JOptionPane.INFORMATION_MESSAGE);

				this.setEnergie(Constante.TIREURPVMAX);
			}
		}
	}
}
