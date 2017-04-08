package ui;

import lib.StdIn;
import lib.StdOut;

public class ConsoleUI implements IConsoleUI {


	public ConsoleUI() {

	}


	@Override
	public void show(String message) {
		StdOut.print(message);
	}

	
	@Override
	public String prompt(String message) {
		StdOut.print(message);

		return StdIn.readString().trim();

	}

}
