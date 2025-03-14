package masterMindWithViews;

public class Combination {

	private Color[] combination = new Color[4];
	
	public Combination(Color first, Color second, Color third, Color fourth) {
		combination[0] = first;
		combination[1] = second;
		combination[2] = third;
		combination[3] = fourth;
	}
	
	public String toString() {
		String result = "";
		
		for(int i = 0; i < this.combination.length; i++) {
			result += this.combination[i].toString().toLowerCase().charAt(0);
		}
		
		return result;
	}
	
	public int numberOfEqualColors(Combination combination) {
		int result = 0;
		boolean[] checkedColors = new boolean[4];
		
		for(int i = 0; i < this.combination.length; i++) {
			int j = 0;
			boolean out = false;
			do {
				if(checkedColors[j] == false && this.combination[i] == combination.combination[j]) {
					result++;
					checkedColors[j] = true;
					out = true;
				}
				j++;
			}while(j < this.combination.length && out == false);
		}
		
		return result;
	}
	
	public int numberOfExactMatches(Combination combination) {
		int result = 0;
		
		for(int i = 0; i < this.combination.length; i++) {
			if(this.combination[i] == combination.combination[i]) {
				result++;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Combination primeCombi = new Combination(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW);
		Combination comparisonCombi = new Combination(Color.CYAN, Color.MAGENTA, Color.RED, Color.GREEN);
		
		int numEqualColors = primeCombi.numberOfEqualColors(comparisonCombi);

		System.out.println(primeCombi.toString());
		System.out.println(comparisonCombi.toString());
		
		System.out.println(numEqualColors);
	
		
		primeCombi = new Combination(Color.RED, Color.RED, Color.BLUE, Color.YELLOW);
		comparisonCombi = new Combination(Color.BLUE, Color.RED, Color.RED, Color.RED);
		
		numEqualColors = primeCombi.numberOfEqualColors(comparisonCombi);

		System.out.println(primeCombi.toString());
		System.out.println(comparisonCombi.toString());
		
		System.out.println(numEqualColors);
	
		
		primeCombi = new Combination(Color.RED, Color.RED, Color.RED, Color.YELLOW);
		comparisonCombi = new Combination(Color.BLUE, Color.MAGENTA, Color.BLUE, Color.GREEN);
		
		numEqualColors = primeCombi.numberOfEqualColors(comparisonCombi);

		System.out.println(primeCombi.toString());
		System.out.println(comparisonCombi.toString());
		
		System.out.println(numEqualColors);
	
		
		primeCombi = new Combination(Color.RED, Color.RED, Color.RED, Color.YELLOW);
		comparisonCombi = new Combination(Color.RED, Color.RED, Color.RED, Color.YELLOW);
		
		numEqualColors = primeCombi.numberOfEqualColors(comparisonCombi);

		System.out.println(primeCombi.toString());
		System.out.println(comparisonCombi.toString());
		
		System.out.println(numEqualColors);
	}
}
