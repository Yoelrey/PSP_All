package Ejercicio3ExamenAnterior;

public class Elevador {

    // Variables que definen las capacidades máximas y el estado actual del elevador
    int maximoPaquetes = 4;
    int maximoPeso = 200;
    int paquetesActuales = 0;
    int pesoActual = 0;

    // Método para cargar un paquete en el elevador
    public synchronized void carga_paquete(int peso) {
        // Utilizar un bucle while para esperar si el elevador está completo
        while (paquetesActuales > maximoPaquetes || pesoActual + peso > maximoPeso) {

            // Imprimir información sobre la capacidad y el intento de cargar el paquete
            if (pesoActual + peso > maximoPeso) {
                System.out.println("Máximo peso: 200. Actual: " + pesoActual + ". Intentando meter: " + peso);
            }

            try {
                // Mostrar información de espera y esperar
                System.out.println("Esperando, ascensor completo. Hay: " + paquetesActuales + " paquetes dentro y un peso de: " + pesoActual);
                wait();
            } catch (InterruptedException e) {
                // Manejar interrupciones (puede ser dejado vacío en este caso)
            }
        }

        // Cargar el paquete y actualizar el estado del elevador
        pesoActual += peso;
        paquetesActuales++;
    }

    // Método para descargar un paquete del elevador
    public synchronized void descarga_paquete(int peso) {
        // Imprimir información sobre la descarga del paquete
        System.out.println("Se retira un paquete de peso: " + peso);

        // Actualizar el estado del elevador al descargar el paquete
        pesoActual -= peso;
        paquetesActuales--;

        // Notificar que hay espacio disponible en el elevador
        notify();
    }
}
