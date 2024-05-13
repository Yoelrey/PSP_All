package Juego1;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.Patch;

public class testPartida {

	public static void main(String[] args) {
		List<Tirada> players= new ArrayList<Tirada>();
		//Inicializacion de partido
		for(int i=0;i<5;i++) {
			Tirada t =new Tirada(String.valueOf(i));
			players.add(t);
		}
	Partida partida= new Partida(players);
	
	//Jugar la partida
		
			for (Tirada tirada : Partida.getJugadores()){
				tirada.start();
				try {
					tirada.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
	
	}
}
