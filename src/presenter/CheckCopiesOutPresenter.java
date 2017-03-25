package presenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Copy;
import domain.Patron;
import mock.Store;
import ui.ConsoleUI;

public class CheckCopiesOutPresenter implements IPresenter {

	private ConsoleUI ui;
	private IPresenter previousPresenter;
	private Patron currentPatron;
	private Map<String, Copy> copiesEntered;

	public CheckCopiesOutPresenter(IPresenter callbackPresenter) {
		copiesEntered = new HashMap<>();
		ui = ConsoleUI.getInstance();
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

			// retrieve patron from store
			currentPatron = Store.getPatron(patronID);

			// invalid patron ID
			if (currentPatron == null) {
				ui.show(PresenterHelper.INVALID_PATRON_ID);
				continue;
			}

			// patron has hold on account
			if (currentPatron.hasHold()) {
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
					+ currentPatron.getName() + "\n\nCOPIES ENTERED:" + getCopiesEnteredString()
					+ "\n\n  ( Enter 0 to CANCEL and return to MAIN MENU. )"
					+ "\n\nEnter 'DONE' to complete check out or enter copy ID to add:";

			String copyID = ui.prompt(copyIDPrompt);

			// return to main menu
			if (copyID.equals("0")) {
				previousPresenter.back();
				return;
			}

			// complete check out transaction
			if (copyID.equalsIgnoreCase("done")) {

				// no copies entered
				if (copiesEntered.isEmpty()) {
					ui.show(PresenterHelper.NO_COPIES_ENTERED);
					continue;
				}
				completeCheckOutCopies();
				return;
			}

			// duplicate copy ID
			if (copiesEntered.containsKey(copyID.toUpperCase())) {
				ui.show(PresenterHelper.DUPLICATE_COPY_ID);
				continue;
			}

			// retrieve Copy from store
			Copy copy = Store.getCopy(copyID);

			// invalid copy ID
			if (copy == null) {
				ui.show(PresenterHelper.INVALID_COPY_ID);
				continue;
			}

			// copy already checked out
			if (copy.getOutTo() != null) {
				ui.show(PresenterHelper.COPY_ALREADY_CHECKED_OUT);
				continue;
			}

			copiesEntered.put(copy.getCopyID(), copy);

		}
	}

	private void completeCheckOutCopies() {

		List<String> copyIDs = new ArrayList<>();

		ui.show("Checking copies out...");

		for (Map.Entry<String, Copy> entry : copiesEntered.entrySet()) {
			currentPatron.checkCopyOut(entry.getValue());
			copyIDs.add(entry.getKey());
		}

		ui.show(PresenterHelper.generateCheckOutSuccessMessage(currentPatron.getName(), copyIDs));
		previousPresenter.back();

	}

	private String getCopiesEnteredString() {

		if (copiesEntered.isEmpty()) {
			return "\n  ( no copies entered yet)";
		}

		String copiesStr = "";

		for (Map.Entry<String, Copy> entry : copiesEntered.entrySet()) {
			copiesStr += "\n  - " + entry.getKey() + "\t" + entry.getValue().getCopyDescription().getTitle();
		}
		return copiesStr;
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
