

// exercicio 3

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
