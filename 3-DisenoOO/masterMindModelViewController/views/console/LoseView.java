package masterMindModelViewController.views.console;

import masterMindModelViewController.views.View;

public class LoseView extends View{
	
	public LoseView() {
		super();
	}

	@Override
	public void showInformation() {
		System.out.println("You've lost!!! :-(");
	}

}
