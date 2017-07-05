package seeingComputer;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class ShipStatus {
	private Point shipStatpnt;
	public ShipStatus(GetImage imgcon) {
		// TODO Auto-generated constructor stub
		this.imgcon=imgcon;
	}
<<<<<<< HEAD
	private Point stpt = new Point();
=======
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
	public Point hitPointsEnd= new Point();
	public Point shieldEnd= new Point();
	private GetImage imgcon;
	protected Point cargofullP= new Point();
	public Point repbtn;
	public boolean shipDead(){
		repbtn=new Point(imgcon.centerpt.x-87,imgcon.centerpt.y+201);
		return(imgcon.pointEcolor(imgcon.centerpt.x-90,imgcon.centerpt.y+120,new Color(28,35,41))
				&&imgcon.pointEcolor(imgcon.centerpt.x-100,imgcon.centerpt.y+120,new Color(28,35,41)));
			
	}
	public boolean shipHit(){
		shieldEnd=new Point(shipStatpnt.x+58,shipStatpnt.y+55);
	return imgcon.pointEcolor(shieldEnd,new Color(76,82,80));
	}
<<<<<<< HEAD
=======
	
	public boolean enimyonscreen(){
		BufferedImage scimg = imgcon.screanImage();
		
		for (int y =100;y<scimg.getHeight()-20; y++){
		for (int x =20;x<scimg.getWidth()-30; x++){
			
			if(imgcon.scipMap(x,y)){
				if(imgcon.pointEcolor(scimg,x,y,33,100,134)||
						imgcon.pointEcolor(scimg,x,y,119,205,33)){
					//System.out.println("enimy on screen");
					//comcon.moveCursor(x,y);
					return true;
				}
			}else{
				x+=300;
			}
		}
		}
		return false;
	}
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
	public Point getShipStatpnt() {
		return shipStatpnt;
	}
	public void setShipStatpnt(Point shipStatpnt,GetImage imgcon) {
		this.shipStatpnt = shipStatpnt;
		this.imgcon=imgcon;
	}

}
