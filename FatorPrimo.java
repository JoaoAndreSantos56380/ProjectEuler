
public class FatorPrimo {
	private int base;
	private int expoente;

	public FatorPrimo(int base){
		this.base = base;
		this.expoente = 1; 
	}

	public int getBase(){
		return base;
	}

	public int getExpoente(){
		return expoente;
	}

	public void incrementaExpoente(){
		expoente++;
	}
}
