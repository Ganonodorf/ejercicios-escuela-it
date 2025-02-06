
public class CartaDelDescarteAlMonton extends Accion {
	
	private Descarte descarte;
	private Monton monton;
	
	public CartaDelDescarteAlMonton(Descarte descarte, Monton monton) {
		super("Carta del descarte al montón: d-numMonton");
		this.descarte = descarte;
		this.monton = monton;
	}
	
	@Override
	public void Accionar() {
		assert descarte != null;
		assert monton != null;
		
		if(!monton.SePuedeAnadirCarta(descarte.VerCarta())) {
			System.out.println("No se puede añadir esa carta del descarte al montón.");
			return;
		}
		
		monton.AnadirCarta(descarte.CogerCarta());
	}
}
