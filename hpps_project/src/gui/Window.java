package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

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
	private GroupLayout groupLayout;
	private ArrayList<String> power;
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

	public Window() {
		initialize();
		actions();
	}
	
	private void initialize() {
		setBounds(100, 100, 550, 300);
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
		comboBox1 = new JComboBox<Integer>();
		comboBox2 = new JComboBox<Integer>();
		lblTthreshold = new JLabel("Tthreshold:");
		lblTcritical = new JLabel("Tcritical:");
		threshold = Tmin;
		critical = Tmax;
		lbl1 = new JLabel(String.format("%.1f", (threshold)));
		lbl2 = new JLabel(String.format("%.1f", (threshold+(critical-threshold)/7)));
		lbl3 = new JLabel(String.format("%.1f", (threshold+2*(critical-threshold)/7)));
		lbl4 = new JLabel(String.format("%.1f", (threshold+3*(critical-threshold)/7)));
		lbl5 = new JLabel(String.format("%.1f", (threshold+4*(critical-threshold)/7)));
		lbl6 = new JLabel(String.format("%.1f", (threshold+5*(critical-threshold)/7)));
		lbl7 = new JLabel(String.format("%.1f", (threshold+6*(critical-threshold)/7)));
		lbl8 = new JLabel(String.format("%.1f", (critical)));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		
		comboBox1.addItem(null);
		for(int i=Tmin; i<Tmax; i++){
			comboBox1.addItem(i);
		}
		
		comboBox2.addItem(null);
		for(int i=Tmin; i<Tmax; i++){
			comboBox2.addItem(i);
		}
			
		groupLayout = new GroupLayout(contentPane);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(18, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lbl1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lbl2)
							.addGap(17))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(slider2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(slider3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lbl3)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(slider4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lbl4)))
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(slider5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lbl5)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(slider6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lbl6)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(slider7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lbl7)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lbl8)
							.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
							.addComponent(jButton)
							.addGap(38))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(slider8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblTthreshold)
								.addComponent(lblTcritical))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(9))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(77)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTthreshold))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTcritical)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(slider4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(slider1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(slider8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(slider7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(slider6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(slider5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(slider2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(slider3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(jButton)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lbl1)
									.addComponent(lbl2)
									.addComponent(lbl4)
									.addComponent(lbl3))
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lbl8)
									.addComponent(lbl7)))
							.addGap(48))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbl5)
								.addComponent(lbl6))
							.addContainerGap())))
		);
		contentPane.setLayout(groupLayout);
		this.setVisible(true);
	}
	
	private void actions() {
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				power = new ArrayList<String>();
				power.add(0, String.valueOf(slider1.getValue()));
				power.add(1, String.valueOf(slider2.getValue()));
				power.add(2, String.valueOf(slider3.getValue()));
				power.add(3, String.valueOf(slider4.getValue()));
				power.add(4, String.valueOf(slider5.getValue()));
				power.add(5, String.valueOf(slider6.getValue()));
				power.add(6, String.valueOf(slider7.getValue()));
				power.add(7, String.valueOf(slider8.getValue()));
				new TestOne(threshold, critical, power);
			}
		});
		
		comboBox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				threshold = (Integer) comboBox1.getSelectedItem();
				lbl1.setText(String.format("%.1f", (threshold)));
				lbl2.setText(String.format("%.1f", (threshold+(critical-threshold)/7)));
				lbl3.setText(String.format("%.1f", (threshold+2*(critical-threshold)/7)));
				lbl4.setText(String.format("%.1f", (threshold+3*(critical-threshold)/7)));
				lbl5.setText(String.format("%.1f", (threshold+4*(critical-threshold)/7)));
				lbl6.setText(String.format("%.1f", (threshold+5*(critical-threshold)/7)));
				lbl7.setText(String.format("%.1f", (threshold+6*(critical-threshold)/7)));
				lbl8.setText(String.format("%.1f", (critical)));
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
				lbl1.setText(String.format("%.1f", (threshold)));
				lbl2.setText(String.format("%.1f", (threshold+(critical-threshold)/7)));
				lbl3.setText(String.format("%.1f", (threshold+2*(critical-threshold)/7)));
				lbl4.setText(String.format("%.1f", (threshold+3*(critical-threshold)/7)));
				lbl5.setText(String.format("%.1f", (threshold+4*(critical-threshold)/7)));
				lbl6.setText(String.format("%.1f", (threshold+5*(critical-threshold)/7)));
				lbl7.setText(String.format("%.1f", (threshold+6*(critical-threshold)/7)));
				lbl8.setText(String.format("%.1f", (critical)));
			}
		});
	}
}
