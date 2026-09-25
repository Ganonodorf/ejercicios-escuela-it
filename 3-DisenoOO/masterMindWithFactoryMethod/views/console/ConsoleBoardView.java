package masterMindWithFactoryMethod.views.console;

import masterMindWithFactoryMethod.models.Board;
import masterMindWithFactoryMethod.models.Play;
import masterMindWithFactoryMethod.views.BoardView;

public class ConsoleBoardView extends BoardView{

	public ConsoleBoardView(Board board) {
		super(board);
	}

	@Override
	public void showInformation() {
		int attempts = board.numberOfAttempts();
		Play[] plays = board.getPlays();
		
		System.out.println("\n" + attempts + " attemp(s):");
		System.out.println("****");
		
		for(int i = 0; i < attempts; i++) {
			System.out.println(plays[i].toString());
		}
	}

}
