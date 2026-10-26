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
	
	public void proposeCombination() {
		masterMindView.askProposedCombination();
		
		Combination proposedCombination = masterMindView.getPlayerCombination();
		
		board.proposeCombination(proposedCombination);
	}
}
