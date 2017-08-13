package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import userControls.textReader;
import userControls.textReader.displayANCalkinfo;

import javax.swing.JLabel;
import javax.swing.SpringLayout;
import java.awt.Component;

public class Playerinfo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @param dispInfo 
	 * @param dispInfo 
	 */
	public Playerinfo(displayANCalkinfo dispInfo) {
		setTitle("player info");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setAlwaysOnTop(true);
		setBounds(100, 100, 190, 208);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, dispInfo.lblStats, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, dispInfo.lblStats, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, dispInfo.lblStats, -5, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, dispInfo.lblStats, -5, SpringLayout.EAST, contentPane);
		contentPane.add(dispInfo.lblStats);
		
		
	}
}
