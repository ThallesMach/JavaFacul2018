


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


public class ViewClienteVilidarCep extends JFrame implements ActionListener {
	private JLabel lblId;
	private JLabel lblNome;
	private JLabel lblLogradouro;
	private JLabel lblNumero;
	private JLabel lblComplemento;
	private JLabel lblCep;
	private JLabel lblCpf;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtLogradouro;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtCep;
	private JTextField txtCpf;
	private JButton btnOk;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnLocalizar;

	private JPanel painelBotoes;
	private JPanel painelFormulario;

	public ViewClienteVilidarCep() {
		super("Clientes");
		setLayout(new BorderLayout());
		//
		//
		painelFormulario = new JPanel();
		painelFormulario.setLayout(new GridLayout(7, 2));

		
//		lblId = new JLabel("Id: ");
//		painelFormulario.add(lblId);
//		txtId = new JTextField(10);
//		painelFormulario.add(txtId);

		
		lblNome = new JLabel("Nome: ");
		painelFormulario.add(lblNome);
		txtNome = new JTextField(10);
		painelFormulario.add(txtNome);

		lblLogradouro = new JLabel("Rua: ");
		painelFormulario.add(lblLogradouro);
		txtLogradouro = new JTextField(10);
		painelFormulario.add(txtLogradouro);

		lblNumero = new JLabel("N: ");
		painelFormulario.add(lblNumero);
		txtNumero = new JTextField(10);
		painelFormulario.add(txtNumero);

		lblComplemento = new JLabel("Complemento: ");
		painelFormulario.add(lblComplemento);
		txtComplemento = new JTextField(10);
		painelFormulario.add(txtComplemento);


		 MaskFormatter mascaraId = null;
		// MaskFormatter mascaraN = null;
		MaskFormatter mascaraCep = null;
		MaskFormatter mascaraCpf = null;

		try {
			 mascaraId = new MaskFormatter("##");
			// mascaraN = new MaskFormatter("####");
			mascaraCep = new MaskFormatter("#####-###");
			mascaraCpf = new MaskFormatter("#########-##");
//			mascaraId.setPlaceholderCharacter('_');
			mascaraCep.setPlaceholderCharacter('_');
			mascaraCpf.setPlaceholderCharacter('_');

		} catch (ParseException excp) {
			System.err.println("Erro na formatação: " + excp.getMessage());
			System.exit(-1);
		}
		
		lblId = new JLabel("Id: ");
		painelFormulario.add(lblId);
		txtId = new JTextField(10);
//		painelFormulario.add(txtId);
		JFormattedTextField jFormattedTextId = new JFormattedTextField( mascaraId );
		painelFormulario.add( jFormattedTextId );


		lblCep = new JLabel("CEP: ");
		painelFormulario.add(lblCep);
		txtCep = new JTextField(10);
		// painelFormulario.add(txtCep);
		JFormattedTextField jFormattedTextCep = new JFormattedTextField(mascaraCep);
		painelFormulario.add(jFormattedTextCep);
		
		lblCpf = new JLabel("CPF: ");
		painelFormulario.add(lblCpf);
		txtCpf = new JTextField(10);
		// painelFormulario.add(txtCpf);
		JFormattedTextField jFormattedTextCpf = new JFormattedTextField(mascaraCpf);
		painelFormulario.add(jFormattedTextCpf);
		


		// Aqui vou criar o painel e colocar os bot?es nele
		painelBotoes = new JPanel();
		painelBotoes.setLayout(new FlowLayout());

//		painelBotoes = new JPanel();
//		painelBotoes.add(btnOk);
//		btnOk.addActionListener(this);

		btnOk = new JButton("Cadastrar");
		painelBotoes.add(btnOk);
		btnOk.addActionListener(this);

		btnAlterar = new JButton("Alterar");
		painelBotoes.add(btnAlterar);

		btnLocalizar = new JButton("Localizar");
		painelBotoes.add(btnLocalizar);

		btnExcluir = new JButton("Remove");
		painelBotoes.add(btnExcluir);

		// Agora, vou incluir os dois paineis dentro da janela
		add(painelFormulario, BorderLayout.CENTER);
		add(painelBotoes, BorderLayout.SOUTH);
	}

//	public void actionPerformed(ActionEvent event) {
//		if(event.getSource()==btnOk) {
//			JOptionPane.showMessageDialog(null,"Cliente Cadastrado!");
//		}
//	}
//	
//	

	public void actionPerformed(ActionEvent event) {
		// if( event.getSource()== btnOk ) {
		// JOptionPane.showMessageDialog(null, "Cliente Cadastrado!");
		//
		// }
//		
//		System.out.println("//////////////////////////////////////////");
//		System.out.println( txtCep.getText().equals(" ")  );
		String a = txtCep.getText();
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println( "B	"+ txtCep.getText().equals(" ") +"	D" );
		System.out.println("//////////////////////////////////////////");
		System.out.println("---//---//---//---//---//---//---");
		System.out.println( "_a"+  a  +"A_"  );
		System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-");
		
		if ( //( txtId.getText().length() > 0 ) // trim() == Tirando espaços em branco com metodo 
												// e length() == Verifica se tem componente preenchido
				 (txtNome.getText().trim().length() > 0) 
//				&& (txtLogradouro.getText().trim().length() > 0)
//				&& (txtNumero.getText().trim().length() > 0) 
//				&& (txtComplemento.getText().trim().length() > 0)
				
				&& (txtCep.getText().equals(" - ") )

//				&& (txtCep.getText().trim().length() > 0 )      && (txtCpf.getText().trim().length() > 0)
				
				&& ( event.getSource()== btnOk ) ) {
			
			JOptionPane.showMessageDialog(null, "Cliente Cadastrado!");
		} else {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Atenção",JOptionPane.ERROR_MESSAGE);
//			JOptionPane.showMessageDialog(null, "Confira os campos Obrigatórios!!");

		}
		
		
	}

	public static void main(String[] args) {
		ViewClienteVilidarCep janelinha = new ViewClienteVilidarCep();// criando a janela
		janelinha.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelinha.setSize(400, 250);
		janelinha.setVisible(true);
	}

}

//		Tentativas feitas
//	&& (txtCep.getText().trim().length() !=0  )
//	&& (txtCep.getText().trim().length() > 0 ) 
//
//	&& (txtCep.getText().trim().equals(null)   )
//	&& (txtCep.getText().trim().equals("")   )
//	&& (txtCep.getText().trim().equals("-")   )
//	&& (txtCep.getText().trim().equals("-")   )
//	&& (txtCep.getText().trim().equals("__-__")   )
//	&& (txtCep.getText().trim().equals("#####-###")   )
//	&& (txtCep.getText().trim().equals(txtCep)   )
//	&& (txtCep.getText().trim().equals(lblCep)   )

//--- Não funciona