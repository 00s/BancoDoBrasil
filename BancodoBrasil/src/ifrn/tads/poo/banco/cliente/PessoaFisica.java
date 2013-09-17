package ifrn.tads.poo.banco.cliente;

//import ifrn.tads.poo.banco.agencia.Agencia;
//import ifrn.tads.poo.banco.agencia.Conta;

public class PessoaFisica extends Cliente {
	private int cpf;
	public PessoaFisica(String nome, int telefone, String email, int cpf) {
		
		super(nome, telefone, email);
		this.cpf = cpf;
	}
	
	public String toString(){
		return "\tNome: " + getNome() + "\n\tCPF: " + getCpf() + "\n\tEmail: " + getEmail() +
				"\n\tTelefone: " + getTelefone() + "\n ---";
	}
	
	
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

}
