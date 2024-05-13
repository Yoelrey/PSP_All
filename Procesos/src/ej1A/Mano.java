package ej1A;

import java.util.ArrayList;
import java.util.Collections;

public class Mano implements Comparable<Mano>{
	
	String nombre;
	ArrayList<Carta> mano;
	int puntos;
	
	Mano(String nombre) {
		this.nombre = nombre;
		this.mano = crearMano();
		this.puntos = asignarPuntos();
	}
	
	
	private ArrayList<Carta> crearMano() {
		Carta dado = null;
		ArrayList<Carta> tirada = new ArrayList<>();
		//total = 0;

		for (int j = 0; j < 5; j++) {
			dado = new Carta();
			dado.start();
			tirada.add(dado);

		}

		for (Carta d : tirada) {
			try {
				d.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//total += d.getPuntos();
		}
		 //System.out.println("total de tirada: " + total);
		return tirada;
	}
	
	public int asignarPuntos() {
		
		int p=0;
		for(Carta d: this.getJugada()) {
			p+=d.getNumero();
		}
		return p;
		
	}
	

	public String getNombre() {
		return nombre;
	}
	
	public int getPuntos() {
		return puntos;
	}
	public ArrayList<Carta> getJugada() {
		return mano;
	}

	@Override
	public String toString() {
		return "Tirada [nombre=" + nombre +", puntos="+puntos+"]";
	}

	public int compareTo(Mano c) {
	    return  c.getPuntos()- puntos;
	  }

}
