package triangle;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TriangleMath {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TriangleMath window = new TriangleMath();
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
	public TriangleMath() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public Rtriangle tri=new Rtriangle();
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHipotinuse = new JLabel("hipotinuse =");
		lblHipotinuse.setBounds(32, 59, 130, 14);
		frame.getContentPane().add(lblHipotinuse);
		
		JLabel lblBonesBoxPoint = new JLabel("bones box point = 400,500");
		lblBonesBoxPoint.setBounds(32, 87, 152, 14);
		frame.getContentPane().add(lblBonesBoxPoint);
		
		JLabel lblClickPoint = new JLabel("click point = ");
		lblClickPoint.setBounds(32, 112, 152, 14);
		frame.getContentPane().add(lblClickPoint);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(32, 154, 152, 80);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblStartPnt = new JLabel("start pnt");
		lblStartPnt.setBounds(59, 11, 46, 14);
		panel.add(lblStartPnt);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(500), new Integer(100), null, new Integer(10)));
		spinner.setBounds(10, 49, 58, 20);
		panel.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Integer(600), new Integer(100), null, new Integer(10)));
		spinner_1.setBounds(84, 49, 58, 20);
		panel.add(spinner_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(237, 154, 152, 80);
		frame.getContentPane().add(panel_1);
		
		JLabel lblEndPnt = new JLabel("end pnt");
		lblEndPnt.setBounds(59, 11, 46, 14);
		panel_1.add(lblEndPnt);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(new Integer(700), new Integer(100), null, new Integer(10)));
		spinner_2.setBounds(10, 49, 58, 20);
		panel_1.add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(new Integer(400), new Integer(100), null, new Integer(10)));
		spinner_3.setBounds(84, 49, 58, 20);
		panel_1.add(spinner_3);
		
		JLabel lblSlope = new JLabel("slope =");
		lblSlope.setBounds(32, 34, 130, 14);
		frame.getContentPane().add(lblSlope);
		
		JButton btnSolve = new JButton("solve");
		btnSolve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int x1 = (int) spinner.getValue();
				int y1 = (int) spinner_1.getValue();
				int x2 = (int) spinner_2.getValue();
				int y2 = (int) spinner_3.getValue();
				Point p1 = new Point(x1,y1);
				Point p2 = new Point(x2,y2);
				tri.findhipotinose(p1,p2);
				lblHipotinuse.setText("hipotinose ="+tri.getHipotinose());
				lblSlope.setText("slope ="+tri.getSlope());
			}
		});
		btnSolve.setBounds(164, 257, 89, 23);
		frame.getContentPane().add(btnSolve);
	}
}
