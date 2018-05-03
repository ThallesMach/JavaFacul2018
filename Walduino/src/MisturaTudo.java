

//// ok

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
	
	private JPanel painelBotões;
	
	public MisturaTudo() {
		super("Mais de um gerenciador! ");
		
		painelBotões = new JPanel();
		painelBotões.setLayout(new FlowLayout() );
		
		btn1 = new JButton("A");
		painelBotões.add(btn1);
		btn2 = new JButton("B");
		painelBotões.add(btn2);
		btn3 = new JButton("C");
		painelBotões.add(btn3);
		btn4 = new JButton("D");
		painelBotões.add(btn4);
		
		setLayout(new BorderLayout());
		add(painelBotões, BorderLayout.SOUTH);
		
	}
	
	public static void main(String[] args) {
		
		MisturaTudo janela = new MisturaTudo();
		janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
		janela.setSize(400, 400);
		janela.setVisible(true);
	}

}
