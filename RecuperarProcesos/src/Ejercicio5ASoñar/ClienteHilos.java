package Ejercicio5ASoñar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * La clase ClienteHilos se encarga de establecer la comunicación con el servidor mediante hilos.
 */
public class ClienteHilos {
    
    Socket socket; // Socket para la conexión
    BufferedReader recibidor; // Flujo de entrada para recibir datos
    PrintWriter enviador; // Flujo de salida para enviar datos

    public ClienteHilos(Socket socket) throws IOException {
        super();
        this.socket = socket;
        
        recibidor = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Inicializa el flujo de entrada
        enviador = new PrintWriter(socket.getOutputStream(), true); // Inicializa el flujo de salida
    }

    public static void main(String[] args) throws UnknownHostException, IOException {

        int puerto = 44444;
        Socket socketCliente = new Socket("localhost", puerto); // Crea un socket cliente y se conecta al servidor
        ClienteHilos clienteHilos = new ClienteHilos(socketCliente); // Crea una instancia de ClienteHilos
        clienteHilos.escribirFrase(); // Llama al método para enviar una frase al servidor
        
        clienteHilos.enviador.close(); // Cierra el flujo de salida
        clienteHilos.recibidor.close(); // Cierra el flujo de entrada
        clienteHilos.socket.close(); // Cierra el socket
    }

    public void escribirFrase() {
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        System.out.println("El cliente escribe frase:");
        String frase = sc.nextLine();
        enviador.println(frase); // Envía la frase al servidor
        
        try {
            Thread.sleep(1000); // Espera un segundo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String recibida = "";
		try {
			recibida = recibidor.readLine(); // Lee la respuesta del servidor
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Recibiendo del servidor -> " + recibida.trim()); // Muestra la respuesta recibida del servidor
    }
}
