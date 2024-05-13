package Ejercicio2ASoñar;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Esta clase Server espera datagramas de clientes, verifica si dos números son amigos y envía el resultado de vuelta.
 */
public class Server {

    public static void main(String[] args) {

        byte[] buffer = new byte[1024]; // Se crea un buffer para almacenar los datos recibidos
        String result = ""; // Variable para almacenar el resultado de la verificación
        System.out.println("Esperando datagrama");

        try {
            int byteRec = 0;
            try (DatagramSocket socketServidor = new DatagramSocket(12345)) { // Se crea un DatagramSocket en el puerto 12345
				String paqueteRecibido = "";

				while (!paqueteRecibido.equals("*")) {
				    DatagramPacket recibo = new DatagramPacket(buffer, buffer.length); // Se crea un DatagramPacket para recibir datos
				    System.out.println("RECIBIENDO DATOS DEL CLIENTE");
				    socketServidor.receive(recibo); // Se recibe el datagrama del cliente
				    byteRec = recibo.getLength();

				    if (byteRec != 0) {
				        paqueteRecibido = new String(recibo.getData()).trim(); // Se obtiene la información del datagrama recibido
				        System.out.println("Hemos recibido del cliente: " + paqueteRecibido);

				        byte[] paqueteAEnviar = new byte[2048];
				        String[] numerosStr = paqueteRecibido.split(" ");
				        int num1 = Integer.parseInt(numerosStr[0]);
				        int num2 = Integer.parseInt(numerosStr[1]);

				        if (isAmigos(num1, num2)) { // Se verifica si los números son amigos
				            result = "Los números: " + numerosStr[0] + " y " + numerosStr[1] + " son amigos";
				        } else {
				            result = "Los números: " + numerosStr[0] + " y " + numerosStr[1] + " NO son amigos";
				        }

				        paqueteAEnviar = result.getBytes(); // Se convierte el resultado a bytes

				        String hostClienteStr = recibo.getAddress().getHostAddress();
				        InetAddress hostCliente = InetAddress.getByName(hostClienteStr);
				        int portCliente = recibo.getPort();

				        DatagramPacket envio = new DatagramPacket(paqueteAEnviar, paqueteAEnviar.length, hostCliente, portCliente); // Se crea un DatagramPacket para enviar la respuesta al cliente

				        socketServidor.send(envio); // Se envía la respuesta al cliente
				        System.out.println("Enviamos al cliente: " + result);
				        byteRec = 0;
				    } else {
				        byteRec = 0;
				        break;
				    }
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("CERRAMOS LA CONEXION");
        }
    }

    /**
     * Método para verificar si dos números son amigos.
     *
     * @param num1 Primer número a comparar
     * @param num2 Segundo número a comparar
     * @return true si los números son amigos, false en caso contrario
     */
    public static boolean isAmigos(int num1, int num2) {
        return sumaDivisores(num1) == num2 && sumaDivisores(num2) == num1; // Comprueba si la suma de los divisores es igual al otro número
    }

    /**
     * Método para calcular la suma de los divisores de un número.
     *
     * @param num Número del cual se calculará la suma de sus divisores
     * @return Suma de los divisores del número
     */
    public static int sumaDivisores(int num) {
        int total = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                total += i; // Suma los divisores del número
            }
        }
        return total; // Devuelve la suma total de los divisores
    }
}