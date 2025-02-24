public class Intervalo_PM {

	private double puntoMedio;

	private double longitud;

	public double getInferior(){
		return puntoMedio - longitud / 2;
	}

	public double getSuperior(){
		return puntoMedio + longitud / 2;
	}

	public Intervalo_PM(double inferior, double superior){
		longitud = superior - inferior;
		puntoMedio = inferior + longitud / 2;
	}

	public Intervalo_PM(double superior){
		longitud = superior;
		puntoMedio = longitud / 2;
	}

	public Intervalo_PM(Intervalo_PM intervalo){
		longitud = intervalo.longitud;
		puntoMedio = intervalo.puntoMedio;
	}

	public Intervalo_PM(){
		this(0, 0);
	}

	public Intervalo_PM clonar(){
		return new Intervalo_PM(this);
	}

	public double longitud(){
		return longitud;
	}

	public double puntoMedio(){
		return puntoMedio;
	}

	public void desplazar(double desplazamiento){
		puntoMedio += desplazamiento;
	}

	public Intervalo_PM desplazado(double desplazamiento){
		Intervalo_PM intervalo = this.clonar();
		intervalo.desplazar(desplazamiento);
		return intervalo;
	}

	public boolean incluye(double punto){
		return getInferior() <= punto && punto <= getSuperior();
	}

	public boolean incluye(Intervalo_PM intervalo){
		return getInferior() <= intervalo.getInferior() && intervalo.getSuperior() <= getSuperior();
	}

	public boolean igual(Intervalo_PM intervalo){
		return puntoMedio == intervalo.puntoMedio && longitud == intervalo.longitud;
	}

	public Intervalo_PM interseccion(Intervalo_PM intervalo){
		assert intersecta(intervalo) : "No hay intersección";
		
		if(incluye(intervalo)) {
			return intervalo;
		}
		
		if(incluye(intervalo.getInferior())) {
			return new Intervalo_PM(intervalo.getInferior(), getSuperior());
		}
		
		return new Intervalo_PM(getInferior(), intervalo.getSuperior());
	}

	public boolean intersecta(Intervalo_PM intervalo){
		return incluye(intervalo.getInferior()) || incluye(intervalo.getSuperior());
	}

	public void oponer(){
		puntoMedio *= -1;
	}

	public void doblar(){
		longitud *= 2;
	}

	public void recoger(){
		
	}

	public void mostrar(){
		System.out.println("El intervalo es: [" + getInferior() + ", " + getSuperior() + "]");
	}

	public Intervalo_PM[] trocear(int trozos){
		double incremento = longitud / trozos;
		
		Intervalo_PM[] intervalos = new Intervalo_PM[trozos];
		
		for(int i = 0; i < trozos; i++) {
			intervalos[i] = new Intervalo_PM(getInferior() + incremento*i, getInferior() + incremento*(i + 1));
		}
		
		return intervalos;
	}

	public static void main(String[] args) {
		Intervalo_PM intervalo = new Intervalo_PM(0, 10);
		
		Intervalo_PM[] intervaloTroceado = intervalo.trocear(7);
		
		for(int i = 0; i < intervaloTroceado.length; i++) {
			intervaloTroceado[i].mostrar();
		}
	}
}