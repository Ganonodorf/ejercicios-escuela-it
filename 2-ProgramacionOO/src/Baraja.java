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
		String mostrar = "";
		
		if(HayCartasEnElMazo()) {
			mostrar += "▒ ";
		}
		else {
			mostrar += "  ";
		}
		
		if(HayDescarte()) {
			mostrar += descarte.getFirst().Mostrar();
		}
		else {
			mostrar += " ";
		}
		
		System.out.println(mostrar);
	}

	public void NuevaCarta() {
		descarte.addFirst(mazo.getFirst());
		mazo.removeFirst();
	}

	public boolean HayDescarte() {
		return !descarte.isEmpty();
	}

	public Carta ObtenerDescarte() {
		return descarte.getFirst();
	}

	public boolean HayCartasEnElMazo() {
		return !mazo.isEmpty();
	}

	public void Barajar() {
		Collections.shuffle(mazo);
		
	}

	public Carta ObtenerPrimeraCarta() {
		Carta cartaADevolver = mazo.getFirst();
		mazo.remove(0);
		return cartaADevolver;
	}
}
