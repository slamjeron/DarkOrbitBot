package pointmath;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSpinner;


import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;

public class Pgui extends PointMath {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Pgui window = new Pgui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private BufferedImage im;

	/**
	 * Create the application.
	 */
	public Pgui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private JSpinner spinner = new JSpinner();
	private JSpinner spinner_1 = new JSpinner();
	private JSpinner spinner_2 = new JSpinner();
	private JSpinner spinner_3 = new JSpinner();
	private findMap1 map = new findMap1();
	private aiFinder key;
	private mouseListener mouse;
	private JLabel label_2 = new JLabel("=");

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 842, 373);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		iniaiate();
		JButton btnMath = new JButton("math");

		btnMath.setBounds(98, 204, 115, 29);
		frame.getContentPane().add(btnMath);

		spinner.setBounds(99, 95, 83, 26);
		frame.getContentPane().add(spinner);

		spinner_1.setBounds(210, 95, 82, 26);
		frame.getContentPane().add(spinner_1);

		spinner_2.setBounds(98, 162, 82, 26);
		frame.getContentPane().add(spinner_2);

		spinner_3.setBounds(209, 162, 82, 26);
		frame.getContentPane().add(spinner_3);

		JLabel lblX = new JLabel("x");
		lblX.setBounds(99, 62, 69, 20);
		frame.getContentPane().add(lblX);

		JLabel label = new JLabel("x");
		label.setBounds(98, 127, 69, 20);
		frame.getContentPane().add(label);

		JLabel lblY = new JLabel("y");
		lblY.setBounds(210, 62, 69, 20);
		frame.getContentPane().add(lblY);

		JLabel label_1 = new JLabel("y");
		label_1.setBounds(209, 127, 69, 20);
		frame.getContentPane().add(label_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(367, 16, 449, 307);
		frame.getContentPane().add(lblNewLabel);

		JButton btnGetPoints = new JButton("set");
		btnGetPoints.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				hookstart(true);
				btn1pressed = true;
			}
		});
		btnGetPoints.setBounds(0, 101, 58, 29);
		frame.getContentPane().add(btnGetPoints);

		JButton button = new JButton("set");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				hookstart(true);
				btn2pressed = true;
			}
		});
		button.setBounds(0, 161, 58, 29);
		frame.getContentPane().add(button);

		JButton btnSetBoth = new JButton("set both");
		btnSetBoth.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hookstart(true);
				k = 1;
			}
		});
		btnSetBoth.setBounds(260, 47, 102, 29);
		frame.getContentPane().add(btnSetBoth);

		JButton btnMp = new JButton("mp =");
		btnMp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				map.moveFinder();
				spinner.setValue(map.mapLocate.x);
				spinner_1.setValue(map.mapLocate.y);
				hookstart(true);
			}
		});
		btnMp.setBounds(294, 94, 83, 29);
		frame.getContentPane().add(btnMp);

		JButton btnStophook = new JButton("stopHook");
		btnStophook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				hookstart(false);
			}
		});
		btnStophook.setBounds(98, 244, 115, 29);
		frame.getContentPane().add(btnStophook);

		JLabel lblComparedToMap = new JLabel("compared to map");
		lblComparedToMap.setBounds(24, 26, 89, 14);
		frame.getContentPane().add(lblComparedToMap);

		JLabel lblComparedToSenter = new JLabel("compared to senter screen");
		lblComparedToSenter.setBounds(0, 54, 156, 14);
		frame.getContentPane().add(lblComparedToSenter);

		label_2.setBounds(167, 54, 46, 14);
		frame.getContentPane().add(label_2);
		
		JButton btnPetPnt = new JButton("pet Pnt");
		btnPetPnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Point petpnt = map.findPet();
				spinner.setValue(petpnt.x);
				spinner_1.setValue(petpnt.y);
				hookstart(true);
			}
		});
		btnPetPnt.setBounds(280, 252, 83, 29);
		frame.getContentPane().add(btnPetPnt);
		btnMath.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent arg0) {

				im = pMath((int) (spinner.getValue()), (int) (spinner_1.getValue()), (int) (spinner_2.getValue()),
						(int) (spinner_3.getValue()));
				for (int y = 0; y < im.getHeight()-1; y++) {
					for (int x = 0; x < im.getWidth(); x++) {
						brightColor(x,y);
						//shipandgatept(x,y);
					}
				}
				lblNewLabel.setIcon(new ImageIcon(im));
			}
		});
	}
	public void brightColor(int x,int y){
		
		if(img.colmore(new Color(im.getRGB(x, y)),
				new Color(204,204,204) )){
			com.printPoint(x, y);
		}else {
			im.setRGB(x, y, new Color(0, 0, 0).getRGB());
			}
	}
public void shipandgatept(int x,int y){
	if (/*backGround*/!(new Color(im.getRGB(x, y)).equals(new Color(204,204,204))||
			new Color(im.getRGB(x, y)).equals(new Color(204,198,125))||
			new Color(im.getRGB(x, y)).equals(new Color(112,112,112))
			&&new Color(im.getRGB(x, y+1)).equals(new Color(70,70,70))
			&&new Color(im.getRGB(x+1, y)).equals(new Color(70,70,70)))) {

		im.setRGB(x, y, new Color(0, 0, 0).getRGB());
	} else {
		if(new Color(im.getRGB(x, y)).equals(new Color(112,112,112))){
		System.out.println("ship point =");
		}else{
			if(new Color(im.getRGB(x, y)).equals(new Color(204,198,125))){
				System.out.println("home map colors=");
			}else{
			System.out.println("gate point =");
			}
		}
		
		com.printPoint(x, y);
	}
}
	public void iniaiate() {
		try {
			GlobalScreen.registerNativeHook();
			mouse = new mouseListener();
			key = new aiFinder();

			GlobalScreen.getInstance().addNativeKeyListener(key);
			GlobalScreen.getInstance().addNativeMouseListener(mouse);

		} catch (NativeHookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void hookstart(boolean on) {
		try {
			if (on) {
				GlobalScreen.registerNativeHook();
			} else {
				GlobalScreen.unregisterNativeHook();
			}
		} catch (NativeHookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String msLocation = "S";
	// private String createBox="D";
	private boolean btn1pressed;
	private boolean btn2pressed;
	private int k = 0;

	private class mouseListener implements NativeMouseListener {

		@Override
		public void nativeMouseClicked(NativeMouseEvent arg0) {
			// TODO Auto-generated method stub
			if (k == 2) {
				btn2pressed = true;
				k = 0;
			}
			if (k == 1) {
				btn1pressed = true;
				k = 2;
			}
			if (btn1pressed) {
				mp = MouseInfo.getPointerInfo().getLocation();
				spinner.setValue(mp.x);
				spinner_1.setValue(mp.y);
				btn1pressed = false;
			}
			if (btn2pressed) {
				mp = MouseInfo.getPointerInfo().getLocation();
				spinner_2.setValue(mp.x);
				spinner_3.setValue(mp.y);
				btn2pressed = false;
			}
		}

		@Override
		public void nativeMousePressed(NativeMouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void nativeMouseReleased(NativeMouseEvent arg0) {
			// TODO Auto-generated method stub

		}
	}

	private Point mp;

	private class aiFinder implements NativeKeyListener {
		private boolean up;
		private Point mp;

		@Override
		public void nativeKeyPressed(NativeKeyEvent e) {
			String keypresed = NativeKeyEvent.getKeyText(e.getKeyCode());
			// System.out.println("Key prissed: " + keypresed);
			if (!up) {
				if (msLocation.equals(keypresed)) {

					if (k == 2) {
						btn2pressed = true;
						k = 0;
					}
					if (k == 1) {
						btn1pressed = true;
						k = 2;
					}
					if (btn1pressed) {
						mp = MouseInfo.getPointerInfo().getLocation();
						spinner.setValue(mp.x);
						spinner_1.setValue(mp.y);
						btn1pressed = false;
					}
					if (btn2pressed) {
						mp = MouseInfo.getPointerInfo().getLocation();
						spinner_2.setValue(mp.x);
						spinner_3.setValue(mp.y);
						btn2pressed = false;
					}
					up = true;
				}

			}

		}

		@Override
		public void nativeKeyReleased(NativeKeyEvent arg0) {
			// TODO Auto-generated method stub
			up = false;
		}

		@Override
		public void nativeKeyTyped(NativeKeyEvent arg0) {
			// TODO Auto-generated method stub

		}

	}
}
