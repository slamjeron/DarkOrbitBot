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
	
	private int oldHP;
	private int oldSD;
	private int shipHP;
	private int shipSD;
	private int deathCount;
	
	public Point getPanelPnt() {
		return panelPnt;
	}
	public void setPanelPnt(Point panelPnt) {
		
		this.panelPnt = panelPnt;
		shipHPRect=new Rectangle(panelPnt.x+34,panelPnt.y+38,50,8);
		shipSDRect=new Rectangle(panelPnt.x+34,panelPnt.y+55,50,8);
		speedRect=new Rectangle(panelPnt.x+125,panelPnt.y+55,25,8);
	}
	public int getSpeed(){
		return (imgR.number.readnum1(image, speedRect));
	}
	public boolean isAtaked() {
		boolean hit = (hitCheck(oldHP,shipHP,oldSD,shipSD)&&enimyonscreen());
		oldHP=shipHP;
		oldSD=shipSD;
		getSD=shipSD;
		getHP=shipHP;
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
	public void shipDead(){
		if(isShipDed()){
			repairShip();
		}
	}
	private void repairShip() {
		Point repbtn = addCenterPt(-87,201);
		if(inc.increment(20)){
			mouse.rightclick(repbtn);
			setDeathCount(getDeathCount() + 1);
		}
	}
	private boolean isShipDed() {
		return pointEcolor(addCenterPt(-90,120),28,35,41)
				&&pointEcolor(addCenterPt(-100,120),28,35,41);
	}
	private boolean pointEcolor(Point pt, int r, int g, int b) {
		return imgR.clogic.pointEcolor
				(image,pt.x,pt.y,new Color(r,g,b));
	}
	private boolean pointEcolor(int x, int y, int r, int g, int b) {
		return pointEcolor(new Point(x,y),r,g,b);
	}
	public boolean enimyonscreen(){
		for (int y =100;y<image.getHeight(); y++){
			for (int x =0;x<image.getWidth(); x++){
				if(enimyFound(x,y)){
					return true;
				}
			}
		}
		return false;
	}
	private boolean enimyFound(int x, int y) {
		return pointEcolor(x,y,33,100,134)||
				pointEcolor(x,y,119,205,33);
	}
	private int slowDownFix=0;
	public int getSD;
	public int getHP;
	public void readInfo() {
		if(shipPanelVisible()){
		int digSD=getSDSize();
		int digHP=getHPSize();
		if(slowDownFix==1)
			setStatsToNumaric(digSD,shipSDRect);
		if(slowDownFix==1)
			setStatsToNumaric(digHP,shipHPRect);
				
		if(slowDownFix>40)
			slowDownFix=0;
			
		if(numbersNotVisible(digHP,digSD)){
			slowDownFix++;
		}else{
			slowDownFix=3;
		}
		}
		}
	private int getHPSize() {
		shipHP=(imgR.number.readnum1(image, shipHPRect));
		return imgR.number.getDigits();
	}
	private void setStatsToNumaric(int digSD, Rectangle rect) {
		if(digSD==0)
			mouse.rightclick(rect.x+30, rect.y+7);
		
	}
	private int getSDSize() {
		shipSD=(imgR.number.readnum1(image, shipSDRect));
		return imgR.number.getDigits();
	}
	private boolean shipPanelVisible() {
		return pointEcolor(panelPnt.x+73,panelPnt.y+11,22,38,47);
	}
	
	private boolean numbersNotVisible(int digHP, int digSD) {
		return digSD==0||digHP==0;
	}
	public int getDeathCount() {
		return deathCount;
	}
	public void setDeathCount(int deathCount) {
		this.deathCount = deathCount;
	}
}
