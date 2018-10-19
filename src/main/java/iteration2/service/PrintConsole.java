package iteration2.service;

import iteration2.model.Grille;

public class PrintConsole {

	public void ecrire(String Dimension, int evolutionNbre, Grille grille) {
		String celluleUne;
		String celluleDeux = "";
		if (grille.getCelluleUne().isEnVie())
			celluleUne = "+";
		else
			celluleUne = "-";
		if (grille.getCelluleDeux() != null) {
			if (grille.getCelluleDeux().isEnVie())
				celluleDeux = "+";
			else
				celluleDeux = "-";
		};
		System.out.println("Evolution nombre " + evolutionNbre );
		if (Dimension.equals("2*1")) {
			System.out.println( celluleUne );
			System.out.println( celluleDeux );
		} else
			System.out.println( celluleUne + celluleDeux);
	}
}
