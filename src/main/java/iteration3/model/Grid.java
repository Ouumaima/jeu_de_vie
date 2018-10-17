package iteration3.model;

import java.util.Arrays;

public class Grid {

	private Cellule[][] cells;

	public Grid() {
		super();
	}

	public Grid(Cellule[][] cells) {
		super();
		this.cells = cells;
	}

	public Cellule[][] getCells() {
		return cells;
	}

	public void setCells(Cellule[][] cells) {
		this.cells = cells;
	}

	public Cellule[][] duplicateCells() {
		Cellule[][] tempCells = new Cellule[cells.length][cells[0].length];
		for (int i = 0; i < tempCells.length; i++) {
			for (int j = 0; j < tempCells[i].length; j++) {
				tempCells[i][j] = new Cellule(cells[i][j].isLive());
			}
		}
		return tempCells;
	}

	public int sum(int i, int j) {
		int sum = 0;
		int living = 0;
		if (this.isLiving(i, j)) {
			living = 1;
		}
		// parcours des cellules alentours
		for (int k = i - 1; k <= i + 1; k++) {
			for (int h = j - 1; h <= j + 1; h++) {
				// sauf la cellule concerne
				if (this.isLiving(k, h)) {
					sum += 1;
				}

			}
		}
		return sum - living;
	}

	public boolean isLiving(int i, int j) {
		try {
			if (cells[i][j] != null) {

				return (cells[i][j].isLive() == true);
			}
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
		return false;
	}

	public Boolean newState(int i, int j) {
		int sum = this.sum(i, j);
		if (sum == 3) {
			return true;
		}
		if (this.isLiving(i, j) && sum == 2) {
			return true;
		}
		if (sum < 2 || sum > 3) {
			return false;
		}
		return false;

	}

	public void evolution() {
		Cellule[][] tempCells = this.duplicateCells();
		for (int i = 0; i < tempCells.length; i++) {
			for (int j = 0; j < tempCells[i].length; j++) {
				tempCells[i][j].setLive(newState(i, j));
			}
		}
		this.cells = tempCells;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Grid [cells=" + Arrays.toString(cells) + "]";
	}

}
