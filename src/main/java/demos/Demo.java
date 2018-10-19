package demos;

import iteration1.service.LoadFile;
import iteration1.service.PrintConsole;
import iteration1.service.TraitSimulation;

public class Demo {

	// iteration 1 : one cellule
	public void ExpleGrilleAcUneCellule() {

		LoadFile loader = new LoadFile();
		TraitSimulation Simulation = loader.load("src\\main\\ressource\\data10.txt");
		Simulation.setPrintConsole(new PrintConsole());
		Simulation.traitemet();
	}

	// iteration 2 : two cellule
	public void ExpleGrilleAcDeuxCellule() {

		iteration2.service.LoadFile loader = new iteration2.service.LoadFile();
		iteration2.service.TraitSimulation simulation = loader.load("src\\main\\ressource\\data21.txt");
		simulation.setPrintConsole(new iteration2.service.PrintConsole());
		simulation.start();

	}

	// iteration 3 : more than two cellules
	public void ExpleGrilleAcPlusDeDeuxCellule() {
		iteration3.service.LoadFile loader = new iteration3.service.LoadFile();
		iteration3.service.TraitSimulation simulator = loader
				.load("src\\main\\ressource\\data5.txt");

		simulator.setPrintConsole(new iteration3.service.PrintConsole());
		simulator.start();
	}

	public static void main(String[] args) {

	 	new Demo().ExpleGrilleAcUneCellule();
		new Demo().ExpleGrilleAcDeuxCellule();
		new Demo().ExpleGrilleAcPlusDeDeuxCellule();

	}

}
