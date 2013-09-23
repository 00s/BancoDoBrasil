package ifrn.tads.poo.banco.exceptions;

public class SenhaInvalidaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage(){
		return "A senha não pode conter espaços.\n";
	}
}
