package presenter;

import domain.Copy;
import domain.Sale;
import mock.Store;
import ui.IConsoleUI;

public class MakeSalePresenter implements IPresenter {

	private IConsoleUI ui;
	private IPresenter previousPresenter;
	private Sale currentSale;

	public MakeSalePresenter(IConsoleUI ui, IPresenter callbackPresenter) {
		this.ui = ui;
		this.previousPresenter = callbackPresenter;
		this.currentSale = new Sale();
	}

	@Override
	public void present() {
		promptForCopyID();

	}

	@Override
	public void back() {
		// TODO Auto-generated method stub

	}

	private void promptForCopyID() {
		String copyIDPrompt;

		while (true) {
			copyIDPrompt = PresenterHelper.generateScreenTitle("SALE COPIES")
					+ "\n\n  ( Enter 0 to cancel sale return to MAIN MENU. )" + currentSale.toString()
					+ "\n\nEnter copy ID or 'DONE': ";

			String copyID = ui.prompt(copyIDPrompt);

			// return to main menu
			if (copyID.equals("0")) {
				backToMain();
				return;
			}

			// complete sale
			if (copyID.equalsIgnoreCase("done")) {

				// no copies entered
				if (currentSale.copiesInSale() == 0) {
					ui.show(PresenterHelper.NO_COPIES_ENTERED_FOR_SALE);
					continue;
				}

				promptForPayment();
				return;
			}
			

			// retrieve copy from store
			Copy copy = Store.getSaleCopy(copyID);

			// invalid copy ID
			if (copy == null) {
				ui.show(PresenterHelper.INVALID_COPY_ID);
				continue;
			}
			
			// copy already entered
			if (currentSale.hasCopy(copy.getCopyID())) {
				ui.show(PresenterHelper.DUPLICATE_COPY_ID);
				continue;
			}

			// add copy to sale
			currentSale.addSaleCopy(copy);

		}
	}

	private void promptForPayment() {
		String paymentPrompt;
		double paymentAmount = 0.0;

		while (true) {

			paymentPrompt = PresenterHelper.generateScreenTitle("SALE PAYMENT")
					+ "\n\n ( Enter 0 to cancel sale and return to main )" + currentSale.toString()
					+ "\n\tAmount paid: " + paymentAmount + "\n\tAmount due: "
					+ (currentSale.getTotal() - paymentAmount) + "\n\n\nEnter payment amount:";

			String amountEntered = ui.prompt(paymentPrompt);

			// return to main menu
			if (amountEntered.equals("0")) {
				backToMain();
				return;
			}

			try {
				
				paymentAmount += Double.parseDouble(amountEntered);
				
				// total not paid yet
				if (paymentAmount < currentSale.getTotal())
					continue;
				
				// total paid
				this.currentSale.complete();
				ui.show(PresenterHelper.generateSaleCompleteMessage(paymentAmount-currentSale.getTotal()));
				backToMain();
				return;
				
			} catch (NumberFormatException e) {
				ui.show(PresenterHelper.INVALID_AMOUNT);
				continue;
			}
		}

	}

	private void backToMain() {
		ui.show("\nReturning to MAIN MENU....");
		previousPresenter.back();
		previousPresenter = null;
		currentSale = null;
		ui = null;
	}

}
