class Intervalo {

	private double inferior;

	private double superior;

	public double getInferior(){
		return inferior;
	}

	public double getSuperior(){
		return superior;
	}

	public Intervalo(double _inferior, double _superior){
		inferior = _inferior;
		superior = _superior;
	}

	public Intervalo(double _superior){
		inferior = 0;
		superior = _superior;
	}

	public Intervalo(Intervalo intervalo){
		inferior = intervalo.getInferior();
		superior = intervalo.getSuperior();
	}

	public Intervalo(){
		inferior = 0;
		superior = 0;
	}

	public Intervalo clonar(){
		return new Intervalo(inferior, superior);
	}

	public double longitud (){
		return superior - inferior;
	}

	public double puntoMedio (){
		return longitud()/2;
	}

	public void desplazar(double desplazamiento){
		superior += desplazamiento;
		inferior += desplazamiento;
	}

	public Intervalo desplazado(double desplazamiento){
		return new Intervalo(inferior + desplazamiento, superior + desplazamiento);
	}

	public boolean incluye(double punto){
		return inferior <= punto && punto <= superior;
	}

	public boolean incluye(Intervalo intervalo){
		return inferior <= intervalo.getInferior() && intervalo.getSuperior() <= superior;
	}

	public boolean igual(Intervalo intervalo){
		return inferior == intervalo.getInferior() && superior == intervalo.getSuperior();
	}

	public Intervalo interseccion(Intervalo intervalo){
		assert intersecta(intervalo) : "No hay intersección";
		
		if(incluye(intervalo)) {
			return intervalo;
		}
		
		if(incluye(intervalo.getInferior())) {
			return new Intervalo(intervalo.getInferior(), superior);
		}
		
		return new Intervalo(inferior, intervalo.getSuperior());
	}

	public boolean intersecta(Intervalo intervalo){
		return incluye(intervalo.getInferior()) || incluye(intervalo.getSuperior());
	}

	public void oponer(){
		double x = superior;
		superior = inferior * -1;
		inferior = x * -1;
	}

	public void doblar(){
		double incremento = longitud() / 2;
		superior = superior + incremento;
		inferior = inferior - incremento;
	}

	public void recoger(){
		
	}

	public void mostrar(){
		System.out.println("El intervalo es: [" + inferior + ", " + superior + "]");
	}

	public Intervalo[] trocear(int trozos){
		double incremento = longitud() / trozos;
		
		Intervalo[] intervalos = new Intervalo[trozos];
		
		for(int i = 0; i < trozos; i++) {
			intervalos[i] = new Intervalo(inferior + incremento*i, inferior + incremento*(i + 1));
		}
		
		return intervalos;
	}

	public static void main(String[] args) {
		Intervalo intervalo = new Intervalo(0, 10);
		
		Intervalo[] intervaloTroceado = intervalo.trocear(6);
		
		for(int i = 0; i < intervaloTroceado.length; i++) {
			intervaloTroceado[i].mostrar();
		}
	}
}