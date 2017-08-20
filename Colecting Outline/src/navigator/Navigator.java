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
	private int hight=20;
	private DIR hDir;
	private DIR vDir;
	private int wtTime=50;
	private int maxX;
	private int minX;
	public GateJumper gatejump;
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

	public Point findShip(BufferedImage screenImg) {
		
		int ny=0;
		for(int y=nMapSTPNT.y;y<nMapSTPNT.y+212;y++)
			if(imgreed.pointEcolor(screenImg, nMapSTPNT.x, y, 70, 70, 70)){
				ny=y-nMapSTPNT.y;
			}
		int nx=165;
		for(int x=nMapSTPNT.x;x<nMapSTPNT.x+335;x++)
			if(imgreed.pointEcolor(screenImg, x, nMapSTPNT.y, 70, 70, 70)){
				nx=x-nMapSTPNT.x;
			}
		shipPnt=new Point(nx,ny);
			return new Point(nx,ny);
	}

	public boolean moving() {
		// TODO Auto-generated method stub
		boolean moving = imgreed.pointEcolor(mapPNT.x+117,mapPNT.y+35,255,255,255)
				&&!imgreed.pointEcolor(mapPNT.x+117,mapPNT.y+35,22,38,47);
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
			setNextPnt();
		}
		if(minX+3>shipPnt.x){
			hDir=DIR.RIGHT;
		setNextPnt();
		}
		moveNextPnt();
		}
		if(wtTime>63)
			wtTime=0;
		wtTime++;
	}
	public Point mapPlusPnt(int x,int y){
		return new Point(nMapSTPNT.x+x,nMapSTPNT.y+y);
	}
	public void setNextPnt(){
		
		if(vDir==DIR.DOWN){
		hight+=25;
		}else{
			hight-=25;	
		}
		if(hight<17){
			hight=18;
			vDir=DIR.DOWN;
		}
		if(hight>200){
			hight=198;
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
