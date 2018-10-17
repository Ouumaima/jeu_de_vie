package iteration3;

import iteration3.model.Cellule;
import iteration3.model.Grid;
import iteration3.service.LoadFile;
import iteration3.service.LoadFileImpl;
import iteration3.service.Traitement;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LoadFileTest {

	private Traitement targetSimulator;

	@Test
	public void should_Return_Target_Simulator10() {

		Cellule[][] cells = new Cellule[1][1];
		cells[0][0] = new Cellule(true);
		Grid grid = new Grid(cells);
		String[] dim = { "1", "1" };
		targetSimulator = new Traitement(dim, 4, grid);

		LoadFile loader = new LoadFileImpl();

		Traitement simulator = loader.load("src\\test\\ressource\\data10.txt");

		Assertions.assertThat(targetSimulator).isEqualTo(simulator);
	}

	@Test
	public void should_Return_Target_Simulator11() {

		Cellule[][] cells = new Cellule[1][1];
		cells[0][0] = new Cellule(false);
		Grid grid = new Grid(cells);
		String[] dim = { "1", "1" };
		targetSimulator = new Traitement(dim, 4, grid);

		LoadFile loader = new LoadFileImpl();

		Traitement simulator = loader.load("src\\test\\ressource\\data11.txt");

		Assertions.assertThat(targetSimulator).isEqualTo(simulator);
	}

	@Test
	public void should_Return_Target_Simulator12() {

		Cellule[][] cells = new Cellule[1][2];
		cells[0][0] = new Cellule(false);
		cells[0][1] = new Cellule(false);
		Grid grid = new Grid(cells);
		String[] dim = { "1", "2" };
		targetSimulator = new Traitement(dim, 4, grid);

		LoadFile loader = new LoadFileImpl();

		Traitement simulator = loader.load("src\\test\\ressource\\data12.txt");

		Assertions.assertThat(targetSimulator).isEqualTo(simulator);
	}

	@Test
	public void should_Return_Target_Simulator22() {

		Cellule[][] cells = new Cellule[2][2];
		cells[0][0] = new Cellule(false);
		cells[0][1] = new Cellule(true);
		cells[1][0] = new Cellule(false);
		cells[1][1] = new Cellule(true);
		Grid grid = new Grid(cells);
		String[] dim = { "2", "2" };
		targetSimulator = new Traitement(dim, 4, grid);

		LoadFile loader = new LoadFileImpl();

		Traitement simulator = loader.load("src\\test\\ressource\\data22.txt");

		Assertions.assertThat(targetSimulator).isEqualTo(simulator);
	}
}
