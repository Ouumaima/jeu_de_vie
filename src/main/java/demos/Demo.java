package demos;

import iteration1.service.LoadFile;
import iteration1.service.PrintConsoleImpl;
import iteration1.service.Traitement;
import iteration1.service.LoadFileImpl;

public class Demo {

	// one cellule
	public void exp01() {

		LoadFile loader = new LoadFileImpl();
		Traitement simulator = loader
				.load("src\\main\\ressource\\data10.txt");

		simulator.setPrintService(new PrintConsoleImpl());
		simulator.start();
	}

	// two cellule
	public void exp02() {

		iteration2.service.LoadFile loader = new iteration2.service.LoadFileImpl();
		iteration2.service.Traitement simulator = loader
				.load("src\\main\\ressource\\data21.txt");

		simulator.setPrintService(new iteration2.service.PrintConsoleImpl());
		simulator.start();

	}

	// more than two cellules
	public void exp03() {
		iteration3.service.LoadFile loader = new iteration3.service.LoadFileImpl();
		iteration3.service.Traitement simulator = loader
				.load("src\\main\\ressource\\data5.txt");

		simulator.setPrintService(new iteration3.service.PrintConsoleImpl());
		simulator.start();
	}

	public static void main(String[] args) {

		new Demo().exp01();
		new Demo().exp02();
		new Demo().exp03();

	}

}
