public class LongestCollatzSequence {
	private static int MILLION = 1000000;
	public static void main(String[] args) {
		int contagemFinal = 0;
		int indiceFinal = -1;
		int contagem = 0;
		for (int index = 0; index <= MILLION; index++) {
			//System.out.println(index);
			long num = index;
			contagem = 0;
			//System.out.println("num: " + num + " contagem: " + contagem);
			while (num > 1 ) {
				if (num % 2 == 0) {
					num = odd(num);
					contagem++;
					//System.out.println("num: " + num + " contagem: " + contagem);
				} else{
					num = even(num);
					contagem++;
					//System.out.println("num: " + num + " contagem: " + contagem);
				}
			}
			if (contagem > contagemFinal) {
				contagemFinal = contagem;
				indiceFinal = index;
			}

			if (index == MILLION) {
				System.out.println("num: " + index + " contagem: " + (contagem + 1));
			}

			if (contagem > 400) {
				System.out.println("num: " + index + " contagem: " + (contagem + 1));
			}
			//System.out.println("num: " + index + " contagem: " + (contagem + 1));
			//System.out.println();
		}
		System.out.println(indiceFinal  + " " + (contagemFinal + 1));
	}// main

	public static long odd(long numero){
		return numero / 2;
	}

	public static long even(long numero){
		return (numero * 3 + 1);
	}
}//classe
/*
0 -
1 -
2 -
3 -
4 -
5 -
6 -
7 -
8 -
9 -
10 - 
11 - 
12 - 
13 - 
14 - 
15 - 
16 - 
17 - 
18 - 
19 - 
20 - 
 */
