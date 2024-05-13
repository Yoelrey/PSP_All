package Acendoso;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteObjeto {
	static Scanner sc= new Scanner(System.in);
	public static void main(String[] arg) throws IOException, ClassNotFoundException {
		

		String host = "localhost";
		int puerto = 6000;// puerto remoto
		
		//Persona per =crearPersona();
		
		System.out.println("PROGRAMA CLIENTE INICIADO....");
		Socket cliente = new Socket(host, puerto);
		// Flujo de entrada para objetos
		//ObjectInputStream perEnt = new ObjectInputStream(cliente.getInputStream());
		// Se recibe un objeto
		//Persona dato = (Persona) perEnt.readObject();
		// recibo objeto
		System.out.println("Recibo: " + dato.getNombre() + "*" + dato.getEdad());
		// Modifico el objeto
		dato.setNombre("Juan Ramos");
		dato.setEdad(22);
		// FLUJO DE salida para objetos

		ObjectOutputStream perSal = new ObjectOutputStream(cliente.getOutputStream());
		// Se envía el objeto
		
		perSal.writeObject(dato);
		System.out.println("Envio: " + dato.getNombre() + "*" + dato.getEdad());
		// CERRAR STREAMS Y SOCKETS
		
		
		perEnt.close();
		perSal.close();
		cliente.close();
		sc.close();
	}// Fin de main
	
	public static Persona crearPersona() {
		
		System.out.println("Introduce los datos de la persona");
		
		Persona p= new Persona("",0);

		System.out.println("Dime el nombre de la persona");
		String nombre =sc.nextLine();
		System.out.println("Dime la edad de la persona");
		int edad = sc.nextInt();
		p.setEdad(edad);
		p.setNombre(nombre);
		System.out.println(p.toString());
		return p;
		
		
	}

}
