package ui;

import contoller.ChangePatronHoldController;

public class HelpPresenter implements IPresenter {

	private IPresenter previousPresenter;
	private IConsoleUI ui;

	public HelpPresenter(IConsoleUI ui,IPresenter previousPresenter)
	{
		this.ui = ui;
		this.previousPresenter = previousPresenter;
	}
	
	@Override
	public void present() {
		promptHelpMenu();
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
	
	private void promptHelpMenu() {
		
		String options = PresenterHelper.generateScreenTitle("HELP MENU")
				+ "\n\nYou can get information about how to use this tool by selecting items below." 
				+ "\n\nPlease select from the following options:" 
				+ "\n\n  0 - EXIT to Main Menu" 
				+ "\n  1 - How to: Check Copies Out" 
				+ "\n  2 - How to: Check Copies In" 
				+ "\n  3 - How to: Make New Sale"
				+ "\n  4 - How to: Change Patron Hold"
				+ "\n\nEnter selection:";
		
		
		boolean validInput = false;
		while (!validInput) {
			
			String userInput = ui.prompt(options);
			
			switch (userInput) {
				case "0":
					validInput = true;
					backToMain();
					break;
				case "1":
					validInput = true;
					checkCopiesOutHelp();
					break;
				case "2":
					validInput = true;
					checkCopiesInHelp();
					break;
				case "3":
					validInput = true;
					makeNewSaleHelp();
					break;
				case "4":
					validInput = true;
					changePatronHoldHelp();
					break;
				default:
					ui.show(PresenterHelper.INVALID_SELECTION);
			}
		}
	}

	private void changePatronHoldHelp() {
		ui.show("You can add a hold to a patron by selecting 4 from the main menu.");
		ui.show("Next, enter a patron ID (P1 or P2), then select 1 to add a hold.");
	}

	private void makeNewSaleHelp() {
		ui.show("You can make a sale to a patron by selecting 3 from the main menu.");
		ui.show("Next, enter a copy ID (C1T1S, C2T1S, C1T2S or C2T2S) and enter 'done' when done.");
	}

	private void checkCopiesInHelp() {
		ui.show("You can check in a copy from a patron by selecting 2 from the main menu.");
		ui.show("Next, enter a copy ID (C1T1R, C2T1R, C1T2R or C2T2R) and enter 'done' when done.");
	}

	private void checkCopiesOutHelp() {
		ui.show("You can check out a copy to a patron by selecting 1 from the main menu.");
		ui.show("Next, enter a patron ID (P1 or P2).");
		ui.show("Then, enter a copy ID (C1T1R, C2T1R, C1T2R or C2T2R) and enter 'done' when done.");
	}

}
