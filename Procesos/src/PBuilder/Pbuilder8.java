package PBuilder;

import java.io.IOException;

public class Pbuilder8 {

	public static void main(String[] arg) throws IOException, InterruptedException {
		ProcessBuilder pb = new ProcessBuilder("poweshell.exe","echo", "Hello GeeksforGeeks" + 
	"This is ProcessBuilder Example");
		pb.inheritIO();
		Process process = pb.start();
		//Esperando a que termine la ejecucion
		//process.waitFor();

	}
}
