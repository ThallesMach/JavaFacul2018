 // https://www.devmedia.com.br/java-swing-conheca-os-componentes-jtextfield-e-jformattedtextfield/30981




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

public class ViewClienteTeste extends JFrame implements ActionListener{
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
	
	
	public ViewClienteTeste() {
	   	 super("Clientes");
         setLayout(new BorderLayout());
         //
         //
         painelFormulario = new JPanel();
         painelFormulario.setLayout(new GridLayout(7, 2));
				
		lblId = new JLabel("Id: ");
		painelFormulario.add(lblId);
		txtId=new JTextField(10);
		painelFormulario.add(txtId);
		
		lblNome = new JLabel("Nome: ");
		painelFormulario.add(lblNome);
		txtNome=new JTextField(10);
		painelFormulario.add(txtNome);
		
		lblLogradouro = new JLabel("Rua: ");
		painelFormulario.add(lblLogradouro);
		txtLogradouro=new JTextField(10);
		painelFormulario.add(txtLogradouro);
		
		lblNumero = new JLabel("N: ");
		painelFormulario.add(lblNumero);
		txtNumero=new JTextField(10);
		painelFormulario.add(txtNumero);
		
		lblComplemento = new JLabel("Complemento: ");
		painelFormulario.add(lblComplemento);
		txtComplemento=new JTextField(10);
		painelFormulario.add(txtComplemento);
		
		lblCep = new JLabel("CEP: ");
		painelFormulario.add(lblCep);
		txtCep=new JTextField(10);
		//painelFormulario.add(txtCep);
		
		lblCpf = new JLabel("CPF: ");
		painelFormulario.add(lblCpf);
		txtCpf=new JTextField(10);
		//painelFormulario.add(txtCpf);
		
		//MaskFormatter mascaraId = null;
		//MaskFormatter mascaraN = null;
		MaskFormatter mascaraCep = null;
		MaskFormatter mascaraCpf = null;
		
		try{
			//mascaraId = new MaskFormatter("##");
		    //mascaraN = new MaskFormatter("####");
            mascaraCep = new MaskFormatter("#####-###");
            mascaraCpf = new MaskFormatter("#########-##");
            mascaraCep.setPlaceholderCharacter('_');
            mascaraCpf.setPlaceholderCharacter('_');
           
     }
     catch(ParseException excp) {
            System.err.println("Erro na formatação: " + excp.getMessage());
            System.exit(-1);
     }
		
		
		//JFormattedTextField jFormattedTextId = new JFormattedTextField(mascaraId);
		//painelFormulario.add(jFormattedTextId);
		//JFormattedTextField jFormattedTextN = new JFormattedTextField(mascaraN);
		//painelFormulario.add(jFormattedTextN);
		JFormattedTextField jFormattedTextCep = new JFormattedTextField(mascaraCep);
		painelFormulario.add(jFormattedTextCep);
        JFormattedTextField jFormattedTextCpf = new JFormattedTextField(mascaraCpf);
        painelFormulario.add(jFormattedTextCpf);
        //jFormattedTextCep.setBounds(150,40,100,20);
        //jFormattedTextCpf.setBounds(150,120,100,20);
		
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
		

		
		//Agora, vou incluir os dois paineis dentro da janela
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
	
	public void actionPerformed(ActionEvent event ) {
		// if( event.getSource()== btnOk ) {
		// JOptionPane.showMessageDialog(null, "Cliente Cadastrado!");
		// 
		// }
		if ( ( txtId.getText().length()>0)
		                &&(txtNome.getText().length()> 0)
		                && (txtLogradouro.getText().length() > 0)
		                && (txtNumero.getText().length() > 0)
		                && (txtComplemento.getText().length() > 0)
		                && (txtCep.getText().length() > 0)
		                && (txtCpf.getText().length() > 0)
		&& ( event.getSource()== btnOk ) ) {
		JOptionPane.showMessageDialog(null, "Cliente Cadastrado!");
		} else {
		JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
		            //JOptionPane.showMessageDialog(null, "Confira os campos Obrigat?rios!!");
		            
		}}
	
	public static void main(String[] args) {
	   	ViewClienteTeste janelinha = new ViewClienteTeste();//criando a janela
        janelinha.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelinha.setSize(400,250);
        janelinha.setVisible(true);

	}

}
