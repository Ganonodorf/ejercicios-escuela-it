package masterMindModelViewController.models;

import java.util.ArrayList;
import java.util.Random;

public class Board {
	
	private int maxNumberOfAttempts;
	
	private int numAttempts;
	
	private Combination secretCombination;
	
	private ArrayList<Play> plays;
	
	private boolean winnerResult;
	
	public Board(int maxNumberOfAttempts) {
		this.maxNumberOfAttempts = maxNumberOfAttempts;
		
		initializeBoard();
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
		this.plays.add(play);
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
	
	public ArrayList<Play> getPlays() {
		return plays;
	}
	
	public boolean hasMoreAttempts() {
		return numAttempts < maxNumberOfAttempts;
	}
	
	public void initializeBoard() {
		numAttempts = 0;
		
		winnerResult = false;
		
		createSecretCombination();
		
		plays = new ArrayList<Play>();
	}
	
	public Memento createMemento() {
		ArrayList<Play> mementoPlays = new ArrayList<Play>();
		
		for(Play play: plays) {
			mementoPlays.add(play.copy());
		}
		
		return new Memento(numAttempts, mementoPlays);
	}
	
	public void setState(Memento memento) {
		this.numAttempts = memento.getAttempts();
		
		this.plays = new ArrayList<Play>();
		
		for(int i = 0; i < this.numAttempts; i++) {
			this.plays.add(memento.getPlay(i).copy());
		}
	}
}
