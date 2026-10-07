package masterMindModelViewController.views.console;

import masterMindModelViewController.views.View;

public class WinView extends View{
	
	public WinView() {
		super();
	}

	@Override
	public void showInformation() {
		System.out.println("You've won!!! ;-)");
	}
	
}
