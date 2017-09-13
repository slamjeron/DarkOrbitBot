package time;

import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

import checkStats.PetActions;
import checkStats.ShipMonitor;
import keyMouse.BonesBox;
import keyMouse.Keyboard;
import keyMouse.Mouse;
import keyMouse.ToolBar;
import navigator.Navigator;
import navigator.Navigator.DIR;
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
	public boolean top=true;
	private int hun=0;
	private int shipSpeed=0;
	public boolean timerEnable=false;
	private Timer timeKeeper;
	protected BonesBox bNSBX=new BonesBox();
	public JLabel lblBacedetect=new JLabel("enimy has bace =");
	public void setPetTools(){
		pet=new PetActions();
		pet.setPanelPnt(panels.pet);
		pet.imgR=imgR;
		pet.mouse=mouse;
		pet.keyB=keyB;
		
		
		
		//mouse.rightclick(mouse.centerpt);
		
	}
	private Navigator navigate =new Navigator();
	public void setToolbar(){
		tool.keyB=keyB;
		tool.imgRead=this.imgR.clogic;
		tool.pnt=panels.getToolBar();
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
		setToolbar();
		navigate.mouse=mouse;
		navigate.imgreed=imgR.clogic;
		navigate.setMapPNT(panels.map,keyB);
		
		bNSBX.mouse=mouse;
		bNSBX.clgc=imgR.clogic;
		bNSBX.panPnt=panels;
		bNSBX.rects();
		bNSBX.imgmath=imgR.smath;
		bNSBX.img=screenImg;
		bNSBX.findBonesBox3(false, DIR.LEFT);
		navigate.gatejump.reset();
		
		
		
		//mouse.moveCursor(panels.toolBar);
	}
	private Increment inc=new Increment();
	private Increment inc2=new Increment();
	public void start() {
		lblBacedetect.setText("ship speed ="+ship.getSpeed());
		timer=new Timer();
		timeKeeper=new Timer();
		timer.scheduleAtFixedRate (
				new TimerTask() {

				private boolean petHit;
				private boolean shipHit;
				private boolean on1_1;
				private boolean canreset;
				private boolean traveling;
				public void run() {
					if(timerEnable){
					screenImg=imgR.image.getScreenImage();
					navigate.image=screenImg;
					pet.setImage(screenImg);
					pet.readInfo();
					ship.setSetImage(screenImg);
					ship.readInfo();
					boolean moving = navigate.moving();
					navigate.top=top;
					on1_1=navigate.on1_1();
					if(pet.screenChanged){
						ship.shipDead();
					}
					if(on1_1){
						if(canreset)
						navigate.gatejump.reset();
						canreset=false;
						pet.stopPet();
					}else{
						canreset=true;
					}
					if(petHit||shipHit){
						escapeEnimy();
					}else{
						
						if(shipCanColect()){
						if(!bNSBX.found&&!moving){
							navigate.image=screenImg;
							navigate.findShip();
							navigate.withinBounds();
						}
						if(bNSBX.found){
							if(!moving){
								if(inc.increment(3))
									bNSBX.found=false;
							}else{
								if(inc2.increment(20))
									bNSBX.found=false;
							}
						}else{
							bNSBX.img=screenImg;
							bNSBX.findBonesBox3(false, DIR.LEFT);
						}
						tool.actSpeedBst();
						tool.actCloak();
						tool.actHartDC();
						pet.colect();
						petHit=pet.isAtaked();
						shipHit=ship.isAtaked();
						}else{
							if(!moving){
							navigate.gatejump.setMoving(moving);
							navigate.gatejump.travel(navigate.gatejump.from1_1To4_1);
							}
							
						}
					}
					
					}else{
						pet.stpet();
					         timer.cancel();
					         timer.purge();
					         return;
					}
				}



				private boolean shipCanColect() {
					traveling=navigate.gatejump.travleing;
					
					return (!traveling&&!on1_1);
				}



				private void escapeEnimy() {
					if(on1_1){
						fleeing=false;
						shipHit=ship.isAtaked();
						petHit=pet.isAtaked();
						pet.stopPet();
					}else{
						fleeing=true;
					}
					if(fleeing)
						if(inc.increment1(500,2)){
					navigate.findShip();
					navigate.furthistPnt();
					System.out.println("runing");
						}
					tool.actSpeedBst();
					tool.actSpeedDC();
					tool.actUlCloak();
					
					tool.acthomejump();
					pet.stopPet();
					if(petHit)
						pet.stGardMode();
				}
		    }, 0, 3);
		timeKeeper.scheduleAtFixedRate (
				new TimerTask() {

				public void run() {
					if(timerEnable){
						int sec=hun/1000;
						int min = 0;
						int houre=0;
					if(hun%1000==0)
						if(sec%60==0)
							min=sec/60;
					
					
					if(min%60==0){
						  houre = min/60;
						  if(sec==1&&hun==1){
					System.out.print(houre);
						  }
					}
					
					hun++;
					
					}else{
						timeKeeper.cancel();
						timeKeeper.purge();
					         return;
					}
				}
		    }, 0, 3);

	}
	
	public void travelTst(){
		timer=new Timer();
		//timeKeeper=new Timer();
		//System.out.println(shipSpeed);
		timer.scheduleAtFixedRate (
				new TimerTask() {
				public void run() {
					
				}
				}, 0, 3);
	}
	public boolean isFleeing() {
		return fleeing;
	}

}
