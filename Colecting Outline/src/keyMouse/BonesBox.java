package keyMouse;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import navigator.Navigator.DIR;
import objectFinder.Colorlogic;
import objectFinder.GamePanels.panelPoints;
import objectFinder.Rtriangle;
import objectFinder.searchMath;

public class BonesBox {

	public boolean found=false;
	public Mouse mouse = new Mouse();
	private Rtriangle tryangle=new Rtriangle();
	private Rectangle[] skipZone;
	public Colorlogic clgc;
	public BufferedImage img;
	private Point[] bbPNts;
	private int pntcnt;
	private Point clickpoint;
	public panelPoints panPnt;
	public searchMath imgmath;
	
	public void rightclick(Point p){
		mouse.rightclick(p);
	}
	
	private boolean backGround( int x, int y) {
		return (clgc.colMoreLess(new Color(130,130,130), clgc.pointColor(img, x, y)));
		}
	
	public void rects(){
		skipZone=new Rectangle[]{new Rectangle(panPnt.map.x-5,panPnt.map.y-20,410,305),
				new Rectangle(panPnt.pet.x-5,panPnt.pet.y-5,310,210),
				new Rectangle(panPnt.ship.x-5,panPnt.ship.y-5,240,120),
				new Rectangle(panPnt.user.x-5,panPnt.user.y-5,259,141)};
	
	}
	private boolean cargoC(Color c){
		return(clgc.colMoreLess(c, new Color(200,82,92)));
	}
	private boolean cargoC(BufferedImage img, int x, int y){
		return cargoC(clgc.pointColor(img, x, y));
		
	}
	private class Filter{
	public boolean filter1(int x,int y){
		return !(cargoC(img, x, y)&&cargoC(img, x+1, y)
							||cargoC(img, x-1, y))&&
							!clgc.pointColor(img, x, y,31,36,43)&&
							!clgc.pointColor(img, x, y,28,33,40)&&
							!clgc.pointColor(img, x, y,27,33,38)&&
							!clgc.pointColor(img, x, y,7,7,7)&&
							!clgc.pointColor(img, x, y,0,0,0)&&
							!clgc.pointColor(img, x, y,22,38,47);
	}
	
	private boolean filter2(int x,int y){
		
		if(cargoC(img, x+1, y)
				||cargoC(img, x-1, y)){
				filter3(x,y);
				return true;
			}
		
		return false;
	}
	private void filter3(int x,int y){
		loop:for(int x1=(-17);x1<8;x1++){
			for(int y1=(-17);y1<8;y1++){
				int tempx=x+x1;
				int tempy=y+y1;
				if(cargoC(img, tempx, tempy)){
					if(filter4(tempx,tempy)){
						if(filter5(tempx-30,tempy-30)){
					bbPNts[pntcnt]=new Point(tempx,tempy);
					pntcnt++;
					break loop;
						}
					}
				}
			}
		}
	}
	private boolean filter4(int x, int y) {
		for(int i=0;i<3;i++){
		for(int x1=0;x1<13;x1+=1){
			if(!cargoC(img, x+x1-i, y)
					&&!cargoC(img, x+x1-i, y+7)){
				return false;
			}
			}
		for(int y1=0;y1<9;y1+=1){
			if(!cargoC(img, x, y+y1-i)
					&&!cargoC(img, x+12, y+y1-i)){
				return false;
			}
		}
		}
		return true;
	}
	private boolean filter5(int x1,int y1) {
		int fp=60;
		for (int y = 2; y < fp; y+=3) {
					if(backGround( y+x1,y1)
							&&backGround( y+x1,y1+fp)
							&&backGround(x1+fp,y+y1)
							&&backGround( x1,y+y1)){
					
					}else{
						return false;
					}
		}
		
		return true;

	}
	}
	private Point findClosePnt(){
		clickpoint=new Point(0,0);
		int[] e =new int[20];
		int i=0;
		int numpnt = 0;
		for(Point p:bbPNts){
			
			if(p!=null){
				if(!imgmath.contains(new Point(p.x,p.y-115),skipZone)){
				e[i]=(int) tryangle.findhipotinose(mouse.centerpt,new Point(p.x,p.y-115));
				numpnt++;
				i++;
				}
			}else{
				break;
			}
		}
		int small = 18000;
		 for(int l=0;l<numpnt;l++){
			 if(bbPNts[l]==null){
				 break;
			 }
			if(small>e[l]){
				small=e[l];
				
				clickpoint=new Point(bbPNts[l].x,bbPNts[l].y);
			}
		}
		 return clickpoint;
}
	public Rectangle[] getSkipZone() {
		return skipZone;
	}
	public void setSkipZone(Rectangle[] skipZone) {
		this.skipZone = skipZone;
	}
	
	public boolean findBonesBox3(boolean moving, DIR dir) {	
	 Filter filter=new Filter();
	 pntcnt=0;
	 bbPNts=new Point[20];
	 for(int y= 70;y<img.getHeight()-4;y+=60){
			for(int x=30;x<img.getWidth()-10;x+=60){
				x=imgmath.skipPnts(img,new Point(x, y), skipZone);
				if(filter.filter1(x,y)){
					loop:for(int i =(-30);i<30;i+=16){
						for(int j =(-30);j<30;j+=16){
							if(filter.filter2(x+j,y+i)){
									break loop;
							}
						}
					}
				}else{
					filter.filter2(x,y);
				}
			}
		}
	 if(pntcnt!=0){
				Point cp = findClosePnt();
				found=true;
			rightclick(cp);
			return true;
	}
	return false;
	}
}
