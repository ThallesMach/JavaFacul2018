package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.Conexao;

//Teste no Eclipse 13/09/2018

/* Essa � uma classe criada para representar um formul�rio que permita:
 * CONECTAR COM O BANCO DE DADOS
 * GRAVAR DADOS EM UMA TABELA CHAMADA TESTE
 * LER UM DADO LIDO
 * ALTERAR UM DADO LIDO
 * EXCLUIR UM DADO LIDO
 * 
 * Depois de entender como o Java se conecta com um banco e manipula seus dados, vamos aplicar os mesmos
 * conhecimentos no projeto Walduino*/
public class ViewTeste extends JFrame implements ActionListener{
	private JPanel painelFormulario;
	private JLabel lblIdCliente;
	private JTextField txtIdCliente;
	private JLabel lblNomeCliente;
	private JTextField txtNomeCliente;
	
	private JPanel painelBotoes;
	private JButton btnGravar;
	private JButton btnLer;
	private JButton btnAlterar;
	private JButton btnExcluir;
	
	public ViewTeste() {
		/*Abaixo temos a parte do c�digo que monta os objetos
		 * dentro do formul�rio.
		 * Esse conte�do foi abordado no 1� Semestre do curso
		 */
		painelFormulario = new JPanel(new GridLayout(2,4,3,3));
		lblIdCliente = new JLabel("Id do cliente:");
		txtIdCliente = new JTextField(10);
		lblNomeCliente = new JLabel("Nome do cliente:");
		txtNomeCliente = new JTextField(10);
		
		painelFormulario.add(lblIdCliente);
		painelFormulario.add(txtIdCliente);
		painelFormulario.add(lblNomeCliente);
		painelFormulario.add(txtNomeCliente);
		
		painelBotoes = new JPanel(new GridLayout(1,4,3,3));
		btnGravar = new JButton("Gravar");
		btnLer = new JButton("Ler");
		btnAlterar = new JButton("Alterar");
		btnExcluir = new JButton("Excluir");
		
		painelBotoes.add(btnGravar);
		painelBotoes.add(btnLer);
		painelBotoes.add(btnAlterar);
		painelBotoes.add(btnExcluir);
		
		btnGravar.addActionListener(this);
		btnLer.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnExcluir.addActionListener(this);

		setLayout(new BorderLayout(5,5));
		add(painelFormulario, BorderLayout.CENTER);
		add(painelBotoes, BorderLayout.SOUTH);
	}
	public static void main(String[] args) {
		/*Os c�digos abaixo servem para exibir
		 * o formul�rio que montamos, conforme estudado no primeiro semestre
		 * */
		ViewTeste janela = new ViewTeste();
		janela.setSize(400,130);
		janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
		janela.show();
	}
	/*Os c�digos abaixo atribuem a��es espec�ficas para cada um dos bot�es
	 * 
	 * */
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource()==btnGravar) {
			/*Aqui vamos inserir o que vai ocorrer 
			 * quando o bot�o GRAVAR for clicado*/
			Conexao banquinho = new Conexao();
			banquinho.abrirConexao();
			
			
		}else {
			if (event.getSource()==btnLer) {
			/*Aqui vamos inserir o que vai ocorrer 
			 * quando o bot�o LER for clicado*/
				
				
			}else {
				if (event.getSource()==btnAlterar) {
			/*Aqui vamos inserir o que vai ocorrer 
			 * quando o bot�o ALTERAR for clicado*/
					
					
					
				}else {
					if (event.getSource()==btnExcluir) {
			/*Aqui vamos inserir o que vai ocorrer 
			 * quando o bot�o EXCLUIR for clicado*/
						
						
						
					}
				}
			}
		}
		
	}

}
