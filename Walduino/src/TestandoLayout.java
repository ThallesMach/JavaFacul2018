import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

//

public class TestandoLayout extends JFrame {
	
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;

	public TestandoLayout() {
		super("Janelosa Firmeza ");
//		setLayout(new BorderLayout(8, 12) );
		
		btn1 = new JButton("Cima  ");
//		add(btn1, BorderLayout.NORTH);
		setLayout(new GridLayout(3, 2));
		
	}
	
	
	
	public static void main(String[] args) {
		
		TestandoLayout janela = new TestandoLayout();
		janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
		janela.setSize(400, 400);
		janela.setVisible(true);
	}

}
