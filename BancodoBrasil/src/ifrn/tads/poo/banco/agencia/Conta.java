package ifrn.tads.poo.banco.agencia;
import ifrn.tads.poo.banco.Banco;
import ifrn.tads.poo.banco.cliente.*;
import ifrn.tads.poo.banco.exceptions.SaldoInsuficienteException;
import ifrn.tads.poo.banco.exceptions.SenhaIncorretaException;

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
	
	public boolean sacar(double valor, int senha) throws SaldoInsuficienteException, SenhaIncorretaException{
		
		if(!c.checkSenha(senha)){
			throw new SenhaIncorretaException();
		}
		
		if (saldo-valor >= 0){
				this.saldo-= valor;
				//System.out.println("Saque efetuado.");
				return true;
		}		
		throw new SaldoInsuficienteException();
	}
	
	public void depositar(double valor){
		this.saldo+=valor;
		System.out.println("Deposito efetuado.");
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
	
	public boolean transferirValor(Banco banco, int numConta, int numAgencia, double valor, int senha) throws SaldoInsuficienteException, SenhaIncorretaException{
		
		// implementar busca de conta
		if(this.verSaldo() < valor){
			System.out.println("Saldo insuficiente.");
			return false;
		}
		
		if(c.buscarAgencia(banco, numAgencia) != null){
			if (c.buscarConta(banco, numAgencia) != null){
				this.sacar(valor, senha);
				c.buscarAgencia(banco, numAgencia).buscarConta(numAgencia).depositar(valor);
				System.out.println("Transferencia efetuada.");
				return true;
			}
		} 
		return false;
	}
	
	public String verSituacao(){
		String sit;
		if(!ativa)
			sit = "Conta nao ativa\n";
		// adicionar limite
		else
			sit = "Conta ativa\n";

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

	public Cliente getCliente() {
		return c;
	}
	
}
