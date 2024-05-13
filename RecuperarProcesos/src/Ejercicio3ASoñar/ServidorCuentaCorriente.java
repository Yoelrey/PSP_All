package Ejercicio3ASoñar;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * La clase ServidorCuentaCorriente espera la conexión de un cliente para recibir una lista de cuentas corrientes y enviar los resultados con descuentos.
 */
public class ServidorCuentaCorriente {

    public static void main(String[] arg) {
        final int numeroPuerto = 6000; // Se define el número de puerto en el que el servidor estará escuchando

        try {
            ServerSocket servidor = new ServerSocket(numeroPuerto); // Se crea un ServerSocket para esperar conexiones entrantes
            System.out.println("Esperando al cliente.....");

            Socket cliente = servidor.accept(); // El servidor acepta la conexión entrante del cliente
            ArrayList<CuentaCorriente> listaCuentasCorrientes = new ArrayList<>(); // Se crea una lista para almacenar las cuentas corrientes recibidas

            ObjectInputStream recibidor = new ObjectInputStream(cliente.getInputStream()); // Se crea un ObjectInputStream para recibir datos del cliente
            listaCuentasCorrientes = (ArrayList<CuentaCorriente>) recibidor.readObject(); // Se lee la lista de cuentas corrientes enviada por el cliente

            for (CuentaCorriente c : listaCuentasCorrientes) { // Se recorre la lista de cuentas corrientes recibidas
                System.out.println("Recibido del cliente:");
                System.out.println(c.toString()); // Se muestra cada cuenta recibida
            }

            escribirResultados(listaCuentasCorrientes, cliente); // Se llama al método para calcular y enviar los resultados con descuentos

            // Cerrar streams y sockets
            recibidor.close(); // Se cierra el ObjectInputStream
            servidor.close(); // Se cierra el ServerSocket
        } catch (IOException | ClassNotFoundException e) { // Captura y manejo de excepciones de E/S y ClassNotFoundException
            e.printStackTrace();
        }
    }

    public static void escribirResultados(ArrayList<CuentaCorriente> cuentas, Socket cliente) {
        try {
            PrintWriter enviador = new PrintWriter(cliente.getOutputStream(), true); // Se crea un PrintWriter para enviar datos al cliente

            for (CuentaCorriente cuenta : cuentas) { // Se recorre la lista de cuentas corrientes
                enviador.println(calcularDescuento(cuenta)); // Se envía el resultado con descuento de cada cuenta al cliente
            }

            enviador.close(); // Se cierra el PrintWriter

        } catch (IOException e) { // Captura y manejo de excepciones de E/S
            e.printStackTrace();
        }
    }

    public static String calcularDescuento(CuentaCorriente cuenta) {
        double saldo = cuenta.getSaldo(); // Se obtiene el saldo original de la cuenta
        double result = saldo * 0.9; // Se calcula el saldo neto con un descuento del 10%

        String frase = "La cuenta: " + cuenta.getNumero() + " con un saldo original de: " + saldo +
                " tiene un saldo neto postdescuento de: " + String.valueOf(result) + ". Descuento: " + (saldo - result); // Se genera la frase con los detalles del descuento

        return frase; // Se devuelve la frase con los resultados del descuento aplicado a la cuenta
    }
}