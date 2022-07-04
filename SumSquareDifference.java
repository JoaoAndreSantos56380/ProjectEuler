public class SumSquareDifference {
	public static void main(String[] args) {
	
		int squareSum = 0;
	
		int sumOfSquares = 0;
	
		for (int i = 1; i < 101; i++) {
			sumOfSquares += i*i;
			squareSum += i;
		}

		System.out.println(squareSum * squareSum - sumOfSquares);
	}
}
