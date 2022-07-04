public class C10001stPrime {
	public static void main(String[] args) {
		// 116686
		boolean[] crivoCompleto = crivoEratostenes(116686);
		int count = 0;
		for (int i = 2; i < crivoCompleto.length && count != 10001; i++) {
			if(crivoCompleto[i] == false){
				count++;
			}
			if (count == 10001) {
				System.out.println(i);
			}
		}
	}

	public static boolean[] crivoEratostenes(int length){
		boolean[] crivo = new boolean[length+1];
		for ( int i = 2; i < crivo.length; i++ ) {
			if (crivo[i] == false) {
				for ( int j = i+i; j < crivo.length; j+=i ) {
					crivo[j] = true;
				}
			}
		}
		return crivo;
	}
	/**
	 * crivo de eratostenes 
	 * 
	 */
}
