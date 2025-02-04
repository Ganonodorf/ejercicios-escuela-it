public class Accion {
		
	public void Accionar(String inputJugador, Baraja baraja, Montones montones, Pilares pilares) {
		assert inputJugador != null;
		assert baraja != null;
		assert montones != null;
		assert pilares != null;
		
		if(NuevaCartaDelMazo(inputJugador) && baraja.HayCartasEnElMazo()) {
			baraja.NuevaCarta();
			return;
		}
		
		if(CartaDelDescarteAMonton(inputJugador) && baraja.HayDescarte() && montones.SePuedeAnadirCarta(baraja.VerDescarte(), Character.getNumericValue(inputJugador.charAt(2)))) {
			montones.AnadirCarta(baraja.ObtenerDescarte(), Character.getNumericValue(inputJugador.charAt(2)));
			return;
		}
		
		if(CartaDelDescarteAPilar(inputJugador) && baraja.HayDescarte() && pilares.SePuedeAnadirCarta(baraja.VerDescarte())){
			pilares.AnadirCarta(baraja.ObtenerDescarte());
			return;
		}
		
		if(CartaDelMontonAlPilar(inputJugador) && pilares.SePuedeAnadirCarta(montones.VerPrimeraCartaDeUnMonton(Character.getNumericValue(inputJugador.charAt(0))))) {
			pilares.AnadirCarta(montones.ObtenerCartaDeUnMonton(Character.getNumericValue(inputJugador.charAt(0))));
			return;
		}
		
		if(MoverCartasEntreMontones(inputJugador)) {
			String[] informacion = inputJugador.split("-");
			
			int[] informacionInt = new int[]{ Integer.parseInt(informacion[0]),
											  Integer.parseInt(informacion[1]),
											  Integer.parseInt(informacion[2])};

			if(montones.SePuedeMoverCarta(informacionInt[0], informacionInt[1], informacionInt[2])) {
				montones.MoverCartas(informacionInt[0], informacionInt[1], informacionInt[2]);				
			}
			return;
		}
		
		System.out.println("Input o acción inválida");
	}

	private boolean NuevaCartaDelMazo(String input) {
		return input.matches("^c");
	}
	
	private boolean CartaDelDescarteAMonton(String input) {
		return input.matches("^d-[1-7]");
	}
	
	private boolean CartaDelDescarteAPilar(String input) {
		return input.matches("^d-p");
	}
	
	private boolean CartaDelMontonAlPilar(String input) {
		return input.matches("^[1-7]-p");
	}

	private boolean MoverCartasEntreMontones(String input) {
		return input.matches("^[1-7]-[1-9][0-9]?-[1-7]");
	}

	public boolean PuedeAccionar(Baraja baraja, Montones montones, Pilares pilares) {
		// TODO
		return false;
	}
}