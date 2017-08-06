package seeingComputer;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;

import userControls.ImgRobot;
import userControls.Mouse;

public class ShipStatus {
	private Point shipStatpnt;
	private Mouse mouse;
	public ShipStatus(ImgRobot imgcon2,Mouse mouse) {
		// TODO Auto-generated constructor stub
		this.imgcon=imgcon2;
		this.mouse=mouse;
	}
	public Point hitPointsEnd= new Point();
	public Point shieldEnd= new Point();
	private ImgRobot imgcon;
	protected Point cargofullP= new Point();
	public Point repbtn;
	private int deathCount;
	private int dedtm;
	public int getDeathCount(){
		return deathCount;
	}
	private Point addCenterPt(int x,int y){
		return new Point(imgcon.image.centerpt.x+x,imgcon.image.centerpt.y+y);
	}
	public void shiplag(){
		mouse.rightclick(addCenterPt(-77,67));
	}
	public boolean shipDead(){
		repbtn=addCenterPt(-87,201);
		if((imgcon.clogic.pointEcolor
				(addCenterPt(-90,120),new Color(28,35,41))
				&&imgcon.clogic.pointEcolor
				(addCenterPt(-100,120)
						,new Color(28,35,41)))){
			if(dedtm>50){
				mouse.rightclick(repbtn);
				deathCount++;
				dedtm=0;
				
			}
			dedtm++;
			return true;
			
		}else{
			return false;
		}
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
