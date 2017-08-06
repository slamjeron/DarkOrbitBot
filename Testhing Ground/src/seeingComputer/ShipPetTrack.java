package seeingComputer;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import imglogic.ImgRobot;
import triangle.Rtriangle;

public class ShipPetTrack {
	private ImgRobot imgcon;
	Rtriangle tryangle=new Rtriangle();
	public Point petpnt=new Point(0,0);
	private Point shipPoint= new Point(120,80);
	private Rectangle maprect;
	private boolean xfound;
	public Point mapPoint;
	public ShipPetTrack( ImgRobot imgcon2) {
		imgcon=imgcon2;
		
	}
	
	public boolean[] petnearShip(int smradius,int bgradius){
		int searchsize=bgradius+10;
		Point shpnt = new Point(shipPoint.x-(searchsize),
				shipPoint.y-(searchsize));
		Point mspnt = new Point(shpnt.x+searchsize*2,shpnt.y+searchsize*2);
	int mx = 0;
	if(mspnt.x>imgcon.image.scwidth){
		mx=mspnt.x-imgcon.image.scwidth;
	}
		BufferedImage shimg = imgcon.image.screanImage(shpnt.x,
				shpnt.y, searchsize-mx, searchsize-mx);
		boolean[] petlogic={false,false,false};
		for (int y =0;y<shimg.getHeight(); y++){
			for (int x =0;x<shimg.getWidth(); x++){
				if(imgcon.clogic.pointEcolor(shimg, x, y, 204, 129, 0)){
					petlogic[2]=true;
					petpnt=new Point(shpnt.x+x,shpnt.y+y);
					int spnt = tryangle.findhipotinose(petpnt,shipPoint);
					if(spnt<smradius){
						petpnt=new Point((shpnt.x+x)-maprect.x,(shpnt.y+y)-maprect.y);
						petlogic[0]=true;
					}
					if(spnt>bgradius){
						petpnt=new Point((shpnt.x+x)-maprect.x,(shpnt.y+y)-maprect.y);
						petlogic[1]=true;
					}
				}
			}	
		}
		
		return petlogic;
	}
	public boolean moving(){
		Point mpnt1 = new Point(maprect.x+119,maprect.y+41);
		//imgcon.clogic.printPColer(mpnt1);
		return imgcon.clogic.pointEcolor(mpnt1, 255,255,255);
	}
	public Point findShip() {
		int yLocation = maprect.y+4;
		int xLocation = shipPoint.x;
		BufferedImage mapImage;
		Point searchPoint = new Point(maprect.x+10,maprect.y+10);
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
				if(imgcon.clogic.pointsevinty(mapImage,200,i)&&imgcon.clogic.pointsevinty(mapImage,40,i)){
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
				shipPoint=new Point(xLocation,maprect.y+18);
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
	public Rectangle getMaprect() {
		return maprect;
	}

	public void setMaprect(Rectangle maprect) {
		shipPoint= new Point(maprect.x+120,maprect.y+80);
		mapPoint=new Point(maprect.x,maprect.y);
		this.maprect = maprect;
	}

	

}
