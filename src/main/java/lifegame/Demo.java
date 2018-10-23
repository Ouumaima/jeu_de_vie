package lifegame;

import java.io.IOException;

public class Demo {

	/**
	 * Execution du premier cas : dimension de la grille = 1.
	 */

	public void execute_one() throws IOException {
		lifegame.iteration1.GridEvolution grid = new lifegame.iteration1.GridEvolution();
		String fileName = getClass().getResource("/demos/iteration1").getPath();
		grid.changeGrid(grid.getEntry(fileName));
	}

	/**
	 * Execution du deuxième cas  : dimension de la grille = 1XN.
	 * @throws IOException
	 */
	public void execute_two() throws IOException {
		lifegame.iteration2.GridEvolution grid = new lifegame.iteration2.GridEvolution();
		String fileName = getClass().getResource("/demos/iteration2").getPath();
		grid.changeGrid(grid.getEntry(fileName));
	}

	/**
	 * Execution du troisième cas du test : dimension de la grille = MXN.
	 * @throws IOException
	 */
	public void execute_tree() throws IOException {
		lifegame.iteration3.GridEvolution grid = new lifegame.iteration3.GridEvolution();
		String fileName = getClass().getResource("/demos/iteration3").getPath();
		grid.changeGrid(grid.getEntry(fileName));
	}

	public static void main(String[] args) throws IOException {
		Demo demo = new Demo();
		System.out.println(" PHASE I :");
		demo.execute_one();
		System.out.println(" PHASE II :");
		demo.execute_two();
		System.out.println(" PHASE III :");
		demo.execute_tree();
	}
}
