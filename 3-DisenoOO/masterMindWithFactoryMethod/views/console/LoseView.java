package masterMindWithFactoryMethod.views.console;

import masterMindWithFactoryMethod.views.View;

public class LoseView extends View{
	
	public LoseView() {
		super();
	}

	@Override
	public void showInformation() {
		System.out.println("You've lost!!! :-(");
	}

}
