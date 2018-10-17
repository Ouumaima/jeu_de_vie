package iteration1;

import iteration1.model.Cellule;
import iteration1.model.Grid;
import iteration1.service.LoadFile;
import iteration1.service.LoadFileImpl;
import iteration1.service.Traitement;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LoadFileTest {

	private Traitement targetSimulator;

	@Test
	public void should_Return_Target_Simulator10() {

		Cellule cell = new Cellule(true);
		Grid grid = new Grid(cell);

		targetSimulator = new Traitement("1*1", 3, grid);

		LoadFile loader = new LoadFileImpl();

		Traitement simulator = loader.load("src\\test\\ressource\\data10.txt");

		Assertions.assertThat(targetSimulator).isEqualTo(simulator);
	}

	@Test
	public void should_Return_Target_Simulator01() {

		Cellule cell = new Cellule(false);
		Grid grid = new Grid(cell);

		targetSimulator = new Traitement("1*1", 3, grid);

		LoadFile loader = new LoadFileImpl();

		Traitement simulator = loader.load("src\\test\\ressource\\data11.txt");

		Assertions.assertThat(targetSimulator).isEqualTo(simulator);
	}

}
