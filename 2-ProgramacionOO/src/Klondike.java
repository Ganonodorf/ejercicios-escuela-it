public class Klondike {
	
	Jugador jugador;
	Baraja baraja;
	Pilares pilares;
	Montones montones;
	Accion accion;
	
	public Klondike(){
		jugador = new Jugador();
		baraja = new Baraja();
		pilares = new Pilares();
		montones = new Montones();
		accion = new Accion();
	}
	
	public void Jugar() {
		String inputJugador;
		
		baraja.Barajar();
		
		montones.Repartir(baraja);
		
		do {
			this.MostrarInformacionDeJuego();
			
			inputJugador = jugador.RecogerInput();
			
			accion.Accionar(inputJugador, baraja, montones, pilares);
		}
		while(accion.PuedeAccionar(baraja, montones, pilares) && !montones.EstanVacios());
		
		if(montones.EstanVacios()) {
			jugador.CantarVictoria();
		}
		
		else {
			System.out.println("Perdiste");
		}
	}
	
	private void MostrarInformacionDeJuego() {
		MostrarReglas();
		
		baraja.Mostrar();
		
		montones.Mostrar();
	}


	private void MostrarReglas() {
		System.out.println("Nueva carta del mazo: c \n");
		System.out.println("Carta del descarte a un montón: d-número montón \n");
		System.out.println("Carta del descarte a un pilar: d-p \n");
		System.out.println("Carta de un montón a un pilar: número montón-p \n");
		System.out.println("Mover carta: número montón-posición carta desde abajo-nuevo número montón \n");
		System.out.println("Salir: q \n\n");
	}

	public static void main(String[] args) {
		Klondike klondike = new Klondike();
		klondike.Jugar();
	}
}