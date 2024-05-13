package Ejemplo3;

import java.io.File;

public class Launcher {

	public void lanzarSumador(Integer n1 ,Integer n2, String fichResultado) {
		
		
		String clase ="C:\\Users\\Yoel Rey Vidal\\eclipse-workspace\\Procesos\\src\\Ejemplo3.Sumador.java";
		ProcessBuilder pb;
		
		try {
			pb= new ProcessBuilder("java",clase ,n1.toString(),n2.toString());
			
			pb.redirectError(new File("errores.txt"));
			pb.redirectOutput(new File(fichResultado));
			pb.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	public static void main(String[] args) {
		Launcher launcher = new Launcher();
		launcher .lanzarSumador(1, 10,"suma1.txt");
		launcher .lanzarSumador(10, 20,"suma2.txt");

	}
}
