package ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import contoller.CheckCopiesOutController;
import domain.Copy;
import domain.Patron;
import mock.Store;

public class CheckCopiesOutPresenter implements IPresenter {
	
	private CheckCopiesOutController controller;
	private IConsoleUI ui;
	private IPresenter previousPresenter;

	public CheckCopiesOutPresenter(IConsoleUI ui, IPresenter callbackPresenter) {
		this.controller = new CheckCopiesOutController();
		this.ui = ui;
		this.previousPresenter = callbackPresenter;
	}

	@Override
	public void present() {
		promptForPatronID();

	}

	private void promptForPatronID() {

		String patronIDPrompt = PresenterHelper.generateScreenTitle("PATRON LOGIN SCREEN")
				+ "\n\n  ( Enter 0 to return to MAIN MENU. )" + "\n\nEnter patron ID:";

		while (true) {

			String patronID = ui.prompt(patronIDPrompt);

			// return to main menu
			if (patronID.equals("0")) {
				backToMain();
				return;
			}

			// invalid patron ID
			if (!controller.isValidPatronID(patronID)) {
				ui.show(PresenterHelper.INVALID_PATRON_ID);
				continue;
			}
			
			controller.setCurrentPatron(patronID);

			// patron has hold on account
			if (controller.currentPatronHasHold()) {
				ui.show(PresenterHelper.PATRON_HAS_HOLD);
				continue;
			}

			promptCopyIDs();
			return;
		}
	}

	private void promptCopyIDs() {

		String copyIDPrompt;

		while (true) {

			copyIDPrompt = PresenterHelper.generateScreenTitle("CHECK COPIES OUT SCREEN") + "\n\nCurrent patron is "
					+ controller.getCurrentPatronName() + "\n\nCOPIES ENTERED:" + controller.getCopiesEnteredString()
					+ "\n\n  ( Enter 0 to CANCEL and return to MAIN MENU. )"
					+ "\n\nEnter copy ID or 'DONE':";

			String copyID = ui.prompt(copyIDPrompt);

			// return to main menu
			if (copyID.equals("0")) {
				previousPresenter.back();
				return;
			}

			// complete check out transaction
			if (copyID.equalsIgnoreCase("done")) {

				// no copies entered
				if (controller.noCopiesEnteredYet()) {
					ui.show(PresenterHelper.NO_COPIES_ENTERED_FOR_RENTAL);
					continue;
				}
				completeCheckOutCopies();
				return;
			}
			
			// invalid copy ID
			if (!controller.isValidCopyID(copyID)) {
				ui.show(PresenterHelper.INVALID_COPY_ID);
				continue;
			}

			// duplicate copy ID
			if (controller.isDuplicateCopy(copyID)) {
				ui.show(PresenterHelper.DUPLICATE_COPY_ID);
				continue;
			}

			// copy already checked out
			if (controller.copyIsOut(copyID)) {
				ui.show(PresenterHelper.COPY_ALREADY_CHECKED_OUT);
				continue;
			}

			controller.addCopy(copyID);

		}
	}

	private void completeCheckOutCopies() {

		ui.show("Checking copies out...");

		List<String> copyIDs = controller.checkOutCopies();
		
		ui.show(PresenterHelper.generateCheckOutSuccessMessage(controller.getCurrentPatronName(), copyIDs));
		previousPresenter.back();

	}


	private void backToMain() {
		ui.show("\nReturning to MAIN MENU....");
		previousPresenter.back();
	}

	@Override
	public void back() {
		previousPresenter.back();
		previousPresenter = null;
		ui = null;
	}

}
