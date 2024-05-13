package Ejercicio3; 
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class HiloServidor extends Thread  {

    DataInputStream entrada;
    Socket socket = null;
    static int Actuales = 0;

    public HiloServidor(Socket s) {
        socket = s;
        try {
            entrada = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("Error de E/S");
            e.printStackTrace();
        }
    }

    public void run() {
        Actuales++;
        System.out.println("Numero de conexiones actuales: " + Actuales);

        String texto = "";
        EnviarMensajes(texto);

        while (true) {
            String cadena = "";
            try {
                cadena = entrada.readUTF();
                if (cadena.trim().equals("quit")) {
                    Actuales--;
                    System.out.println("Numero de conexiones actuales: " + Actuales);
                    break;
                }

                System.out.println("Mensaje recibido: " + cadena);
                EnviarMensajes(cadena);
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
        
        
    }
    public void EnviarMensajes(String texto) {
       
        for (int i = 0; i < Servidor.listaConexiones.size(); i++) {
            Socket socket = Servidor.listaConexiones.get(i);
            try {
                DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
                salida.writeUTF(texto);
            } catch (SocketException se) {
            } catch (IOException e) {
                e.printStackTrace();
            }
        } 
    }
}