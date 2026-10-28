package masterMindModelViewController;

import masterMindModelViewController.models.MasterMind;
import masterMindModelViewController.utils.Observer;
import masterMindModelViewController.views.MasterMindView;
import masterMindModelViewController.views.console.ConsoleView;

public class ConsoleMasterMindController extends MasterMindController {
	
	@Override
	public MasterMindView createView(MasterMind masterMind, Observer observer) {
		return new ConsoleView(masterMind, observer);
	}
	
	public static void main(String[] args) {
		MasterMindController masterMindController = new ConsoleMasterMindController();
		
		masterMindController.play();
	}
}
