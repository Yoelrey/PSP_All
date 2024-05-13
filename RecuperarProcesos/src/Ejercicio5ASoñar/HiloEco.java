package Ejercicio5ASoñar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Esta clase HiloEco extiende de Thread y se encarga de manejar la comunicación con un cliente para realizar eco de mensajes.
 */
public class HiloEco extends Thread {

    BufferedReader fentrada; // Flujo de entrada
    PrintWriter fsalida; // Flujo de salida
    Socket socket; // Socket para la conexión

    public HiloEco(Socket s) { // Constructor que recibe un socket como parámetro
        socket = s; // Asigna el socket recibido al socket de la clase

        try {
            fsalida = new PrintWriter(socket.getOutputStream(), true); // Inicializa el flujo de salida
            fentrada = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Inicializa el flujo de entrada
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() { // Método run que define la tarea a realizar con el cliente
        String cadena = "";
        try {
            while ((cadena = fentrada.readLine()) != null && !cadena.trim().equals("*")) {
                System.out.println("Mensaje recibido del cliente: " + cadena.trim()); // Muestra el mensaje recibido del cliente
                String cadenaModificada = cadena.trim().toUpperCase(); // Convierte la cadena a mayúsculas
                System.out.println("Cadena modificada: " + cadenaModificada); // Muestra la cadena modificada
                fsalida.println(cadenaModificada); // Envía la cadena modificada al cliente
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("FIN CON: " + socket.toString()); // Mensaje de finalización con el cliente
        try {
            fsalida.close(); // Cierra el flujo de salida
            fentrada.close(); // Cierra el flujo de entrada
            socket.close(); // Cierra el socket
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
