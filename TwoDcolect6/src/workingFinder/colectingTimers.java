package workingFinder;

import java.io.PrintStream;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

import mapControls.GateJumper;
import seeingComputer.MainObjects;
import seeingComputer.ShipStatus;
import userControls.Colorlogic;
import userControls.Keyboard;
import userControls.Mouse;

public class colectingTimers {
	private Timer timer= new Timer(), timer1= new Timer()
			,timer2= new Timer(),timer3= new Timer();
	public MainObjects mObjects=new MainObjects();
	private boolean st=false;
	private boolean fst=true;
	private boolean moving;
	private boolean to1_4 = false;
	private boolean shipDed = false;
	private int index=0;
	public void setIndex(int i){
	index=i;
	}
	private int min=0;
	private int maxtime=5;
	public void setWTime(){
		min=maxtime+20;
	}
	private boolean redy;
	public JLabel lblDeathCount = new JLabel("Death Count=");
	public JLabel lblStallTime = new JLabel("Stall time =");
	Keyboard kb=new Keyboard();
public void colect(){
	
	 int centery = mObjects.imgcon.image.centerpt.y;
	 int centerx = mObjects.imgcon.image.centerpt.x;
	mObjects.cargo.cbox.rightclick(centerx,centery);
	if(!st){
		st=!st;
	mObjects.search();
	mObjects.cargo.findCargo1();
	Mouse mouse = mObjects.cargo.cbox.mouse;
	ShipStatus shipstat = new ShipStatus(mObjects.imgcon,mouse);
	Colorlogic clogic = mObjects.imgcon.clogic;
	mObjects.cargo.reset();
	//gj.reset();
	 moving = mObjects.shipPet.moving();
	
	 
	 
	if(fst){
		
		
	timer1.scheduleAtFixedRate (
		    new TimerTask() {
		    	
				@Override
				public void run() {
					
					if(st){
						moving=mObjects.cargo.shipPet.moving();
					}
				}
		    }, 0, 1);
	
	timer3.scheduleAtFixedRate (
		    new TimerTask() {
		    	private PrintStream out=System.out;
				private int mili, sec;
				private int traveltm=0;
				public boolean shipFlewPastItem(int dist) {
					return fst;
				}
				@Override
				public void run() {
					
					if(st){
						if(sec>60){
							min++;
							sec=0;
						}
						if(mili>1000){
							sec++;
							mili=0;
						}else{
							mili++;
						}
						if(moving){
							traveltm++;
							lblDeathCount.setText
							("travel time = "+traveltm);
						}else{
							traveltm=0;
						}
						
					}
				}
		    }, 0, 1);
	
	fst=false;
	}
	
	}
}

}
