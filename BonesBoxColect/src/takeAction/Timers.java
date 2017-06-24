package takeAction;

import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

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
	public void startSeeing(){
		stc.search();
		shipPoint=stc.map.keapshipLock();
		colect.colect(shipPoint,searcharea);
		colect.stmove();
		mapPnt=stc.map.getMappnt();
		runf.setMapPnt(mapPnt);
		travel.seeAthome();
		stop=false;
		longwate=0;
		//System.out.println(stc.flylocate.on1_1());

		 
		//begin=false;
		if(begin){
			//stc.petSt.petColecting();
		timer.scheduleAtFixedRate (
			    new TimerTask() {
					public void run() {
						if(!stop){
						if(!shipHit&&!petneadReper){
						travel.flytoPvp();
						}
						travel.seeAthome();
						if(travel.onHomescreen){
							if(run){
							runf.resetRuning();
							}
							run=false;
						}
						colectingsetup();
						
						if(!run&&!travel.traveling
								&&!travel.onHomescreen){
							
						bonesBox.findBonesBox(5, 20);
						bonesBox.Cargoonship(1, 1);
						bclick=bonesBox.click;
						shipPoint=stc.map.keapshipLock();
						if(bclick){
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
					private int nm=0;
					public void run() {
						if(!stop){
						stc.petSt.petmoniter();
						if(!run&&!travel.traveling&&!travel.onHomescreen){
						if(!bonesBox.cargoFound){
							colect.colect(shipPoint,searcharea);
							
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
				public void run() {
					if(!stop){
						lblShipHit.setText("ship hit = " +shipHit);
						lblPetNotRepared.setText("pet need repared = "+petneadReper);
						 lblOnMap.setText("on home screen = "+travel.onHomescreen);
						 lblAbleToTravel.setText("able to travel = "+(!shipHit&&!petneadReper&&travel.onHomescreen));
						 lblRedyToRun.setText("redy to run = "+ run);
						 lblWateTime.setText("wate time= "+ longwate);
						 if(longwate>6000){
							 stop=true;
						 }
						 longwate++;
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
						}
						if(tl>100){
							tl=2;
						}
						if(tl==0){
							
							//System.out.println("died "+"time");
						}
						tl++;
					}else{
						tl=0;
					}
					shipHit = stc.shipstat.shipHit();
					if(!travel.onHomescreen){
						
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
					shipPoint=stc.map.keapshipLock();
					//System.out.println(runf.isRun());
					
			
		        	}
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
