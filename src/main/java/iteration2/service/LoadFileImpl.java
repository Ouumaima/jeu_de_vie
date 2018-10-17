package iteration2.service;

import iteration2.model.Cellule;
import iteration2.model.Grid;

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
		String[] s = line.split(",");
		String prefix = s[0] + "," + s[1] + ",";
		String lineWithNoPrefix = line.substring(line.indexOf(prefix)
				+ prefix.length());

		String[] result = lineWithNoPrefix.split(",");

		Cellule firstCell = new Cellule(true);

		if (result[0].equals("-")) {
			firstCell.setLive(false);
		}
		if (result.length > 1) {
			Cellule SecondCell = new Cellule(true);
			if (result[1].isEmpty()) {
				if (result[3].equals("-"))
					SecondCell.setLive(false);
				return new Grid(firstCell, SecondCell);
			} else {
				if (result[1].equals("-"))
					SecondCell.setLive(false);
				return new Grid(firstCell, SecondCell);
			}
		}
		return new Grid(firstCell);

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
