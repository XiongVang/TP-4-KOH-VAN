package ui;

public class MainMenuPresenter implements IPresenter {

	private IConsoleUI ui;

	public MainMenuPresenter(IConsoleUI ui) {
		this.ui = ui;
	}

	@Override
	public void present() {
		promptWithMainOptions();
	}

	@Override
	public void back() {
		promptWithMainOptions();

	}

	private void promptWithMainOptions() {
		
		String options = PresenterHelper.generateScreenTitle("MAIN MENU")
				+ "\n\nPlease select from the following options:" 
				+ "\n\n  0 - EXIT" 
				+ "\n  1 - Check Copies Out" 
				+ "\n  2 - Check Copies In" 
				+ "\n  3 - Make New Sale"
				+ "\n\nEnter selection:";
		
		
		boolean validInput = false;
		while (!validInput) {
			
			String userInput = ui.prompt(options);
			
			switch (userInput) {
				case "0":
					validInput = true;
					goodbye();
					break;
				case "1":
					validInput = true;
					checkCopiesOut();
					break;
				case "2":
					validInput = true;
					checkCopiesIn();
					break;
				case "3":
					validInput = true;
					makeNewSale();
					break;
				default:
					ui.show(PresenterHelper.INVALID_SELECTION);
			}
		}
	}


	private void goodbye() {
		String goodbyeMessage = "Exiting..." 
				+ PresenterHelper.SEPARATOR 
				+ "\n\n Thank you for using TRL. Goodbye.";
		
		ui.show(goodbyeMessage);
		//system.exit(0);
	}
	
	private void checkCopiesOut() {
		new CheckCopiesOutPresenter(ui,this).present();
		
	}
	
	private void checkCopiesIn() {
		new CheckCopiesInPresenter(ui,this).present();
		
	}

	private void makeNewSale() {
		new MakeSalePresenter(ui,this).present();
		
	}

}
