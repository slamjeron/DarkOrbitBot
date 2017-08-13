package takeAction;

import java.awt.Point;

import seeingComputer.StaticInfo;

public class NormalColect {

	private StaticInfo stc;
	private CursorControl robUI;
	
	private int n;
	
	
	
	private boolean flytoRight;
	private int boundtimekeap=0;
	
	public NormalColect(CursorControl r, StaticInfo s) {
		// TODO Auto-generated constructor stub
		robUI=r;
		stc=s;
	}
	public void stopPet(){
		
		if(stc.petSt.petup){
			
				if(n==1){
				robUI.type("e");
				}
				if(n>20){
					n=0;
				}
				n++;
				System.out.println(n);
		}
	}
	public void startPet(){
		
		
		if(stc.petSt.petdown){
			if(n==1){
			robUI.rightclick(stc.petSt.petControlPoints[0]);
			}
			if(n>20){
				n=0;
			}
			n++;
			
		}
	}
	private move move=new move();
	private Point shpnt;
	private int k;
	public void colect(Point shipPoint) {
		
		
		if(k>30){
		robUI.keepToolActive(6);
		k=0;
		}
		k++;
		
		
		shpnt=shipPoint;
		move.inBounds(shipPoint);
	}
	public void stmove(){
		move.moveside();
	}
	public void hmove(){
		move.hmove();
	}
	
	public void keepPetColoecting(){
		
		if(stc.petSt.petup){
			if(!stc.petSt.petColecting()){
				if(n==6){
				robUI.rightclick(stc.petSt.petControlPoints[1]);
				}
				if(n>10){
					if(stc.petSt.dropdownShown()){
						robUI.rightclick(stc.petSt.petControlPoints[2]);
						n=0;
					}
					if(n>30){
						n=0;
					}
				}
				n++;
			}
			
		}
	}
	
	class move{
		private Point mp;
		private Point minPnt;
		private Point maxPnt;
		private int i=0;
		private int yi=0;
		public void chp() {
			
			boolean baseFound=false;
			if (baseFound) {
				i++;
				switch (i) {
				case 1:
					yi = 5;
					break;
				case 2:
					yi = 20;
					break;
				case 3:
					yi = 35;
					break;
				}
				if (i > 3) {
					yi = 7;
					i = 1;
				}
			} else {
				i++;
					switch (i) {
					case 0:
						yi = 5;
						break;
					case 1:
						yi = 24;
						break;
					case 2:
						yi = 180;
						break;
					case 3:
						yi = 198;
						break;

					}
				if (i > 3) {
					yi = 7;
					i = 0;
				}
			}
		}

		public void inBounds(Point shipPoint) {
			// TODO Auto-generated method stub
			mp=stc.map.getMappnt();
			minPnt=new Point(mp.x+70,mp.y+12);
			maxPnt=new Point(mp.x+270,mp.y+210);
			boolean left = minPnt.x+3>shipPoint.x;
			boolean right = maxPnt.x-3<shipPoint.x;
			boolean up =minPnt.y+1>shipPoint.y;
			boolean down = maxPnt.y-1<shipPoint.y;
			if(left){
				moveRight(true,shipPoint.y);
			}
			if(right){
				moveRight(false,shipPoint.y);
			}
			
			if(!up&&!left&&!right&&!down){
				boundtimekeap=17;
			}else{
				if(boundtimekeap>20){
					boundtimekeap=0;
				}
				boundtimekeap++;
			}
		}
	
		private void moveRight(boolean b, int y) {
			// TODO Auto-generated method stub
			if(boundtimekeap==2){
			flytoRight=b;
			chp();
			moveside();
			}
		}
		public void hmove(){
			
			if(flytoRight){
				robUI.rightclick(maxPnt.x, shpnt.y);
			}else{
				robUI.rightclick(minPnt.x, shpnt.y);
			}
		}
		public void moveside(){
			if(flytoRight){
				robUI.rightclick(maxPnt.x, minPnt.y+yi);
			}else{
				robUI.rightclick(minPnt.x, minPnt.y+yi);
			}
		}
		private void moveAwayhightbounds(boolean atTop){
			if(boundtimekeap==2){
			int x;
			int y;
			if(flytoRight){
				 x = maxPnt.x;
			}else{
				x= minPnt.x;
			}
			if(atTop){
				y= minPnt.y+20;
				
			}else{
				y= maxPnt.y-20;
			}
			robUI.rightclick(x,y);
			}
			
			
		}

	}
}
