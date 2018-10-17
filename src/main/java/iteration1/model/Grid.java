package iteration1.model;

public class Grid {

	private Cellule cell;

	public Grid() {
		super();
	}

	public Grid(Cellule cell) {
		super();
		this.cell = cell;
	}

	public void evolution() {
		this.cell.setLive(false);
	}

	public Cellule getCell() {
		return cell;
	}

	public void setCell(Cellule cell) {
		this.cell = cell;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cell == null) ? 0 : cell.hashCode());
		return result;
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
		if (cell == null) {
			if (other.cell != null)
				return false;
		} else if (!cell.equals(other.cell))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Grid [cell=" + cell + "]";
	}
}
