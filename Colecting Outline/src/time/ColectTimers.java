package time;

import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import checkStats.DefenceManuvers;
import checkStats.PetActions;
import checkStats.StatsMoniter;
import keyMouse.Keyboard;
import keyMouse.Mouse;
import objectFinder.GamePanels.panelPoints;
import objectFinder.ImgRobot;

public class ColectTimers {

	private boolean fleeing;
	public panelPoints panels;
	private Timer timer=new Timer();
	public ImgRobot imgR;
	public Mouse mouse=new Mouse();
	private Keyboard keyB=new Keyboard();
	private PetActions pet=new PetActions();
	public void start() {
		pet=new PetActions();
		pet.setPanelPnt(panels.pet);
		pet.imgR=imgR;
		pet.mouse=mouse;
		pet.keyB=keyB;
		timer.scheduleAtFixedRate (
				new TimerTask() {
				private StatsMoniter monitor;
				private boolean petHit;
				private boolean shipHit;
				private DefenceManuvers defence;
				
				public void run() {
					BufferedImage screenImg =
							imgR.image.getScreenImage();
					pet.setImage(screenImg);
					pet.readPetInfo();
					/*monitor.screenImg=(screenImg);
					if(petHit||shipHit){
						defence.runtoCorner();
						defence.speedDroneConfig();
						pet.stopPet();
						defence.jumpHome3sec();
						fleeing=true;
						if(petHit){
							pet.gardMode();
						}
					}else{
						
						petHit=monitor.pet();
						shipHit=monitor.ship();
					}*/
					
				}
		    }, 0, 1);
		
	}

	public boolean isFleeing() {
		return fleeing;
	}

}
