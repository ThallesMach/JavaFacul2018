

// exercicio 3   no Final do C�digo

public class Conta {
	
	//	private Integer numero;
	private double saldo;

	
	
	public Conta() {
		//super();
	}

	public Conta(double saldoInicial) {
		//super();
		this.saldo = saldoInicial;
	}

	
	
	public double getSaldo() {
		return saldo;
	}
	
	public void acrescentaCredito(double credito) {
//		saldo = saldo + credito;
//		this.saldo = this.saldo + credito
//		this.saldo += credito;
		saldo += credito;
	}

//	public void setSaldo(double saldo) {
//		this.saldo = saldo;
//	}
	
	
}

/*
	3 � Analisando o cen�rio a seguir, crie a classe FATURA:
�Uma loja de itens m�gicos do reino de Tundera gera uma fatura
para os itens vendidos na loja. Essa fatura cont�m um N�MERO, 
uma DESCRI��O, a QUANTIDADE COMPRADA de determinado item e o PRE�O do produto.
As necessidades da loja s�o preencher esses itens, l�-los 
individualmente e calcular o TOTAL da fatura (que consiste na quantidade
		multiplicada pelo valor do produto), mas sem armazenar esse total�

*/
