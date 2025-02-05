import java.util.ArrayList;

public class Pilares {
	
	private ArrayList<ArrayList<Carta>> pilaresCartas;
	
	private int NUMERO_MONTONES = 4;
	
	public Pilares() {
		pilaresCartas = new ArrayList<ArrayList<Carta>>();
		
		for(int i = 0; i < NUMERO_MONTONES; i++) {
			pilaresCartas.add(new ArrayList<Carta>());
		}
	}
	
	public boolean SePuedeAnadirCarta(Carta carta) {
		if(pilaresCartas.get(carta.getPalo() - 1).isEmpty() && carta.getNumero() == 1) {
			return true;
		}
		if(pilaresCartas.get(carta.getPalo() - 1).isEmpty() && carta.getNumero() != 1) {
			return false;
		}
		Carta cartaPilar = pilaresCartas.get(carta.getPalo() - 1).getFirst();
		return carta.SonDelMismoColor(cartaPilar) && cartaPilar.EsInmediatamenteInferior(carta);
	}

	public void AnadirCarta(Carta carta) {
		pilaresCartas.get(carta.getPalo() - 1).addFirst(carta);
	}
	
	public String Mostrar() {
		String cartasEnPilares = "";
		
		for(int i = 0; i < NUMERO_MONTONES; i++) {
			if(pilaresCartas.get(i).isEmpty()) {
				cartasEnPilares += "___";
			}
			else {
				cartasEnPilares += pilaresCartas.get(i).getFirst().Mostrar();
			}
			
			cartasEnPilares += "  ";
		}
		
		return cartasEnPilares;
	}
}
