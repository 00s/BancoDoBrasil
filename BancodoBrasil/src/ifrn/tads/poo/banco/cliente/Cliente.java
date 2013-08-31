package ifrn.tads.poo.banco.cliente;
import ifrn.tads.poo.banco.agencia.*;


public abstract class Cliente {
	protected String nome, telefone, email;
	protected Conta minhaConta;
	protected Agencia minhaAgencia;
	
	Cliente(String nome, String telefone, String email, Agencia minhaAgencia, Conta minhaConta){
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.minhaConta = minhaConta;
		this.minhaAgencia = minhaAgencia;
	}
	
	public Conta buscarConta(int numero){
		return minhaConta;
	}
	
	public Agencia buscarAgencia(int numero){
		return minhaAgencia;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	
}
