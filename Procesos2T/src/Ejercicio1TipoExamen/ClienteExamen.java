package Ejercicio1TipoExamen;

// ClienteExamen.java

// Importa las clases necesarias para entrada/salida y networking
import java.io.*;
import java.net.*;

public class ClienteExamen {
    public static void main(String[] args) throws IOException {
        // Crea un socket y se conecta al servidor en localhost en el puerto 1234
        Socket socket = new Socket("localhost", 1234);

        // Crea un PrintWriter para enviar datos al servidor
        PrintWriter enviarServer = new PrintWriter(socket.getOutputStream(), true);

        // Crea un BufferedReader para recibir datos del servidor
        BufferedReader recibirServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Crea un BufferedReader para leer la entrada del usuario desde la consola
        BufferedReader leerEntrdaConsola = new BufferedReader(new InputStreamReader(System.in));

        // Variable para almacenar la entrada del usuario
        String userInput;

        // Bucle que se ejecuta mientras el usuario sigue ingresando datos desde la consola
        while ((userInput = leerEntrdaConsola.readLine()) != null) {
            // Envía la entrada del usuario al servidor
            enviarServer.println(userInput);

            // Imprime la respuesta del servidor (asumiendo que devuelve el día de la semana)
            System.out.println("Day of week: " + recibirServer.readLine());
        }

        // Cierra los flujos y el socket cuando el bucle termina
        enviarServer.close();
        recibirServer.close();
        leerEntrdaConsola.close();
        socket.close();
    }
}
