package takeAction;

import seeingComputer.FlytoLocation;
import seeingComputer.ShipStatus;
import seeingComputer.StaticInfo;
import seeingComputer.mapinfo;

import java.awt.List;
import java.awt.Point;
import java.util.Arrays;
import java.util.Collections;

public class RunFromeEnimy {
	private CursorControl robUI;
	private FlytoLocation flylocate;
	private Point shipPoint;
	private Point mapPnt;
	private Point leftCenterGate;
	private Point rightTopGate;
	private Point rightBotomGate;
	private mapinfo map;
	private int lm=0;
	private int kl=0;
	public RunFromeEnimy(CursorControl robUI, mapinfo map, FlytoLocation flylocate) {
		this.robUI = robUI;
		this.map=map;
		this.flylocate=flylocate;
	}

	
	Point rdirect = leftCenterGate;
	private Point gp=new Point();
	private int wate;
	private boolean run=false;
	private boolean on4_1=true;
	private int tm;
	private int gn;
	private boolean on1_4;
	public void setShipPoint(Point shipPoint) {
		if(on4_1){
		if(lm==0){
		int leftCdist = findHipotinus(shipPoint,leftCenterGate);
		int rTdist = findHipotinus(shipPoint,rightTopGate);
		int rBdist = findHipotinus(shipPoint,rightBotomGate);
		 int largest = Collections.max(Arrays.asList(leftCdist, rTdist, rBdist));
		if(largest==leftCdist){
			 rdirect = calkgateovershoot(leftCenterGate,shipPoint);
			 gp=leftCenterGate;
			 gn=0;
			 
		}
		if(largest==rTdist){
			 rdirect = calkgateovershoot(rightTopGate,shipPoint);
			gp=rightTopGate;
			 gn=1;
		}
		if(largest==rBdist){
			 rdirect = calkgateovershoot(rightBotomGate,shipPoint);
			 gp=rightBotomGate;
			 gn=2;
			 
		}
		if(tm==5){
			robUI.rightclick(rdirect);
		}
		if(tm>12){
		robUI.rightclick(rdirect);
		lm=1;
		tm=0;
		}
		tm++;
		}
		if(lm==1){
			
			if(on4_1){
			if(!(shipPoint.x>gp.x+5||shipPoint.x<gp.x-5)){
				if(kl==5){
					robUI.type("j");
					System.out.println("out bounds");
				}
				if(kl>29){
					kl=1;
					
				}
				
				
				kl++;
			}
				
			}
			run4_1test();
			//travelto1_8();
		}
		}
	}

	//corners = 0
	//edges = 1
	//
	public Point[][] cjumpgate2 ={{new Point(39,33),new Point(314,33),
			new Point(314,191),new Point(39,191)},{new Point(172,25),
				new Point(322,100),new Point(172,200),new Point(31,100)},{			
					new Point(181,112),new Point(64,112),new Point(239,11),
					new Point(239,209),new Point(166,112),new Point(188,99),
					new Point(188,121)},{new Point(239,213),new Point(107,110),
						new Point(214,52),new Point(214,172)},
						{new Point(312,56),new Point(52,56),new Point(52,181)
							,new Point(324,55),new Point(308,116),new Point(247,116)
							,new Point(247,137),new Point(300,137),new Point(300,211)
						}};
	public boolean doneTraveling;
	public boolean travel4_1;
	public boolean travel4_2;
	public boolean moving;
	public void travel(int[][] gate){
		int size = gate.length;
		if(mnum<size){
			jumpgate(cjumpgate2[gate[mnum][0]][gate[mnum][1]],
					cjumpgate2[gate[mnum+1][0]][gate[mnum+1][1]]);
			if(rnum==2){
				rnum=0;
			mnum+=2;
			}
			
			moving=true;
		}else{
			if(moving){
			resetRuning();
			
			moving=false;
			}
		}
	}
	public void resetRuning(){
		travel4_2=false;
		travel4_1=false;
		rnum=0;
		mnum=0;
		wate=0;
		System.out.println("reseting");
	}
	public int mnum=0;
	private int rnum=0;
	private boolean on4_2;
	private boolean on4_3;
	public boolean moveTPnt(Point mpnt){
		Point mpnt1 = new Point(mapPnt.x+mpnt.x,mapPnt.y+mpnt.y);
		if(!flylocate.plocate(mpnt1)){
		if(wate==8){
			robUI.rightclick(mpnt1);
		}
		if(wate>300){
			wate=0;
		}
			wate++;
		}else{
			return true;
		}
		return false;
			
	}
	public Point mpPlesPnt(Point p){
		return new Point(mapPnt.x+p.x,mapPnt.y+p.y);
	}
	Point[] furthistpoint= {new Point(10,6),new Point(350,11),new Point(350,210),new Point(17,210)};
	private int stall;

	private void jumpgate(Point p,Point p2){
		
		Point jpnt=mpPlesPnt(p);
		Point dpnt = mpPlesPnt(p2);
		 
		if(rnum==0){
		if(flylocate.plocate(jpnt)){
			rnum=1;
			wate=0;
			//System.out.println(rnum);
		}else{
			if(wate==8){
				robUI.rightclick(jpnt);
			}
			if(wate>300){
				wate=0;
			}
				wate++;
		}
		}
		if(rnum==1){
			if(flylocate.plocate(dpnt)){
				rnum=2;
				wate=0;
				robUI.moveCursor(dpnt);
			}else{
				if(flylocate.plocate(jpnt)){
				if(wate==10){
					robUI.type("j");
				}
				if(wate>70){
					wate=0;
				}
					wate++;
					//System.out.println(wate);
				}
			}
		}
	}
	Point runpnt=new Point();
	private int stalln;
	public void run4_1(Point shipPoint){
		
		if(rnum==0){
		int[] e = new int[4];
		
		
		int i=0;
		 for(Point p:furthistpoint){
			e[i]=findHipotinus(shipPoint,mpPlesPnt(p));
			
			i++;
		}
		 int largest = Collections.max(Arrays.asList(e[0], e[1], e[2],e[3]));
		 System.out.println(largest);
		 for(int l=0;l<4;l++){
			System.out.println(e[l]);
			if(largest==e[l]){
				runpnt= furthistpoint[l];
				
				break;
			}
		}
		 
		rnum=1;
		}
		if(rnum==1){
			
			if(stall==4){
		 robUI.rightclick(mpPlesPnt(runpnt));
			}
			if(stalln>50){
				
				stalln=0;
			}
			stalln++;
			//System.out.println(stall);
			if(stall>320){
			stall=0;
			}
			stall++;
		}
		 
	}
	private void run4_1test(){
		if(gn>0){
if(flylocate.plocate(mpPlesPnt(cjumpgate2[0][3]))){
			if(gn==2){
				on1_4=false;
				on4_3=true;
			}
			if(gn==1){
				on4_2=true;
				on4_1=false;
				}
		}
		}
		if(gn==0){
		if(flylocate.plocate(new Point(mapPnt.x+322,mapPnt.y+100))){
			
			if(wate>500){
				robUI.type("j");
				wate=0;
				setRun(false);
				lm=0;
				kl=0;
				
			}
			System.out.println(wate);
				wate++;
		}
		}
	}
	private Point calkgateovershoot(Point gatepoint, Point shipPoint){
		Point p1 = pcompToP(gatepoint,shipPoint);
		double m=p1.getY()/p1.getX();
		int x=0;
		if(p1.x<0){
			x= p1.x-22;
		}else{
			x= p1.x+22;
		}
		int y=(int) (x*m);
		
	
		return new Point(shipPoint.x+x,y+shipPoint.y);
		
	}
	
	private Point pcompToP(Point p, Point p1){
		int x = p.x- p1.x;
		int y=p.y- p1.y;
		return new Point(x,y);
	}
	private int findHipotinus(Point p, Point p1){
		int x = p.x- p1.x;
		int y=p.y- p1.y;
		if(x<0){
			x=x*(-1);
		}
		if(y<0){
			y=y*(-1);
		}
		
		return pyththeorem(x,y);
	}
	private int pyththeorem(int hp,int nownleg){
		return (int) Math.sqrt((Math.pow(hp, 2)+Math.pow(nownleg, 2)));
	}

	public void setMapPnt(Point mapPnt) {
		this.mapPnt = mapPnt;
		leftCenterGate = new Point(mapPnt.x+31,mapPnt.y+100);
		rightTopGate = new Point(mapPnt.x+314,mapPnt.y+33);
		rightBotomGate = new Point(mapPnt.x+314,mapPnt.y+191);
	}

	public boolean isRun() {
		return run;
	}

	public void setRun(boolean run) {
		this.run = run;
	}
}
