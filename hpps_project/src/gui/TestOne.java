package gui;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JTextArea;

public class TestOne extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int NUM_TEMP_VALUES = 8;
	private JFrame frame;
	private JTextArea textArea;
	private float threshold;
	private float critical;
	private ArrayList<String> power;
	private GregorianCalendar calendar; 

	/**
	 * Launch the application.
	 */
	public TestOne(float threshold, float critical, ArrayList<String> power){
		this.threshold = threshold;
		this.critical = critical;
		this.power=power;
		initialize();
		display(threshold, critical, power);
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
		calendar = new GregorianCalendar();
	}
	
	private void display(float threshold, float critical, ArrayList<String> power){
		textArea.append("; The INI file looks like:\n\n");
		textArea.append("[last_update]\n");
		textArea.append("year="+calendar.get(Calendar.YEAR)+"\n");
		textArea.append("month="+(calendar.get(Calendar.MONTH)+1)+"\n");
		textArea.append("day="+calendar.get(Calendar.DAY_OF_MONTH)+"\n");
		textArea.append("h="+calendar.get(Calendar.HOUR_OF_DAY)+"\n");
		textArea.append("m="+calendar.get(Calendar.MINUTE)+"\n");
		textArea.append("s="+calendar.get(Calendar.SECOND)+"\n\n");
		textArea.append("[temperature_values]\n");
		textArea.append("threshold="+this.threshold+"\n");
		textArea.append("critical="+this.critical+"\n\n");
		textArea.append("[fan_speed]\n");
		for(int i=0; i<NUM_TEMP_VALUES; i++) {
			textArea.append(String.valueOf(i+1) + "=" + this.power.get(i));
			textArea.append("\n");
		}
				
		//TODO Aggiungere programma -- impostato in windows
	}
}
