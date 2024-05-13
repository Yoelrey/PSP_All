package Ejercicio1ExamenAnterior;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner sc = new Scanner(System.in);

        // Lista de nombres de archivos de entrada
        String[] nombresFicheros = {"comercio.txt", "contabilidad.txt", "gerencia.txt", "informatica.txt", "rrhh.txt"};

        // Obtener la ubicación del directorio actual
        String classPath = System.getProperty("user.dir");

        // Carpetas y archivos de salida
        String carpetaActual = "\\src\\ejercicio1A\\";
        String archivoSalida = "resultado";
        
        System.out.println("Escoge el mínimo a partir del cual quieres sumar: ");
        String minimo = sc.nextLine();

        File ficheroError;

        // Ejecutar el Sumador para cada archivo de entrada
        for (int i = 0; i < nombresFicheros.length; i++) {
            String nombreFichero = nombresFicheros[i];
            ProcessBuilder pb = new ProcessBuilder("java", classPath + carpetaActual + "Sumador.java", nombreFichero, minimo, archivoSalida + nombreFichero);

            // Redireccionar la salida de error a un archivo de error específico
            ficheroError = new File(".\\src\\ejercicio1A\\", "error" + nombreFichero + ".txt");
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

        // Nombres de archivos de resultado
        String[] ficherosResultado = {"resultadocomercio.txt", "resultadocontabilidad.txt", "resultadogerencia.txt", "resultadoinformatica.txt", "resultadorrhh.txt"};

        File ejercicio1A;
        BufferedReader br;

        // Leer y mostrar los resultados
        for (int i = 0; i < ficherosResultado.length; i++) {
            ejercicio1A = new File(".\\src\\ejercicio1A\\", ficherosResultado[i]);
            try {
                br = new BufferedReader(new FileReader(ejercicio1A));
                String linea;

                // Leer cada línea del archivo de resultado
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
