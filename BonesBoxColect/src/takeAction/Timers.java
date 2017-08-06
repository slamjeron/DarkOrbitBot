package takeAction;

import java.awt.Point;
import java.io.PrintStream;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

import cargoSight.bonesBoxsearch;
import cargoSight.boxes;
import seeingComputer.StaticInfo;

public class Timers {
	private StaticInfo stc=new StaticInfo();
	protected Timer timer= new Timer();
	private boolean begin=true;
	private CursorControl robUI = new CursorControl(stc);
	private NormalColect colect = new NormalColect(robUI,stc);
	public bonesBoxsearch bonesBox = stc.bBColect;
	public boxes box= stc.bBColect2;
	public RunFromeEnimy runf=
			new RunFromeEnimy(robUI,stc.map,stc.flylocate);
	public JLabel lblShipHit = new JLabel("ship hit");
	public JLabel lblPetNotRepared = new JLabel("pet");
	public JLabel lblOnMap = new JLabel("on map #");
	public JLabel lblRedyToRun = new JLabel("redy to run=");
	public JLabel lblAbleToTravel = new JLabel("able to travel");
	private boolean colecting;
	private int lht=0;
	private boolean petneadReper=false;
	private Point shipPoint;
	private boolean bclick=false;
	private boolean shipHit;
	private boolean run=false;
	private Point mapPnt;
	private Travel travel=new Travel(stc.flylocate,runf);
	private boolean stop;
	public int searcharea=0;
	private int longwate=0;
	public JLabel lblWateTime;
	public boolean moving=false;
	public JLabel lblCt;
	public int psh=30;
	public int psw=10;
	private int nm=0;
	public void startSeeing(){
		stc.search();
		shipPoint=stc.map.keapshipLock();
		travel.timeserch=30;
		travel.seeAthome();
		mapPnt=stc.map.getMappnt();
		runf.setMapPnt(mapPnt);
		if(travel.onHomescreen){
			travel.traveling=true;
			//System.out.println("moving to 4-1");
		}
		colect.colectst(shipPoint,searcharea);
		colect.stmove();
		stop=false;
		longwate=0;
		//System.out.println(stc.flylocate.on1_1());
		//begin=false;
		if(begin){
		timer.scheduleAtFixedRate (
			    new TimerTask() {
					private int longsit;
					private boolean mov;
					
					public void run() {
						PrintStream pr = System.out;
						if(!stop){
						if(!shipHit&&!petneadReper){
						travel.flytoPvp();
						}
						moving=stc.map.moving();
						runf.movingc=moving;
						travel.seeAthome();
						stc.flylocate.moving=moving;
						if(travel.onHomescreen){
							if(run){
							runf.resetRuning();
							}
							run=false;
						}
						
						colectingsetup();
						
						if(redytoColect()){
							lblCt.setText("ct ="+bonesBox.getCt()+
									"cargoNotClose ="+bonesBox.getCargoNotClose()+"losit ="+longsit);
						
						bclick=bonesBox.click;
						shipPoint=stc.map.keapshipLock();
						robUI.keepToolActive(0);
						robUI.keepToolActive(7);
						if(moving){
							longsit=0;
						}else{
							if(longsit>3){
								colect.stmove();
								longsit=0;
							}
							longsit++;
						}
						if(bclick){
							longsit=0;
							longwate=0;
							robUI.rightclick(bonesBox.clickpoint);
							bonesBox.click=false;
						}
						colecting=true;
						}else{
							colecting=false;
							if(run){
							runf.run4_1(shipPoint);
							}
							
						}
						}
			        	}}, 0, 1);
		timer.scheduleAtFixedRate (
			    new TimerTask() {
					
					public void run() {
						if(!stop){
						stc.petSt.petmoniter();
						if(redytoColect()){
						if(!bonesBox.cargoFound){
							colect.colect(shipPoint,searcharea);
							if(nm==5){
								if(!moving){
								colect.hmove();
								}
							}
							if(nm==14){
								colect.stmove();
							}
							if(moving){
							if(nm==180){
								colect.stmove();
							}
							if(nm==260){
								colect.stmove();
							}
							}
							nm++;
						}else{
							nm=0;
						}
						}
						}
					}}, 0, 1);
		
		timer.scheduleAtFixedRate (
			new TimerTask() {
				private int tl;
				private int rnum;
				private boolean resetwate;
				private void keepPetColect(){
					 if(runf.rnum==1){
						 resetwate=true;
					 }else{
						if(resetwate){
							longwate=0;
							resetwate=false;
						}
					 }
					 if(longwate>10000){
						 stop=true;
					 }
					 if(longwate==4000||longwate==6000
							 ||longwate==8000){
						 
						 stc.search();
						 colecting=true;
						 if(stc.mapf&&stc.petstf&&
								 stc.toolBarF&&stc.shipstf){
							mapPnt=stc.map.getMappnt();
							runf.setMapPnt(mapPnt);
							colect.stmove();
					 run=false;
						runf.resetRuning();
						 }else{
							 run=false;
							runf.resetRuning();
							 stop=true;
						 }
						 }
					
					 longwate++;
				}
				private void defenceP4_1(){
					 if(colecting){
							colect.startPet();
							colect.keepPetColoecting();
							}else{
								if(!travel.onHomescreen){
								colect.stopPet();
								}
							}
							if(stc.shipstat.shipDead()){
								
								if(tl==4){
									robUI.rightclick(stc.shipstat.repbtn);
									travel.onHomescreen=true;
								}
								if(tl>100){
									
									tl=2;
								}
								tl++;
							}else{
								tl=0;
							}
							shipHit = stc.shipstat.shipHit();
							if(!travel.onHomescreen){
								if(stc.toolbar.toolredy(9)&&runf.nothear){
							boolean petHit=stc.petSt.petLesSH;
							if(shipHit&&stc.shipstat.enimyonscreen()){
							run=true;
							colecting=false;
							}
							
							if(petHit){
								petneadReper=true;
								run=true;
								colecting=false;
							}
								}
							}
				}
				private void setlbls(){
					lblPetNotRepared.setText("pet need repared = "+petneadReper);
					 lblOnMap.setText("on home screen = "+travel.onHomescreen);
					 lblAbleToTravel.setText("able to travel = "+(!shipHit&&!petneadReper&&travel.onHomescreen));
					 lblRedyToRun.setText("redy to run = "+ run);
					 lblWateTime.setText("wate time= "+ longwate);
					
				}
				public void run() {
					lblShipHit.setText("ship hit = " +shipHit+" stop ="+ stop);
					if(!stop){
						//lblShipHit.setText("ship hit = " +shipHit);
						setlbls();
						 keepPetColect();
						 defenceP4_1();
					shipPoint=stc.map.keapshipLock();
					//System.out.println(runf.isRun());
		        	}
					}
				}, 0, 1);
		begin=false;
		//shipPoint=stc.map.keapshipLock();
		}
		
	}
	
	private void colectingsetup(){
		shipPoint=stc.map.keapshipLock();
		if(travel.onHomescreen){
			if(petneadReper){
			colect.startPet();
			keepRepPet();
			}else{
				colect.stopPet();
			}
			robUI.keepToolActive(6);
			robUI.keepToolActive(7);
		}
		
		
	}
	public void stopPet() {
		// TODO Auto-generated method stub
		stop=true;
		run=false;
		runf.resetRuning();
		
		/*if(stc.petSt.petup){
			if(n==1){
			robUI.rightclick(stc.petSt.petControlPoints[0]);
			}
			if(n>20){
				n=0;
			}
			System.out.println(n);
			n++;
		}*/
	}
	private boolean redytoColect(){
		return !run&&!travel.traveling&&!travel.onHomescreen;
	}
	private void keepRepPet(){
		
		if(stc.petSt.petup&&stc.petSt.petLesHP&&stc.petSt.petLesSH){
			if(lht>7){
			if(lht==9){
				robUI.rightclick(stc.petSt.petControlPoints[1]);
				}
			if(lht>14){
				if(stc.petSt.dropdownShown()){
					robUI.rightclick(stc.petSt.petControlPoints[3]);
					
				}
				}
			if(lht>90){
				lht=6;
				}
				}
			lht++;
			}else{
			if(stc.petSt.petup){
			petneadReper=false;
			lht=0;
			}
			}
		}
	
}
