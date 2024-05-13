package Multicast;

import java.net.*;
import java.util.Scanner;

public class ServidorMC {
	public static void main(String args[]) throws Exception {
// FLUJO PARA ENTRADA ESTANDAR
		
		
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner sc = new Scanner(System.in);
//Se crea el socket multicast.
		MulticastSocket ms = new MulticastSocket();
		int Puerto = 12345;// Puerto multicast
		InetAddress grupo = InetAddress.getByName("225.0.0.1");// Grupo
		String cadena = "";
		while (!cadena.trim().equals("*")) {
			System.out.print("Datos a enviar al grupo: ");
			cadena = sc.nextLine();
			System.out.println(ms.getInetAddress());
// ENVIANDO AL GRUPO
			DatagramPacket paquete = new DatagramPacket(cadena.getBytes(), cadena.length(), grupo, Puerto);
			ms.send(paquete);
		} // Fin de while
//cierro socket
		ms.close();
		System.out.println("Socket cerrado...");
	}// Fin de main
}// Fin de ServidorMC
