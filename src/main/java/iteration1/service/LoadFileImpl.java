package iteration1.service;

import iteration1.model.Cellule;
import iteration1.model.Grid;

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
		String dimension = extractDimension(line);
		Grid grid = this.extractGrid(line);

		Traitement simulator = new Traitement(dimension, evolution, grid);

		return simulator;

	}

	public String extractDimension(String line) {
		String[] result = line.split(",");
		return result[0];
	}

	public int extractEvolution(String line) {
		String[] result = line.split(",");
		return Integer.parseInt(result[1]);
	}

	private Grid extractGrid(String line) {
		Cellule cell = new Cellule(true);
		String[] result = line.split(",");
		if (result[2].equals("-")) {
			cell.setLive(false);
			;
		}

		return new Grid(cell);
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
