package ifrn.tads.poo.banco.exceptions;

public class SenhaIncorretaException extends Exception{

	public String getMessage(String nome){
		return "---"
				+ "A senha não confere," + nome.toUpperCase() + ". \n\n   Tente novamente: \n";
	}
}
