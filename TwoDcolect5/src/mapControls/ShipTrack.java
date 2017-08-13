package mapControls;

import java.awt.Point;
import java.awt.image.BufferedImage;
import userControls.Colorlogic;
import userControls.ImgRobot;
import userControls.Rtriangle;

public class ShipTrack {
	private ImgRobot imgcon;
	Rtriangle tryangle=new Rtriangle();
	//public Point petpnt=new Point(0,0);
	private Point shipPoint= new Point(120,80);
	
	private boolean xfound;
	public Point mapPoint;
	private Colorlogic clogic;
	private Point mapPnt(int x,int y){
		return new Point(mapPoint.x+x,mapPoint.y+y);
	}
	public boolean on1_1(){
		
		return clogic.pointEcolor(mapPnt(33,44), 38, 41, 48)
				&&clogic.pointEcolor(mapPnt(44,44), 38, 41, 48)&&
				clogic.pointEcolor(mapPnt(33,43), 34,39,44)
				&&clogic.pointEcolor(mapPnt(44,43),34,39,44);
		
	}
	public ShipTrack( ImgRobot imgcon2) {
		imgcon=imgcon2;
		clogic=imgcon.clogic;
	}
	
	public boolean moving(){
		Point mpnt1 = new Point(mapPoint.x+119,mapPoint.y+41);
		//imgcon.clogic.printPColer(mpnt1);
		return imgcon.clogic.pointEcolor(mpnt1, 255,255,255);
	}
	public Point findShip() {
		int yLocation = mapPoint.y+18;
		int xLocation = shipPoint.x;
		//System.out.println(mapPoint);
		BufferedImage mapImage;
		Point searchPoint = new Point(mapPoint.x+18,mapPoint.y+18);
			mapImage=imgcon.image.screanImage(searchPoint, 360, 221);
			for (int i =0;i<mapImage.getWidth(); i++){
				if(imgcon.clogic.pointsevinty(mapImage,i,0)&&
						imgcon.clogic.pointsevinty(mapImage,i,100)||
						imgcon.clogic.pointsevinty(mapImage,i,40)&&
						imgcon.clogic.pointsevinty(mapImage,i,110)){
				xLocation=searchPoint.x+i;
				xfound=true;
				break;
				}
			}
			boolean yfound=false;
			for(int i =0;i<mapImage.getHeight();i++){
				if(imgcon.clogic.pointsevinty(mapImage,210,i)&&imgcon.clogic.pointsevinty(mapImage,40,i)){
					yLocation=searchPoint.y+i;
					//System.out.println(i+10);
					yfound=true;
					break;
				}
			}
			if(!xfound){
				xLocation=shipPoint.x;
			}
			if(yfound){
			shipPoint=new Point(xLocation,yLocation);
			}else{
				shipPoint=new Point(xLocation,mapPoint.y+18);
			}
			
			return shipPoint;
	}
	
	public Point keapshipLock(){
		 boolean xlocat = false;
		 boolean ylocat = false;
		 int xLocation=0;
		 int yLocation=0;
		BufferedImage shipimg;
		Point lastLocation = new Point(shipPoint.x-35,shipPoint.y-35);
		shipimg=imgcon.image.screanImage(lastLocation, 70, 70);
		
					for (int k = 0; k < shipimg.getWidth(); k++) {
						if(imgcon.clogic.pointsevinty(shipimg,k,68)){
							xLocation=lastLocation.x+k;
							xlocat=true;
							break;
						}
					if(imgcon.clogic.pointsevinty(shipimg,k,1)){
						xLocation=lastLocation.x+k;
						xlocat=true;
						break;
					}
					
					}
				
					for (int k = 0; k < shipimg.getHeight(); k++) {	
					if(imgcon.clogic.pointsevinty(shipimg,1,k)){
						yLocation=lastLocation.y+k;
						ylocat=true;
						break;
					}
					}
		if(!xlocat||!ylocat){
			findShip();
			return shipPoint;
		}else{
		shipPoint=new Point(xLocation,yLocation);
		return shipPoint;
		}
	}

	public void setMappnt(Point mapPnt) {
		mapPoint=new Point(mapPnt.x-22,mapPnt.y-50);
		shipPoint= new Point(mapPoint.x+120,mapPoint.y+80);
		
		
	}

	

}
