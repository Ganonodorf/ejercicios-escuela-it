package Chess;

import java.util.Scanner;

public class Player {
	
	private Color color;
	
	private String MOVE_REGEX = "^[kqrnbp][abcdefgh][1-8]x?[abcdefgh][1-8]$";
	
	public Player(Color color) {
		this.color = color;
	}
	
	public Movement createMove() {
		String input;
		
		Scanner scanner = new Scanner(System.in);

		String error;

		do {
			System.out.println("move a piece, ex: qh4xe1");
			
	        input = scanner.nextLine();
	        
	        error = checkErrorInInput(input);
	        
	        if(error.length() > 0) {
	        	System.out.println(error);
	        }
		}while(error.length() > 0);
        
        scanner.close();
		
		return new Movement(input, color);
	}

	private String checkErrorInInput(String input) {
		if(input.length() > 6) {
			return "Wrong moved combination length";
		}
		if(!input.matches(MOVE_REGEX)) {
			return "Wrong move, it must be like: qh4xe1";
		}
		
		return "";
	}
	
	public static void main(String[] args) {
		Player player = new Player(Color.WHITE);
		
		player.createMove();
	}
}
