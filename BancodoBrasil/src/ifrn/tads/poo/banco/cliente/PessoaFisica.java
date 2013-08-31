package ifrn.tads.poo.banco.cliente;

import ifrn.tads.poo.banco.agencia.Agencia;
import ifrn.tads.poo.banco.agencia.Conta;

public class PessoaFisica extends Cliente {
	private int cpf;
	public PessoaFisica(String nome, String telefone, String email, int cpf
						, Agencia minhaAgencia, Conta minhaConta) {
		
		super(nome, telefone, email,minhaAgencia, minhaConta);
		this.cpf = cpf;
	}
	
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

}
