public class Pilar extends Mazo {
	
	@Override
	public boolean SePuedeAnadirCarta(Carta carta) {
		if(this.EstaVacio() && carta.EsRey()) {
			return true;
		}
		
		if(!this.EstaVacio() && this.VerPrimeracarta().EsInmediatamenteInferior(carta) && this.VerPrimeracarta().SonDelMismoPalo(carta)) {
			return true;
		}
		
		return false;
	}
}
