package Ejercicio4;

import java.io.DataInputStream;

import java.io.DataOutputStream;

import java.net.Socket;

import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws Exception {

		String host = "localhost";
		int puerto = 6000;
		Socket cliente = new Socket(host, puerto);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("PROGRAMA CLIENTE INICIADO....");
		
			
		
		
		String frase ="";
		while(!frase.equals("*")) {
			System.out.print("Introduce una frase de mas de tres palabras: ");
		frase=sc.nextLine();
		if(frase.length()<=2) {
            System.out.println("No sirve.Debe tener mas de tres palabras");
	
		}else {
			DataInputStream entrada = new DataInputStream(cliente.getInputStream());
			System.out.println("Recibiendo del SERVIDOR: \n" + entrada.readUTF());
			
		}
		
		cliente.close();
		sc.close();
		}

	}

}