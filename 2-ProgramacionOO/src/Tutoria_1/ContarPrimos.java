package Tutoria_1;

public class ContarPrimos {
	
	public ContarPrimos() {
		
	}
	
	public boolean esPrimo(int numero) {
		if(numero <= 0) {
			return false;
		}
		
		if(numero == 1) {
			return true;
		}
		
		for(int i = 2; i < numero; i++) {
			if(numero % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public int sumarPrimosEnLosPrimerosXNumeros(int tope) {
		int suma = 0;
		
		for(int i = 1; i <= tope; i++) {
			if(esPrimo(i)) {
				suma += i;
			}
		}
		
		return 0;
	}
	
	public int sumarLosPrimerosXPrimos(int numeroPrimos) {
		return 0;
	}
	
	public static void main(String[] args) {
		
	}
}
