package Parking;

import java.util.Random;

public class Coche extends Thread {

	String nombre;
	Aparcamiento parking;
	int tiempoEstacionado;

	public Coche(String nombre, Aparcamiento parking) {
		super();
		this.nombre = nombre;
		this.parking = parking;
	
		start();
	}
	
	
	@Override
	public void run() {
	
		Random rand = new Random();
		int num = rand.nextInt(10000);
		try {
			sleep(num);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

			
		
		

			parking.gestionarEntrada();
			
			
			System.out.println(this.toString() + "     HA ENTRADO");
	
			
			this.tiempoEstacionado =  rand.nextInt(20000);
		try {
		

			sleep(tiempoEstacionado);
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parking.gestionarSalida();
		System.out.println(this.toString() + "     HA SALIDO");
		
		
		
		
	}


	@Override
	public String toString() {
		return "Coche [nombre=" + nombre + ", tiempoEstacionado=" + tiempoEstacionado+" ]";
	}
	
	
	
}