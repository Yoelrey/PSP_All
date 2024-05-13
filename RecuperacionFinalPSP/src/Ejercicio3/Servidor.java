package Ejercicio3;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {

    static ServerSocket servidor;
    static int puerto = 44444;
    static int conexiones = 0;
    static int actuales = 0;
    static ArrayList<Socket> listaConexiones = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        try {
			try {
				servidor = new ServerSocket(puerto);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Servidor iniciado...");

        while (true) {
            Socket s = servidor.accept();

            listaConexiones.add(s);
            conexiones++;
            actuales++;
            HiloServidor hiloServer = new HiloServidor(s);
            hiloServer.start();
        }
    }
}