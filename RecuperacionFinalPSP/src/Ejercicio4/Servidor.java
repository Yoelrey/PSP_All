package Ejercicio4;

import java.io.DataInputStream;

import java.io.DataOutputStream;

import java.io.IOException;

import java.io.InputStream;

import java.io.OutputStream;

import java.net.ServerSocket;

import java.net.Socket;

public class Servidor {

	public static void main(String[] arg) throws IOException {

		int puerto = 6000;
		Socket socket = null;
		ServerSocket servidor = new ServerSocket(puerto);
		System.out.println("Esperando al cliente.....");
		socket = servidor.accept();
		InputStream entrada = null;
		entrada = socket.getInputStream();

		DataInputStream fEntrada = new DataInputStream(entrada);
		String mensajeCliente = fEntrada.readUTF();
		System.out.println("Recibiendo del CLIENTE: \n\t" + mensajeCliente);

		String respuesta = esPalindromo(mensajeCliente);
		OutputStream salida = socket.getOutputStream();
		DataOutputStream fSalida = new DataOutputStream(salida);
		fSalida.writeUTF(respuesta);
		
		entrada.close();
		fEntrada.close();
		salida.close();
		fSalida.close();
		socket.close();
		servidor.close();

	}

	public static String esPalindromo(String cad) {

		cad = cad.replaceAll(" ", "");
		int izquierda = 0;
		int derecha = cad.length() - 1;

		while (izquierda < derecha) {
			if (cad.charAt(izquierda) != cad.charAt(derecha)) {
				return "No es una palindroma la frase introducida";
			}
			izquierda++;
			derecha--;
		}

		return "Es una palindroma la frase introducida";

	}

}