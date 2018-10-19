package iteration1.model;

public class Grille {

	private Cellule cellule;

	public Grille() {
	}

	public Grille(Cellule cellule) {
		super();
		this.cellule = cellule;
	}

	public void evolution() {
		this.cellule.setEnVie(false);
	}

	public Cellule getCellule() {
		return cellule;
	}

	public void setCellule(Cellule cellule) {
		this.cellule = cellule;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cellule == null) ? 0 : cellule.hashCode());
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
		Grille other = (Grille) obj;
		if (cellule == null) {
			if (other.cellule != null)
				return false;
		} else if (!cellule.equals(other.cellule))
			return false;
		return true;
	}

	
}
