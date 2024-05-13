package udpIntro;

import java.net.DatagramPacket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		
	Socket socket= new Socket ();
	byte[] bufer = new byte[1024];
	DatagramPacket recibido= new DatagramPacket(bufer, bufer.length);
	
	int bytesRec = recibido.getLength();
	String paquete = new String(recibido.getData());
	System.out.println("Numero de bytes recibidos:" + bytesRec); 
	System.out.println("Contenido del paquete: "+ paquete.trim());
	System.out.println("puerto origen del mensaje"+recibido.getPort());
	System.out.println("Ip de origen "+ recibido.getAddress().getHostAddress());
	
	
	
	
	}
}
