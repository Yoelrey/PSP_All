package Ejercicio1TipoExamen;

// ServerExamen.java

// Importa las clases necesarias para entrada/salida, networking y manejo de fechas
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ServerExamen {
    
    public static void main(String[] args) throws IOException {
        // Crea un ServerSocket que escucha en el puerto 1234
        ServerSocket serverSocket = new ServerSocket(1234);

        // Espera a que un cliente se conecte y acepta la conexión
        Socket clientSocket = serverSocket.accept();

        // Crea un BufferedReader para leer datos del cliente
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // Crea un PrintWriter para enviar datos al cliente
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        // Variable para almacenar la entrada del cliente
        String inputLine;

        // Bucle que se ejecuta mientras el cliente sigue enviando datos
        while ((inputLine = in.readLine()) != null) {
            try {
                // Intenta parsear la entrada del cliente como una fecha en formato "dd/MM/yyyy"
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date date = format.parse(inputLine);

                // Obtiene el día de la semana de la fecha y lo envía al cliente
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                out.println(dayOfWeek);
            } catch (Exception e) {
                // En caso de error, envía un mensaje de error al cliente
                out.println("Error: " + e.getMessage());
            }
        }

        // Cierra los flujos y el socket cuando el bucle termina
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
