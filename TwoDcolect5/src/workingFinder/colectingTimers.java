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
	st=!st;
	if(st){
	mObjects.search();
	//mObjects.cargo.cbox.mouse.moveCursor(mObjects.shipPet.mapPoint);
	mObjects.cargo.findCargo1();
	Mouse mouse = mObjects.cargo.cbox.mouse;
	ShipStatus shipstat = new ShipStatus(mObjects.imgcon,mouse);
	Colorlogic clogic = mObjects.imgcon.clogic;
	mObjects.cargo.reset();
	GateJumper gj=new 
			GateJumper(mObjects.mappnt,mouse,clogic);
	 //gj.reset();
	 moving = mObjects.shipPet.moving();
	
	if(fst){
		timer.scheduleAtFixedRate (
			    new TimerTask() {
			    	private void reset(int mapnum){
			    		//controls what happens when we die and arrive at 1-1
			    		
			    		redy=(to1_4&&mapnum==1&&min<maxtime);
			    		
			    		if(mapnum!=0&&!moving){
			    			boolean on1_1 = mObjects.shipPet.on1_1();
			    			if(on1_1){
			    				
			    				
			    				to1_4=true;
			    				gj.reset();
			    				mapnum=0;
			    			}
			    			shipDed=shipstat.shipDead();
			    			lblDeathCount.setText("Death Count = "+shipstat.getDeathCount());
			    		}
			    		if (to1_4){
			    			int max = gj.from1_1To4_1.length;
			    			if(mapnum>max-1)to1_4=false;
			    			if(!redy){
			    				mObjects.cargo.pet.stop();
			    				gj.setMoving(moving);
			    				gj.travel(gj.from1_1To4_1);
			    			}
			    		}
			    	}
					@Override
					public void run() {
						if(st){
							moving = mObjects.shipPet.moving();
							int mapnum = gj.getMapNumber();
							mObjects.cargo.pet.moniter();
							reset(mapnum);
							
						}
					}
			    }, 0, 1);
		
	timer1.scheduleAtFixedRate (
		    new TimerTask() {
				private PrintStream out=System.out;
				private int cnt=0;
		    	private void colect(){
					if(redy){
						mObjects.cargo.findCargo();
						mObjects.cargo.travel.onMap2=true;
						
					}else{
						if(!to1_4){
			    			mObjects.cargo.findCargo();
						min=0;
						}
						mObjects.cargo.travel.onMap2=false;
					}
					lblStallTime.setText("Stall time ="+min);
		    	}
				@Override
				public void run() {
					
					if(st){
						if(cnt==9){
							if(to1_4){
							out.println("we should be colecting ="+redy);
							out.println("we are traveling ="+to1_4);
							out.println("stall timer ="+min);
							
							}
							kb.type("7");
						}
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
						out.println("we should be colecting ="+redy);
						out.println("we are traveling ="+to1_4);
						out.println("stall timer ="+min);
						}
						mObjects.cargo.findBonesBoxes();
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
