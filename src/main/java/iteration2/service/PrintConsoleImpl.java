package iteration2.service;

import iteration2.model.Grid;

public class PrintConsoleImpl implements PrintConsole {

	@Override
	public void print(String Dimension, int stepNumber, Grid grid) {
		String firstCell;
		String secondCell = "";
		if (grid.getFirstCell().isLive())
			firstCell = "+";
		else
			firstCell = "-";
		if (grid.getSecondCell() != null) {
			if (grid.getSecondCell().isLive())
				secondCell = "+";
			else
				secondCell = "-";
		}
		;

		System.out.println("+------------------------+");
		System.out.println("| Step " + stepNumber + "              |");
		System.out.println("+------------------------+");
		if (Dimension.equals("2*1")) {
			System.out.println("|      " + firstCell + "                 |");
			System.out.println("|      " + secondCell + "                 |");
		} else
			System.out.println("|      " + firstCell + secondCell
					+ "                 |");
		System.out.println("+------------------------+");

	}
}
