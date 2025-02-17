package masterMind;

public class Combination {

	private Color[] combination = new Color[4];
	
	public Combination(Color first, Color second, Color third, Color fourth) {
		combination[0] = first;
		combination[1] = second;
		combination[2] = third;
		combination[3] = fourth;
	}
	
	public int numberOfEqualColors(Combination combination) {
		int result = 0;
		boolean[] checkedColors = new boolean[4];
		
		for(int i = 0; i < 4; i++) {
			int j = 0;
			boolean out = false;
			do {
				if(checkedColors[j] == false && this.combination[i] == combination.combination[j]) {
					result++;
					checkedColors[j] = true;
					out = true;
				}
			}while(j < 4 && out == false);
		}
		
		return result;
	}
}
