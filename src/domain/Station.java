package domain;

import presenter.IPresenter;
import presenter.MainMenuPresenter;
import ui.ConsoleUI;
import ui.IConsoleUI;

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
