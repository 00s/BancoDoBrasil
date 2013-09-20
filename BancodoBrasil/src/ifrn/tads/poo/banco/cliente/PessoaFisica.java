package ifrn.tads.poo.banco.cliente;

//import ifrn.tads.poo.banco.agencia.Agencia;
//import ifrn.tads.poo.banco.agencia.Conta;

public class PessoaFisica extends Cliente {
	private String cpf;
	public PessoaFisica(String nome, int telefone, String email, String cpf, int senha) {
		
		super(nome, telefone, email, senha);
		this.cpf = cpf;
	}
	
	public String toString(){
		return   "\tNome: " + getNome() 
			 + "\n\tCPF: " + getCpf()
			 + "\n\tAgência: " + super.minhaAgencia
			 + "\n\tConta: " + super.minhaConta
			 + "\n\tEmail: " + getEmail()
			 + "\n\tTelefone: " + getTelefone()
			 + "\n---";
	}
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
