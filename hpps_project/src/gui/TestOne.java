package gui;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextArea;

public class TestOne extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextArea textArea;
	private String s="not initialized";

	/**
	 * Launch the application.
	 */
	public TestOne(String s){
		this.s=s;
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
		textArea.append(s);
	}

}
