package presenter;

import domain.Copy;
import domain.Patron;
import mock.Store;
import ui.ConsoleUI;

public class CheckCopiesInPresenter implements IPresenter {

	private IPresenter previousPresenter;
	private ConsoleUI ui;

	public CheckCopiesInPresenter(IPresenter callbackPresenter) {

		ui = ConsoleUI.getInstance();
		this.previousPresenter = callbackPresenter;
	}

	@Override
	public void present() {
		promptForCopyID();

	}

	private void promptForCopyID() {

		String copyIDPrompt = PresenterHelper.generateScreenTitle("CHECK COPIES IN")
				+ "\n\n  ( Enter 0 to return to MAIN MENU.  )" + "\n\nEnter copy ID: ";

		while (true) {

			String copyID = ui.prompt(copyIDPrompt);

			// return to main menu
			if (copyID.equals("0")) {
				backToMain();
				return;
			}

			// retrieve copy from store
			Copy copy = Store.getCopy(copyID);

			// invalid copy ID
			if (copy == null) {
				ui.show(PresenterHelper.INVALID_COPY_ID);
				continue;
			}

			// retrieve patron copy was checked out to
			Patron patron = copy.getOutTo();

			// copy never checked out
			if (patron == null) {
				ui.show(PresenterHelper.COPY_NOT_CHECKED_OUT);
				continue;
			}

			completeCheckCopyIn(patron, copy);

		}
	}

	private void completeCheckCopyIn(Patron patron, Copy copy) {
		ui.show("Checking copy in...");
		patron.checkCopyIn(copy);
		ui.show(PresenterHelper.generateCheckInSuccessMessage(copy.getCopyID(), patron.getName()));

	}

	private void backToMain() {
		ui.show("\nReturning to MAIN MENU....");
		previousPresenter.back();
	}

	@Override
	public void back() {
		previousPresenter.back();

	}

}
