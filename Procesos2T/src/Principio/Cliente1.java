package Principio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente1 {
	public static void main(String[] args) throws IOException {

		String host = "localhost";
		int puerto = 6000;// puerto remoto
// ABRIR SOCKET
		//Socket cliente = new Socket(host, puerto);// conecta
		InetAddress i =InetAddress.getByName("10.101.19.19");
		Socket cliente= new Socket(i,puerto);
				
		
		System.out.println("Puerto local: " + cliente.getLocalPort());
		
		System.out.println("Puerto Remoto: " + cliente.getPort());
		
		System.out.println("Host Remoto: " + i.getHostName().toString());
		
		System.out.println("IP Host Remoto: " + i.getHostAddress().toString());
		
		cliente.close();// Cierra el socket
	}// fin de main
}// fin de SocketCliente
