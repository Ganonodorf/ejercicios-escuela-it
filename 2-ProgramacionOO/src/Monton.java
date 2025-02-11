public class Monton extends Mazo{
	int posicion;
	
	public Monton(int posicion, Baraja baraja) {
		this.posicion = posicion;
		
		for(int i = 0; i < posicion; i++) {
			this.AnadirCarta(baraja.CogerCarta());
		}
		this.VerCarta().Revelar(true);
	}

	@Override
	protected void MostrarContenido() {
		System.out.print(posicion + " -> ");
		for(int i = this.Tamano(); i > 0; i--) {
			this.VerCarta(i).Mostrar();
		}
	}

	@Override
	public boolean SePuedeAnadirCarta(Carta carta) {
		if(this.EstaVacio() && carta.EsRey()) {
			return true;
		}
		
		if(!this.EstaVacio() &&	!carta.SonDelMismoColor(this.VerCarta()) && carta.EsInmediatamenteInferior(this.VerCarta())) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public Carta CogerCarta() {
		Carta cartaADevolver = super.CogerCarta();
		this.cartas.getFirst().Mostrar();
		return cartaADevolver;
	}
	
	@Override
	public Carta CogerCarta(int numeroCarta) {
		Carta cartaADevolver = super.CogerCarta(numeroCarta);
		this.cartas.getFirst().Mostrar();
		return cartaADevolver;
	}
}
