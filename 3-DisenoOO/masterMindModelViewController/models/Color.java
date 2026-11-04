package masterMindModelViewController.models;

public enum Color {
	RED,
	GREEN,
	BLUE,
	YELLOW,
	CYAN,
	MAGENTA,
	NULL;
	
	public static Color charToColor(char colorChar) {
		switch(colorChar) {
		case 'r':
			return Color.RED;
		case 'g':
			return Color.GREEN;
		case 'b':
			return Color.BLUE;
		case 'm':
			return Color.MAGENTA;
		case 'c':
			return Color.CYAN;
		case 'y':
			return Color.YELLOW;
		default:
			return Color.NULL;
		}
	}
}