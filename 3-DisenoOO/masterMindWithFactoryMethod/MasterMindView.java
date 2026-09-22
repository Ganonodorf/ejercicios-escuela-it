package masterMindWithFactoryMethod;

public abstract class MasterMindView {
	protected final String ANSWER_REGEX = "^[yn]$";
	
	public MasterMindView() {
		
	}
	
	public abstract void winMessage();

	public abstract void loseMessage();
	
	public abstract boolean askUserPlayAgain();
	
	protected abstract boolean isPlayingAgain(String input);

	protected abstract boolean isGoodAnswer(String input);

}
