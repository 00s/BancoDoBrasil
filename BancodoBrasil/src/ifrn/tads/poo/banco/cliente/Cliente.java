package ifrn.tads.poo.banco.cliente;
import ifrn.tads.poo.banco.agencia.*;


public abstract class Cliente {
	protected String nome, telefone, email;
	protected Conta numeroConta;
	protected Agencia numeroAgencia;
	
	Cliente(String nome, String telefone, String email){
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}
	
	public Conta buscarConta(int numero){
		return numeroConta;
	}
	
	public Agencia buscarAgencia(int numero){
		return numeroAgencia;
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
