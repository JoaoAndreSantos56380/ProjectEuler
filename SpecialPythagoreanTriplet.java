public class SpecialPythagoreanTriplet {
	public static void main(String[] args) {
		//System.out.println("xau");
		for (int i = 0; i < 1000; i++) {
			for (int j = i+1; j < 1000; j++) {
				for (int j2 = j+1; j2 < 1000; j2++) {
					if ( Math.pow(i, 2) + Math.pow(j, 2) == Math.pow(j2, 2) && i+j+j2 == 1000 ){
						System.out.println(i * j * j2);
					}
				}
			}
		}
	}
}
/*
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
a^2 + b^2 = c^2

// For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
*/
