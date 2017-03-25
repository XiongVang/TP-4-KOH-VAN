package domain;

import presenter.IPresenter;
import presenter.MainMenuPresenter;

public class Station implements IStation{

	private IPresenter starter;
	
	public Station() {
		starter = new MainMenuPresenter();
	}
	
	@Override
	public void on(){
		starter.present();
	}
	
}
