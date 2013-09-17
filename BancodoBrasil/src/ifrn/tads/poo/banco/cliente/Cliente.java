package ifrn.tads.poo.banco.cliente;
import ifrn.tads.poo.banco.*;
import ifrn.tads.poo.banco.agencia.*;


public abstract class Cliente {
	protected String nome, email;
	protected int minhaConta;
	protected int minhaAgencia;
	protected int telefone;
	
	Cliente(String nome, int telefone, String email){
		this.nome = nome.toUpperCase();
		this.telefone = telefone;
		this.email = email;
		
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

	
}
