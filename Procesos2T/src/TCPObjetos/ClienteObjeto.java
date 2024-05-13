package TCPObjetos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteObjeto {
	static Scanner sc= new Scanner(System.in);
	public static void main(String[] arg) throws IOException, ClassNotFoundException {
		

		String host = "localhost";
		int puerto = 6000;
		
		Persona per =crearPersona();
		
		System.out.println("PROGRAMA CLIENTE INICIADO....");
		Socket cliente = new Socket(host, puerto);
		ObjectInputStream perEnt = new ObjectInputStream(cliente.getInputStream());
		Persona dato = (Persona) perEnt.readObject();
		System.out.println("Recibo: " + dato.getNombre() + "*" + dato.getEdad());		//dato.setNombre("Juan Ramos");
	
		ObjectOutputStream perSal = new ObjectOutputStream(cliente.getOutputStream());
		
		perSal.writeObject(dato);
		System.out.println("Envio: " + dato.getNombre() + "*" + dato.getEdad());
		
		
		perEnt.close();
		perSal.close();
		cliente.close();
		sc.close();
	}
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
