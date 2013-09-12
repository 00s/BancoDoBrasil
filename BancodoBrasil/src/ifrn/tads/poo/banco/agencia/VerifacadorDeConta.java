package ifrn.tads.poo.banco.agencia;

public class VerifacadorDeConta {
	
	AlgoritmoDerpofoldao alg;
	
	public boolean verificar(int numConta){
		
	//	try{
			alg = new AlgoritmoDerpofoldao(numConta/10);
			int testeNumero = alg.gerarNumero();
			if (testeNumero == numConta) return true;
	//	}catch(ContaInvalidaException e){	
	//	}
return false;
	}
}
