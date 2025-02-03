import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
	
	private ArrayList<Carta> mazo;
	
	private ArrayList<Carta> descarte;
	
	public Baraja() {
		mazo = new ArrayList<Carta>();
		descarte = new ArrayList<Carta>();
		
		for(int i = 1; i < 5; i++) {
			for(int j = 1; j < 14; j++) {
				mazo.add(new Carta(i, j));
			}
		}
	}

	public void Mostrar() {
		System.out.println("▒ " + descarte.getLast().Mostrar());
	}

	public void NuevaCarta() {
		descarte.add(mazo.getFirst());
		mazo.removeFirst();
	}

	public boolean HayDescarte() {
		return !descarte.isEmpty();
	}

	public Carta ObtenerDescarte() {
		return descarte.getLast();
	}

	public boolean HayCartasEnElMazo() {
		return !mazo.isEmpty();
	}

	public void Barajar() {
		Collections.shuffle(mazo);
		
	}
}
