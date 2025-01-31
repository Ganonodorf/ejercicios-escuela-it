import java.util.HashMap;

class Fecha{

	private int dia;
	private int mes;
	private int ano;
	
	private static final int[] DIAS_MESES = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	private static final char[] INICIALES_DIAS = new char[] {'s', 'd', 'l', 'm', 'x', 'j', 'v'};
	
	private HashMap<Estacion, Fecha> estaciones = new HashMap<Estacion, Fecha>(){{
		put(Estacion.PRIMAVERA, new Fecha(20, 3, 1970));
		put(Estacion.VERANO, new Fecha(21, 6, 1970));
		put(Estacion.OTONO, new Fecha(22, 9, 1970));
		put(Estacion.INVIERNO, new Fecha(21, 12, 1970));
	}};

	public Fecha(){
		dia = 1;
		mes = 1;
		ano = 1;
	};

	public Fecha(int dia, int mes, int ano){
		set(dia, mes, ano);
	};

	public Fecha(Fecha fecha){
		this(fecha.dia, fecha.mes, fecha.ano);
	};

	public Fecha(String fecha){
		this(Integer.parseInt(fecha.substring(0, 1)),
				Integer.parseInt(fecha.substring(3, 4)),
				Integer.parseInt(fecha.substring(5, 8)));
	};

	public Fecha(int timeStamp){
		//int anos = timeStamp/1000/60/60/24/365;
	};
	
	private void set(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	
	public void set(Fecha fecha) {
		set(fecha.dia, fecha.mes, fecha.ano);
	}

	public int getDia(){
		return dia;
	}

	public int getMes(){
		return mes;
	}
	
	public int getAno(){
		return ano;
	}

	public Fecha clone(){
		return new Fecha(dia, mes, ano);
	}

	public void mostrar(){
		System.out.println("La fecha es: " + dia + "/" + mes + "/" + ano);
	}

	public String toStringCAS(){
		return "" + dia + "/" + mes + "/" + ano;
	}

	public String toStringUSA(){
		return "" + mes + "/" + dia + "/" + ano;
	}
	
	public int toTimeStamp() {
		int diasTotales = this.diaAno();
		
		diasTotales += (ano - 1)*365;
		
		for(int i = 1; i < ano - 1; i++) {
			if(Fecha.bisiesto(i)) {
				diasTotales += 1;
			}
		}
		
		return diasTotales;
	}

	public boolean igual(Fecha fecha){
		return this.ano == fecha.ano && this.dia == fecha.dia && this.mes == fecha.mes;
	}

	public boolean anterior(Fecha fecha){
		return this.toTimeStamp() < fecha.toTimeStamp();
	}

	public boolean posterior(Fecha fecha){
		return this.toTimeStamp() > fecha.toTimeStamp();
	}

	public int diferenciaDias(Fecha fecha){
		return fecha.toTimeStamp() - this.toTimeStamp();
	}
	
	public boolean bisiesto(){
		return bisiesto(ano);
	}
	
	public static boolean bisiesto(int ano) {
		return ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0;
	}
	
	public int diaAno() {
		int diasTotales = dia;
		
		for(int i = 0; i < mes; i++) {
			diasTotales += DIAS_MESES[i-1];
		}
		
		if(this.bisiesto() && mes > 2) {
			diasTotales += 1;
		}
		
		return diasTotales;
	}

	public static int diasAno(int ano){
		if(bisiesto(ano)) {
			return 366;
		}
		
		return 365;
	}
	
	private void incrementar() {
		dia += 1;
		if(dia > DIAS_MESES[mes-1]) {
			dia = 1;
			mes += 1;
			if(mes > 12) {
				mes = 1;
				ano += 1;
			}
		}
	}

	public void incrementar(int dias){
		for(int i=0; i<dias; i++) {
			this.incrementar();
		}
	}

	public int diasAnoRestantes(){
		float diasTotales = dia;
		
		for(int i = 0; i < mes; i++) {
			diasTotales += DIAS_MESES[i - 1];
		}
		
		if(this.bisiesto() && mes > 2) {
			diasTotales++;
		}
		
		return (int)(Fecha.diasAno(ano) - diasTotales);
	}
	
	public char diaSemana() {
		return INICIALES_DIAS[(this.toTimeStamp()-1) % 7];
	}
	
	public int numeroSemana() {
		return (this.toTimeStamp() - new Fecha(1,1,ano).toTimeStamp())/7+1;
	}

	public void sumarMes(int mes){
		this.mes += mes;
		
		while(mes > 12) {
			mes -= 12;
			ano += 1;
		}
	}
	
	public void sumarAno(int ano){
		this.ano += ano;
	}

	public Estacion estacion(){
		Fecha comparacion = new Fecha(this.dia, this.mes, 1970);
		if(comparacion.posterior(estaciones.get(Estacion.INVIERNO))) {
			return Estacion.INVIERNO;
		}
		
		if(comparacion.posterior(estaciones.get(Estacion.OTONO))) {
			return Estacion.OTONO;
		}
		
		if(comparacion.posterior(estaciones.get(Estacion.VERANO))) {
			return Estacion.VERANO;
		}
		
		if(comparacion.posterior(estaciones.get(Estacion.PRIMAVERA))) {
			return Estacion.PRIMAVERA;
		}
		
		return Estacion.PRIMAVERA;
	}
	
	private enum Estacion {
		PRIMAVERA,
		VERANO,
		OTONO,
		INVIERNO
	}
	
	public static void main(String[] args) {
		
	}
}