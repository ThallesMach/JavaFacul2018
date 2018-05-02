

// exercicio 3   no Final do Código

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
	3 – Analisando o cenário a seguir, crie a classe FATURA:
“Uma loja de itens mágicos do reino de Tundera gera uma fatura
para os itens vendidos na loja. Essa fatura contém um NÚMERO, 
uma DESCRIÇÃO, a QUANTIDADE COMPRADA de determinado item e o PREÇO do produto.
As necessidades da loja são preencher esses itens, lê-los 
individualmente e calcular o TOTAL da fatura (que consiste na quantidade
		multiplicada pelo valor do produto), mas sem armazenar esse total”

*/
