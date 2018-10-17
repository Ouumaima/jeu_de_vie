package iteration3.service;

import java.util.Arrays;

import iteration3.model.Grid;

public class Traitement {

	private PrintConsole printService;
	private String[] dimension;
	private Integer iterationNumber;
	private Grid grid;

	public Traitement() {
		super();
	}

	public PrintConsole getPrintService() {
		return printService;
	}

	public void setPrintService(PrintConsole printService) {
		this.printService = printService;
	}

	public String[] getDimension() {
		return dimension;
	}

	public void setDimension(String[] dimension) {
		this.dimension = dimension;
	}

	public int getIterationNumber() {
		return iterationNumber;
	}

	public void setIterationNumber(int iterationNumber) {
		this.iterationNumber = iterationNumber;
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public Traitement(String[] dimension, int iterationNumber, Grid grid) {
		super();
		this.dimension = dimension;
		this.iterationNumber = iterationNumber;
		this.grid = grid;
	}

	public void start() {
		printService.print(this.dimension, 0, grid);
		for (int i = 1; i <= this.iterationNumber; i++) {
			grid.evolution();
			printService.print(this.dimension, i, grid);
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
		Traitement other = (Traitement) obj;
		if (grid == null) {
			if (other.grid != null)
				return false;
		}
		if (iterationNumber != other.iterationNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Simulator [dimension=" + dimension + ", iterationNumber="
				+ iterationNumber + ", grid=" + grid + "]";
	}

}
