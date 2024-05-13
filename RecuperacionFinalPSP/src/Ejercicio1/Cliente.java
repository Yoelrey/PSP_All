package Ejercicio1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Cliente {

    public static void main(String[] args) throws SocketException {

        Scanner sc = new Scanner(System.in); 
        int puertoServidor = 12345; 
        InetAddress host = null;
        try {
            host = InetAddress.getLocalHost(); 
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        String numeroCad = "";
        DatagramSocket socketCliente = new DatagramSocket(3456); 

        while (!numeroCad.equals("*")) {
            System.out.println("Escribe un numero mayor a 100");
            numeroCad = sc.nextLine(); 

            byte[] mensaje = new byte[1024];

            if (numeroCad.length() <=2) {
                System.out.println("No sirve.Debe ser mayor a cien");
            } else {
                mensaje = numeroCad.getBytes(); 
                DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, host, puertoServidor); 

                try {
                    socketCliente.send(envio); 
                    System.out.println("Datagram enviado: " + numeroCad);

                    byte[] paqueteRecibido = new byte[1024];
                    DatagramPacket recibo = new DatagramPacket(paqueteRecibido, paqueteRecibido.length);

                    socketCliente.receive(recibo); 
                    String resultado = new String(recibo.getData());
                    System.out.println("HEMOS RECIBIDO DEL SERVIDOR: " + resultado.trim()); 

                    envio = null;

                } catch (IOException e) {
                    break;
                }
            }
        }

        System.out.println("Cerrada la conexión con el servidor");
        socketCliente.close(); 
    }
}