import java.math.BigInteger;

public class PowerDigitSum {
	public static void main(String[] args) {
		BigInteger two = new BigInteger("2");
		BigInteger value = two.pow(1000);
		String str = value.toString();
		int sum = 0;
		//System.out.println(str);
		for (int i = 0; i < str.length(); i++) {
			sum += ( str.charAt(i) - '0' );
		}
		System.out.println(sum);
	}
}
