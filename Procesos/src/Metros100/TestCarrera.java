package Metros100;

public class TestCarrera {

	
	
	
	public static void main(String[] args) throws InterruptedException {
		Carrera japon = new Carrera();
		japon.iniciarCarrera();
		japon.correr();
		
	japon.ordenarClasificacion();
		japon.mostrarClasificacion();
		
		System.out.println("acabo la prueba.");
	}
	
	
	
}