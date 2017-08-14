package time;

import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;
import checkStats.DefenceManuvers;
import checkStats.PetActions;
import checkStats.ShipMonitor;
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
	private ShipMonitor ship;
	private BufferedImage screenImg;
	private int shipSpeed;
	public void setPetTools(){
		pet=new PetActions();
		pet.setPanelPnt(panels.pet);
		pet.imgR=imgR;
		pet.mouse=mouse;
		pet.keyB=keyB;
	}
	public void setShipTools(){
		ship= new ShipMonitor();
		ship.setPanelPnt((panels.ship));
		ship.imgR=imgR;
		ship.mouse=mouse;
	}
	public void start() {
		setPetTools();
		setShipTools();
		screenImg =imgR.image.getScreenImage();
		//ship.setSetImage(screenImg);
		//shipSpeed=ship.getSpeed();
		//System.out.println(shipSpeed);
		timer.scheduleAtFixedRate (
				new TimerTask() {
				
				
				public void run() {
					
					screenImg=imgR.image.getScreenImage();
					pet.setImage(screenImg);
					pet.readInfo();
					ship.setSetImage(screenImg);
					ship.readInfo();
					/*if(petHit||shipHit){
						defence.runtoCorner();
						defence.speedDroneConfig();
						pet.stopPet();
						defence.jumpHome3sec();
						fleeing=true;
						if(petHit){
							pet.gardMode();
						}
					}else{
						
						
						//pet.isPetAtaked();
						//shipHit=ship.isShipAtaked();
					}*/
					
				}
		    }, 0, 3);
		
	}

	public boolean isFleeing() {
		return fleeing;
	}

}
