package takeAction;

import java.awt.Point;

import seeingComputer.StaticInfo;

public class NormalColect {

	private StaticInfo stc;
	private CursorControl robUI;
	
	private int n;
	
	
	
<<<<<<< HEAD
	private boolean flytoRight;
	private int boundtimekeap=0;
=======
	public boolean flytoRight;
	private int boundtimekeap=0;
	private int tst;
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
	
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
<<<<<<< HEAD
	public void startPet(){
=======
	public void startPet1(){
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
		
		
		if(stc.petSt.petdown){
			if(n==1){
			robUI.rightclick(stc.petSt.petControlPoints[0]);
			}
			if(n>20){
<<<<<<< HEAD
=======
				tst++;
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
				n=0;
			}
			n++;
			
		}
	}
<<<<<<< HEAD
	private move move=new move();
	private Point shpnt;
	private int k;
	public void colect(Point shipPoint) {
=======
	
public void startPet(){
		if(stc.petSt.petdown){
			if(tst<3){
			if(n==1){
			robUI.rightclick(stc.petSt.petControlPoints[0]);
			}
			if(n>20){
				tst++;
				n=0;
			}
			n++;
		}else{
			if(n>500){
				tst=0;
				n=0;
			}
			n++;
		}
		}else{
			n=0;
			tst=0;
		}
	}
	
	private move move=new move();
	private Point shpnt;
	private int k;
	private int tn;
	public void colectst(Point shipPoint,int movespec) {
		shpnt=shipPoint;
		move.inBounds(shipPoint, movespec);
	}
	public void colect(Point shipPoint,int movespec) {
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
		
		
		if(k>30){
		robUI.keepToolActive(6);
<<<<<<< HEAD
=======
		robUI.keepToolActive(7);
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
		k=0;
		}
		k++;
		
		
		shpnt=shipPoint;
<<<<<<< HEAD
		move.inBounds(shipPoint);
=======
		move.inBounds(shipPoint, movespec);
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
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
<<<<<<< HEAD
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
=======
				if(tn==4){
				robUI.rightclick(stc.petSt.petControlPoints[1]);
				}
				if(tn>8){
					if(stc.petSt.dropdownShown()){
						robUI.rightclick(stc.petSt.petControlPoints[2]);
						tn=0;
					}
					if(tn>30){
						tn=0;
					}
				}
				tn++;
			}else{
				tn=0;
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
			}
			
		}
	}
	
	class move{
		private Point mp;
		private Point minPnt;
		private Point maxPnt;
		private int i=0;
		private int yi=0;
<<<<<<< HEAD
		public void chp() {
=======
		public void chp4() {
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
			
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
<<<<<<< HEAD

					}
				if (i > 3) {
=======
					case 4:
						yi = 170;
						break;
					case 5:
						yi = 30;
						break;
					}
				if (i > 5) {
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
					yi = 7;
					i = 0;
				}
			}
		}
<<<<<<< HEAD

		public void inBounds(Point shipPoint) {
=======
public void chp() {
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
					case 4:
						yi = 170;
						break;
					case 5:
						yi = 30;
						break;
					}
				if (i > 5) {
					yi = 7;
					i = 0;
				}
		}
public void chp1() {
	i++;
		switch (i) {
		case 0:
			yi = 5;
			break;
		case 1:
			yi = 24;
			break;
		case 2:
			yi = 10;
			break;
		case 3:
			yi = 20;
			break;
		case 4:
			yi = 3;
			break;
		case 5:
			yi = 30;
			break;
		}
	if (i > 5) {
		yi = 7;
		i = 0;
	}
}
public void chp2() {
	i++;
		switch (i) {
		case 0:
			yi = 190;
			break;
		case 1:
			yi = 180;
			break;
		case 2:
			yi = 195;
			break;
		case 3:
			yi = 170;
			break;
		case 4:
			yi = 190;
			break;
		case 5:
			yi = 180;
			break;
		}
	if (i > 5) {
		yi = 7;
		i = 0;
	}
}
		public void inBounds(Point shipPoint,int movespec) {
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
			// TODO Auto-generated method stub
			mp=stc.map.getMappnt();
			minPnt=new Point(mp.x+70,mp.y+12);
			maxPnt=new Point(mp.x+270,mp.y+210);
<<<<<<< HEAD
			boolean left = minPnt.x+3>shipPoint.x;
			boolean right = maxPnt.x-3<shipPoint.x;
			boolean up =minPnt.y+1>shipPoint.y;
			boolean down = maxPnt.y-1<shipPoint.y;
			if(left){
				moveRight(true,shipPoint.y);
			}
			if(right){
				moveRight(false,shipPoint.y);
=======
			boolean left = minPnt.x+5>shipPoint.x;
			boolean right = maxPnt.x-5<shipPoint.x;
			boolean up =minPnt.y+1>shipPoint.y;
			boolean down = maxPnt.y-1<shipPoint.y;
			if(left){
				moveRight(true,shipPoint.y,movespec);
			}
			if(right){
				moveRight(false,shipPoint.y,movespec);
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
			}
			
			if(!up&&!left&&!right&&!down){
				boundtimekeap=17;
			}else{
<<<<<<< HEAD
				if(boundtimekeap>20){
=======
				if(boundtimekeap>15){
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
					boundtimekeap=0;
				}
				boundtimekeap++;
			}
		}
<<<<<<< HEAD
		private void moveRight(boolean b, int y) {
			// TODO Auto-generated method stub
			if(boundtimekeap==2){
			flytoRight=b;
			chp();
=======
		private void moveRight(boolean b, int y,int movespec) {
			// TODO Auto-generated method stub
			if(boundtimekeap==2){
			flytoRight=b;
			switch (movespec){
			case 0:
			chp();
			break;
			case 1:
				chp1();
				break;
			case 2:
				chp2();
				break;
			}
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
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
<<<<<<< HEAD
		private void moveAwayhightbounds(boolean atTop){
=======
		/*private void moveAwayhightbounds(boolean atTop){
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
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
<<<<<<< HEAD

=======
*/
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
	}
}
