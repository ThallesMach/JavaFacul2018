

import java.awt.BorderLayout;
import java.awt.FlowLayout; //gerenciador de layout que especifica como os componentes serão exibidos na Janela.
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame; //recursos básicos de janela
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;


public class ViewCliente7 extends JFrame implements ActionListener {
	private JLabel lblId;
	private JLabel lblNome;
	private JLabel lblLogradouro;
	private JLabel lblNumero;
	private JLabel lblComplemento;
	private JLabel lblCep;
	private JLabel lblCpf;
	
	private JTextField txtNome;
	private JTextField txtLogradouro;
	private JTextField txtComplemento;
	
	private JFormattedTextField txtId;
	private JFormattedTextField txtNumero;
	private JFormattedTextField txtCep;
	private JFormattedTextField txtCpf;
	
	MaskFormatter mascaraId;
	MaskFormatter mascaraNumero;
	MaskFormatter mascaraCep;
	MaskFormatter mascaraCpf;
	
	private JButton btnOk;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnLocalizar;

	private JPanel painelBotoes;
	private JPanel painelFormulario;

	public ViewCliente7() throws ParseException {
		super("Clientes");
		setLayout(new BorderLayout());
		
		painelFormulario = new JPanel();
		painelFormulario.setLayout(new GridLayout(7, 2));

		lblId = new JLabel("Id: ");
		//lblId.setBounds(50, 40, 100, 20);

		lblNome = new JLabel("Nome: ");
		painelFormulario.add(lblNome);
		txtNome = new JTextField(10);
		painelFormulario.add(txtNome);

		lblLogradouro = new JLabel("Rua: ");
		painelFormulario.add(lblLogradouro);
		txtLogradouro = new JTextField(10);
		painelFormulario.add(txtLogradouro);

		lblNumero = new JLabel("N: ");
		//lblId.setBounds(50, 40, 100, 20);

		lblComplemento = new JLabel("Complemento: ");
		painelFormulario.add(lblComplemento);
		txtComplemento = new JTextField(10);
		painelFormulario.add(txtComplemento);

		lblCep = new JLabel("CEP: ");
		//lblId.setBounds(50, 120, 100, 20);
				
		lblCpf = new JLabel("CPF: ");
		//lblId.setBounds(50, 120, 100, 20);
		
		try {
			mascaraId = new MaskFormatter("###");
			mascaraNumero = new MaskFormatter("####");
			mascaraCep = new MaskFormatter("#####-###");
			mascaraCpf = new MaskFormatter("###.###.###-##");
			
//			mascaraCep.setPlaceholderCharacter('_');
//	        mascaraCpf.setPlaceholderCharacter('_');
	        }catch(ParseException excp) {
	        	
	        }
		txtId = new JFormattedTextField(mascaraId);
		txtNumero = new JFormattedTextField(mascaraNumero);
		txtCep = new JFormattedTextField(mascaraCep);
		txtCpf = new JFormattedTextField(mascaraCpf);
		
		/*txtId.setBounds(150, 40, 100, 20);
		txtNumero.setBounds(150, 40, 100, 20);
		txtCep.setBounds(150, 40, 100, 20);
		txtCpf.setBounds(150, 40, 100, 20);*/
		
		painelFormulario.add(lblId);
		painelFormulario.add(txtId);
		painelFormulario.add(lblNumero);
		painelFormulario.add(txtNumero);
		painelFormulario.add(lblCep);
		painelFormulario.add(txtCep);
		painelFormulario.add(lblCpf);
		painelFormulario.add(txtCpf);
	

		//Criar painel e colocar os botoes 
		painelBotoes = new JPanel();
		painelBotoes.setLayout(new FlowLayout());


		btnOk = new JButton("Cadastrar");
		painelBotoes.add(btnOk);
		btnOk.addActionListener(this);

		btnAlterar = new JButton("Alterar");
		painelBotoes.add(btnAlterar);

		btnLocalizar = new JButton("Localizar");
		painelBotoes.add(btnLocalizar);

		btnExcluir = new JButton("Remover");
		painelBotoes.add(btnExcluir);

		// Agora, vou incluir os dois paineis dentro da janela
		add(painelFormulario, BorderLayout.CENTER);
		add(painelBotoes, BorderLayout.SOUTH);
	}


	public void actionPerformed(ActionEvent event) {

		if ((txtId.getText().equals("   ") )
		|| (txtNome.getText().length() == 0) 
//		||  (txtLogradouro.getText().length() == 0)
//		||  (txtNumero.getText().equals("    ")) 
//		||  (txtComplemento.getText().length() == 0)
		|| (txtCep.getText().length() == 0 )
//		&& (txtCep.getText().equals("     -   "))
//		&&  (txtCpf.getText().equals("   .   .   -  "))
		&& ( event.getSource()== btnOk ) ) {
			JOptionPane.showMessageDialog(null, "preencha !");
		} else {
			JOptionPane.showMessageDialog(null, "ok  ");
		}
		
		
	}

	public static void main(String[] args) throws Exception{
		ViewCliente7 janelinha = new ViewCliente7();// criando a janela
		janelinha.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelinha.setSize(400, 250);
		janelinha.setVisible(true);
		
		

	}

}