package ifrn.tads.poo.banco.cliente;

public class PessoaFisica extends Cliente {
	private int cpf;
	public PessoaFisica(String nome, String telefone, String email, int cpf) {
		super(nome, telefone, email);
		this.cpf = cpf;
	}
	
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

}
