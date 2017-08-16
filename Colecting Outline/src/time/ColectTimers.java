package time;

import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;
import checkStats.DefenceManuvers;
import checkStats.PetActions;
import checkStats.ShipMonitor;
import keyMouse.Keyboard;
import keyMouse.Mouse;
import keyMouse.ToolBar;
import objectFinder.GamePanels.panelPoints;
import objectFinder.ImgRobot;

public class ColectTimers {
	
	private boolean fleeing;
	public panelPoints panels;
	private Timer timer=new Timer();
	public ImgRobot imgR;
	ToolBar tool = new ToolBar();
	public Mouse mouse=new Mouse();
	private Keyboard keyB=new Keyboard();
	private PetActions pet=new PetActions();
	private ShipMonitor ship=new ShipMonitor();
	private BufferedImage screenImg;
	private int hun=0;
	private int shipSpeed=0;
	public boolean timerEnable=false;
	private Timer timeKeeper;
	public void setPetTools(){
		pet=new PetActions();
		pet.setPanelPnt(panels.pet);
		pet.imgR=imgR;
		pet.mouse=mouse;
		pet.keyB=keyB;
		
		
		
		//mouse.rightclick(mouse.centerpt);
		
	}
	public void setToolbar(){
		tool.keyB=keyB;
		tool.imgRead=this.imgR.clogic;
		tool.pnt=panels.toolBar;
		tool.findItems(screenImg);
	}
	public void setShipTools(){
		ship= new ShipMonitor();
		ship.setPanelPnt((panels.ship));
		ship.imgR=imgR;
		ship.mouse=mouse;
		ship.setSetImage(screenImg);
		shipSpeed=ship.getSpeed();
		System.out.println(shipSpeed);
	}
	public void setUp(){
		screenImg =imgR.image.getScreenImage();
		setPetTools();
		setShipTools();
		mouse.moveCursor(panels.toolBar);
	}
	public void start() {
		
		timer=new Timer();
		timeKeeper=new Timer();
		//System.out.println(shipSpeed);
		timer.scheduleAtFixedRate (
				new TimerTask() {

				private boolean petHit;
				private boolean shipHit;

				public void run() {
					if(timerEnable){
					screenImg=imgR.image.getScreenImage();
					pet.setImage(screenImg);
					pet.readInfo();
					ship.setSetImage(screenImg);
					ship.readInfo();
					if(petHit||shipHit){
						//defence.runtoCorner();
						//defence.speedDroneConfig();
						pet.stopPet();
						//defence.jumpHome3sec();
						fleeing=true;
						if(petHit){
							pet.stGardMode();
						}
					}else{
						
						//pet.startPet();
						//pet.findCBItems();
						//pet.stAutoCargo();
						//petHit=pet.isAtaked();
						//shipHit=ship.isAtaked();
						//pet.rep();
					}
					}else{
					         timer.cancel();
					         timer.purge();
					         return;
					}
				}
		    }, 0, 3);
		timeKeeper.scheduleAtFixedRate (
				new TimerTask() {

				public void run() {
					if(timerEnable){
					if(hun%1000==0){
						int sec=hun/1000;
						if(sec%60==0){
						int min=sec/60;
						//System.out.println(min);
						}
						//System.out.println(sec);
					}
					
					hun++;
					
					}else{
						timeKeeper.cancel();
						timeKeeper.purge();
					         return;
					}
				}
		    }, 0, 3);
		//pet.findCBItems();
	}

	public boolean isFleeing() {
		return fleeing;
	}

}
