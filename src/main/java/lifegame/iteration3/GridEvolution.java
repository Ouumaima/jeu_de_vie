package lifegame.iteration3;

import java.io.BufferedReader;
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
		java.io.FileReader fileReader = new java.io.FileReader(fileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		while ((line = bufferedReader.readLine()) != null) {
			lstLines.add(line);
		}
		bufferedReader.close();
		// II)-Sauvegarde des des donn�es d'initialisation du jeu dans le map
		Map<String, String> entry = new HashMap<String, String>();
		entry.put("nbrEvolutions", lstLines.get(0));
		entry.put("dimension", lstLines.get(1));
		String initialGrid = "";
		// III)-L'id�e est de regrouper les lignes de la grille initiale
		// dans une seule ligne qu'on splitera apr�s sur le caract�re X
		for (int i = 2; i < lstLines.size(); i++) {
			initialGrid += lstLines.get(i);
			if (i != lstLines.size() - 1) {
				initialGrid += "X";
			}
		}
		entry.put("initialGrid", initialGrid);
		return entry;
	}

	/**
	 * Evolution de la grille
	 * 
	 * @param grid
	 */
	private void changeValue(Grid grid) {
		Cell[][] cell = grid.getCell();
		Cell[][] resultCell = new Cell[cell.length][cell[0].length];
		for (int i = 0; i < cell.length; i++) {
			for (int j = 0; j < cell[i].length; j++) {
				resultCell[i][j] = new Cell(returnNextState(cell, i, j));
			}
		}
		grid.setCell(resultCell);
	}

	/**
	 * 
	 * @param cell
	 * @param i
	 * @param j
	 * @return : retourner l'etat de la cellulle (i,j) dans l'it�ration qui suit
	 */
	private String returnNextState(Cell[][] cell, int i, int j) {

		int calculSumLiveCell = 0;

		for (int k1 = i - 1; k1 <= i + 1; k1++) {
			for (int k2 = j - 1; k2 <= j + 1; k2++) {
				try {
					if (cell[k1][k2].getState().equals(ConstantesSign.ALIVE))
						calculSumLiveCell += 1;

				} catch (IndexOutOfBoundsException e) {
					continue;
				}
			}
		}

		// Dans la boucle au dessus on calcule le nombre de cellules voisines vivantes y
		// compris la cellule concern�e
		// du coup on teste avec les valeurs 3 et 4
		if (cell[i][j].getState().equals(ConstantesSign.ALIVE) && (calculSumLiveCell == 3 || calculSumLiveCell == 4)) {
			return ConstantesSign.ALIVE;
		}
		if (cell[i][j].getState().equals(ConstantesSign.DEAD) && calculSumLiveCell == 3) {
			return ConstantesSign.ALIVE;
		}
		return ConstantesSign.DEAD;
	}

	/**
	 * 
	 * @param entry : l'entr�e de notre jeu : le map qui contient nos donn�es : nbrEvo,
	 *              dimension et l'etat initial de la grille ==> evolue la grille pour nbrEvo it�rations et l'affiche pour chaque it�ration.
	 */
	public Grid changeGrid(Map<String, String> entry) {

		// I)-les entr�es
		int nbrEvolution = Integer.parseInt(entry.get("nbrEvolutions"));
		String dimension = entry.get("dimension");
		String initialGrid = entry.get("initialGrid");
		// II)-Affichage �tat initial
		System.out.println("Nombre d'it�rations : " + nbrEvolution + "\n" + "Dimension initiale : " + dimension + "\n"
				+ "Etat initial de la grille : " + initialGrid + "\n");
		// III)-Construction de la grille
		Grid grid = getGrid(dimension, initialGrid);
		// IV)-Evolution de la grille
		for (int i = 0; i < nbrEvolution; i++) {
			changeValue(grid);
			System.out.println("Iteration: " + (i+1) + " ==>  Resultat : ");
			StringBuilder builder = new StringBuilder();
			for (int j = 0; j < grid.getCell().length; j++) {
				builder.append("\n");
				for (int j2 = 0; j2 < grid.getCell()[j].length; j2++) {
					builder.append((grid.getCell()[j][j2].getState()));
				}

			}
			System.out.println(builder.toString());
		}
		System.out.println("\n");
		return grid;
	}

	private Grid getGrid(String dimension, String initialGrid) {
		
		// I)-Dimention
		int x = Integer.parseInt(dimension.split("X")[0]);
		int y = Integer.parseInt(dimension.split("X")[1]);
		int siseTab = initialGrid.split("X").length;
		// II)- tableau split� de l'etat initial de la grille
		String[] valGrid = initialGrid.split("X");
		Cell[][] cell = new Cell[x][y];
		for (int i = 0; i < siseTab; i++) {
			for (int j = 0; j < valGrid[i].length(); j++) {
				cell[i][j] = new Cell(String.valueOf(valGrid[i].charAt(j)));
			}
		}
		Grid grid = new Grid(cell);
		return grid;

	}

}
