package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Patron {

	private String patronID;
	private String name;
	private Hold hold;
	private Map<String, Copy> copiesOut;

	public Patron(String patronID, String name, Hold hold) {
		copiesOut = new HashMap<>();

		this.patronID = patronID;
		this.name = name;
		this.hold = hold;
	}

	public String getPatronID() {
		return patronID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void putHold() {
		hold.setHasOverDueFees(true);
	}

	public void removeHold() {
		hold.setHasOverDueFees(false);
	}

	public boolean hasHold() {
		return hold.hasOverDueFees();
	}

	public boolean checkCopyOut(Copy copy) {
		if (copy == null)
			return false;
		copiesOut.put(copy.getCopyID(), copy);
		copy.setOutTo(this);
		return true;
	}

	public boolean hasCopyOut(String copyID) {
		return copiesOut.containsKey(copyID);
	}

	public boolean checkCopyIn(String copyID) {
		if (!copiesOut.containsKey(copyID)) {
			return false;
		} else {
			copiesOut.get(copyID).setOutTo(null);
			copiesOut.remove(copyID);
			return true;
		}
	}

	public boolean checkCopyIn(Copy copy) {
		if (copy == null)
			return false;

		if (!copiesOut.containsKey(copy.getCopyID())) {
			return false;
		}
		
		copy.setOutTo(null);
		copiesOut.remove(copy.getCopyID());
		
		return true;
	}

	public List<Copy> getCopiesOut() {
		return (List<Copy>) copiesOut.values();
	}

	@Override
	public String toString() {
		String objDescription = String.format("Patron w/ name: %s, id: %s.", name, patronID);

		return objDescription;
	}

}
