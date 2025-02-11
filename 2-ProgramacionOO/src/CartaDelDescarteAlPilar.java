
public class CartaDelDescarteAlPilar extends Accion{

	private Descarte descarte;
	private Pilar[] pilares;
	
	public CartaDelDescarteAlPilar(Descarte descarte, Pilar[] pilares) {
		super("Carta del descarte al pilar: d-p", "^d-p");
		this.descarte = descarte;
		this.pilares = pilares;
	}
	
	@Override
	public void Accionar() {
		boolean error = SePuedeAnadirAlPilar();
		
		if(error) {
			System.out.println("No se puede añadir esa carta del descarte al pilar.");
			return;
		}
		
		AnadirAlPilar();
	}

	private void AnadirAlPilar() {
		for(int i = 0; i < pilares.length; i++) {
			if(pilares[i].SePuedeAnadirCarta(descarte.VerCarta())) {
				pilares[i].AnadirCarta(descarte.CogerCarta());
			}
		}
	}

	private boolean SePuedeAnadirAlPilar() {
		for(int i = 0; i < pilares.length; i++) {
			if(pilares[i].SePuedeAnadirCarta(descarte.VerCarta())) {
				return true;
			}
		}
		return false;
	}
}
