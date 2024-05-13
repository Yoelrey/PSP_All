package ChatGraficoQuePreguntaraNoGrafico;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {

    static ServerSocket servidor;
    static final int PUERTO = 44444;
    static int CONEXIONES = 0;
    static int ACTUALES = 0;
    static ArrayList<Socket> tabula = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        servidor = new ServerSocket(PUERTO);
        System.out.println("Servidor iniciado...");

        // SE ADMITEN HASTA 50 CONEXIONES--> Funcionamiento continuo
        while (true) {
            Socket s = servidor.accept();

            tabula.add(s);
            CONEXIONES++;
            ACTUALES++;
            HiloServidor hilo = new HiloServidor(s);
            hilo.start();
        }
    }
}