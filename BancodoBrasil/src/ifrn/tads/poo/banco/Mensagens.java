package ifrn.tads.poo.banco;
import ifrn.tads.poo.banco.agencia.*;

public class Mensagens {


	public void entradaIncorreta(){
		System.out.println("Entrada incorreta. Tente novamente.");
	}
	
	public void menuPrincipal(){
		System.out.println("______________________\n"
						 + "1 - Cadastrar Agencia\n"
						 + "2 - Acessar Agencia\n"
						 + "9 - Sair\n");
	}
	
	public void menuAgencia(Agencia a){
		System.out.printf("---\n"
						+ "Agencia %d.\n"
						+ "---\n"
						+ "1 - Abrir nova conta\n"
						+ "2 - Buscar conta\n"
						+ "3 - Buscar cliente\n" 
						+ "4 - Realizar deposito\n"
						+ "5 - Voltar\n", a.getNumero());
	}
	
	public void menuContaCorrente(){
		System.out.println("1 - Consultar Saldo\n" +
						   "2 - Ver Situacao da conta\n" +
						   "3 - Saque\n" +
						   "4 - Transferencia\n" +
						   "5 - Alterar limite \n" +
						   "6 - Cancelar\n");
	}
	
	public void menuContaPoupanca(){
		System.out.println( "1 - Consultar Saldo\n" +
				   			"2 - Ver Situacao da conta\n" +
				   			"3 - Saque\n" +
				   			"4 - Transferencia\n" +
				   			"5 - Cancelar\n");
		
	}
	
	public void qualTipoDeConta(){
		System.out.println("1 - Conta Corrente\n"
				 + "2 - Conta poupanca\n");
	}
	
	public void qualTipoDeCliente(){
		System.out.println("1 - Pessoa Fisica\n"
				 + "2 - Pessoa Juridica");
	}
	
	public void qualNome(){
		System.out.println("Nome:");
	}
	
	public void qualTelefone(){
		System.out.println("Telefone:");
	}
	
	public void qualEmail(){
		System.out.println("Email:");
	}
	
	public void qualCPF(){
		System.out.println("CPF:");
	}	
	
	public void qualCNPJ(){
		System.out.println("CNPJ:");
	}
	
	public void qualNomeFantasia(){
		System.out.println("Nome Fantasia:");
	}
	
	public void qualNumeroDaConta(){
		System.out.println("Digite o numero da conta: \n");
	}
	
	public void qualSenha(){
		System.out.println("Digite sua senha: \n");
	}
	
	public void ConfirmeSenha(){
		System.out.println("Confirme sua senha: \n ");
	}
}
