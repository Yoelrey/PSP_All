package Ejercicio4ASoñar;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * La clase MCastClient se conecta al servidor multicast para recibir mensajes del grupo.
 */
public class MCastClient {

    public static void main(String args[]) throws Exception {
        int Puerto = 12345; // Puerto multicast
        MulticastSocket ms = new MulticastSocket(Puerto); // Socket multicast
        InetAddress grupo = InetAddress.getByName("225.0.0.1"); // Dirección del grupo multicast

        ms.joinGroup(grupo); // Se une al grupo multicast
        String msg = "";

        System.out.println("Cliente conectado al servidor.");

        while (!msg.trim().equals("quit")) {
            byte[] buf = new byte[1024];
            DatagramPacket paquete = new DatagramPacket(buf, buf.length);
            ms.receive(paquete); // Recibe el paquete del servidor
            msg = new String(paquete.getData());
            System.out.println("Recibido: " + msg.trim());
        }

        ms.leaveGroup(grupo); // Abandona el grupo multicast
        System.out.println("Has abandonado el grupo.");
        
        ms.close(); // Cierra el socket multicast
        System.out.println("Socket cerrado...");
    }
}
