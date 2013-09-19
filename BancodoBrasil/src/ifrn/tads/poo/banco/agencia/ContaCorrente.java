package ifrn.tads.poo.banco.agencia;

import ifrn.tads.poo.banco.cliente.Cliente;

public class ContaCorrente extends Conta {
	private double limite;
	public ContaCorrente(int numero, Cliente c) {
		super(numero, c);
		this.limite = 250;
		this.saldo += limite;
	}
	
	public void mudarLimiteDaConta(double novoLimite){
		this.limite = novoLimite;
	}
	
	public double getLimite(){
		return limite;
	}
	public String toString(){
		return 
	}
}
