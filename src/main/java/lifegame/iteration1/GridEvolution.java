package lifegame.iteration1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lifegame.commun.ConstantesSign;

public class GridEvolution {

	public Map<String, String> getEntry(String fileName) throws IOException {

		// I)-Lecture du fichier d'entr�e
		List<String> lstLines = new ArrayList<>();
		String line = null;
		FileReader fileReader = new FileReader(fileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		while ((line = bufferedReader.readLine()) != null) {
			lstLines.add(line);
		}
		bufferedReader.close();
		// II)-Sauvegarde des des donn�es d'initialisation du jeu dans le map
		Map<String, String> entry = new HashMap<String, String>();
		entry.put("nbrEvolutions", lstLines.get(0));
		entry.put("dimension", lstLines.get(1));
		entry.put("initialSign", lstLines.get(2));
		return entry;
	}

	/**
	 * Evolution de la grille
	 * @param grid
	 */
	private void changeValue(Grid grid) {
		grid.getCell().setState(ConstantesSign.DEAD);
	}

	/**
	 * 
	 * @param entry : l'entr�e de notre jeu et qui contienne nos donn�es : nbrEvo, dimension et l'etat initial de la grille.
	 *  ==> evolue la grille pour nbrEvo it�rations et l'affiche pour chaque it�ration.
	 */
	public Grid changeGrid(Map<String, String> entry) {
		// I)-Entr�e
		int nbrEvolution = Integer.parseInt(entry.get("nbrEvolutions"));
		int dimension = Integer.parseInt(entry.get("dimension"));
		String initialSign = entry.get("initialSign");
		
		// II)-Affichage d'etat initial.
		System.out.println("Nombre d'it�rations : " + nbrEvolution + "\n" + "Dimension initiale : " + dimension + "\n"
				+ "Etat initial de la grille : " + initialSign+"\n");
		Cell cell = new Cell(initialSign);
		Grid grid = new Grid(cell);
		// III)-Evolution et affichage de la grille pour chaque it�aration
		for (int i = 0; i < nbrEvolution; i++) {
			changeValue(grid);
			System.out.println("Iteration: " + (i+1) + " ==>  Resultat : " + grid.getCell().getState());
		}
		System.out.println("\n");
		return grid;
	}

}
