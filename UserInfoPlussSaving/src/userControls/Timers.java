package userControls;

import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class Timers {
	
	private int min;
	private int sec;
	public Timers(textReader txt, GetImage img, String shipName) {
		new Timer().scheduleAtFixedRate (
			    new TimerTask() {
					public void run() {
						
						//System.out.println(min);
						if(sec==0||sec==30){
							BufferedImage im = img.screanImage();
						txt.readResorces(im,min);
						//txt.getStats(im);
						}
					}
			    }, 0, 1);
		new Timer().scheduleAtFixedRate (
			    new TimerTask() {
					
					private int hun;
					public void run() {
						if(hun>1000){
							sec++;
							hun=0;
						}
						if(sec==60){
							sec=0;
							min++;
						}
						hun++;
					}
			    }, 0, 1);
	}

	
		    
}
