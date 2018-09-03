package dao;
/*Essa classe ser� usada para manipularmos nossa conex�o com o banco de dados!
 * Nela faremos a conex�o
 * O envio de instru��es que modificam os dados de uma tabela
 * O envio de instru��es que retornam dados de uma tabela
 * */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private String servidor;
	private String porta;
	private String usuario;
	private String senha;
	
	private Connection conexao;
	
	public Conexao() {
		servidor = "oracle.fiap.com.br";
		porta = "1521";
		usuario= "PF0737";
		senha="C68C94";
	}
	
	public void abrirConexao( ) {
		/*Vou criar meus paramentos de conection
		 * para depois tentar abrir a conexao em si
		 * */
		
		// String de Connection
		// String de connection Aguarda os Paramento para cone��o
		String url= "jdbc:oracle:thin:@"+servidor+":"+porta+":orcl";
		
		/*Como uma atividade que envolve manipular o banco pode 
		 * retornar uma Exe��o, vamos usar o bloco try, que TENTA
		 * executar algo.
		 * Caso a execu��o d� erro, o programa N�o Trava. O Bloco catch �
		 * executado.
		 * */
		try { 
			/*Essa Linha abaixo regista o Driver que faz a comunica��o do Oracle
			 * Mas ela so Funciona se add o Arquivo do Driver JDBC (ojdbc6.jar) 
			 * ao Build Path do projeto
			 * */ 
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver() );
			
			/*� a linha abaixo que efetivamente realiza a conex�o com o banco
			 * Se ela for bem sucedida, a conex�o � aberta
			 * */
			conexao = DriverManager.getConnection(url, usuario, senha);
		}catch( SQLException erro){
			erro.printStackTrace();
		}
		
	}
	
	public String getServidor() {
		return servidor;
	}
	public void setServidor(String servidor) {
		this.servidor = servidor;
	}
	public String getPorta() {
		return porta;
	}
	public void setPorta(String porta) {
		this.porta = porta;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
       
}
