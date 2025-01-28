class Intervalo {

	private double inferior;

	private double superior;

	public double getInferior(){
		return inferior;
	}

	public double getSuperior(){
		return superior;
	}

	public Intervalo(double inferior, double superior){
		assert inferior <= superior;
		this.inferior = inferior;
		this.superior = superior;
	}

	public Intervalo(double superior){
		this(0, superior);
	}

	public Intervalo(Intervalo intervalo){
		this(intervalo.inferior, intervalo.superior);
	}

	public Intervalo(){
		this(0, 0);
	}

	public Intervalo clonar(){
		return new Intervalo(this);
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
		Intervalo intervalo = this.clonar();
		intervalo.desplazar(desplazamiento);
		return intervalo;
	}

	public boolean incluye(double punto){
		return inferior <= punto && punto <= superior;
	}

	public boolean incluye(Intervalo intervalo){
		assert intervalo != null;
		return this.incluye(intervalo.inferior) && this.incluye(intervalo.superior);
	}

	public boolean igual(Intervalo intervalo){
		assert intervalo != null;
		return inferior == intervalo.inferior && superior == intervalo.superior;
	}

	public Intervalo interseccion(Intervalo intervalo){
		assert intervalo != null;
		assert intersecta(intervalo) : "No hay intersección";
		
		if(incluye(intervalo)) {
			return intervalo.clonar();
		}
		
		if(intervalo.incluye(this)) {
			return clonar();
		}
		
		if(incluye(intervalo.inferior)) {
			return new Intervalo(intervalo.inferior, superior);
		}
		
		return new Intervalo(inferior, intervalo.superior);
	}

	public boolean intersecta(Intervalo intervalo){
		assert intervalo != null;
		return incluye(intervalo.inferior) || incluye(intervalo.superior) || intervalo.incluye(this);
	}

	public void oponer(){
		double superiorInicial = superior;
		superior = inferior * -1;
		inferior = superiorInicial * -1;
	}

	public void doblar(){
		double incremento = longitud() / 2;
		superior = superior + incremento;
		inferior = inferior - incremento;
	}

	public void recoger(){
		GestorIO gestorIO = new GestorIO();
		gestorIO.out("¿Inferior?");
		inferior = gestorIO.inDouble();
		gestorIO.out("¿Superior?");
		superior = gestorIO.inDouble();
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
		Intervalo intervalo = new Intervalo();
		
		intervalo.recoger();
		
		Intervalo[] intervaloTroceado = intervalo.trocear(6);
		
		for(int i = 0; i < intervaloTroceado.length; i++) {
			intervaloTroceado[i].mostrar();
		}
	}
}