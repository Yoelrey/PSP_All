package TCPObjetos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ClienteLista {
	static Scanner sc = new Scanner(System.in);

	@SuppressWarnings("unchecked")
	public static void main(String[] arg) throws IOException, ClassNotFoundException {

		String host = "localhost";
		int puerto = 6000;// puerto remoto

		

		System.out.println("PROGRAMA CLIENTE INICIADO....");
		Socket cliente = new Socket(host, puerto);
		// Flujo de entrada para objetos
		ObjectInputStream perEnt = new ObjectInputStream(cliente.getInputStream());
		// Se recibe un objeto
		Persona dato = (Persona) perEnt.readObject();
		// recibo objeto
		System.out.println("Recibo: " + dato.getNombre() + "*" + dato.getEdad());
		// Modifico el objeto
		dato.setNombre("Juan Ramos");
		dato.setEdad(22);
		// FLUJO DE salida para objetos

		ObjectOutputStream perSal = new ObjectOutputStream(cliente.getOutputStream());
		
		
		ArrayList<Persona>enviados=new ArrayList<Persona>();
		
		System.out.println("Cuantas personas añadimos para enviar al servidor");
		
		int num = sc.nextInt();
		for (int i =0; i>num;i++) {
			Persona per = crearPersona();
			enviados.add(per);
			
		}
				
		
		
		// Se envía el objeto+
		

		ArrayList<Persona>recibidos= new ArrayList<Persona>();
		recibidos= (ArrayList<Persona>) perEnt.readObject();
		perSal.writeObject(enviados);
		//System.out.println("Envio: " + dato.getNombre() + "*" + dato.getEdad());
		// CERRAR STREAMS Y SOCKETS

		
		perEnt.close();
		perSal.close();
		cliente.close();
		sc.close();
	}// Fin de main

	public static Persona crearPersona() {

		System.out.println("Introduce los datos de la persona");

		Persona p = new Persona("", 0);

		System.out.println("Dime el nombre de la persona");
		String nombre = sc.next();
		System.out.println("Dime la edad de la persona");
		int edad = sc.nextInt();
		p.setEdad(edad);
		p.setNombre(nombre);
		System.out.println(p.toString());
		return p;

	}

}
