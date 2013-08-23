package ifrn.tads.poo.banco.cliente;

public class PessoaJuridica extends Cliente{
	private String nomeFantasia;
	private int cnpj;
	public PessoaJuridica(String nome, String telefone, String email, String nomeFantasia, int cnpj){
		super(nome, telefone, email);
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
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
