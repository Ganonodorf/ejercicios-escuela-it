package masterMindModelViewController.controllers;

import masterMindModelViewController.models.Board;
import masterMindModelViewController.models.Combination;
import masterMindModelViewController.views.MasterMindView;

public class GameController {
	
	Board board;
	MasterMindView masterMindView;
	
	public GameController(Board board, MasterMindView masterMindView) {
		this.board = board;
		this.masterMindView = masterMindView; 
	}
	
	public void play() {
		board.initializeBoard();
		
		do {
			masterMindView.board(board);
			
			masterMindView.player();
			
			Combination proposedCombination = masterMindView.getPlayerCombination();
			
			board.proposeCombination(proposedCombination);
			
		}while(board.hasMoreAttempts() && board.isWinnerResult() == false);

		masterMindView.board(board);
		
		if(board.isWinnerResult()) {
			masterMindView.win();
		}
		else {
			masterMindView.lose();
		}
	}
}
