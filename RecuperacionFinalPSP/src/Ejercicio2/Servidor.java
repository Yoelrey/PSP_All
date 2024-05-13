package Ejercicio2;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        int serverPort = 8000;
        ServerSocket serverSocket = new ServerSocket(serverPort);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Nuevo cliente conectado");

            ObjectInputStream entrada = new ObjectInputStream(clientSocket.getInputStream());
            casa casa = (casa) entrada.readObject();

            int valoracion = calcularValoracion(casa);
            String respuesta = "El alquiler de la casa con " + casa.getHabitaciones() + " habitaciones, " + casa.getBaños() + " baño" +
            (casa.getTrastero() ? " y con trastero" : "") + " vale: " + valoracion + "€";

            ObjectOutputStream salida = new ObjectOutputStream(clientSocket.getOutputStream());
            salida.writeObject(respuesta);
            
            
            
            entrada.close();
            salida.close();
            clientSocket.close();
        }
    }

    private static int calcularValoracion(casa casa) {
        int valoracion = 0;
        valoracion += casa.getHabitaciones() * 75;
        valoracion += casa.getBaños() * 50;
        if (casa.getTrastero()) {
            valoracion += 100;
        }
        return valoracion;
    }
}


