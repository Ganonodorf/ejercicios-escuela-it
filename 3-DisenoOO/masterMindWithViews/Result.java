package masterMindWithViews;

public class Result {

	private int blacks;
	private int whites;
	
	public Result(int blacks, int whites) {
		this.blacks = blacks;
		this.whites = whites;
	}
	
	public String toString() {
		return blacks + " blacks and " + whites + " whites";
	}
}
