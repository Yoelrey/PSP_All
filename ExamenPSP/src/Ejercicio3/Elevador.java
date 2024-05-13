package Ejercicio3;

import java.util.Random;

public class Elevador extends Thread{

	Random r= new Random();
	private int capacidad;
	private int peso =r.nextInt(100);
	private int pesoTotal;
	
	public Elevador(int capacidad) {
		super();
		
		if(capacidad<0) {
			capacidad = 0;
			this.capacidad=capacidad;
		}	
		
	}

	public synchronized void cargar_paquete() {
		while (capacidad == 0 && pesoTotal >200) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				System.out.println("Esperando,eleveador lleno");
				wait();
			} catch (InterruptedException e) {}
		}
			capacidad--;
			pesoTotal-=peso;
	}
	public synchronized void descargar_paquete () {
		
		if( pesoTotal<=200) {
			pesoTotal+=peso;
		}else if(pesoTotal <200 && capacidad>0 && capacidad<=4) {
			System.out.println("Sale un paquete --> Hueco libre");
			capacidad++;
			notifyAll();
		}else {
			System.out.println("Esta cargado al maximo peso el elevador");
		}
		
		
	}
	
}
