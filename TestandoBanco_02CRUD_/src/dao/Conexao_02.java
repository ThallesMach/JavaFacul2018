package dao;
/*Essa classe será usada para manipularmos nossa conexão com o banco de dados!
 * Nela faremos a conexão
 * O envio de instruções que modificam os dados de uma tabela
 * O envio de instruções que retornam dados de uma tabela
 * */

//teste no git

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao_02 {
	
	private String servidor;
	private String porta;
	private String usuario;
	private String senha;
	
	private Connection conexao;
	
	public Conexao_02() {
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
		// String de connection Aguarda os Paramento para coneção
		String url= "jdbc:oracle:thin:@"+servidor+":"+porta+":orcl";
		
		/*Como uma atividade que envolve manipular o banco pode 
		 * retornar uma Exeção, vamos usar o bloco try, que TENTA
		 * executar algo.
		 * Caso a execução dê erro, o programa Não Trava. O Bloco catch é
		 * executado.
		 * */
		try { 
			/*Essa Linha abaixo regista o Driver que faz a comunicação do Oracle
			 * Mas ela so Funciona se add o Arquivo do Driver JDBC (ojdbc6.jar) 
			 * ao Build Path do projeto
			 * */ 
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver() );
			
			/*É a linha abaixo que efetivamente realiza a conexão com o banco
			 * Se ela for bem sucedida, a conexão é aberta
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
