import java.util.Scanner;

public class CartaDelDescarteAlMonton extends Accion {
	
	private Descarte descarte;
	private Monton[] montones;
	
	public CartaDelDescarteAlMonton(Descarte descarte, Monton[] montones) {
		super("Carta del descarte al montón: d-m", "^d-m");
		this.descarte = descarte;
		this.montones = montones;
	}
	
	@Override
	public void Accionar() {
		assert descarte != null;
		assert montones != null;
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("¿A qué montón?");
		
        String input = scanner.nextLine();
        
        if(input.matches("^[1-7]") && montones[Integer.parseInt(input)].SePuedeAnadirCarta(descarte.VerCarta())) {
        	montones[Integer.parseInt(input)].AnadirCarta(descarte.CogerCarta());
        	return;
        }

    	System.out.println("Montón inválido, acción detenida.");
	}
}
