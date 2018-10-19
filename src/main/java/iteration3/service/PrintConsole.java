 package iteration3.service;

import iteration3.model.Cellule;
import iteration3.model.Grille;



public class PrintConsole {

	public void ecrire( Integer evolutionNbre, Grille grille) {
		
		Cellule[][] cellules = grille.getCellules();
		System.out.println("Evolution nombre " + evolutionNbre );
		for (int i=0; i< cellules.length;i++){
			String formatedLine = this.formatLigne(cellules[i]);
			System.out.println( formatedLine );
		}
	}
	
	public String formatLigne(Cellule[] cellules) {
		StringBuilder ligne = new StringBuilder();
		String sign = "";
		for (int i = 0; i < cellules.length; i++) {
			if (cellules[i] != null ){
				if (cellules[i].isEnVie())
					sign = "+";
				else sign = "-";
			}
			ligne.append(sign);
		}
		return ligne.toString();

	}
	}
