
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
//
public class MisturaTudo extends JFrame {


	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	
	private JPanel painelBot�es;
	
	public MisturaTudo() {
		super("Mais de um gerenciador! ");
		
		painelBot�es = new JPanel();
		painelBot�es.setLayout(new FlowLayout() );
		
		btn1 = new JButton("A");
		painelBot�es.add(btn1);
		btn2 = new JButton("B");
		painelBot�es.add(btn2);
		btn3 = new JButton("C");
		painelBot�es.add(btn3);
		btn4 = new JButton("D");
		painelBot�es.add(btn4);
		
		setLayout(new BorderLayout());
		add(painelBot�es, BorderLayout.SOUTH);
		
	}
	
	public static void main(String[] args) {
		
		MisturaTudo janela = new MisturaTudo();
		janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
		janela.setSize(400, 400);
		janela.setVisible(true);
	}

}
