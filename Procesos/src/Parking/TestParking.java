package Parking;

public class TestParking {

	
	
	
	public static void main(String[] args) {
		
		
		
		Aparcamiento a = new Aparcamiento(10);
		Coche c;
		
		
		for (int i = 1; i <= 50; i++) {
			
			c = new Coche("Coche" + i, a);
			
			a.listaDeCoches.add(c);
		}
		
		for (Coche coche : a.listaDeCoches) {
			try {
				coche.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		System.out.println("Todos los coches han salido del parking.");
		
		
		
		
		
	}
	
	

}