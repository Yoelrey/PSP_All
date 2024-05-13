package Tcp2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Server1 {
public static void main(String[] arg) throws IOException {
		
		
		Scanner sc = new Scanner(System.in);
		
		int numPuerto = 6000;// Puerto
		ServerSocket servidor = new ServerSocket(numPuerto);
		Socket clienteConectado = null;
		System.out.println("Esperando al cliente.....");
		clienteConectado = servidor.accept();
		
				
		//creo Flujo de salida del cliente
		PrintWriter fsalida= new PrintWriter(clienteConectado.getOutputStream(),true);
		
		//Creo flujo de entrada del cliente 
		BufferedReader fentrada= new BufferedReader(new InputStreamReader(clienteConectado.getInputStream()));
		
		
		String cad="";
	
		
		
		
		while((cad=fentrada.readLine())!=null) {
			//Logica de servidor
			cad=sc.nextLine();
		fsalida.println(respondeChat(cad));
		if (cad.equals("*"))break;
		}
		
		System.out.println("Cerrando conexion ...");
		fentrada.close();
		fsalida.close();
		clienteConectado.close();
		servidor.close();
	}// main
public static String respondeChat(String cad) {
	
	Scanner sc = new Scanner( System.in );
	
	System.out.println("Introduce una cadenna:");

	
	cad = sc.nextLine();
	while (cad!= null) {
		
		System.out.println("=>ECO: " +cad);
		System.out.println("Introduce una cadena: ");
		cad = sc.nextLine();
		if (cad.equals("*"))			break;
	}
	return cad;
}



}
