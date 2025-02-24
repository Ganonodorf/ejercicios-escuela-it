package Chess;

import java.util.Scanner;

public class Chess {
	
	private final String ANSWER_REGEX = "[yn]";
	
	private Board board = new Board();
	
	private Player playerWhite = new Player(Color.WHITE);
	
	private Player playerBlack = new Player(Color.BLACK);
	
	public Chess(){
		
	}
	
	public void play() {
		do {
			board = new Board();
			
			Player activePlayer = playerWhite;
			
			do {
				board.showInformation();
				
				Movement move;
				do {
					move = activePlayer.createMove();
				}while(!board.canMove(move));
				
				activePlayer = activePlayer == playerWhite ? playerBlack : playerWhite;
			}while(!board.isGameOver());

			board.showInformation();
			
			System.out.println(board.getWinner() + " has won!!! ;-)");
			
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
		return input.matches("y");
	}

	private boolean isGoodAnswer(String input) {
		return input.matches(ANSWER_REGEX);
	}

	public static void main(String[] args) {
		Chess chess = new Chess();
		
		chess.play();
	}
}
