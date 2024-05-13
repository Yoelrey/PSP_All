package Hilos;

public class testSegundoHiloJoin {
    public static void main(String[] args) {

        SegundoHilo hilo2;
        System.out.println("El main antes de arrancar el hilo");
        for (int i = 0; i < 20; i++) {
            hilo2 = new SegundoHilo(i);
            hilo2.start();
            try {
                hilo2.join();//obliga al hilo que lo llama a terminar antes que el hilo desde el que se lanza, en este caso llamamos a join desde main por lo que el main NO VA A ACBAR hasta que el hilo termine
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
        System.out.println("Han rematado todos los hilos joineados");
        System.out.println("El main ha terminado");
    }
}
