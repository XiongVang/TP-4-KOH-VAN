package ui;

import lib.StdIn;
import lib.StdOut;

public class ConsoleUI {

	private static ConsoleUI instance;

	public static ConsoleUI getInstance() {
		if (instance == null) {
			instance = new ConsoleUI();
		}

		return instance;

	}

	private ConsoleUI() {

	}

	public void show(String message) {
		StdOut.print(message);
	}

	public String prompt(String message) {
		StdOut.print(message);

		return StdIn.readString().trim();

	}

}
