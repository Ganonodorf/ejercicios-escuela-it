package masterMindWithFactoryMethod;

import masterMindWithFactoryMethod.models.Board;
import masterMindWithFactoryMethod.views.MasterMindView;
import masterMindWithFactoryMethod.views.console.ConsoleView;

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
