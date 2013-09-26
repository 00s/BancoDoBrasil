package ifrn.tads.poo.banco.agencia;

import ifrn.tads.poo.banco.cliente.Cliente;
import ifrn.tads.poo.banco.exceptions.LimiteLimitadoException;
import ifrn.tads.poo.banco.exceptions.SaldoInsuficienteException;
import ifrn.tads.poo.banco.exceptions.SenhaIncorretaException;

public class ContaCorrente extends Conta {
	private double limite;
	public ContaCorrente(int numero, Cliente c) {
		super(numero, c);
		this.limite = 250;
	}
	
	public boolean mudarLimiteDaConta(double novoLimite) throws LimiteLimitadoException{
		
		if(novoLimite - getSaldo() >=0){
			this.limite = novoLimite;
			return true;
		} throw new LimiteLimitadoException();
	}
	

	public double getSaldo() {
		return saldo + limite;
	}
	
	public boolean sacar(double valor, String senha) throws SaldoInsuficienteException, SenhaIncorretaException{
		
		if(!c.checkSenha(senha)){
			throw new SenhaIncorretaException();
		}
	
		if (getSaldo() - valor >= 0){
				this.saldo-= valor;
				return true;
		}		
		throw new SaldoInsuficienteException();
	}
	
	
}
