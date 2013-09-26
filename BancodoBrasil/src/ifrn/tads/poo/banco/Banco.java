package ifrn.tads.poo.banco;
import ifrn.tads.poo.banco.agencia.*;
import ifrn.tads.poo.banco.exceptions.AgenciaNaoEncontradaException;

import java.util.ArrayList;;

public class Banco {
	private String nome;
	private ArrayList<Agencia> agencias = new ArrayList<Agencia>();
	
	
	Banco(String nome){
		this.nome = nome;
	}
	
	public Agencia buscarAgencia(int numero) throws AgenciaNaoEncontradaException{
	
		if(agencias.size() != 0){			
			for(int i=0; i< agencias.size();i++){
				if(agencias.get(i).getNumero()==numero){
					return agencias.get(i);
				}
			}
		}
		throw new AgenciaNaoEncontradaException();
	}
	
	public void adicionarAgencia(Agencia a){
		agencias.add(a);
	}

	public ArrayList<Agencia> getAgencias() {
		return agencias;
	}

	public String getNome() {
		return nome;
	}
	
}