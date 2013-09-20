package ifrn.tads.poo.banco.exceptions;

public class SenhaIncorretaException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage(String nome){
		return "---\n"
				+ "A senha não confere," + nome.toUpperCase() + ". \n\n   Tente novamente: \n";
	}
}
