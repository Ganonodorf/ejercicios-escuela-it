public class Accion {
		
	public void Accionar(String inputJugador, Baraja baraja, Montones montones, Pilares pilares) {
		assert baraja != null;
		assert montones != null;
		
		if(NuevaCartaDelMazo(inputJugador)) {
			if(baraja.HayCartasEnElMazo()) {
				baraja.NuevaCarta();
			}
			return;
		}
		
		if(CartaDelDescarteAMonton(inputJugador)) {
			if(montones.SePuedeAnadirCarta(baraja.ObtenerDescarte(), inputJugador.charAt(2))){
				montones.AnadirCarta(baraja.ObtenerDescarte(), inputJugador.charAt(2));
			}
			return;
		}
		
		if(CartaDelMontonAlPilar(inputJugador)) {
			if(montones.SePuedeMoverCartaAlPilar(pilares, inputJugador.charAt(0))) {
				montones.CartaAlPilar(pilares, inputJugador.charAt(0));
			}
			return;
		}
		
		if(MoverCartasEntreMontones(inputJugador)) {
			String[] informacion = inputJugador.split("-");
			if(montones.SePuedeMoverCarta(informacion[0], informacion[1], informacion[2])) {
				montones.MoverCartas(informacion[0], informacion[1], informacion[2]);				
			}
			return;
		}
	}

	private boolean NuevaCartaDelMazo(String input) {
		return input.matches("c");
	}
	
	private boolean CartaDelDescarteAMonton(String input) {
		return input.matches("^d-[1-7]");
	}
	
	private boolean CartaDelMontonAlPilar(String input) {
		return input.matches("^[1-7]-p");
	}

	private boolean MoverCartasEntreMontones(String input) {
		return input.matches("^[1-7]-[1-9][0-9]?-[1-7]");
	}

	public boolean PuedeAccionar(Baraja baraja, Montones montones, Pilares pilares) {
		
		return false;
	}
}