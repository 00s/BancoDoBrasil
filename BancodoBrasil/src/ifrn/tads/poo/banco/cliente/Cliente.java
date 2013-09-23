package ifrn.tads.poo.banco.cliente;
import ifrn.tads.poo.banco.*;
import ifrn.tads.poo.banco.agencia.*;
import ifrn.tads.poo.banco.exceptions.AgenciaNaoEncontradaException;
import ifrn.tads.poo.banco.exceptions.ContaNaoEncontradaException;
import ifrn.tads.poo.banco.exceptions.SenhaIncorretaException;


public abstract class Cliente {
	protected String nome, email;
	protected int minhaConta;
	protected int minhaAgencia;
	protected String telefone;
	protected String senha; 
	
	Cliente(String nome, String telefone, String email, String senha){
		this.nome = nome.toUpperCase();
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
	}
	
	public Conta buscarConta(Agencia a, int numConta) throws ContaNaoEncontradaException{
		return a.buscarConta(numConta);
	}
	
	public Agencia buscarAgencia(Banco banco, int numConta) throws AgenciaNaoEncontradaException{
		return banco.buscarAgencia(numConta);
	}
	
	public abstract String toString();
	
	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setMinhaAgencia(int numAgencia){
		this.minhaAgencia = numAgencia;
	}
	
	public void setMinhaConta(int numConta){
		this.minhaConta = numConta;
	}

	public int getMinhaConta() {
		return minhaConta;
	}

	public int getMinhaAgencia() {
		return minhaAgencia;
	}
	
	public boolean checkSenha(String senha) throws SenhaIncorretaException{
		if(this.senha.equals(senha)) return true;
		throw new SenhaIncorretaException();	
	}
	
}