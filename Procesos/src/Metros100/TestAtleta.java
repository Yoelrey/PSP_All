package Metros100;

public class TestAtleta {
	
	public static void main(String[] args) {
		Atleta atleta;
		
		for (int i = 0; i < 3; i++) {
			
			atleta = new Atleta("Ghichoi"+i,	 i+1	, "Pais"+i);
		new Thread(atleta).start();
			
		}
		
		
	}
}