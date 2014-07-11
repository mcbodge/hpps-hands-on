package gui;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JTextArea;
import java.util.Calendar;

public class TestOne extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int NUM_TEMP_VALUES = 8;
	private JFrame frame;
	private JTextArea textArea;
	private ArrayList<String> sliders;

	/**
	 * Launch the application.
	 */
	public TestOne(ArrayList<String> s){
		initialize();
		display(s);
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		textArea = new JTextArea();
		textArea.setEditable(false);		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
	private void display(ArrayList<String> s){
		this.sliders=s;
		textArea.append("; The INI file looks like:\n\n");
		textArea.append("[last_update]\n");
		textArea.append("y="+Calendar.YEAR+"\n");
		textArea.append("m="+Calendar.MONTH+"\n");
		textArea.append("d="+Calendar.DAY_OF_MONTH+"\n");
		textArea.append("h="+Calendar.HOUR_OF_DAY+Calendar.MINUTE+"\n\n");
		textArea.append("[fan_speed]\n");
		for(int i=0; i<NUM_TEMP_VALUES; i++) {
			textArea.append(String.valueOf(i+1) + "=" + this.sliders.get(i));
			textArea.append("\n");
		}
		
		//TODO Aggiungere ordinate (temperature) -- impostate in windows
		
		//TODO Aggiungere programma -- impostato in windows
	}
}
