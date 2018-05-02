

/*
 	3 � Analisando o cen�rio a seguir, crie a classe FATURA:
�Uma loja de itens m�gicos do reino de Tundera gera uma fatura para os itens vendidos na loja. Essa fatura cont�m um N�MERO, uma DESCRI��O, a QUANTIDADE COMPRADA de determinado item e o PRE�O do produto. As necessidades da loja s�o preencher esses itens, l�-los individualmente e calcular o TOTAL da fatura (que consiste na quantidade multiplicada pelo valor do produto), mas sem armazenar esse total�

 */

public class Fatura {
	
	private int numero;
	private String descricao;
	private int qtde;
	private double preco;
	//	private double totalFatura;
	
	
	
	public Fatura() {
		super();
	}
	public Fatura(int numero, String descricao, int qtde, double preco) {
		super();
		this.numero = numero;
		this.descricao = descricao;
		this.qtde = qtde;
		this.preco = preco;
	}
	
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	/////
	
	public int getNumero() {
		return numero;
	}
	public String getDescricao() {
		return descricao;
	}
	public int getQtde() {
		return qtde;
	}
	public double getPreco() {
		return preco;
	}
	
	
	public double getTotal() {
		return preco * qtde;
	}

}
