package Hotel;

import java.util.Random;

public class Cliente extends Thread {

	private Hotel hotel;

	Random r= new Random();
	Cliente(String numero, Hotel p) {
		super(numero);
		this.hotel = p;
		// Arrancando en el constructor
		start();

	}

	@Override
	public void run() {

		try {
			sleep((int) (r.nextInt(10000) ));
		} catch (InterruptedException e) {}
		hotel.entra();
		System.out.println(getName() + " :entra al hotel");
		
		try {
			sleep((int) (r.nextInt(20000)));
		} catch (InterruptedException e) {}
		
		hotel.sale();
		System.out.println(getName() + " :sale del hotel");

	}
}
