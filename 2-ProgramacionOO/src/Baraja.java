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

	public String Mostrar() {
		String mostrar = "";
		
		if(HayCartasEnElMazo()) {
			mostrar += "▒▒▒";
		}
		else {
			mostrar += "___";
		}
		
		mostrar += "  ";
		
		if(HayDescarte()) {
			mostrar += descarte.getFirst().Mostrar();
		}
		else {
			mostrar += "___";
		}
		
		return mostrar;
	}

	public void NuevaCarta() {
		if(mazo.isEmpty()) {
			RellenarMazo();
			NuevaCarta();
		}
		else {
			descarte.addFirst(mazo.getFirst());
			descarte.get(0).Revelar(true);
			mazo.removeFirst();
		}
	}

	private void RellenarMazo() {
		while(!descarte.isEmpty()) {
			mazo.addFirst(descarte.getFirst());
			mazo.get(0).Revelar(false);
			descarte.remove(0);
		}
	}

	public boolean HayDescarte() {
		return !descarte.isEmpty();
	}

	public Carta VerDescarte() {
		return descarte.getFirst();
	}

	public Carta ObtenerDescarte() {
		Carta cartaADevolver = descarte.getFirst();
		descarte.remove(0);
		return cartaADevolver;
	}

	private boolean HayCartasEnElMazo() {
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
	
	public static void main(String[] args) {
		Baraja baraja = new Baraja();
		
		baraja.Barajar();
		
		baraja.Mostrar();
		
		for(int i = 0; i < 100; i++) {
			baraja.NuevaCarta();

			baraja.Mostrar();
		}
	}

	public boolean HayCartasEnLaBaraja() {
		return HayCartasEnElMazo() && HayDescarte();
	}
}
