package Metros100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Carrera {

	ArrayList<Atleta> finalistas = new ArrayList<Atleta>();

	List<Thread> listaHilos = new ArrayList<Thread>();

	public int numeroParticipantes() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce numero de participantes.");
		int numParticipantes = sc.nextInt();
		return numParticipantes;
	}

	public void iniciarCarrera() {

		int n = numeroParticipantes();
		Scanner sc = new Scanner(System.in);
		String nombre, pais;
		int dorsal;
		for (int i = 0; i < n; i++) {

			System.out.println("Introduce nombre:");
			nombre = sc.next();

			System.out.println("Introduce pais:");
			pais = sc.next();
			System.out.println("Introduce dorsal:");
			dorsal = sc.nextInt();
			Atleta atleta = new Atleta(nombre, dorsal, pais);
			finalistas.add(atleta);
		}

		sc.close();
	}

	public void correr() {

		Thread t = null;
		for (Atleta atleta : finalistas) {

			// new Thread(atleta).start();
			t = new Thread(atleta);
			System.out.println(atleta.toString() +"   ESTA PREPARADO");
			t.start();
		
		}


		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
			
		
	}

	public void ordenarClasificacion() {
		Collections.sort(this.finalistas);
	}

	public void mostrarClasificacion() {

		System.out.println("Esto es la clasificacion final.");

		for (Atleta a : finalistas) {
			System.out.println(a.toString());
		}

	}
}