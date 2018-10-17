package iteration3.model;


public class Cellule {
	private boolean live = false;

	public Cellule() {
	}

	public Cellule(boolean live) {
		super();
		this.live = live;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
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
		if (live != other.live)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Cell [live=" + live + "]";
	}
}
