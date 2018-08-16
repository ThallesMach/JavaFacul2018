
//// Alterado pelo Git

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout; //gerenciador de layout que especifica como os componentes ser�o exibidos na Janela.
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame; //recursos b�sicos de janela
import javax.swing.JLabel; //para exibi��o de texto e/ou imagem
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField; //campo de Texto
import javax.swing.text.MaskFormatter;


public class TestCampoNumerico extends JFrame implements ActionListener {
	
	
	
	private static final Component JFormattedTextField = null;
	private JLabel lblId;	//JLabel que usamos para textos 
	private JLabel lblRazaoSocial; //JLabel que usamos para textos
	private JLabel lblNomeFantasia; //JLabel que usamos para textos
	private JLabel lblTelefone;
	private JLabel lblEmail;
	private JLabel lblEndereco;
	private JTextField txtId;	// JTextField onde poder� digitar o id.
	private JTextField txtRazaoSocial;	// JTextField onde poder� digitar Raz�oSocial
	private JTextField txtNomeFantasia; // JTextField onde poder� digitar NomeFantasia
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	
	private JButton btnOk;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnLocalizar;
	
	
	private JPanel painelBotoes;
	private JPanel painelFormulario; 
	
	public TestCampoNumerico() {
		super("Fornecedor");
        setLayout(new BorderLayout());
        

        
        //Vou criar um painel apenas para as labels
        //e os campos do formul�rio
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
		
//		-------------------------------------------------------------------------------
		lblTelefone = new JLabel("Telefone N�: ");
		lblTelefone.setBounds(50,80,100,20);
//		lblTelefone = new JLabel("Telefone N�: ");
		painelFormulario.add(lblTelefone);
//		txtTelefone =new JTextField(10);

        //Define as m�scaras
        MaskFormatter mascaraTel = null;

        try{
               mascaraTel = new MaskFormatter("(##)####-####");
               mascaraTel.setPlaceholderCharacter('_');
        }
        catch(ParseException excp) {
               System.err.println("Erro na formata��o: " + excp.getMessage());
               System.exit(-1);
        }

        JFormattedTextField txtTelefone = new JFormattedTextField(mascaraTel);
        txtTelefone.setBounds(150,80,100,20);
		painelFormulario.add(txtTelefone);  



        
//        --------------------------------------------------------------------------------
		
		lblEmail = new JLabel("Email: ");
		painelFormulario.add(lblEmail);
		txtEmail =new JTextField(10);
		painelFormulario.add(txtEmail);
		
		lblEndereco = new JLabel("Endereco: ");
		painelFormulario.add(lblEndereco);
		txtEndereco =new JTextField(10);
		painelFormulario.add(txtEndereco);
		
		
		
		// Aqui vou criar o painel e colocar os bot�es nele 
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
		
//---------------------------------------------------------------------------

		//Agora, vou incluir os dois paineis dentro da janela
		add(painelFormulario, BorderLayout.CENTER);
		add(painelBotoes, BorderLayout.SOUTH);
	}

	
	
	public void actionPerformed(ActionEvent event ) {

		if ( ( txtId.getText().trim().length()>0)   // trim() == Tirando espa�os em branco com metodo // e length() == Verifica se tem componente preenchido
		                && (txtRazaoSocial.getText().trim().length()> 0)
		                && (txtNomeFantasia.getText().trim().equals("") )
		                && (txtTelefone.getText().trim().length() > 0)
		                && (txtEmail.getText().trim().length() > 0)
		                && (txtEndereco.getText().trim().equals("") )
		                && ( event.getSource()== btnOk ) ) {
		JOptionPane.showMessageDialog(null, "Cliente Cadastrado!");
		} else {
		JOptionPane.showMessageDialog(null, "Dados Validados aqui deve ser efetuada a operação!!", "Aviso",JOptionPane.ERROR_MESSAGE);
		            JOptionPane.showMessageDialog(null, "Confira os campos Obrigat�rios!!", "Aviso",JOptionPane.WARNING_MESSAGE);
		            
		}}
	
	//Na main vamos instanciar a janela e exibir na tela
	public static void main(String[] args) {
		ViewFornecedor janelinha = new ViewFornecedor();//criando a janela
        janelinha.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelinha.setSize(400,250);
        janelinha.setVisible(true);

	}
}



/*
//--------------------------------------------
Link 1
https://www.devmedia.com.br/java-swing-conheca-os-componentes-jtextfield-e-jformattedtextfield/30981

//---------------------------------------------

Link 2
https://www.devmedia.com.br/validando-informacoes-de-campos-jtextfield/26336

*/
