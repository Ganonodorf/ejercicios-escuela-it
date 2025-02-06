
public class MoverCartasEntreMontones extends Accion{
	
	private Monton montonOrigen;
	private int posicionCartaOrigen;
	private Monton montonDestino;
	
	public MoverCartasEntreMontones(Monton montonOrigen, int posicionCartaOrigen, Monton montonDestino) {
		super("Mover cartas entre montones: numMontonOrigen-posCartaOrigen-numMontonDestino");
		this.montonOrigen = montonOrigen;
		this.posicionCartaOrigen = posicionCartaOrigen;
		this.montonDestino = montonDestino;
	}
	
	public void Accionar() {
		if(posicionCartaOrigen >= montonOrigen.Tamano()) {
			System.out.println("El montón es más pequeño, la carta que intentas coger no existe.");
			return;
		}
		
		if(montonDestino.SePuedeAnadirCarta(montonOrigen.CogerCarta(posicionCartaOrigen))) {
			do {
				montonDestino.AnadirCarta(montonOrigen.CogerCarta());
				posicionCartaOrigen--;
			}while(posicionCartaOrigen < 1);
		}
	}
}
