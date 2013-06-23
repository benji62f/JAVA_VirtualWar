package classes;

import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * Classe qui permet a un robot d'attaquer.
 */
public class Attaque extends Action {

	/**
	 * Constructeur de la classe Attaque pour le choix manuel de la direction
	 * 
	 * @param robot
	 *            Robot qui va attaquer
	 */
	public Attaque(Robot robot) {
		super(robot);
		this.setDirection(null);
		Coordonnees tmp = null;
		while (tmp == null) {
			tmp = this.choixDirection(robot);
			tmp = new DeplacementOuAttaqueValide(this.getRobot(), this
					.getRobot().getVue().getPlateau()).attaqueValide(tmp);
			if (tmp == null) {
				System.out.println("Attaque impossible !");
			}
		}
		this.setDirection(tmp);
	}

	/**
	 * Constructeur de la classe Attaque pour les intelligences artificielles
	 * 
	 * @param robot
	 *            Robot qui va attaquer
	 * @param direction
	 *            Direction vers laquelle le robot va attaquer
	 */
	public Attaque(Robot robot, Coordonnees direction) {
		super(robot, direction);
	}

	/**
	 * Classe permettant de générer les cases dans la direction vers laquelle
	 * le char veut attaquer
	 * 
	 * @param direction
	 *            direction vers laquelle le char veut attaquer
	 * @param nombre
	 *            nombre de cases vers laquelle le char veut tirer
	 * @return les coordonnees de la case dans la direction vers laquelle le
	 *         char veut attaquer
	 */
	public Coordonnees aideCoordChar(Coordonnees direction, int nombre) {
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

	public Coordonnees choixDirection(Robot r1) {
		String deplacement = "";
		@SuppressWarnings("resource")
		Scanner s1 = new Scanner(System.in);
		while (deplacement.equals("")) {
			System.out
					.print("Saisir attaque de "
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
			System.out.println("Direction inconnue !");
			deplacement = "";
		}
		return null;
	}

	public void agit() {
		this.getRobot().setEnergie(
				this.getRobot().getEnergie() - this.getRobot().getCoutAction());
		if (this.getRobot().getType().equals("Tireur")
				|| this.getRobot().getType().equals("Char")) {
			this.getRobot().getVue().getPlateau()[this.getRobot()
					.getCoordonnees().getLargeur()
					+ this.getDirection().getLargeur()][this.getRobot()
					.getCoordonnees().getHauteur()
					+ this.getDirection().getHauteur()].getContenu().get(0)
					.subitTir(this.getRobot());
			System.out
					.println(this.getRobot().getVue().getPlateau()[this
							.getRobot().getCoordonnees().getLargeur()
							+ this.getDirection().getLargeur()][this.getRobot()
							.getCoordonnees().getHauteur()
							+ this.getDirection().getHauteur()].getContenu()
							.get(0).getImage()
							+ " a perdu "
							+ this.getRobot().getDegatTir() + " points de vie");
			JOptionPane.showMessageDialog(null,
					this.getRobot().getVue().getPlateau()[this.getRobot()
							.getCoordonnees().getLargeur()
							+ this.getDirection().getLargeur()][this.getRobot()
							.getCoordonnees().getHauteur()
							+ this.getDirection().getHauteur()].getContenu()
							.get(0).getImage()
							+ " a perdu "
							+ this.getRobot().getDegatTir() + " points de vie.",
					"Message", JOptionPane.INFORMATION_MESSAGE);

		} else if (this.getRobot().getType().equals("Piegeur")) {
			this.getRobot().getVue().getPlateau()[this.getRobot()
					.getCoordonnees().getLargeur()
					+ this.getDirection().getLargeur()][this.getRobot()
					.getCoordonnees().getHauteur()
					+ this.getDirection().getHauteur()].poserMine(this
					.getRobot().getEquipe());
		}
	}
}
