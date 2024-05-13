package Ejercicio3ASoñar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Esta clase ClienteCuenta se conecta al servidor y envía una lista de cuentas corrientes poblada aleatoriamente.
 */
public class ClienteCuenta {

    static Scanner sc = new Scanner(System.in); // Se crea un objeto Scanner para la entrada de datos

    public static void main(String[] arg) {

        final String host = "localhost"; // Se define la dirección del servidor
        final int puerto = 6000; // Se define el puerto de conexión

        try {
            System.out.println("PROGRAMA CLIENTE INICIADO....");
            Socket cliente = new Socket(host, puerto); // Se crea un socket para la conexión al servidor
            ObjectOutputStream enviador = new ObjectOutputStream(cliente.getOutputStream()); // Se crea un ObjectOutputStream para enviar datos al servidor

            ArrayList<CuentaCorriente> listaCuentasEnviar = poblarLista(); // Se genera una lista de cuentas corrientes aleatorias

            enviador.writeObject(listaCuentasEnviar); // Se envía la lista de cuentas al servidor

            BufferedReader recibidor = new BufferedReader(new InputStreamReader(cliente.getInputStream())); // Se crea un BufferedReader para recibir datos del servidor
            String linea;

            while ((linea = recibidor.readLine()) != null) { // Se lee y muestra la respuesta del servidor
                System.out.println("Recibido del servidor: ");
                System.out.println(linea);
            }

            enviador.close(); // Se cierra el ObjectOutputStream
            recibidor.close(); // Se cierra el BufferedReader
            cliente.close(); // Se cierra la conexión con el servidor
            sc.close(); // Se cierra el Scanner

        } catch (IOException e) { // Captura y manejo de excepciones de E/S
            e.printStackTrace();
        }
    }

    /**
     * Método para poblar una lista de cuentas corrientes con valores aleatorios.
     *
     * @return Lista de cuentas corrientes poblada
     */
    public static ArrayList<CuentaCorriente> poblarLista() {
        ArrayList<CuentaCorriente> listaCuentas = new ArrayList<CuentaCorriente>(); // Se crea una lista para almacenar las cuentas corrientes generadas aleatoriamente
        Random rand = new Random(); // Se crea un objeto Random para generar números aleatorios
        int r = 0;
        int numero = 0;

        while (numero < 5) { // Bucle para asegurar que se añadan al menos 5 cuentas a la lista
            System.out.println("¿Cuántas cuentas añadimos? MÍNIMO 5: ");
            numero = sc.nextInt(); // Se solicita al usuario ingresar el número de cuentas a añadir
        }

        for (int i = 1; i <= numero; i++) { // Bucle para poblar la lista con cuentas corrientes aleatorias
            r = rand.nextInt(150) + 1; // Genera un número aleatorio entre 1 y 150
            CuentaCorriente cuenta = new CuentaCorriente(i * 100); // Crea una nueva cuenta corriente con saldo inicial basado en el índice
            cuenta.ingreso(i * r); // Realiza un ingreso aleatorio en la cuenta
            cuenta.cargo(r); // Realiza un cargo aleatorio en la cuenta
            listaCuentas.add(cuenta); // Agrega la cuenta a la lista
        }

        return listaCuentas; // Devuelve la lista poblada de cuentas corrientes
    }
}