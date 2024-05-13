package Contemos;

public class HiloInc extends Thread{

	Contador contador;
	
	public HiloInc(String n,Contador c) {
		setName(n);
		contador =c;
	}
	
	@Override
	public void run() {
		synchronized (contador) {
			
		
		for(int j =0; j< 300;j++) {
			contador.incrementa();
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(this.getName()+ " contador vale "+ contador.getC());}

		}
	}
	
}
