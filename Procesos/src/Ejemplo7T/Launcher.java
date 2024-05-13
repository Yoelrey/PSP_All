package Ejemplo7T;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Launcher {

	// Hay que lanzar la calculadora por cada fichero
	public static void main(String[] args) throws InterruptedException {

		String[] nombreFicheros = { "informatica.txt", "gerencia.txt", "rrhh.txt", "contabilidad.txt", "comercio.txt" };

		String path = System.getProperty("user.dir");
		String ruta = "\\src\\ejemplo6\\";
		int total = 0;
		int parcial;
		String minimo = "1000";
		ProcessBuilder pb;

		for (int i = 0; i < nombreFicheros.length; i++) {
			pb = new ProcessBuilder("java", path + ruta + "Calculadora.java", path + "\\src\\" + nombreFicheros[i],
					"T" + nombreFicheros[i], minimo);
			pb.redirectError(new File("E" + nombreFicheros[i]));
			try {
				pb.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		// Recuperar los totales de cada fichero mosntrandolo por pantall
		// Y Guardar los gastos en total gastos
		// Necesita tiempo para que se lean los ficheros
		Thread.sleep(3000);
		for (int i = 0; i < nombreFicheros.length; i++) {

			try {

				BufferedReader br = Calculadora.getBufferedReader(path + "\\T" + nombreFicheros[i]);
				parcial = Integer.parseInt(br.readLine());
				System.out.println("gastos" + nombreFicheros[i] + ": " + parcial);
				total += parcial;

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		//fin for

		System.out.println("gastos totales: " + total);
		System.out.println("Guardando en gastosTotales.txt......");
		try {
			PrintWriter pw = Calculadora.getPrintWriter("gastosTotales.txt");
			pw.write(String.valueOf(total));
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
