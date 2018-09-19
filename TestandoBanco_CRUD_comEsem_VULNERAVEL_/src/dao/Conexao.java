package dao;

import java.sql.Connection; //Classe java que manipula a conexão com o banco
import java.sql.DriverManager; //Classe que manipula drivers usados para conexões com o banco
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Conexao {
    /*Atributos básicos para a conexão com o banco
     * */
	private String servidor;
    private String porta;
    private String senha;
    private String usuario;
    
    public Connection conexao;
    public Statement comando; //A classe Statement permite a execução de DDL ou DML

    public Conexao(){
    	/*
    	 * No construtor, estou definindo os valores para a conexão
    	 * com o banco oracle da fiap.
    	 * Dessa forma, assim que um objeto for criado, já estará apto a se
    	 * conectar com esse banco*/
        servidor="oracle.fiap.com.br";
        porta="1521";
        senha="SUA SENHA";
        usuario="SEU USUÁRIO";
    }
   /*O método abaixo apresenta uma grande falha de segurança e não pode/deve ser usado
    * em hipótese alguma em um programa profissional*/
    public boolean loginVulneravel(String nome) {
    	/*Muitos programas usam um select pelo nome de usuário e senha para fazer
    	 * um login, retornando verdadeiro caso o registro correspondente
    	 * seja encontrado. O nosso login vulnerável faz o mesmo, mas usando o
    	 * nome de cliente*/
    	try {
	    	ResultSet rs;
			comando = conexao.createStatement();
			/*O ResultSet armazena cada uma das colunas da tupla resultante do select*/
	  		rs = comando.executeQuery("Select * from TESTE where nome_cliente='" + nome + "'");
	  		if(rs.next()) {
	  			return true;
	  		}else {
	  			return false;
	  		}
	  		
  		
    	}catch(SQLException erro) {
    		erro.printStackTrace();
    		return false;
  		
    	}
    }
    
    
    /*
    * O método abaixo é responsável por inserir um dado no banco de dados.
    * Para isso, ela recebe como um parâmetro o nome do cliente que será inserido.
    * Para executar o comando "Insert", utilizamos um Statement (o atributo comando).
    * Esse método é simples, mas pouco recomendado, pois está sujeito a ataques SQLInjection.
    * Mais a frente estudaremos outro método.*/
    public void inserir(String nome) {
    	try {
    		/*Criamos o Statement com o objeto comando. Caso tudo seja executado corretamente,
    		 * retornamos true. Caso ocorra um erro, retornamos false*/
    		comando = conexao.createStatement();
    		comando.execute("Insert into TESTE (nome_cliente) values ('" + nome + "')");
    		
    	}catch(SQLException erro) {
    		erro.printStackTrace();
    		
    	}
    }
    
    
    /*
     * O método abaixo é responsável por atualizar um dado no banco de dados.
     * Para isso, ela recebe como um parâmetro o id e o nome do cliente que será atualizado.
     * Para executar o comando "Update", utilizamos um Statement (o atributo comando).
     * Esse método é simples, mas pouco recomendado, pois está sujeito a ataques SQLInjection.
     * Mais a frente estudaremos outro método.*/
     public void alterar(int id, String nome) {
     	try {
     		/*Criamos o Statement com o objeto comando. Caso tudo seja executado corretamente,
     		 * retornamos true. Caso ocorra um erro, retornamos false*/
     		comando = conexao.createStatement();
     		comando.execute("Update TESTE set nome_cliente='" + nome + "' where id_cliente=" + id);
     		
     	}catch(SQLException erro) {
     		erro.printStackTrace();
     		
     	}
     }
    
     /*
      * O método abaixo é responsável por remover um dado do banco de dados.
      * Para isso, ela recebe como um parâmetro o id do cliente que será removido.
      * Para executar o comando "Delete", utilizamos um Statement (o atributo comando).
      * Esse método é simples, mas pouco recomendado, pois está sujeito a ataques SQLInjection.
      * Mais a frente estudaremos outro método.*/
      public void remover(int id) {
      	try {
      		/*Criamos o Statement com o objeto comando. Caso tudo seja executado corretamente,
      		 * retornamos true. Caso ocorra um erro, retornamos false*/
      		comando = conexao.createStatement();
      		comando.execute("Delete from TESTE where id_cliente=" + id);
      		
      	}catch(SQLException erro) {
      		erro.printStackTrace();
      		
      	}
      }
     
      /*
       * O método abaixo é responsável por buscar um dado do banco de dados.
       * Para isso, ela recebe como um parâmetro o id do cliente que será removido.
       * Para executar o comando "Select", utilizamos um Statement (o atributo comando). e armazenamos
       * o resultado em um objeto do tipo ResultSet (que armazena cada um dos dados da tupla encontrada)
       * Esse método é simples, mas pouco recomendado, pois está sujeito a ataques SQLInjection.
       * Mais a frente estudaremos outro método.*/
      public void buscar(int id) {
        	try {
          		/*Criamos o Statement com o objeto comando. Caso tudo seja executado corretamente,
          		exibimos um JOptionPane com o nome do cliente*/
          		
        		ResultSet rs;
        		comando = conexao.createStatement();
        		/*O ResultSet armazena cada uma das colunas da tupla resultante do select*/
          		rs = comando.executeQuery("Select nome_cliente from TESTE where id_cliente=" + id);
          		rs.next();
          		JOptionPane.showMessageDialog(null, rs.getString(1));
          		
          	}catch(SQLException erro) {
          		erro.printStackTrace();
          		
          	}
      }
      
      /*
       * O método abaixo é responsável por buscar um dado do banco de dados.
       * Para isso, ela recebe como um parâmetro o nome do cliente que será removido.
       * Para executar o comando "Select", utilizamos um Statement (o atributo comando). e armazenamos
       * o resultado em um objeto do tipo ResultSet (que armazena cada um dos dados da tupla encontrada)
       * Esse método é simples, mas pouco recomendado, pois está sujeito a ataques SQLInjection.
       * Mais a frente estudaremos outro método.*/
      public void buscar(String nome) {
        	try {
          		/*Criamos o Statement com o objeto comando. Caso tudo seja executado corretamente,
          		exibimos um JOptionPane com o id do cliente*/
          		
        		ResultSet rs;
        		comando = conexao.createStatement();
        		/*O ResultSet armazena cada uma das colunas da tupla resultante do select*/
          		rs = comando.executeQuery("Select id_cliente from TESTE where nome_cliente='" + nome + "'");
          		rs.next();
          		JOptionPane.showMessageDialog(null, rs.getString(1));
          		
          	}catch(SQLException erro) {
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
    	/*A linha abaixo é a String de Conexão
    	 * Ela armazena as informações básicas para a conexão com o banco, como o 
    	 *driver que será usado, o endereço do servidor e a porta*/
        String url="jdbc:oracle:thin:@"+servidor+":"+porta+":orcl";
       
        /*Abaixo há um bloco Try para tratamento de erros. Esse bloco
         * serve para prevenir que uma exceção que ocorra durante a execução
         * do código faça o programa travar. Caso ocorra uma exceção, o bloco
         * Try será executado.*/
        try{
    	   /*É registrado o driver presente dntro do arquivo ojdbc6 para que
    	    * possa ser usado.*/
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            /*A linha abaixo realiza a conexão com o banco de dados e armazena a
             * conexão ativa no atributo conn*/
            conexao = DriverManager.getConnection(url, usuario, senha);
       }catch (SQLException e) {
    	   /*Caso ocorra alguma exceção, ela será printada*/
            e.printStackTrace();
        }
    }
    
    public void fechaConexao(){
    	   /*Abaixo há um bloco Try para tratamento de erros. Esse bloco
         * serve para prevenir que uma exceção que ocorra durante a execução
         * do código faça o programa travar. Caso ocorra uma exceção, o bloco
         * Try será executado.*/
         try{
          /*A conexão ativa, armazenada no atributo conn é fechada*/
            conexao.close();
         }catch (SQLException e){
        	 /*Caso ocorra alguma exceção, ela será printada*/
            e.printStackTrace();
         }
    }
   
}
