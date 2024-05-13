package Ejemplo6;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Launcher {

    // Hay que lanzar la calculadora por cada fichero
    public static void main(String[] args) throws InterruptedException {

        // Lista de nombres de ficheros de entrada
        String[] nombreFicheros = { "informatica.txt", "gerencia.txt", "rrhh.txt", "contabilidad.txt", "comercio.txt" };

        // Obtener la ruta del directorio actual
        String path = System.getProperty("user.dir");
        // Ruta relativa donde se encuentran los ficheros de entrada y salida
        String ruta = "\\src\\ejemplo6\\";
        int total = 0;
        int parcial;
        String minimo = "1000"; // Valor mínimo (parámetro para la Calculadora)
        ProcessBuilder pb;

        // Lanzar la Calculadora para cada fichero
        for (int i = 0; i < nombreFicheros.length; i++) {
            pb = new ProcessBuilder("java", path + ruta + "Calculadora.java", path + "\\src\\" + nombreFicheros[i],
                    "T" + nombreFicheros[i], minimo);
            pb.redirectError(new File("E" + nombreFicheros[i]));
            try {
                pb.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Esperar un tiempo para que los procesos terminen
        Thread.sleep(3000);

        // Recuperar los totales de cada fichero y mostrarlos por pantalla
        // Guardar los gastos totales
        for (int i = 0; i < nombreFicheros.length; i++) {
            try {
                // Obtener el BufferedReader del fichero de salida de la Calculadora
                BufferedReader br = Calculadora.getBufferedReader(path + "\\T" + nombreFicheros[i]);
                // Leer el total parcial del fichero
                parcial = Integer.parseInt(br.readLine());
                // Mostrar el total parcial por pantalla
                System.out.println("gastos" + nombreFicheros[i] + ": " + parcial);
                // Sumar al total general
                total += parcial;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Mostrar el gasto total y guardar en un archivo
        System.out.println("gastos totales: " + total);
        System.out.println("Guardando en gastosTotales.txt......");
        try {
            // Obtener el PrintWriter para escribir en el archivo "gastosTotales.txt"
            PrintWriter pw = Calculadora.getPrintWriter("gastosTotales.txt");
            // Escribir el total en el archivo
            pw.write(String.valueOf(total));
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
