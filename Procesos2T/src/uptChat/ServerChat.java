package uptChat;
// Importar las clases necesarias
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

// Definir la clase del servidor de chat
public class ServerChat {

    public static void main(String[] args) throws Exception {
        // Crear un socket Datagram en el puerto 9876 para el servidor
        DatagramSocket serverSocket = new DatagramSocket(9876);
        
        // Definir arreglos de bytes para almacenar datos enviados y recibidos
        byte[] enviados = new byte[1024];
        byte[] recibidos = new byte[1024];
        
        // Variable para almacenar el mensaje recibido
        String cad;

        // Bucle infinito para escuchar continuamente por datagramas
        while (true) {
            // Imprimir mensaje indicando que el servidor está esperando un datagrama
            System.out.println("Esperando datagrama...");
            
            // Crear un DatagramPacket para recibir datos del cliente
            recibidos = new byte[1024];
            DatagramPacket recibido = new DatagramPacket(recibidos, recibidos.length);
            
            // Recibir el datagrama del cliente a través del socket del servidor
            serverSocket.receive(recibido);
            
            // Convertir los bytes recibidos a una cadena y almacenarla en 'cad'
            cad = new String(recibido.getData());

            // Obtener la dirección IP de origen y el puerto de origen del datagrama recibido
            InetAddress IPorigen = recibido.getAddress();
            int puerto = recibido.getPort();
            
            // Imprimir la dirección IP de origen y el puerto de origen
            System.out.println("Origen " + IPorigen + " Puerto " + puerto);

            // Convertir la cadena a mayúsculas y quitar espacios alrededor
            String mayus = cad.trim().toUpperCase();
            
            // Convertir la cadena mayúscula a bytes y almacenarla en 'enviados'
            enviados = mayus.getBytes();

            // Crear un DatagramPacket para enviar la respuesta al cliente
            DatagramPacket enviado = new DatagramPacket(enviados, enviados.length, IPorigen, puerto);
            
            // Enviar el DatagramPacket al cliente a través del socket del servidor
            serverSocket.send(enviado);

            // Si el mensaje recibido es "*", salir del bucle
            if (cad.trim().equals("*"))
                break;
        }

        // Cerrar el socket del servidor
        serverSocket.close();
        
        // Imprimir mensaje indicando que el socket se ha cerrado
        System.out.println("Socket cerrado");
    }

    // Método que devuelve la respuesta al cliente (no parece estar siendo utilizado actualmente)
    public static String respuestaAlCliente(String cad) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Mensaje recibido: " + cad.trim());
        System.out.println("Mensaje a enviar: ");
        String respuesta = sc.nextLine();
        return respuesta;
    }
    public static boolean esBisiesto(String fechaString) throws ParseException {
        // Crear un objeto SimpleDateFormat para analizar la cadena de fecha
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        // Convertir la cadena de fecha a un objeto Date
        Date fecha = sdf.parse(fechaString);
        
        // Crear un objeto Calendar y establecer la fecha analizada
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        
        // Obtener el año del objeto Calendar
        int year = calendar.get(Calendar.YEAR);
        
        // Verificar si el año es bisiesto
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
