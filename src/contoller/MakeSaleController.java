package contoller;

import domain.Sale;
import mock.Store;

public class MakeSaleController {
	private Sale currentSale;
	private double paymentTotal;

	public MakeSaleController() {
		this.currentSale = new Sale();
		this.paymentTotal = 0.0;
	}

	public String getSaleString() {
		return currentSale.toString();
	}
	
	public double getSaleTotal(){
		return currentSale.getTotal();
	}
	
	public double getChangeDue(){
		return paymentTotal - currentSale.getTotal();
	}

	public boolean saleHasCopies() {

		return currentSale.copiesInSale() > 0;
	}

	public boolean saleHasCopy(String copyID) {
		return currentSale.hasCopy(copyID);
	}
	
	public boolean validCopyID(String copyID){
		return Store.getSaleCopy(copyID) != null;
	}

	public void addSaleCopy(String copyID) {
		currentSale.addSaleCopy(Store.getSaleCopy(copyID));
		
	}
	
	public void applyPayment(double payment){
		paymentTotal =+ payment;
	}
	
	public boolean saleIsPaid(){
		return paymentTotal >= currentSale.getTotal();
	}
	
	public void completeSale(){
		currentSale.complete();
	}
}
