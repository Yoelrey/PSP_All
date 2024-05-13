package Juego1;

public class Tirada extends Thread implements Comparable<Tirada>{

	
	String nombre;
	int puntos;
	
	public Tirada(String n) {
		this.nombre=n;
	
		
	}
	
	@Override
	public void run() {
		   Dado d;
	       
	        for (int i = 0; i < 2; i++) {
	            d = new Dado();
	            d.start();
	            System.out.println(d.toString());
	            puntos+=d.getRes();
	        }
	       System.out.println(this.toString());
	    }

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Tirada [nombre=" + nombre + ", puntos=" + puntos + "]";
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	@Override
	public int compareTo(Tirada o) {
			Tirada t= o;
		/*	if(this.puntos>t.puntos) {
				return this.puntos - t.puntos;
				
			}else if(this.puntos< t.puntos){
				return this.puntos - t.puntos;
			}else {
				return t.puntos;
			}
*/
			
			return -(this.puntos - t.puntos);
	}

	
	
	
}
