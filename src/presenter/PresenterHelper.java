package presenter;

import java.util.List;

public final class PresenterHelper {

	private PresenterHelper() {
	};

	public static final String SEPARATOR = "\n_____________________________";

	public static final String INVALID_SELECTION = "\n> INVALID SELECTION: Check options and try again. <";

	public static final String INVALID_COPY_ID = "\n> INVALID COPY ID: Check copy ID and try again. <";

	public static final String INVALID_PATRON_ID = "\n> INVALID PATRON ID: Check patron ID and try again. <";

	public static final String PATRON_HAS_HOLD = "\n> PATRON HAS A HOLD: Cannot check out copies until hold is cleared. <";

	public static final String COPY_NOT_CHECKED_OUT = "\n> COPY ENTERED HAS NOT BEEN CHECKED OUT: Please try a different copy ID. <";

	public static final String COPY_ALREADY_CHECKED_OUT = "\n> COPY ALREADY CHECKED OUT: Please try a different copy ID. <";

	public static final String NO_COPIES_ENTERED_FOR_RENTAL = "\n>  NO COPIES ENTERED FOR RENTAL: Please add by entering copy ID. <";
	
	public static final String DUPLICATE_COPY_ID = "\n>  DUPLICATE COPY ID: Copy ID already entered.  <";

	public static final String NO_COPIES_ENTERED_FOR_SALE = "\n>  NO COPIES ENTERED FOR SALE: Please add by entering copy ID. <";

	public static final String INVALID_AMOUNT = "\n> INVALID AMOUNT: Please enter amount as a number <";
	
	public static String generateScreenTitle(String title) {
		return PresenterHelper.SEPARATOR + "\n\n***** " + title + " *****";
	}

	public static String generateDebugMessage(String debugMessage) {
		return "\n\n *** DEBUG MESSAGE ***\n" + debugMessage + "\n ********************\n\n";
	}

	public static String generateCheckInSuccessMessage(String copyID, String patronName) {
		return SEPARATOR + 
				String.format("\n\n  CHECK IN SUCCESS: %s checked in from %s.", copyID, patronName);
	}

	public static String generateCheckOutSuccessMessage(String patronName, List<String> copyIDs) {
		
		String copiesList = "";
		
		for (String copyID : copyIDs) {
			copiesList += "\n\t- " + copyID;
		}

		return SEPARATOR + 
				"\n\n  CHECK OUT SUCCESS: " + "\n  Patron name: " + patronName + copiesList;
	}
	
	public static String generateSaleCompleteMessage(double changeDue){
		return SEPARATOR + 
				"\n\n  SALE COMPLETED: " + "\n  Change due: " + changeDue + "\n  Printing receipt...";
	}
	
	public static String generateCopyAlreadyCheckedOutMessage(String outToPatronName) {
		return String.format("\n  > COPY ALREADY CHECKED OUT: Copy already checked out to %s. <", outToPatronName);
	}
	
}
