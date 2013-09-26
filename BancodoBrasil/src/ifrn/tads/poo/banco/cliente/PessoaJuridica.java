package ifrn.tads.poo.banco.cliente;

public class PessoaJuridica extends Cliente{
	private String nomeFantasia, cnpj;
	public PessoaJuridica(String nome, String telefone, String email, String nomeFantasia, String cnpj, String senha){
		
		super(nome, telefone, email, senha);
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
	}
	
	public String toString(){
		return "\tNome: " + getNome()
				+ "\n\tCNPJ: "  + getCnpj() 
				+ "\n\tAgência: " + super.minhaAgencia
				+ "\n\tConta: " + super.minhaConta
				+ "\n\tNome Fantasia: "	+ getNomeFantasia()
				+ "\n\tEmail: " + getEmail() 
				+ "\n\tTelefone: "	+ getTelefone() 
				+ "\n---";
	}
	
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}