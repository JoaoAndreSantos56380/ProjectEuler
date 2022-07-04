public class LargestPalindromeProduct {
	public static void main(String[] args) {
		int number = 10001;
		int multiple = 0;
		boolean capicua = true;
		int a = 0;
		int b = 0;
		for (int i = 100; i < 1000; i++) {
			for (int j = 100; j < 1000; j++) {
				capicua=true;
				multiple = i * j;
				String palindrome = String.valueOf(multiple);
				for (int k = 0; k < palindrome.length(); k++) {
					if (palindrome.charAt(k) != palindrome.charAt(palindrome.length() - 1 - k )) {
						capicua = false;
						break;
					}
				}
				if ((multiple > number && capicua == true)) {
					number = multiple;
					a = i;
					b = j;
				}
				/*
				StringBuilder sb = new StringBuilder(String.valueOf(multiple));
				StringBuilder sg = new StringBuilder(String.valueOf(multiple)).reverse();
				if ( (sg.equals(sb)) && (multiple > number)) {
					number = multiple;
				}*/
			}
		}
		System.out.println(number + " " + a + " " + b);
	}
}
