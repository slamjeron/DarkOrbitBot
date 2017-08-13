package mapControls;

import java.awt.Point;
import userControls.Mouse;

public class Travel {

	int i=0;
	private Point minPnt=new Point(500,500);
	private Point maxPnt=new Point(500,500);
	private int yi=7;
	public Point mapPoint;
	public Mouse mouse;
	public boolean move;
	public Direction dir= Direction.LEFT;
	private Direction vtravel=Direction.DOWN;
	private int hight;
	private int index;
	public boolean onMap2=false;
	private boolean mapPntRecived;
	public void chYPnt2(){
		if(mapPntRecived){
		hight=20;
		if(vtravel==Direction.DOWN){
		yi+=25;
		}else{
			yi-=25;	
		}
		if(yi<hight){
			yi=hight+1;
			vtravel=Direction.DOWN;
		}
		if(yi>200){
			vtravel=Direction.UP;
		}
		}
	}
	public void bhalfchYPnt2(){
		if(mapPntRecived){
		hight=135;
		if(yi<hight){
			yi=hight+3;
			
			vtravel=Direction.DOWN;
		}
		System.out.println(yi);
		if(vtravel==Direction.DOWN){
			yi+=25;
			}else{
				yi-=25;	
			}
		if(yi>180){
			vtravel=Direction.UP;
			yi=179;
		}
		}
	}
	public void sethight(int index){
		this.index=index;
		if(index==0||onMap2){
			chYPnt2();
			}else{
			if(index==1)
				bhalfchYPnt2();
			}
			yi=hight;
			moveside();
	}
	public void sethight(){
		//System.out.println(index);
		if(index==0||onMap2){
			chYPnt2();
			}else{
			if(index==1)
				bhalfchYPnt2();
			}
			moveside();
	}
	public enum Direction {
	    RIGHT,LEFT,UP,DOWN 
	}
	public void inBounds(Point shipPoint) {
		// TODO Auto-generated method stub
		//System.out.println(dir);
		if(mapPntRecived){
		if(shipPoint!=null&&mapPoint!=null){
			
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
			if(move){
				sethight();
				moveside();
				move=false;
			}
			//horisontalmv(shipPoint);
		}else{
			move=true;
		}
		
		}
		}
	}
	public void horisontalmv(Point shipPoint){
		if(mapPntRecived){
		if(dir == Direction.RIGHT){
			mouse.rightclick(maxPnt.x, shipPoint.y);
		}
		if(dir == Direction.LEFT){
			mouse.rightclick(minPnt.x, shipPoint.y);
		}
		}
	}
	
	public void moveside(){
		if(mapPntRecived){
		if(dir == Direction.RIGHT){
			mouse.rightclick(maxPnt.x, minPnt.y+yi);
		}
		if(dir == Direction.LEFT){
			mouse.rightclick(minPnt.x, minPnt.y+yi);
		}
		}
	}
	public void setMapPoint(Point point) {
		if(point!=null){
		mapPoint=point;
		mapPntRecived=true;
	minPnt = new Point(mapPoint.x+90,mapPoint.y+60);
	 maxPnt = new Point(mapPoint.x+300,mapPoint.y+260);
		}
	}
	
	
}
