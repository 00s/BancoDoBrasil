package ifrn.tads.poo.banco.agencia;
import ifrn.tads.poo.banco.cliente.*;

public abstract class Conta {
	protected int numero;
	protected boolean ativa;
	protected double saldo;
	protected Cliente c;
	
	Conta(int numero, Cliente c){
		this.numero = numero;
		this.c = c;
		this.ativa = true;
	}
	
	public boolean sacar(double valor){
		boolean saque = false;
			if (saldo-valor >= 0){
				this.saldo-= valor;
				saque = true;
			}
		return saque;
	}
	
	public void depositar(double valor){
		this.saldo+=valor;
	}
	
	public double verSaldo(){
		return saldo;
	}
	
	public void cancelarConta(){
		
	}
	
	public Cliente verInformacoesCliente(){
		return c;
	}
	
	public boolean transferirValor(int numConta, int numAgencia, double valor){
		boolean transferido;
		return transferido;
	}
	
	public String verSituacao(){
		return;
	}
}
