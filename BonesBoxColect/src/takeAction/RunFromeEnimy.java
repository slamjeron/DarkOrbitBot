package takeAction;

import seeingComputer.FlytoLocation;
<<<<<<< HEAD
import seeingComputer.ShipStatus;
import seeingComputer.StaticInfo;
=======
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
import seeingComputer.mapinfo;

import java.awt.Point;
import java.util.Arrays;
import java.util.Collections;

public class RunFromeEnimy {
	private CursorControl robUI;
	private FlytoLocation flylocate;
<<<<<<< HEAD
	private Point shipPoint;
	private Point mapPnt;
	private Point leftCenterGate;
	private Point rightTopGate;
	private Point rightBotomGate;
	private mapinfo stc;
	private int lm=0;
	private int kl=0;
	public RunFromeEnimy(CursorControl robUI, mapinfo map, FlytoLocation flylocate) {
		this.robUI = robUI;
		this.stc=map;
		this.flylocate=flylocate;
	}

	public void run(){
	
	}
	Point rdirect = leftCenterGate;
	private Point gp=new Point();
	private int wate;
	private boolean run=false;
	private boolean atgate;
	public void setShipPoint(Point shipPoint) {
		if(lm==0){
		int leftCdist = findHipotinus(shipPoint,leftCenterGate);
		int rTdist = findHipotinus(shipPoint,rightTopGate);
		int rBdist = findHipotinus(shipPoint,rightBotomGate);
		 int largest = Collections.max(Arrays.asList(leftCdist, rTdist, rBdist));
		if(largest==leftCdist){
			 rdirect = calkgateovershoot(leftCenterGate,shipPoint);
			 gp=leftCenterGate;
			 
		}
		if(largest==rTdist){
			 rdirect = calkgateovershoot(rightTopGate,shipPoint);
			gp=rightTopGate;
		}
		if(largest==rBdist){
			 rdirect = calkgateovershoot(rightBotomGate,shipPoint);
			 gp=rightBotomGate;
		}
		robUI.rightclick(rdirect);
		lm=1;
		}
		if(lm==1){
			//System.out.println(lm);
			if(!(shipPoint.x>gp.x+5||shipPoint.x<gp.x-5)){
				if(kl==5){
					robUI.type("j");
					System.out.println("out bounds");
				}
				if(kl>29){
					kl=1;
					
				}
				travelto1_8();
				
				kl++;
			}else{
				run1_4();
			}
		}
		
	}
	private void travelto1_8() {
		// TODO Auto-generated method stub
		
	}
=======
	private Point mapPnt;
	private Point leftCenterGate;
	public RunFromeEnimy(CursorControl robUI, mapinfo map, FlytoLocation flylocate) {
		this.robUI = robUI;
		this.flylocate=flylocate;
	}

	
	Point rdirect = leftCenterGate;
	private int wate;
	
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
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
<<<<<<< HEAD
			if(rnum==2){
				rnum=0;
			mnum+=2;
			}
			System.out.println(mnum);
=======
			if(rnum==3){
				rnum=0;
			mnum+=2;
			}
			//System.out.println(mnum);
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
			moving=true;
		}else{
			if(moving){
			resetRuning();
			System.out.println("done traveling");
			moving=false;
			}
		}
	}
<<<<<<< HEAD
=======
	
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
	public void resetRuning(){
		travel4_2=false;
		travel4_1=false;
		rnum=0;
		mnum=0;
		wate=0;
<<<<<<< HEAD
		System.out.println("reseting");
	}
	public int mnum=0;
	private int rnum=0;
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
=======
		stall=0;
		stl=0;
		System.out.println("reseting");
	}
	Point runpnt=new Point();
	private int stall;
	private int stl;
	public boolean nothear;
	public void run4_1(Point shipPoint){
		Point[] furthistpoint= {new Point(10,6),new Point(350,11),new Point(350,210),new Point(17,210)};
		
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
			if(stl==10||stl==20||stl==5){
				robUI.keepToolActive(8);
				robUI.keepToolActive(0);
			}
			if(stl>25){
				if(nothear){
				robUI.keepToolActive(9);
				}
				stl=0;
			}
			stl++;
			//System.out.println(stall);
			if(stall>320){
			stall=0;
			}
			stall++;
		}
		 
	}
	public Point mpPlesPnt(Point p){
		return new Point(mapPnt.x+p.x,mapPnt.y+p.y);
	}
	public int mnum=0;
	public int rnum=0;
	public boolean movingc;
	
	public boolean moveTPnt(Point mpnt){
		Point mpnt1 = new Point(mapPnt.x+mpnt.x,mapPnt.y+mpnt.y);
		if(!flylocate.plocate(mpnt1)){
			if(!moving){
		if(wate==8){
			robUI.rightclick(mpnt1);
		}
		if(wate>30){
			wate=0;
		}
			wate++;
			}
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
		}else{
			return true;
		}
		return false;
			
	}
	private void jumpgate(Point p,Point p2){
		Point jpnt=new Point(mapPnt.x+p.x,mapPnt.y+p.y);
		Point dpnt = new Point(mapPnt.x+p2.x,mapPnt.y+p2.y);
		if(rnum==0){
<<<<<<< HEAD
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
=======
			robUI.rightclick(jpnt);
			rnum++;
		}
		if(rnum==1){
		if(flylocate.plocate(jpnt)){
			rnum++;
			wate=0;
			//System.out.println(rnum);
		}else{
			if(!movingc){
			if(wate==7){
				robUI.rightclick(jpnt);
			}
			if(wate>30){
				wate=0;
			}
			}
				wate++;
		}
		}
		if(rnum==2){
			if(flylocate.plocate(dpnt)){
				rnum++;
				wate=0;
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
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
<<<<<<< HEAD
	private void run1_4(){
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
	private Point calkgateovershoot(Point gatepoint, Point shipPoint){
=======
	/*private Point calkgateovershoot(Point gatepoint, Point shipPoint){
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
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
<<<<<<< HEAD
	
	private Point pcompToP(Point p, Point p1){
		int x = p.x- p1.x;
		int y=p.y- p1.y;
		
			
		
		
			
		
		
		return new Point(x,y);
	}
=======
	*/
	/*private Point pcompToP(Point p, Point p1){
		int x = p.x- p1.x;
		int y=p.y- p1.y;
		return new Point(x,y);
	}*/
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
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
<<<<<<< HEAD
		rightTopGate = new Point(mapPnt.x+314,mapPnt.y+33);
		rightBotomGate = new Point(mapPnt.x+314,mapPnt.y+191);
	}

	public boolean isRun() {
		return run;
	}

	public void setRun(boolean run) {
		this.run = run;
=======
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
	}
}
