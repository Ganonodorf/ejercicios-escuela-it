package masterMindWithViews;

public class BoardView {
	
	Board board;
	
	public BoardView(Board board) {
		this.board = board;
	}
	
	public void showInformation() {
		int attempts = board.numberOfAttempts();
		Play[] plays = board.getPlays();
		
		System.out.println("\n" + attempts + " attemp(s):");
		System.out.println("****");
		
		for(int i = 0; i < attempts; i++) {
			System.out.println(plays[i].toString());
		}
	}
}
