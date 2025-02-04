import java.util.ArrayList;

public class Montones {

	private ArrayList<ArrayList<Carta>> montonesCartas;
	
	private final int NUMERO_COLUMNAS = 7;
	
	public Montones() {
		montonesCartas = new ArrayList<ArrayList<Carta>>();
		
		for(int i = 0; i < NUMERO_COLUMNAS; i++) {
			montonesCartas.add(new ArrayList<Carta>());
		}
	}

	public boolean EstanVacios() {
		for(int i = 0; i < NUMERO_COLUMNAS; i++) {
			if(!montonesCartas.get(i).isEmpty()){
				return false;
			}
		}
		return true;
	}

	public String Mostrar() {
		int cartasEnColumnaMasLarga = ObtenerCartasEnColumnaMasLarga();
		
		String cartasEnColumnas = "";
		
		for(int i = 0; i < cartasEnColumnaMasLarga; i++) {
			for(int j = 0; j < NUMERO_COLUMNAS; j++) {
				if(i < montonesCartas.get(j).size()){
					cartasEnColumnas += montonesCartas.get(j).get(montonesCartas.get(j).size() - i - 1).Mostrar();
				}
				else {
					cartasEnColumnas += "   ";
				}
				cartasEnColumnas += "  ";
			}
			cartasEnColumnas += "\n";
		}
		
		return cartasEnColumnas;
	}

	private int ObtenerCartasEnColumnaMasLarga() {
		int cartasEnColumnaMasLarga = 0;
		
		for(int i = 0; i < NUMERO_COLUMNAS; i++) {
			if(montonesCartas.get(i).size() > cartasEnColumnaMasLarga) {
				cartasEnColumnaMasLarga = montonesCartas.get(i).size();
			}
		}
		
		return cartasEnColumnaMasLarga;
	}

	public boolean SePuedeAnadirCarta(Carta carta, int numeroMonton) {
		if(EstaElMontonVacio(numeroMonton) && carta.getNumero() == 13) {
			return true;
		}
		
		if(!EstaElMontonVacio(numeroMonton) && 
				!carta.SonDelMismoColor(PrimeraCartaMonton(numeroMonton)) && 
				carta.EsInmediatamenteInferior(PrimeraCartaMonton(numeroMonton))) {
			return true;
		}
		
		return false;
	}
	
	public boolean EstaElMontonVacio(int numeroMonton) {
		return montonesCartas.get(numeroMonton - 1).isEmpty();
	}
	
	private Carta PrimeraCartaMonton(int numeroMonton) {
		return montonesCartas.get(numeroMonton - 1).getFirst();
	}

	public void AnadirCarta(Carta carta, int numeroMonton) {
		montonesCartas.get(numeroMonton - 1).addFirst(carta);
	}

	public boolean SePuedeMoverCarta(int montonOrigen, int posicionCarta, int montonDestino) {
		Carta cartaSeleccionada = montonesCartas.get(montonOrigen - 1).get(posicionCarta - 1);
		if(cartaSeleccionada.getNumero() == 13 && EstaElMontonVacio(montonDestino)) {
			return true;
		}
		if(cartaSeleccionada.getNumero() != 13 && EstaElMontonVacio(montonDestino)) {
			return false;
		}
		Carta cartaDestino = PrimeraCartaMonton(montonDestino);
		if(cartaSeleccionada != null && cartaDestino != null &&
				!cartaSeleccionada.SonDelMismoColor(cartaDestino) && cartaSeleccionada.EsInmediatamenteInferior(cartaDestino)){
			return true;
		}
		return false;
	}

	public void MoverCartas(int montonOrigen, int posicionCarta, int montonDestino) {
		for(int i = posicionCarta - 1; i >= 0; i--) {
			montonesCartas.get(montonDestino - 1).addFirst(montonesCartas.get(montonOrigen - 1).get(i));
			montonesCartas.get(montonOrigen - 1).remove(i);
		}
		if(!EstaElMontonVacio(montonOrigen)) {
			PrimeraCartaMonton(montonOrigen).Revelar(true);
		}
	}

	public void Repartir(Baraja baraja) {
		for(int i = 0; i < NUMERO_COLUMNAS; i++) {
			for(int j = 0; j <= i ; j++) {
				montonesCartas.get(i).add(baraja.ObtenerPrimeraCarta());
				if(j == i) {
					montonesCartas.get(i).get(0).Revelar(true);
				}
			}
		}
	}

	public Carta VerPrimeraCartaDeUnMonton(int numeroMonton) {
		return PrimeraCartaMonton(numeroMonton);
	}

	public Carta ObtenerPrimeraCartaDeUnMonton(int numeroMonton) {
		Carta cartaADevolver = VerPrimeraCartaDeUnMonton(numeroMonton);
		EliminarPrimeraCartaDeUnMonton(numeroMonton);
		if(!EstaElMontonVacio(numeroMonton)) {
			VerPrimeraCartaDeUnMonton(numeroMonton).Revelar(true);
		}
		return cartaADevolver;
	}

	private void EliminarPrimeraCartaDeUnMonton(int numeroMonton) {
		montonesCartas.get(numeroMonton - 1).remove(0);
	}
	
	public static void main(String[] args) {
		Baraja baraja = new Baraja();
		Montones montones = new Montones();
		
		montones.Repartir(baraja);
		
		System.out.println(montones.Mostrar());

		Carta cartaSeleccionada = montones.VerPrimeraCartaDeUnMonton(2);

		Carta cartaDestino = montones.VerPrimeraCartaDeUnMonton(6);
		
		System.out.println(cartaSeleccionada.Mostrar());

		System.out.println(cartaDestino.Mostrar());
		
		System.out.println(montones.SePuedeMoverCarta(2, 1, 6));
		
		montones.MoverCartas(2, 1, 6);
		
		System.out.println(montones.Mostrar());
		
		montones.MoverCartas(6, 2, 3);
		
		System.out.println(montones.Mostrar());
	}
}
