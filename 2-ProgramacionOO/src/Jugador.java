import java.util.ArrayList;
import java.util.Scanner;

public class Jugador {
	
	private ArrayList<Accion> acciones;
	
	private Salir salir;
	
	public Jugador() {
		acciones = new ArrayList<Accion>();
		
		salir = new Salir();
	}

	public void AnadirAccion(Accion accion) {
		acciones.add(accion);
	}
	
	public void CerrarAcciones() {
		acciones.add(salir);
	}

	public Accion RecogerAccion() {
		String input;
		
		Scanner scanner = new Scanner(System.in);
		
		boolean matchea;
		
		do {
	        input = scanner.nextLine();
	        
	        matchea = MatcheaAlgunaAccion(input);
	        
	        if(!matchea) {
	        	System.out.println("Input inválido! Prueba otra vez.");
	        }
	        
		}while(!matchea);
		
		return DevolverAccion(input);
	}
	
	private boolean MatcheaAlgunaAccion(String input) {
		for(int i = 0; i < acciones.size(); i++) {
        	if(acciones.get(i).Coincide(input)) {
        		return true;
        	}
        }
		
		return false;
	}
	
	private Accion DevolverAccion(String input) {
		for(int i = 0; i < acciones.size(); i++) {
        	if(acciones.get(i).Coincide(input)) {
        		return acciones.get(i);
        	}
        }
		
		return null;
	}
	
	public boolean SalirPresionado() {
		return salir.HaSidoAccionado();
	}

	public void CantarVictoria() {
		System.out.println("Gané gané");
	}
	
	public void MostrarAcciones() {
		for(int i = 0; i < acciones.size(); i++) {
			acciones.get(i).Mostrar();
			System.out.print("\n");
		}
	}
}
