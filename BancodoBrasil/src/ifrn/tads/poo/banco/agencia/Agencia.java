package ifrn.tads.poo.banco.agencia;
import ifrn.tads.poo.banco.cliente.*;
import java.util.ArrayList;
public class Agencia {

	private ArrayList<Conta> contas = new ArrayList<Conta>();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private int numero;
	private String nome, endereco, nomeGerente;

	public Agencia(int numero){
		this.numero = numero;
	}	

	public boolean criarContaCorrente(Cliente c, int numConta){
		
	//	try{
			ContaCorrente conta = new ContaCorrente(numConta, c);
			contas.add(conta);
			clientes.add(c);
			c.setMinhaAgencia(this.numero);
			c.setMinhaConta(numConta);
			return true;
//		}throws(numContaInvalidoException e){
			
//		}
	}

	public boolean criarContaPoupanca(Cliente c, int numConta){
//		try{
			ContaPoupanca conta =  new ContaPoupanca(numConta, c);
			contas.add(conta);
			clientes.add(c);
			c.setMinhaAgencia(this.numero);
			c.setMinhaConta(numConta);
			return true;
//		}throws(numContaInvalidoException e){
			
//		}
		
	}
	
	
	public Conta buscarConta(int numero){
	
		for (int c = 0; c < contas.size(); c++){
		
			if(contas.get(c).getNumero()==numero){
				return contas.get(c);
			}
		}
	System.out.println("Conta n�o encontrada.");
	return null;
	}

	public ArrayList<Cliente> buscarCliente(String nome){
		ArrayList<Cliente> clientesEncontrados = new ArrayList();
	
		for(int c = 0; c< clientes.size(); c++){
		
			if(clientes.get(c).getNome().contains(nome)){
				clientesEncontrados.add(clientes.get(c));
			}
		}
	return clientesEncontrados;
	}

	public ArrayList<Conta> getContas() {
		return contas;
	}

	public void setContas(ArrayList<Conta> contas) {
		this.contas = contas;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNomeGerente() {
		return nomeGerente;
	}

	public void setNomeGerente(String nomeGerente) {
		this.nomeGerente = nomeGerente;
	}
	
	
}