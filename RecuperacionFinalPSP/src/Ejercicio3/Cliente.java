package Ejercicio3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente implements Runnable {

    Socket socket = null;
    DataInputStream entrada;
    DataOutputStream salida;
    String nombre;
    static boolean repetir = true;

    public Cliente(Socket s, String nombre) {
        socket = s;
        this.nombre = nombre;

        try {
            entrada = new DataInputStream(socket.getInputStream());
            salida = new DataOutputStream(socket.getOutputStream());
            String cad = " - Entra en el Chat " + nombre;
            salida.writeUTF(cad);
            System.out.println("Mensaje de entrada enviado: " + cad);
        } catch (IOException e) {
            System.out.println("ERROR DE E/S");
            e.printStackTrace();
            System.exit(0);
        }
    }

    @Override
    public void run() {
        String cad2 = "";
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        while (repetir) {
            try {
                cad2 = entrada.readUTF();
                System.out.println("Mensaje recibido: " + cad2);
                System.out.print("Escribe una respuesta: ");
                String respuesta = sc.nextLine();
                salida.writeUTF(nombre + "> " + respuesta);
                System.out.println("Mensaje enviado: " + nombre + "- " + respuesta);
            } catch (IOException e) {
                System.out.println("Error de E/S");
                e.printStackTrace();
                break;
            }
        }

        try {
            socket.close();
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        int puerto = 44444;
        String nombre = "Jugador1";
        Socket socket = null;
        try {
            InetAddress local = InetAddress.getByName("localhost");
            socket = new Socket(local, puerto);
        } catch (IOException e) {
            System.out.println("Imposible conectar con el servidor:" + e.getMessage());
            System.exit(0);
        }
        if (!nombre.trim().equals("")) {
            Cliente cliente = new Cliente(socket, nombre);
            Thread hilo = new Thread(cliente);
            hilo.start();
            try {
				hilo.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else
            System.out.println("El nombre está vacío....");
    }
}