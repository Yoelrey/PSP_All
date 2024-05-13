package Ejemplo6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Calculadora {

	//1 Abrir el fichero informatica.txt
	
	//2 sumar las cantidades de un fichero
	
	//3	Guardar el resultado numerico en u n fichero llamado
	//totalinformatica.txt
	public static void hacerCalculos(String fichEntrada, String fichSalida) throws IOException {
		 
		int suma = 0;
		
		
			ArrayList<String> cantidades = getLineasFichero(fichEntrada);
		
		for (String s:cantidades) {
			suma+=Integer.parseInt(s);
			
		}
		System.out.println("El total de gastos de: "+fichEntrada+" es: "+suma+" €");
		PrintWriter pw= getPrintWriter(fichSalida);

		pw.println(suma);
		
		pw.close();
	}
	
	
	
	public static BufferedReader getBufferedReader(String nombreFichero) throws FileNotFoundException {

		FileReader lector;
		lector = new FileReader(nombreFichero);

		BufferedReader bufferedReader;
		bufferedReader = new BufferedReader(lector);
		return bufferedReader;
	}
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
	
	public static void main(String[] args) {
		
		Scanner jaime= new Scanner(System.in);
		String ent,sal;
		
		System.out.println("Fichero de entrada: ");  // Esto seria args [0]
		ent=args[0];
		System.out.println("Fichero de salida: ");   // Esto seria args [1]
		sal=args[1];
		
		
		try {
			hacerCalculos(ent, sal);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Para leer un fichero
		
	}
	
}
