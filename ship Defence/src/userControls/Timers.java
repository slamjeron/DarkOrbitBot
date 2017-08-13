package userControls;

import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import checkStats.DefenceInfo;
import userControls2.ImgRobot;

public class Timers {
	
	private int min;
	private int sec;
	//ImageReader colimg=new ImageReader();
	private DefenceInfo def;
	private Timer defTimer;
	private Timer clockTimer;
	public Timers() {
		ImgRobot img=new ImgRobot();
		BufferedImage im = img.image.screanImage();
		def=new DefenceInfo();
		def.setImage(im);
		def.startReadImg(img);
		defTimer=new Timer();
		clockTimer=new Timer();
		if(img.imgReader.panelsearch.allItemsFound()){
		defTimer.scheduleAtFixedRate (
			    new TimerTask() {
					public void run() {
						BufferedImage Scim = img.image.screanImage();
						def.setImage(Scim);
						if(def.shipHit()){
							System.out.println("the ship has been hit");
						}
						if(def.petHit()){
							System.out.println("the pet has been hit");
							
						}
						System.out.println(sec);
					}
			    }, 0, 1);
		clockTimer.scheduleAtFixedRate (
			    new TimerTask() {
					public void setTimer(int hun,int sec,int min){
						Timers.this.min=min;
						Timers.this.sec=sec;
						this.hun=hun;
					}
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
	}else{
		JPanel panel = new JPanel();
		JOptionPane.showMessageDialog(panel, "item not located", "Error", JOptionPane.ERROR_MESSAGE);
	}
	}
	
		    
}
