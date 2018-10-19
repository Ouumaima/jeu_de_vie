package iteration2;

import iteration2.model.Cellule;
import iteration2.model.Grille;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class TraitementTest {

	
	private Grille grilleAcUneCelluleVivante;
	private Grille grilleAcUneCelluleMorte;
	private Grille expectedGrille;
	

	private Grille grilleAcDeuxCellulesMortes;
	private Grille grilleAcCelluleVivanteEtCelluleMorte;
	private Grille grilleAcDeuxCellulesVivantes;

	@Before
	public void setUp() throws Exception {

		grilleAcUneCelluleVivante   = new Grille(new Cellule(true));
		grilleAcUneCelluleMorte = new Grille(new Cellule(false));
		grilleAcDeuxCellulesMortes = new Grille(new Cellule(false), new Cellule(false));
		grilleAcCelluleVivanteEtCelluleMorte = new Grille(new Cellule(false),new Cellule(true));
		grilleAcDeuxCellulesVivantes = new Grille(new Cellule(true), new Cellule(true));
		expectedGrille = new Grille(new Cellule(false));

	}

	@Test
	public void should_Return_Grille_Ac_Une_Cellule_Morte_When_Cellule_initiale_Vivante() {
		
		grilleAcUneCelluleVivante.evolution();
		Assertions.assertThat(expectedGrille).isEqualTo(grilleAcUneCelluleVivante);
	}

	@Test
	public void should_Return_Grille_Ac_Une_Cellule_Morte_When_Cellule_initiale_Morte() {
		
		grilleAcUneCelluleMorte.evolution();
		Assertions.assertThat(expectedGrille).isEqualTo(grilleAcUneCelluleMorte);
	}

	@Test
	
	public void should_Return_Grille_Ac_Deux_Cellules_Mortes_When_Deux_Cellules_initiales_Vivantes() {
		
		grilleAcDeuxCellulesVivantes.evolution();
		Assertions.assertThat(grilleAcDeuxCellulesMortes).isEqualTo(grilleAcDeuxCellulesVivantes);
	}

	@Test
	public void should_Return_Grille_Ac_Deux_Cellules_Mortes_When_Deux_Cellules_initiales_Mortes() {
		
		grilleAcDeuxCellulesMortes.evolution();
		Assertions.assertThat(grilleAcDeuxCellulesMortes).isEqualTo(grilleAcDeuxCellulesMortes);
	}

	@Test 
	public void should_Return_Grille_Ac_Deux_Cellules_Mortes_When_Une_Vivante_Deux_Morte() {
		
		grilleAcCelluleVivanteEtCelluleMorte.evolution();
		Assertions.assertThat(grilleAcDeuxCellulesMortes).isEqualTo(grilleAcCelluleVivanteEtCelluleMorte);
	}
}
