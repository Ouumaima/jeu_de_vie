package iteration1.service;

import iteration1.model.Grille;

public class PrintConsole {

	public void ecrire(int evolutionNbre, Grille grille) {
		String signe;
		if (grille.getCellule().isEnVie())
			signe = "+";
		else
			signe = "-";

		System.out.println("Evolution nombre " + evolutionNbre );
		System.out.println( signe );
	
		
	}
	
}
