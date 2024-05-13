package ACtividad1Hilos;

public class Tic extends Thread{

	
	String tic;

	
	public Tic(String t) {
			this.tic=t;
	}
	
	@Override
	public void run() {
	
		while(true) {
			try {
				sleep(2000);
				System.out.println(tic);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	}
	
	
}
