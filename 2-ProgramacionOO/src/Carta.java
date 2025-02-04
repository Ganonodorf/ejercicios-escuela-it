
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
			return ObtenerNumeroString(numero) + ObtenerPaloString(palo);
		}
		return "▒▒▒";
	}

	private String ObtenerPaloString(int palo) {
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

	private String ObtenerNumeroString(int numero) {
		if(numero == 11) {
			return " J";
		}
		if(numero == 12) {
			return " Q";
		}
		if(numero == 13) {
			return " K";
		}
		return String.format("%2d", numero);
	}

	public boolean SonDelMismoColor(Carta carta) {
		return this.color == carta.color;
	}

	public boolean EsInmediatamenteInferior(Carta carta) {
		return this.numero + 1 == carta.numero;
	}
	
	public int getPalo() {
		return palo;
	}

	public int getNumero() {
		return numero;
	}
	
	public void Revelar(boolean estado) {
		this.estaRevelada = estado;
	}
	
	public static void main(String[] args) {
		Carta dosCorazones = new Carta(1, 2);
		Carta tresTreboles = new Carta(2, 3);
		
		dosCorazones.Revelar(true);
		tresTreboles.Revelar(true);
		
		System.out.println(dosCorazones.Mostrar() + tresTreboles.Mostrar());
		
		System.out.println(dosCorazones.EsInmediatamenteInferior(tresTreboles));

		System.out.println(dosCorazones.color + "   " + tresTreboles.color);
		
		System.out.println(dosCorazones.SonDelMismoColor(tresTreboles));
	}
}
