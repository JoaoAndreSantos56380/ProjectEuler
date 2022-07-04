public class SmallestMultiple {

	public static void main(String[] args) {
		boolean progress = true;
		int count = 0;
		int finalNumber = 0;
		int number = 0;
		while(finalNumber == 0 && count < 100000000){
			progress = true;
			number += 20;
			count++;
			while(progress == true){
				for (int i = 2; i <= 20; i++) {
					if (number % i != 0) {
						progress = false;
						break;
					}
					if ((i == 20 ) && (number % i == 0)) {
						finalNumber = number;
					}
				}
			}
		}
		System.out.println(finalNumber);
	}
	/**
	 * 
	 * somar 20 em 20 
	 * 
	 * ter variavel para controlar progresso 
	 * 
	 * a cada numero dividir por todos os numeros de 1 a 20 se der para todos os numeros guardar o numero
	 * 
	 * e imprimir se falhar somar mais 20 e repetir o processo
	 * 
	 */

}
