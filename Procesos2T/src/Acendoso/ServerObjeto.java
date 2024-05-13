package Acendoso;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerObjeto {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] arg) throws Exception, ClassNotFoundException {
		int numeroPuerto = 6000;// Puerto
		ServerSocket servidor = new ServerSocket(numeroPuerto);
		System.out.println("Esperando al cliente.....");
		Socket cliente = servidor.accept();

		// Se prepara un flujo de salida para objetos
		//ObjectOutputStream salidaObjeto = new ObjectOutputStream(cliente.getOutputStream());
		// Se prepara un objeto y se envía
		//Persona per = new Persona("Juan", 20);
		
		//salidaObjeto.writeObject(per);
		// enviando objeto
		System.out.println("Envio: " + per.getNombre() + "*" + per.getEdad());
		// Se obtiene un stream para leer objetos
		
		ObjectInputStream llegadaObjeto = new ObjectInputStream(cliente.getInputStream());
		
		//Persona dato = (Persona) llegadaObjeto.readObject();
		
		
		modificarPersona(dato);
		//System.out.println("Recibo: " + dato.getNombre() + "*" + dato.getEdad());
		// CERRAR STREAMS Y SOCKETS

		System.out.println("Recibido"+dato.toString());
		salidaObjeto.close();
		llegadaObjeto.close();
		cliente.close();
		servidor.close();
	}// Fin de main

	public static void calculaCuenta(Persona p) {

		System.out.println("Datos de la persona recibida");

		System.out.println(p.toString());

		System.out.println("Nombre recibido"+p.getNombre());
		String nombre = sc.nextLine();
		System.out.println("Edad de la persona recibida"+p.getEdad());
		int edad = sc.nextInt();
		p.setEdad(edad);
		p.setNombre(nombre);


	}
}
