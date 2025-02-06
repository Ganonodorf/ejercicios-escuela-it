public class Monton extends Mazo{
	
	public Monton(int posicion, Baraja baraja) {
		for(int i = 0; i < posicion; i++) {
			this.AnadirCarta(baraja.CogerCarta());
		}
	}

	@Override
	protected void MostrarContenido() {
		for(Carta carta : cartas) {
			 carta.Mostrar();
			 System.out.println("  ");
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
}
