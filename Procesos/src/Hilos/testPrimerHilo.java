package Hilos;

public class testPrimerHilo {

    public static void main(String[] args) {

        PrimerHilo hilo = new PrimerHilo(5);
        System.out.println("Antes de arrancar el primer hilo");

        hilo.start();
        System.out.println("El main ha terminado");

    }

}