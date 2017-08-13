package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import workingFinder.bonesBox;
import workingFinder.colectingTimers;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TPage window = new TPage();
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
	public TPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//colectingTimers cbox= new colectingTimers();
		bonesBox box=new bonesBox();
		colectingTimers box1=new colectingTimers();
		frame = new JFrame();
		frame.setUndecorated( true );
		frame.getRootPane().setWindowDecorationStyle(6 );
		frame.setBackground(Color.BLUE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 200, 164);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setAlwaysOnTop(true);
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"colect and moving", "colect", "moving"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(36, 59, 128, 20);
		frame.getContentPane().add(comboBox);
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index=comboBox.getSelectedIndex();
				if(index==0){
					box1.colect();
				}
				if(index==1){
					//box.findBonesBox3();
				}
				if(index==2){
					//keeplookingBB
					
				}
				//cbox.colect();
				
			}
		});
		btnNewButton.setBounds(65, 117, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
	}
}
