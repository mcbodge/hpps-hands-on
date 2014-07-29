package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import logic.DataManager;

public class Window extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static final int Tmin = -40;
	private static final int Tmax = 120;
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
	private JComboBox<Integer> comboBox1;
	private JComboBox<Integer> comboBox2;
	private JLabel lblTthreshold;
	private JLabel lblTcritical;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	private JLabel lbl7;
	private JLabel lbl8;
	private float threshold;
	private float critical;
	private int[] power;

	public Window() {
		initialize();
		actions();
	}
	
	private void initialize() {
		setBounds(100, 100, 900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		slider1 = new JSlider();
		slider1.setBounds(10, 100, 29, 190);
		slider1.setOrientation(SwingConstants.VERTICAL);
		slider2 = new JSlider();
		slider2.setBounds(60, 100, 29, 190);
		slider2.setOrientation(SwingConstants.VERTICAL);
		slider3 = new JSlider();
		slider3.setBounds(110, 100, 29, 190);
		slider3.setOrientation(SwingConstants.VERTICAL);
		slider4 = new JSlider();
		slider4.setBounds(160, 100, 29, 190);
		slider4.setOrientation(SwingConstants.VERTICAL);
		slider5 = new JSlider();
		slider5.setBounds(210, 100, 29, 190);
		slider5.setOrientation(SwingConstants.VERTICAL);
		slider6 = new JSlider();
		slider6.setBounds(260, 100, 29, 190);
		slider6.setOrientation(SwingConstants.VERTICAL);
		slider7 = new JSlider();
		slider7.setBounds(310, 100, 29, 190);
		slider7.setOrientation(SwingConstants.VERTICAL);
		slider8 = new JSlider();
		slider8.setBounds(360, 100, 29, 190);
		slider8.setOrientation(SwingConstants.VERTICAL);
		jButton = new JButton();
		jButton.setBounds(442, 201, 75, 29);
		comboBox1 = new JComboBox<Integer>();
		comboBox1.setBounds(494, 77, 52, 27);
		comboBox2 = new JComboBox<Integer>();
		comboBox2.setBounds(494, 110, 52, 27);
		lblTthreshold = new JLabel("Tthreshold:");
		lblTthreshold.setBounds(404, 81, 72, 16);
		lblTcritical = new JLabel("Tcritical:");
		lblTcritical.setBounds(421, 114, 55, 16);
		threshold = Tmin;
		critical = Tmax;
		lbl1 = new JLabel(String.format("%.1f", (threshold))+" \u00b0C");
		lbl1.setBounds(6, 290, 60, 16);
		lbl2 = new JLabel(String.format("%.1f", (threshold+(critical-threshold)/7))+" \u00b0C");
		lbl2.setBounds(70, 290, 60, 16);
		lbl3 = new JLabel(String.format("%.1f", (threshold+2*(critical-threshold)/7))+" \u00b0C");
		lbl3.setBounds(122, 201, 20, 16);
		lbl4 = new JLabel(String.format("%.1f", (threshold+3*(critical-threshold)/7))+" \u00b0C");
		lbl4.setBounds(169, 201, 28, 16);
		lbl5 = new JLabel(String.format("%.1f", (threshold+4*(critical-threshold)/7))+" \u00b0C");
		lbl5.setBounds(218, 201, 28, 16);
		lbl6 = new JLabel(String.format("%.1f", (threshold+5*(critical-threshold)/7))+" \u00b0C");
		lbl6.setBounds(270, 201, 28, 16);
		lbl7 = new JLabel(String.format("%.1f", (threshold+6*(critical-threshold)/7))+" \u00b0C");
		lbl7.setBounds(317, 201, 28, 16);
		lbl8 = new JLabel(String.format("%.1f", (critical))+" \u00b0C");
		lbl8.setBounds(363, 201, 73, 16);
		getContentPane().add(contentPane, BorderLayout.CENTER);
		
		comboBox1.addItem(null);
		for(int i=Tmin; i<Tmax; i++){
			comboBox1.addItem(i);
		}
		
		comboBox2.addItem(null);
		for(int i=Tmin; i<Tmax; i++){
			comboBox2.addItem(i);
		}
		contentPane.setLayout(null);
		contentPane.add(lbl1);
		contentPane.add(slider1);
		contentPane.add(lbl2);
		contentPane.add(slider2);
		contentPane.add(slider3);
		contentPane.add(lbl3);
		contentPane.add(slider4);
		contentPane.add(lbl4);
		contentPane.add(slider5);
		contentPane.add(lbl5);
		contentPane.add(slider6);
		contentPane.add(lbl6);
		contentPane.add(slider7);
		contentPane.add(lbl7);
		contentPane.add(lbl8);
		contentPane.add(jButton);
		contentPane.add(slider8);
		contentPane.add(lblTthreshold);
		contentPane.add(lblTcritical);
		contentPane.add(comboBox2);
		contentPane.add(comboBox1);
		this.setVisible(true);
	}
	
	private void actions() {
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				power = new int[8];
				power[0] = slider1.getValue();
				power[1] = slider2.getValue();
				power[2] = slider3.getValue();
				power[3] = slider4.getValue();
				power[4] = slider5.getValue();
				power[5] = slider6.getValue();
				power[6] = slider7.getValue();
				power[7] = slider8.getValue();
				DataManager.fileCreator(threshold, critical, power);
			}
		});
		
		comboBox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				threshold = (Integer) comboBox1.getSelectedItem();
				lbl1.setText(String.format("%.1f", (threshold))+" \u00b0C");
				lbl2.setText(String.format("%.1f", (threshold+(critical-threshold)/7))+" \u00b0C");
				lbl3.setText(String.format("%.1f", (threshold+2*(critical-threshold)/7))+" \u00b0C");
				lbl4.setText(String.format("%.1f", (threshold+3*(critical-threshold)/7))+" \u00b0C");
				lbl5.setText(String.format("%.1f", (threshold+4*(critical-threshold)/7))+" \u00b0C");
				lbl6.setText(String.format("%.1f", (threshold+5*(critical-threshold)/7))+" \u00b0C");
				lbl7.setText(String.format("%.1f", (threshold+6*(critical-threshold)/7))+" \u00b0C");
				lbl8.setText(String.format("%.1f", (critical))+" \u00b0C");
				if (threshold>critical){
					comboBox2.removeAllItems();
					for (int i=(int) comboBox1.getSelectedItem(); i<Tmax; i++){
						comboBox2.addItem(i);
					}
				}
			}
		});
		
		comboBox2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBox2.getSelectedItem()==null)
					critical = threshold;
				else
					critical = (Integer) comboBox2.getSelectedItem();
				lbl1.setText(String.format("%.1f", (threshold))+" \u00b0C");
				lbl2.setText(String.format("%.1f", (threshold+(critical-threshold)/7))+" \u00b0C");
				lbl3.setText(String.format("%.1f", (threshold+2*(critical-threshold)/7))+" \u00b0C");
				lbl4.setText(String.format("%.1f", (threshold+3*(critical-threshold)/7))+" \u00b0C");
				lbl5.setText(String.format("%.1f", (threshold+4*(critical-threshold)/7))+" \u00b0C");
				lbl6.setText(String.format("%.1f", (threshold+5*(critical-threshold)/7))+" \u00b0C");
				lbl7.setText(String.format("%.1f", (threshold+6*(critical-threshold)/7))+" \u00b0C");
				lbl8.setText(String.format("%.1f", (critical))+" \u00b0C");
			}
		});
	}
}
