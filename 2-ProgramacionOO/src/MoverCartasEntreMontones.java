import java.util.Scanner;

public class MoverCartasEntreMontones extends Accion{
	
	private Monton[] montones;
	
	public MoverCartasEntreMontones(Monton[] montones) {
		super("Mover cartas entre montones: m-m", "^m-m");
		this.montones = montones;
	}
	
	public void Accionar() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Elija montón origen, carta y montón destino: m-c-m");
		
        String input = scanner.nextLine();
        
        if(!input.matches("^[1-7]-[1-9][0-9]-[1-7]?")) {
        	System.out.println("Input inválido, acción detenida.");
        	return;
        }
        
        String[] inputSeparado = input.split("-");
        
        int montonOrigen = Integer.parseInt(inputSeparado[0]);
        int carta = Integer.parseInt(inputSeparado[1]);
        int montonDestino = Integer.parseInt(inputSeparado[2]);
        
        if(carta >= montones[montonOrigen].Tamano()) {
        	System.out.println("El montón no tiene tantas cartas, acción detenida.");
        	return;
        }
        
        if(!montones[montonDestino].SePuedeAnadirCarta(montones[montonOrigen].VerCarta(carta))) {
        	System.out.println("No se puede añadir esa carta, acción detenida.");
        	return;
        }
        
        montones[montonDestino].AnadirCarta(montones[montonOrigen].CogerCarta(carta));
	}
}
