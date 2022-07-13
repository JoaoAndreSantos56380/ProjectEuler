
import java.util.ArrayList;
public class HighlyDivisibleTriangularNumber {
	public static void main(String[] args) {
		int max = 50;
		int i = 1;
		int sum = 0;
		int divisores;
		while (i <= max) {
			sum = 0;
			for (int j = 1; j <= i; j++) {
				sum += j;
			}
			divisores = calculaNumeroDivisores(sum);
			System.out.println(divisores);
			System.out.println("iteracao: " + i + " termo: " + sum + " ");
			i++;
		}
		boolean[] teste = crivoEratostenes(max);
		for (int j = 2; j < teste.length; j++) {
			if (teste[j] == true) {
				System.out.println("indice: " + j);
			}
		}
	}

	private static int calculaNumeroDivisores(int sum) {
		// obter primos ate ao numero desejado9 (numero triangular)
		boolean[] primos = crivoEratostenes(sum);
		// array de fatores primos do numero triangular
		ArrayList<FatorPrimo> fatoresPrimos = new ArrayList<>();
		//indice do array de fatores primos (para incrementar expoente da potencia)
		int indice = -1;
		//percorrer o array de primos 
		for (int i = 2; i < primos.length; i++) {
			//se o numero for primo
			if (primos[i] == true) {
				// se o primo dividir o numero triangular 
				if (sum % i == 0) {
					indice = contem(i, fatoresPrimos);
					if (indice == -1) {//se nao contem o indice
						fatoresPrimos.add(new FatorPrimo(i));
					} else{
						// enquanto o primo dividir o numero triangular 
						while(sum % i == 0){
							//incremementar o expoente da potencia 
							fatoresPrimos.get(indice).incrementaExpoente();
						}
					}
				}
			}
		}

		int numeroDivisores = 1;
		//obter expoentes e fazer calculo respetivo (multiplicar os expoentes uns pelos outros)
		for (int i = 0; i < fatoresPrimos.size(); i++) {
			numeroDivisores *= fatoresPrimos.get(i).getExpoente();
		}
		//devolver o numero de divisores
		return numeroDivisores;
	}

	private static int contem(int i, ArrayList<FatorPrimo> fatoresPrimos) {
		for (int j = 0; j < fatoresPrimos.size(); j++) {
			if (fatoresPrimos.get(i).getBase() == i) {
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
