package Ejercicio1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class Servidor {

    public static void main(String[] args) {

        byte[] buffer = new byte[1024]; 
        String resultado = ""; 
        System.out.println("Esperando datagrama");

        try {
            int recuentoBytes = 0;
            try (DatagramSocket socketServidor = new DatagramSocket(12345)) {
				String paqueteRecibido = "";

				while (!paqueteRecibido.equals("*")) {
				    DatagramPacket recibo = new DatagramPacket(buffer, buffer.length); 
				    System.out.println("RECIBIENDO DATOS DEL CLIENTE");
				    socketServidor.receive(recibo);
				    recuentoBytes = recibo.getLength();

				    if (recuentoBytes != 0) {
				        paqueteRecibido = new String(recibo.getData()).trim(); 
				        System.out.println("Hemos recibido del cliente: " + paqueteRecibido);

				        byte[] paqueteAEnviar = new byte[1024];
				        String[] numerosStr = paqueteRecibido.split(" ");
				        int num1 = Integer.parseInt(numerosStr[0]);

				        if (capicua(num1)==true) { 
				            resultado = "El numero: " + numerosStr[0] + " es capicua";
				        } else {
				            resultado = "El numero: " + numerosStr[0] + " no es capicua"; 
				        }

				        paqueteAEnviar = resultado.getBytes();

				        String hostClienteStr = recibo.getAddress().getHostAddress();
				        InetAddress hostCliente = InetAddress.getByName(hostClienteStr);
				        int portCliente = recibo.getPort();

				        DatagramPacket envio = new DatagramPacket(paqueteAEnviar, paqueteAEnviar.length, hostCliente, portCliente); 

				        socketServidor.send(envio); 
				        System.out.println("Enviamos al cliente: " + resultado);
				        recuentoBytes = 0;
				    } else {
				        recuentoBytes = 0;
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

    public static boolean capicua(int numero) {
        int numeroInvertido = 0;
        int numeroOriginal = numero;

        while (numero > 0) {
            int resultado = numero % 10;
            numeroInvertido = numeroInvertido * 10 + resultado;
            numero /= 10;
        }

        return numeroOriginal == numeroInvertido;
    }

	
  
}