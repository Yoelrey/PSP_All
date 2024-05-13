package ColaHilos;

public class Consumidor extends Thread {
	private Cola cola;
	private int n;

	public Consumidor (Cola c, int n) {
		cola = c;
		this.n = n;
	}

	public void run() {
	int valor = 0;
		for (int i = 0; i < 5; i++) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			valor = cola.get(); //recoge el namero
			System.out.println (i+"=>Consumidor: "+n+" ,consume: " + valor);
		}
}
}