package pruebita;
class Fecha{

	public Fecha(){};

	public Fecha(int dia, int mes, int ano){};

	public Fecha(Fecha fecha){};

	public Fecha(String fecha){};

	public Fecha(int timeStamp){};

	//public Fecha hoy(){}; <-- Mal

	public char diaSemana(){
		return ' ';
	};

	public boolean festivo(){
		return false;
	}

	public int diasAnoRestantes(){
		return 0;
	}

	public int diferenciaDias(Fecha fecha){
		return 0;
	}

	public boolean mayor(Fecha fecha){
		return false;
	}

	public boolean igual(Fecha fecha){
		return false;
	}

	public void sumarDia(int dias){}; public void sumarMes(int mes){}; public void sumarAno(int ano){};

	public boolean bisiesto(){
		return false;
	};

	public Estacion estacion(){
		return Estacion.PRIMAVERA;
	};
	
	private enum Estacion {
		PRIMAVERA,
		VERANO,
		OTONO,
		INVIERNO
	}
}