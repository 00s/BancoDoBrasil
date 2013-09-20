package ifrn.tads.poo.banco.exceptions;

public class SaldoInsuficienteException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage(){
		return "Impossível realizar operação. Saldo insuficiente.\n";
	}
}
