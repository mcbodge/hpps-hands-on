package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import logic.DataManager;

public class Window extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private static final int Tmin = -40;
	private static final int Tmax = 120;
	private JPanel contentPane, panel1, panel2, panel3;
	private CardLayout cardLayout;
	private GroupLayout layout1, layout2, layout3;
	private JMenuBar menuBar;
	private JMenu menu;
	private JRadioButtonMenuItem rbMenuItem1, rbMenuItem2, rbMenuItem3;
	private ButtonGroup group;
	private JSlider slider1, slider2, slider3, slider4, slider5, slider6, slider7, slider8;
	private JButton jButton1, jButton2, jButton3;
	private JComboBox<Integer> comboThreshold1, comboCritical1, comboThreshold2, comboTarget2, comboCritical2, 
								comboThreshold3, comboTarget3, comboCritical3;
	private JLabel lblThreshold1, lblCritical1, lblThreshold2, lblTarget2, lblCritical2, lblThreshold3, lblTarget3, lblCritical3, 
					lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8;
	private JTextArea description2, description3;
	private float threshold, critical;
	private int[] power;

	public Window() {
		initialize();
		actions();
	}
	
	private void initialize() {
		setBounds(100, 100, 900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		cardLayout = new CardLayout();
		contentPane = new JPanel(cardLayout);
		contentPane.add(panel1, "first");
		contentPane.add(panel2, "second");
		contentPane.add(panel3, "third");
		layout1 = new GroupLayout(panel1);
		layout1.setAutoCreateGaps(true);
		layout1.setAutoCreateContainerGaps(true);
		panel1.setLayout(layout1);
		layout2 = new GroupLayout(panel2);
		layout2.setAutoCreateGaps(true);
		layout2.setAutoCreateContainerGaps(true);
		panel2.setLayout(layout2);
		layout3 = new GroupLayout(panel3);
		layout3.setAutoCreateGaps(true);
		layout3.setAutoCreateContainerGaps(true);
		panel3.setLayout(layout3);
		group = new ButtonGroup();
		menu = new JMenu("Program");
		rbMenuItem1 = new JRadioButtonMenuItem("User Defined");
		rbMenuItem1.setSelected(true);
		group.add(rbMenuItem1);
		menu.add(rbMenuItem1);
		rbMenuItem2 = new JRadioButtonMenuItem("Power Efficiency");
		group.add(rbMenuItem2);
		menu.add(rbMenuItem2);
		rbMenuItem3 = new JRadioButtonMenuItem("Max Cooling Efficieny");
		group.add(rbMenuItem3);
		menu.add(rbMenuItem3);
		menuBar = new JMenuBar();
		menuBar.add(menu);
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
		jButton1 = new JButton();
		comboThreshold1 = new JComboBox<Integer>();
		comboCritical1 = new JComboBox<Integer>();
		comboThreshold2 = new JComboBox<Integer>();
		comboTarget2 = new JComboBox<Integer>();
		comboCritical2 = new JComboBox<Integer>();
		comboThreshold3 = new JComboBox<Integer>();
		comboTarget3 = new JComboBox<Integer>();
		comboCritical3 = new JComboBox<Integer>();
		lblThreshold1 = new JLabel("T threshold:");
		lblCritical1 = new JLabel("T critical:");
		lblThreshold2 = new JLabel("T threshold:");
		lblTarget2 = new JLabel("T target:");
		lblCritical2 = new JLabel("T critical:");
		lblThreshold3 = new JLabel("T threshold:");
		lblTarget3 = new JLabel("T target:");
		lblCritical3 = new JLabel("T critical:");
		threshold = Tmin;
		critical = Tmax;
		lbl1 = new JLabel(String.format("%.1f", (threshold))+" \u00b0C");
		lbl2 = new JLabel(String.format("%.1f", (threshold+(critical-threshold)/7))+" \u00b0C");
		lbl3 = new JLabel(String.format("%.1f", (threshold+2*(critical-threshold)/7))+" \u00b0C");
		lbl4 = new JLabel(String.format("%.1f", (threshold+3*(critical-threshold)/7))+" \u00b0C");
		lbl5 = new JLabel(String.format("%.1f", (threshold+4*(critical-threshold)/7))+" \u00b0C");
		lbl6 = new JLabel(String.format("%.1f", (threshold+5*(critical-threshold)/7))+" \u00b0C");
		lbl7 = new JLabel(String.format("%.1f", (threshold+6*(critical-threshold)/7))+" \u00b0C");
		lbl8 = new JLabel(String.format("%.1f", (critical))+" \u00b0C");
		description2 = new JTextArea("ciao sono il due.");
		description3 = new JTextArea("ciao sono il tre.");
		
		layout1.setHorizontalGroup(layout1.createSequentialGroup()
				.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addGroup(layout1.createSequentialGroup()
								.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(lblThreshold1)
										.addComponent(lblCritical1))
								.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(comboThreshold1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										          GroupLayout.PREFERRED_SIZE)
										.addComponent(comboCritical1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										          GroupLayout.PREFERRED_SIZE)))
						.addGroup(layout1.createSequentialGroup()
								.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(slider1)
										.addComponent(lbl1))
								.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(slider2)
										.addComponent(lbl2))
								.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(slider3)
										.addComponent(lbl3))
								.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(slider4)
										.addComponent(lbl4))
								.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(slider5)
										.addComponent(lbl5))
								.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(slider6)
										.addComponent(lbl6))
								.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(slider7)
										.addComponent(lbl7))
								.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(slider8)
										.addComponent(lbl8)))
						.addComponent(jButton1))
		);
		layout1.setVerticalGroup(layout1.createSequentialGroup()
				.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lblThreshold1)
						.addComponent(comboThreshold1))
				.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lblCritical1)
						.addComponent(comboCritical1))
				.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(slider1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						          GroupLayout.PREFERRED_SIZE)
						.addComponent(slider2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						          GroupLayout.PREFERRED_SIZE)
						.addComponent(slider3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						          GroupLayout.PREFERRED_SIZE)
						.addComponent(slider4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						          GroupLayout.PREFERRED_SIZE)
						.addComponent(slider5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						          GroupLayout.PREFERRED_SIZE)
						.addComponent(slider6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						          GroupLayout.PREFERRED_SIZE)
						.addComponent(slider7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						          GroupLayout.PREFERRED_SIZE)
						.addComponent(slider8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						          GroupLayout.PREFERRED_SIZE))
				.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(lbl1)
						.addComponent(lbl2)
						.addComponent(lbl3)
						.addComponent(lbl4)
						.addComponent(lbl5)
						.addComponent(lbl6)
						.addComponent(lbl7)
						.addComponent(lbl8))
				.addComponent(jButton1)
		);
		
		/*layout2.setHorizontalGroup(layout2.createSequentialGroup()
				
		);*/
		
		getContentPane().add(menuBar, BorderLayout.NORTH);
		getContentPane().add(contentPane, BorderLayout.CENTER);
		
		comboThreshold1.addItem(null);
		for(int i=Tmin; i<Tmax; i++){
			comboThreshold1.addItem(i);
		}
		
		comboCritical1.addItem(null);
		for(int i=Tmin; i<Tmax; i++){
			comboCritical1.addItem(i);
		}
		
		comboThreshold2.addItem(null);
		for(int i=Tmin; i<Tmax; i++){
			comboThreshold2.addItem(i);
		}
		
		comboTarget2.addItem(null);
		for(int i=Tmin; i<Tmax; i++){
			comboTarget2.addItem(i);
		}
		
		comboCritical2.addItem(null);
		for(int i=Tmin; i<Tmax; i++){
			comboCritical2.addItem(i);
		}
		
		comboThreshold3.addItem(null);
		for(int i=Tmin; i<Tmax; i++){
			comboThreshold3.addItem(i);
		}
		
		comboTarget3.addItem(null);
		for(int i=Tmin; i<Tmax; i++){
			comboTarget3.addItem(i);
		}
		
		comboCritical3.addItem(null);
		for(int i=Tmin; i<Tmax; i++){
			comboCritical3.addItem(i);
		}
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==rbMenuItem1)
			cardLayout.show(contentPane, "first");
		else if (e.getSource()==rbMenuItem2)
	        cardLayout.show(contentPane, "second");
		else if (e.getSource()==rbMenuItem3) 
	        cardLayout.show(contentPane, "third");
		else if (e.getSource()==jButton1) {
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
	}
	
	private void actions() {
		rbMenuItem1.addActionListener(this);
		rbMenuItem2.addActionListener(this);
		rbMenuItem3.addActionListener(this);	
		jButton1.addActionListener(this);
		
		comboThreshold1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				threshold = (Integer) comboThreshold1.getSelectedItem();
				lbl1.setText(String.format("%.1f", (threshold))+" \u00b0C");
				lbl2.setText(String.format("%.1f", (threshold+(critical-threshold)/7))+" \u00b0C");
				lbl3.setText(String.format("%.1f", (threshold+2*(critical-threshold)/7))+" \u00b0C");
				lbl4.setText(String.format("%.1f", (threshold+3*(critical-threshold)/7))+" \u00b0C");
				lbl5.setText(String.format("%.1f", (threshold+4*(critical-threshold)/7))+" \u00b0C");
				lbl6.setText(String.format("%.1f", (threshold+5*(critical-threshold)/7))+" \u00b0C");
				lbl7.setText(String.format("%.1f", (threshold+6*(critical-threshold)/7))+" \u00b0C");
				lbl8.setText(String.format("%.1f", (critical))+" \u00b0C");
				if (threshold>critical){
					comboCritical1.removeAllItems();
					for (int i=(int) comboThreshold1.getSelectedItem(); i<Tmax; i++){
						comboCritical1.addItem(i);
					}
				}
			}
		});
		
		comboCritical1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboCritical1.getSelectedItem()==null)
					critical = threshold;
				else
					critical = (Integer) comboCritical1.getSelectedItem();
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
