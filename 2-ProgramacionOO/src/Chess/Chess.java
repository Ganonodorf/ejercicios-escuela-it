package Chess;

import java.util.Scanner;

public class Chess {
	
	private final String ANSWER_REGEX = "[yn]";
	
	private Board board;
	
	private Player playerWhite;
	
	private Player playerBlack;
	
	public Chess(){
		playerWhite = new Player(Color.WHITE);
		playerBlack = new Player(Color.BLACK);
	}
	
	public void play() {
		do {
			board = new Board();
			
			Player activePlayer = playerWhite;
			
			do {
				this.showTurn(activePlayer);
				
				board.showInformation();
				
				Movement movement;
				
				do {
					movement = activePlayer.createMovement();
				}while(!board.canMakeMovement(movement));
				
				board.makeMovement(movement);
				
				if(activePlayer == playerWhite) {
					activePlayer = playerBlack;
				}
				else {
					activePlayer = playerWhite;
				}
				
				//activePlayer = activePlayer == playerWhite ? playerBlack : playerWhite;
				
			}while(!board.isGameOver());

			board.showInformation();
			
			System.out.println(board.getWinner() + " has won!!! ;-)");
			
		}while(playAgain() == true);
	}

	private void showTurn(Player player) {
		System.out.print("Player turn ");
		player.show();
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
        
        scanner.close();
		
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
