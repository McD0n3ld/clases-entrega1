package edu.upc.eetac.dsa.raul.entrega1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class App {
	static String direccion_1 = "C:/numeros.txt";
	static String direccion_2 = "C:/texto.txt";
	static String direccion_3 = "C:/registro.txt";
	static String direccion_4 = "C:/imagen.jpg";
	static String direccion_5 = "C:/objeto.bin";

	public static void main(String[] args) {
		int caracteres = 0;
		int bytes = 0;
		String ficheroMayor = "";

		String t = "";
		int ejercicio = 0;
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			try {
				System.out.println("Introduce el numero de ejercicio que quieras comprobar. [1 - 7]. 0 para salir");
				t = s.readLine();
				ejercicio = Integer.parseInt(t);
			} catch (Exception e) {
				System.out.println("No has introducido un numero del 8 al 11");
			}

			switch (ejercicio) {
			case 1:
				System.out.println("\n\n--------------------------------------------\nInicio ejercicio 1");
				System.out.println("numeros.txt debe encontrarse en C:/");
				BufferedReader br = FicherosLib.abrirFicheroLectura(direccion_1);
				FicherosLib.leerNumerosEnteros(br);
				System.out.println("Fin del ejercicio 1");
				break;

			case 2:
				System.out.println("\n\n--------------------------------------------\nInicio ejercicio 2");
				System.out.println("numeros.txt debe encontrarse en C:/");
				br = FicherosLib.abrirFicheroLectura(direccion_1);
				FicherosLib.leerNumerosEnterosBajos(br);
				System.out.println("Fin del ejercicio 2");
				break;

			case 3:
				System.out.println("\n\n--------------------------------------------\nInicio ejercicio 3");
				System.out.println("numeros.txt debe encontrarse en C:/");
				br = FicherosLib.abrirFicheroLectura(direccion_1);
				FicherosLib.leerNumerosEnteros(br);
				System.out.println("Fin del ejercicio 3");
				break;

			case 4:
				System.out.println("\n\n--------------------------------------------\nInicio ejercicio 4");
				System.out.println("-------> C:/");
				br = FicherosLib.abrirFicheroLectura(direccion_2);
				caracteres = FicherosLib.contarCaracteres(br);
				FicherosLib.escribirCaracteres(direccion_3, caracteres, direccion_2);
				System.out.println("Fin del ejercicio 4");
				break;

			case 5:
				System.out.println("\n\n--------------------------------------------\nInicio ejercicio 5");
				System.out.println("-------> C:/");
				BufferedInputStream bis = FicherosLib.abrirImagen(direccion_4);
				bytes = FicherosLib.contarBytes(bis);
				FicherosLib.escribirCaracteres(direccion_3, bytes, direccion_4);
				System.out.println("Fin del ejercicio 5");
				break;

			case 6:
				System.out.println("\n\n--------------------------------------------\nInicio ejercicio 6");
				System.out.println("-------> C:/");
				br = FicherosLib.abrirFicheroLectura(direccion_3);
				ficheroMayor = FicherosLib.buscarArchivoMayor(br);
				System.out.println(ficheroMayor);
				System.out.println("Fin del ejercicio 6");
				break;

			case 7:
				System.out.println("\n\n--------------------------------------------\nInicio ejercicio 7");
				System.out.println("-------> C:/");
				Dato dt1 = new Dato(2, "Prueba1", 'r');
				Dato dt2 = new Dato(3, "Prueba2", 's');
				Dato dt3 = new Dato(4, "Prueba3", 't');
				FicherosLib.escribirObjetoFichero(direccion_5, dt1, dt2, dt3);
				Dato temp;
				ArrayList<Dato> al = FicherosLib.recuperarObjetoFichero(direccion_5);
				for (int i = 0; i < al.size(); i++) {
					temp = al.get(i);
					System.out.println("String: " + temp.getTexto());
					System.out.println("Numero" + temp.getNumero());
					System.out.println("Caracter: " + temp.getCaracter());
				}

				System.out.println("Fin del ejercicio 7");
				break;

			case 0:
				return;
				
			default:
				System.out.println("No has introducido un numero del 1 al 7");
				break;
			}
		}

	}
}