package ifrn.tads.poo.banco.agencia;

import ifrn.tads.poo.banco.cliente.Cliente;

import java.util.Date;

public class ContaPoupanca extends Conta {
	private Date aniversario;
	
	@SuppressWarnings("deprecation")
	public ContaPoupanca(int numero, Cliente c) {
		super(numero, c);
		aniversario.getDate(); // verificar se este é o método correto
	}
	
	void calcularRendimentoDoMes (){
		
	}
}
