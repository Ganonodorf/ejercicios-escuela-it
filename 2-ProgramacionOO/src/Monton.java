import java.util.ArrayList;

public class Monton extends Mazo{
	
	public Monton(int posicion, Baraja baraja) {
		for(int i = 0; i < posicion; i++) {
			this.AnadirCarta(baraja.CogerPrimeraCarta());
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
		
		if(!this.EstaVacio() &&	!carta.SonDelMismoColor(this.VerPrimeracarta()) && carta.EsInmediatamenteInferior(this.VerPrimeracarta())) {
			return true;
		}
		
		return false;
	}

	public boolean SePuedeMoverCarta(int montonOrigen, int posicionCarta, int montonDestino) {
		Carta cartaSeleccionada = montonesCartas.get(montonOrigen - 1).get(posicionCarta - 1);
		if(!cartaSeleccionada.EstaRevalada()) {
			return false;
		}
		if(cartaSeleccionada.getNumero() == 13 && EstaElMontonVacio(montonDestino)) {
			return true;
		}
		if(cartaSeleccionada.getNumero() != 13 && EstaElMontonVacio(montonDestino)) {
			return false;
		}
		Carta cartaDestino = PrimeraCartaMonton(montonDestino);
		if(cartaSeleccionada != null && cartaDestino != null &&
				!cartaSeleccionada.SonDelMismoColor(cartaDestino) && cartaSeleccionada.EsInmediatamenteInferior(cartaDestino)){
			return true;
		}
		return false;
	}

	public void MoverCartas(int montonOrigen, int posicionCarta, int montonDestino) {
		for(int i = posicionCarta - 1; i >= 0; i--) {
			montonesCartas.get(montonDestino - 1).addFirst(montonesCartas.get(montonOrigen - 1).get(i));
			montonesCartas.get(montonOrigen - 1).remove(i);
		}
		if(!EstaElMontonVacio(montonOrigen)) {
			PrimeraCartaMonton(montonOrigen).Revelar(true);
		}
	}
}
