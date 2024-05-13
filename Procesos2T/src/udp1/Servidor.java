package udp1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servidor {

	public static void main(String[] args) throws Exception {
		
		byte []bufer= new byte[1024];
		DatagramSocket socket= new DatagramSocket(12345);

		System.out.println("Esperando datagrama...");
		DatagramPacket recibido= new DatagramPacket(bufer, bufer.length);
		socket.receive(recibido);
		int bytesRec= recibido.getLength();
		
	}
}
