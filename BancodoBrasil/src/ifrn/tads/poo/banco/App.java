package ifrn.tads.poo.banco;
import ifrn.tads.poo.banco.cliente.*;
import ifrn.tads.poo.banco.exceptions.AgenciaNaoEncontradaException;
import ifrn.tads.poo.banco.exceptions.ClienteNaoEncontradoException;
import ifrn.tads.poo.banco.exceptions.ContaNaoEncontradaException;
import ifrn.tads.poo.banco.exceptions.NumContaExistenteException;
import ifrn.tads.poo.banco.exceptions.SaldoInsuficienteException;
import ifrn.tads.poo.banco.exceptions.SenhaIncorretaException;
import ifrn.tads.poo.banco.exceptions.SenhaInvalidaException;
import ifrn.tads.poo.banco.agencia.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class App {
	static Scanner  ler = new Scanner(System.in);
	static Scanner lerTexto = new Scanner(System.in);
	public static Banco banco;
	
	static AlgoritmoDerpofoldao adp = new AlgoritmoDerpofoldao();
	static Mensagens msg = new Mensagens();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("CADASTRO DE BANCO\n Nome do banco:");
		String nomeBanco = lerTexto.nextLine();
		banco = new Banco(1, nomeBanco);
		
		System.out.println("\n Bem vindo ao " + nomeBanco.toUpperCase() + "\n-");
		Agencia a;	
		int opcao = 0;
		int gerarNumAgencia = 1;
		
	
		do{	
			try{
				msg.menuPrincipal();
				
				switch (opcao = ler.nextInt()) {
				case 1:
							a = new Agencia(gerarNumAgencia++);
							banco.adicionarAgencia(a);
							menuAgencia(a);
					break;
				case 2:
					System.out.println("Numero da agencia:");
					
					try{
						a = banco.buscarAgencia(ler.nextInt());
						menuAgencia(a);
					}catch(AgenciaNaoEncontradaException ane){}	
		
					break;
					
				case 9:
					System.out.println("Sistema Encerrado.");
					System.exit(0);
					break;
				default:
					System.out.println("Opção Inválida. Tente Novamente.\n");
					break;
				}
			}catch(InputMismatchException e){
				ler.nextLine();
				msg.entradaIncorreta();
			}
			
		}while(opcao != 9);
	}
	
	public static void menuAgencia(Agencia a){
 	
		int opAgencia = 0;
		
		do{
			try{
				msg.menuAgencia(a);
				
				switch (opAgencia = ler.nextInt()) {
					case 1: // Abre conta
			
							cadastrarCliente(a);
						break;
					case 2: // busca conta
							fluxoBuscarConta(a);
						break;
					case 3: //busca cliente em todas as agencias e imprime toString de cada cliente
						try{
							fluxoBuscarCliente();
						}catch(ClienteNaoEncontradoException c){
							System.out.println(c.getMessage());
						}
						break;
					case 4: // realiza deposito
							fluxoDeposito();
						break;
					case 5:
						break;
					default:
						msg.entradaIncorreta();
						break;
				}
			}catch(InputMismatchException e){ ler.nextLine(); msg.entradaIncorreta();}
		}while(opAgencia != 5);
		
	}
	
	public static void menuAgenciaCriarContaPessoaFisica(Agencia a){
		Cliente c;
		int qualConta = 0;
		msg.qualTipoDeConta();
		boolean contaCriada = false;
		do{
			try{
				switch (qualConta = ler.nextInt()) {
				case 1:
						
					c = cadastrarClientePessoaFisica();
					do{		
						try{	
							contaCriada = a.criarContaCorrente(c, adp.gerarNumero()); 
						}catch(NumContaExistenteException e){}
						
					}while(!contaCriada);
					break;
				
				case 2:
					
						c = cadastrarClientePessoaFisica();
					do{		
						try{		
							contaCriada = a.criarContaPoupanca(c, adp.gerarNumero());
						}catch(NumContaExistenteException i){}
					
					}while(!contaCriada);
					break;
		
				default:
					break;
				}
			}catch(InputMismatchException e){ ler.nextLine(); msg.entradaIncorreta();}
		}while(qualConta > 2 || qualConta < 1);
	}
	
	public static void criarContaPessoaJuridica(Agencia a){
		boolean contaCriada = false;
		Cliente c = cadastrarClientePessoaJuridica();
		
		do{	
			try{	
				contaCriada = a.criarContaCorrente(c, adp.gerarNumero());
			}catch(NumContaExistenteException e){}
		}while(!contaCriada);
	}
	
	
	public static void cadastrarCliente(Agencia a){

		int tipoDeCliente = 0;
		
		do {
			try{
				msg.qualTipoDeCliente();
				switch (tipoDeCliente = ler.nextInt()) {
					case 1:
							menuAgenciaCriarContaPessoaFisica(a);
						
						break;
					case 2:
							criarContaPessoaJuridica(a);
			
					default:
						break;
				}
			}catch(InputMismatchException e){ler.nextLine(); msg.entradaIncorreta();}
		}while(tipoDeCliente > 2 || tipoDeCliente < 1);
	}
	
	public static PessoaFisica cadastrarClientePessoaFisica(){
		
			msg.qualNome();
			String nome = lerTexto.nextLine();
			
			msg.qualTelefone();
			String telefone = ler.next();

			msg.qualEmail();
			String email = ler.next();
			
			msg.qualCPF();
			String cpf = lerTexto.nextLine();
			
			String senha = null;
			boolean senhasOK = false;
		
			do {
				try {
					 
					senha = criarSenha();
					senhasOK = true;
				
				} catch (SenhaInvalidaException e){
					System.out.println(e.getMessage());
				} catch (SenhaIncorretaException e) {
					System.out.println(e.getMessage(nome));
	
				}
			} while (!senhasOK);
			
		return new PessoaFisica(nome, telefone, email, cpf, senha);
		
		
	}
	
	public static PessoaJuridica cadastrarClientePessoaJuridica(){
		msg.qualNome();
		String nome = lerTexto.nextLine();
		
		msg.qualTelefone();
		String telefone = ler.next();
		
		msg.qualEmail();
		String email = ler.next();
		
		msg.qualNomeFantasia();
		String nomeFantasia = lerTexto.nextLine();
		
		msg.qualCNPJ();
		String cnpj = ler.next();
		
		String senha = null;
		boolean senhasOK = false;
	
		do {
			try {
				 
				senha = criarSenha();
				senhasOK = true;
			} catch(SenhaInvalidaException e){
				System.out.println(e.getMessage());
			} catch (SenhaIncorretaException e) {
				System.out.println(e.getMessage(nome));

			}
		} while (!senhasOK);
		
		return new PessoaJuridica(nome, telefone, email, nomeFantasia, cnpj, senha);
	}

	public static void menuConta(ContaCorrente cc){
		int opMenuConta = 0;
	do{	
		try{
			msg.menuContaCorrente();
			
			opMenuConta = ler.nextInt();
			
			switch (opMenuConta) {
			case 1: // consultar saldo
			   System.out.printf("Sr(a). %s, seu saldo atual (com limite) Ã© de %.2f.\n\n", cc.getCliente().getNome(), cc.getSaldo());
				
				break;
			case 2: // ver situacao da conta
				System.out.println(cc.verSituacao());
				
				break;
			case 3: // Sacar
				fluxoSaque(cc);
				
				break;
				
			case 4: // transferencia
				fluxoTransferencia(cc);
				
				break;
			case 5: // alterar limite
				fluxoAlteracaoDeLimite(cc);
				
				break;
			case 6: // cancelar
				break;
	
			default:
				break;
			}
		}catch(InputMismatchException e){ ler.nextLine(); msg.entradaIncorreta();}	
	}while(opMenuConta != 6);	
		
	}
	
	
	public static void menuConta(ContaPoupanca cp){
		int opMenuConta = 0;
		
		do{	
			try{
				msg.menuContaPoupanca();
				
				opMenuConta = ler.nextInt();
				
				switch (opMenuConta) {
				case 1: // consultar saldo
				   System.out.printf("Sr(a). %s, seu saldo atual e de %.2f.\n", cp.getCliente().getNome(), cp.getSaldo());
					
					break;
				case 2: // ver situacao da conta
					System.out.println(cp.verSituacao());
					
					break;
				case 3: // Sacar
					fluxoSaque(cp);
					
					break;
					
				case 4: // transferencia
					fluxoTransferencia(cp);
					
					break;
				
				case 5: // cancelar
					break;
		
				default:
					msg.entradaIncorreta();
					break;
				}	
			}catch(InputMismatchException e){ ler.nextLine(); msg.entradaIncorreta();}
		}while(opMenuConta != 5);
	}

	
	private static void fluxoSaque(Conta conta){
		try{
			System.out.println("Informe o valor do saque:\n");
			double valor = ler.nextDouble();
			System.out.println("Informe a senha:\n");
			String senha = ler.next();
			conta.sacar(valor, senha);
			System.out.println("Saque efetuado.\n---\n");
				
		}catch (SenhaIncorretaException s){
			System.out.println(s.getMessage(conta.getCliente().getNome()));
		}catch (SaldoInsuficienteException s){
			System.out.println(s.getMessage()); /// TRYCATCHCCCCH
		}catch(InputMismatchException e){ ler.nextLine(); msg.entradaIncorreta();}	
	}
	
	private static void fluxoDeposito(){
		try{
			System.out.println("Informe o numero da agencia da conta a ser realizado o deposito: \n");
			int numAgencia = ler.nextInt();
			System.out.println("Informe o numero da conta de destino: \n");
			int numConta = ler.nextInt();
			System.out.println("Informe o valor do deposito: \n");
			double valor = ler.nextDouble();
			
			banco.buscarAgencia(numAgencia).buscarConta(numConta).depositar(valor);
			System.out.println("Depósito efetuado.\n");
				
			}catch(AgenciaNaoEncontradaException ane){
				System.out.println(ane.getMessage());
			}catch(ContaNaoEncontradaException cne){
				System.out.println(cne.getMessage());
			}catch(InputMismatchException e){ ler.nextLine(); msg.entradaIncorreta();}
	}
	
	private static void fluxoTransferencia(Conta conta){
		try{
			System.out.println("Informe o numero da agencia da conta a ser realizada a transferencia: \n");
			int numAgencia = ler.nextInt();
			System.out.println("Informe o numero da conta de destino: \n");
			int numConta = ler.nextInt();
			System.out.println("Informe o valor da transferencia: \n");
			double valor = ler.nextDouble();
			System.out.println("informe a sua senha:\n");
			String senha = ler.next();
			
			conta.transferirValor(banco, numConta, numAgencia, valor, senha);
		
		}catch(AgenciaNaoEncontradaException ane){
			System.out.println(ane.getMessage());
		}catch(ContaNaoEncontradaException cne){
			System.out.println(cne.getMessage());
		}catch(SaldoInsuficienteException si){
			System.out.println(si.getMessage());
		}catch(SenhaIncorretaException sei){
			System.out.println(sei.getMessage(conta.getCliente().getNome()));
		}catch(InputMismatchException e){ ler.nextLine(); msg.entradaIncorreta();}
	}
	
	private static void fluxoAlteracaoDeLimite(ContaCorrente cc){ // catch ContaInvalidaException
		double novoLimite;
		try{	
			if(cc.isAtiva()){
				System.out.println("Insira novo limite: \n");
			do{	
				novoLimite = ler.nextDouble();
				
				if(novoLimite < 0) {
					System.out.println("O limite não pode ser negativo. Tente novamente.\n");
				}
			}while(novoLimite <0);	
				cc.mudarLimiteDaConta(novoLimite);
				System.out.println("Limite alterado para: " + novoLimite +".\n---\n");
			
			}
		}catch(InputMismatchException e){ ler.nextLine(); msg.entradaIncorreta();}
	}
	
	private static void fluxoBuscarConta(Agencia a){
		
		try{
			msg.qualTipoDeConta();
			int qualTipoDeConta = ler.nextInt();
			msg.qualNumeroDaConta();
			int numConta = ler.nextInt();
			
			switch (qualTipoDeConta) {
			case 1: // Conta corrente
				ContaCorrente cc;
				try	{
					cc = (ContaCorrente) a.buscarConta(numConta);	
					System.out.println(cc.verInformacoesCliente().toString());
					menuConta(cc);
				}catch(ContaNaoEncontradaException cne){
					System.out.println(cne.getMessage());
				}catch(ClassCastException cce){
					System.out.println("Esta conta não é do tipo conta poupança.\n");
				}
	
				
				break;
			
			case 2: //  Conta poupanÃ§a
				ContaPoupanca cp;
				try{
					cp = (ContaPoupanca) a.buscarConta(numConta);
					System.out.println(cp.verInformacoesCliente().toString());
					menuConta(cp);
				}catch(ContaNaoEncontradaException cne){
					System.out.println(cne.getMessage());
				}catch(ClassCastException cce){
					System.out.println("Esta conta não é do tipo conta corrente.\n");
				}
				
				
				break;
		
			default:
				msg.entradaIncorreta();
				break;
			}
		}catch(InputMismatchException e){ ler.nextLine(); msg.entradaIncorreta();}		
	}
	
	private static void fluxoBuscarCliente() throws ClienteNaoEncontradoException{	
		ArrayList<Cliente> clientesEncontrados = new ArrayList<Cliente>();
		
		System.out.println("Insira o nome do cliente a ser encontrado");
		try{	
			String nomeCliente = lerTexto.nextLine().toUpperCase();
			
			for(int i = 0; i< banco.getAgencias().size(); i++){
				clientesEncontrados.addAll(banco.getAgencias().get(i).buscarCliente(nomeCliente));
			}
				if(clientesEncontrados.size() != 0){
					for(Cliente c : clientesEncontrados){
						System.out.println(c.toString());
					}
				} else throw new ClienteNaoEncontradoException(nomeCliente);
				
		}catch(InputMismatchException e){ ler.nextLine(); msg.entradaIncorreta();}
	}
	
	private static String criarSenha() throws SenhaIncorretaException, SenhaInvalidaException{
		
		msg.qualSenha();
	    String senha1 = ler.next();
	    if(!senha1.contains(" ")){
	    	msg.ConfirmeSenha();
	    	String senha2 = ler.next();
	    	return checarSenha(senha1, senha2);
	    }
	    throw new SenhaInvalidaException();
	}
	
	private static String checarSenha(String senha1, String senha2) throws SenhaIncorretaException
	
	{
		if(senha1.equals(senha2)) return senha1;

		throw new SenhaIncorretaException();
	}
	
}


/*
 * .jar
 * criar metodos de verificaÃ§ao de datas para juros e rendimentos 
 */