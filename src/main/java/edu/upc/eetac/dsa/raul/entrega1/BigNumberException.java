package edu.upc.eetac.dsa.raul.entrega1;

public class BigNumberException extends Exception {

	private static final long serialVersionUID = 6440617511433658876L;	//recomendacion de eclipse

	public BigNumberException() {
		super("El numero es demasiado grande!");
	}
	
	public static void checkearNumero(int num) throws Exception {
		if (num > 1000)
			throw new BigNumberException();
		return;
	}

}
