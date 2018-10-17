 package iteration3.service;

import iteration3.model.Cellule;
import iteration3.model.Grid;



public class PrintConsoleImpl implements PrintConsole {

	@Override
	public void print(String[] dimension, Integer stepNumber, Grid grid) {
		Integer height = Integer.parseInt(dimension[2]);
		Cellule[][] cells = grid.getCells();
			
		System.out.println("+------------------------+");
		System.out.println("| Step " + stepNumber + "              |");
		System.out.println("+------------------------+");
		for (int i=0; i< cells.length;i++){
			String formatedLine = this.formatLine(cells[i]);
			printLine(formatedLine, height);
		}
		
		System.out.println("+------------------------+");
		
	}
	
	public String formatLine(Cellule[] cells) {
		StringBuilder sb = new StringBuilder();
		String sign = "";
		for (int i = 0; i < cells.length; i++) {
			if (cells[i] != null ){
				if (cells[i].isLive())
					sign = "+";
				else sign = "-";
			}
			sb.append(sign);
		}
		return sb.toString();

	}
	
	public void printLine(String formatedLine, int height) {
		int restOfLineByTwo = (height - formatedLine.length()) / 2;
		String gap = repeatLine("", " ", restOfLineByTwo);
		System.out.println(gap + formatedLine + gap);
	}

	public String repeatLine(String border, String element, int count) {

		StringBuilder sb = new StringBuilder(border);
		for (int i = 0; i < count; i++) {
			sb.append(element);
		}
		sb.append(border);
		return sb.toString();

	}
	
}
