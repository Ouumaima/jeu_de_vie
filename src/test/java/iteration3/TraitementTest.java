package iteration3;

import iteration3.model.Cellule;
import iteration3.model.Grid;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class TraitementTest {

	private Grid targetSevenForGrid;
	private Grid sourceSevenForGrid;
	private Grid gridWithOneAliveCell;
	private Grid gridWithOneDEADCell;
	private Grid targetGrid;
	private Grid gridWithTwoDEADCells;
	private Grid gridWithOneDEADCellAndOneLiveCell;
	private Grid gridWithTwoLiveCells;
	private Grid targetTwoTwoGrid;
	private Grid sourceTwoTwoGrid;

	@Before
	public void setUp() throws Exception {

		Cellule c011 = new Cellule(true);
		Cellule c012 = new Cellule(false);
		Cellule c013 = new Cellule(true);
		Cellule c014 = new Cellule(true);
		Cellule c015 = new Cellule(true);
		Cellule c016 = new Cellule(true);
		Cellule c017 = new Cellule(true);

		Cellule[][] cells01 = { { c011 } };

		this.gridWithOneAliveCell = new Grid(cells01);

		Cellule[][] cells02 = { { c011, c012 } };

		this.gridWithOneDEADCellAndOneLiveCell = new Grid(cells02);

		Cellule[][] cells08 = { { c012, c012 } };

		this.gridWithTwoDEADCells = new Grid(cells08);

		Cellule[][] cells09 = { { c011, c011 } };

		this.gridWithTwoLiveCells = new Grid(cells09);

		Cellule[][] cells03 = { { c011, c012 }, { c011, c011 } };

		this.sourceTwoTwoGrid = new Grid(cells03);

		Cellule[][] cellTarget = { { c011, c011 }, { c011, c011 } };
		this.targetTwoTwoGrid = new Grid(cellTarget);

		Cellule[][] cells04 = { { c011, c012, c013, c014 },
				{ c012, c012, c013, c014 }, { c013, c012, c013, c014 },
				{ c014, c012, c013, c014 }, { c015, c012, c013, c014 },
				{ c016, c012, c013, c014 }, { c017, c012, c013, c014 } };

		this.sourceSevenForGrid = new Grid(cells04);

		Cellule[][] cells05 = { { c012, c011, c011, c011 },
				{ c012, c012, c012, c012 }, { c012, c012, c012, c012 },
				{ c011, c012, c012, c012 }, { c011, c012, c012, c012 },
				{ c011, c012, c012, c012 }, { c012, c012, c011, c011 } };

		this.targetSevenForGrid = new Grid(cells05);
		Cellule[][] cells06 = { { c012 } };
		this.targetGrid = new Grid(cells06);

		this.gridWithOneDEADCell = new Grid(cells05);
		Cellule[][] cells07 = { { c012 } };
		this.gridWithOneDEADCell = new Grid(cells07);

	}

	@Test
	public void should8_Return_targetSevenForGrid_from_sourceSevenForGrid() {
		sourceSevenForGrid.evolution();
		Assertions.assertThat(sourceSevenForGrid).isEqualTo(targetSevenForGrid);
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

	@Test
	public void should_Return_A_Grid_With_A_FoorLivesCell_After_Current_ONE_DEADState_AND_Three_LIVEState() {
		sourceTwoTwoGrid.evolution();

		Assertions.assertThat(targetTwoTwoGrid).isEqualTo(sourceTwoTwoGrid);
	}
}
