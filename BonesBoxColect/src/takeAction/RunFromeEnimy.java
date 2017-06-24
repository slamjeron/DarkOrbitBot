package takeAction;

import seeingComputer.FlytoLocation;
import seeingComputer.mapinfo;

import java.awt.Point;
import java.util.Arrays;
import java.util.Collections;

public class RunFromeEnimy {
	private CursorControl robUI;
	private FlytoLocation flylocate;
	private Point mapPnt;
	private Point leftCenterGate;
	public RunFromeEnimy(CursorControl robUI, mapinfo map, FlytoLocation flylocate) {
		this.robUI = robUI;
		this.flylocate=flylocate;
	}

	
	Point rdirect = leftCenterGate;
	private int wate;
	
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
			System.out.println(mnum);
			moving=true;
		}else{
			if(moving){
			resetRuning();
			System.out.println("done traveling");
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
		}else{
			return true;
		}
		return false;
			
	}
	private void jumpgate(Point p,Point p2){
		Point jpnt=new Point(mapPnt.x+p.x,mapPnt.y+p.y);
		Point dpnt = new Point(mapPnt.x+p2.x,mapPnt.y+p2.y);
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
	/*private Point calkgateovershoot(Point gatepoint, Point shipPoint){
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
	*/
	/*private Point pcompToP(Point p, Point p1){
		int x = p.x- p1.x;
		int y=p.y- p1.y;
		return new Point(x,y);
	}*/
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
	}
}
