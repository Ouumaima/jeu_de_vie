package iteration1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import lifegame.commun.ConstantesSign;
import lifegame.iteration1.Grid;
import lifegame.iteration1.GridEvolution;

public class GridEvolutionTest {
	
	private GridEvolution gridEvolution = new GridEvolution();
	
	@Test
	public void should_Return_Entry_Expected() throws IOException {

		// given
		Map<String, String> entryExpected = new HashMap<String, String>();
		entryExpected.put("nbrEvolutions", "8");
		entryExpected.put("dimension", "1X1");
		entryExpected.put("initialSign", "-");
		String fileName = getClass().getResource("/demos/iteration1").getPath();
		// when
		Map<String, String> entry = gridEvolution.getEntry(fileName);
		// then
		Assertions.assertThat(entryExpected.get("nbrEvolutions")).isEqualTo(entry.get("nbrEvolutions"));
		Assertions.assertThat(entryExpected.get("dimension")).isEqualTo(entry.get("dimension"));
		Assertions.assertThat(entryExpected.get("initialSign")).isEqualTo(entry.get("initialSign"));
	}

	@Test
	public void should_Return_Grid_With_One_Dead_Cell_When_initial_Allive_Cell() {
		// given
		Map<String, String> entryWithOneAliveCell = new HashMap<String, String>();
		entryWithOneAliveCell.put("nbrEvolutions", "8");
		entryWithOneAliveCell.put("dimension", "1");
		entryWithOneAliveCell.put("initialSign", "+");
		// when
		Grid returnCall = gridEvolution.changeGrid(entryWithOneAliveCell);
		// then
		Assertions.assertThat(ConstantesSign.DEAD).isEqualTo(returnCall.getCell().getState());
	}

	@Test
	public void should_Return_Grid_With_One_Dead_Cell_When_initial_DEAD_Cell() {
		// given
		Map<String, String> entryWithOneDeadCell = new HashMap<String, String>();
		entryWithOneDeadCell.put("nbrEvolutions", "8");
		entryWithOneDeadCell.put("dimension", "1");
		entryWithOneDeadCell.put("initialSign", "-");
		// when
		Grid returnCall = gridEvolution.changeGrid(entryWithOneDeadCell);
		// then
		Assertions.assertThat(ConstantesSign.DEAD).isEqualTo(returnCall.getCell().getState());
	}

}
