package Ejercicio2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String serverAddress = "localhost";
        int serverPort = 8000;

        Scanner sc= new Scanner(System.in);
        Socket socket = new Socket(serverAddress, serverPort);
        System.out.println("Conectando al servidor");
        System.out.println();
        System.out.println("Dime el numero de habitaciones");
        int habitaciones=sc.nextInt();
        System.out.println("Dime el numero de banios");
        int banios=sc.nextInt();
        System.out.println("Dime si tiene trastero con true(tiene) o false(no tiene)");
        boolean trastero= sc.nextBoolean();
        
        casa casa = new casa(habitaciones, banios, trastero);

        ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
        salida.writeObject(casa);

        ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
        String respuesta = (String) entrada.readObject();

        System.out.println(respuesta);

        entrada.close();
        salida.close();
        socket.close();
    }
}