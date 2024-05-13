package MulticastTiempo;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ClienteMC {

	public static void main(String args[]) throws Exception {
		// Se crea el socket multicast
		int Puerto = 12345;// Puerto multicast
		MulticastSocket ms = new MulticastSocket(Puerto);
		InetAddress grupo = InetAddress.getByName("225.0.0.1");// Grupo
		// Nos unimos al grupo
		ms.joinGroup(grupo);
		String msg = "";
		while (!msg.trim().equals("quit")) {
			// Recibe el paquete del servidor multicast
			byte[] buf = new byte[1024]; // Genero dentro el buffer para que se sobreescriba al enviar un nuevo mensaje
			DatagramPacket paquete = new DatagramPacket(buf, buf.length);
			ms.receive(paquete);
			msg = new String(paquete.getData());
			System.out.println("Recibo: " + msg.trim());
		} // Fin de while
		ms.leaveGroup(grupo); // abandonamos grupo
		// cierra socket
		ms.close();
		System.out.println("Socket cerrado...");
	}// Fin de main
}