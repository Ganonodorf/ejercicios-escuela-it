package masterMindWithFactoryMethod;

public class ConsoleMasterMind extends MasterMind {
	
	@Override
	public ConsoleView createView() {
		return new ConsoleView();
	}
	
	public static void main(String[] args) {
		MasterMind masterMind = new ConsoleMasterMind();
		
		masterMind.play();
	}
}
