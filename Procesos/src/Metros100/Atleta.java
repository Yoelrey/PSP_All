package Metros100;

import java.util.Random;

public class Atleta implements Runnable, Comparable<Atleta>{
	
	
	
	private String nombre;
	private int dorsal;
	private long tiempo;
	private String pais;
	
	
	

	public Atleta(String nombre, int dorsal, String pais) {
		super();
		this.nombre = nombre;
		this.dorsal = dorsal;
		this.pais = pais;
	}



	public String getPais() {
		return pais;
	}



	public void setPais(String pais) {
		this.pais = pais;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getDorsal() {
		return dorsal;
	}



	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}








	@Override
	public String toString() {
		return "Atleta [nombre=" + nombre + ", dorsal=" + dorsal + ", tiempo=" + tiempo + ", pais=" + pais + "]";
	}



	@Override

	public void run() {

			//System.out.println(this.nombre + " preparado");

			//long inicio = System.currentTimeMillis();

			this.tiempo = 0;

			//METODO SINCRONIZADO PARA ARRANCAR

			try {

				Random r = new Random();

				this.tiempo = r.nextInt(4001)+8000;

				Thread.sleep(this.tiempo);
			

			} catch (InterruptedException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

			//System.out.println(this.nombre +" ha llegado");

			//System.out.println(this.toString());
			
			
			//long fin = System.currentTimeMillis();

	

	}



	@Override
	public int compareTo(Atleta o) {
		// TODO Auto-generated method stub
		return (int)(this.tiempo - o.tiempo);
	}

}