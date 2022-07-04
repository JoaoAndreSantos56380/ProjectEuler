class Main {
	// Function to find the nth Fibonacci number
	public static int fib(int n) {
		if (n <= 1) {
			return n;
		}

		return fib(n - 1) + fib(n - 2);
	}

	public static void main(String[] args) {
		int n = 10;

		System.out.println("nth Fibonacci number is " + fib(n));
	}
}
