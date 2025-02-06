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
		this.VerCarta().Mostrar();
	}
	
	protected boolean EstaVacio() {
		return cartas.isEmpty();
	}
	
	protected Carta CogerCarta() {
		return this.CogerCarta(1);
	}
	
	protected Carta CogerCarta(int numeroCarta) {         
		assert !this.EstaVacio();
		assert numeroCarta > 0;
		
		Carta cartaADevolver = cartas.get(numeroCarta - 1);
		cartas.remove(numeroCarta - 1);
		return cartaADevolver;
	}
	
	protected Carta VerCarta() {
		return this.VerCarta(1);
	}
	
	protected Carta VerCarta(int numeroCarta) {
		assert !this.EstaVacio();
		assert numeroCarta > 0;
		
		return cartas.get(numeroCarta - 1);
	}
	
	protected int Tamano() {
		return cartas.size();
	}
}
