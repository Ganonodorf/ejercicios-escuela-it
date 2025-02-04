import java.util.ArrayList;

public class Pilares {
	
	private ArrayList<ArrayList<Carta>> PilaresCartas;
	
	private int NUMERO_MONTONES = 4;
	
	public Pilares() {
		PilaresCartas = new ArrayList<ArrayList<Carta>>();
		
		for(int i = 0; i < NUMERO_MONTONES; i++) {
			PilaresCartas.add(new ArrayList<Carta>());
		}
	}
	
	public boolean SePuedeAnadirCarta(Carta carta) {
		Carta cartaPilar = PilaresCartas.get(carta.getPalo() - 1).getFirst();
		return carta.SonDelMismoColor(cartaPilar) && cartaPilar.EsInmediatamenteInferior(carta);
	}

	public void AnadirCarta(Carta carta) {
		PilaresCartas.get(carta.getPalo() - 1).addFirst(carta);
	}
	
	public String Mostrar() {
		String cartasEnPilares = "";
		
		for(int i = 0; i < NUMERO_MONTONES; i++) {
			if(PilaresCartas.get(i).isEmpty()) {
				cartasEnPilares += "___";
			}
			else {
				cartasEnPilares += PilaresCartas.get(i).getFirst().Mostrar();
			}
			
			cartasEnPilares += "  ";
		}
		
		return cartasEnPilares;
	}
}
