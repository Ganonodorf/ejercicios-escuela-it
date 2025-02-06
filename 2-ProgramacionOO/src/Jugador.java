import java.util.Scanner;

public class Jugador {
	
	public Jugador() {
		
	}

	public String RecogerInput() {
		String input;
		
		Scanner scanner = new Scanner(System.in);
		
		do {
	        input = scanner.nextLine();
		}while(!NuevaCartaDelMazo(input) &&
				!CartaDelDescarteAMonton(input) &&
				!CartaDelDescarteAPilar(input) &&
				!CartaDelMontonAlPilar(input) &&
				!MoverCartasEntreMontones(input));
		
		return input;
	}
	

	private boolean NuevaCartaDelMazo(String input) {
		return input.matches("^c");
	}
	
	private boolean CartaDelDescarteAMonton(String input) {
		return input.matches("^d-[1-7]");
	}
	
	private boolean CartaDelDescarteAPilar(String input) {
		return input.matches("^d-p");
	}
	
	private boolean CartaDelMontonAlPilar(String input) {
		return input.matches("^[1-7]-p");
	}

	private boolean MoverCartasEntreMontones(String input) {
		return input.matches("^[1-7]-[1-9][0-9]?-[1-7]");
	}

	public void CantarVictoria() {
		System.out.println("Gané gané");
		
	}
}
