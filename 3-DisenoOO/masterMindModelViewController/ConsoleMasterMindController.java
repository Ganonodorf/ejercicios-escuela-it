package masterMindModelViewController;

import masterMindModelViewController.views.MasterMindView;
import masterMindModelViewController.views.console.ConsoleView;

public class ConsoleMasterMindController extends MasterMindController {
	
	@Override
	public MasterMindView createView() {
		return new ConsoleView();
	}
	
	public static void main(String[] args) {
		MasterMindController masterMindController = new ConsoleMasterMindController();
		
		masterMindController.play();
	}
}
