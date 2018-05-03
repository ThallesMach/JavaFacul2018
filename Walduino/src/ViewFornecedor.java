
//// Alterado pelo Git

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ViewFornecedor extends JFrame implements ActionListener{
	
	
	private JLabel lblId;
	private JLabel lblRazaoSocial;
	private JLabel lblNomeFantasia;
	private JLabel lblTelefone;
	private JLabel lblEmail;
	private JLabel lblEndereco;
	private JTextField txtId;
	private JTextField txtRazaoSocial;
	private JTextField txtNomeFantasia;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	
	private JButton btnOk;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnLocalizar;
	
	
	private JPanel painelBotoes;
	private JPanel painelFormulario; 
	
	public ViewFornecedor() {
		super("Fornecedor");
        setLayout(new BorderLayout());
        //Vou criar um painel apenas para as labels
        //e os campos do formulário
        painelFormulario = new JPanel();
        painelFormulario.setLayout(new GridLayout(7, 2));
        
		lblId = new JLabel("Id: ");
		painelFormulario.add(lblId);
		txtId=new JTextField(10);
		painelFormulario.add(txtId);
		
		lblRazaoSocial = new JLabel("RazaoSocial: ");
		painelFormulario.add(lblRazaoSocial);
		txtRazaoSocial=new JTextField(10);
		painelFormulario.add(txtRazaoSocial);
		
		lblNomeFantasia = new JLabel("NomeFantasia: ");
		painelFormulario.add(lblNomeFantasia);
		txtNomeFantasia=new JTextField(10);
		painelFormulario.add(txtNomeFantasia);
		
		lblTelefone = new JLabel("Telefone Nº: ");
		painelFormulario.add(lblTelefone);
		txtTelefone =new JTextField(10);
		painelFormulario.add(txtTelefone);
        
		lblEmail = new JLabel("Email: ");
		painelFormulario.add(lblEmail);
		txtEmail =new JTextField(10);
		painelFormulario.add(txtEmail);
		
		lblEndereco = new JLabel("Endereco: ");
		painelFormulario.add(lblEndereco);
		txtEndereco =new JTextField(10);
		painelFormulario.add(txtEndereco);
		
		
		
		// Aqui vou criar o painel e colocar os botões nele 
		painelBotoes = new JPanel();
		painelBotoes.setLayout(new FlowLayout());
		

		btnOk = new JButton("Cadastrar");
		painelBotoes.add(btnOk);
		btnOk.addActionListener(this);
		
		
		btnAlterar = new JButton("Alterar");
		painelBotoes.add(btnAlterar);
		
		btnLocalizar = new JButton("Localizar");
		painelBotoes.add(btnLocalizar);
		
		btnExcluir = new JButton("Remove");
		painelBotoes.add(btnExcluir);
		

		
		//Agora, vou incluir os dois paineis dentro da janela
		add(painelFormulario, BorderLayout.CENTER);
		add(painelBotoes, BorderLayout.SOUTH);
	}

	
	
	public void actionPerformed(ActionEvent event ) {

		if ( ( txtId.getText().length()>0)
		                &&(txtRazaoSocial.getText().length()> 0)
		                && (txtNomeFantasia.getText().length() > 0)
		                && (txtTelefone.getText().length() > 0)
		                && (txtEmail.getText().length() > 0)
		                && (txtEndereco.getText().length() > 0)
		                && ( event.getSource()== btnOk ) ) {
		JOptionPane.showMessageDialog(null, "Cliente Cadastrado!");
		} else {
		JOptionPane.showMessageDialog(null, "Dados Validados aqui deve ser efetuada a operação!!");
		            JOptionPane.showMessageDialog(null, "Confira os campos Obrigatórios!!");
		            
		}}
	
	public static void main(String[] args) {
		ViewFornecedor janelinha = new ViewFornecedor();//criando a janela
        janelinha.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelinha.setSize(400,250);
        janelinha.setVisible(true);

	}
}
