package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import logic.DataManager;
//TODO ottimizzazione codice (soprattutto actions) e layout; intervalli sulle lbl non sono (quasi) mai uguali->visualizzare float, passare int;
//quando cambio programma, perfezionare controlli sugli rbmenuitem;
//sistemare comboDelay (impaginazione); default->operare sui buttons
public class Window extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static final int Tmin = -40;
	private static final int Tmax = 120;
	private static final int NUM_TEMP_VALUES = 8;
	private JPanel contentPane, panel1, panel2, panel3;
	private CardLayout cardLayout;
	private GroupLayout layout1, layout2, layout3;
	private JMenuBar menuBar;
	private JMenu menu, submenu;
	private JRadioButtonMenuItem rbMenuItem1, rbMenuItem2, rbMenuItem3, em1, em2, em3;
	private ButtonGroup group;
	private JSlider slider1, slider2, slider3, slider4, slider5, slider6, slider7, slider8, 
					minPow2, maxPow2, minPow3, maxPow3;
	private JButton jButton1, jButton2, jButton3;
	private JComboBox<Integer> comboThreshold1, comboCritical1, comboDelay, comboThreshold2, comboTarget2, comboCritical2, 
								comboThreshold3, comboTarget3, comboCritical3;
	private JLabel lblThreshold1, lblCritical1, lblThreshold2, lblTarget2, lblCritical2, lblThreshold3, lblTarget3, lblCritical3, 
					lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8, lblDelay, lblMinPow2, lblMaxPow2, lblMinPow3, lblMaxPow3,
					field1, field2, field3, field4, field5, field6, field7, field8, valMinPow2, valMaxPow2, valMinPow3, valMaxPow3;
	private JTextArea description2, description3;
	private float threshold, critical;
	private int emergency, delay, target;
	private int[] temperature, power;

	public Window() {
		initialize();
		actions();
	}
	
	private void initialize() {
		setBounds(100, 100, 600, 500);
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
		rbMenuItem1 = new JRadioButtonMenuItem("User Defined", true);
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
		menu = new JMenu("Emergency");
		submenu = new JMenu("What to do?");
		em1 = new JRadioButtonMenuItem("Maximum power", true);
		em1.setEnabled(false);
		submenu.add(em1);
		em2 = new JRadioButtonMenuItem("Alarm");
		submenu.add(em2);
		em3 = new JRadioButtonMenuItem("Switching off");
		submenu.add(em3);
		menu.add(submenu);
		menuBar.add(menu);
		lblDelay = new JLabel("Delay(ms) :");
		comboDelay = new JComboBox<Integer>();
		for (int item=500; item<10000; item=item+500)
			comboDelay.addItem(item);
		for (int item=10000; item<31000; item=item+1000)
			comboDelay.addItem(item);
		comboDelay.setSelectedItem(4000);
		slider1 = new JSlider(JSlider.VERTICAL);;
		slider1.setMinorTickSpacing(5);
		slider1.setMajorTickSpacing(20);
		slider1.setPaintTicks(true);
		slider1.setPaintLabels(true);
		field1 = new JLabel(""+slider1.getValue());
		slider2 = new JSlider(JSlider.VERTICAL);
		slider2.setMinorTickSpacing(5);
		slider2.setMajorTickSpacing(20);
		slider2.setPaintTicks(true);
		slider2.setPaintLabels(true);
		field2 = new JLabel(""+slider2.getValue());
		slider3 = new JSlider(JSlider.VERTICAL);
		slider3.setMinorTickSpacing(5);
		slider3.setMajorTickSpacing(20);
		slider3.setPaintTicks(true);
		slider3.setPaintLabels(true);
		field3 = new JLabel(""+slider3.getValue());
		slider4 = new JSlider(JSlider.VERTICAL);
		slider4.setMinorTickSpacing(5);
		slider4.setMajorTickSpacing(20);
		slider4.setPaintTicks(true);
		slider4.setPaintLabels(true);
		field4 = new JLabel(""+slider4.getValue());
		slider5 = new JSlider(JSlider.VERTICAL);
		slider5.setMinorTickSpacing(5);
		slider5.setMajorTickSpacing(20);
		slider5.setPaintTicks(true);
		slider5.setPaintLabels(true);
		field5 = new JLabel(""+slider5.getValue());
		slider6 = new JSlider(JSlider.VERTICAL);
		slider6.setMinorTickSpacing(5);
		slider6.setMajorTickSpacing(20);
		slider6.setPaintTicks(true);
		slider6.setPaintLabels(true);
		field6 = new JLabel(""+slider6.getValue());
		slider7 = new JSlider(JSlider.VERTICAL);
		slider7.setMinorTickSpacing(5);
		slider7.setMajorTickSpacing(20);
		slider7.setPaintTicks(true);
		slider7.setPaintLabels(true);
		field7 = new JLabel(""+slider7.getValue());
		slider8 = new JSlider(JSlider.VERTICAL);
		slider8.setMinorTickSpacing(5);
		slider8.setMajorTickSpacing(20);
		slider8.setPaintTicks(true);
		slider8.setPaintLabels(true);
		field8 = new JLabel(""+slider8.getValue());
		jButton1 = new JButton("Submit");
		jButton1.setEnabled(false);
		jButton2 = new JButton("Submit");
		jButton2.setEnabled(false);
		jButton3 = new JButton("Submit");
		jButton3.setEnabled(false);
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
		lblMinPow2 = new JLabel("Min Power:");
		lblMaxPow2 = new JLabel("Max Power:");
		lblMinPow3 = new JLabel("Min Power:");
		lblMaxPow3 = new JLabel("Max Power:");
		minPow2 = new JSlider();
		minPow2.setMinorTickSpacing(5);
		minPow2.setMajorTickSpacing(20);
		minPow2.setPaintTicks(true);
		minPow2.setPaintLabels(true);
		maxPow2 = new JSlider();
		maxPow2.setMinorTickSpacing(5);
		maxPow2.setMajorTickSpacing(20);
		maxPow2.setPaintTicks(true);
		maxPow2.setPaintLabels(true);
		minPow3 = new JSlider();
		minPow3.setMinorTickSpacing(5);
		minPow3.setMajorTickSpacing(20);
		minPow3.setPaintTicks(true);
		minPow3.setPaintLabels(true);
		maxPow3 = new JSlider();
		maxPow3.setMinorTickSpacing(5);
		maxPow3.setMajorTickSpacing(20);
		maxPow3.setPaintTicks(true);
		maxPow3.setPaintLabels(true);
		valMinPow2 = new JLabel(""+minPow2.getValue());
		valMaxPow2 = new JLabel(""+maxPow2.getValue());
		valMinPow3 = new JLabel(""+minPow3.getValue());
		valMaxPow3 = new JLabel(""+maxPow3.getValue());
		threshold = Tmin;
		critical = Tmax;
		temperature = new int[NUM_TEMP_VALUES];
		power = new int[NUM_TEMP_VALUES];
		for (int i=0; i<NUM_TEMP_VALUES; i++) {
			temperature[i] = Math.round(threshold + (critical-threshold)*i/(NUM_TEMP_VALUES-1));
		}
		lbl1 = new JLabel(String.format("%d", temperature[0])+" \u00b0C");
		lbl2 = new JLabel(String.format("%d", temperature[1])+" \u00b0C");
		lbl3 = new JLabel(String.format("%d", temperature[2])+" \u00b0C");
		lbl4 = new JLabel(String.format("%d", temperature[3])+" \u00b0C");
		lbl5 = new JLabel(String.format("%d", temperature[4])+" \u00b0C");
		lbl6 = new JLabel(String.format("%d", temperature[5])+" \u00b0C");
		lbl7 = new JLabel(String.format("%d", temperature[6])+" \u00b0C");
		lbl8 = new JLabel(String.format("%d", temperature[7])+" \u00b0C");
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
										          GroupLayout.PREFERRED_SIZE))
								.addComponent(lblDelay)
								.addComponent(comboDelay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								          GroupLayout.PREFERRED_SIZE))
						.addGroup(layout1.createSequentialGroup()
								.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(field1)
										.addComponent(slider1)
										.addComponent(lbl1))
								.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(field2)
										.addComponent(slider2)
										.addComponent(lbl2))
								.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(field3)
										.addComponent(slider3)
										.addComponent(lbl3))
								.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(field4)
										.addComponent(slider4)
										.addComponent(lbl4))
								.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(field5)
										.addComponent(slider5)
										.addComponent(lbl5))
								.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(field6)
										.addComponent(slider6)
										.addComponent(lbl6))
								.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(field7)
										.addComponent(slider7)
										.addComponent(lbl7))
								.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(field8)
										.addComponent(slider8)
										.addComponent(lbl8)))
						.addComponent(jButton1))
		);
		layout1.setVerticalGroup(layout1.createSequentialGroup()
				.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addGroup(layout1.createSequentialGroup()
								.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lblThreshold1)
										.addComponent(comboThreshold1))
								.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lblCritical1)
										.addComponent(comboCritical1)))
						.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.CENTER)
								.addComponent(lblDelay)
								.addComponent(comboDelay)))
				.addGroup(layout1.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(field1)
						.addComponent(field2)
						.addComponent(field3)
						.addComponent(field4)
						.addComponent(field5)
						.addComponent(field6)
						.addComponent(field7)
						.addComponent(field8))
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
		
		layout2.setHorizontalGroup(layout2.createSequentialGroup()
				.addGroup(layout2.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addGroup(layout2.createSequentialGroup()
								.addGroup(layout2.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(lblThreshold2)
										.addComponent(lblTarget2)
										.addComponent(lblCritical2))
								.addGroup(layout2.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(comboThreshold2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										          GroupLayout.PREFERRED_SIZE)
										.addComponent(comboTarget2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										          GroupLayout.PREFERRED_SIZE)
										.addComponent(comboCritical2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										          GroupLayout.PREFERRED_SIZE))
								.addGroup(layout2.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(lblMinPow2)
										.addComponent(lblMaxPow2))
								.addGroup(layout2.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(minPow2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										          GroupLayout.PREFERRED_SIZE)
										.addComponent(maxPow2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										          GroupLayout.PREFERRED_SIZE))
								.addGroup(layout2.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(valMinPow2)
										.addComponent(valMaxPow2)))
						.addComponent(description2)
						.addComponent(jButton2))
		);
		layout2.setVerticalGroup(layout2.createSequentialGroup()
				.addGroup(layout2.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout2.createSequentialGroup()
								.addGroup(layout2.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lblThreshold2)
										.addComponent(comboThreshold2))
								.addGroup(layout2.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lblTarget2)
										.addComponent(comboTarget2))
								.addGroup(layout2.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lblCritical2)
										.addComponent(comboCritical2)))
						.addGroup(layout2.createSequentialGroup()
								.addGroup(layout2.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lblMinPow2)
										.addComponent(minPow2)
										.addComponent(valMinPow2))
								.addGroup(layout2.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lblMaxPow2)
										.addComponent(maxPow2)
										.addComponent(valMaxPow2))))
				.addComponent(description2)
				.addComponent(jButton2)
		);
		
		layout3.setHorizontalGroup(layout3.createSequentialGroup()
				.addGroup(layout3.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addGroup(layout3.createSequentialGroup()
								.addGroup(layout3.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(lblThreshold3)
										.addComponent(lblTarget3)
										.addComponent(lblCritical3))
								.addGroup(layout3.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(comboThreshold3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										          GroupLayout.PREFERRED_SIZE)
										.addComponent(comboTarget3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										          GroupLayout.PREFERRED_SIZE)
										.addComponent(comboCritical3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										          GroupLayout.PREFERRED_SIZE))
								.addGroup(layout3.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(lblMinPow3)
										.addComponent(lblMaxPow3))
								.addGroup(layout3.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(minPow3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										          GroupLayout.PREFERRED_SIZE)
										.addComponent(maxPow3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										          GroupLayout.PREFERRED_SIZE))
								.addGroup(layout3.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(valMinPow3)
										.addComponent(valMaxPow3)))
						.addComponent(description3)
						.addComponent(jButton3))
		);
		layout3.setVerticalGroup(layout3.createSequentialGroup()
				.addGroup(layout3.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout3.createSequentialGroup()
								.addGroup(layout3.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lblThreshold3)
										.addComponent(comboThreshold3))
								.addGroup(layout3.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lblTarget3)
										.addComponent(comboTarget3))
								.addGroup(layout3.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lblCritical3)
										.addComponent(comboCritical3)))
						.addGroup(layout3.createSequentialGroup()
								.addGroup(layout3.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lblMinPow3)
										.addComponent(minPow3)
										.addComponent(valMinPow3))
								.addGroup(layout3.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lblMaxPow3)
										.addComponent(maxPow3)
										.addComponent(valMaxPow3))))
				.addComponent(description3)
				.addComponent(jButton3)
		);
		
		getContentPane().add(menuBar, BorderLayout.NORTH);
		getContentPane().add(contentPane, BorderLayout.CENTER);
		
		comboThreshold1.addItem(null);
		for(int i=Tmin; i<Tmax; i++){
			comboThreshold1.addItem(i);
		}
		
		comboCritical1.addItem(null);
		comboCritical1.setEnabled(false);
		
		comboThreshold2.addItem(null);
		for(int i=Tmin; i<Tmax; i++){
			comboThreshold2.addItem(i);
		}
		
		comboTarget2.addItem(null);
		comboTarget2.setEnabled(false);
		
		comboCritical2.addItem(null);
		comboCritical2.setEnabled(false);
	
		comboThreshold3.addItem(null);
		for(int i=Tmin; i<Tmax; i++){
			comboThreshold3.addItem(i);
		}
		
		comboTarget3.addItem(null);
		comboTarget3.setEnabled(false);
		
		comboCritical3.addItem(null);
		comboCritical3.setEnabled(false);

		setVisible(true);
	}
	
	private void actions() {
		rbMenuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				threshold = Tmin;
				critical = Tmax;
				cardLayout.show(contentPane, "first");
			}
		});

		rbMenuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				threshold = Tmin;
				critical = Tmax;
		        cardLayout.show(contentPane, "second");
			}
		});
		
		rbMenuItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				threshold = Tmin;
				critical = Tmax;
		        cardLayout.show(contentPane, "third");
			}
		});
		
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				power[0] = slider1.getValue();
				power[1] = slider2.getValue();
				power[2] = slider3.getValue();
				power[3] = slider4.getValue();
				power[4] = slider5.getValue();
				power[5] = slider6.getValue();
				power[6] = slider7.getValue();
				power[7] = slider8.getValue();
				delay = (int) comboDelay.getSelectedItem();
				if (!em2.isSelected()&&!em3.isSelected())
					emergency = 1;
				else if (em2.isSelected()&&!em3.isSelected()) 
					emergency = 2;
				else if (!em2.isSelected()&&em3.isSelected())
					emergency = 3;
				else emergency = 4;
				DataManager.fileCreator(1, emergency, delay, temperature, 0, power);
			}
		});
		
		comboThreshold1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboThreshold1.getSelectedItem()!=null) {
					comboCritical1.setEnabled(true);
					threshold = (int) comboThreshold1.getSelectedItem();
					if (comboCritical1.getSelectedItem()==null || threshold > (int) comboCritical1.getSelectedItem()) {
						comboCritical1.removeAllItems();
						for (int i=(int) comboThreshold1.getSelectedItem(); i<Tmax; i++){
							comboCritical1.addItem(i);
						}
					} else if (threshold > (int) comboCritical1.getItemAt(0)){
						int i = 0;
						while (threshold > comboCritical1.getItemAt(i)) {
							comboCritical1.removeItemAt(i);
						}
					} else if (threshold < (int) comboCritical1.getItemAt(0)) {
						int selection = (int) comboCritical1.getSelectedItem();
						comboCritical1.removeAllItems();
						for (int i=(int) comboThreshold1.getSelectedItem(); i<Tmax; i++){
							comboCritical1.addItem(i);
						}
						comboCritical1.setSelectedItem(selection);
					}
					for (int i=0; i<NUM_TEMP_VALUES; i++) {
						temperature[i] = Math.round(threshold + (critical-threshold)*i/(NUM_TEMP_VALUES-1));
					}
					lbl1.setText(String.format("%d", temperature[0])+" \u00b0C");
					lbl2.setText(String.format("%d", temperature[1])+" \u00b0C");
					lbl3.setText(String.format("%d", temperature[2])+" \u00b0C");
					lbl4.setText(String.format("%d", temperature[3])+" \u00b0C");
					lbl5.setText(String.format("%d", temperature[4])+" \u00b0C");
					lbl6.setText(String.format("%d", temperature[5])+" \u00b0C");
					lbl7.setText(String.format("%d", temperature[6])+" \u00b0C");
					lbl8.setText(String.format("%d", temperature[7])+" \u00b0C");
				} else {
					jButton1.setEnabled(false);
					comboCritical1.removeAllItems();
					comboCritical1.addItem(null);
					comboCritical1.setEnabled(false);
				}
			}
		});
		
		comboCritical1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboCritical1.getSelectedItem()!=null) {
					critical = (int) comboCritical1.getSelectedItem();
					for (int i=1; i<NUM_TEMP_VALUES; i++) {
						temperature[i] = Math.round(threshold + (critical-threshold)*i/(NUM_TEMP_VALUES-1));
					}
					lbl2.setText(String.format("%d", temperature[1])+" \u00b0C");
					lbl3.setText(String.format("%d", temperature[2])+" \u00b0C");
					lbl4.setText(String.format("%d", temperature[3])+" \u00b0C");
					lbl5.setText(String.format("%d", temperature[4])+" \u00b0C");
					lbl6.setText(String.format("%d", temperature[5])+" \u00b0C");
					lbl7.setText(String.format("%d", temperature[6])+" \u00b0C");
					lbl8.setText(String.format("%d", temperature[7])+" \u00b0C");
					jButton1.setEnabled(true);
				}
			}
		});
		
		slider1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int value = slider1.getValue();
				field1.setText(""+value);
				if (slider2.getValue()<value)
					slider2.setValue(value);
			}
		});
		
		slider2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int value = slider2.getValue();
				field2.setText(""+value);
				if (slider3.getValue()<value)
					slider3.setValue(value);
				if (slider1.getValue()>value)
					slider1.setValue(value);
			}
		});

		slider3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int value = slider3.getValue();
				field3.setText(""+value);
				if (slider4.getValue()<value)
					slider4.setValue(value);
				if (slider2.getValue()>value)
					slider2.setValue(value);
			}
		});
		
		slider4.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int value = slider4.getValue();
				field4.setText(""+value);
				if (slider5.getValue()<value)
					slider5.setValue(value);
				if (slider3.getValue()>value)
					slider3.setValue(value);
			}
		});
		
		slider5.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int value = slider5.getValue();
				field5.setText(""+value);
				if (slider6.getValue()<value)
					slider6.setValue(value);
				if (slider4.getValue()>value)
					slider4.setValue(value);
			}
		});
		
		slider6.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int value = slider6.getValue();
				field6.setText(""+value);
				if (slider7.getValue()<value)
					slider7.setValue(value);
				if (slider5.getValue()>value)
					slider5.setValue(value);
			}
		});
		
		slider7.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int value = slider7.getValue();
				field7.setText(""+value);
				if (slider8.getValue()<value)
					slider8.setValue(value);
				if (slider6.getValue()>value)
					slider6.setValue(value);
			}
		});
		
		slider8.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int value = slider8.getValue();
				field8.setText(""+slider8.getValue());
				if (slider7.getValue()>value)
					slider7.setValue(value);
			}
		});
		
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				power[0] = minPow2.getValue();
				power[1] = maxPow2.getValue();
				for (int i=2; i<NUM_TEMP_VALUES; i++) {
					power[i] = power[1];
				}
				if (!em2.isSelected()&&!em3.isSelected())
					emergency = 1;
				else if (em2.isSelected()&&!em3.isSelected()) 
					emergency = 2;
				else if (!em2.isSelected()&&em3.isSelected())
					emergency = 3;
				else emergency = 4;
				DataManager.fileCreator(2, emergency, 4000, temperature, target, power);
			}
		});
		
		comboThreshold2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboThreshold2.getSelectedItem()!=null) {
					comboTarget2.setEnabled(true);
					comboCritical2.setEnabled(true);
					temperature[0] = (int) comboThreshold2.getSelectedItem();
					if (comboTarget2.getSelectedItem()==null || temperature[0] > (int) comboTarget2.getSelectedItem()) {
						comboTarget2.removeAllItems();
						for (int i=(int) comboThreshold2.getSelectedItem(); i<Tmax; i++){
							comboTarget2.addItem(i);
						}
					} else if (temperature[0] > (int) comboTarget2.getItemAt(0)){
						int i = 0;
						while (temperature[0] > comboTarget2.getItemAt(i)) {
							comboTarget2.removeItemAt(i);
						}
					} else if (temperature[0] < (int) comboTarget2.getItemAt(0)) {
						int selection = (int) comboTarget2.getSelectedItem();
						comboTarget2.removeAllItems();
						for (int i=(int) comboThreshold2.getSelectedItem(); i<Tmax; i++){
							comboTarget2.addItem(i);
						}
						comboTarget2.setSelectedItem(selection);
					}
				} else {
					jButton2.setEnabled(false);
					comboCritical2.removeAllItems();
					comboCritical2.addItem(null);
					comboCritical2.setEnabled(false);
					comboTarget2.removeAllItems();
					comboTarget2.addItem(null);
					comboTarget2.setEnabled(false);
				}
			}
		});
		
		comboTarget2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboTarget2.getSelectedItem()!=null) {
					target = (int) comboTarget2.getSelectedItem();
					if (comboCritical2.getSelectedItem()==null || target > (int) comboCritical2.getSelectedItem()) {
						comboCritical2.removeAllItems();
						for (int i=(int) comboTarget2.getSelectedItem(); i<Tmax; i++){
							comboCritical2.addItem(i);
						}
					} else if (target > (int) comboCritical2.getItemAt(0)){
						int i = 0;
						while (target > comboCritical2.getItemAt(i)) {
							comboCritical2.removeItemAt(i);
						}
					} else if (target < (int) comboCritical2.getItemAt(0)) {
						int selection = (int) comboCritical2.getSelectedItem();
						comboCritical2.removeAllItems();
						for (int i=(int) comboTarget2.getSelectedItem(); i<Tmax; i++){
							comboCritical2.addItem(i);
						}
						comboCritical2.setSelectedItem(selection);
					}
				}
			}
		});
		
		comboCritical2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboCritical2.getSelectedItem()!=null) {
					temperature[7] = (int) comboCritical2.getSelectedItem();
					jButton2.setEnabled(true);
				}
			}
		});
		
		minPow2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int value = minPow2.getValue();
				valMinPow2.setText(""+value);
				if (maxPow2.getValue()<value)
					maxPow2.setValue(value);
			}
		});
		
		maxPow2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int value = maxPow2.getValue();
				valMaxPow2.setText(""+value);
				if (minPow2.getValue()>value)
					minPow2.setValue(value);
			}
		});
		
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				power[0] = minPow3.getValue();
				power[1] = maxPow3.getValue();
				for (int i=2; i<NUM_TEMP_VALUES; i++) {
					power[i] = power[1];
				}
				if (!em2.isSelected()&&!em3.isSelected())
					emergency = 1;
				else if (em2.isSelected()&&!em3.isSelected()) 
					emergency = 2;
				else if (!em2.isSelected()&&em3.isSelected())
					emergency = 3;
				else emergency = 4;
				DataManager.fileCreator(3, emergency, 4000, temperature, target, power);
			}
		});
		
		comboThreshold3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboThreshold3.getSelectedItem()!=null) {
					comboTarget3.setEnabled(true);
					comboCritical3.setEnabled(true);
					temperature[0] = (int) comboThreshold3.getSelectedItem();
					if (comboTarget3.getSelectedItem()==null || temperature[0] > (int) comboTarget3.getSelectedItem()) {
						comboTarget3.removeAllItems();
						for (int i=(int) comboThreshold3.getSelectedItem(); i<Tmax; i++){
							comboTarget3.addItem(i);
						}
					} else if (temperature[0] > (int) comboTarget3.getItemAt(0)){
						int i = 0;
						while (temperature[0] > comboTarget3.getItemAt(i)) {
							comboTarget3.removeItemAt(i);
						}
					} else if (temperature[0] < (int) comboTarget3.getItemAt(0)) {
						int selection = (int) comboTarget3.getSelectedItem();
						comboTarget3.removeAllItems();
						for (int i=(int) comboThreshold3.getSelectedItem(); i<Tmax; i++){
							comboTarget3.addItem(i);
						}
						comboTarget3.setSelectedItem(selection);
					}
				} else {
					jButton3.setEnabled(false);
					comboCritical3.removeAllItems();
					comboCritical3.addItem(null);
					comboCritical3.setEnabled(false);
					comboTarget3.removeAllItems();
					comboTarget3.addItem(null);
					comboTarget3.setEnabled(false);
				}
			}
		});
		
		comboTarget3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboTarget3.getSelectedItem()!=null) {
					target = (int) comboTarget3.getSelectedItem();
					if (comboCritical3.getSelectedItem()==null || target > (int) comboCritical3.getSelectedItem()) {
						comboCritical3.removeAllItems();
						for (int i=(int) comboTarget3.getSelectedItem(); i<Tmax; i++){
							comboCritical3.addItem(i);
						}
					} else if (target > (int) comboCritical3.getItemAt(0)){
						int i = 0;
						while (target > comboCritical3.getItemAt(i)) {
							comboCritical3.removeItemAt(i);
						}
					} else if (target < (int) comboCritical3.getItemAt(0)) {
						int selection = (int) comboCritical3.getSelectedItem();
						comboCritical3.removeAllItems();
						for (int i=(int) comboTarget3.getSelectedItem(); i<Tmax; i++){
							comboCritical3.addItem(i);
						}
						comboCritical3.setSelectedItem(selection);
					}
				}
			}
		});
		
		comboCritical3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboCritical3.getSelectedItem()!=null) {
					temperature[7] = (int) comboCritical3.getSelectedItem();
					jButton3.setEnabled(true);
				}
			}
		});
		
		minPow3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int value = minPow3.getValue();
				valMinPow3.setText(""+value);
				if (maxPow3.getValue()<value)
					maxPow3.setValue(value);
			}
		});
		
		maxPow3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int value = maxPow3.getValue();
				valMaxPow3.setText(""+value);
				if (minPow3.getValue()>value)
					minPow3.setValue(value);
			}
		});
	}
}
