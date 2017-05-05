package contoller;

import domain.Copy;
import domain.Patron;
import mock.Store;

public class CheckCopiesInController {
	
	private Copy copy;
	
	public boolean isValidCopyID(String copyID){
		return Store.getRentalCopy(copyID) != null;
	}
	
	public void setCopy(String copyID){
		copy = Store.getRentalCopy(copyID);
	}
	
	public boolean copyWasCheckedOut(){
		if (copy == null)
			return false;
		
		return copy.getOutTo() != null;
	}

	public String checkCopyIn() {

		if(copy == null)
			return "";
		
		if (this.copyWasCheckedOut())
			return "";
		
		Patron patron = copy.getOutTo();
		patron.checkCopyIn(copy);
		
		return patron.getName();
	}

	public String getCopyID() {
		if(copy == null)
			return "";
		
		return copy.getCopyID();
	}

}
