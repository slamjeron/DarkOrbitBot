package seeingComputer;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class mapinfo {
	private Point mappnt=new Point(200,200);
	private GetImage imgcon;
	private Point shipPoint= new Point(getMappnt().x+120,getMappnt().y+80);
	private Rectangle mapsize;
	
	private int n;
	public mapinfo( GetImage i) {
		imgcon=i;
		
	}
	public Point findShip() {
		int yLocation = getMappnt().y+18;
		int xLocation = getMappnt().x+120;
	
		BufferedImage mapImage;
		Point searchPoint = new Point(getMappnt().x+10,getMappnt().y+10);
			mapImage=imgcon.screanImage(searchPoint, 360, 221);
			for (int i =0;i<mapImage.getWidth(); i++){
				if(imgcon.pointsevinty(mapImage,i,0)&&
						imgcon.pointsevinty(mapImage,i,100)||
						imgcon.pointsevinty(mapImage,i,4)&&
						imgcon.pointsevinty(mapImage,i,110)){
				xLocation=searchPoint.x+i;
				//System.out.println(i+10);
				break;
				}
			}
			for(int i =0;i<mapImage.getHeight();i++){
				if(imgcon.pointsevinty(mapImage,200,i)){
					yLocation=searchPoint.y+i;
					//System.out.println(i+10);
					break;
				}
			}
			
			shipPoint=new Point(xLocation,yLocation);
			
			return shipPoint;
	}
	
	public Point[] findgates(){
		Point[] gatepnt =new Point[8];
		
		Point searchPoint = new Point(mappnt.x+10,mappnt.y+10);
		BufferedImage mapImage;
			mapImage=imgcon.screanImage(searchPoint, 360, 221);
			
			for (int y =0;y<mapImage.getHeight()-4; y++){
				//System.out.println(y);
			for (int x =0;x<mapImage.getWidth()-4; x++){
				//System.out.println(x);
				if(imgcon.pointEcolor(mapImage,x,y, 204,204,204)){
					
				gatepnt[n]=new Point(x,y);
				System.out.println(gatepnt[n]);
				}
			}
			}
			
			
			
			return gatepnt;
	}
	
	public Point keapshipLock(){
		// this uses the old location to the ship to find where it moves
		// then if the cowardinants are not found the it trys to find the ship agan threw the hol map
		 boolean xlocat = false;
		 boolean ylocat = false;
		 int xLocation=0;
		 int yLocation=0;
		BufferedImage shipimg;
		Point lastLocation = new Point(shipPoint.x-35,shipPoint.y-35);
		//this.comcon.moveCursor(lastLocation);
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
