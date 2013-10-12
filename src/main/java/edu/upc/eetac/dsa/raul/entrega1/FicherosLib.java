package edu.upc.eetac.dsa.raul.entrega1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FicherosLib {

	// Metodos EJERCICIO 1
	public static BufferedReader abrirFicheroLectura(String direccion_1) {
		// variables
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(direccion_1); // abrimos el fichero
			br = new BufferedReader(fr); // propiedades buffered
		} catch (Exception e) {
			e.printStackTrace();
		}
		return br;
	}

	public static void leerNumerosEnteros(BufferedReader br) {
		// variables
		Scanner s = null;

		try {
			s = new Scanner(br); // para scannear solo un tipo de datos

			while (s.hasNext()) {
				if (s.hasNextInt()) {
					System.out.println(s.nextInt());
				} else {
					s.next();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (s != null)
				s.close();
		}
	}

	// Metodos EJERCICIO 2
	public static void leerNumerosEnterosBajos(BufferedReader br) {
		// variables
		Scanner s = null;
		int temp = 0;
		try {
			s = new Scanner(br); // para scannear solo un tipo de datos

			while (s.hasNext()) {
				if (s.hasNextInt()) {
					temp = s.nextInt();
					BigNumberException.checkearNumero(temp);
					System.out.println(temp);
				} else {
					s.next();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (s != null)
				s.close();
		}
	}

	// Metodos EJERCICIO 4
	public static int contarCaracteres(String direccion) {
		BufferedReader br = abrirFicheroLectura(direccion);
		String line = null;
		int cont = 0;
		try {
			while ((line = br.readLine()) != null)
				cont += line.length();
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cont;
	}

	public static BufferedWriter abrirFicheroEscritura(String direccion) {
		// variables
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter(direccion, true); // abrimos el fichero
			bw = new BufferedWriter(fw); // propiedades buffered
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bw;
	}

	public static void escribirCaracteres(String direccion_3, int caracteres, String filename) {
		BufferedWriter bw = null;
		try {
			bw = abrirFicheroEscritura(direccion_3);
			Date dt = new Date();
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			bw.write(format.format(dt) + "-" + caracteres + "-" + filename + "\n");
			System.out.println("DEBUG: " + format.format(dt) + "-" + caracteres + "-" + filename);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Metodos EJERCICIO 5

	private static BufferedInputStream abrirImagen(String direccion_1) {
		// variables
		BufferedInputStream bis = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(direccion_1); // abrimos el fichero
			bis = new BufferedInputStream(fis); // propiedades buffered
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bis;
	}

	public static int contarBytes(String dir) {
		BufferedInputStream bis = FicherosLib.abrirImagen(dir);
		try {
			return bis.available();
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// Metodos EJERCICIO 6

	public static String buscarArchivoMayor(String dir) {
		int max = 0;
		int bytes = 0;
		String tempLine = "";
		String line = "";
		
		BufferedReader br = FicherosLib.abrirFicheroLectura(dir);
		try {
			while ((tempLine = br.readLine()) != null) {
				bytes = Integer.parseInt(tempLine.split("-")[1]);
				// System.out.println(bytes + " y " + max + " y " + tempLine);
				if (bytes > max) {
					max = bytes;
					line = tempLine;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return line;
	}

	// Metodos EJERCICIO 7

	public static void escribirObjetoFichero(String direccion, Object... obj) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		int i = 0;
		try {
			fos = new FileOutputStream(direccion);
			oos = new ObjectOutputStream(fos);
			for (i = 0; i < obj.length; i++)
				oos.writeObject(obj[i]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return;
	}

	public static ArrayList<Dato> recuperarObjetoFichero(String direccion) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Object aux;
		ArrayList<Dato> al = new ArrayList<Dato>();
		try {
			fis = new FileInputStream(direccion);
			ois = new ObjectInputStream(fis);
			while (fis.available() > 0) {
				aux = ois.readObject();
				if (aux instanceof Dato)
					al.add((Dato) aux);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return al;
	}

}
