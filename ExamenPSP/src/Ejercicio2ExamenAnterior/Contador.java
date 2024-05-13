package Ejercicio2ExamenAnterior;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Contador {

    public static int contarLetras(String archivoEntrada, String letra) {
        // Inicializar la variable que almacenará el resultado (cantidad de veces que aparece la letra)
        int resultado = 0;

        // Crear un objeto de tipo File para el archivo de entrada
        File archivo = new File(".\\src\\Ejercicio2ExamenAnterior\\" + archivoEntrada);

        try {
            // Crear un BufferedReader para leer el archivo de entrada
            BufferedReader bf = new BufferedReader(new FileReader(archivo));

            String linea;
            String[] letrasLinea;

            // Leer cada línea del archivo
            while ((linea = bf.readLine()) != null) {
                // Dividir la línea en un array de letras
                letrasLinea = linea.split("");

                // Iterar sobre el array de letras y contar la ocurrencia de la letra especificada
                for (int i = 0; i < letrasLinea.length; i++) {
                    if (letrasLinea[i].equals(letra)) {
                        resultado++;
                    }
                }
            }

            // Cerrar el BufferedReader
            bf.close();

            // Devolver el resultado (cantidad de veces que aparece la letra)
            return resultado;

        } catch (IOException e) {
            // Imprimir información de la excepción en caso de error de lectura del archivo
            e.printStackTrace();
        }

        // En caso de excepciones o problemas, devolver 0
        return 0;
    }

    public static void escribirEnFichero(String archivoSalida, int resultado, String letra) {
        try {
            // Crear un BufferedWriter para escribir en el archivo de salida
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida));

            // Crear un objeto de tipo File para el archivo de salida
            File archivo = new File(".\\src\\Ejercicio2ExamenAnterior\\" + archivoSalida);

            // Convertir el resultado a una cadena y escribirlo en el archivo junto con la letra
            String linea = "La letra '" + letra + "' aparece " + resultado + " veces.";
            bw.append(linea);

            // Cerrar el BufferedWriter
            bw.close();

        } catch (IOException e) {
            // Imprimir información de la excepción en caso de error al escribir en el archivo de salida
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Obtener los nombres de los archivos de entrada y salida, así como la letra a contar
        String archivoEntrada = args[0];
        String letra = args[1];
        String archivoSalida = args[2];

        // Calcular la cantidad de veces que aparece la letra en el archivo de entrada
        int resultado = contarLetras(archivoEntrada, letra);

        // Escribir el resultado en el archivo de salida
        escribirEnFichero(archivoSalida, resultado, letra);
    }
}
