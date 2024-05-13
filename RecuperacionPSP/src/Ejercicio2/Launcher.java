package Ejercicio2;

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

    public static String[] escogeLetras() {
        Scanner sc = new Scanner(System.in);

        String[] letras = { "B", "C", "D", "F", "G", "H","J", "K", "L", "N", "M", "P", "Q", "R",
                "S", "T", "V", "W", "X", "Y", "Z"};

        String[] letrasABuscar = new String[3];
        Random rand = new Random();

        for (int i = 0; i < letrasABuscar.length; i++) {
            int num = rand.nextInt(22);

            letrasABuscar[i] = letras[num];

            System.out.println("Se buscará la letra: " + letras[num]);
        }

        return letrasABuscar;
    }

    public static int leerResultados(String ficheroResultado) {
        File archivo;
        int total = 0;
        int aux;

        archivo = new File(".", ficheroResultado);

        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));

            String linea;

            while ((linea = br.readLine()) != null) {
                aux = Integer.parseInt(linea);
                total += aux;

                System.out.println("aux: " + aux);
                System.out.println("total: " + total);
            }

            br.close();
            return total;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return total;
    }

    public static void escribirResultadoFinal(int resultado) {
        String resultadoTexto = String.valueOf(resultado);
        File ficheroResultado = new File(".\\src\\Ejercicio2\\resultadoTotal.txt");

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroResultado));

            bw.append(resultadoTexto);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String classPath = System.getProperty("user.dir");

        String archivoEntrada = "textoA.txt";

        String[] letrasEscogidas = escogeLetras();

        String carpetaActual = "\\src\\Ejercicio2\\";
        String archivoSalida = "resultado";

        String letra;
        File ficheroError;
        /*
		 * Los argumentos que se van a pasar son el fichero de entrada,que seria el textoA, la letra a
		 * buscar,que sera obtenida del array letrasEscogidas y por ultimo el fichero de salida,
		 * que tendra el nombre de resultado + el nombre de la letra a buscar.
		 * El resultado total aparecera dentro de la carpeta Ejercicio2 y los resultados individuales en la carpeta del proyecto
		 * a la altura de src.*/

        String[] ficherosResultado = new String[3];
        String ficheroResultado;

        for (int i = 0; i < letrasEscogidas.length; i++) {
            letra = letrasEscogidas[i];
            ficheroResultado = archivoSalida + letra + ".txt";
            ProcessBuilder pb = new ProcessBuilder("java", classPath + carpetaActual + "Contador.java", archivoEntrada,
                    letra, ficheroResultado);

            ficherosResultado[i] = ficheroResultado;

            ficheroError = new File(".\\src\\Ejercicio2\\", "error" + letra + ".txt");
            pb.redirectError(ficheroError);

            try {
                pb.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Finalizado.");
		//Se espera hasta que los procesos hayan finalizadp. 

        try {
            System.out.println("Esperando...");
            Thread.sleep(5000);

            int total = 0;

            for (int i = 0; i < ficherosResultado.length; i++) {
                int resultado = leerResultados(ficherosResultado[i]);
                total += resultado;
            }

            escribirResultadoFinal(total);
            System.out.println("Se ha guardado el resultado total en el archivo resultadoTotal.txt, dentro de la carpeta Ejercicio2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
