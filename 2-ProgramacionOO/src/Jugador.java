import java.util.ArrayList;
import java.util.Scanner;

public class Jugador {
	
	private ArrayList<Accion> acciones;
	
	
	public Jugador() {
		acciones = new ArrayList<Accion>();
	}

	public void AnadirAccion(Accion accion) {
		acciones.add(accion);
	}

	public Accion RecogerAccion() {
		String input;
		
		Scanner scanner = new Scanner(System.in);
		
		do {
	        input = scanner.nextLine();
	        
	        if(NuevaCartaDelMazo(input)) {
	        	return 
	        }
		}while(true);
		if(NuevaCartaDelMazo())
		do {
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
