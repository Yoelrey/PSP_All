package EjercicioTipoExamen;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

// Se suma de 0 a 1000
public class Launcher {

    // Número de procesos que se lanzarán para la suma distribuida
    static final int NUM_PROCESOS = 4;
    
    // Prefijo para los nombres de los archivos de resultados
    static final String prefijo = "teta";

    // Método para lanzar un sumador en un proceso separado
    public static void lanzarSumador(int n1, int n2, String fichResultados) throws IOException {
        // Comando para ejecutar el sumador
        String comando = "Sumador.java";

        // Directorio donde se encuentra el sumador
        File dirSumador = new File("C:\\Users\\Yoel Rey Vidal\\eclipse-workspace\\Procesos\\src\\EjercicioTipoExamen\\");
        File fichResultado = new File(fichResultados);

        // Configurar el proceso que ejecutará el sumador
        ProcessBuilder pb = new ProcessBuilder("java", comando, String.valueOf(n1), String.valueOf(n2));
        pb.directory(dirSumador);
        pb.redirectOutput(fichResultado);
        pb.redirectError(new File("errores.txt"));
        pb.start();
    }

    // Método para obtener el resultado de un archivo
    public static int getResultadoFichero(String nombreFichero) {
        int suma = 0;
        try {
            FileInputStream fichero = new FileInputStream(nombreFichero);
            InputStreamReader fir = new InputStreamReader(fichero);
            BufferedReader br = new BufferedReader(fir);
            // Solo lee una línea
            String linea = br.readLine();
            suma = Integer.parseInt(linea);
            return suma;
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo abrir " + nombreFichero);
        } catch (IOException e) {
            System.out.println("No hay nada en " + nombreFichero);
        }
        return suma;
    }

    // Método para obtener la suma total de los resultados de los archivos generados por los procesos
    public static int getSumaTotal(int numFicheros) {
        int sumaTotal = 0;
        for (int i = 1; i <= NUM_PROCESOS; i++) {
            sumaTotal += getResultadoFichero(prefijo + String.valueOf(i));
        }
        return sumaTotal;
    }

    // Método principal
    public static void main(String[] args) throws IOException, InterruptedException {
        // Obtener los argumentos de la línea de comandos (números de inicio y fin para la suma)
        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[1]);

        // Calcular el salto para dividir la suma en varios procesos
        int salto = (n2 / NUM_PROCESOS) - 1;

        // Lanzar varios procesos para realizar la suma distribuida
        for (int i = 1; i <= NUM_PROCESOS; i++) {
            System.out.println("n1:" + n1);
            int resultadoSumaConSalto = n1 + salto;
            System.out.println("n2:" + resultadoSumaConSalto);
            lanzarSumador(n1, n1 + salto, prefijo + String.valueOf(i));
            n1 = n1 + salto + 1;
            System.out.println("Suma lanzada...");
        }

        // Dormir el hilo principal (main) por medio segundo
        Thread.sleep(5000);

        // Calcular la suma total de los resultados de los procesos
        int sumaTotal = getSumaTotal(NUM_PROCESOS);
        System.out.println("La suma total es:" + sumaTotal);

        // Guardar el resultado total en un archivo
        File resTotal = new File("resultado fichero");
        FileWriter fw = new FileWriter(resTotal, true);
        fw.append("el resultado total es: " + sumaTotal);
        fw.close();
        System.out.println("resultado guardado en " + resTotal.getName());
    }
}
