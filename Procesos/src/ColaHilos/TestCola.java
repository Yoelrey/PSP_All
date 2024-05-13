package ColaHilos;

public class TestCola {
	public static void main(String[] args) {
		Cola cola= new Cola();
		Productor p = new Productor(cola, 11);
		Consumidor consumidor= new Consumidor(cola, -69);
		cola.start();
		p.start();
		consumidor.start();
		
	}
}
