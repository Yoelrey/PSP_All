package EjercicioExamen;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {
public static void main(String[] args) throws Exception {
	
	
	Scanner sc = new Scanner(System.in);
	DatagramSocket clientSocket= new DatagramSocket();
	
	
	
	
	byte []recibidos = new byte[1024];
	
	InetAddress IPAddress= InetAddress.getLocalHost();
	int puerto = 9876;
	System.out.println("Introduce un año para comprobar: ");
	String cad= sc.nextLine();
	byte []enviados = new byte[1024];
	enviados= cad.getBytes();
	
	//System.out.println("Enviando " + enviados.length+ " bytes del servidor");

	DatagramPacket envio= new  DatagramPacket(enviados, enviados.length,IPAddress,puerto);
	clientSocket.send(envio);
	
	
	
	
	
	DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
	
	System.out.println("Esperando datagrama......");
	clientSocket.receive(recibo);
	String mayuscula = new String(recibo.toString());

	
	InetAddress IPOrigen= recibo.getAddress();
	int puertoOrigen= recibo.getPort();
	System.out.println(mayuscula);
	System.out.println(IPOrigen +" "+ puertoOrigen);
	System.out.println(mayuscula.trim());

	clientSocket.close();
}
}
