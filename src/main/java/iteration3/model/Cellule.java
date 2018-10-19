package iteration3.model;

import iteration3.model.Cellule;

public class Cellule {
	private boolean enVie ;

	public Cellule() {}

	public Cellule(boolean enVie) {
		this.enVie = enVie;
	}

	public boolean isEnVie() {
		return enVie;
	}

	public void setEnVie(boolean enVie) {
		this.enVie = enVie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (enVie ? 1231 : 1237);
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
		Cellule other = (Cellule) obj;
		if (enVie != other.enVie)
			return false;
		return true;
	}

	
}
