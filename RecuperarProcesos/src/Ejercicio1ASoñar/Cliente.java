package Ejercicio1ASoñar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Esta clase Cliente establece una conexión con un servidor en localhost y puerto 6000.
 * Lee frases del usuario, las envía al servidor y muestra la respuesta recibida.
 */
public class Cliente {

    public static void main(String[] args) throws IOException {

        // Definir el host y puerto del servidor
        String host = "localhost";
        int port = 6000;

        // Iniciar el programa cliente
        System.out.println("PROGRAMA CLIENTE INICIADO....");
        System.out.println("Introduce * para salir");

        // Establecer conexión con el servidor
        Socket cliente = new Socket(host, port);

        // Crear objetos para enviar y recibir datos
        PrintWriter fsalida = new PrintWriter(cliente.getOutputStream(), true);
        BufferedReader fentrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

        // Leer entrada del usuario
        Scanner sc = new Scanner(System.in);
        String cadena = "", eco = "";
        
        // Bucle principal para enviar y recibir datos
        String[] cadenaArray;
        while (cadena != null && cliente.isConnected()) {
            System.out.println("Introduce una frase de cinco palabras: ");
            cadena = sc.nextLine();
            if (cadena.equals("*")) {
                System.out.println("El cliente ha cerrado la conexión.");
                break;
            }
            cadenaArray = cadena.split(" ");
            if (cadenaArray.length < 5) {
                System.out.println("Deben ser al menos cinco palabras. Has escrito: " + cadenaArray.length);
            } else {
                // Enviar la frase al servidor
                fsalida.println(cadena);
                // Recibir la respuesta del servidor
                eco = fentrada.readLine();
                System.out.println("Recibiendo del servidor: " + eco);
            }
        }

        // Cerrar la conexión y los flujos de entrada/salida
        cliente.close();
        fentrada.close();
        fsalida.close();
    }
}