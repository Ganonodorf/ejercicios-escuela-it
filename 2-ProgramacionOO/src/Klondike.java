public class Klondike {
	
	Jugador jugador;
	Baraja baraja;
	Pilares pilares;
	Montones montones;
	
	public Klondike(){
		jugador = new Jugador();
		baraja = new Baraja();
		pilares = new Pilares();
		montones = new Montones(baraja);
	}
	
	public void Jugar() {
		do {
			this.Mostrar();
			
			jugador.Accionar(baraja, montones);
		}
		while(jugador.PuedeAccionar() && !montones.EstanVacios());
		
		if(montones.EstanVacios()) {
			jugador.CantarVictoria();
		}
		else {
			System.out.println("Perdiste");
		}
	}
	
	private void Mostrar() {
		montones.Mostrar();
		
		baraja.Mostrar();
	}

	public static void main(String[] args) {
		
	}
	
}