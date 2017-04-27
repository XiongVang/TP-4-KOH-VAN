package contoller;

import domain.Patron;
import mock.Store;

public class ChangePatronHoldController {
	private Patron currentPatron;

	public void setCurrentPatron(String patronID) {
		currentPatron = Store.getPatron(patronID);
	}

	public boolean isValidPatronID(String patronID) {

		return Store.getPatron(patronID) != null;
	}

	public boolean currentPatronHasHold() {
		if (currentPatron == null)
			return false;

		return currentPatron.hasHold();
	}

	public String getCurrentPatronName() {
		if (currentPatron == null)
			return "";
		return currentPatron.getName();
	}
	
	public void putHold(){
		currentPatron.putHold();
	}
	
	public void removeHold(){
		currentPatron.removeHold();
	}
}
