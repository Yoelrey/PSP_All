package Ejercicio5ASoñar;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Esta clase ServidorHilos se encarga de gestionar múltiples clientes mediante hilos para realizar eco de mensajes.
 */
public class ServidorHilos {

    public static ArrayList<Socket> clientes = new ArrayList<>(); // Lista de sockets para los clientes
    static ServerSocket servidor; // ServerSocket para aceptar conexiones

    public static void main(String[] args) {

        System.out.println("Servidor iniciado esperando cliente");

        try {
            servidor = new ServerSocket(44444); // Inicializa el ServerSocket en el puerto 44444

            while (true) {
                try {
                    Socket socketCliente = servidor.accept(); // Acepta la conexión con un cliente
                    System.out.println("Cliente conectado");
                    clientes.add(socketCliente); // Agrega el socket del cliente a la lista
                    HiloEco hilo = new HiloEco(socketCliente); // Crea un nuevo hilo para manejar la comunicación con el cliente
                    hilo.start(); // Inicia el hilo
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
