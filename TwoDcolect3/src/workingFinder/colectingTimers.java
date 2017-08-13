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
	private int wTime=0;
	private int gatnum =0;
	private boolean redy;
	public JLabel lblDeathCount = new JLabel("Death Count=");
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
		wTime=4100;
		
		timer.scheduleAtFixedRate (
			    new TimerTask() {

					@Override
					public void run() {
						if(st){
							moving = mObjects.shipPet.moving();
							int gatnum = gj.getMapNumber();
							mObjects.cargo.pet.moniter();
							redy=(to1_4&&gatnum!=1||wTime>4000);
							if(gatnum!=0&&!moving){
								boolean on1_1 = mObjects.shipPet.on1_1();
									if(on1_1){
										to1_4=true;
										 gj.reset();
										 gatnum=0;
									}
								shipDed=shipstat.shipDead();
								lblDeathCount.setText("Death Count = "+shipstat.getDeathCount());
							}
							if (to1_4){
							int max = gj.from1_1To4_1.length;
							if(gatnum>max-1)to1_4=false;
							if(redy){
								mObjects.cargo.pet.stop();
							gj.setMoving(moving);
							gj.travel(gj.from1_1To4_1);
							}
							}
							
						}
					}
			    }, 0, 1);
		
	timer.scheduleAtFixedRate (
		
		    new TimerTask() {
				private PrintStream out=System.out;

				@Override
				public void run() {
					if(st){
						
						if(!to1_4&&!shipDed&&!fst){mObjects.cargo.findCargo();
						wTime=0;
						}
						if(!redy){
							mObjects.cargo.findCargo();
							wTime++;
						}
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
		mObjects.cargo.findCargo();
	}
	
}
public void colectT(){
	mObjects.search();
	mObjects.cargo.findCargo1();
	
}
}
