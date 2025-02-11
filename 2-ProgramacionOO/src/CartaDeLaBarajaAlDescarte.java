
public class CartaDeLaBarajaAlDescarte extends Accion{
	
	private Baraja baraja;
	private Descarte descarte;
	
	public CartaDeLaBarajaAlDescarte(Baraja baraja, Descarte descarte) {
		super("Carta de la baraja al descarte: c", "^c");
		this.baraja = baraja;
		this.descarte = descarte;
	}
	
	@Override
	public void Accionar() {
		if(baraja.EstaVacio() && descarte.EstaVacio()) {
			System.out.println("No quedan cartas ni en el mazo ni en la baraja!");
			return;
		}
		
		if(baraja.EstaVacio() && !descarte.EstaVacio()) {
			RellenarBarajaConDescarte(baraja, descarte);
			this.Accionar();
		}

		descarte.AnadirCarta(baraja.CogerCarta());
	}
	
	private void RellenarBarajaConDescarte(Baraja baraja, Descarte descarte) {
		assert baraja != null;
		assert descarte != null;
		
		while(!descarte.EstaVacio()) {
			baraja.AnadirCarta(descarte.CogerCarta());
			baraja.VerCarta().Revelar(false);
		}
	}
}
