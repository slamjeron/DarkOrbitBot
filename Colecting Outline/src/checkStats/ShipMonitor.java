package checkStats;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import keyMouse.Mouse;
import objectFinder.ImgRobot;

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
	public boolean isShipAtaked() {
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
		this.image = image;
	}
	public void readInfo() {
		// TODO Auto-generated method stub
		shipHP=(imgR.number.readnum1(image, shipHPRect));
		 
		shipSD=(imgR.number.readnum1(image, shipSDRect));
		
		if(wClick==1)
			if(imgR.number.getDigits()==0)
				mouse.rightclick(shipSDRect.x+30, shipSDRect.y+7);
			
			 
			if(wClick==4)
				if(imgR.number.getDigits()==0)
					mouse.rightclick(shipHPRect.x+20, shipHPRect.y+6);
			
			
				
			if(wClick>20){
				//numLocated=true;
				wClick=0;
			}
			wClick++;
		}
}
