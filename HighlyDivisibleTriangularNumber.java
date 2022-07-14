
import java.util.ArrayList;
public class HighlyDivisibleTriangularNumber {
	public static void main(String[] args) {
		System.out.println("comecou");
		int max = 50000;
		int i = 1;
		int sum = 0;
		int divisores;
		boolean[] primos = crivoEratostenes(1000000000);
		while (i <= max) {
			//sum = 0;
/* 			for (int j = 1; j <= i; j++) {
				sum += j;
			} */
			sum += i;
			divisores = calculaNumeroDivisores(sum, primos);
			if (divisores > 500) {
				System.out.println("iteracao: " + i + " termo: " + sum + " " + "divs: " + divisores);
				break;
			}
			//System.out.println(divisores);
			i++;
		}
/* 		boolean[] teste = crivoEratostenes(max);
		for (int j = 2; j < teste.length; j++) {
			if (teste[j] == true) {
				System.out.println("indice: " + j);
			}
		} */
	}

	private static int calculaNumeroDivisores(int sum, boolean[] primos) {
		// obter primos ate ao numero desejado9 (numero triangular)
		//boolean[] primos = crivoEratostenes(sum);
		if (primos[sum] == true) {
			return 2;
		}
		// array de fatores primos do numero triangular
		ArrayList<FatorPrimo> fatoresPrimos = new ArrayList<>();
		//indice do array de fatores primos (para incrementar expoente da potencia)
		int indice = -1;
		//percorrer o array de primos 
		for (int i = 2; i < primos.length && (sum > 1); i++) {
			//se o numero for primo
			if (primos[i] == true) {
				// se o primo dividir o numero triangular 
				if (sum % i == 0) {
					indice = contem(i, fatoresPrimos);
					if (indice == -1) {//se nao contem o indice
						fatoresPrimos.add(new FatorPrimo(i));
						sum /= i;
						indice = contem(i, fatoresPrimos);
						// enquanto o primo dividir o numero triangular 
						while(sum % i == 0){
							//incremementar o expoente da potencia 
							fatoresPrimos.get(indice).incrementaExpoente();
							sum /= i;
						}
					}
				}
			}
		}

		int numeroDivisores = 1;
		//int expoente = 0;
		//obter expoentes e fazer calculo respetivo (multiplicar os expoentes uns pelos outros)
		for (int i = 0; i < fatoresPrimos.size(); i++) {
			// expoente = fatoresPrimos.get(i).getExpoente();
			numeroDivisores *= (fatoresPrimos.get(i).getExpoente() + 1);
		}
		//devolver o numero de divisores
		return numeroDivisores;
	}

	private static int contem(int i, ArrayList<FatorPrimo> fatoresPrimos) {
		for (int j = 0; j < fatoresPrimos.size(); j++) {
			if (fatoresPrimos.get(j).getBase() == i) {
				return j;
			}
		}
		return -1;
	}

	protected static boolean[] crivoEratostenes(int limit){
		boolean[] primos = new boolean[limit+1];
		for (int i = 0; i < primos.length; i++) {
			primos[i] = true;
		}
		for (int i = 2; i < primos.length; i++) {
			if (primos[i] == true) {
				for (int j = 2 * i; j < primos.length; j += i) {
					primos[j] = false;
				}
			}
		}
		return primos;
	}
}
// 18446744073709551616 2^32
// 37107287533902102798797998220837590246510135740250 nume
