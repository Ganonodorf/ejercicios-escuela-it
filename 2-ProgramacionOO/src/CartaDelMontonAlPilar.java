import java.util.Scanner;

public class CartaDelMontonAlPilar extends Accion {
	
	private Monton[] montones;
	private Pilar[] pilares;
	
	public CartaDelMontonAlPilar(Monton[] montones, Pilar[] pilares) {
		super("Carta del monton al pilar: m-p", "^m-p");
		this.montones = montones;
		this.pilares = pilares;
	}
	
	@Override
	public void Accionar() {
		assert montones != null;
		assert pilares != null;
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("¿Desde qué montón?");
		
        String input = scanner.nextLine();
        
        
        if(!input.matches("^[1-7]")) {
        	System.out.println("Montón inválido, acción detenida.");
        	return;
        }
        
        if(!SePuedeAnadirAlPilar(Integer.parseInt(input))) {
        	System.out.println("Esa carte del montón es inválida, acción detenida.");
        	return;
        }
        
        AnadirAlPilar(Integer.parseInt(input));
	}

	private void AnadirAlPilar(int posicionMonton) {
		for(int i = 0; i < pilares.length; i++) {
			if(pilares[i].SePuedeAnadirCarta(montones[posicionMonton + 1].VerCarta())) {
				pilares[i].AnadirCarta(montones[posicionMonton + 1].CogerCarta());
			}
		}
	}

	private boolean SePuedeAnadirAlPilar(int posicionMonton) {
		for(int i = 0; i < pilares.length; i++) {
			if(pilares[i].SePuedeAnadirCarta(montones[posicionMonton + 1].VerCarta())) {
				return true;
			}
		}
		return false;
	}
}
