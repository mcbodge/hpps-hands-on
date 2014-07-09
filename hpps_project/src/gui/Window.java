package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.SwingConstants;

import logic.DataManager;

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
	
	public static void main(String[] args) {
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
	}

	public Window() {
		initialize();
		actions();
	}
	
	private void initialize() {
		data = new ArrayList<String>();
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
	}
	
	private void actions() {
		jButton.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				data.add(0, "Slider1: "+slider1.getValue());
				data.add(1, "Slider2: "+slider2.getValue());
				data.add(2, "Slider3: "+slider3.getValue());
				data.add(3, "Slider4: "+slider4.getValue());
				data.add(4, "Slider5: "+slider5.getValue());
				data.add(5, "Slider6: "+slider6.getValue());
				data.add(6, "Slider7: "+slider7.getValue());
				data.add(7, "Slider8: "+slider8.getValue());
				System.out.println("Windows actions 1" + data.get(0));
				DataManager dataman = new DataManager(data);
				System.out.println("Windows actions 2" + data.get(0));
				dataman.putInTestOne();
				System.out.println("Windows actions 3" + data.get(0));
			}
		});
	}
}
