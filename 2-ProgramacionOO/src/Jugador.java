import java.util.Scanner;

public class Jugador {
	
	public Jugador() {
		
	}
	
	public void Accionar(Baraja baraja, Montones montones) {
		assert baraja != null;
		assert montones != null;
		
		MostrarInfo();
		
		String input = RecogerInput();
		
		HacerAccion(baraja, montones, input);
	}

	private void MostrarInfo() {
		System.out.println("Nueva carta del mazo: c \n");
		System.out.println("Carta del descarte a un montón: d-número montón \n");
		System.out.println("Carta de un montón a un pilar: número montón-p \n");
		System.out.println("Mover carta: número montón-posición carta desde abajo-nuevo número montón");
	}

	private String RecogerInput() {
        Scanner scanner = new Scanner(System.in);
        String inputJugador;
		do {
			inputJugador = scanner.nextLine();
		}while(InputValido(inputJugador));
		
        return inputJugador;
	}

	private boolean InputValido(String input) {
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
		System.out.println("Input no válido \n");
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


	private void HacerAccion(Baraja baraja, Montones montones, String input) {
		if(NuevaCartaDelMazo(input)) {
			baraja.NuevaCarta();
			return;
		}
		
		if(CartaDelDescarteAMonton(input)) {
			if(montones.SePuedeAnadirCarta(baraja.ObtenerDescarte(), input.charAt(2))){
				montones.AnadirCarta(baraja.ObtenerDescarte(), input.charAt(2));
			}
		}
		
		if(CartaDelMontonAlPilar(input)) {
			return true;
		}
		
		if(MoverCartasEntreMontones(input)) {
			return true;
		}
		
		System.out.println("Input no válido \n");
		return false;
	}

	public boolean PuedeAccionar() {
		// TODO Auto-generated method stub
		return false;
	}

	public void CantarVictoria() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		Jugador jugador = new Jugador();
		
		jugador.MostrarInfo();
		String inputJugador = jugador.RecogerInput();
	
		System.out.println("Lo que introdujo el jugador fue: " + inputJugador);
	}
}
