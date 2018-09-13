package dao;

import java.sql.Connection; //Classe java que manipula a conex�o com o banco
import java.sql.DriverManager; //Classe que manipula drivers usados para conex�es com o banco
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
    /*Atributos b�sicos para a conex�o com o banco
     * */
	private String servidor;
    private String porta;
    private String senha;
    private String usuario;
    
    public Connection conexao;
    public Statement stm; //A classe Statement permite a execu��o de DDL ou DML

    public Conexao(){
    	/*
    	 * No construtor, estou definindo os valores para a conex�o
    	 * com o banco oracle da fiap.
    	 * Dessa forma, assim que um objeto for criado, j� estar� apto a se
    	 * conectar com esse banco*/
        servidor="oracle.fiap.com.br";
        porta="1521";
        senha="SUA SENHA";
        usuario="SEU USUARIO";
    }
   
   /*
    * O m�todo abaixo � respons�vel por inserir um dado no banco de dados.
    * Para isso, ela recebe como um par�metro o nome do cliente que ser� inserido.
    * Para executar o comando "Insert", utilizamos um Statement (o atributo stm).
    * Esse m�todo � simples, mas pouco recomendado, pois est� sujeito a ataques SQLInjection.
    * Mais a frente estudaremos outro m�todo.*/
    public boolean inserir(String nome) {
    	try {
    		/*Criamos o Statement com o objeto stm. Caso tudo seja executado corretamente,
    		 * retornamos true. Caso ocorra um erro, retornamos false*/
    		stm = conexao.createStatement();
    		stm.execute("Insert into TESTE (nome_cliente) values ('" + nome + "')");
    		return true;
    	}catch(SQLException erro) {
    		erro.printStackTrace();
    		return false;
    	}
    }
    
    
    /*
     * O m�todo abaixo � respons�vel por atualizar um dado no banco de dados.
     * Para isso, ela recebe como um par�metro o id e o nome do cliente que ser� atualizado.
     * Para executar o comando "Update", utilizamos um Statement (o atributo stm).
     * Esse m�todo � simples, mas pouco recomendado, pois est� sujeito a ataques SQLInjection.
     * Mais a frente estudaremos outro m�todo.*/
     public boolean alterar(int id, String nome) {
     	try {
     		/*Criamos o Statement com o objeto stm. Caso tudo seja executado corretamente,
     		 * retornamos true. Caso ocorra um erro, retornamos false*/
     		stm = conexao.createStatement();
     		stm.execute("Update TESTE set nome_cliente='" + nome + "' where id_cliente=" + id);
     		return true;
     	}catch(SQLException erro) {
     		erro.printStackTrace();
     		return false;
     	}
     }
    
     /*
      * O m�todo abaixo � respons�vel por remover um dado do banco de dados.
      * Para isso, ela recebe como um par�metro o id do cliente que ser� removido.
      * Para executar o comando "Delete", utilizamos um Statement (o atributo stm).
      * Esse m�todo � simples, mas pouco recomendado, pois est� sujeito a ataques SQLInjection.
      * Mais a frente estudaremos outro m�todo.*/
      public boolean remover(int id) {
      	try {
      		/*Criamos o Statement com o objeto stm. Caso tudo seja executado corretamente,
      		 * retornamos true. Caso ocorra um erro, retornamos false*/
      		stm = conexao.createStatement();
      		stm.execute("Delete from TESTE where id_cliente=" + id);
      		return true;
      	}catch(SQLException erro) {
      		erro.printStackTrace();
      		return false;
      	}
      }
     
      /*
       * O m�todo abaixo � respons�vel por buscar um dado do banco de dados.
       * Para isso, ela recebe como um par�metro o id do cliente que ser� removido.
       * Para executar o comando "Select", utilizamos um Statement (o atributo stm). e armazenamos
       * o resultado em um objeto do tipo ResultSet (que armazena cada um dos dados da tupla encontrada)
       * Esse m�todo � simples, mas pouco recomendado, pois est� sujeito a ataques SQLInjection.
       * Mais a frente estudaremos outro m�todo.*/
      public String buscar(int id) {
        	try {
          		/*Criamos o Statement com o objeto stm. Caso tudo seja executado corretamente,
          		 * retornamos o dado encontrado. Caso ocorra um erro, retornamos uma outra string*/
          		
        		ResultSet rs;
        		stm = conexao.createStatement();
        		/*O ResultSet armazena cada uma das colunas da tupla resultante do select*/
          		rs = stm.executeQuery("Select nome_cliente from TESTE where id_cliente=" + id);
          		if(rs.next()) {
          			return rs.getString(1);
          		}return "N�o encontrado";
          		
          	}catch(SQLException erro) {
          		erro.printStackTrace();
          		return "N�o encontrado";
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
