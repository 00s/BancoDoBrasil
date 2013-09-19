package ifrn.tads.poo.banco.cliente;

//import ifrn.tads.poo.banco.agencia.Agencia;
//import ifrn.tads.poo.banco.agencia.Conta;

public class PessoaJuridica extends Cliente{
	private String nomeFantasia;
	private int cnpj;
	public PessoaJuridica(String nome, int telefone, String email, String nomeFantasia, int cnpj, int senha){
		
		super(nome, telefone, email, senha);
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
	}
	
	public String toString(){
		return "\tNome: " + getNome() + "\n\tNome Fantasia: " + getNomeFantasia() + "\n\tCPF: " 
	          + getCnpj() + "\n\tEmail: " + getEmail() + "\n\tTelefone: " + getTelefone() + "\n ---";
	}
	
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public int getCnpj() {
		return cnpj;
	}
	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

}
