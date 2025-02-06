
public class CartaDelMontonAlPilar extends Accion {
	
	private Monton monton;
	private Pilar pilar;
	
	public CartaDelMontonAlPilar(Monton monton, Pilar pilar) {
		super("Carta del monton al pilar: numMonton-p");
		this.monton = monton;
		this.pilar = pilar;
	}
	
	@Override
	public void Accionar() {
		if(!pilar.SePuedeAnadirCarta(monton.VerCarta())) {
			System.out.println("No se puede añadir esa carta del monton al pilar.");
			return;
		}
		
		pilar.AnadirCarta(monton.CogerCarta());
	}
}
