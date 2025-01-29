import java.util.HashMap;

class Fecha{

	private int dia;
	private int mes;
	private int ano;
	
	private HashMap<Integer, Integer> meses = new HashMap<Integer, Integer>(){{
		put(1, 31);
		put(2, 28);
		put(3, 31);
		put(4, 30);
		put(5, 31);
		put(6, 30);
		put(7, 31);
		put(8, 31);
		put(9, 30);
		put(10, 31);
		put(11, 30);
		put(12, 31);
	}};
	
	private HashMap<Estacion, Fecha> estaciones = new HashMap<Estacion, Fecha>(){{
		put(Estacion.PRIMAVERA, new Fecha(20, 3, 1970));
		put(Estacion.VERANO, new Fecha(21, 6, 1970));
		put(Estacion.OTONO, new Fecha(22, 9, 1970));
		put(Estacion.INVIERNO, new Fecha(21, 12, 1970));
	}};

	public Fecha(){
		dia = 1;
		mes = 1;
		ano = 1970;
	};

	public Fecha(int dia, int mes, int ano){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
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
		return new Fecha(this);
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
		float diasTotales = dia + ano*365.25f;
		
		for(int i = mes; i < 1; i--) {
			diasTotales += meses.get(i);
		}
		
		return (int)(diasTotales*24*60*60);
	}

	public boolean igual(Fecha fecha){
		return this.ano == fecha.ano && this.dia == fecha.dia && this.mes == fecha.mes;
	}

	public boolean anterior (Fecha fecha){
		return this.toTimeStamp() < fecha.toTimeStamp();
	}

	public boolean posterior (Fecha fecha){
		return this.toTimeStamp() > fecha.toTimeStamp();
	}

	public int diferenciaDias(Fecha fecha){
		return (fecha.toTimeStamp() - this.toTimeStamp())/86400;
	}
	
	public boolean bisiesto(){
		return this.checkBisiesto(ano);
	}
	
	public boolean checkBisiesto(int ano) {
		if(ano % 100 == 0) {
			return ano % 400 == 0;
		}
		
		return ano % 4 == 0;
	}

	public int diasAno(int ano){
		if(this.checkBisiesto(ano)) {
			return 366;
		}
		
		return 365;
	}

	public void incrementar(int dias){
		while(dias > 0) {
			dia += 1;
			if(dia > meses.get(mes)) {
				dia = 1;
				mes += 1;
				if(mes > 12) {
					mes = 1;
					ano += 1;
				}
			}
			dias -= 1;
		}
	}

	public int diasAnoRestantes(){
		float diasTotales = dia;
		
		for(int i = mes; i < 1; i--) {
			diasTotales += meses.get(i);
		}
		
		return (int)(365 - diasTotales);
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
}