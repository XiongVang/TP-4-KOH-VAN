package ui;

import contoller.ChangePatronHoldController;

public class ChangePatronHoldPresenter implements IPresenter {

	private ChangePatronHoldController controller;
	private IPresenter previousPresenter;
	private IConsoleUI ui;

	public ChangePatronHoldPresenter(IConsoleUI ui, IPresenter previous) {
		this.controller = new ChangePatronHoldController();
		this.previousPresenter = previous;
		this.ui = ui;

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

			showChangeHoldOptions();
			return;
		}
	}

	private void showChangeHoldOptions() {
		if (controller.currentPatronHasHold())
			promptForRemoveHold();
		else {
			promptForPutHold();
		}
	}

	private void promptForPutHold() {

		String addHoldPrompt = PresenterHelper.generateScreenTitle("CHANGE PATRON HOLD") 
				+ "\n\nPATRON NAME: "
				+ controller.getCurrentPatronName() 
				+ "\nHAS HOLD: No" 
				+ "\n\nPlease select from the following options:"
				+ "\n\n  0 - Return to MAIN MENU"
				+ "\n  1 - Put hold on patron's account"
				+ "\n\nEnter selection:";

		boolean validInput = false;
		while (true) {

			String userInput = ui.prompt(addHoldPrompt);

			switch (userInput) {
			case "0":
				validInput = true;
				backToMain();
				break;
			case "1":
				validInput = true;
				putHold();
				break;
			default:
				ui.show(PresenterHelper.INVALID_SELECTION);
			}
		}
	}
	

	private void putHold() {
		controller.putHold();
		ui.show("\nA hold has been put on patron's account.");
		showChangeHoldOptions();
		
	}

	private void promptForRemoveHold() {
		String addHoldPrompt = PresenterHelper.generateScreenTitle("CHANGE PATRON HOLD") + "\n\nPATRON NAME: "
				+ controller.getCurrentPatronName() 
				+ "\nHAS HOLD: Yes" 
				+ "\n\nPlease select from the following options:"
				+ "\n\n  0 - Return to MAIN MENU"
				+ "\n  1 - Remove hold on patron's account"
				+ "\n\nEnter selection:";

		boolean validInput = false;
		while (true) {

			String userInput = ui.prompt(addHoldPrompt);

			switch (userInput) {
			case "0":
				validInput = true;
				backToMain();
				break;
			case "1":
				validInput = true;
				removeHold();
				break;
			default:
				ui.show(PresenterHelper.INVALID_SELECTION);
			}
		}

	}

	private void removeHold() {
		controller.removeHold();
		ui.show("\nHold has been removed patron's account.");
		showChangeHoldOptions();
		
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
