package domain;
import java.util.ArrayList;
import java.util.List;

import mock.Store;

public class Sale {

	private List<Copy> saleCopies;
	private double total;

	public Sale() {
		saleCopies = new ArrayList<>();
		total = 0;
	}

	public void addSaleCopy(Copy copy) {
		saleCopies.add(copy);
		total += copy.getCopyDescription().getPrice();
	}
	
	public int copiesInSale(){
		return saleCopies.size();
	}

	public double getTotal() {
		return total;
	}

	public void complete(){
		for (Copy copy : saleCopies) {
			Store.removeSaleCopy(copy.getCopyID());
		}
	}
	
	public String toString(){
		StringBuilder toReturn = new StringBuilder();
		
		toReturn.append("\n\n-- Current Sale --");
		
		if(saleCopies.isEmpty())
			toReturn.append("\n(no copies entered yet)");
		
		for(Copy copy: saleCopies){
			toReturn.append("\n" + copy.getCopyID() + "\t" + copy.getCopyDescription().getTitle());
		}
		
		toReturn.append("\n\n\tTotal: " + total);
		
		return toReturn.toString();
	}
	
}
