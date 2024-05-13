package Ejercicio3ASoñar;

import java.io.Serializable;
import java.util.ArrayList;

class CuentaCorriente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String numero = "";

	private double saldo;

	private ArrayList<String> movimientos = new ArrayList<>();

	public CuentaCorriente() {

		this.generaNumero();

	}

	public CuentaCorriente(double saldo) {

		this.generaNumero();

		this.saldo = saldo;

	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	private void generaNumero() {

		for (int i = 0; i < 10; i++) {

			numero += (int) (Math.random() * 10);

		}

	}

	@Override

	public String toString() {

		return "N�mero de cta: " + numero + " Saldo: " + String.format("%.2f", saldo) + " �";

	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	void ingreso(int dinero) {

		saldo += dinero;

		movimientos.add("Ingreso de " + dinero + " �  Saldo: " + String.format("%.2f", saldo) + " �");

	}

	void cargo(int dinero) {

		saldo -= dinero;

		movimientos.add("Cargo de " + dinero + " �  Saldo: " + String.format("%.2f", saldo) + " �");

	}

	void transferencia(CuentaCorriente cuentaDestino, int dinero) {

		saldo -= dinero;

		cuentaDestino.saldo += dinero;

		movimientos.add("Transf. emitida de " + dinero + " � a la cuenta "

				+ cuentaDestino.numero + "  Saldo " + String.format("%.2f", saldo) + " �");

		cuentaDestino.movimientos.add("Transf. recibida de " + dinero

				+ " � de la cuenta " + cuentaDestino.numero + "  Saldo " + String.format("%.2f", cuentaDestino.saldo)
				+ " �");

	}

	void movimientos() {

		System.out.println("Movimientos de la cuenta " + numero);

		System.out.println("-----------------------------------");

		for (String movimiento : movimientos) {

			System.out.println(movimiento);

		}

	}

}
