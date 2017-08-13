package userControls;

import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import checkStats.PetanShip;
import userControls.panelFinder.panelSearch;

public class Timers {
	
	private int min;
	private int sec;
	 
	public Timers(panelFinder txt, GetImage img) {
		PetanShip petShip=new PetanShip(txt.text);
		new Timer().scheduleAtFixedRate (
			    new TimerTask() {
					public void run() {
						
						//System.out.println(min);
						
							BufferedImage im = img.screanImage();
						txt.readText.getStats(im);
						petShip.setImage(im);
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
