package ui;

import contoller.MakeSaleController;
import domain.Copy;
import domain.Sale;
import mock.Store;

public class MakeSalePresenter implements IPresenter {

	private MakeSaleController controller;
	private IConsoleUI ui;
	private IPresenter previousPresenter;


	public MakeSalePresenter(IConsoleUI ui, IPresenter callbackPresenter) {
		
		this.controller = new MakeSaleController();
		this.ui = ui;
		this.previousPresenter = callbackPresenter;
	}

	@Override
	public void present() {
		promptForCopyID();

	}

	@Override
	public void back() {
		backToMain();

	}

	private void promptForCopyID() {
		String copyIDPrompt;

		while (true) {
			copyIDPrompt = PresenterHelper.generateScreenTitle("SALE COPIES")
					+ "\n\n  ( Enter 0 to cancel sale return to MAIN MENU. )" + controller.getSaleString()
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
				if (!controller.saleHasCopies()) {
					ui.show(PresenterHelper.NO_COPIES_ENTERED_FOR_SALE);
					continue;
				}

				promptForPayment();
				return;
			}
			
			// invalid copy ID
			if (controller.validCopyID(copyID)) {
				ui.show(PresenterHelper.INVALID_COPY_ID);
				continue;
			}
			
			// copy already entered
			if (controller.saleHasCopy(copyID)) {
				ui.show(PresenterHelper.DUPLICATE_COPY_ID);
				continue;
			}

			// add copy to sale
			controller.addSaleCopy(copyID);

		}
	}

	private void promptForPayment() {
		String paymentPrompt;
		double paymentAmount = 0.0;

		while (true) {

			paymentPrompt = PresenterHelper.generateScreenTitle("SALE PAYMENT")
					+ "\n\n ( Enter 0 to cancel sale and return to main )" + controller.getSaleString()
					+ "\n\tAmount paid: " + paymentAmount + "\n\tAmount due: "
					+ (controller.getSaleTotal() - paymentAmount) + "\n\n\nEnter payment amount:";

			String amountEntered = ui.prompt(paymentPrompt);

			// return to main menu
			if (amountEntered.equals("0")) {
				backToMain();
				return;
			}

			try {
				
				controller.applyPayment(Double.parseDouble(amountEntered));
				
				// total not paid yet
				if(!controller.saleIsPaid())
					continue;
				
				// total paid
				controller.completeSale();
				ui.show(PresenterHelper.generateSaleCompleteMessage(controller.getChangeDue()));
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
		ui = null;
	}

}
