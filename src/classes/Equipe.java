package classes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * La classe Equipe permet de stocker la liste des robots d'une equipe
 * 
 */
public class Equipe {
	private int numero;
	private ArrayList<Robot> liste;
	private Cellule[][] grille;

	/**
	 * Constructeur de la classe Equipe
	 * 
	 * @param numero
	 *            numero de l'equipe
	 * @param grille
	 *            grille du jeu
	 */
	public Equipe(int numero, Cellule[][] grille) {
		liste = new ArrayList<Robot>();
		this.numero = numero;
		this.grille = grille;
	}

	/**
	 * Permet d'enlever les robots qui sont morts de l'equipe.
	 */
	public void actualiserEquipe() {
		for (int i = 0; i < liste.size(); i++) {
			if (liste.get(i).estMort()) {
				if(!liste.get(i).getImage().equals("O")){
					System.out.println(this.liste.get(i).getImage() + " est mort.");
					JOptionPane.showMessageDialog (null, this.liste.get(i).getImage() + " est mort.", "Message", JOptionPane.INFORMATION_MESSAGE);				}
				if (liste.get(i).estSurBase()) {
				} else {
					this.grille[liste.get(i).getCoordonnees().getLargeur()][liste.get(i).getCoordonnees().getHauteur()].getContenu().remove(liste.get(i)); // a verifier
					this.grille[liste.get(i).getCoordonnees().getLargeur()][liste.get(i).getCoordonnees().getHauteur()].setImage(" ");
				}
				liste.remove(i);
				i = i - 1;
			}
		}
	}

	/**
	 * Permet d'ajouter des robots dans l'equipe
	 * 
	 * @param robot
	 *            Robot qu'il faut ajouter dans l'equipe
	 */
	public void ajouterRobot(Robot robot) {
		liste.add(robot);
	}

	/**
	 * Permet de savoir si l'equipe est vide
	 * 
	 * @return true si l'equipe est vide, false sinon
	 */
	public boolean estVide() {
		return liste.isEmpty();
	}

	/**
	 * Permet de retourner le n-ieme robot de l'equipe
	 * 
	 * @param index
	 *            index ou se trouve le robot dans l'equipe
	 * @return le robot demande
	 */
	public Robot get(int index) {
		return liste.get(index);
	}

	/**
	 * Permet de savoir combien de robots vivants sont dans l'equipe
	 * 
	 * @return le nombre de robots (vivants) de l'equipe
	 */
	public int size() {
		return liste.size();
	}

	/**
	 * Permet de recuperer le numero de l'equipe
	 * 
	 * @return le numero de l'equipe
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Permet de recuperer la liste des robots vivants de l'equipe
	 * 
	 * @return la liste des robots vivants de l'equipe
	 */
	public ArrayList<Robot> getListe() {
		return liste;
	}

	/**
	 * Permet de savoir si le nombre de robots dans la base permet d'en faire
	 * rentrer un nouveau ou non
	 * 
	 * @return true si il y a 2 robots sur le plateau, faux sinon.
	 */
	public boolean peutAllerDansBase() {
		int cpt = 0;
		for (int i = 0; i < liste.size(); i++) {
			if (liste.get(i).estSurBase()) {
				cpt++;
			}
		}
		return (cpt < this.size() - 1);
	}

	/**
	 * Permet de recuperer la grille de Cellule
	 * 
	 * @return la grille de Cellule
	 */
	public Cellule[][] getGrille() {
		return this.grille;
	}
}
