public abstract class Accion {
	
	private String titulo;
	
	private String inputMatch;
	
	public Accion(String titulo, String inputMatch) {
		this.titulo = titulo;
		this.inputMatch = inputMatch;
	}
	
	abstract void Accionar();
	
	public void Mostrar() {
		System.out.print(titulo);
	}
	
	public boolean Coincide(String input) {
		return input.matches(inputMatch);
	}
}