package Banco;

public class SacarDinrero extends Thread{

	private Cuenta c;
	String nombre;

	
	public SacarDinrero(Cuenta c, String nombre) {
		super(nombre);
		this.c = c;

	}


	@Override
	public void run() {
		for(int x =1; x<= 4;x++) {
			c.retirarDinero(10, this.getName());
		}
	}
	
}
