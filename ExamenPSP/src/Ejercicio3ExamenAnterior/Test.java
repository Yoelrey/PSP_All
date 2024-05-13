package Ejercicio3ExamenAnterior;



public class Test {

	
public static void main(String[] args) {
		
		
		
		Elevador elevador = new Elevador();
		Paquete p;
		for (int i = 0; i < 20; i++) {

			 p = new Paquete("Nombre"+(i+1), elevador);
		}
		
	}
}
