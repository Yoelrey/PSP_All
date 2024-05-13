package ACtividad1Hilos;

public class Tac extends Thread{

	String tac;
	
	public Tac(String t) {
		this.tac=t;
}

@Override
public void run() {

	while(true) {
		
		try {
			Thread.sleep(2000);
			System.out.println(tac);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
}
