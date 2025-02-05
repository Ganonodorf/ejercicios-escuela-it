
public class Descarte extends Mazo{

	@Override
	public boolean SePuedeAnadirCarta(Carta carta) {
		return true;
	}

	@Override
	public void Mostrar() {
		if(!this.EstaVacio()) {
			System.out.println(this.VerPrimeracarta().Mostrar());
		}
		else {
			System.out.println("___");
		}
	}
}
