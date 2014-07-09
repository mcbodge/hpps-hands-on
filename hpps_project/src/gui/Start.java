package gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JRadioButton;




public class Start extends JFrame  {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnPartitaClassica;
	private JButton btnPartitaATurni;
	private JButton btnPartitaATempo;
	private JTextField textField;
	private JRadioButton rdbtnConnessioneSocketdefault;
	private JRadioButton rdbtnConnessioneRmi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Start() {
		//inizializzatore();
		//azionatore();
	}
}



