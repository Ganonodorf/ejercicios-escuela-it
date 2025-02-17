package masterMind;

import java.util.Scanner;

public class MasterMind {
	
	private Player player;
	private Board board;
	private final String ANSWER_REGEX = "^[yn]$";
	
	public MasterMind() {
		player = new Player();
	}
	
	public void Play() {
		do {
			board = new Board();
			
			do {
				board.proposeCombination(player.createCombination());
			}while(board.numberOfAttemps() < 8 && board.isWinnerResult() == false);
			
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
	        
	        if(goodAnswer) {
	        	System.out.println("Not a valid answer. Try again.");
	        }
	        
		}while(!goodAnswer);
		
		return isPlayingAgain(input);
	}
	
	private boolean isPlayingAgain(String input) {
		if(input == "y") {
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
		
		masterMind.Play();
	}
}
