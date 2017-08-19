package checkStats;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import keyMouse.Mouse;
import objectFinder.ImgRobot;
import time.Increment;

public class ShipMonitor {

	public ImgRobot imgR;
	public Mouse mouse;
	private Point panelPnt;
	private BufferedImage image;
	private Rectangle shipHPRect;
	private Rectangle shipSDRect;
	private Rectangle speedRect;
	private int wClick;
	private boolean numLocated;
	private int oldHP;
	private int oldSD;
	private int shipHP;
	private int shipSD;
	private int deathCount;
	
	public Point getPanelPnt() {
		return panelPnt;
	}
	public void setPanelPnt(Point panelPnt) {
		numLocated=false;
		this.panelPnt = panelPnt;
		shipHPRect=new Rectangle(panelPnt.x+34,panelPnt.y+38,50,8);
		shipSDRect=new Rectangle(panelPnt.x+34,panelPnt.y+55,50,8);
		speedRect=new Rectangle(panelPnt.x+125,panelPnt.y+55,25,8);
	}
	public int getSpeed(){
		return (imgR.number.readnum1(image, speedRect));
	}
	public boolean isAtaked() {
		boolean hit = (hitCheck(oldHP,shipHP,oldSD,shipSD));
		oldHP=shipHP;
		oldSD=shipSD;
		return hit;
	}
	private boolean hitCheck(int oldHP,int newHP,int oldSD,int newSD){
		return(oldHP!=0&&newHP!=0&&oldSD!=0&&newSD!=0&&
				oldHP>newHP&&oldSD>newSD);
	}
	public BufferedImage getImage() {
		return image;
	}
	public void setSetImage(BufferedImage image) {
		//System.out.println(image);
		this.image = image;
	}
	private Point addCenterPt(int x,int y){
		return new Point(mouse.centerpt.x+x,mouse.centerpt.y+y);
	}
	private Increment inc=new Increment();
	public boolean shipDead(){
		Point repbtn = addCenterPt(-87,201);
		if((imgR.clogic.pointEcolor
				(addCenterPt(-90,120),new Color(28,35,41))
				&&imgR.clogic.pointEcolor
				(addCenterPt(-100,120)
						,new Color(28,35,41)))){
			if(inc.increment(10)){
				mouse.rightclick(repbtn);
				deathCount++;
			}
			
			return true;
			
		}else{
			return false;
		}
	}
	public void readInfo() {
		// TODO Auto-generated method stub
		//if()
		
		shipSD=(imgR.number.readnum1(image, shipSDRect));
		int digSD=imgR.number.getDigits();
		if(wClick==1)
			if(digSD==0)
				mouse.rightclick(shipSDRect.x+30, shipSDRect.y+7);
			
		shipHP=(imgR.number.readnum1(image, shipHPRect));
		int digHP=imgR.number.getDigits();
			if(wClick==1)
				if(digHP==0)
					mouse.rightclick(shipHPRect.x+20, shipHPRect.y+6);
			
			
				
			if(wClick>40){
				//numLocated=true;
				wClick=0;
			}
			if(digSD==0||digHP==0){
			wClick++;
			}else{
				wClick=3;
			}
		}
}
