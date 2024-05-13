package Ejercicio3;

public class Elevador {

    int maximoPaquetes = 3;
    int maximoPeso = 100;
    int paquetesActuales = 0;
    int pesoActual = 0;

    public synchronized void carga_paquete(int peso) {
        while (paquetesActuales > maximoPaquetes || pesoActual + peso > maximoPeso) {

            if (pesoActual + peso > maximoPeso) {
                System.out.println("Máximo peso: 200. Actual: " + pesoActual + ". Intentando meter: " + peso);
            }

            try {
                System.out.println("Esperando, ascensor completo. Hay: " + paquetesActuales + " paquetes dentro y un peso de: " + pesoActual);
                wait();
            } catch (InterruptedException e) {
            }
        }

        pesoActual += peso;
        paquetesActuales++;
    }

    public synchronized void descarga_paquete(int peso) {
        System.out.println("Se retira un paquete de peso: " + peso);

        pesoActual -= peso;
        paquetesActuales--;

        notify();
    }
}
