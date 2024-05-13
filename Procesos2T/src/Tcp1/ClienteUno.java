package Tcp1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClienteUno {

	public static void main(String[] args) throws Exception {
		//String host = "localhost";
		
		
		InetAddress i =InetAddress.getByName("10.101.19.19");

		int puerto = 6000;// puerto remoto
		System.out.println("PROGRAMA CLIENTE INICIADO....");
		Socket cliente = new Socket(i, puerto);
		// CREO FLUJO DE SALIDA AL SERVIDOR
		DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
		Thread.sleep(5000);
		// ENVIO UN SALUDO AL SERVIDOR
		flujoSalida.writeUTF("SaludOS al SERVIDOR DESDE EL	CLIENTE");
		// CREO FLUJO DE ENTRADA AL SERVIDOR
		DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
		// EL SERVIDOR ME ENVIA UN MENSAJE
		System.out.println("Recibiendo del SERVIDOR: \n\t" + flujoEntrada.readUTF());
		// CERRAR STREAMS Y SOCKETS
		flujoEntrada.close();
		flujoSalida.close();
		cliente.close();
	}// fin de main
}
