package ifrn.tads.poo.banco.cliente;
import ifrn.tads.poo.banco.agencia.*;


public abstract class Cliente {
	protected String nome, email;
	protected int minhaConta;
	protected int minhaAgencia;
	protected int telefone;
	Cliente(String nome, int telefone, String email){
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		
	}
	
	public Conta buscarConta(int numero){
//		return minhaConta;
	}
	
	public Agencia buscarAgencia(int numero){
//		return minhaAgencia;
	}

	public String getNome() {
		return nome;
	}

	public int getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	
}
