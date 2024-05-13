package Ejercicio2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

// se le pasa por args las consonantes a buscar  
// se recogera  la suma de vesces que aparece en un fichero


public class ContarConsonantes  {
	
	public static void hacerRecuento(String fichEntrada, String letra, String fichSalida)
			throws FileNotFoundException, IOException {
		BufferedReader br;
		br = Utilidades.getBufferedReader(fichEntrada);
		PrintWriter pw;
		pw = Utilidades.getPrintWriter(fichSalida);
		String lineaLeida;
		lineaLeida = br.readLine();
		int totalMayus = 0;
		// Mientras no queden líneas....
		while (lineaLeida != null) {
			// ...recorremos la linea...
			for (int i = 0; i < lineaLeida.length(); i++) {
				char letraLeida = lineaLeida.charAt(i);
				char letraPasada = letra.charAt(0);
				// incrementamos el contador
				if (letraLeida == letraPasada) {
					totalMayus++;
				}
				// fin del if

			}
			// fin del for
			// Pasamos a la siguiente linea
			lineaLeida = br.readLine();
		}
		// Escribimos el total de vocales
		// en el fichero de salida
		pw.println(totalMayus);
		pw.flush();
		// Y cerramos los ficheros
		pw.close();
		br.close();
		// fin del método hacerRecuento
	}

public static void main(String[] args) throws FileNotFoundException, IOException {
	Scanner sc =new Scanner (System.in);
		System.out.println("Nombre fich de entrada :");
		String fileIn= sc.nextLine();
		System.out.println("Introduzca el caracter a buscar:");
		String letter= sc.nextLine();
		System.out.println("Introduzca fich de salida :");
		String fichOut= sc.nextLine();
		
		
		hacerRecuento(fileIn, letter, fichOut);
		
		
}
}

