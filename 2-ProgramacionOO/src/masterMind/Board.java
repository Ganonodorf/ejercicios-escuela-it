package masterMind;

import java.util.Random;

public class Board {
	
	private int attemps = 0;
	
	private Combination secretCombination;
	
	private String[] result;
	
	private boolean winnerResult = false;
	
	public Board(int numberOfAttemps) {
		createSecretCombination();
		
		result = new String[numberOfAttemps];
	}
	
	public void proposeCombination(Combination combination) {
		int numberOfBlacks = secretCombination.numberOfExactMatches(combination);
		
		if(numberOfBlacks == 4) {
			winnerResult = true;
		}
		
		int numberOfWhites = secretCombination.numberOfEqualColors(combination) - numberOfBlacks;
		
		saveResult(combination, numberOfBlacks, numberOfWhites);
		
		attemps++;
	}
	
	public boolean isWinnerResult() {
		return winnerResult;
	}
	
	public int numberOfAttemps() {
		return attemps;
	}
	
	private void saveResult(Combination combination, int numberOfBlacks, int numberOfWhites) {
		result[attemps] = combination.toString() + " --> " + numberOfBlacks + " blacks and " + numberOfWhites + " whites";
	}

	private void createSecretCombination() {
		Random rand = new Random();
		Color[] colors = Color.values();
		
		secretCombination = new Combination(colors[rand.nextInt(colors.length)], 
											colors[rand.nextInt(colors.length)], 
											colors[rand.nextInt(colors.length)], 
											colors[rand.nextInt(colors.length)]);
	}
}
