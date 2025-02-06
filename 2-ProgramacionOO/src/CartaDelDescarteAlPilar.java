
public class CartaDelDescarteAlPilar extends Accion{

	private Descarte descarte;
	private Pilar pilar;
	
	public CartaDelDescarteAlPilar(Descarte descarte, Pilar pilar) {
		super("Carta del descarte al pilar: d-p");
		this.descarte = descarte;
		this.pilar = pilar;
	}
	
	@Override
	public void Accionar() {
		if(!pilar.SePuedeAnadirCarta(descarte.VerCarta())) {
			System.out.println("No se puede añadir esa carta del descarte al pilar.");
			return;
		}
		
		pilar.AnadirCarta(descarte.CogerCarta());
	}
}
