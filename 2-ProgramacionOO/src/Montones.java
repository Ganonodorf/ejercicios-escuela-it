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

	public void Mostrar() {
		int cartasEnColumnaMasLarga = ObtenerCartasEnColumnaMasLarga();
		
		String cartasEnColumnas = "";
		
		for(int i = 0; i < cartasEnColumnaMasLarga; i++) {
			for(int j = 0; j < NUMERO_COLUMNAS; j++) {
				if(montonesCartas.get(j).size() > i){
					cartasEnColumnas += montonesCartas.get(j).get(i).Mostrar();
				}
				else {
					cartasEnColumnas += "   ";
				}
				cartasEnColumnas += "  ";
			}
			cartasEnColumnas += "/n";
		}
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
		Carta primeraCartaMonton = montonesCartas.get(numeroMonton - 1).getFirst();
		
		if(!carta.SonDelMismoColor(primeraCartaMonton) && carta.EsInmediatamenteInferior(primeraCartaMonton)) {
			return true;
		}
		
		return false;
	}

	public void AnadirCarta(Carta carta, int numeroMonton) {
		Carta primeraCartaMonton = montonesCartas.get(numeroMonton - 1).getFirst();
		
		montonesCartas.get(numeroMonton - 1).add(carta);
	}

	public boolean SePuedeMoverCarta(int montonOrigen, int posicionCarta, int montonDestino) {
		Carta cartaSeleccionada = montonesCartas.get(montonOrigen - 1).get(posicionCarta - 1);
		Carta cartaDestino = montonesCartas.get(montonDestino - 1).getFirst();
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
	}

	public void Repartir(Baraja baraja) {
		for(int i = 0; i < NUMERO_COLUMNAS; i++) {
			for(int j = 0; j <= i ; j++) {
				montonesCartas.get(i).add(baraja.ObtenerPrimeraCarta());
			}
		}
	}

	public Carta VerPrimeraCartaDeUnMonton(int numeroMonton) {
		return montonesCartas.get(numeroMonton - 1).getFirst();
	}

	public Carta ObtenerPrimeraCartaDeUnMonton(int numeroMonton) {
		Carta cartaADevolver = VerPrimeraCartaDeUnMonton(numeroMonton);
		EliminarPrimeraCartaDeUnMonton(numeroMonton);
		return cartaADevolver;
	}

	private void EliminarPrimeraCartaDeUnMonton(int numeroMonton) {
		montonesCartas.get(numeroMonton - 1).remove(0);
	}

}
