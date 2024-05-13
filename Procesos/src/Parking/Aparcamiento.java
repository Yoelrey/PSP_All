package Parking;

import java.util.ArrayList;

public class Aparcamiento{

	
	int numPlazas;

	ArrayList<Coche> listaDeCoches = new ArrayList<Coche>();
	
	public Aparcamiento(int numPlazas) {

		if (numPlazas < 0) {
			numPlazas = 0;
		}
		this.numPlazas = numPlazas;
	}
	
	
	
	public synchronized void gestionarEntrada() {
		
		
		while (numPlazas == 0) {
			
		
			
			try {
				System.out.println("TODAS LAS PLAZAS EST�N OCUPADAS.");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		numPlazas--;
		
		
		
		
	}
	
	public synchronized void gestionarSalida() {
		
		System.out.println("Plazas disponibles: " + numPlazas);
		
		numPlazas++;
		
		notify();
		
		
		
	}
	
	
	
	
	
	
}