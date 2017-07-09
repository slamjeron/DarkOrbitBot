package seeingComputer;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class GetImage {
	
	private Rectangle screen=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	public final Point centerpt = new Point(screen.width/2,screen.height/2);
	private Robot rob;
	public int scwidth=screen.width;
	public int scheight=screen.height;
	public GetImage() {
		try {
			rob=new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	public int findHipotinus(Point p, Point p1){
		int x = p.x- p1.x;
		int y=p.y- p1.y;
		if(x<0){
			x=x*(-1);
		}
		if(y<0){
			y=y*(-1);
		}
		return pyththeore(x,y);
	}
	private int pyththeore(int hp,int nownleg){
		return (int) Math.sqrt((Math.pow(hp, 2)+Math.pow(nownleg, 2)));
	}
	public int twoPntSkip(Point cP,Point p,Point p2){
 		Point[] bsmPNTs = sortpnt(p,p2);
 		if(bsmPNTs[0].x>cP.x&&bsmPNTs[1].x<cP.x
 				&&bsmPNTs[0].y>cP.y&&bsmPNTs[1].y<cP.y){
 			return bsmPNTs[0].x;
 		}else{
 			return cP.x;
 		}
 	}	
 	private Point[] sortpnt(Point p,Point p2){
 		int bigy;
 		int smally;
 		if(p.y>p2.y){
 			bigy=p.y;
 			smally=p2.y;
 		}else{
 			bigy=p2.y;
 			smally=p.y;
 		}
 		int bigX;
 		int smallX;
 		if(p.x>p2.x){
 			bigX=p.x;
 			smallX=p2.x;
 		}else{
 			bigX=p2.x;
 			smallX=p.x;
 		}
 		 Point[]arint={new Point(bigX,bigy),new Point(smallX,smally)};
 		return arint;
 	}
	public BufferedImage screanImage(){
		return rob.createScreenCapture(screen);
	}
	public BufferedImage screanImage(int x,int y,int width,int hight){
		return rob.createScreenCapture(new Rectangle(x,y,width,hight));
	}
	public BufferedImage screanImage(Point p,int width,int hight){
		return rob.createScreenCapture(new Rectangle(p.x,p.y,width,hight));
	}
	
	public int twoPntSkip(int x1, int y1, int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		return twoPntSkip(new Point (x1,y1),new Point(i,j),new Point (k,l));
	}
}
