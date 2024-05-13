package Contemos;

public class Contador {

	int c=0;
	
	public Contador(int c) {
		this.c=c;
	}
	public void incrementa() {
		c=c+1;
	}
	public void decrementa() {
		c=c-1;
	}
	@Override
	public String toString() {
		return "Contador [c=" + c + "]";
	}
	public int getC() {
		return c;
	}
	
	
}
