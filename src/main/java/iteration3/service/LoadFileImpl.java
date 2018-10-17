package iteration3.service;

import iteration3.model.Cellule;
import iteration3.model.Grid;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoadFileImpl implements LoadFile {

	@Override
	public Traitement load(String path) {
		String line;
		line = readFile(path);

		int evolution = extractEvolution(line);
		String[] dimension = extractDimension(line);
		Grid grid = this.extractGrid(line);

		Traitement simulator = new Traitement(dimension, evolution, grid);

		return simulator;

	}

	public String[] extractDimension(String line) {
		String[] result = line.split(",");
		String[] dim = result[0].split("/*");
		return dim;
	}

	public int extractEvolution(String line) {
		String[] result = line.split(",");
		return Integer.parseInt(result[1]);
	}

	private Grid extractGrid(String line) {

		String[] s = line.split(",");
		String prefix = s[0] + "," + s[1] + ",";
		String cellules = line
				.substring(line.indexOf(prefix) + prefix.length());
		String[] signs = cellules.split(",");
		String[] dimension = extractDimension(line);
		Cellule[][] cells = stringArrToCellArr(dimension, signs);
		return new Grid(cells);
	}

	private Cellule[][] stringArrToCellArr(String[] dim, String[] s) {
		int k = 0;
		Cellule[][] cell = new Cellule[Integer.parseInt(dim[0])][Integer
				.parseInt(dim[2])];
		for (int i = 0; i < Integer.parseInt(dim[0]); i++) {
			for (int j = 0; j < Integer.parseInt(dim[2]); j++) {
				if (s[k].equals("+")) {
					cell[i][j] = new Cellule(true);
				} else {
					cell[i][j] = new Cellule(false);
				}
				k++;
			}
		}
		return cell;
	}

	private String readFile(String path) {
		try {
			File f = new File(path);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			try {
				String line = br.readLine();

				while (line != null) {
					System.out.println(line);
					return line;
				}

				br.close();
				fr.close();
			} catch (IOException exception) {
				System.out.println("Erreur lors de la lecture : "
						+ exception.getMessage());
			}
		} catch (FileNotFoundException exception) {
			System.out.println("Le fichier n'a pas été trouvé");
		}
		return null;

	}

}
