package iteration3.service;

import iteration3.model.Cellule;
import iteration3.model.Grille;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoadFile{

	public TraitSimulation load(String path) {
		
		String ligne;
		ligne = readFile(path);
		int evolutionNbre = getNbEvolution(ligne);
		Grille grille = getGrille(ligne);
		TraitSimulation Simulation = new TraitSimulation( evolutionNbre, grille);
		return Simulation;

	}

	public String[] getDimension(String ligne) {
		String[] result = ligne.split(",");
		String[] dim = result[0].split("/*");
		return dim;
	}

	public int getNbEvolution(String ligne) {
		String[] result = ligne.split(",");
		return Integer.parseInt(result[1]);
	}

	private Grille getGrille(String ligne) {

		String[] s = ligne.split(",");
		String prefix = s[0] + "," + s[1] + ",";
		String ligneSansPrefix = ligne.substring(ligne.indexOf(prefix) + prefix.length());
		String[] signs = ligneSansPrefix.split(",");
		String[] dimension = getDimension(ligne);
		Cellule[][] cellules = convertToCellulesMatrice(dimension, signs);
		return new Grille(cellules);
	}

	private Cellule[][] convertToCellulesMatrice(String[] dim, String[] s) {
		int k = 0;
		Cellule[][] cellules = new Cellule[Integer.parseInt(dim[0])][Integer.parseInt(dim[2])];
		for (int i = 0; i < Integer.parseInt(dim[0]); i++) {
			for (int j = 0; j < Integer.parseInt(dim[2]); j++) {
				if (s[k].equals("+")) {
					cellules[i][j] = new Cellule(true);
				} else {
					cellules[i][j] = new Cellule(false);
				}
				k++;
			}
		}
		return cellules;
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
