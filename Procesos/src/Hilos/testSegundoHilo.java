package Hilos;

public class testSegundoHilo {

    public static void main(String[] args) {

        SegundoHilo hilo2;
        System.out.println("El main antes de arrancar el hilo");
        for (int i = 0; i < 20; i++) {
            hilo2 = new SegundoHilo(i);
            hilo2.start();
        }
        System.out.println("El main ha terminado");
    }
}
