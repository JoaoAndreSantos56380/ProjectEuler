import java.util.List;
import java.util.ArrayList;

public class LarestPrimeFactor {
	public static void main(String[] args) {
		List<Long> factors = primeFactors(600851475143L);
		for (long element : factors) {
			System.out.print(element + " ");
		}
	}

	public static List<Long> primeFactors(long numbers) {
		long n = numbers;
		List<Long> factors = new ArrayList<Long>();
		for (long i = 2; i <= n / i; i++) {
			while (n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}
		if (n > 1) {
			factors.add(n);
		}
		return factors;
	}
}
