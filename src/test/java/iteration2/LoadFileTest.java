package iteration2;

import iteration2.model.Cellule;
import iteration2.model.Grid;
import iteration2.service.LoadFile;
import iteration2.service.LoadFileImpl;
import iteration2.service.Traitement;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LoadFileTest {

	private Traitement targetSimulator;

	@Test
	public void should_Return_Target_Simulator10() {

		Cellule firstCellule = new Cellule(true);
		Grid grid = new Grid(firstCellule);

		targetSimulator = new Traitement("1*1", 3, grid);

		LoadFile loader = new LoadFileImpl();

		Traitement simulator = loader.load("src\\test\\ressource\\data10.txt");

		Assertions.assertThat(targetSimulator).isEqualTo(simulator);
	}

	@Test
	public void should_Return_Target_Simulator11() {

		Cellule firstCellule = new Cellule(false);
		Grid grid = new Grid(firstCellule);

		targetSimulator = new Traitement("1*1", 3, grid);

		LoadFile loader = new LoadFileImpl();

		Traitement simulator = loader.load("src\\test\\ressource\\data11.txt");

		Assertions.assertThat(targetSimulator).isEqualTo(simulator);
	}

	@Test
	public void should_Return_Target_Simulator12() {

		Cellule firstCellule = new Cellule(false);
		Cellule secondCellule = new Cellule(false);
		Grid grid = new Grid(firstCellule, secondCellule);

		targetSimulator = new Traitement("1*2", 3, grid);

		LoadFile loader = new LoadFileImpl();

		Traitement simulator = loader.load("src\\test\\ressource\\data12.txt");

		Assertions.assertThat(targetSimulator).isEqualTo(simulator);
	}

	@Test
	public void should_Return_Target_Simulator21() {

		Cellule firstCellule = new Cellule(false);
		Cellule secondCellule = new Cellule(true);
		Grid grid = new Grid(firstCellule, secondCellule);

		targetSimulator = new Traitement("2*1", 4, grid);

		LoadFile loader = new LoadFileImpl();

		Traitement simulator = loader.load("src\\test\\ressource\\data21.txt");

		Assertions.assertThat(targetSimulator).isEqualTo(simulator);
	}
}
