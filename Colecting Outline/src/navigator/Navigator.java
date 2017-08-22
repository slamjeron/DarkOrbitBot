package navigator;

import java.awt.Point;
import java.awt.image.BufferedImage;

import keyMouse.Keyboard;
import keyMouse.Mouse;
import objectFinder.Colorlogic;

public class Navigator {
	
	private Point mapPNT;
	private Point nMapSTPNT;
	public Colorlogic imgreed;
	private Point shipPnt;
	public Mouse mouse;
	private int hight=7;
	private DIR hDir;
	private DIR vDir;
	private int wtTime=50;
	private int maxX;
	private int minX;
	public GateJumper gatejump;
	public BufferedImage image;
	public void furthistPnt() {
		int farY;
		if(shipPnt.y<106){
			farY=210;
		}else{
			farY=1;
		}
		int farX;
		if(shipPnt.x<162){
			farX=334;
		}else{
			farX=1;
		}
		mouse.rightclick(nMapSTPNT.x+farX,nMapSTPNT.y+farY);
	}

	public Point findShip() {
		int ny=0;
		for(int y=nMapSTPNT.y;y<nMapSTPNT.y+212;y++)
			if(pointEColor(new Point(nMapSTPNT.x, y), 70, 70, 70)){
				ny=y-nMapSTPNT.y;
			}
		int nx=165;
		for(int x=nMapSTPNT.x;x<nMapSTPNT.x+335;x++)
			if(pointEColor(new Point(x, nMapSTPNT.y), 70, 70, 70)){
				nx=x-nMapSTPNT.x;
			}
		shipPnt=new Point(nx,ny);
			return new Point(nx,ny);
	}

	public boolean moving() {
		// TODO Auto-generated method stub
		boolean moving = pointEColor(mBmapPlusPnt(117,35),255,255,255)
				&&pointEColor(mBmapPlusPnt(117,35),22,38,47);
				if(moving)
					wtTime=60;
		return moving;
	}
	public boolean on1_1() {
		return imgreed.pointEcolor(mapPNT.x+29,mapPNT.y+34,106,110,113)&&
				imgreed.pointEcolor(mapPNT.x+40,mapPNT.y+34,106,110,113);
			
	}
	public enum DIR {
	    RIGHT,LEFT,UP,DOWN 
	}
	public void withinBounds() {
		 maxX =258;
		 minX=73;
		 //System.out.println(wtTime);
		if(wtTime==1){
		if(shipPnt.x>maxX-3){
			hDir=DIR.LEFT;
			if(enimyHasBace()){
				setNextPnt(130);
			}else{
				setNextPnt(6);
			}
		}
		if(minX+3>shipPnt.x){
			hDir=DIR.RIGHT;
			if(enimyHasBace()){
				setNextPnt(140);
			}else{
				setNextPnt(6);
			}
		}else{
			if(enimyHasBace())
		if(hight<140)
			hight=140+1;
		}
		moveNextPnt();
		}
		if(wtTime>20)
			wtTime=0;
		wtTime++;
	}
	private boolean enimyHasBace() {
		return pointEColor(mBmapPlusPnt(193,138), 172, 36, 36);
	}
	
	private boolean pointEColor( Point point, int r, int g, int b){
		return imgreed.pointColor(image,point.x,point.y, r, g, b);
	}
	public Point mapPlusPnt(int x,int y){
		return new Point(nMapSTPNT.x+x,nMapSTPNT.y+y);
	}
	public Point mBmapPlusPnt(int x,int y){
		return new Point(mapPNT.x+x,mapPNT.y+y);
	}
	public void setNextPnt(int stHight){
		
		if(vDir==DIR.DOWN){
		hight+=25;
		}else{
			hight-=25;	
		}
		if(hight<stHight){
			hight=stHight+1;
			vDir=DIR.DOWN;
		}
		if(hight>211){
			hight=210;
			vDir=DIR.UP;
		}
	}

	public void moveNextPnt() {
		if(hDir==DIR.RIGHT){
				mouse.rightclick(mapPlusPnt(maxX,hight));
			}else{
				mouse.rightclick(mapPlusPnt(minX,hight));
			}
		
	}

	public Point getMapPNT() {
		return mapPNT;
	}

	public void setMapPNT(Point mapPNT, Keyboard keyB) {
		this.mapPNT = mapPNT;
		nMapSTPNT=new Point(mapPNT.x+34,mapPNT.y+46);
		gatejump=new GateJumper(mapPNT,mouse,keyB, imgreed);
	}

}
