import java.math.BigInteger;
public class FactorialDigitSum {
	public static void main(String[] args) {
		BigInteger number = new BigInteger("1");
		BigInteger prod = new BigInteger("1");
		for (long i = 2; i <= 100; i++) {
			number = number.multiply(BigInteger.valueOf(i));
		}
		String numeroStr = number.toString();
		System.out.println(numeroStr);
		int sum = 0;
		for (int i = 0; i < numeroStr.length(); i++) {
			sum += (numeroStr.charAt(i) - 48); 
		}
		System.out.println(sum);
	}
}
