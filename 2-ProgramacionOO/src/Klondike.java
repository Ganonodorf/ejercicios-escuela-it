public class Klondike {
	
	Jugador jugador;
	Baraja baraja;
	Descarte descarte;
	Pilar[] pilares;
	Monton[] montones;
	
	private final int NUMERO_PALOS = 4;
	
	private final int NUMERO_MONTONES = 7;
	
	public Klondike(){
		jugador = new Jugador();
		baraja = new Baraja();
		descarte = new Descarte();
		pilares = new Pilar[NUMERO_PALOS];
		for(int i = 0; i < NUMERO_PALOS; i++) {
			pilares[i] = new Pilar(i + 1);
		}
		montones = new Monton[NUMERO_MONTONES];
		for(int i = 0; i < NUMERO_MONTONES; i++) {
			montones[i] = new Monton(i + 1, baraja);
		}
	}
	
	public void Jugar() {
		String inputJugador;
		
		baraja.Barajar();
		
		MostrarReglas();
		
		do {
			this.MostrarInformacionDeJuego();
			
			inputJugador = jugador.RecogerInput();
			
			this.Accionar(inputJugador);
		}
		while(accion.PuedeAccionar(baraja, montones));
		
		if(this.HaGanadoElJugador()) {
			jugador.CantarVictoria();
		}
		else {
			System.out.println("Perdiste");
		}
	}
	
	private boolean HaGanadoElJugador() {
		boolean estanLosPilaresCompletos = true;
		
		int i = 0;
		
		while(estanLosPilaresCompletos == true && i < pilares.length) {
			estanLosPilaresCompletos = pilares[i].EstaCompleto();
		}
		
		return estanLosPilaresCompletos;
	}

	private void Accionar(String inputJugador) {
		if(inputJugador.length() == 1){
			accion.CartaDeLaBarajaAlDescarte(baraja, descarte);
			return;
		}
		
		if(inputJugador.contains("d-p")) {
			int pilarDestino = -1;
			for(int i = 0; i < NUMERO_PALOS; i++) {
				if(!pilares[i].SePuedeAnadirCarta(descarte.VerCarta())) {
					pilarDestino = i;
				}
			}
			
			if(pilarDestino != -1) {
				accion.CartaDelDescarteAlPilar(descarte, pilares[pilarDestino]);
				return;
			}
			
			System.out.println("Esa carta no se puede añadir al pilar");
			return;
		}

		if(inputJugador.contains("d-")) {
			accion.CartaDelDescarteAlMonton(descarte, montones[Integer.parseInt(inputJugador.split("-")[2])]);
			return;
		}

		if(inputJugador.contains("-p")) {
			int pilarDestino = -1;
			int montonOrigen = Integer.parseInt(inputJugador.split("-")[0]);
			do {
				pilarDestino++;
			}while(pilarDestino < NUMERO_PALOS && !pilares[pilarDestino].SePuedeAnadirCarta(montones[montonOrigen].VerCarta()));

			accion.CartaDelMontonAlPilar(montones[montonOrigen], pilares[pilarDestino]);
			return;
		}
		
		int montonOrigen = Integer.parseInt(inputJugador.split("-")[0]);
		int numeroCarta = Integer.parseInt(inputJugador.split("-")[1]);
		int montonDestino = Integer.parseInt(inputJugador.split("-")[2]);
		
		accion.MoverCartasEntreMontones(montones[montonOrigen], numeroCarta, montones[montonDestino]);
	}

	private void MostrarInformacionDeJuego() {
		System.out.println("\n\n");
		baraja.Mostrar();
		descarte.Mostrar();
		System.out.println("       ");
		for(Pilar pilar: pilares) {
			pilar.Mostrar();
			System.out.print(" ");
		}
		System.out.println("\n\n");

		for(Monton monton: montones) {
			monton.Mostrar();
			System.out.print("\n");
		}
	}


	private void MostrarReglas() {
		System.out.println("Nueva carta del mazo: c \n");
		System.out.println("Carta del descarte a un pilar: d-p \n");
		System.out.println("Carta del descarte a un montón: d-número montón \n");
		System.out.println("Carta de un montón a un pilar: número montón-p \n");
		System.out.println("Mover carta: número montón-posición carta desde abajo-nuevo número montón \n");
	}

	public static void main(String[] args) {
		Klondike klondike = new Klondike();
		klondike.Jugar();
	}
}