package masterMind;

import java.util.Scanner;

public class Player {
	
	private String COMBINATION_REGEX = "REGEX_MATCH";
	
	public Player() {
	}
	
	public Combination createCombination() {
		String input;
		
		Scanner scanner = new Scanner(System.in);
		
		boolean goodCombination;

		do {
	        input = scanner.nextLine();
	        
	        goodCombination = isGoodCombination(input);
	        
	        if(!goodCombination) {
	        	System.out.println("Not a valid combination.");
	        }
	        
		}while(!goodCombination);
		
		return inputToCombination(input);
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
		case 'g':
			result = Color.GREEN;
		case 'b':
			result = Color.BLUE;
		case 'm':
			result = Color.MAGENTA;
		case 'c':
			result = Color.CYAN;
		case 'y':
			result = Color.YELLOW;
		default:
			result = Color.RED;
		}
		
		return result;
	}

	private boolean isGoodCombination(String input) {
		if(input.matches(COMBINATION_REGEX)) {
			return true;
		}
		
		return false;
	}
}
