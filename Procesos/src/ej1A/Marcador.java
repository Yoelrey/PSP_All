package ej1A;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Marcador {

	// public static int NUM_JUGADORES =2;
		ArrayList<Mano> datos;
		
		Marcador(int numero){
			this.datos=crearPartida(numero);
		}

		public ArrayList<Mano>  crearPartida(int numero) {
			Scanner sc = new Scanner(System.in);
			ArrayList<Mano> datos = new ArrayList();
			Mano t = null;
			String n = "";
			for (int i = 0; i < numero; i++) {
				System.out.println("nombre jugador: " +( i + 1) + " : ");
				n = sc.nextLine();
				t = new Mano(n);
				datos.add(t);
			}
			return datos;
		}
		
		// mecanica del juego
		public int juegoSumando(Mano t) {
			int p=0;
			for(Carta d: t.getJugada()) {
				p+=d.getNumero();
			}
			return p;
		}

		@Override
		public String toString() {
			return "Marcador [datos=" + datos + "]";
		}
		public ArrayList<Mano> getDatos(){
			return datos;
		}
		public String declaraVencedor() {
			String n="";
			int r=0;
			for(Mano t :datos) {
				
				int p =juegoSumando(t);
				if(p>r) {
					r=p;
					n=t.getNombre();
				}
				System.out.println(t.getNombre()+" "+p);
			}
			return "El ganador es: "+n+" con resultado : "+r;
		}
		
		public void ordenaMarcador() {
			Collections.sort(datos);
		}
}
