package seeingComputer;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import imglogic.GetImage;

public class ShipPetTrack {
	private Point mappnt=new Point(200,200);
	private GetImage imgcon;
	public Point petpnt=new Point(0,0);
	private Point shipPoint= new Point(getMappnt().x+120,getMappnt().y+80);
	private Rectangle mapsize;
	
	private int n;
	private boolean xfound;
	public ShipPetTrack( GetImage i) {
		imgcon=i;
		
	}
	
	public boolean[] petnearShip(int smradius,int bgradius){
		int searchsize=bgradius+10;
		Point shpnt = new Point(shipPoint.x-(searchsize),
				shipPoint.y-(searchsize));
		Point mspnt = new Point(shpnt.x+searchsize*2,shpnt.y+searchsize*2);
	int mx = 0;
	if(mspnt.x>imgcon.scwidth){
		mx=mspnt.x-imgcon.scwidth;
	}
		BufferedImage shimg = imgcon.screanImage(shpnt.x,
				shpnt.y, searchsize-mx, searchsize-mx);
		boolean[] petlogic={false,false,false};
		for (int y =0;y<shimg.getHeight(); y++){
			for (int x =0;x<shimg.getWidth(); x++){
				if(imgcon.pointEcolor(shimg, x, y, 204, 129, 0)){
					petlogic[2]=true;
					petpnt=new Point(shpnt.x+x,shpnt.y+y);
					int spnt = imgcon.findHipotinus(petpnt,shipPoint);
					if(spnt<smradius){
						petpnt=new Point((shpnt.x+x)-mappnt.x,(shpnt.y+y)-mappnt.y);
						petlogic[0]=true;
					}
					if(spnt>bgradius){
						petpnt=new Point((shpnt.x+x)-mappnt.x,(shpnt.y+y)-mappnt.y);
						petlogic[1]=true;
					}
				}
			}	
		}
		
		return petlogic;
	}
	public boolean moving(){
		Point mpnt1 = new Point(mappnt.x+96,mappnt.y-10);
		return imgcon.pointEcolor(mpnt1, 255,255,255);
	}
	public Point findShip() {
		int yLocation = getMappnt().y+4;
		int xLocation = shipPoint.x;
		BufferedImage mapImage;
		Point searchPoint = new Point(getMappnt().x+10,getMappnt().y+10);
			mapImage=imgcon.screanImage(searchPoint, 360, 221);
			for (int i =0;i<mapImage.getWidth(); i++){
				if(imgcon.pointsevinty(mapImage,i,0)&&
						imgcon.pointsevinty(mapImage,i,100)||
						imgcon.pointsevinty(mapImage,i,40)&&
						imgcon.pointsevinty(mapImage,i,110)){
				xLocation=searchPoint.x+i;
				xfound=true;
				break;
				}
			}
			boolean yfound=false;
			for(int i =0;i<mapImage.getHeight();i++){
				if(imgcon.pointsevinty(mapImage,200,i)&&imgcon.pointsevinty(mapImage,40,i)){
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
				shipPoint=new Point(xLocation,getMappnt().y+18);
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
		shipimg=imgcon.screanImage(lastLocation, 70, 70);
		
					for (int k = 0; k < shipimg.getWidth(); k++) {
						if(imgcon.pointsevinty(shipimg,k,68)){
							xLocation=lastLocation.x+k;
							xlocat=true;
							break;
						}
					if(imgcon.pointsevinty(shipimg,k,1)){
						xLocation=lastLocation.x+k;
						xlocat=true;
						break;
					}
					
					}
				
					for (int k = 0; k < shipimg.getHeight(); k++) {	
					if(imgcon.pointsevinty(shipimg,1,k)){
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
	public Point getMappnt() {
		return mappnt;
	}
	public void setMappnt(Point mappnt) {
		this.mappnt = mappnt;
		setMapsize(new Rectangle(mappnt.x,mappnt.y,350,210));
	}
	public Rectangle getMapsize() {
		return mapsize;
	}
	public void setMapsize(Rectangle mapsize) {
		this.mapsize = mapsize;
	}

}
