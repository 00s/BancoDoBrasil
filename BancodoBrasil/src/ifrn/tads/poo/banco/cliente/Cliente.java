package ifrn.tads.poo.banco.cliente;

public abstract class Cliente {
	protected String nome, telefone, email;
	
	Cliente(String nome, String telefone, String email){
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}
	
	public Conta buscarConta(int numero){
		return null; // implementar com banco de dados
	}
	
	public Agencia buscarAgencia(int numero){
		return null; // implementar com banco de dados
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
