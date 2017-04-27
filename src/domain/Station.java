package domain;

import ui.ConsoleUI;
import ui.IConsoleUI;
import ui.IPresenter;
import ui.MainMenuPresenter;

public class Station implements IStation{

	private IPresenter starter;
	private IConsoleUI ui;
	
	public Station() {
		ui = new ConsoleUI();
		starter = new MainMenuPresenter(ui);
	}
	
	@Override
	public void on(){
		starter.present();
	}
	
}
