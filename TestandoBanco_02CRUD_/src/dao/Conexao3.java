package dao;

import java.sql.Connection; //Classe java que manipula a conex�o com o banco
import java.sql.DriverManager; //Classe que manipula drivers usados para conex�es com o banco
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Conexao3 {
    /*Atributos b�sicos para a conex�o com o banco
     * */
	private String servidor;
    private String porta;
    private String senha;
    private String usuario;
    
    public Connection conexao;
    
    
    /*A Classe Statement N�o Trataos DADOS, portanto,
     * deixa margem para SQL INJECTION
     * */
    public Statement comandoSQL; // stm; //A classe Statement permite a execu��o de DDL ou DML

    public Conexao3(){
    	/*
    	 * No construtor, estou definindo os valores para a conex�o
    	 * com o banco oracle da fiap.
    	 * Dessa forma, assim que um objeto for criado, j� estar� apto a se
    	 * conectar com esse banco*/
    	servidor = "oracle.fiap.com.br";
		porta = "1521";
		usuario= "PF0737";
		senha="C68C94";
		
//        servidor="oracle.fiap.com.br";
//        porta="1521";
//        senha="SUA SENHA";
//        usuario="SEU USUARIO";
    }
    
   
    public String exibir(int i) {
    	
    	try {
    		/*Um result set permite que seja armazenada
    		 * uma linha do banco de dados (com suas colunas separadas) */
			ResultSet resultado;
			comandoSQL = conexao.createStatement();
			resultado = comandoSQL.executeQuery("Selet * form teste where id_cliente");
			if(resultado.next() ) {
				return resultado.getString(2);
			  //	JOptionPane.showMessageDialog(null, resultado.getString(2) );
			}
			return "ERRO";
		} catch (SQLException erro) {
			erro.printStackTrace();
			return "ERRO";
		}
    }
  
    public void inserir(String nome) {
    	
    	try {
    		//Indico que o comando ser� executado na comnex�o.
			comandoSQL = conexao.createStatement();
				comandoSQL.executeQuery("Insert into TESTE (nome_cliente) values ('"+nome+"')" );  // ('"+nome+"')" );  superErro 
		} catch (SQLException erro) {
			erro.printStackTrace();
			
		}
    	
    }
    
//    public void atualizar(String nome, int id) {
//    	
//    	try {
//			
//		} catch (SQLException erro) {
//			
//		}
//    	
//    }
      
     
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



    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void abreConexao(){
    	/*A linha abaixo � a String de Conex�o
    	 * Ela armazena as informa��es b�sicas para a conex�o com o banco, como o 
    	 *driver que ser� usado, o endere�o do servidor e a porta*/
        String url="jdbc:oracle:thin:@"+servidor+":"+porta+":orcl";
       
        /*Abaixo h� um bloco Try para tratamento de erros. Esse bloco
         * serve para prevenir que uma exce��o que ocorra durante a execu��o
         * do c�digo fa�a o programa travar. Caso ocorra uma exce��o, o bloco
         * Try ser� executado.*/
        try{
    	   /*� registrado o driver presente dntro do arquivo ojdbc6 para que
    	    * possa ser usado.*/
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            /*A linha abaixo realiza a conex�o com o banco de dados e armazena a
             * conex�o ativa no atributo conn*/
            conexao = DriverManager.getConnection(url, usuario, senha);
       }catch (SQLException e) {
    	   /*Caso ocorra alguma exce��o, ela ser� printada*/
            e.printStackTrace();
        }
    }
    
    public void fechaConexao(){
    	   /*Abaixo h� um bloco Try para tratamento de erros. Esse bloco
         * serve para prevenir que uma exce��o que ocorra durante a execu��o
         * do c�digo fa�a o programa travar. Caso ocorra uma exce��o, o bloco
         * Try ser� executado.*/
         try{
          /*A conex�o ativa, armazenada no atributo conn � fechada*/
            conexao.close();
         }catch (SQLException e){
        	 /*Caso ocorra alguma exce��o, ela ser� printada*/
            e.printStackTrace();
         }
    }
   
}
