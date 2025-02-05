public class Klondike {
	
	Jugador jugador;
	Baraja baraja;
	Pilar pilares;
	Montones montones;
	Accion accion;
	
	public Klondike(){
		jugador = new Jugador();
		baraja = new Baraja();
		pilares = new Pilar();
		montones = new Montones();
		accion = new Accion();
	}
	
	public void Jugar() {
		String inputJugador;
		
		baraja.Barajar();
		
		montones.Repartir(baraja);
		
		MostrarReglas();
		
		do {
			this.MostrarInformacionDeJuego();
			
			inputJugador = jugador.RecogerInput();
			
			accion.Accionar(inputJugador, baraja, montones, pilares);
		}
		while(accion.PuedeAccionar(baraja, montones, pilares) && (!montones.EstanVacios() || baraja.HayCartasEnLaBaraja()));
		
		if(montones.EstanVacios() && !baraja.HayCartasEnLaBaraja()) {
			jugador.CantarVictoria();
		}
		
		else {
			System.out.println("Perdiste");
		}
	}
	
	private void MostrarInformacionDeJuego() {
		System.out.println("\n\n" + baraja.Mostrar() + "       " + pilares.Mostrar() + "\n\n");
		
		System.out.println(montones.Mostrar());
	}


	private void MostrarReglas() {
		System.out.println("Nueva carta del mazo: c \n");
		System.out.println("Carta del descarte a un montón: d-número montón \n");
		System.out.println("Carta del descarte a un pilar: d-p \n");
		System.out.println("Carta de un montón a un pilar: número montón-p \n");
		System.out.println("Mover carta: número montón-posición carta desde abajo-nuevo número montón \n");
	}

	public static void main(String[] args) {
		Klondike klondike = new Klondike();
		klondike.Jugar();
	}
}