package iteration1.service;

import iteration1.model.Grid;

public class PrintConsoleImpl implements PrintConsole {

	@Override
	public void print(int stepNumber, Grid grid) {
		String sign;
		if (grid.getCell().isLive())
			sign = "+";
		else
			sign = "-";

		System.out.println("+------------------------+");
		System.out.println("| Step " + stepNumber + "              |");
		System.out.println("+------------------------+");
		System.out.println("|      " + sign + "                 |");
		System.out.println("+------------------------+");
	
		
	}
	
}

	
