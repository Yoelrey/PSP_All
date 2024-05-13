package Juego1;

import java.util.Collections;
import java.util.List;

public class Partida{

	
	static List <Tirada> jugadores;
	
	Partida (List<Tirada>j){
		this.jugadores=j;
				
	}

	
	
	
	
	
	//Metodo para ordenar los jugadores por puntos

	
	public static List<Tirada> getJugadores() {
		return jugadores;
	}






	public void setJugadores(List<Tirada> jugadores) {
		this.jugadores = jugadores;
	}






	public void resultadoPuntos() {
		Collections.sort(jugadores);
			
		
	}

	//Metodo para inicializar
	public void mostrarMarcador() {
		resultadoPuntos();
		System.out.println("Marcador Final");
		for (Tirada tirada : jugadores) {
				
			System.out.println(tirada.toString());
		}
	}
	
}
