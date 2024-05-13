package Ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Contador {

    public static int contarLetras(String archivoEntrada, String letra) {
        int resultado = 0;

        File archivo = new File(".\\src\\Ejercicio2\\" + archivoEntrada);

        try {
            BufferedReader bf = new BufferedReader(new FileReader(archivo));

            String linea;
            String[] letrasLinea;

            while ((linea = bf.readLine()) != null) {
                letrasLinea = linea.split("");

                for (int i = 0; i < letrasLinea.length; i++) {
                    if (letrasLinea[i].equals(letra)) {
                        resultado++;
                    }
                }
            }

            bf.close();

            return resultado;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static void escribirEnFichero(String archivoSalida, int resultado, String letra) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida));

            File archivo = new File(".\\src\\Ejercicio2\\" + archivoSalida);

            String linea = "La letra '" + letra + "' aparece " + resultado + " veces.";
            bw.append(linea);

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String archivoEntrada = args[0];
        String letra = args[1];
        String archivoSalida = args[2];

        int resultado = contarLetras(archivoEntrada, letra);

        escribirEnFichero(archivoSalida, resultado, letra);
    }
}
