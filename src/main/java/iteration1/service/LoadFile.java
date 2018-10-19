package iteration1.service;

import iteration1.model.Cellule;
import iteration1.model.Grille;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoadFile  {

	public TraitSimulation load(String path) {
		
		String ligne;
		ligne = readFile(path);
		int evolutionNbre = getNbEvolution(ligne);
		String dimension = getDimension(ligne);
		Grille grille = getGrille(ligne);
		TraitSimulation Simulation = new TraitSimulation(dimension, evolutionNbre, grille);
		return Simulation;

	}

	public String getDimension(String ligne) {
		String[] result = ligne.split(",");
		return result[0];
	}

	public int getNbEvolution(String ligne) {
		String[] result = ligne.split(",");
		return Integer.parseInt(result[1]);
	}

	private Grille getGrille(String ligne) {
		Cellule cellule = new Cellule(true);
		String[] result = ligne.split(",");
		if (result[2].equals("-")) {
			cellule.setEnVie(false);
		}

		return new Grille(cellule);
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
