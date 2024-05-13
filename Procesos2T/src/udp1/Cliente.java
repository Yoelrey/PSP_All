package udp1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {

	public static void main(String[] args) throws Exception {
		InetAddress destino = InetAddress.getLocalHost();
		
		byte[]mensaje= new byte[1024];
		
		String saludo = "hola pesada";
		mensaje= saludo.getBytes();
		
		DatagramPacket envia= new DatagramPacket(mensaje, mensaje.length);
		DatagramSocket socket= new DatagramSocket(34567);
		
		
		socket.send(envia);
		socket.close();
	}
	
}
