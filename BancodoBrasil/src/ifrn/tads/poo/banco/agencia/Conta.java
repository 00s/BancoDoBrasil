package ifrn.tads.poo.banco.agencia;

public abstract class Conta {
	protected int numero;
	protected boolean ativa;
	protected double saldo;
	
	public boolean sacar(double valor){
		boolean saque;
		return saque;
	}
	
	public void depositar(double valor){
		
	}
	
	public double verSaldo(){
		return saldo;
	}
	
	public void cancelarConta(){
		
	}
	
	public Cliente verInformacoesCliente(){
		
	}
	
	public boolean transferirValor(int numConta, int numAgencia, double valor){
		boolean tranferido;
		return tranferido;
	}
	
	
	public String verSituacao(){
		return;
	}
}
