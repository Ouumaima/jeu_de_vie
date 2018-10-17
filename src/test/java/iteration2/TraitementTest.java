package iteration2;

import iteration2.model.Cellule;
import iteration2.model.Grid;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class TraitementTest {

	private Grid gridWithOneAliveCell;
	private Grid gridWithOneDEADCell;

	private Grid gridWithTwoDEADCells;
	private Grid gridWithOneDEADCellAndOneLiveCell;
	private Grid gridWithTwoLiveCells;
	private Grid targetGrid;

	@Before
	public void setUp() throws Exception {

		Cellule aliveCell = new Cellule(true);
		Cellule deadCell = new Cellule(false);

		gridWithOneAliveCell = new Grid(aliveCell);
		gridWithOneDEADCell = new Grid(deadCell);

		Cellule targetCell = new Cellule(false);

		targetGrid = new Grid(targetCell);

		gridWithTwoDEADCells = new Grid(new Cellule(false), new Cellule(false));
		gridWithOneDEADCellAndOneLiveCell = new Grid(new Cellule(false),
				new Cellule(true));
		gridWithTwoLiveCells = new Grid(new Cellule(true), new Cellule(true));

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

	@Test
	public void should_Return_A_Grid_With_A_TWO_DEAD_Cell_After_Current_TWO_ALIVEState() {
		gridWithTwoLiveCells.evolution();

		Assertions.assertThat(gridWithTwoDEADCells).isEqualTo(
				gridWithTwoLiveCells);
	}

	@Test
	public void should_Return_A_Grid_With_A_TWO_DEAD_Cell_After_Current_TWO_DEADState() {
		gridWithTwoDEADCells.evolution();

		Assertions.assertThat(gridWithTwoDEADCells).isEqualTo(
				gridWithTwoDEADCells);
	}

	@Test
	public void should_Return_A_Grid_With_A_TWO_DEAD_Cell_After_Current_ONE_DEADState_AND_ONE_LIVEState() {
		gridWithOneDEADCellAndOneLiveCell.evolution();

		Assertions.assertThat(gridWithTwoDEADCells).isEqualTo(
				gridWithOneDEADCellAndOneLiveCell);
	}
}
