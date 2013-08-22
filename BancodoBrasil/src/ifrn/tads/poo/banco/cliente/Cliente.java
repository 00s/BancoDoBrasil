package ifrn.tads.poo.banco.cliente;

public abstract class Cliente {
	protected String nome, telefone, email;
	
	Cliente(){}
	
	public Conta buscarConta(int numero){
		return null;
	}
	
	public Agencia buscarAgencia(int numero){
		return null;
	}
	
}
