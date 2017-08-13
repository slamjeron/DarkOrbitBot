package workingFinder;

import java.awt.Point;
import userControls.Mouse;

public class Travel {

	int i=0;
	private Point minPnt;
	private Point maxPnt;
	private int yi;
	public Point mapPoint;
	public Mouse mouse;
	private boolean move;
	public Direction dir= Direction.RIGHT;
	
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
		
		if(shipPoint!=null&&mapPoint!=null){
		 minPnt = new Point(mapPoint.x+90,mapPoint.y+60);
		 maxPnt = new Point(mapPoint.x+290,mapPoint.y+200);
		boolean left = minPnt.x+6>shipPoint.x;
		boolean right = maxPnt.x-6<shipPoint.x;
		if(left||right){
			if(left){
				
				 setDir(Direction.RIGHT);
			}
			if(right){
				
				 setDir(Direction.LEFT);
			}
			moveRight();
		}else{
			move=true;
		}
		
		}
		
	}
	private void moveRight( ) {
		if(move){
			chYPnt();
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
	public Direction getDir() {
		return dir;
	}
	public void setDir(Direction dir) {
		this.dir = dir;
	}
}
