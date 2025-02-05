import java.util.ArrayList;

public abstract class Mazo {
	
	protected ArrayList<Carta> cartas;
	
	public Mazo() {
	}
	
	public abstract boolean SePuedeAnadirCarta(Carta carta);
	
	public void AnadirCarta(Carta carta) {
		cartas.addFirst(carta);
	}

	public void Mostrar() {
		if(!this.EstaVacio()) {
			System.out.println(this.VerPrimeracarta().Mostrar());
		}
		else {
			System.out.println("___");
		}
	}
	
	public boolean EstaVacio() {
		return cartas.isEmpty();
	}
	
	public Carta CogerPrimeraCarta() {
		assert !this.EstaVacio();
		Carta cartaADevolver = cartas.getFirst();
		cartas.remove(0);
		return cartaADevolver;
	}
	
	public Carta VerPrimeracarta() {
		assert !this.EstaVacio();
		return cartas.getFirst();
	}
}
