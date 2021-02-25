
package ficherosDeTexto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PruebaLectura {
	
	/**
	 * Pre: [nombre] almacena la ruta + nombre del fichero a leer
	 * Post: lee el fichero cuyo path coincide con [nombre] y muestra por 
	 * 		pantalla el número total de líneas y el número total de caracteres
	 * 		de este.
	 */
	private static void mostrarInformacionFichero(String nombre) {
		/*
		 * Creo el objeto [file] de tipo File para poder crear el objeto
		 * de tipo Scanner para leer el fichero.
		 */
		File file = new File(nombre);
		int numLineas = 0; // Almacena el número de lineas del fichero
		int numCaracteres = 0; // Almacena el número de caracteres del fichero
		try {
			/*
			 * Se crea un objeto [Formatter] al que se asocia un fichero deno-
			 * minado [file].
			 */
			Scanner f = new Scanner(file);
			while(f.hasNextLine()) {
				/*
				 * Almacenamos toda la línea en la variable asociada, para poder
				 * trabajar con ella. Podríamos usar el método subString() y todos 
				 * los métodos de la clase String asociados que dimos en el primer
				 * trimestre. 
				 */
				String linea = f.nextLine();
				numLineas++;
				numCaracteres = numCaracteres + linea.length();
			}
			/*
			 * Se libera el fichero que estamos leyendo. 
			 */
			f.close();
			/*
			 * Mostramos por pantalla el resultdo del análisis del fichero.
			 */
			System.out.println("Fichero " + nombre + " analizado con éxito: ");
			System.out.println("\t- Número total de lineas: " + numLineas);
			System.out.println("\t- Número total de caracteres: " + numCaracteres);
		} catch(FileNotFoundException e) {
			System.out.println("El fichero " + nombre + " no ha podido ser abierto.");
		}
	}
	
	/**
	 * Pre: [nombre] almacena la ruta + nombre del fichero a leer
	 * Post: lee el fichero cuyo path coincide con [nombre] y muestra por 
	 * 		pantalla el nombre de cada uno de los alumnos seguido de la
	 * 		media de sus 3 examenes.
	 */
	private static void calcularMedias(String nombre) {
		/*
		 * Creo el objeto [file] de tipo File para poder crear el objeto
		 * de tipo Scanner para leer el fichero.
		 */
		File file = new File(nombre);
		try {
			/*
			 * Se crea un objeto [Formatter] al que se asocia un fichero deno-
			 * minado [file].
			 */
			Scanner f = new Scanner(file);
			/*
			 * Recorremos el fichero linea por linea.
			 */
			while(f.hasNextLine()) {
				String linea = f.nextLine();
				/*
				 * Cogemos cada una de las lineas con formato 
				 * [nombre;dni;exa1;exa2;exa3]
				 */
				String[] lineaSeparada = linea.split(";");
				/*
				 * Calculamos la media cogiendo las notas de los examenes. Nuestra tabla
				 * tiene siempre la siguiente estructura:
				 * 		lineaSeparada[0] = [nombre]
				 * 		lineaSeparada[1] = [dni]
				 * 		lineaSeparada[2] = [exa1]
				 * 		lineaSeparada[3] = [exa2]
				 * 		lineaSeparada[4] = [exa3]
				 */
				double media = (Integer.parseInt(lineaSeparada[2])+ 
						Integer.parseInt(lineaSeparada[3]) + Integer.parseInt(lineaSeparada[4]))/3;
				System.out.println(lineaSeparada[0] + " tiene una media de: " + media);
			}
			/*
			 * Se libera el fichero que estamos leyendo. 
			 */
			f.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fichero " + nombre + " no ha podido ser abierto.");
		}
	}
	
	/**
	 * Pre: ---
	 * Post: Ejecuta el programa Java que solicita al usuario el (path + nombre) de un fichero
	 * 		 que ya existe en el sistema. Muestra por pantalla el número de líneas y el número
	 * 		 de caracteres de este.
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		/*
		 * Solicita al usuario el fichero mostrar la información
		 * de este por pantalla
		 */
		System.out.print("Dame la ruta + nombre del fichero: ");
		String nombreFichero = entrada.next();
		mostrarInformacionFichero(nombreFichero);
	}
}
