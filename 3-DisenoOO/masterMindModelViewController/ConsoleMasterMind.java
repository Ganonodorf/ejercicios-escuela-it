package masterMindModelViewController;

import masterMindModelViewController.models.Board;
import masterMindModelViewController.views.MasterMindView;
import masterMindModelViewController.views.console.ConsoleView;

public class ConsoleMasterMind extends MasterMind {
	
	@Override
	public MasterMindView createView(Board board) {
		return new ConsoleView(board);
	}
	
	public static void main(String[] args) {
		MasterMind masterMind = new ConsoleMasterMind();
		
		masterMind.play();
	}
}
