package uptChat;

// Importar las clases necesarias
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

// Definir la clase del cliente de chat
public class ClientChat {
    public static void main(String[] args) throws Exception {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner sc = new Scanner(System.in);
        
        // Crear un socket Datagram para el cliente
        DatagramSocket clientSocket = new DatagramSocket();
        
        // Definir arreglos de bytes para almacenar datos enviados y recibidos
        byte[] enviados = new byte[1024];
        byte[] recibidos = new byte[1024];
        
        // Obtener la dirección IP del localhost
        InetAddress IPAddress = InetAddress.getLocalHost();
        
        // Definir el puerto de destino
        int puerto = 9876;
        
        // Solicitar al usuario que introduzca un mensaje
        System.out.println("Introduce un mensaje: ");
        String cad = sc.nextLine();
        
        // Convertir el mensaje a bytes y almacenarlo en el arreglo 'enviados'
        enviados = cad.getBytes();
        
        // Imprimir la cantidad de bytes que se enviarán al servidor
        System.out.println("Enviando " + enviados.length + " bytes al servidor");

        // Crear un DatagramPacket para el envío de datos al servidor
        DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPAddress, puerto);
        
        // Enviar el DatagramPacket al servidor a través del socket del cliente
        clientSocket.send(envio);
        
        // Crear un DatagramPacket para recibir datos del servidor
        DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
        
        // Imprimir un mensaje indicando que el cliente está esperando un datagrama del servidor
        System.out.println("Esperando datagrama......");
        
        // Recibir el datagrama del servidor a través del socket del cliente
        clientSocket.receive(recibo);
        
        // Convertir los bytes recibidos a una cadena y almacenarla en 'mayuscula'
        String mayuscula = new String(recibo.getData());
        
        // Obtener la dirección IP de origen y el puerto de origen del datagrama recibido
        InetAddress IPOrigen = recibo.getAddress();
        int puertoOrigen = recibo.getPort();
        
        // Imprimir la dirección IP de origen y el puerto de origen
        System.out.println(IPOrigen + " " + puertoOrigen);
        
        // Imprimir el mensaje recibido del servidor (convertido a mayúsculas y sin espacios)
        System.out.println(mayuscula.trim());

        // Cerrar el socket del cliente
        clientSocket.close();
    }
}
