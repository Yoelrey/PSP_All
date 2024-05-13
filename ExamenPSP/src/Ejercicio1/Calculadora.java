package Ejercicio1;


//Los resultados van a quedar almacenados en el fichero gastosTotales.text
//Los parametros de entrada se pasaran por argumento

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Calculadora {
public static void hacerCalculos(String fichEntrada,String fichSalida, String minimo) throws IOException{
       
       int suma = 0;
       //1 abrir el fichero informatica.txt
       ArrayList<String>cantidades = getLineasFichero(fichEntrada);
       //2 sumar las cantidades de dicho fichero
       int minimoInt = Integer.parseInt(minimo);
       int aux = 0;
       for(String s:cantidades) {
          
          aux = Integer.parseInt(s);
       
             if (aux >= minimoInt) {
                suma += aux;
             }
          
       }
       System.out.println("el total de gastos de: "+fichEntrada+" es: "+suma+" €");
       //3 guardar el resultado numerico en un fichero llamado totalinformatica.txt
       PrintWriter pw = getPrintWriter(fichSalida);
       pw.println(suma);
       pw.close();
       
    }
    public static void main(String[] args) {
       String ent,sal;
       Scanner jaime = new Scanner(System.in);
       System.out.println("fichero de entrada: " ); 
       ent=args[0];//jaime.nextLine();args[0]
       
       System.out.println("fichero de salida: ");
       sal=args[1];//jaime.nextLine();args[1]
       
    
       String minimo = args[2];
       try {
          hacerCalculos(ent,sal, minimo);
       } catch (IOException e) {
          e.printStackTrace();
       }
    }
    public static PrintWriter getPrintWriter(String nombreFichero) throws IOException {
       PrintWriter printWriter;
       FileWriter fileWriter;
       fileWriter = new FileWriter(nombreFichero);
       printWriter = new PrintWriter(fileWriter);
       return printWriter;
    }
    public static BufferedReader getBufferedReader(String nombreFichero) throws FileNotFoundException {
       FileReader lector;
       lector = new FileReader(nombreFichero);
       BufferedReader bufferedReader;
       bufferedReader = new BufferedReader(lector);
       return bufferedReader;
    }
    public static ArrayList<String> getLineasFichero(String nombreFichero) throws IOException {
       ArrayList<String> lineas = new ArrayList<String>();
       BufferedReader bfr = getBufferedReader(nombreFichero);
       // Leemos líneas del fichero...
       String linea = bfr.readLine();
       while (linea != null) {
          // Y las añadimos al array
          lineas.add(linea);
          linea = bfr.readLine();
       }
       // Fin del bucle que lee líneas
       return lineas;
    
    }
    
}
    
