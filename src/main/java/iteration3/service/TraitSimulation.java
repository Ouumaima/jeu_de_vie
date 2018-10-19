package iteration3.service;


import iteration3.model.Grille;

public class TraitSimulation {

	private PrintConsole printConsole;
	private Integer iterationNumber;
	private Grille grid;

	public TraitSimulation() {
	}

	public void setPrintConsole(PrintConsole printConsole) {
		this.printConsole = printConsole;
	}

	public TraitSimulation(int iterationNumber, Grille grid) {
		this.iterationNumber = iterationNumber;
		this.grid = grid;
	}

	public void start() {
		printConsole.ecrire( 0, grid);
		for (int i = 1; i <= this.iterationNumber; i++) {
			grid.evolution();
			printConsole.ecrire( i, grid);
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
		if (grid == null) {
			if (other.grid != null)
				return false;
		}
		if (iterationNumber != other.iterationNumber)
			return false;
		return true;
	}

}
