
public class Carta {
	
	private int palo;
	
	private int numero;
	
	public Carta(int palo, int numero) {
		this.palo = palo;
		this.numero = numero;
		
	}

	public String Mostrar() {
		ObtenerNumero(numero);
		ObtenerPalo(palo);
		return null;
	}

	private String ObtenerPalo(int palo) {
		if(palo == 1) {
			return "♥";
		}
		if(palo == 1) {
			return "♦";
		}
		if(palo == 1) {
			return "♣";
		}
		if(palo == 1) {
			return "♠";
		}
		return " ";
	}

	private String ObtenerNumero(int numero) {
		return String.format("%02d", numero);
	}

	private boolean TieneDiferenteColor(Carta primeraCartaMonton) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean EsInmediatamenteInferior(Carta primeraCartaMonton) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean SePuedeColocarDebajo(Carta primeraCartaMonton) {
		// TODO Auto-generated method stub
		return false;
	}

}
