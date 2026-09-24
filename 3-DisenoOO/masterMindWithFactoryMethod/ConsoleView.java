package masterMindWithFactoryMethod;

import java.util.Scanner;

public class ConsoleView extends MasterMindView {
	
	public ConsoleView(Board board){
		super(board);
	}
	
	@Override
	public void start() {
		System.out.println("Welcome to MasterMind!");
		System.out.println("Try to guess the combination with rybgmc colors.");
	}
	
	@Override
	public void play() {
		do {
			board.initializeBoard();
			
			boardView = new BoardView(board);
			
			do {
				boardView.showInformation();
				
				Combination proposedCombination = playerView.askUserCombination();
				
				board.proposeCombination(proposedCombination);
				
			}while(board.hasMoreAttempts() && board.isWinnerResult() == false);

			boardView.showInformation();
			
			if(board.isWinnerResult()) {
				this.winMessage();
			}
			else {
				this.loseMessage();
			}
			
		}while(this.askUserPlayAgain());
	}
	
	@Override
	public void winMessage() {
		System.out.println("You've won!!! ;-)");
	}
	
	@Override
	public void loseMessage() {
		System.out.println("You've lost!!! :-(");
	}

	@Override
	public boolean askUserPlayAgain() {
		String input;
		
		Scanner scanner = new Scanner(System.in);
		
		boolean goodAnswer;
		
		System.out.println("Do you want to continue? (y/n): ");

		do {
	        input = scanner.nextLine();
	        
	        goodAnswer = isGoodAnswer(input);
	        
	        if(!goodAnswer) {
	        	System.out.println("Not a valid answer. Try again.");
	        }
	        
		}while(!goodAnswer);
		
		return isPlayingAgain(input);
	}
	
	@Override
	protected boolean isPlayingAgain(String input) {
		if(input.matches("y")) {
			return true;
		}
		return false;
	}
	
	@Override
	protected boolean isGoodAnswer(String input) {
		if(input.matches(ANSWER_REGEX)) {
			return true;
		}
		return false;
	}
}
