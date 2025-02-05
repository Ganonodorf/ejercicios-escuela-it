import java.util.Collections;

public class Baraja extends Mazo {
	
	private final int NUMERO_PALOS = 4;
	
	private final int NUMERO_CARTAS = 13;
	
	public Baraja() {
		super();
		
		for(int i = 1; i < NUMERO_PALOS + 1; i++) {
			for(int j = 1; j < NUMERO_CARTAS + 1; j++) {
				this.AnadirCarta(new Carta (i, j));
			}
		}
	}

	@Override
	public void Mostrar() {
		if(!this.EstaVacio()) {
			System.out.println("▒▒▒");
		}
		else {
			System.out.println("___");
		}
	}

	@Override
	public boolean SePuedeAnadirCarta(Carta carta) {
		return true;
	}

	public void CartaAlDescarte(Descarte descarte) {
		if(this.EstaVacio()) {
			RellenarMazo(descarte);
			CartaAlDescarte(descarte);
		}
		else {
			descarte.AnadirCarta(this.CogerPrimeraCarta());
		}
	}

	private void RellenarMazo(Descarte descarte) {
		while(!descarte.EstaVacio()) {
			this.AnadirCarta(descarte.CogerPrimeraCarta());
			this.VerPrimeracarta().Revelar(false);
		}
	}

	public void Barajar() {
		Collections.shuffle(cartas);
	}
}
