public class Accion {
	
	public Accion() {
		
	}
	
	public void CartaDeLaBarajaAlDescarte(Baraja baraja, Descarte descarte) {
		assert baraja != null;
		assert descarte != null;

		if(baraja.EstaVacio() && descarte.EstaVacio()) {
			System.out.println("No quedan cartas ni en el mazo ni en la baraja!");
			return;
		}
		
		if(baraja.EstaVacio() && !descarte.EstaVacio()) {
			RellenarBarajaConDescarte(baraja, descarte);
			CartaDeLaBarajaAlDescarte(baraja, descarte);
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
	
	public void CartaDelDescarteAlMonton(Descarte descarte, Monton monton) {
		assert descarte != null;
		assert monton != null;
		
		if(!monton.SePuedeAnadirCarta(descarte.VerCarta())) {
			System.out.println("No se puede añadir esa carta del descarte al montón.");
			return;
		}
		
		monton.AnadirCarta(descarte.CogerCarta());
	}
	
	public void CartaDelDescarteAlPilar(Descarte descarte, Pilar pilar) {
		assert descarte != null;
		assert pilar != null;
		
		if(!pilar.SePuedeAnadirCarta(descarte.VerCarta())) {
			System.out.println("No se puede añadir esa carta del descarte al pilar.");
			return;
		}
		
		pilar.AnadirCarta(descarte.CogerCarta());
	}
	
	public void CartaDelMontonAlPilar(Monton monton, Pilar pilar) {
		assert monton != null;
		assert pilar != null;
		
		if(!pilar.SePuedeAnadirCarta(monton.VerCarta())) {
			System.out.println("No se puede añadir esa carta del monton al pilar.");
			return;
		}
		
		pilar.AnadirCarta(monton.CogerCarta());
	}
	
	public void MoverCartasEntreMontones(Monton montonOrigen, int numeroCarta, Monton montonDestino) {
		assert montonOrigen != null;
		assert numeroCarta > 0;
		assert montonDestino != null;
		
		if(numeroCarta >= montonOrigen.Tamano()) {
			System.out.println("El montón es más pequeño, la carta que intentas coger no existe.");
			return;
		}
		
		if(montonDestino.SePuedeAnadirCarta(montonOrigen.CogerCarta(numeroCarta))) {
			do {
				montonDestino.AnadirCarta(montonOrigen.CogerCarta());
				numeroCarta--;
			}while(numeroCarta < 1);
		}
	}

	public boolean PuedeAccionar(Baraja baraja, Monton[] montones) {
		boolean hayCartasEnLosMontones = false;
		
		int i = 0;
		
		while(hayCartasEnLosMontones == false && i < montones.length) {
			hayCartasEnLosMontones = !montones[i].EstaVacio();
		}
		
		return !baraja.EstaVacio() || hayCartasEnLosMontones;
	}
}