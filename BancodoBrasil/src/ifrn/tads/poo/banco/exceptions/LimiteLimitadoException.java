package ifrn.tads.poo.banco.exceptions;

public class LimiteLimitadoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage(){
		return "O limite nao pode ser menor que saldo devedor.";
	}
}
