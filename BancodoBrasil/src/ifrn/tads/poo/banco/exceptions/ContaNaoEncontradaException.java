package ifrn.tads.poo.banco.exceptions;

public class ContaNaoEncontradaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage(){
		return "Conta não encontrada.\n";
	}
}
