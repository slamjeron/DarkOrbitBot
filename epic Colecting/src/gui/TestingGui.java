package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import meetCode.BiginingLVL1;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestingGui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestingGui window = new TestingGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestingGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 294, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JRadioButton rdbtnRun = new JRadioButton("run");
		rdbtnRun.setBounds(6, 33, 61, 23);
		frame.getContentPane().add(rdbtnRun);
		
		JRadioButton rdbtnColect = new JRadioButton("colect");
		rdbtnColect.setBounds(6, 7, 61, 23);
		frame.getContentPane().add(rdbtnColect);
		
		JRadioButton rdbtnRunNow = new JRadioButton("pretend hit");
		rdbtnRunNow.setBounds(68, 33, 89, 23);
		frame.getContentPane().add(rdbtnRunNow);
		
		JRadioButton rdbtnFindEnimyPlayer = new JRadioButton("find enimy player");
		rdbtnFindEnimyPlayer.setBounds(5, 59, 116, 23);
		frame.getContentPane().add(rdbtnFindEnimyPlayer);
		
		JLabel lblEnimyPlayerInsignea = new JLabel("enimy player insignea");
		lblEnimyPlayerInsignea.setBounds(127, 63, 29, 36);
		frame.getContentPane().add(lblEnimyPlayerInsignea);
		
		JLabel lblPlayerStats = new JLabel("player stats");
		lblPlayerStats.setBounds(179, 7, 89, 75);
		frame.getContentPane().add(lblPlayerStats);
		
		JRadioButton rdbtnPetColect = new JRadioButton("pet colect");
		rdbtnPetColect.setBounds(12, 99, 109, 23);
		frame.getContentPane().add(rdbtnPetColect);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			
			private BiginingLVL1 start;
			

			public void actionPerformed(ActionEvent arg0) {
				boolean run = rdbtnRun.isSelected();
				boolean colect = rdbtnColect.isSelected();
				boolean runNow = rdbtnRunNow.isSelected();
				boolean fndPP = rdbtnFindEnimyPlayer.isSelected();
				boolean ptclct = rdbtnPetColect.isSelected();
				start.test(run,colect,runNow,fndPP,ptclct);
			}
		});
		btnNewButton.setBounds(32, 172, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		
	}
}
