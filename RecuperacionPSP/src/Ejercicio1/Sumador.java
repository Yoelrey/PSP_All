package Ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Sumador {

    public static int sumarCantidades(String nombreFichero, String minimo,String maximo) {
        int minimoNum = Integer.parseInt(minimo);
        int maximoNum= Integer.parseInt(maximo);

        File archivo = new File(".\\src\\Ejercicio1", nombreFichero);

        int resultado = 0;
        String linea;
        int aux;

        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));

            while ((linea = br.readLine()) != null) {
                aux = Integer.parseInt(linea);

                if (aux > minimoNum && aux<maximoNum) {
                    resultado += aux;
                }
            }

            br.close();

            return resultado;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static void escribirResultado(String nombreFicheroSalida, int resultado) {
        File archivoSalida = new File(".\\src\\Ejercicio1", nombreFicheroSalida);

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida, true));

            String linea = String.valueOf(resultado);
            bw.append(linea);

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String ficheroEntrada = args[0];
        String minimo = args[1];
        String maximo = args [2];
        String ficheroSalida = args[3];

        int resultado = sumarCantidades(ficheroEntrada, minimo,maximo);

        escribirResultado(ficheroSalida, resultado);
    }
}
