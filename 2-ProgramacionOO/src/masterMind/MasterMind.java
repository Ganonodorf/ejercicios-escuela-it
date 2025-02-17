package masterMind;

import java.util.Scanner;

public class MasterMind {
	
	private Player player;
	private Board board;
	private final String ANSWER_REGEX = "^[yn]$";
	private final int NUMBER_OF_ATTEMPS = 8;
	
	public MasterMind() {
		player = new Player();
	}
	
	public void play() {
		do {
			board = new Board(NUMBER_OF_ATTEMPS);
			
			do {
				board.showInformation();
				
				board.proposeCombination(player.createCombination());
			}while(board.numberOfAttemps() < NUMBER_OF_ATTEMPS && board.isWinnerResult() == false);
			
			if(board.isWinnerResult()) {
				System.out.println("You've won!!! ;-)");
			}
			else {
				System.out.println("You've lost!!! :-(");
			}
			
		}while(playAgain() == true);
	}

	private boolean playAgain() {
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
	
	private boolean isPlayingAgain(String input) {
		if(input.matches("y")) {
			return true;
		}
		return false;
	}

	private boolean isGoodAnswer(String input) {
		if(input.matches(ANSWER_REGEX)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		MasterMind masterMind = new MasterMind();
		
		masterMind.play();
	}
}
