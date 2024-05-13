package ACtividad1Hilos;

public class TestTicTac {

	
	public static void main(String[] args) {
		
		
		System.out.println("Prueba de tic tac");
		Tic tic =new Tic("TIC..............");
		Tac tac =new Tac("TAC..............");
		
		
		tic.start();
		tac.start();
		try {
			tic.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			tac.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
