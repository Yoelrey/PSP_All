package Ejercicio2ExamenAnterior;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Launcher {

    // Método para escoger tres letras aleatorias
    public static String[] escogeLetras() {
        Scanner sc = new Scanner(System.in);

        // Lista de letras del alfabeto
        String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "N", "M", "O", "P", "Q", "R",
                "S", "T", "U", "V", "W", "X", "Y", "Z"};

        // Array para almacenar las tres letras escogidas
        String[] letrasABuscar = new String[3];
        Random rand = new Random();

        for (int i = 0; i < letrasABuscar.length; i++) {
            // Generar un número aleatorio para seleccionar una letra del array
            int num = rand.nextInt(26);

            // Asignar la letra correspondiente al array de letras a buscar
            letrasABuscar[i] = letras[num];

            // Imprimir la letra que se buscará
            System.out.println("Se buscará la letra: " + letras[num]);
        }

        return letrasABuscar;
    }

    // Método para leer resultados de archivos
    public static int leerResultados(String ficheroResultado) {
        File archivo;
        int total = 0;
        int aux;

        archivo = new File(".", ficheroResultado);

        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));

            String linea;

            // Leer cada línea del archivo
            while ((linea = br.readLine()) != null) {
                // Convertir la línea a un entero y sumarlo al total
                aux = Integer.parseInt(linea);
                total += aux;

                // Imprimir información de depuración
                System.out.println("aux: " + aux);
                System.out.println("total: " + total);
            }

            // Cerrar el BufferedReader
            br.close();
            return total;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return total;
    }

    // Método para escribir el resultado total en un archivo
    public static void escribirResultadoFinal(int resultado) {
        String resultadoTexto = String.valueOf(resultado);
        File ficheroResultado = new File(".\\src\\Ejercicio2ExamenAnterior\\resultadoTotal.txt");

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroResultado));

            // Escribir el resultado total en el archivo
            bw.append(resultadoTexto);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Obtener la ruta del directorio actual
        String classPath = System.getProperty("user.dir");

        // Nombre del archivo de entrada
        String archivoEntrada = "textoA.txt";

        // Obtener tres letras aleatorias
        String[] letrasEscogidas = escogeLetras();

        // Carpeta actual y nombre base del archivo de salida
        String carpetaActual = "\\src\\Ejercicio2ExamenAnterior\\";
        String archivoSalida = "resultado";

        String letra;
        File ficheroError;

        // Nombres de los archivos de resultados individuales
        String[] ficherosResultado = new String[3];
        String ficheroResultado;

        // Ejecutar el Contador para cada letra escogida
        for (int i = 0; i < letrasEscogidas.length; i++) {
            letra = letrasEscogidas[i];
            ficheroResultado = archivoSalida + letra + ".txt";
            ProcessBuilder pb = new ProcessBuilder("java", classPath + carpetaActual + "Contador.java", archivoEntrada,
                    letra, ficheroResultado);

            ficherosResultado[i] = ficheroResultado;

            ficheroError = new File(".\\src\\Ejercicio2ExamenAnterior\\", "error" + letra + ".txt");
            pb.redirectError(ficheroError);

            try {
                pb.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Finalizado.");

        // Esperar hasta que los procesos hayan terminado
        try {
            System.out.println("Esperando...");
            Thread.sleep(5000);

            // Calcular el resultado total sumando los resultados individuales
            int total = 0;

            for (int i = 0; i < ficherosResultado.length; i++) {
                int resultado = leerResultados(ficherosResultado[i]);
                total += resultado;
            }

            // Escribir el resultado total en un archivo
            escribirResultadoFinal(total);
            System.out.println("Se ha guardado el resultado total en el archivo resultadoTotal.txt, dentro de la carpeta ejercicio2A");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
