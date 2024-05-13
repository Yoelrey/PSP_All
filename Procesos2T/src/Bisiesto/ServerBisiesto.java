package Bisiesto;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ServerBisiesto {
	static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		DatagramSocket serverSocket = new DatagramSocket(9876);
		byte[] recibidos = new byte[1024];
		byte[] enviados = new byte[1024];
		boolean corta=false;
		String cadena;

		while (!corta) {
		    System.out.println("Arrancando server Bisiesto.....");
		    // RECIBO DATAGRAMA
		    recibidos = new byte[1024];
		    DatagramPacket paqRecibido = new DatagramPacket(recibidos, recibidos.length);
		    serverSocket.receive(paqRecibido);
		    cadena = new String(paqRecibido.getData());
		    
		    // DIRECCION ORIGEN
		    InetAddress IPOrigen = paqRecibido.getAddress();
		    int puerto = paqRecibido.getPort();
		    System.out.println("\tOrigen: " + IPOrigen + " - Puerto: " + puerto);
		   
		    // CONVERTIR CADENA A MAYUSCULA
		    String mayuscula = comprobarBisiesto(cadena);
		    enviados= new byte[1024];
		    enviados = mayuscula.getBytes();
		    
		    // ENVIO DATAGRAMA AL CLIENTE
		    DatagramPacket paqEnviado = new DatagramPacket(enviados, enviados.length, IPOrigen, puerto);
		    serverSocket.send(paqEnviado);
		    // para terminar
		    if (cadena.trim().equals("quit")) corta=true;

		    
	}
		serverSocket.close();
	    System.out.println("Socket cerrado...");
}
	
	
	public static String comprobarBisiesto(String cad) {
		
		System.out.println("Año recibido: "+cad);
		int dato= Integer.parseInt(cad.trim());
		String respuesta;
		if((dato%400==0 || dato%4==0)&& (dato%100!=0)) {
			respuesta="Es bisiesto";
		}
		else
		respuesta= "NO es bisiesto";
		return respuesta;
	}
	
	
}
	

