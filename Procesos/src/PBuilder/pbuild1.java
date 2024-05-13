package PBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class pbuild1 {

	public static void 
	main(String[] arg) throws IOException{
	// Creando lista de procesos y le añade el programa a ejecutar
	List<String> list = new ArrayList<String>();
	list.add("notepad.exe");

	// Creas o instancias el proceso y pasando el array list
	ProcessBuilder build = new ProcessBuilder(list);

	// Devuelve los comandos que se vayan a ejecutar(Cuando se llama a command muestra el array o lis de comandos)
	System.out.println("command: " + build.command());
	//Despues de chequear el proceso lo lanzo
	build.start();

	
	//Codigo que aproveche el proceso lanzado
	
	
	}
}
