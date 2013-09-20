package ifrn.tads.poo.banco.agencia;

import java.util.Random;
public class AlgoritmoDerpofoldao {

	Random number = new Random();
	int counter = 1, pre;
	
	
	public AlgoritmoDerpofoldao() {
		do  {	
			pre = number.nextInt(9999);
	     	} while(pre<1000);
	}
	public AlgoritmoDerpofoldao(int pre){
		this.pre = pre;
	}
	
	public int gerarNumero(){
	
		
		int numeroValido = derpofoldao(pre, pre, 0);
	//	System.out.println(numeroValido);
		return numeroValido;
	}
	
	private int derpofoldao(int in,int pre, int out){
	
		if(in == 0) return adicionarDigito(pre, out);
		return derpofoldao(in/10, pre, ((in%10)*++counter)+out);
	}
	
	private int adicionarDigito(int pre, int out){
		
		int resto = out%11;
		
		if(resto<2){
			return pre*10;
		}else{
			return (pre*10)+(resto-2);
		}
	}
}
