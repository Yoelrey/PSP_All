package Banco;

public class TestCuenta {
	public static void main(String[] args) {
		System.out.println("sacando dinero");
		Cuenta c= new Cuenta(40);
		
		SacarDinrero s1 = new SacarDinrero(c, "Yowy");
		SacarDinrero s2 = new SacarDinrero(c,"Pichu!");
		
		
		s1.start();
		s2.start();
		
		System.out.println("Fin del main");
	}
}
