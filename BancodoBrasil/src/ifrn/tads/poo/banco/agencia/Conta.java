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
		this.saldo = 0;
	}
	
	public boolean sacar(double valor){
			if (saldo-valor >= 0){
				this.saldo-= valor;
				return true;
			}else return false;
	}
	
	public void depositar(double valor){
		this.saldo+=valor;
	}
	
	public double verSaldo(){
		return saldo;
	}
	
	public void cancelarConta(){
		
	}
	
	public void alterarEstadoConta(){
		if (this.ativa)	this.ativa = false;
		else this.ativa = true;
	}

	
	public Cliente verInformacoesCliente(){
		return c;
	}
	
	public boolean transferirValor(int numConta, int numAgencia, double valor){
		
		// implementar busca de conta
		
		
		if(this.getSaldo()>= valor)
			return true;
		else
			return false;
	}
	
	public String verSituacao(){
		String sit;
		if(!ativa)
			sit = "Conta não ativa";
		else
			sit = "Conta ativa";

	return sit;
	}

	
	
	public int getNumero() {
		return numero;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public double getSaldo() {
		return saldo;
	}

	public Cliente getC() {
		return c;
	}
	
}
