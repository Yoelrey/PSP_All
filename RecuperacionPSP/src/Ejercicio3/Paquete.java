package Ejercicio3;

import java.util.Random;

public class Paquete extends Thread {

    String nombre;
    int peso;
    Elevador elevador;

    public Paquete(String nombre, Elevador elevador) {
        Random rand = new Random();
        int num = rand.nextInt((45 - 25) + 1) + 25;

        this.nombre = nombre;
        this.peso = num;
        this.elevador = elevador;

        start();
    }

    @Override
    public void run() {
        Random rand = new Random();
        int num = rand.nextInt((5000 - 3000) + 1) + 3000;

        try {
            sleep(num);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        elevador.carga_paquete(this.peso);

        System.out.println(nombre + " mete paquete en el ascensor. Hay: " + elevador.paquetesActuales +
                " paquetes y " + elevador.pesoActual + " de peso en el ascensor.");

        try {
            sleep(num);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        elevador.descarga_paquete(peso);

        System.out.println(nombre + " saca paquete del ascensor.");
    }
}