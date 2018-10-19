package iteration1;

import iteration1.model.Cellule;
import iteration1.model.Grille;
import iteration1.service.LoadFile;
import iteration1.service.TraitSimulation;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LoadFileTest {

	private TraitSimulation expectedSimulation;

	@Test
	public void should_Return_Expected_Simulation10() {

		Cellule cellule = new Cellule(true);
		Grille grille = new Grille(cellule);
		expectedSimulation = new TraitSimulation("1*1", 4, grille);
		LoadFile loader = new LoadFile();
		TraitSimulation Simulation = loader.load("src\\test\\ressource\\data10.txt");
		Assertions.assertThat(expectedSimulation).isEqualTo(Simulation);
	}

	@Test
	public void should_Return_Expected_Simulation01() {

		Cellule cell = new Cellule(false);
		Grille grid = new Grille(cell);
		expectedSimulation = new TraitSimulation("1*1", 4, grid);
		LoadFile loader = new LoadFile();
		TraitSimulation Simulation = loader.load("src\\test\\ressource\\data11.txt");
		Assertions.assertThat(expectedSimulation).isEqualTo(Simulation);
	}

}
