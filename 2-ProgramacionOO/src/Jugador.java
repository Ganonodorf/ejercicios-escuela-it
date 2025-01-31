import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Jugador {
	
	public Jugador() {
		
	}
	
	public void Accionar(Baraja baraja, Montones montones) {
		assert baraja != null;
		assert montones != null;
		
		MostrarInfo();
		
		String input = RecogerInput();
		
		HacerAccion(input);
	}

	private void HacerAccion(String input) {
		// TODO Auto-generated method stub
		
	}

	private String RecogerInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.toString();
	}

	private void MostrarInfo() {
		System.out.println("Nueva carta: c \n");
		System.out.println("Mover carta: número montón + posición carta desde abajo + nuevo número montón");
	}

	public boolean PuedeAccionar() {
		// TODO Auto-generated method stub
		return false;
	}

	public void CantarVictoria() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		
	}
}
