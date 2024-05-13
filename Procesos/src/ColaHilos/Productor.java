package ColaHilos;

public class Productor extends Thread {

	private Cola cola;
	// el conguito produciod es un entero
	private int n;

	public Productor(Cola c, int n) {
		cola = c;
		this.n = n;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			cola.put(i); // pone el numero en la cola
			System.out.println(i + "=>Productor= " + n + " , produce: " + i);

			try {
				sleep(100);

			} catch (InterruptedException e) {
			}
		}
	}
}