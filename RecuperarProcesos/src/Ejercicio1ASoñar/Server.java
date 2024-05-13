package Ejercicio1ASoñar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Esta clase Server espera la conexión de un cliente en el puerto 6000.
 * Recibe frases del cliente, elimina las vocales y devuelve las consonantes.
 */
public class Server {

    public static void main(String[] args) throws Exception {

        int numPort = 6000; // Puerto
        ServerSocket servidor = new ServerSocket(numPort);
        Socket cliente = null;
        System.out.println("Esperando al cliente.....");
        cliente = servidor.accept();

        // Flujo de salida
        PrintWriter ficheroSalida = new PrintWriter(cliente.getOutputStream(), true);

        // Flujo de entrada
        BufferedReader ficheroEntrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

        String cadena;
        String[] cadenaArray;

        while ((cadena = ficheroEntrada.readLine()) != null) {
            System.out.println("Recibido del cliente: " + cadena);
            cadenaArray = cadena.split("");
            ficheroSalida.println(devolverConsonantes(cadenaArray));
        }

        System.out.println("Conexión cerrada.");

        // Cerrar flujos y sockets
        ficheroSalida.close();
        ficheroEntrada.close();
        cliente.close();
        servidor.close();
    }

    /**
     * Método para devolver las consonantes de una cadena de texto.
     *
     * @param cadena Array de caracteres a procesar
     * @return Cadena resultante sin vocales
     */
    public static String devolverConsonantes(String[] cadena) {
        String vocales = "aeiou";
        StringBuilder total = new StringBuilder();
        
        for (String c : cadena) {
            if (!vocales.contains(c)) {
                total.append(c);
            }
        }
        
        return total.toString();
    }
}
