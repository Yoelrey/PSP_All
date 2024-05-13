package Contemos;

public class HiloDecre extends Thread{

			Contador contador;
		
		public HiloDecre(String n,Contador c) {
			setName(n);
			contador =c;
		}
		
		@Override
		public void run() {
			
			synchronized (contador) {
				
			
			for(int j =0; j< 300;j++) {
				contador.decrementa();
				try {
					sleep(150);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(this.getName()+ " contador vale "+ contador.getC());}

			}
		}
		
	}

