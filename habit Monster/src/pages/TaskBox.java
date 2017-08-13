package pages;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class TaskBox extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	public JLabel lblTaskName = new JLabel("Task Name");
	public JCheckBox chckbxNewCheckBox = new JCheckBox("");
	public JButton btnEdit = new JButton("edit");
	public JButton btnDetails = new JButton("details");
	public JLabel lblStreek = new JLabel("streek=");
	public TaskBox() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		
		lblTaskName.setBounds(33, 55, 120, 14);
		add(lblTaskName);
		
		
		chckbxNewCheckBox.setBounds(250, 46, 26, 23);
		add(chckbxNewCheckBox);
		
		
		btnEdit.setBounds(197, 11, 57, 23);
		add(btnEdit);
		
		
		btnDetails.setBounds(98, 11, 89, 23);
		add(btnDetails);
		
		
		lblStreek.setBounds(283, 51, 46, 23);
		add(lblStreek);

	}
}
