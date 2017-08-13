package workingFinder;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.PrintStream;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

import mapControls.GateJumper;
import seeingComputer.MainObjects;
import seeingComputer.ShipStatus;
import shairing.ShairInfo;
import userControls.Colorlogic;
import userControls.Keyboard;
import userControls.Mouse;

public class colectingTimers {
	private Timer timer= new Timer(), timer1= new Timer()
			,timer2= new Timer(),timer3= new Timer();
	public ShairInfo shair=new ShairInfo();
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
	st=!st;
	if(st){
	shair.setObjectLocations();
	//mObjects.cargo.cbox.mouse.moveCursor(mObjects.shipPet.mapPoint);
	shair.cargo.findCargo1();
	shair.cargo.reset();
	

	//shair.petSt.petmoniter();
	 //shair.cargo.pet.start();
	 //shair.cargo.pet.colect();
	 shair.cargo.findCargo();
	
	if(fst){
		timer.scheduleAtFixedRate (
			    new TimerTask() {
			    	
					@Override
					public void run() {
						if(st){
							shair.cargo.pet.moniter();
							
						}
					}
			    }, 0, 1);
		
	timer1.scheduleAtFixedRate (
		    new TimerTask() {
				private PrintStream out=System.out;
				private int cnt=0;
		    	private void colect(){
						if(!to1_4){
							
			    			shair.cargo.findCargo();
			    			
						min=0;
						}
					
		    	}
				@Override
				public void run() {
					
						
					if(st){
						
						if(cnt>500){
							cnt=0;
						}
						//out.println(cnt);
						cnt++;
						colect();
					}
					
				}
		    }, 0, 1);
	timer2.scheduleAtFixedRate (
		    new TimerTask() {
				
				@Override
				public void run() {
					
					if(st){
						
					}
				}
		    }, 0, 1);
	timer3.scheduleAtFixedRate (
		    new TimerTask() {
		    	private PrintStream out=System.out;
				private int mili, sec;
				@Override
				public void run() {
					
					if(st){
						if(redy){
							if(mili>1000){
								sec++;
								mili=0;
							}
							if(sec==60){
								min++;
								sec=0;
							}
							mili++;
						
						}
						shair.cargo.findBonesBoxes();
					}
				}
		    }, 0, 1);
	
	fst=false;
	}
	
	}
}

public void setStallTime(int value) {
	// TODO Auto-generated method stub
	maxtime=value;
	System.out.println(maxtime);
}
}
