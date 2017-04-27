package domain;

import java.time.LocalDate;

public class Copy {

	private String copyID;
	private Patron outTo;
	private Textbook copyDescription;
	private LocalDate dueDate;
	
	public Copy(String copyID, Textbook copyDescription){
		this.copyID = copyID;
		this.copyDescription = copyDescription;
	}

	public String getCopyID() {
		return copyID;
	}

	public Textbook getCopyDescription() {
		return copyDescription;
	}
	
	public void setOutTo(Patron patron) {
		outTo = patron;
	}
	
	public Patron getOutTo() {
		return outTo;
	}
	
	
	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		String objectDescription = String.format("Copy w/ id: %s", copyID);
		
		return objectDescription;
	}

}
