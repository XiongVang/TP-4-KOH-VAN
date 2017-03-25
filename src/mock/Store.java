package mock;

import java.util.HashMap;
import java.util.Map;

import domain.Copy;
import domain.Hold;
import domain.Patron;
import domain.Textbook;

public class Store {

	private static Map<String, Patron> patrons = new HashMap<>();
	private static Map<String, Textbook> textbookCatalog = new HashMap<>();
	private static Map<String, Copy> copyInventory = new HashMap<>();

	// static initializer
	static {
		patrons.put("P1", new Patron("P1", "Patron1", new Hold(false)));
		patrons.put("P2", new Patron("P2", "Patron2", new Hold(true)));

		textbookCatalog.put("111", new Textbook("111", "Book1", "Author1", 1.00));
		textbookCatalog.put("222", new Textbook("222", "Book2", "Author2", 2.00));

		copyInventory.put("C1T1", new Copy("C1T1", textbookCatalog.get("111")));
		copyInventory.put("C2T1", new Copy("C2T1", textbookCatalog.get("111")));
		copyInventory.put("C1T2", new Copy("C1T2", textbookCatalog.get("222")));
		copyInventory.put("C2T2", new Copy("C2T2", textbookCatalog.get("222")));
	}

	public static Patron getPatron(String patronID) {
		return patrons.get(patronID.toUpperCase());
	}

	public static Copy getCopy(String copyID) {
		return copyInventory.get(copyID.toUpperCase());
	}

	public static Textbook getTextbook(String isbn) {
		return textbookCatalog.get(isbn);
	}

}
