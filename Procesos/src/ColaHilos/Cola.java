package ColaHilos;

public class Cola extends Thread{

	private int numero;
	private boolean disponible = false;
	// inicialmente cola vacia

	synchronized public int get() {
		while(disponible == false) {
			try {
				wait();
			} catch (InterruptedException e) {}
			
		}
		disponible= false;
		notifyAll();
		return numero;
	}

	synchronized public void put(int valor) {
	while(disponible== true ) {
		
		try {
			wait();
		} catch (InterruptedException e) {}
	}
	numero= valor;
	disponible= true;
	notifyAll();
	}

	@Override
	 public String toString() {
		return "Cola [numero=" + numero + ", disponible=" + disponible + "]";
	}
	
}