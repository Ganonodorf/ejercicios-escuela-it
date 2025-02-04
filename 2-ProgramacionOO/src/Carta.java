
public class Carta {
	
	private int palo;
	
	private int numero;
	
	private boolean estaRevelada;
	
	private int color;
	
	public Carta(int palo, int numero) {
		this.palo = palo;
		this.numero = numero;
		this.estaRevelada = false;
		this.color = palo % 2;
	}

	public String Mostrar() {
		if(estaRevelada) {
			return ObtenerNumero(numero) + ObtenerPalo(palo);
		}
		return "▒▒▒";
	}

	private String ObtenerPalo(int palo) {
		if(palo == 1) {
			return "♥";
		}
		if(palo == 2) {
			return "♣";
		}
		if(palo == 3) {
			return "♦";
		}
		if(palo == 4) {
			return "♠";
		}
		return " ";
	}

	private String ObtenerNumero(int numero) {
		return String.format("%02d", numero);
	}

	public boolean SonDelMismoColor(Carta carta) {
		return this.color != carta.color;
	}

	public boolean EsInmediatamenteInferior(Carta carta) {
		return this.numero - 1 == carta.numero;
	}
}
