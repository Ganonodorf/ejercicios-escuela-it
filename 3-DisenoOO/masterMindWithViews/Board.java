package masterMindWithViews;

import java.util.Random;

public class Board {
	
	private int numAttempts = 0;
	
	private Combination secretCombination;
	
	private Play[] plays;
	
	private boolean winnerResult = false;
	
	public Board(int numberOfAttemps) {
		createSecretCombination();
		
		plays = new Play[numberOfAttemps];
	}
	
	public void proposeCombination(Combination combination) {
		int numberOfBlacks = secretCombination.numberOfExactMatches(combination);
		
		if(numberOfBlacks == 4) {
			winnerResult = true;
		}
		
		int numberOfWhites = secretCombination.numberOfEqualColors(combination) - numberOfBlacks;
		
		savePlay(new Play(combination, new Result(numberOfBlacks, numberOfWhites)));
		
		numAttempts++;
	}
	
	private void savePlay(Play play) {
		this.plays[numAttempts] = play;
	}
	
	public boolean isWinnerResult() {
		return winnerResult;
	}
	
	public int numberOfAttempts() {
		return numAttempts;
	}

	private void createSecretCombination() {
		Random rand = new Random();
		Color[] colors = Color.values();
		
		secretCombination = new Combination(colors[rand.nextInt(colors.length)], 
											colors[rand.nextInt(colors.length)], 
											colors[rand.nextInt(colors.length)], 
											colors[rand.nextInt(colors.length)]);
	}
	
	public Play[] getPlays() {
		return plays;
	}
}
