package it.data;

public class ContoCorrente {

	private int numero;
	private String intestatario;
	private float saldo;
	
	public ContoCorrente(int numero, String intestatario, float saldo) {
		this.numero = numero;
		this.intestatario = intestatario;
		this.saldo = saldo;
	}
	
	public ContoCorrente () {
		}

	public int getNumero() {return numero;}
	public String getIntestatario() {return intestatario;}
	public float getSaldo() {return saldo;}

	public void setNumero(int numero) {this.numero = numero;}
	public void setIntestatario(String intestatario) {this.intestatario = intestatario;}
	public void setSaldo(float saldo) {this.saldo = saldo;}
	
	
}
