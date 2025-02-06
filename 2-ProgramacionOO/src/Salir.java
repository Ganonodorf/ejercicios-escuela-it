
public class Salir extends Accion{
	
	private boolean accionado = false;
	
	public Salir() {
		super("Salir: s");
	}
	
	@Override
	public void Accionar() {
		accionado = true;
	}
	
	public boolean HaSidoAccionado() {
		return accionado;
	}
}
