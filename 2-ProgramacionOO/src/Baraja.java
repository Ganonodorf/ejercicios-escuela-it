public class Baraja {
	
	private Carta[] cartas;
	
	public Baraja() {
		cartas = new Carta[52];
		
		int k = 0;
		
		for(int i = 1; i < 5; i++) {
			for(int j = 1; j < 14; j++) {
				cartas[k] = new Carta(i, j);
				k++;
			}
		}
	}

	public void Mostrar() {
		// TODO Auto-generated method stub
		
	}

	public void NuevaCarta() {
		// TODO Auto-generated method stub
		
	}

	public Object ObtenerDescarte() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean HayCartasEnElMazo() {
		// TODO Auto-generated method stub
		return false;
	}

}
