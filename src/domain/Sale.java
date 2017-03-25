package domain;
import java.util.ArrayList;
import java.util.List;

public class Sale {

	private List<Copy> saleCopies;
	private double total;

	public Sale() {
		saleCopies = new ArrayList<>();
		total = 0;
	}

	public void makeSaleCopy(Copy copy) {
		saleCopies.add(copy);
		total += copy.getCopyDescription().getPrice();
	}

	public double getTotal() {
		return total;
	}

	public void makePayment(double amount){
		//TODO complete make payment
	}
	
}
