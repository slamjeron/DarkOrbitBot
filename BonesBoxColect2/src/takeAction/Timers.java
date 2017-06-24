package takeAction;

import java.awt.Point;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import cargoSight.bonesBoxsearch;
import seeingComputer.StaticInfo;

public class Timers {
	private StaticInfo stc=new StaticInfo();
	protected Timer timer= new Timer();
	private boolean begin=true;
	private CursorControl robUI = new CursorControl(stc);
	private NormalColect colect = new NormalColect(robUI,stc);
	public bonesBoxsearch bonesBox = new bonesBoxsearch();
	public RunFromeEnimy runf=
			new RunFromeEnimy(robUI,stc.map,stc.flylocate);
	private boolean colecting;
	private int lht;
	private boolean petshotat;
	private boolean on1_1;
	private boolean runing;
	private Point shipPoint;
	private boolean bclick=false;
	private boolean shipHit=false;
	private boolean run=false;
	private Point mapPnt;
	private Travel travel=new Travel(stc.flylocate,runf);
	private boolean start;
	public void startSeeing(){
		stc.search();
		shipPoint=stc.map.keapshipLock();
		colect.colect(shipPoint);
		colect.stmove();
		mapPnt=stc.map.getMappnt();
		runf.setMapPnt(mapPnt);
		travel.seeAthome();
		runf.resetRuning();
		stc.shipstat.enimyonscreen();
		run=false;
		start=true;
		//System.out.println(travel.onHomescreen);
		//stc.imgcon.scipMap(22,22);
		//begin=false;
		if(begin){
			//stc.petSt.petColecting();
		timer.scheduleAtFixedRate (
			    new TimerTask() {
					

					public void run() {
						if(start){
						if(!shipHit){
						travel.flytoPvp();
						}
						
						travel.seeAthome();
						if(travel.onHomescreen){
							run=false;
							runf.setRun(false);
						}
						
						if(!run&&!travel.traveling&&
								!travel.onHomescreen){
						colectingsetup();
						bonesBox.findBonesBox(5, 20);
						bonesBox.Cargoonship(1, 1);
						bclick=bonesBox.click;
						shipPoint=stc.map.keapshipLock();
						if(bclick){
							robUI.rightclick(bonesBox.clickpoint);
							bonesBox.click=false;
						}
						colecting=true;
						}else{
							colecting=false;
							if(run){
							runf.setShipPoint(shipPoint);
							}
							
						}
						}
			        	}}, 0, 1);
		timer.scheduleAtFixedRate (
			    new TimerTask() {
					private int nm=0;
					
					public void run() {
						if(start){
						stc.petSt.petmoniter();
						if(!run&&!travel.traveling&&!travel.onHomescreen){
						if(!bonesBox.cargoFound){
							colect.colect(shipPoint);
							
						
					
							if(nm==5){
								colect.hmove();
							}
							if(nm==14){
								colect.stmove();
							}
							if(nm!=20){
							nm++;
							}
						
						}else{
							nm=0;
						}
						}
						}
					}}, 0, 1);
		
			timer.scheduleAtFixedRate (
			new TimerTask() {
				private int tl;
				private int dn;
				
				

				public void run() {
					if(start){
					if(colecting){
					colect.startPet();
					colect.keepPetColoecting();
					}else{
						if(!petshotat){
						colect.stopPet();
						}
					}
					if(stc.shipstat.shipDead()){
						if(tl==4){
							robUI.rightclick(stc.shipstat.repbtn);
						}
						if(tl>100){
							tl=2;
						}
						if(tl==0){
							dn++;
							
						}
						tl++;
					}else{
						tl=0;
					}
					 shipHit = stc.shipstat.shipHit();
					if(!travel.onHomescreen&&!travel.traveling){
					
					
					boolean petHit=stc.petSt.petLesSH;
					if(shipHit&&stc.shipstat.enimyonscreen()||petHit){
					runf.setRun(true);
					
					}
					shipPoint=stc.map.keapshipLock();
					//System.out.println(runf.isRun());
					run=runf.isRun();
			if(run){
				//runf.setShipPoint(shipPoint);
				runf.run4_1(shipPoint);
			}
		        	}
					}
				}
				}, 0, 1);
		begin=false;
		
		//shipPoint=stc.map.keapshipLock();
		
		
		
		
		}
		
	}
	public void testruning(){
		stc.search();
		shipPoint=stc.map.keapshipLock();
		colect.colect(shipPoint);
		colect.stmove();
		mapPnt=stc.map.getMappnt();
		runf.setMapPnt(mapPnt);
		travel.seeAthome();
		//System.out.println(travel.onHomescreen);
		runf.setRun(true);
		//robUI.moveCursor(runf.mpPlesPnt(runf.cjumpgate2[2][0]));
		
		if(begin){
			//stc.petSt.petColecting();
			timer.scheduleAtFixedRate (
			new TimerTask() {
				public void run() {
					shipPoint=stc.map.keapshipLock();
					runf.run4_1(shipPoint);
				}}, 0, 1);
		begin=false;
		
		//shipPoint=stc.map.keapshipLock();
		
		
		
		
		}
		
	}
	
	private void colectingsetup(){
		shipPoint=stc.map.keapshipLock();
		if(on1_1){
			if(petshotat){
			colect.startPet();
			keepRepPet();
			}else{
			stopPet();
			}
		}else{
			if(runing){
				System.out.println("trinng to run");
			runAway();
			}else{
		colect.colect(shipPoint);
			}
		}
		
		
	}
	
	private void runAway() {
		
	}
	public void stopPet() {
		// TODO Auto-generated method stub
		stc.search();
		stc.map.findgates();
		start=false;
		
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
	
	private void keepRepPet(){
		if(stc.petSt.petLesSH){
			petshotat=true;
			runing=true;
		}
		if(stc.petSt.petup&&stc.petSt.petLesHP){
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
			
			petshotat=false;
			runing=false;
			lht=0;
			}
		}
	
}
