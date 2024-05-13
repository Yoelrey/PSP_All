package Ejercicio3ExamenAnterior;

import java.util.Random;

public class Paquete extends Thread {

    // Atributos de la clase Paquete
    String nombre;
    int peso;
    Elevador elevador;

    // Constructor para inicializar los atributos y comenzar el hilo
    public Paquete(String nombre, Elevador elevador) {
        // Generar un peso aleatorio entre 50 y 90 para el paquete
        Random rand = new Random();
        int num = rand.nextInt((90 - 50) + 1) + 50;

        // Inicializar atributos
        this.nombre = nombre;
        this.peso = num;
        this.elevador = elevador;

        // Iniciar el hilo
        start();
    }

    // Método que representa la ejecución del hilo
    @Override
    public void run() {
        // Generar un tiempo de espera aleatorio entre 3000 y 5000 milisegundos
        Random rand = new Random();
        int num = rand.nextInt((5000 - 3000) + 1) + 3000;

        try {
            // Dormir el hilo durante el tiempo generado
            sleep(num);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Intentar cargar el paquete en el elevador
        elevador.carga_paquete(this.peso);

        // Imprimir información sobre el paquete que se coloca en el elevador
        System.out.println(nombre + " mete paquete en el ascensor. Hay: " + elevador.paquetesActuales +
                " paquetes y " + elevador.pesoActual + " de peso en el ascensor.");

        try {
            // Generar otro tiempo de espera aleatorio
            sleep(num);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Descargar el paquete del elevador
        elevador.descarga_paquete(peso);

        // Imprimir información sobre el paquete que se retira del elevador
        System.out.println(nombre + " saca paquete del ascensor.");
    }
}
