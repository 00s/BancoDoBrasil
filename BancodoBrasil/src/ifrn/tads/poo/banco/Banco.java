package ifrn.tads.poo.banco;

public class Banco {
	private String nome;
	private int numero;
	
	Banco(int numero, String nome){
		this.nome = nome;
		this.numero = numero;
	}
	
	public Agencia buscarAgencia(int numero){
		return;
	}
	
	public void adicionarAgencia(Agencia a){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
}
