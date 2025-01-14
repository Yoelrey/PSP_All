package ChatGraficoQuePreguntaraNoGrafico;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class HiloServidor extends Thread {

	DataInputStream fentrada;
	Socket socket = null;

	public HiloServidor(Socket s) {
		socket = s;
		try {
			// CREO FLUJO DE ENTRADA
			fentrada = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			System.out.println("ERROR DE E/S");
			e.printStackTrace();
		} //

	}// constr
	
	@SuppressWarnings("unlikely-arg-type")
	public void run() {
		Servidor.mensaje.setText("NUMERO DE CONEXIONES ACTUALES: " + Servidor.ACTUALES);
		// NADA MAS CONECTARSE EL CLIENTE LE ENVIO TODOS LOS MENSAJES
		String texto = Servidor.textarea.getText();
		EnviarMensajes(texto);

		while (true) {
			String cadena = "";
			try {
				cadena = fentrada.readUTF();
				// lee lo que el cliente escribe
				// cuando un cliente finaliza envia un *
				if (cadena.trim().equals("quit")) {
					Servidor.ACTUALES--;
					Servidor.mensaje.setText("NUMERO DE CONEXIONES ACTUALES: " + Servidor.ACTUALES);
					//remove socket del array dinamico
					Servidor.tabula.remove(this);
					break;
				}
				// salir del while

				Servidor.textarea.append(cadena + "\n");
				texto = Servidor.textarea.getText();
				EnviarMensajes(texto);
				// envio texto a todos los clientes
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		} // fin while
	}// run
	
	// ENVIA LOS MENSAJES DEL TEXTAREA A LOS CLIENTES DEL CHAT
		private void EnviarMensajes(String texto) {
			int i;
			// recorremos tabla de sockets para enviarles los mensajes
			for (i = 0; i < Servidor.CONEXIONES; i++) {
				//ojo el socket esta en un array dianmico
				Socket si = Servidor.tabula.get(i);
				// obtener socket
				try {
					DataOutputStream fsalida = new DataOutputStream(si.getOutputStream());
					fsalida.writeUTF(texto);
					// escribir en el socket el texto
				} catch (SocketException se) {
					// esta excepción oc           aswwqewsaq1	56urre cuando escribimos en un socket
					// de un cliente que ha finalizado
				} catch (IOException e) {
					e.printStackTrace();
				}
			} // for
		}// EnviarMensajes
	
 }                                                               