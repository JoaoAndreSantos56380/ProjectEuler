public class Fibonacci{
	
	private static final int UNKNOWN = -1;
	
	public static void main(String[] args) {
		long sum = 0;
		int n = 0;
		while(fibonacci(n) < 4000000){
			n++;
			if (fibonacci(n)%2 == 0) {
				sum+= fibonacci(n);
			}
		}
		long i = fibonacci(n);
		System.out.println(i);
		System.out.println(sum);
	}


	public static long fibonacci(int n) {

		long[] sols = new long[n + 1];
		for (int i = 0; i <= n; i++) {
			// no inicio, nao se conhece qualquer solucao
			sols[i] = UNKNOWN;
		}

		// invocar a recursao passando o vector de solucoes
		return fibonacci(sols, n);
	}

	public static long fibonacci(long[] sols, int n) {

		long resultado;
		// jah foi calculado?
		if (sols[n] != UNKNOWN) {
			resultado = sols[n];
		} else {
			// base da recursão
			if (n == 0 || n == 1) {
				sols[n] = 1;
				resultado = sols[n];
			} else {
				// passo da recursao
				sols[n] = fibonacci(sols, n - 1) + fibonacci(sols, n - 2);
				resultado = sols[n];
			}
		}
		return resultado;
	}
}
