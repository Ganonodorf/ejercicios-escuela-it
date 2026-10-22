package masterMindModelViewController;

import masterMindModelViewController.models.Board;
import masterMindModelViewController.views.MasterMindView;
import masterMindModelViewController.views.console.ConsoleView;

public class ConsoleMasterMindController extends MasterMindController {
	
	@Override
	public MasterMindView createView(Board board) {
		return new ConsoleView(board);
	}
	
	public static void main(String[] args) {
		MasterMindController masterMindController = new ConsoleMasterMindController();
		
		masterMindController.play();
	}
}
