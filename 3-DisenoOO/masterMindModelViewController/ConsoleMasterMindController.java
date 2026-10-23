package masterMindModelViewController;

import masterMindModelViewController.models.Board;
import masterMindModelViewController.utils.Event;
import masterMindModelViewController.utils.Observer;
import masterMindModelViewController.views.MasterMindView;
import masterMindModelViewController.views.console.ConsoleView;

public class ConsoleMasterMindController extends MasterMindController {
	
	@Override
	public MasterMindView createView(Board board, Observer observer) {
		return new ConsoleView(board, observer);
	}
	
	public static void main(String[] args) {
		MasterMindController masterMindController = new ConsoleMasterMindController();
		
		masterMindController.play();
	}
}
