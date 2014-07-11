package gui;

import java.awt.BorderLayout;
//import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class Window extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JSlider slider1;
	private JSlider slider2;
	private JSlider slider3;
	private JSlider slider4;
	private JSlider slider5;
	private JSlider slider6;
	private JSlider slider7;
	private JSlider slider8;
	private JButton jButton;
	private ArrayList<String> data;
	
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public Window() {
		initialize();
		actions();
	}
	
	private void initialize() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		slider1 = new JSlider();
		slider1.setOrientation(SwingConstants.VERTICAL);
		slider2 = new JSlider();
		slider2.setOrientation(SwingConstants.VERTICAL);
		slider3 = new JSlider();
		slider3.setOrientation(SwingConstants.VERTICAL);
		slider4 = new JSlider();
		slider4.setOrientation(SwingConstants.VERTICAL);
		slider5 = new JSlider();
		slider5.setOrientation(SwingConstants.VERTICAL);
		slider6 = new JSlider();
		slider6.setOrientation(SwingConstants.VERTICAL);
		slider7 = new JSlider();
		slider7.setOrientation(SwingConstants.VERTICAL);
		slider8 = new JSlider();
		slider8.setOrientation(SwingConstants.VERTICAL);
		jButton = new JButton();
		contentPane.add(slider1);
		contentPane.add(slider2);
		contentPane.add(slider3);
		contentPane.add(slider4);
		contentPane.add(slider5);
		contentPane.add(slider6);
		contentPane.add(slider7);
		contentPane.add(slider8);
		contentPane.add(jButton);
		getContentPane().add(contentPane, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	private void actions() {
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				data = new ArrayList<String>();
				data.add(0, String.valueOf(slider1.getValue()));
				data.add(1, String.valueOf(slider2.getValue()));
				data.add(2, String.valueOf(slider3.getValue()));
				data.add(3, String.valueOf(slider4.getValue()));
				data.add(4, String.valueOf(slider5.getValue()));
				data.add(5, String.valueOf(slider6.getValue()));
				data.add(6, String.valueOf(slider7.getValue()));
				data.add(7, String.valueOf(slider8.getValue()));
				new TestOne(data);
			}
		});
	}
}
