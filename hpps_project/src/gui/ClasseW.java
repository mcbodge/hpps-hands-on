package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class ClasseW extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JSlider slider1;
	private JTextField textField;

	public ClasseW() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		slider1 = new JSlider();
		textField = new JTextField();
		contentPane.add(slider1);
		contentPane.add(textField);
		getContentPane().add(contentPane, BorderLayout.CENTER);
		textField.setColumns(10);
		slider1.setOrientation(SwingConstants.VERTICAL);

		slider1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				textField.setText("Time: " + slider1.getValue());
				System.out.println("Slider1: " + slider1.getValue());
			}
		});
	}

	public static void main(String[] args) {
		new ClasseW().setVisible(true);
	}
}
