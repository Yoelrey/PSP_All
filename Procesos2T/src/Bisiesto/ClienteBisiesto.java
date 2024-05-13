package Bisiesto;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteBisiesto {
	public static void main(String[] args) throws IOException {
		Scanner sc= new Scanner(System.in);
		int localPort=58500;
		byte[] enviados;
        byte[] recibidos;
        Boolean corta=false;
        // Datos del servidor al que se enviará el mensaje
        InetAddress IpServidor = InetAddress.getLocalHost(); // localhost
        int puerto = 9876; // puerto por el que escucha el servidor
        DatagramSocket clientSocket= new DatagramSocket(localPort);
        System.out.println("Iniciando Cliente Bisiesto");

        while(!corta) {
        	 // Introducir mensaje por teclado
            System.out.print("Introduce año para comprobar: ");
            String cadena = sc.nextLine();
            enviados= new byte[1024];
            enviados = cadena.getBytes();

            // Enviando datagrama al servidor
            System.out.println("Enviando " + enviados.length + " bytes al Servidor.");
            DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IpServidor, puerto);
            clientSocket.send(envio);

            if (cadena.trim().equals("quit")) corta=true;
            // Recibiendo datagrama del servidor
            recibidos= new byte[1024];
            DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
            System.out.println("Esperando datagrama....");
            clientSocket.receive(recibo);

            String mayuscula = new String(recibo.getData()).trim();

            // Obteniendo información del datagrama recibido
            InetAddress origen = recibo.getAddress();
            int puertoOrigen = recibo.getPort();
            System.out.println("Procedente de: " + origen + " puerto " + puertoOrigen);
            System.out.println("Respuesta: " + mayuscula);
        }
       

        clientSocket.close(); // Cerrar socket
	}
}
