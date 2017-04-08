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
	private static Map<String, Copy> rentalInventory = new HashMap<>();
	private static Map<String, Copy> saleInventory = new HashMap<>();

	// static initializer
	static {
		patrons.put("P1", new Patron("P1", "Patron1", new Hold(false)));
		patrons.put("P2", new Patron("P2", "Patron2", new Hold(true)));

		textbookCatalog.put("111", new Textbook("111", "Book1", "Author1", 1.00));
		textbookCatalog.put("222", new Textbook("222", "Book2", "Author2", 2.00));

		rentalInventory.put("C1T1R", new Copy("C1T1R", textbookCatalog.get("111")));
		rentalInventory.put("C2T1R", new Copy("C2T1R", textbookCatalog.get("111")));
		rentalInventory.put("C1T2R", new Copy("C1T2R", textbookCatalog.get("222")));
		rentalInventory.put("C2TR2", new Copy("C2T2R", textbookCatalog.get("222")));
		
		saleInventory.put("C1T1S", new Copy("C1T1S", textbookCatalog.get("111")));
		saleInventory.put("C2T1S", new Copy("C2T1S", textbookCatalog.get("111")));
		saleInventory.put("C1T2S", new Copy("C1T2S", textbookCatalog.get("222")));
		saleInventory.put("C2T2S", new Copy("C2T2S", textbookCatalog.get("222")));
		
	}

	public static Patron getPatron(String patronID) {
		return patrons.get(patronID.toUpperCase());
	}

	public static Copy getRentalCopy(String copyID) {
		return rentalInventory.get(copyID.toUpperCase());
	}
	
	public static Copy getSaleCopy(String copyID) {
		return saleInventory.get(copyID.toUpperCase());
	}
	
	public static Copy removeSaleCopy(String copyID){
		return saleInventory.remove(copyID);
	}

	public static Textbook getTextbook(String isbn) {
		return textbookCatalog.get(isbn);
	}

}
