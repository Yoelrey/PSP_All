package FicheroUtilidades;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Utilidades {
	
	// Para leer un fichero
	public static BufferedReader getBufferedReader(String nombreFichero) throws FileNotFoundException {

		FileReader lector;
		lector = new FileReader(nombreFichero);

		BufferedReader bufferedReader;
		bufferedReader = new BufferedReader(lector);
		return bufferedReader;
	}
//Para escribir en un fichero 
	public static PrintWriter getPrintWriter(String nombreFichero) throws IOException {
		PrintWriter printWriter;
		FileWriter fileWriter;
		fileWriter = new FileWriter(nombreFichero);
		printWriter = new PrintWriter(fileWriter);
		return printWriter;
	}
	//Para obtener una lista de dinamica de las lineas de un fichero
	public static ArrayList<String> getLineasFichero(String nombreFichero) throws IOException {
		ArrayList<String> lineas = new ArrayList<String>();
		BufferedReader bfr = getBufferedReader(nombreFichero);
		// Leemos líneas del fichero...
		String linea = bfr.readLine();
		while (linea != null) {
			// Y las añadimos al array
			lineas.add(linea);
			linea = bfr.readLine();
		}
		// Fin del bucle que lee líneas
		return lineas;
	}
}
