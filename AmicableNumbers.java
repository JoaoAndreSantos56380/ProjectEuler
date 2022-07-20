import java.util.ArrayList;

public class AmicableNumbers {
	public static void main(String[] args) {
		boolean[] primos = crivoEratostenes(10000);
		int totalSum = 0;
		ArrayList<Integer> listaNumsContabilizados = new ArrayList<>(); 
		for (int i = 2; i < 10000; i++) {
			int d_b = calculaSomaProperDivisors(i, primos);
			int d_a = calculaSomaProperDivisors(d_b, primos);
			if ( i == d_a && (d_a != d_b)) {
				if (contemAmicableNumber(d_a, listaNumsContabilizados) == -1 || contemAmicableNumber(d_b, listaNumsContabilizados)== -1) {
					listaNumsContabilizados.add(i);
					listaNumsContabilizados.add(calculaSomaProperDivisors(i, primos));
					totalSum += (d_a + d_b);
				}
			}
		}
		System.out.println(totalSum);
	}

	private static int contem(int i, ArrayList<FatorPrimo> fatoresPrimos) {
		for (int j = 0; j < fatoresPrimos.size(); j++) {
			if (fatoresPrimos.get(j).getBase() == i) {
				return j;
			}
		}
		return -1;
	}

	private static int contemAmicableNumber(int i, ArrayList<Integer> listaNumsContabilizados) {
		for (int j = 0; j < listaNumsContabilizados.size(); j++) {
			if (listaNumsContabilizados.get(j) == i) {
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

	private static int calculaSomaProperDivisors(int num, boolean[] primos) {
		int numero = num;
		// obter primos ate ao numero desejado9 (numero triangular)
		//boolean[] primos = crivoEratostenes(sum);
		// array de fatores primos do numero triangular
		ArrayList<FatorPrimo> fatoresPrimos = new ArrayList<>();
		//indice do array de fatores primos (para incrementar expoente da potencia)
		int indice = -1;
		//percorrer o array de primos 
		for (int i = 2; i < primos.length && (num > 1); i++) {
			//se o numero for primo
			if (primos[i] == true) {
				// se o primo dividir o numero triangular 
				if (num % i == 0) {
					indice = contem(i, fatoresPrimos);
					if (indice == -1) {//se nao contem o indice
						fatoresPrimos.add(new FatorPrimo(i));
						num /= i;
						indice = contem(i, fatoresPrimos);
						// enquanto o primo dividir o numero triangular 
						while(num % i == 0){
							//incremementar o expoente da potencia 
							fatoresPrimos.get(indice).incrementaExpoente();
							num /= i;
						}
					}
				}
			}
		}
		int somaFinal = 1;
		int somaDivisores = 0;
		//int expoente = 0;
		//obter expoentes e fazer calculo respetivo (multiplicar os expoentes uns pelos outros)
		for (int i = 0; i < fatoresPrimos.size(); i++) {
			// expoente = fatoresPrimos.get(i).getExpoente();
			for (int j = 0; j <= fatoresPrimos.get(i).getExpoente(); j++) {
				somaDivisores += Math.pow((double)fatoresPrimos.get(i).getBase(), j);
			}
			somaFinal *= somaDivisores;
			somaDivisores = 0;
		}
		//devolver o numero de divisores
		return somaFinal - numero;
	}
}
