package Tutoria_1;

public class ContarPrimos {
	
	public ContarPrimos() {
		
	}
	
	public boolean esPrimo(int numero) {
		if(numero <= 1) {
			return false;
		}
		
		for(int i = 2; i < numero; i++) {
			if(numero % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public int sumarPrimosEnLosPrimerosXNumeros(int tope) {
		assert tope > 0;
		
		int suma = 0;
		
		for(int i = 1; i <= tope; i++) {
			if(esPrimo(i)) {
				suma += i;
			}
		}
		
		return suma;
	}
	
	public int sumarLosPrimerosXPrimos(int tope) {
		assert tope > 0;
		
		int suma = 0;
		int contador = 0;
		
		for(int i = 1; contador <= tope; i++) {
			if(esPrimo(i)) {
				suma += i;
				contador++;
				System.out.println(i);
			}
		}
		
		return suma;
	}
	
	public static void main(String[] args) {
		ContarPrimos contarPrimos = new ContarPrimos();
		
		int suma = contarPrimos.sumarPrimosEnLosPrimerosXNumeros(50);
		
		System.out.println("La suma de los primos en los primeros 50 números es: " + suma);
		
		int sumaPrimerosPrimos = contarPrimos.sumarLosPrimerosXPrimos(50);

		System.out.println("La suma de los primos 50 primeros primos es: " + sumaPrimerosPrimos);
	}
}
