package Hotel;
public class Hotel extends Thread{

	
	private int places;
	Hotel ( int places){
		if (places < 0) {
			places = 0;
			this.places = places;
		}
	}
	
	public synchronized void entra() {
		while (places == 0) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				System.out.println("Esperando, hotel completo");
				wait();
			} catch (InterruptedException e) {}
		}
		places--;
	}
	
	public synchronized void sale () {
		System.out.println("Sale un cliente --> Cama libre");
		places++;
		notifyAll();
	}
}
