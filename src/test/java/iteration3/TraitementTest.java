package iteration3;

import iteration3.model.Cellule;
import iteration3.model.Grille;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class TraitementTest {

	private Grille ExpectedGrilleSeptQuatreDimension;
	private Grille GrilleAcSeptQuatreDimension;
	private Grille grilleAcUneCelluleVivante;
	private Grille grilleAcUneCelluleMorte;
	private Grille expectedGrille;
	private Grille grilleAcDeuxCellulesMortes;
	private Grille grilleAcCelluleVivanteEtCelluleMorte;
	private Grille grilleAcDeuxCellulesVivantes;
	private Grille ExpectedGrilleDeuxDeuxDimension;
	private Grille GrilleAcDeuxDeuxDimension;

	@Before
	public void setUp() throws Exception {

		Cellule c1 = new Cellule(true);
		Cellule c2 = new Cellule(false);
		Cellule c3 = new Cellule(true);
		Cellule c4 = new Cellule(true);
		Cellule c5 = new Cellule(true);
		Cellule c6 = new Cellule(true);
		Cellule c7 = new Cellule(true);

		Cellule[][] cells01 = { { c1 } };
		grilleAcUneCelluleVivante = new Grille(cells01);
		
		Cellule[][] cells02 = { { c2 } };
		grilleAcUneCelluleMorte = new Grille(cells02);
		
		expectedGrille = new Grille(cells02);

		Cellule[][] cells03 = { { c1, c1 } };
		grilleAcDeuxCellulesVivantes = new Grille(cells03);
		
		Cellule[][] cells04 = { { c2, c2 } };
		grilleAcDeuxCellulesMortes = new Grille(cells04);
		
		
		Cellule[][] cells05 = { { c1, c2 } };
		grilleAcCelluleVivanteEtCelluleMorte = new Grille(cells05);
		
		Cellule[][] cells06 = { { c1, c2 }, { c1, c1 } };
		GrilleAcDeuxDeuxDimension = new Grille(cells06);
		
		Cellule[][] cells07 = { { c1, c2, c3, c4 },
				{ c2, c2, c3, c4 }, { c3, c2, c3, c4 },
				{ c4, c2, c3, c4 }, { c5, c2, c3, c4 },
				{ c6, c2, c3, c4 }, { c7, c2, c3, c4 } };
		GrilleAcSeptQuatreDimension = new Grille(cells07);
		
		
		
		
		Cellule[][] cells08 = { { c2, c1, c1, c1 },
				{ c2, c2, c2, c2 }, { c2, c2, c2, c2 },
				{ c1, c2, c2, c2 }, { c1, c2, c2, c2 },
				{ c1, c2, c2, c2 }, { c2, c2, c1, c1 } };
		ExpectedGrilleSeptQuatreDimension = new Grille(cells08);
		


		Cellule[][] expectedCellule = { { c1, c1 }, 
									{ c1, c1 } };
		ExpectedGrilleDeuxDeuxDimension = new Grille(expectedCellule);

		

		
		
	}

	@Test
	public void should_Return_Grille_Ac_Une_Cellule_Morte_When_Cellule_initiale_Vivantetete() {
		
		grilleAcUneCelluleVivante.evolution();
		Assertions.assertThat(expectedGrille).isEqualTo(grilleAcUneCelluleVivante);
	}

	@Test
	public void should_Return_Grille_Ac_Une_Cellule_Morte_When_Cellule_initiale_Mortetete() {
		
		grilleAcUneCelluleMorte.evolution();
		Assertions.assertThat(expectedGrille).isEqualTo(grilleAcUneCelluleMorte);
	}

	@Test
	public void should_Return_Grille_Ac_Deux_Cellules_Mortes_When_Deux_Cellules_initiales_Vivantestete() {
		
		grilleAcDeuxCellulesVivantes.evolution();
		Assertions.assertThat(grilleAcDeuxCellulesMortes).isEqualTo(grilleAcDeuxCellulesVivantes);
	}

	@Test
	public void should_Return_Grille_Ac_Deux_Cellules_Mortes_When_Deux_Cellules_initiales_Mortestete() {
		
		grilleAcDeuxCellulesMortes.evolution();
		Assertions.assertThat(grilleAcDeuxCellulesMortes).isEqualTo(grilleAcDeuxCellulesMortes);
	}

	@Test
	public void should_Return_Grille_Ac_Deux_Cellules_Mortes_When_Une_Vivante_Deux_Mortetete() {
		
		grilleAcCelluleVivanteEtCelluleMorte.evolution();
		Assertions.assertThat(grilleAcDeuxCellulesMortes).isEqualTo(grilleAcCelluleVivanteEtCelluleMorte);
	}

	@  Test
	public void should_Return_Grille_Ac_4Cellules_Vivantes_When_Une_Morte_Trois_Vivantetate() {
		
		GrilleAcDeuxDeuxDimension.evolution();
		Assertions.assertThat(ExpectedGrilleDeuxDeuxDimension).isEqualTo(GrilleAcDeuxDeuxDimension);
	}
	@Test
	public void should_Return_ExpectedGrilleSeptQuatreDimension_from_ExpectedGrilleSeptQuatreDimension() {
		
		GrilleAcSeptQuatreDimension.evolution();
		Assertions.assertThat(ExpectedGrilleSeptQuatreDimension).isEqualTo(GrilleAcSeptQuatreDimension);
	}
}
