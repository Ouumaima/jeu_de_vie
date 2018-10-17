package iteration2.model;

public class Grid {

	private Cellule firstCell;
	private Cellule secondCell;

	public Grid() {
		super();
	}

	public Grid(Cellule firstCell) {
		super();
		this.firstCell = firstCell;
	}

	public Grid(Cellule firstCell, Cellule secondCell) {
		super();
		this.firstCell = firstCell;
		this.secondCell = secondCell;
	}

	public Cellule getFirstCell() {
		return firstCell;
	}

	public void setFirstCell(Cellule firstCell) {
		this.firstCell = firstCell;
	}

	public Cellule getSecondCell() {
		return secondCell;
	}

	public void setSecondCell(Cellule secondCell) {
		this.secondCell = secondCell;
	}

	public void evolution() {
		this.firstCell.setLive(false);
		if (secondCell != null)
			this.secondCell.setLive(false);
		;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grid other = (Grid) obj;
		if (firstCell == null) {
			if (other.firstCell != null)
				return false;
		} else if (!firstCell.equals(other.firstCell))
			return false;
		if (secondCell == null) {
			if (other.secondCell != null)
				return false;
		} else if (!secondCell.equals(other.secondCell))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Grid [firstCell=" + firstCell + ", secondCell=" + secondCell
				+ "]";
	}

}
