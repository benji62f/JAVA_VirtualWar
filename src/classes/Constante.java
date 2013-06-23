package classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe contient toutes les constantes du jeu.
 * 
 */
public class Constante {
	public static final List<Coordonnees> depTireurPiegeur = new ArrayList<Coordonnees>();
	public static final List<Coordonnees> depCharEtAttaqueAll = new ArrayList<Coordonnees>();
	public static final Coordonnees HAUT = new Coordonnees(-1, 0);
	public static final Coordonnees BAS = new Coordonnees(1, 0);
	public static final Coordonnees DROITE = new Coordonnees(0, 1);
	public static final Coordonnees GAUCHE = new Coordonnees(0, -1);
	public static final Coordonnees HAUTDROITE = new Coordonnees(-1, 1);
	public static final Coordonnees BASDROITE = new Coordonnees(1, 1);
	public static final Coordonnees HAUTGAUCHE = new Coordonnees(-1, -1);
	public static final Coordonnees BASGAUCHE = new Coordonnees(1, -1);
	public static final int PIEGEURPVMAX = 50;// 50 par defaut
	public static final int TIREURPVMAX = 40;// 40 par defaut
	public static final int CHARPVMAX = 60;// 60 par defaut
	public static final double TAUXREGEN = 0.2;
	public static final int TAUXOBSTACLES = 20;

	static {
		depTireurPiegeur.add(HAUTGAUCHE);
		depTireurPiegeur.add(HAUT);
		depTireurPiegeur.add(DROITE);
		depTireurPiegeur.add(GAUCHE);
		depTireurPiegeur.add(HAUTDROITE);
		depTireurPiegeur.add(BASGAUCHE);
		depTireurPiegeur.add(BAS);
		depTireurPiegeur.add(BASDROITE);
		depCharEtAttaqueAll.add(HAUT);
		depCharEtAttaqueAll.add(GAUCHE);
		depCharEtAttaqueAll.add(BAS);
		depCharEtAttaqueAll.add(DROITE);
	}
}
