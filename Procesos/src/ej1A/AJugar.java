package ej1A;

import java.util.Scanner;

public class AJugar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("introduce numero de jugadores: ");
		int n= sc.nextInt();
		Marcador dep = new Marcador(n);
		
		System.out.println(dep.declaraVencedor());
		
		dep.ordenaMarcador();
		System.out.println("Jugadores ordenados de mayor a menor puntos");
		for(Mano m:dep.getDatos()) {
			System.out.println(m.toString());
		}
	}
}
