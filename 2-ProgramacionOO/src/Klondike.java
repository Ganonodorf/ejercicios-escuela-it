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
		
		baraja.Barajar();
		
		pilares = new Pilar[NUMERO_PALOS];
		for(int i = 0; i < NUMERO_PALOS; i++) {
			pilares[i] = new Pilar(i + 1);
		}
		
		montones = new Monton[NUMERO_MONTONES];
		for(int i = 0; i < NUMERO_MONTONES; i++) {
			montones[i] = new Monton(i + 1, baraja);
		}
		
		IntroducirAcciones(jugador);
	}
	
	private void IntroducirAcciones(Jugador jugador) {
		jugador.AnadirAccion(new CartaDeLaBarajaAlDescarte(baraja, descarte));
		jugador.AnadirAccion(new CartaDelDescarteAlPilar(descarte, pilares));
		jugador.AnadirAccion(new CartaDelDescarteAlMonton(descarte, montones));
		jugador.AnadirAccion(new CartaDelMontonAlPilar(montones, pilares));
		jugador.AnadirAccion(new MoverCartasEntreMontones(montones));
		jugador.CerrarAcciones();
	}

	public void Jugar() {
		Accion accionJugador;
		
		jugador.MostrarAcciones();
		
		do {
			this.MostrarInformacionDeJuego();
			
			accionJugador = jugador.RecogerAccion();
			
			accionJugador.Accionar();
		}
		while(!jugador.SalirPresionado());
		
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

	public static void main(String[] args) {
		Klondike klondike = new Klondike();
		klondike.Jugar();
	}
}