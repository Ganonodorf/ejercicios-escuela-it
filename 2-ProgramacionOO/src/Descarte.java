
public class Descarte extends Mazo{

	@Override
	public boolean SePuedeAnadirCarta(Carta carta) {
		return true;
	}
	
	public void AnadirCarta(Carta carta) {
		super.AnadirCarta(carta);
		this.VerCarta().Revelar(true);
	}
}
