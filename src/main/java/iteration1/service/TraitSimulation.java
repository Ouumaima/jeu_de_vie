package iteration1.service;

import iteration1.model.Grille;

public class TraitSimulation {

	private PrintConsole printConsole;
	private String dimension;
	private Integer iterationNombre;
	private Grille grille;

	public TraitSimulation() {
	}

	public PrintConsole getPrintService() {
		return printConsole;
	}

	public void setPrintService(PrintConsole printConsole) {
		this.printConsole = printConsole;
	}

	public TraitSimulation(String dimension, int iterationNombre, Grille grille) {
		this.dimension = dimension;
		this.iterationNombre = iterationNombre;
		this.grille = grille;
	}

	public void traitemet() {
		printConsole.ecrire(0, grille);
		for (int i = 1; i <= this.iterationNombre; i++) {
			grille.evolution();
			printConsole.ecrire(i, grille);
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