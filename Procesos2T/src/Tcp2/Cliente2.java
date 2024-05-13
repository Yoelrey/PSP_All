package Tcp2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente2 {
	public static void main(String[] args) throws Exception {
		// String host = "localhost";

		InetAddress i = InetAddress.getByName("10.101.19.19");

		int puerto = 6000;// puerto remoto
		System.out.println("PROGRAMA CLIENTE INICIADO....");
		Socket cliente = new Socket(i, puerto);

		// creo Flujo de salida del cliente
		PrintWriter fsalida = new PrintWriter(cliente.getOutputStream(), true);

		// Creo flujo de entrada del cliente
		BufferedReader fentrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		String cadena, eco = "";
		System.out.println("Introduce una cadena de mas de 5 palabras:");
		cadena = sc.nextLine();
		while (cadena != null) {
			fsalida.print(cadena);
			eco = fentrada.readLine();
			System.out.println("=>ECO: " + eco);
			System.out.println("Introduce una cadena: ");
			cadena = sc.nextLine();
			if (cadena.equals("*"))
				break;
		}

		System.out.println("Recibiendo del SERVIDOR: \n\t" + fentrada.read());
		// CERRAR STREAMS Y SOCKETS
		fsalida.close();
		fentrada.close();
		cliente.close();
	}// fin de main
	
	
}
