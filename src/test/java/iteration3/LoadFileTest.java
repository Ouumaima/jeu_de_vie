package iteration3;

import iteration3.model.Cellule;
import iteration3.model.Grille;
import iteration3.service.LoadFile;
import iteration3.service.TraitSimulation;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LoadFileTest {

	private TraitSimulation expectedSimulation;

	@Test
	public void should_Return_Target_Simulator10() {

		Cellule[][] cellules = new Cellule[1][1];
		cellules[0][0] = new Cellule(true);
		Grille grille = new Grille(cellules);
		expectedSimulation = new TraitSimulation( 4, grille);
		LoadFile loader = new LoadFile();
		TraitSimulation simulation = loader.load("src\\test\\ressource\\data10.txt");
		Assertions.assertThat(expectedSimulation).isEqualTo(simulation);
	}

	@Test
	public void should_Return_Target_Simulator11() {

		Cellule[][] cellules = new Cellule[1][1];
		cellules[0][0] = new Cellule(false);
		Grille grille = new Grille(cellules);
		expectedSimulation = new TraitSimulation( 4, grille);
		LoadFile loader = new LoadFile();
		TraitSimulation simulator = loader.load("src\\test\\ressource\\data11.txt");
		Assertions.assertThat(expectedSimulation).isEqualTo(simulator);
	}

	@Test
	public void should_Return_Target_Simulator12() {

		Cellule[][] cellules = new Cellule[1][2];
		cellules[0][0] = new Cellule(false);
		cellules[0][1] = new Cellule(false);
		Grille grille = new Grille(cellules);
		expectedSimulation = new TraitSimulation( 4, grille);
		LoadFile loader = new LoadFile();
		TraitSimulation simulator = loader.load("src\\test\\ressource\\data12.txt");
		Assertions.assertThat(expectedSimulation).isEqualTo(simulator);
	}

	@Test
	public void should_Return_Target_Simulator22() {

		Cellule[][] cellules = new Cellule[2][2];
		cellules[0][0] = new Cellule(false);
		cellules[0][1] = new Cellule(true);
		cellules[1][0] = new Cellule(false);
		cellules[1][1] = new Cellule(true);
		Grille grille = new Grille(cellules);
		expectedSimulation = new TraitSimulation( 4, grille);
		LoadFile loader = new LoadFile();
		TraitSimulation simulator = loader.load("src\\test\\ressource\\data22.txt");
		Assertions.assertThat(expectedSimulation).isEqualTo(simulator);
	}
}
