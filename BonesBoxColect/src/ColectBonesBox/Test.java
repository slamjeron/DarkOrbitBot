package ColectBonesBox;

import java.awt.AWTException;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;

import takeAction.CursorControl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class Test {

	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
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
	public Test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private bonesBoxsearch box=new bonesBoxsearch();
	private TypingFun type;
	private int k=0;
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setAlwaysOnTop(true);
		CursorControl con = new CursorControl();
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				//System.out.println(box.imgcon.twoPntSkip(444,222,333,445,666,100));
				
				con.rightclick(1160,800);
				//con.moveCursor(1160,800);
				//con.sleep(10);
				
				String st;
				switch (k){
				case 0:
					//con.type("this !()");
					try {
						type=new TypingFun();
					} catch (AWTException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					st="\"Hello\"";
					
					
					type.type("It is also worth noting that you can"
							+ " include arbitrary Unicode characters "
							+ "in your source code using Unicode escape"
							+ " sequences of the form where the are "+st
							+ "hexadecimal digits. However, these are different"
							+ " from ordinary string and character escapes in that"
							+ " you can use them anywhere in a Java program ... not"
							+ " just in string and character literals; see JLS sections"
							+ " 3.1, 3.2 and 3.3 for a details on the use of"
							+ " Unicode in Java source code.!");
					//con.type('"'+"Oh no! I am not in control! There isn't enough time!"+'"');
					break;
					
				}
				k++;
			
			}
		});
		btnNewButton.setBounds(149, 88, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnReset = new JButton("reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				k=0;
			}
		});
		btnReset.setBounds(138, 156, 89, 23);
		frame.getContentPane().add(btnReset);
	}
}
