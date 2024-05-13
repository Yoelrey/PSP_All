package Ejercicio3;


public class testElevador {
public static void main(String[] args) {
	Elevador elvElevador= new Elevador(4);
	for (int i = 1; i<=20;i++) {
		Paquete c = new Paquete("paquete numero "+i,elvElevador);	
			
		}
	}
}

