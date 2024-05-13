package Ejercicio3;
import java.io.*;
import java.net.*;

public class HiloCliente implements Runnable {
    private Socket socket;
    private BufferedReader entrada;
    private PrintWriter salida;

    public HiloCliente(Socket socket) {
        this.socket = socket;
    }

    @Override
   public void run() {
        try {
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            salida = new PrintWriter(socket.getOutputStream(), true);

            String mensaje;
            while ((mensaje = entrada.readLine()) != null) {
                System.out.println("Mensaje recivido: " + mensaje);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void enviarMensaje(String mensaje) {
        salida.println(mensaje);
    }
}