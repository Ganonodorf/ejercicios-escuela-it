package masterMindWithFactoryMethod.views.console;

import masterMindWithFactoryMethod.views.View;

public class WinView extends View{
	
	public WinView() {
		super();
	}

	@Override
	public void showInformation() {
		System.out.println("You've won!!! ;-)");
	}
	
}
