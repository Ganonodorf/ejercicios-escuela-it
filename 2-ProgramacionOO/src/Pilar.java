public class Pilar extends Mazo {
	
	int palo;
	
	public Pilar(int palo) {
		this.palo = palo;
	}
	
	@Override
	public boolean SePuedeAnadirCarta(Carta carta) {
		if(this.EstaVacio() && carta.EsAs() && carta.getPalo() == palo) {
			return true;
		}
		
		if(!this.EstaVacio() && this.VerCarta().EsInmediatamenteInferior(carta) && this.VerCarta().SonDelMismoPalo(carta)) {
			return true;
		}
		
		return false;
	}
	
	public boolean EstaCompleto() {
		return this.Tamano() == 13;
	}
}
