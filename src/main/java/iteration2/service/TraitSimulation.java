package iteration2.service;

import iteration2.model.Grille;

public class TraitSimulation {

	private PrintConsole printConsole;
	private String dimension;
	private Integer iterationNombre;
	private Grille grille;


	public TraitSimulation() {
	}

	public void setPrintConsole(PrintConsole printConsole) {
		this.printConsole = printConsole;
	}

	public TraitSimulation(String dimension, int iterationNombre, Grille grille) {
		this.dimension = dimension;
		this.iterationNombre = iterationNombre;
		this.grille = grille;
	}

	public void start() {
		printConsole.ecrire(this.dimension, 0, grille);
		for (int i = 1; i <= this.iterationNombre; i++) {
			grille.evolution();
			printConsole.ecrire(this.dimension, i, grille);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TraitSimulation other = (TraitSimulation) obj;
		if (!dimension.equals(other.dimension))
			return false;
		if (grille == null) {
			if (other.grille != null)
				return false;
		} else if (!grille.equals(other.grille))
			return false;
		if (iterationNombre != other.iterationNombre)
			return false;
		return true;
	}
}
