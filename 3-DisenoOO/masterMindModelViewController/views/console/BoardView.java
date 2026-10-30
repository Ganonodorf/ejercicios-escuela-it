package masterMindModelViewController.views.console;

import java.util.ArrayList;

import masterMindModelViewController.models.Board;
import masterMindModelViewController.models.Play;
import masterMindModelViewController.views.ViewWithBoard;

public class BoardView extends ViewWithBoard{

	public BoardView(Board board) {
		super(board);
	}

	@Override
	public void showInformation() {
		int attempts = board.numberOfAttempts();
		ArrayList<Play> plays = board.getPlays();
		
		System.out.println("\n" + attempts + " attemp(s):");
		System.out.println("****");
		
		for(int i = 0; i < attempts; i++) {
			System.out.println(plays.get(i).toString());
		}
	}

}
