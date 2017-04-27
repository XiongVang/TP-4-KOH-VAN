package contoller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Copy;
import domain.Patron;
import mock.Store;

public class CheckCopiesOutController {

	private Map<String, Copy> copiesEntered;
	private Patron currentPatron;

	public CheckCopiesOutController() {
		copiesEntered = new HashMap<>();
	}

	public void setCurrentPatron(String patronID) {
		currentPatron = Store.getPatron(patronID);
	}

	public boolean isDuplicateCopy(String copyID) {

		return copiesEntered.containsKey(copyID.toUpperCase());

	}

	public boolean isValidPatronID(String patronID) {

		return Store.getPatron(patronID) != null;
	}

	public boolean isValidCopyID(String copyID) {
		return Store.getRentalCopy(copyID) != null;
	}

	public void addCopy(String copyID) {
		copiesEntered.put(copyID, Store.getRentalCopy(copyID));
	}

	public boolean copyIsOut(String copyID) {
		return Store.getRentalCopy(copyID).getOutTo() != null;
	}

	public boolean currentPatronHasHold() {
		if (currentPatron == null)
			return false;

		return currentPatron.hasHold();
	}

	public String getCopiesEnteredString() {

		if (copiesEntered.isEmpty()) {
			return "\n  ( no copies entered yet)";
		}

		String copiesStr = "";

		for (Map.Entry<String, Copy> entry : copiesEntered.entrySet()) {
			copiesStr += "\n  - " + entry.getKey() + "\t" + entry.getValue().getCopyDescription().getTitle();
		}
		return copiesStr;
	}

	public String getCurrentPatronName() {
		if (currentPatron == null)
			return "";

		return currentPatron.getName();
	}
	
	public boolean noCopiesEnteredYet(){
		return copiesEntered.isEmpty();
	}
	
	public List<String> checkOutCopies(){
		
		List<String> copyIDs = new ArrayList<>();
		
		for (Map.Entry<String, Copy> entry : copiesEntered.entrySet()) {
			currentPatron.checkCopyOut(entry.getValue());
			entry.getValue().setDueDate(Store.getDueDate());
			copyIDs.add(entry.getKey());
		}

		return copyIDs;
	}

}
