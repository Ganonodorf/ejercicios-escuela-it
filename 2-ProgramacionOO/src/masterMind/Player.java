package masterMind;

import java.util.Scanner;

public class Player {
	
	private final String COMBINATION_REGEX = "^[rgbycm][rgbycm][rgbycm][rgbycm]$";
	
	public Player() {
	}
	
	public Combination createCombination() {
		String input;
		
		Scanner scanner = new Scanner(System.in);
		
		boolean goodCombination;

		String error;

		do {
			System.out.println("move a combination: rybgmc");
			
	        input = scanner.nextLine();
	        
	        error = checkErrorInInput(input);
	        
	        if(error.length() > 0) {
	        	System.out.println(error);
	        }
		}while(error.length() > 0);
		
		return inputToCombination(input);
	}

	private String checkErrorInInput(String input) {
		if(input.length() != 4) {
			return "Wrong moved combination length";
		}
		if(!input.matches(COMBINATION_REGEX)) {
			return "Wrong colors, they must be: rgybmc";
		}
		
		return "";
	}

	private Combination inputToCombination(String input) {
		Color[] colors = new Color[4];
		
		for(int i = 0; i < 4; i++) {
			colors[i] = charToColor(input.charAt(i));
		}
		
		return new Combination(colors[0], colors[1], colors[2], colors[3]);
	}

	private Color charToColor(char colorChar) {
		Color result;

		switch(colorChar) {
		case 'r':
			result = Color.RED;
			break;
		case 'g':
			result = Color.GREEN;
			break;
		case 'b':
			result = Color.BLUE;
			break;
		case 'm':
			result = Color.MAGENTA;
			break;
		case 'c':
			result = Color.CYAN;
			break;
		case 'y':
			result = Color.YELLOW;
			break;
		default:
			result = Color.RED;
			break;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Player player = new Player();
		
		System.out.print(player.inputToCombination("ymmg").toString());
		
	}
}
