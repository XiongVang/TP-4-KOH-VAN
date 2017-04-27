package ui;

import contoller.CheckCopiesInController;
import domain.Copy;
import domain.Patron;
import mock.Store;

public class CheckCopiesInPresenter implements IPresenter {

	private CheckCopiesInController controller;
	private IPresenter previousPresenter;
	private IConsoleUI ui;

	public CheckCopiesInPresenter(IConsoleUI ui, IPresenter callbackPresenter) {

		this.ui = ui;
		this.previousPresenter = callbackPresenter;
		this.controller = new CheckCopiesInController();
	}

	@Override
	public void present() {
		promptForCopyID();

	}

	private void promptForCopyID() {

		String copyIDPrompt = PresenterHelper.generateScreenTitle("CHECK COPIES IN")
				+ "\n\n  ( Enter 0 to return to MAIN MENU. )" + "\n\nEnter copy ID: ";

		while (true) {

			String copyID = ui.prompt(copyIDPrompt);

			// return to main menu
			if (copyID.equals("0")) {
				backToMain();
				return;
			}

			// invalid copy ID
			if (!controller.isValidCopyID(copyID)) {
				ui.show(PresenterHelper.INVALID_COPY_ID);
				continue;
			}

			// copy never checked out
			if (!controller.copyWasCheckedOut()) {
				ui.show(PresenterHelper.COPY_NOT_CHECKED_OUT);
				continue;
			}

			completeCheckCopyIn();

		}
	}

	private void completeCheckCopyIn() {
		ui.show("Checking copy in...");
		ui.show(PresenterHelper.generateCheckInSuccessMessage(controller.getCopyID(), controller.checkCopyIn()));

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
