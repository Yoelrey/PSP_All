package Ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nombresFicheros = {"comercio.txt", "contabilidad.txt", "gerencia.txt", "informatica.txt", "rrhh.txt"};

        String classPath = System.getProperty("user.dir");

        String carpetaActual = "\\src\\Ejercicio1\\";
        String archivoSalida = "resultado";
        
        System.out.println("Escoge el mínimo a partir del cual quieres sumar: ");
        String minimo = sc.nextLine();
        System.out.println("Escoge el máximo a hasta el que quieres sumar: ");
        String maximo= sc.nextLine();
        File ficheroError;

		/*Los argumentos pasados al ProcessBuilder vienen siendo el fichero de entrada, el minimo a partir del cual se quiere sumar,
		 * el maximo hasta el cual se quiere sumar y  el nombre del fichero de salida. 
		 * Tanto los ficheros de error como los resultados deberan apareceran en la carpeta del ejercicio1*/

        for (int i = 0; i < nombresFicheros.length; i++) {
            String nombreFichero = nombresFicheros[i];
            ProcessBuilder pb = new ProcessBuilder("java", classPath + carpetaActual + "Sumador.java", nombreFichero, minimo,maximo, archivoSalida + nombreFichero);

            ficheroError = new File(".\\src\\Ejercicio1\\", "error" + nombreFichero + ".txt");
            pb.redirectError(ficheroError);

            try {
                pb.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finalizado.");

        try {
            System.out.println("Espera 3 segundos a que todo esté bien guardado...");
            Thread.sleep(3000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        String[] ficherosResultado = {"resultadocomercio.txt", "resultadocontabilidad.txt", "resultadogerencia.txt", "resultadoinformatica.txt", "resultadorrhh.txt"};

        File ejercicio1A;
        BufferedReader br;

        for (int i = 0; i < ficherosResultado.length; i++) {
            ejercicio1A = new File(".\\src\\Ejercicio1\\", ficherosResultado[i]);
            try {
                br = new BufferedReader(new FileReader(ejercicio1A));
                String linea;

                while ((linea = br.readLine()) != null) {
                    System.out.println("Resultado de " + ficherosResultado[i] + " es: " + linea);
                }

                br.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
