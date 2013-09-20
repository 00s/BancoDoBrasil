package ifrn.tads.poo.banco.cliente;
import ifrn.tads.poo.banco.*;
import ifrn.tads.poo.banco.agencia.*;


public abstract class Cliente {
	protected String nome, email;
	protected int minhaConta;
	protected int minhaAgencia;
	protected int telefone;
	protected int senha; 
	
	Cliente(String nome, int telefone, String email, int senha){
		this.nome = nome.toUpperCase();
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
	}
	
	public Conta buscarConta(Banco banco, int numero){
       Conta conta = null;
		for (Agencia a : banco.getAgencias()){
          if(a.buscarConta(numero) != null){
        	  conta = a.buscarConta(numero);
        	  break;
          }
		}
	return conta;
	}
	
	public Agencia buscarAgencia(Banco banco, int numero){
		return banco.buscarAgencia(numero);
	}
	
	
	public abstract String toString();


	
	public String getNome() {
		return nome;
	}

	public int getTelefone() {
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
	

	
}
