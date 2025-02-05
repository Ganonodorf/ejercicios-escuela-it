import java.util.ArrayList;

public abstract class Mazo {
	
	protected ArrayList<Carta> cartas;
	
	public Mazo() {
		
	}
	
	protected abstract boolean SePuedeAnadirCarta(Carta carta);
	
	protected void AnadirCarta(Carta carta) {
		cartas.addFirst(carta);
	}

	protected void Mostrar() {
		if(!this.EstaVacio()) {
			MostrarContenido();
		}
		else {
			System.out.println("___");
		}
	}
	
	
	protected void MostrarContenido() {
		this.VerPrimeracarta().Mostrar();
	}
	
	protected boolean EstaVacio() {
		return cartas.isEmpty();
	}
	
	protected Carta CogerPrimeraCarta() {
		assert !this.EstaVacio();
		Carta cartaADevolver = cartas.getFirst();
		cartas.remove(0);
		return cartaADevolver;
	}
	
	protected Carta VerPrimeracarta() {
		assert !this.EstaVacio();
		return cartas.getFirst();
	}
}
