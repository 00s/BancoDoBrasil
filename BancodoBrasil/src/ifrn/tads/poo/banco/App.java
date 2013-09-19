package ifrn.tads.poo.banco;
import ifrn.tads.poo.BancoExceptions.NumContaExistenteException;
import ifrn.tads.poo.BancoExceptions.SenhaIncorretaException;
import ifrn.tads.poo.banco.cliente.*;
import ifrn.tads.poo.banco.agencia.*;

import java.util.ArrayList;
import java.util.Scanner;


public class App {
	static Scanner  ler = new Scanner(System.in);
	static Scanner lerTexto = new Scanner(System.in);
	public static Banco banco;
	PessoaJuridica pj;
	static AlgoritmoDerpofoldao adp = new AlgoritmoDerpofoldao();
	static Mensagens msg = new Mensagens();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("CADASTRAR BANCO:\n"
				+ "Novo banco");
		
		banco = new Banco(40052505, "Banco do Brasil");
		Agencia a;
		int opcao;
		int gerarNumAgencia = 1;
		
	
	do{	
		
		msg.menuPrincipal();
		
		switch (opcao = ler.nextInt()) {
		case 1:
				
					a = new Agencia(gerarNumAgencia++);
					banco.adicionarAgencia(a);
					menuAgencia(a);
			break;
		case 2:
			System.out.println("Numero da agencia:\n");
			//try{
				a = banco.buscarAgencia(ler.nextInt());
				menuAgencia(a);
			//}catch(){ }

			break;
			
		case 9:
			System.out.println("Sistema Encerrado.");
			System.exit(0);
			break;

		default:
			msg.entradaIncorreta();
			break;
		}
		
	}while(opcao != 9);	
		
	
	
	}
	
	public static void menuAgencia(Agencia a){
 	
		int opAgencia;
		
		do{
			msg.menuAgencia(a);
			
			switch (opAgencia = ler.nextInt()) {
				case 1: // Abre conta
		
						cadastrarCliente(a);
					break;
				
				case 2: // busca conta
						
						fluxoBuscarConta(a);
					break;
					
				case 3: //busca cliente em todas as agencias e imprime toString de cada cliente
						
						fluxoBuscarCliente();
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
		}while(opAgencia != 5);
		
	}
	
	public static void menuAgenciaCriarContaPessoaFisica(Agencia a){
		Cliente c;
		int qualConta;
		msg.qualTipoDeConta();
		boolean contaCriada = false;
		do{
			switch (qualConta = ler.nextInt()) {
			case 1:
					
					c = cadastrarClientePessoaFisica();
			do{		
				try{	
					a.criarContaCorrente(c, adp.gerarNumero());
					contaCriada = true;
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

		int tipoDeCliente;
		
		do {
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
		}while(tipoDeCliente > 2 || tipoDeCliente < 1);
	}
	
	public static PessoaFisica cadastrarClientePessoaFisica(){
		msg.qualNome();
		String nome = lerTexto.nextLine();		// criar sempre?
		
		msg.qualTelefone();
		int telefone = ler.nextInt();
		
		msg.qualEmail();
		String email = ler.next();
		
		msg.qualCPF();
		int cpf = ler.nextInt();
		
		msg.qualSenha();
		int senha = ler.nextInt();
		
		return new PessoaFisica(nome, telefone, email, cpf, senha);
		
	}
	
	public static PessoaJuridica cadastrarClientePessoaJuridica(){
		msg.qualNome();
		String nome = lerTexto.nextLine();
		
		msg.qualTelefone();
		int telefone = ler.nextInt();
		
		msg.qualEmail();
		String email = ler.next();
		
		msg.qualNomeFantasia();
		String nomeFantasia = lerTexto.nextLine();
		
		msg.qualCNPJ();
		int cnpj = ler.nextInt();
		
		int senha = -1;
		boolean senhasOK = false;
	
		do {
			try {
				 
				senha = criarSenha();
				senhasOK = true;
				
			} catch (SenhaIncorretaException e) {
				System.out.println(e.getMessage(nome));

			}
		} while (!senhasOK);
		
		return new PessoaJuridica(nome, telefone, email, nomeFantasia, cnpj, senha);
	}

	public static void menuConta(ContaCorrente cc){
		int opMenuConta;
	do{	
		msg.menuContaCorrente();
		
		opMenuConta = ler.nextInt();
		
		switch (opMenuConta) {
		case 1: // consultar saldo
		   System.out.printf("Sr(a). %s, seu saldo atual e de %.2f.\n", cc.getCliente().getNome(), cc.getSaldo());
			
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
	}while(opMenuConta != 6);	
		
	}
	
	
	public static void menuConta(ContaPoupanca cp){
		int opMenuConta;
		
		msg.menuContaPoupanca();
		
		opMenuConta = ler.nextInt();
		
		switch (opMenuConta) {
		case 1: // consultar saldo
		   System.out.printf("Sr(a). %s, seu saldo atual e de %f.\n", cp.getCliente().getNome(), cp.getSaldo());
			
			break;
		case 2: // ver situa��o da conta
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
	}

	
	private static void fluxoSaque(Conta conta){
		System.out.println("Informe o valor do saque:\n");
		if(conta.sacar(ler.nextDouble())){
			System.out.println("Saque efetuado.");
		}else System.out.println("Saldo insuficiente.");  /// TRYCATCHCCCCH
	}
	
	private static void fluxoDeposito(){
		
		System.out.println("Informe o numero da agencia da conta a ser realizado o deposito: \n");
		int numAgencia = ler.nextInt();
		System.out.println("Informe o numero da conta de destino: \n");
		int numConta = ler.nextInt();
		System.out.println("Informe o valor do deposito: \n");
		double valor = ler.nextDouble();
		
		banco.buscarAgencia(numAgencia).buscarConta(numConta).depositar(valor);
		
	}
	
	private static void fluxoTransferencia(Conta conta){

		System.out.println("Informe o numero da agencia da conta a ser realizada a transferencia: \n");
		int numAgencia = ler.nextInt();
		System.out.println("Informe o numero da conta de destino: \n");
		int numConta = ler.nextInt();
		double valor = ler.nextDouble();
		System.out.println("Informe o valor da transferencia: \n");
		
		conta.transferirValor(banco, numConta, numAgencia, valor);
		
	}
	
	private static boolean fluxoAlteracaoDeLimite(ContaCorrente cc){ // catch ContaInvalidaException
			
		if(cc.isAtiva()){
			System.out.println("Insira novo limite: \n");
			double novoLimite = ler.nextDouble();
			cc.mudarLimiteDaConta(novoLimite);
			return true;
		}
		return false;
	}
	
	private static void fluxoBuscarConta(Agencia a){
		
		msg.qualTipoDeConta();
		int qualTipoDeConta = ler.nextInt();
		msg.qualNumeroDaConta();
		int numConta = ler.nextInt();
		
		switch (qualTipoDeConta) {
		case 1: // Conta corrente
			ContaCorrente cc = (ContaCorrente) a.buscarConta(numConta);	
			if(cc != null){
				System.out.println(cc.verInformacoesCliente().toString());
				menuConta(cc);
			}
			break;
		
		case 2: //  Conta poupan�a
			ContaPoupanca cp = (ContaPoupanca) a.buscarConta(numConta);
			if(cp != null){
				System.out.println(cp.verInformacoesCliente().toString());
				menuConta(cp);
			}
			break;
	
		default:
			msg.entradaIncorreta();
			break;
		}
	}
	private static void fluxoBuscarCliente(){	
		System.out.println("Insira o nome do cliente a ser encontrado");
		String nomeCliente = lerTexto.nextLine().toUpperCase();
		ArrayList<Cliente> clientesEncontrados = new ArrayList<Cliente>();
		
		for(int i = 0; i< banco.getAgencias().size(); i++){
			clientesEncontrados.addAll(banco.getAgencias().get(i).buscarCliente(nomeCliente));
		}
		
		for(Cliente c : clientesEncontrados){
			System.out.println(c.toString());
		}
	}
	
	private static int criarSenha() throws SenhaIncorretaException{
		
		msg.qualSenha();
	    int senha1 = ler.nextInt();
	
	    msg.ConfirmeSenha();
	    int senha2 = ler.nextInt();
	    
	    return checarSenha(senha1, senha2);
	    
	}
	
	
	private static int checarSenha(int senha1, int senha2) throws SenhaIncorretaException
	
	{
		if(senha1 == senha2) return senha1;

		throw new SenhaIncorretaException();
	}
}


/*
 * .jar
 * criar m�todos de verifica�ao de datas para juros e rendimentos
 * alterar fluxo do menu
 * corrigir par�metriza��o 
 */
