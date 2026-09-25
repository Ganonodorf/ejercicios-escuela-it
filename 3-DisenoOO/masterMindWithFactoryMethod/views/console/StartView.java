package masterMindWithFactoryMethod.views.console;

import masterMindWithFactoryMethod.views.View;

public class StartView extends View{
	
	public StartView() {
		super();
	}
	
	@Override
	public void showInformation() {
		System.out.println("Welcome to MasterMind!");
		System.out.println("Try to guess the combination with rybgmc colors.");
	}

}
