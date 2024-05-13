package Ejercicio4ASoñar;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Date;

/**
 * La clase MCastServer envía la hora actual y los segundos restantes hasta las 22:00 a un grupo multicast.
 */
public class MCastServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        int puerto = 12345; // Puerto multicast
        MulticastSocket ms = new MulticastSocket(puerto); // Socket multicast
        InetAddress grupo = InetAddress.getByName("225.0.0.1"); // Dirección del grupo multicast
        String cadena = "";

        System.out.println("SERVIDOR INICIADO.");
        while (!cadena.trim().equals("quit")) {
            Thread.sleep(10000); // Espera 10 segundos
            cadena = mostrarTiempo(); // Obtiene la hora actual y los segundos restantes
            DatagramPacket paquete = new DatagramPacket(cadena.getBytes(), cadena.length(), grupo, puerto);
            ms.send(paquete); // Envía el paquete al grupo multicast
        }
        System.out.println("Se ha cerrado la conexión del servidor.");

        ms.close(); // Cierra el socket multicast
        System.out.println("Socket Cerrado...");
    }

    public static String mostrarTiempo() {
        Date date = new Date();
        String[] arrayDate = date.toString().split(" ");
        String dateConFormato = arrayDate[3];
        
        String resultado = calcularTiempoRestante(dateConFormato);
        
        return "Hora actual = " + dateConFormato + " Segundos restantes hasta las 22:00: " + resultado;
    }

    public static String calcularTiempoRestante(String tiempoActual) {
        String[] tiempo = tiempoActual.split(":");
        int horaActual = Integer.parseInt(tiempo[0]);
        int minutosActuales = Integer.parseInt(tiempo[1]);
        int segundosActuales = Integer.parseInt(tiempo[2]);

        int horaActualSegundos = horaActual * 60 * 60;
        int minutoActualSegundos = minutosActuales * 60;
        int totalSegundosHoraActual = horaActualSegundos + minutoActualSegundos + segundosActuales;

        int diezHorasASegundos = 22 * 60 * 60;

        int segundosTotalesFaltantes = diezHorasASegundos - totalSegundosHoraActual;
        
        return String.valueOf(segundosTotalesFaltantes);
    }
}
