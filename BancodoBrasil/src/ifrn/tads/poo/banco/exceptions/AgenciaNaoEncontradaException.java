package ifrn.tads.poo.banco.exceptions;

public class AgenciaNaoEncontradaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage(){
		return "Agencia nao encontrada.\n";
	}
}
