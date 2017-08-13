package seeingComputer;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import imglogic.ImgRobot;

public class ShipStatus {
	private Point shipStatpnt;
	public ShipStatus(ImgRobot imgcon2) {
		// TODO Auto-generated constructor stub
		this.imgcon=imgcon2;
	}
	public Point hitPointsEnd= new Point();
	public Point shieldEnd= new Point();
	private ImgRobot imgcon;
	protected Point cargofullP= new Point();
	public Point repbtn;
	public boolean shipDead(){
		repbtn=new Point(imgcon.image.centerpt.x-87,imgcon.image.centerpt.y+201);
		return(imgcon.clogic.pointEcolor(imgcon.image.centerpt.x-90,imgcon.image.centerpt.y+120,new Color(28,35,41))
				&&imgcon.clogic.pointEcolor(imgcon.image.centerpt.x-100,imgcon.image.centerpt.y+120,new Color(28,35,41)));
			
	}
	public boolean shipHit(){
		shieldEnd=new Point(shipStatpnt.x+58,shipStatpnt.y+55);
	return imgcon.clogic.pointEcolor(shieldEnd,new Color(76,82,80));
	}
	
	public boolean enimyonscreen(){
		BufferedImage scimg = imgcon.image.screanImage();
		
		for (int y =100;y<scimg.getHeight()-20; y++){
		for (int x =20;x<scimg.getWidth()-30; x++){
			
			
				if(imgcon.image.pointEcolor(scimg,x,y,33,100,134)||
						imgcon.image.pointEcolor(scimg,x,y,119,205,33)){
					//System.out.println("enimy on screen");
					//comcon.moveCursor(x,y);
					return true;
				}
			
		}
		}
		return false;
	}
	public Point getShipStatpnt() {
		return shipStatpnt;
	}
	public void setShipStatpnt(Point shipStatpnt) {
		this.shipStatpnt = shipStatpnt;
	}

}
