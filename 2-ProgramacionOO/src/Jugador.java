import java.util.Scanner;

public class Jugador {
	
	public Jugador() {
		
	}

	public String RecogerInput() {
        Scanner scanner = new Scanner(System.in);
        String inputJugador;
        
		do {
			inputJugador = scanner.nextLine();
		}while(!InputValido(inputJugador));
		
        return inputJugador;
	}

	public boolean InputValido(String input) {
		if(NuevaCartaDelMazo(input)) {
			return true;
		}
		if(CartaDelDescarteAMonton(input)) {
			return true;
		}
		if(CartaDelMontonAlPilar(input)) {
			return true;
		}
		if(MoverCartasEntreMontones(input)) {
			return true;
		}
		System.out.println("Input no válido.\n");
		return false;
	}

	private boolean NuevaCartaDelMazo(String input) {
		return input.matches("c");
	}
	
	private boolean CartaDelDescarteAMonton(String input) {
		return input.matches("^d-[1-7]");
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
	
	public static void main(String[] args) {

	}
}
