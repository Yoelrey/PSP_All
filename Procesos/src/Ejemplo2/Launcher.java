package Ejemplo2;

import java.io.File;

public class Launcher {

	public void lanzarSumador(Integer n1, Integer n2, String fichResultado) {
		String clase = "Ejemplo2.Sumador";
		ProcessBuilder pb;
		try {
			pb = new ProcessBuilder("java", clase, n1.toString(), n2.toString());

			pb.redirectError(new File("errores.txt"));
			pb.redirectOutput(new File(fichResultado));
			pb.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Launcher l = new Launcher();
		l.lanzarSumador(1, 5, "result1.txt");
		l.lanzarSumador(6, 10, "result2.txt");
		System.out.println("Fin de main");

	}
}
