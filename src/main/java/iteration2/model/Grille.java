package iteration2.model;

public class Grille {

	private Cellule celluleUne;
	private Cellule CelluleDeux;

	public Grille() {
	}

	public Grille(Cellule cellule) {
		this.celluleUne = cellule;
	}

	public Grille(Cellule celluleUne, Cellule CelluleDeux) {
		this.celluleUne = celluleUne;
		this.CelluleDeux = CelluleDeux;
	}

	public Cellule getCelluleUne() {
		return celluleUne;
	}

	public void setCelluleUne(Cellule celluleUne) {
		this.celluleUne = celluleUne;
	}

	public Cellule getCelluleDeux() {
		return CelluleDeux;
	}

	public void setCelluleDeux(Cellule celluleDeux) {
		CelluleDeux = celluleDeux;
	}

	public void evolution() {
		this.celluleUne.setEnVie(false);
		if (CelluleDeux != null)
			this.CelluleDeux.setEnVie(false);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((CelluleDeux == null) ? 0 : CelluleDeux.hashCode());
		result = prime * result
				+ ((celluleUne == null) ? 0 : celluleUne.hashCode());
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
		if (CelluleDeux == null) {
			if (other.CelluleDeux != null)
				return false;
		} else if (!CelluleDeux.equals(other.CelluleDeux))
			return false;
		if (celluleUne == null) {
			if (other.celluleUne != null)
				return false;
		} else if (!celluleUne.equals(other.celluleUne))
			return false;
		return true;
	}

}
