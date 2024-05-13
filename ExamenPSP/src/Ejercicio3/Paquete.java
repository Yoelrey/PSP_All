package Ejercicio3;

import java.util.Random;


public class Paquete extends Thread {

	private Elevador elevador;

	Random r= new Random();
	private String num;
	

	public Paquete(String numero,Elevador elevador) {
		super();
		this.elevador = elevador;
		this.num= numero;
	}



	@Override
	public void run() {

		try {
			sleep((int) (r.nextInt(10000) ));
		} catch (InterruptedException e) {}
		elevador.cargar_paquete();
		System.out.println(getName() + " :entra al elevador");
		
		try {
			sleep((int) (r.nextInt(20000)));
		} catch (InterruptedException e) {}
		
		elevador.descargar_paquete();
		System.out.println(getName() + " :sale del elevador");

	}
}

