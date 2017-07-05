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
<<<<<<< HEAD
=======
	public Point mapPoint=new Point();
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
	public GetImage() {
		try {
			rob=new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
<<<<<<< HEAD
	
=======
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
public boolean scipMap(int x,int y){
	//System.out.println(new Point(x,y));
		if(mapPoint.x>x||mapPoint.x+300<x||
				mapPoint.y>y||mapPoint.y+218<y){
			//System.out.println("this is not the map"+x+mapPoint);
			return true;
		}else{
			//System.out.println("this is the map"+x+mapPoint);
			return false;
		}
	}
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
	public BufferedImage screanImage(){
		return rob.createScreenCapture(screen);
	}
	public BufferedImage screanImage(int x,int y,int width,int hight){
		return rob.createScreenCapture(new Rectangle(x,y,width,hight));
	}
	public BufferedImage screanImage(Point p,int width,int hight){
		return rob.createScreenCapture(new Rectangle(p.x,p.y,width,hight));
	}
	public Color pointColor(BufferedImage img,Point p){
		return pointColor(img,p.x, p.y);
	}
	public Color pointColor(BufferedImage img,int x,int y){
		return new Color(img.getRGB(x, y));
	}
	public Color pointColor(Point p){
		return pointColor(p.x, p.y);
	}
	public Color pointColor(int x,int y){
		return rob.getPixelColor(x, y);
	}
	protected boolean pointEcolor(BufferedImage image
			, int x, int y, int r, int g, int b) {
		return pointEcolor(image, x, y,new Color(r, g, b));
	}
	protected boolean pointEcolor(BufferedImage image
			, int x, int y, Color c) {
		return pointColor(image, x, y).equals(c);
	}
	public boolean pointsevinty(BufferedImage Image, int x, int y) {
		return pointEcolor(Image,x,y,70,70,70);
	}
	public boolean pointEcolor(Point point, int r, int g, int b) {
		return pointEcolor(point,new Color(r,g,b));
		
	}
	public boolean pointEcolor(Point point,Color c) {
		return pointColor(point).equals(c);
		
	}
	public boolean colMoreLess(Color more,Color less){
		return(more.getRed()>less.getRed()&&more.getGreen()>less.getGreen()&&more.getBlue()>less.getBlue());
	}
	public Color screenColor(Point p) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean pointEcolor(int x, int y, Color color) {
		// TODO Auto-generated method stub
		return pointEcolor(new Point(x,y),color);
	}
<<<<<<< HEAD
=======
	public void printPColer(Point p) {
		// TODO Auto-generated method stub
		printColor(pointColor(p));
	}
	public void printColor(Color color) {
		// TODO Auto-generated method stub
		System.out.println("new Color("+color.getRed()+","
		+color.getGreen()+","+color.getBlue()+"),");
	}
	public void printPColer(int x, int y) {
		// TODO Auto-generated method stub
		printPColer(new Point(x,y));
	}
	public boolean pointEcolor(int x, int y, int r, int g, int b) {
		// TODO Auto-generated method stub
		return pointEcolor(x,y,new Color(r,g,b));
	}
	
	public int twoPntSkip(int x1, int y1, int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		return twoPntSkip(new Point (x1,y1),new Point(i,j),new Point (k,l));
	}
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
}
