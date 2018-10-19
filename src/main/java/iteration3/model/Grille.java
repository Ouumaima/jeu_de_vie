package iteration3.model;


import java.util.Arrays;

public class Grille {

	private Cellule[][] cellules;

	public Grille() {
	}

	public Grille(Cellule[][] cellules) {
		this.cellules = cellules;
	}

	public Cellule[][] getCellules() {
		return cellules;
	}

	public void setCellules(Cellule[][] cellules) {
		this.cellules = cellules;
	}

	public int sommeCellulesVivantes(int i, int j,int n, int m) {
		int somme = 0;
		if (i>=1 && j>=1){
			for (int k = i - 1; k <= i + 1; k++) {
				for (int h = j - 1; h <= j + 1; h++) {
					if (h != j || k != i ) {
						if (h != m || k == n ) {
							if (h == m || k != n )
								if (h != m || k != n )
									if (cellules[k][h].isEnVie())
										somme += 1;}
					}
				}
			}
		}
		
		if (i==0 && j>=1){
			for (int k = 0 ; k <= 1; k++) {
				for (int h = j - 1; h <= j + 1; h++) {
					if (h != j || k != i)  {
						if (h!=m){
							if (cellules[k][h].isEnVie())
								somme += 1;
						}
					}
				}
			}
		}
		
		if (i>=1 && j==0){
			for (int k = i -1 ; k <= i + 1; k++) {
				for (int h = 0 ; h <= 1; h++) {
					if (h != j || k != i ) {
						if (k!=n){
						if (cellules[k][h].isEnVie())
							somme += 1;}
					}
				}
			}
		}
		
		if (i==0 && j==0){
			for (int k = 0 ; k <= 1; k++) {
				for (int h = 0 ; h <= 1; h++) {
					if (h != j || k != i ) {
						if (cellules[k][h].isEnVie())
							somme += 1;
					}
				}
			}
		}
		return somme; 
	}


	public Boolean etatSuivante(int i, int j,int n,int m) {
		int sum = this.sommeCellulesVivantes(i, j,n,m);
		if (sum == 3) {
			return true;
		}
		if (sum < 2 || sum > 3) {
			return false;
		}
		if (cellules[i][j] != null) 
			if (cellules[i][j].isEnVie() == true && sum == 2) {
				return true;
		}
		return false;

	}

	public void evolution() {
		Cellule[][] celluleCopie =this.CopieCellule();
		if (celluleCopie.length >=2 &&  celluleCopie[0].length >= 2){
			for (int i = 0; i < celluleCopie.length; i++) {
				for (int j = 0; j < celluleCopie[i].length; j++) {
					celluleCopie[i][j].setEnVie(etatSuivante(i, j,celluleCopie.length,celluleCopie[0].length));
				}
			}
		} else {
			celluleCopie[0][0].setEnVie(false);
			if (celluleCopie[0].length == 2)
				celluleCopie[0][1].setEnVie(false);
			if (celluleCopie.length ==2 )
				celluleCopie[1][0].setEnVie(false);
		}
		this.cellules=celluleCopie;
		
		}
	
	

	public Cellule[][] CopieCellule() {
		Cellule[][] celluleCopie = new Cellule[cellules.length][cellules[0].length];
		for (int i = 0; i < celluleCopie.length; i++) {
			for (int j = 0; j < celluleCopie[i].length; j++) {
				celluleCopie[i][j] = new Cellule(cellules[i][j].isEnVie());
			}
		}
		return celluleCopie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(cellules);
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
		if (!Arrays.deepEquals(cellules, other.cellules))
			return false;
		return true;
	}

	

}
