package gui;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JTextArea;

public class TestOne extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int NUM_TEMP_VALUES = 8;
	private JFrame frame;
	private JTextArea textArea;
	private ArrayList<String> a;

	/**
	 * Launch the application.
	 */
	public TestOne(ArrayList<String> s){
		this.a=s;
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		textArea = new JTextArea();
		textArea.setEditable(false);
		for(int i=0; i<NUM_TEMP_VALUES; i++) {
			textArea.append(this.a.get(i));
			textArea.append("\n");
		}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
