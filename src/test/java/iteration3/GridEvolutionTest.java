package iteration3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



import org.assertj.core.api.Assertions;
import org.junit.Test;

import lifegame.commun.ConstantesSign;
import lifegame.iteration3.Cell;
import lifegame.iteration3.Grid;
import lifegame.iteration3.GridEvolution;

public class GridEvolutionTest {

	private Grid expectedGrid;
	private GridEvolution gridEvolution  = new GridEvolution();
	private Map<String, String> entryExpected = new HashMap<String, String>();

	@Test
	public void should_Return_Entry_Expected1() throws IOException {

		//given
		String fileName = getClass().getResource("/demos/iteration1").getPath();
		entryExpected.put("nbrEvolutions", "8");
		entryExpected.put("dimension", "1X1");
		entryExpected.put("initialGrid", "-");
		//when
		Map<String, String> entry = gridEvolution.getEntry(fileName);
		//then
		testMapData(entry);
		
	}

	@Test
	public void should_Return_Entry_Expected2() throws IOException {

		//given
		String fileName = getClass().getResource("/demos/iteration2").getPath();
		entryExpected.put("nbrEvolutions", "8");
		entryExpected.put("dimension", "1X4");
		entryExpected.put("initialGrid", "-+++");
		//when
		Map<String, String> entry = gridEvolution.getEntry(fileName);
		//then
		testMapData(entry);	
	}
	
	@Test
	public void should_Return_Entry_Expected3() throws IOException {

		//given
		String fileName = getClass().getResource("/demos/iteration3").getPath();
		entryExpected.put("nbrEvolutions", "3");
		entryExpected.put("dimension", "3X3");
		entryExpected.put("initialGrid", "---X+++X---");
		//when
		Map<String, String> entry = gridEvolution.getEntry(fileName);
		//then
		Assertions.assertThat(entryExpected).isEqualTo(entry);
	}
	
	private void testMapData(Map<String, String> entry) {
		Assertions.assertThat(entryExpected.get("nbrEvolutions")).isEqualTo(entry.get("nbrEvolutions"));
		Assertions.assertThat(entryExpected.get("dimension")).isEqualTo(entry.get("dimension"));
		Assertions.assertThat(entryExpected.get("initialGrid")).isEqualTo(entry.get("initialGrid"));
	}
	
	
	@Test
	public void should_Return_Grid_With_One_Dead_Cell_When_initial_Allive_Cell() {
		
		//given
		Map<String, String> entryWithOneAliveCell = new HashMap<String, String>();
		entryWithOneAliveCell.put("nbrEvolutions", "8");
		entryWithOneAliveCell.put("dimension", "1X1");
		entryWithOneAliveCell.put("initialGrid", "+");
		
		Cell c1 = new Cell(ConstantesSign.DEAD);
		Cell[][] cells1 = { {c1}};
		expectedGrid = new Grid(cells1);
		//when
		Grid gridChanged = gridEvolution.changeGrid(entryWithOneAliveCell);
		//then
		Assertions.assertThat(expectedGrid).isEqualTo(gridChanged);
	}

	@Test
	public void should_Return_Grid_With_One_Dead_Cell_When_initial_DEAD_Cell() {
		
		//given
		Map<String, String> entryWithOneDeadCell = new HashMap<String, String>();
		entryWithOneDeadCell.put("nbrEvolutions", "8");
		entryWithOneDeadCell.put("dimension", "1X1");
		entryWithOneDeadCell.put("initialGrid", "-");
		
		Cell c1 = new Cell(ConstantesSign.DEAD);
		Cell[][] cells1 = { {c1}};
		expectedGrid = new Grid(cells1);
		
		//when
		Grid gridChanged = gridEvolution.changeGrid(entryWithOneDeadCell);
		//then
		Assertions.assertThat(expectedGrid).isEqualTo(gridChanged);
	}
	
	
	@Test
	public void should_Return_Expected_Grid_When_Dimension_OfInitial_Grid_is_1X4() {
		
		//given
		Map<String, String> entryWithOneDeadCell = new HashMap<String, String>();
		entryWithOneDeadCell.put("nbrEvolutions", "8");
		entryWithOneDeadCell.put("dimension", "1X4");
		entryWithOneDeadCell.put("initialGrid", "-+-+");
		
		Cell c1 = new Cell(ConstantesSign.DEAD);
		Cell[][] cells1 = { {c1,c1,c1,c1}};
		expectedGrid = new Grid(cells1);
		
		//when
		Grid gridChanged = gridEvolution.changeGrid(entryWithOneDeadCell);
		//then
		Assertions.assertThat(expectedGrid).isEqualTo(gridChanged);
	}
	
	@Test
	public void should_Return_Expected_Grid_When_Dimension_OfInitial_Grid_is_1X6() {
		
		//given
		Map<String, String> entryWithOneDeadCell = new HashMap<String, String>();
		entryWithOneDeadCell.put("nbrEvolutions", "1");
		entryWithOneDeadCell.put("dimension", "1X6");
		entryWithOneDeadCell.put("initialGrid", "-+++-+");
		
		Cell c1 = new Cell(ConstantesSign.DEAD);
		Cell c2 = new Cell(ConstantesSign.ALIVE);
		Cell[][] cells1 = {{ c1,c1,c2,c1,c1,c1}};
		expectedGrid = new Grid(cells1);
		
		//when
		Grid gridChanged = gridEvolution.changeGrid(entryWithOneDeadCell);
		//then
		Assertions.assertThat(expectedGrid).isEqualTo(gridChanged);
	}
	
	
	@Test
	public void should_Return_Expected_Grid_When_Dimension_OfInitial_Grid_is_2X2() {
		
		//given
		Map<String, String> entryWithOneDeadCell = new HashMap<String, String>();
		entryWithOneDeadCell.put("nbrEvolutions", "3");
		entryWithOneDeadCell.put("dimension", "2X2");
		entryWithOneDeadCell.put("initialGrid", "-+X++");
		
		Cell c2 = new Cell(ConstantesSign.ALIVE);
		Cell[][] cells1 = {{ c2,c2},
						   { c2,c2}};
		expectedGrid = new Grid(cells1);
		
		//when
		Grid gridChanged = gridEvolution.changeGrid(entryWithOneDeadCell);
		//then
		Assertions.assertThat(expectedGrid).isEqualTo(gridChanged);
	}
	
	
	@Test
	public void should_Return_Expected_Grid_When_Dimension_OfInitial_Grid_is_3X3() {
		
		//given
		Map<String, String> entryWithOneDeadCell = new HashMap<String, String>();
		entryWithOneDeadCell.put("nbrEvolutions", "3");
		entryWithOneDeadCell.put("dimension", "3X3");
		entryWithOneDeadCell.put("initialGrid", "---X+++X---");
		
		Cell c1 = new Cell(ConstantesSign.DEAD);
		Cell c2 = new Cell(ConstantesSign.ALIVE);
		Cell[][] cells1 = {{ c1,c2,c1},
						   { c1,c2,c1},
						   { c1,c2,c1}};
		expectedGrid = new Grid(cells1);
		
		//when
		Grid gridChanged = gridEvolution.changeGrid(entryWithOneDeadCell);
		//then
		Assertions.assertThat(expectedGrid).isEqualTo(gridChanged);
	}

}
