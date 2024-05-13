package Hilos;

public class PrimerHilo extends Thread {

    int x;

    public PrimerHilo(int x) {
        this.x = x;
    }

    public void run(){
        for (int i = 0; i < x; i++) {
            System.out.println("Me imprimo por vez: "+ i);
        }
    }


    //tread_0 primer hilo SIEMPRE en java


}
