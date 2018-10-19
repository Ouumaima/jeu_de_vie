package iteration1;

import iteration1.model.Cellule;
import iteration1.model.Grille;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class TraitementTest {

	private Grille grilleAcUneCelluleVivante;
	private Grille grilleAcUneCelluleMorte;
	private Grille expectedGrille;

	@Before
	public void setUp() throws Exception {
		
		grilleAcUneCelluleVivante = new Grille(new Cellule(true));
		grilleAcUneCelluleMorte = new Grille(new Cellule(false));
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

}
