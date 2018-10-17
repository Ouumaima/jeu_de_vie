package iteration1;

import iteration1.model.Cellule;
import iteration1.model.Grid;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class TraitementTest {

	private Grid gridWithOneAliveCell;
	private Grid gridWithOneDEADCell;

	private Grid targetGrid;

	@Before
	public void setUp() throws Exception {

		Cellule aliveCell = new Cellule(true);
		Cellule deadCell = new Cellule(false);

		gridWithOneAliveCell = new Grid(aliveCell);
		gridWithOneDEADCell = new Grid(deadCell);

		Cellule targetCell = new Cellule(false);

		targetGrid = new Grid(targetCell);

	}

	@Test
	public void should_Return_A_Grid_With_A_DEAD_Cell_After_Current_ALIVEState() {
		gridWithOneAliveCell.evolution();

		Assertions.assertThat(targetGrid).isEqualTo(gridWithOneAliveCell);
	}

	@Test
	public void should_Return_A_Grid_With_A_DEAD_Cell_After_CurrentDEADState() {
		gridWithOneDEADCell.evolution();

		Assertions.assertThat(targetGrid).isEqualTo(gridWithOneDEADCell);
	}

}
