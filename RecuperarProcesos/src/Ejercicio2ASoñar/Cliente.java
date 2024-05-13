package Ejercicio2ASoñar;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Esta clase Cliente envía al servidor dos números separados por un espacio a través de DatagramSocket.
 */
public class Cliente {

    public static void main(String[] args) throws SocketException {

        Scanner sc = new Scanner(System.in); // Se crea un objeto Scanner para la entrada de datos
        int puertoServidor = 12345; // Puerto del servidor al que se conectará el cliente
        InetAddress host = null;
        try {
            host = InetAddress.getLocalHost(); // Se obtiene la dirección IP del localhost
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        String numerosStr = "";
        DatagramSocket socketCliente = new DatagramSocket(3456); // Se crea un DatagramSocket en el puerto 3456 del cliente

        while (!numerosStr.equals("*")) {
            System.out.println("Escribe dos números separados por un espacio: Ej -> 220 284. Escribe * para cerrar la conexión.");
            numerosStr = sc.nextLine(); // Se solicita al usuario ingresar los dos números

            int longitud = numerosStr.split(" ").length; // Se verifica que se hayan ingresado dos números separados por un espacio
            byte[] mensaje = new byte[2048];

            if (longitud != 2) {
                System.out.println("No sirve. Deben ser solo dos números.");
            } else {
                mensaje = numerosStr.getBytes(); // Se convierte la cadena de números en bytes
                DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, host, puertoServidor); // Se crea un DatagramPacket para enviar los datos al servidor

                try {
                    socketCliente.send(envio); // Se envían los datos al servidor
                    System.out.println("Datagram enviado: " + numerosStr);

                    byte[] paqueteRecibido = new byte[2048];
                    DatagramPacket recibo = new DatagramPacket(paqueteRecibido, paqueteRecibido.length);

                    socketCliente.receive(recibo); // Se recibe la respuesta del servidor
                    String resultado = new String(recibo.getData()); // Se convierte la respuesta a una cadena de texto
                    System.out.println("HEMOS RECIBIDO DEL SERVIDOR: " + resultado.trim()); // Se muestra la respuesta recibida

                    envio = null;

                } catch (IOException e) {
                    break;
                }
            }
        }

        System.out.println("Cerrada la conexión con el servidor");
        socketCliente.close(); // Se cierra el DatagramSocket del cliente
    }
}