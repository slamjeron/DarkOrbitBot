package mapControls;

import java.awt.Point;
import userControls.Mouse;

public class Travel {

	int i=0;
	private Point minPnt;
	private Point maxPnt;
	private int yi=7;
	public Point mapPoint;
	public Mouse mouse;
	public boolean move;
	public Direction dir= Direction.LEFT;
	private Direction vtravel=Direction.DOWN;
	public void chYPnt2(){
		if(vtravel==Direction.DOWN){
			
		yi+=25;
		}else{
			yi-=25;	
		}
		if(yi<25){
			vtravel=Direction.DOWN;
		}
		if(yi>175){
			vtravel=Direction.UP;
		}
	}
	public void bhalfchYPnt2(){
		if(vtravel==Direction.DOWN){
			
		yi+=25;
		}else{
			yi-=25;	
		}
		if(yi<90){
			vtravel=Direction.DOWN;
		}
		if(yi>180){
			vtravel=Direction.UP;
		}
	}
	public void chYPnt(){
		 i++;
		 yi = 0;
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
	public enum Direction {
	    RIGHT,LEFT,UP,DOWN 
	}
	public void inBounds(Point shipPoint) {
		// TODO Auto-generated method stub
		//System.out.println(dir);
		if(shipPoint!=null&&mapPoint!=null){
		 minPnt = new Point(mapPoint.x+90,mapPoint.y+60);
		 maxPnt = new Point(mapPoint.x+300,mapPoint.y+260);
		boolean left = minPnt.x+6>shipPoint.x;
		boolean right = maxPnt.x-6<shipPoint.x;
		
		if(left||right){
			
			if(left){
				
				dir=Direction.RIGHT;
			}
			if(right){
				//System.out.println("should go left");
				 dir=Direction.LEFT;
			}
			moveRight();
			//horisontalmv(shipPoint);
		}else{
			move=true;
		}
		
		}
		
	}
	public void horisontalmv(Point shipPoint){
		if(dir == Direction.RIGHT){
			mouse.rightclick(maxPnt.x, shipPoint.y);
		}
		if(dir == Direction.LEFT){
			mouse.rightclick(minPnt.x, shipPoint.y);
		}
	}
	public void moveRight( ) {
		if(move){
			chYPnt2();
			
			moveside();
			move=false;
		}
		
		
	}
	public void moveside(){
		if(dir == Direction.RIGHT){
			mouse.rightclick(maxPnt.x, minPnt.y+yi);
		}
		if(dir == Direction.LEFT){
			mouse.rightclick(minPnt.x, minPnt.y+yi);
		}
	}
	
}
