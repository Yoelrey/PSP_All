package Contemos;

public class testContador {

	
	public static void main(String[] args) {
		Contador c= new Contador(100);
		HiloInc in= new HiloInc("HIlo Inca", c);
		HiloDecre dec= new HiloDecre("HIlo Decre", c);
		

		in.start();
		dec.start();

		
	}
}
