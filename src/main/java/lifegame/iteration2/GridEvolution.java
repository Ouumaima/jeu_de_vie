package lifegame.iteration2;

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
		// I)-Lecture du fichier d'entrée
		List<String> lstLines = new ArrayList<>();
		String line = null;
		FileReader fileReader = new java.io.FileReader(fileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		while ((line = bufferedReader.readLine()) != null) {
			lstLines.add(line);
		}
		bufferedReader.close();
		// II)-Sauvegarde des des données d'initialisation du jeu dans le map
		Map<String, String> entry = new HashMap<String, String>();
		entry.put("nbrEvolutions", lstLines.get(0));
		entry.put("dimension", lstLines.get(1));
		entry.put("initialGrid", lstLines.get(2));
		return entry;
	}

	/**
	 * Evolution de la grille
	 * 
	 * @param grid
	 */
	private void changeValue(Grid grid) {

		Cell[] cell = grid.getCell();
		Cell[] resultCell = new Cell[cell.length];

		for (int i = 0; i < cell.length; i++) {
			resultCell[i] = new Cell(ConstantesSign.DEAD);
			if (ConstantesSign.ALIVE.equals(cell[i].getState()) && i > 0 && i < cell.length - 1)
				if (ConstantesSign.ALIVE.equals(cell[i - 1].getState())
						&& ConstantesSign.ALIVE.equals(cell[i + 1].getState())) {
					resultCell[i].setState(ConstantesSign.ALIVE);
				}
		}

		grid.setCell(resultCell);

	}

	/**
	 * 
	 * @param entry : l'entrée de notre jeu et qui contienne nos données : nbrEvo, dimension et l'etat initial de la grille.
	 *  ==> evolue la grille pour nbrEvo itérations et l'affiche pour chaque itération.
	 */
	public Grid changeGrid(Map<String, String> entry) {
		// I)-Entrée
		int nbrEvolution = Integer.parseInt(entry.get("nbrEvolutions"));
		String dimension = entry.get("dimension");
		String initialGrid = entry.get("initialGrid");
		// II)-Affichage de l'etat initial de la grille 
		System.out.println("Nombre d'itérations : " + nbrEvolution + "\n" + "Dimension initiale : " + dimension + "\n"
				+ "Etat initial de la grille : " + initialGrid+"\n");

		// III)-Construction de l'objet Grid 
		Grid grid = getGrid(dimension, initialGrid);
		// IV)-Evolution et affichage de la grille pour chaque itéaration
		for (int i = 0; i < nbrEvolution; i++) {
			changeValue(grid);
			System.out.println("Iteration: " + i + " ==>  Resultat : ");
			StringBuilder builder = new StringBuilder();
			for (int j = 0; j < grid.getCell().length; j++) {
				builder.append((grid.getCell()[j].getState()));
			}
			System.out.println(builder.toString());
		}
		System.out.println("\n");
		return grid;
	}

	/**
	 * 
	 * @param dimension 
	 * @param initialGrid : chaine de caractères qui construit l'etat initial du grille
	 * @return
	 */
	private Grid getGrid(String dimension, String initialGrid) {

		// Dans ce cas x est tjrs égal à 1
		int y = Integer.parseInt(dimension.split("X")[1]);

		Cell[] cell = new Cell[y];
		Grid grid = new Grid(cell);

		for (int i = 0; i < initialGrid.length(); i++) {
			cell[i] = new Cell(String.valueOf(initialGrid.charAt(i)));
		}

		grid.setCell(cell);

		return grid;

	}

}
