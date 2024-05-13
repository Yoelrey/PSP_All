package Ejercicio2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Launcher {
	
	
	static final int NUM_PROCESOS=3;
	static final String prefijo= "Mayuscula";
	
	public static void lanzarSumador(String n1,String n2,String n3, String fichResultados) throws IOException{
		String comando = "ContarConsonantes.java";
		File dirSumador= new File("C:\\Users\\Yoel Rey Vidal\\eclipse-workspace\\ExamenPSP\\adjA\\");
		File fichResultado = new File(fichResultados);
	
	
		
		ProcessBuilder pb = new ProcessBuilder("java", comando,String.valueOf(n1),String.valueOf(n2),String.valueOf(n3));
		 pb.directory(dirSumador);
	        pb.redirectOutput(fichResultado);
	        pb.redirectError(new File("errores.txt"));
	        pb.start();
	}

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
	
	public static int getSumaTotal(int numFicheros) {
        int sumaTotal = 0;
        for (int i = 1; i <= NUM_PROCESOS; i++) {
            sumaTotal += getResultadoFichero(prefijo + String.valueOf(i));
        }
        return sumaTotal;
    }
	
	
	public static void main(String[] args) throws IOException,InterruptedException{
		String n1 =args[0];
        String n2 = args[1];
        String n3 = args[2];
      
        for (int i = 1; i <= NUM_PROCESOS; i++) {
            System.out.println("n1:" + n1);
            String  resultadoSumaConSalto = n1;
            System.out.println("n2:" + resultadoSumaConSalto);
            lanzarSumador(n1, n2 , prefijo + String.valueOf(i), n3);
            n1 = n1  + 1;
            System.out.println("Suma lanzada...");
            
        }
        Thread.sleep(5000);

        // Calcular la suma total de los resultados de los procesos
        int sumaTotal = getSumaTotal(NUM_PROCESOS);
        System.out.println("La suma total es:" + sumaTotal);

        // Guardar el resultado total en un archivo
        File resTotal = new File("resultado_fichero");
        FileWriter fw = new FileWriter(resTotal, true);
        fw.append("el resultado total es: " + sumaTotal);
        fw.close();
        System.out.println("resultado guardado en " + resTotal.getName());
        
        
	}
}
