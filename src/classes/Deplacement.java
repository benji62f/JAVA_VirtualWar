package classes;

import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * Classe qui permet de deplacer un robot.
 * 
 */
public class Deplacement extends Action {

	/**
	 * Constructeur de la classe Deplacement pour le choix manuel de la
	 * direction
	 * 
	 * @param robot
	 *            Robot qui va se deplacer
	 */
	public Deplacement(Robot robot) {
		super(robot);
		Coordonnees tmp = null;
		this.setDirection(null);
		while (tmp == null) {
			tmp = this.choixDirection(robot);
			tmp = new DeplacementOuAttaqueValide(this.getRobot(), this
					.getRobot().getVue().getPlateau()).deplacementValide(tmp);
			if (tmp == null) {
				System.out.println("Deplacement impossible !");
			}
		}
		this.setDirection(tmp);
	}

	/**
	 * Constructeur de la classe Deplacement pour les intelligences
	 * artificielles
	 * 
	 * @param robot
	 *            Robot qui va se deplacer
	 * @param direction
	 *            Direction vers laquelle le robot va se deplacer
	 */
	public Deplacement(Robot robot, Coordonnees direction) {
		super(robot, direction);
	}

	public Coordonnees choixDirection(Robot r1) {
		String deplacement = "";
		@SuppressWarnings("resource")
		Scanner s1 = new Scanner(System.in);
		while (deplacement.equals("")) {
			if (r1.getType().equals("Char")) {
				System.out
						.print("Saisir deplacement de "
								+ r1.getImage()
								+ " qui a "
								+ r1.getEnergie()
								+ " point(s) de vie (z pour haut, s pour bas, d pour droite, q pour gauche) : ");
				deplacement = s1.nextLine().toUpperCase();
				if (deplacement.equals("Z")) {
					return Constante.HAUT;
				}
				if (deplacement.equals("S")) {
					return Constante.BAS;
				}
				if (deplacement.equals("D")) {
					return Constante.DROITE;
				}
				if (deplacement.equals("Q")) {
					return Constante.GAUCHE;
				}
				System.out.println("Deplacement inconnu !");
				deplacement = "";
			} else {
				System.out
						.print("Saisir deplacement de "
								+ r1.getImage()
								+ " qui a "
								+ r1.getEnergie()
								+ " point(s) de vie (z pour haut, s pour bas, d pour droite, q pour gauche, \nzq pour diagonale gauche vers le haut, zd pour diagonale droite vers le haut, sq pour diagonale gauche vers le bas, sd pour diagonale droite vers le bas) : ");
				deplacement = s1.nextLine().toUpperCase();
				if (deplacement.equals("Z")) {
					return Constante.HAUT;
				}
				if (deplacement.equals("S")) {
					return Constante.BAS;
				}
				if (deplacement.equals("D")) {
					return Constante.DROITE;
				}
				if (deplacement.equals("Q")) {
					return Constante.GAUCHE;
				}
				if (deplacement.equals("ZD")) {
					return Constante.HAUTDROITE;
				}
				if (deplacement.equals("ZQ")) {
					return Constante.HAUTGAUCHE;
				}
				if (deplacement.equals("SD")) {
					return Constante.BASDROITE;
				}
				if (deplacement.equals("SQ")) {
					return Constante.BASGAUCHE;
				}

				System.out.println("Deplacement inconnu !");
				deplacement = "";
			}
		}
		return null;
	}

	public void agit() {
		this.getRobot().setEnergie(
				this.getRobot().getEnergie() - this.getRobot().getCoutDep());
		if (this.getRobot().getType().equals("Tireur")
				|| this.getRobot().getType().equals("Piegeur")
				|| (this.getRobot().getType().equals("Char") && ((this
						.getDirection().getHauteur() != -2 && this
						.getDirection().getHauteur() != 2) && ((this
						.getDirection().getLargeur() != -2 && this
						.getDirection().getLargeur() != 2))))) {
			this.getRobot().getVue().getPlateau()[this.getRobot()
					.getCoordonnees().getLargeur()
					+ this.getDirection().getLargeur()][this.getRobot()
					.getCoordonnees().getHauteur()
					+ this.getDirection().getHauteur()].poserRobot(this
					.getRobot());
			if (this.getRobot().getVue().getPlateau()[this.getRobot()
					.getCoordonnees().getLargeur()][this.getRobot()
					.getCoordonnees().getHauteur()].contientMine() != 0) {
				this.getRobot().subitMine();
				this.getRobot().getVue().getPlateau()[this.getRobot()
						.getCoordonnees().getLargeur()][this.getRobot()
						.getCoordonnees().getHauteur()].poserMine(0);
				this.getRobot().getVue().getPlateau()[this.getRobot()
						.getCoordonnees().getLargeur()][this.getRobot()
						.getCoordonnees().getHauteur()].setImage(this.getRobot().getImage());
				System.out.println(this.getRobot().getImage()
						+ " a perdu 2 points de vie");
				JOptionPane.showMessageDialog(null, this.getRobot().getImage()
						+ " a perdu 2 points de vie", "Message",
						JOptionPane.INFORMATION_MESSAGE);

			}
		} else {
			this.getRobot().getVue().getPlateau()[this.getRobot()
					.getCoordonnees().getLargeur()
					+ this.getDirection().getLargeur()][this.getRobot()
					.getCoordonnees().getHauteur()
					+ this.getDirection().getHauteur()].poserRobot(this
					.getRobot());
			if (this.getRobot().getVue().getPlateau()[this.getRobot()
					.getCoordonnees().getLargeur()
					- this.getDirection().getLargeur() / 2][this.getRobot()
					.getCoordonnees().getHauteur()
					- this.getDirection().getHauteur() / 2].contientMine() != 0) {// testMine1ereCase
				this.getRobot().subitMine();
				this.getRobot().getVue().getPlateau()[this.getRobot()
						.getCoordonnees().getLargeur()
						- this.getDirection().getLargeur() / 2][this.getRobot()
						.getCoordonnees().getHauteur()
						- this.getDirection().getHauteur() / 2].poserMine(0);
				this.getRobot().getVue().getPlateau()[this.getRobot()
						.getCoordonnees().getLargeur()
						- this.getDirection().getLargeur() / 2][this.getRobot()
						.getCoordonnees().getHauteur()
						- this.getDirection().getHauteur() / 2].setImage(" ");
				System.out.println(this.getRobot().getImage()
						+ " a perdu 2 points de vie");
				JOptionPane.showMessageDialog(null, this.getRobot().getImage()
						+ " a perdu 2 points de vie", "Message",
						JOptionPane.INFORMATION_MESSAGE);

			}
			if (this.getRobot().getVue().getPlateau()[this.getRobot()
					.getCoordonnees().getLargeur()][this.getRobot()
					.getCoordonnees().getHauteur()].contientMine() != 0) {// testMine2eCase
				this.getRobot().subitMine();
				this.getRobot().getVue().getPlateau()[this.getRobot()
						.getCoordonnees().getLargeur()][this.getRobot()
						.getCoordonnees().getHauteur()].poserMine(0);
				this.getRobot().getVue().getPlateau()[this.getRobot()
						.getCoordonnees().getLargeur()][this.getRobot()
						.getCoordonnees().getHauteur()].setImage(this.getRobot().getImage());
				System.out.println(this.getRobot().getImage()
						+ " a perdu 2 points de vie");
				JOptionPane.showMessageDialog(null, this.getRobot().getImage()
						+ " a perdu 2 points de vie", "Message",
						JOptionPane.INFORMATION_MESSAGE);

			}
		}
	}
}
