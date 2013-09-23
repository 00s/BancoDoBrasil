package ifrn.tads.poo.banco.agencia;
import ifrn.tads.poo.banco.cliente.Cliente; 

import java.text.SimpleDateFormat;
import java.util.Date; 

public class ContaPoupanca extends Conta { 
	final double MES_EM_MILISEGUNDOS = 1000 * 60 * 60 * 24 * 30.5; // média de mês com 30.5 por ano, para se aproximar, a cada 4 anos da variação gerada pelo ano bissexto.
	private Date ultimaData; // ultima data usada para aplicar rendimento
	private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	private String dataAniversario;	
	
	public ContaPoupanca(int numConta, Cliente c){ 
		super(numConta, c); 
 
		this.ultimaData = new Date();

		dataAniversario = format.format(this.ultimaData); // armazena a data de criaçao da conta.
	} 
	
	public void aplicarRendimento(){
		
		Date hoje = new Date();
		double dif = diferencaMeses(hoje);
		
		while(dif-- > 0){
 			this.saldo *= 1.005;
 		}
		setAniversario(hoje); // faz com que o próximo calculo seja executado a partir deste.
							 // data de criação da conta armazenada em dataAniversario
			//System.out.printf("O rendimento no momento e: %.2f\n", this.saldo);

		}
	public double getSaldo(){
		aplicarRendimento();
		return this.saldo;
	}
	
//	public void aplicarRendimento(String data) throws ParseException{
//
//		Date hoje = format.parse(data);
//		double dif = diferencaMeses(hoje);
//		System.out.println(dif);
//		while(dif-- > 0){
//			this.saldo *= 1.005;
//		}
//		setAniversario(hoje); // faz com que o próximo calculo seja executado a partir deste.
//							 // data de criação da conta armazenada em dataAniversario
//			System.out.printf("O rendimento no momento e: %.2f\n", this.saldo);
//	}

	public void setAniversario(Date hoje) {
		this.ultimaData = hoje;
	}

	public long diferencaMeses(Date hoje){
		return (long) ((long) ( hoje.getTime() - ultimaData.getTime())/MES_EM_MILISEGUNDOS);
	} 

	public String getDataAniversario(){
		return dataAniversario + "\n";
	}
}