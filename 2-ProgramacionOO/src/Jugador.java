import java.util.Scanner;

public class Jugador {
	
	public Jugador() {
		
	}

	public String RecogerInput() {
        return new Scanner(System.in).nextLine();
	}

	public void CantarVictoria() {
		System.out.println("Gané gané");
		
	}
	
	public static void main(String[] args) {

	}
}
