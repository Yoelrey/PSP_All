package Principio;

import java.net.*;
import java.io.*;

public class Ejemplo1URLCon {
	public static void main(String[] args) {
		URL url = null;
		URLConnection urlCon = null;
		try {
			url = new URL("https://www.cebem.net/index.php/es/");
			urlCon = url.openConnection();
			BufferedReader br;
			InputStream inputStream = urlCon.getInputStream();
			br = new BufferedReader(new InputStreamReader(inputStream));
			String inputLine;
			while ((inputLine = br.readLine()) != null)
				System.out.println(inputLine);
			br.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// fin de main
}// Fin