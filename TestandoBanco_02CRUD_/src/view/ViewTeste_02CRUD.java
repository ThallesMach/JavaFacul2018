package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.Conexao_02CRUD;

//--->>> Testando no Eclipse de Casa

/* Essa é uma classe criada para representar um formulário que permita:
 * CONECTAR COM O BANCO DE DADOS
 * GRAVAR DADOS EM UMA TABELA CHAMADA TESTE
 * LER UM DADO LIDO
 * ALTERAR UM DADO LIDO
 * EXCLUIR UM DADO LIDO
 * 
 * Depois de entender como o Java se conecta com um banco e manipula seus dados, vamos aplicar os mesmos
 * conhecimentos no projeto Walduino*/
public class ViewTeste_02CRUD extends JFrame implements ActionListener{
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
	
	public ViewTeste_02CRUD() {
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
		// TODO Auto-generated method stub
		ViewTeste_02CRUD janela = new ViewTeste_02CRUD();
		janela.setSize(400,130);
		janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
		janela.show();
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource()==btnGravar) {
			/*Aqui vamos inserir o que vai ocorrer 
			 * quando o bot�o GRAVAR for clicado*/
			Conexao_02CRUD banquinho = new Conexao_02CRUD();
			banquinho.abreConexao();
			if(banquinho.inserir(txtNomeCliente.getText())) {
				JOptionPane.showMessageDialog(null, "O Cliente foi inserido com sucesso!");
			}else {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a inser��o do cliente!");
			}
			banquinho.fechaConexao();
			
		}else {
			if (event.getSource()==btnLer) {
			/*Aqui vamos inserir o que vai ocorrer 
			 * quando o bot�o LER for clicado*/
				
				if(txtIdCliente.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Insira um id para buscar o dado!");
					
				}else {
					Conexao_02CRUD banquinho = new Conexao_02CRUD();
					banquinho.abreConexao();
					txtNomeCliente.setText(banquinho.buscar(Integer.parseInt(txtIdCliente.getText())));
					banquinho.fechaConexao();
				}
				
				
			}else {
				if (event.getSource()==btnAlterar) {
			/*Aqui vamos inserir o que vai ocorrer 
			 * quando o bot�o ALTERAR for clicado*/
					if(txtIdCliente.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Insira um id para alterar o dado!");
						
					}else {
						Conexao_02CRUD banquinho = new Conexao_02CRUD();
						banquinho.abreConexao();
						if(banquinho.alterar(Integer.parseInt(txtIdCliente.getText()), txtNomeCliente.getText())) {
							JOptionPane.showMessageDialog(null, "O Cliente foi alterado com sucesso!");
						}else {
							JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a altera��o do cliente!");
						}
						banquinho.fechaConexao();
					}
				}else {
					if (event.getSource()==btnExcluir) {
			/*Aqui vamos inserir o que vai ocorrer 
			 * quando o bot�o EXCLUIR for clicado*/
						
						if(txtIdCliente.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Insira um id para remover o dado!");
							
						}else {
							Conexao_02CRUD banquinho = new Conexao_02CRUD();
							banquinho.abreConexao();
							if(banquinho.remover(Integer.parseInt(txtIdCliente.getText()))) {
								JOptionPane.showMessageDialog(null, "O Cliente foi removido com sucesso!");
							}else {
								JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a remo��o do cliente!");
							}
							banquinho.fechaConexao();
						}
						
					}
				}
			}
		}
		
	}

}
