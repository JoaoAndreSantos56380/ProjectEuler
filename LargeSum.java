import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class LargeSum {
// 18446744073709551616 2^32
// 37107287533902102798797998220837590246510135740250 numero de 50 digitos 
// 9999999999999999999999999999999999999999999999999900 100 vezes o numero de 50 digitos
// 5537376230390876637302048746832985971773659831892672
// 340282366920938463463374607431768211455 2^128
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new File("LargeSumInput.txt"))) {
			BigInteger numeroBase = new BigInteger(sc.next());
			while (sc.hasNext()) {
				BigInteger numASomar = new BigInteger(sc.next());
				numeroBase = numeroBase.add(numASomar);
			}
			System.out.println(numeroBase/* .mod(new BigInteger("10000000000")) */);
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("Ficheiro não existe!");
		}
	}
}
