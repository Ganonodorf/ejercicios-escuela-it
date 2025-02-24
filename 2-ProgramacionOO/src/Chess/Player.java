package Chess;

import java.util.Scanner;

public class Player {
	
	private Color color;
	
	private String MOVE_REGEX = "^[kqrnbp][abcdefgh][1-8]x?[abcdefgh][1-8]$";
	
	public Player(Color color) {
		this.color = color;
	}
	
	public Movement createMovement() {
		String input;
		
		Scanner scanner = new Scanner(System.in);

		String error;

		do {
			System.out.println("\nMove a piece, ex: qh4xe1");
			
	        input = scanner.nextLine();
	        
	        error = checkErrorInInput(input);
	        
	        if(error.length() > 0) {
	        	System.out.println(error);
	        }
		}while(error.length() > 0);
		
		return new Movement(input, color);
	}

	private String checkErrorInInput(String input) {
		if(input.length() > 6) {
			return "\nWrong moved combination length";
		}
		if(!input.matches(MOVE_REGEX)) {
			return "\nWrong move, it must be like: qh4xe1";
		}
		
		return "";
	}
	
	public void show() {
		System.out.println(this.color);
	}
	
	public static void main(String[] args) {
		Player player = new Player(Color.WHITE);
		
		player.createMovement();
	}
}
