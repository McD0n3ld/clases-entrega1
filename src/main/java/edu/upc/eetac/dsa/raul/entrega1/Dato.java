package edu.upc.eetac.dsa.raul.entrega1;

import java.io.Serializable;

public class Dato implements Serializable {

	private static final long serialVersionUID = -3317339979711535370L; // recomendacion de eclipse

	int numero;
	String texto;
	char caracter;
	
	public Dato(int numero, String texto, char caracter) {
		super();
		this.numero = numero;
		this.texto = texto;
		this.caracter = caracter;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public char getCaracter() {
		return caracter;
	}

	public void setCaracter(char caracter) {
		this.caracter = caracter;
	}
	
	
	

}
