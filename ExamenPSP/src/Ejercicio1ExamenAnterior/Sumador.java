package Ejercicio1ExamenAnterior;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Sumador {

    public static int sumarCantidades(String nombreFichero, String minimo) {
        // Convertir el valor mínimo a un entero
        int minimoNum = Integer.parseInt(minimo);

        // Crear un objeto de tipo File para el archivo de entrada
        File archivo = new File(".\\src\\ejercicio1A", nombreFichero);

        // Inicializar la variable que almacenará la suma de las cantidades mayores al mínimo
        int resultado = 0;
        String linea;
        int aux;

        try {
            // Crear un BufferedReader para leer el archivo de entrada
            BufferedReader br = new BufferedReader(new FileReader(archivo));

            // Leer cada línea del archivo
            while ((linea = br.readLine()) != null) {
                // Convertir la línea a un entero
                aux = Integer.parseInt(linea);

                // Sumar la cantidad solo si es mayor que el valor mínimo
                if (aux > minimoNum) {
                    resultado += aux;
                }
            }

            // Cerrar el BufferedReader
            br.close();

            // Devolver el resultado de la suma
            return resultado;

        } catch (FileNotFoundException e) {
            // Imprimir información de la excepción en caso de que el archivo no sea encontrado
            e.printStackTrace();
        } catch (IOException e) {
            // Imprimir información de la excepción en caso de error de lectura del archivo
            e.printStackTrace();
        }

        // En caso de excepciones o problemas, devolver 0
        return 0;
    }

    public static void escribirResultado(String nombreFicheroSalida, int resultado) {
        // Crear un objeto de tipo File para el archivo de salida
        File archivoSalida = new File(".\\src\\ejercicio1A", nombreFicheroSalida);

        try {
            // Crear un BufferedWriter para escribir en el archivo de salida
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida, true));

            // Convertir el resultado a una cadena y escribirlo en el archivo
            String linea = String.valueOf(resultado);
            bw.append(linea);

            // Cerrar el BufferedWriter
            bw.close();

        } catch (IOException e) {
            // Imprimir información de la excepción en caso de error al escribir en el archivo de salida
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Obtener los nombres de los archivos y el valor mínimo desde los argumentos de la línea de comandos
        String ficheroEntrada = args[0];
        String minimo = args[1];
        String ficheroSalida = args[2];

        // Calcular la suma de cantidades mayores al valor mínimo
        int resultado = sumarCantidades(ficheroEntrada, minimo);

        // Escribir el resultado en el archivo de salida
        escribirResultado(ficheroSalida, resultado);
    }
}
