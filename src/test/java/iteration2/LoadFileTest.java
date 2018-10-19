package iteration2;

import iteration2.service.TraitSimulation;
import iteration2.model.Cellule;
import iteration2.model.Grille;
import iteration2.service.LoadFile;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LoadFileTest {

	private TraitSimulation expectedSimulation;
	
	@Test
	public void should_Return_Expected_Simulation10() {

		Grille grille = new Grille(new Cellule(true));
		expectedSimulation = new TraitSimulation("1*1", 4, grille);
		LoadFile loader = new LoadFile();
		TraitSimulation Simulation = loader.load("src\\test\\ressource\\data10.txt");
		Assertions.assertThat(expectedSimulation).isEqualTo(Simulation);
	}

	@Test
	public void should_Return_Expected_Simulation01() {

		Grille grid = new Grille(new Cellule(false));
		expectedSimulation = new TraitSimulation("1*1", 4, grid);
		LoadFile loader = new LoadFile();
		TraitSimulation Simulation = loader.load("src\\test\\ressource\\data11.txt");
		Assertions.assertThat(expectedSimulation).isEqualTo(Simulation);
	}

	@Test
	public void should_Return_Target_Simulator12() {

		Grille grid = new Grille(new Cellule(false), new Cellule(false));
		expectedSimulation = new TraitSimulation("1*2", 4, grid);
		LoadFile loader = new LoadFile();
		TraitSimulation Simulation = loader.load("src\\test\\ressource\\data12.txt");
		Assertions.assertThat(expectedSimulation).isEqualTo(Simulation);
	}

	@Test
	public void should_Return_Target_Simulator21() {

		Grille grille = new Grille(new Cellule(false), new Cellule(true));
		expectedSimulation = new TraitSimulation("2*1", 4, grille);
		LoadFile loader = new LoadFile();
		TraitSimulation Simulation = loader.load("src\\test\\ressource\\data21.txt");
		Assertions.assertThat(expectedSimulation).isEqualTo(Simulation);
	}
}
