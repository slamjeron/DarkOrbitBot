package workingFinder;

import java.io.PrintStream;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

import mapControls.GateJumper;
import seeingComputer.MainObjects;
import seeingComputer.ShipStatus;
import userControls.Colorlogic;
import userControls.Mouse;

public class colectingTimers {
	protected Timer timer= new Timer();
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
	private int wTime=0;
	private int maxtime=4000;
	public void setWTime(){
		wTime=maxtime+20;
	}
	private boolean redy;
	public JLabel lblDeathCount = new JLabel("Death Count=");
	public JLabel lblStallTime = new JLabel("Stall time =");
	
public void colect(){
	st=!st;
	if(st){
	mObjects.search();
	//mObjects.cargo.cbox.mouse.moveCursor(mObjects.shipPet.mapPoint);
	mObjects.cargo.findCargo1();
	//mObjects.cargo.cbox.findBonesBox3(true,mObjects.cargo.travel.dir);
	Mouse mouse = mObjects.cargo.cbox.mouse;
	ShipStatus shipstat = new ShipStatus(mObjects.imgcon,mouse);
	Colorlogic clogic = mObjects.imgcon.clogic;
	mObjects.cargo.reset();
	GateJumper gj=new 
			GateJumper(mObjects.mappnt,mouse,clogic);
	 //gj.reset();
	 moving = mObjects.shipPet.moving();
	
	if(fst){
		wTime=maxtime+20;
		timer.scheduleAtFixedRate (
			    new TimerTask() {
			    	private void reset(int mapnum){
			    		//controls what happens when we die and arrive at 1-1
			    		redy=(to1_4&&mapnum!=1||wTime>maxtime);
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
			    			if(redy){
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
		
	timer.scheduleAtFixedRate (
		
		    new TimerTask() {
				private PrintStream out=System.out;
		    	private void colect(){
		    		if(!to1_4&&!shipDed&&!fst){
		    			//out.println(index);
		    			mObjects.cargo.findCargo();
					wTime=0;
					}
					if(redy){
						mObjects.cargo.findCargo();
						mObjects.cargo.travel.onMap2=true;
						
					}else{
						mObjects.cargo.travel.onMap2=false;
					}
					lblStallTime.setText("Stall time ="+wTime);
		    	}
				@Override
				public void run() {
					if(st){
						colect();
					}
				}
		    }, 0, 1);
	fst=false;
	}
	
	}
}
public void colect2(){
	mObjects.search();
	mObjects.cargo.cbox.mouse.moveCursor(mObjects.shipPet.mapPoint);
	mObjects.shipPet.moving();
	mObjects.cargo.findCargo1();
	st=!st;
	while(st){
		//mObjects.cargo.findCargo(1);
	}
	
}
public void colectT(){
	mObjects.search();
	mObjects.cargo.findCargo1();
	
}
}
