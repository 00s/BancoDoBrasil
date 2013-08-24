package ifrn.tads.poo.banco.agencia;

public class Agencia {
	
	private int numero;
	private String nome, endereco, nomeGerente;
	
	Agencia(int numero){
		this.numero = numero;
	}
	
	public boolean criarConta(Cliente c, int numConta, int limConta, String tipoConta){
		// método a ser aplicado com banco de dados
	}
	
	public Conta buscarConta(int numero){
		// método a ser aplicado com banco de dados
		return;
	}
	
	public Cliente[] buscarCliente(String nome){
		// método a ser aplicado com banco de dados
		return;
	}
	
}
