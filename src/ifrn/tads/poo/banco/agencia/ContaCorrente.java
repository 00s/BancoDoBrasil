package ifrn.tads.poo.banco.agencia;

public class ContaCorrente extends Conta {
	private double limite;
	public ContaCorrente() {

	}
	
	
	public void mudarLimiteDeConta(double novoLimite){
		this.limite = novoLimite;
	}
	
}
