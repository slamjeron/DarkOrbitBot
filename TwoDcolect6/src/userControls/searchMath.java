package userControls;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import gui.ColectRobot;

public class searchMath {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
					searchMath window = new searchMath();
					
				
			}
		});
	}
	private searchMath(){
		testastect();
	}
	public int aspectratioY(Point p,Point p2,int x){
		int y=0;
		double xdif = p.x-p2.x;
		double ydif = p.y-p2.y;
		double m = ydif/xdif;
		System.out.println(m);
		double c = p.y-m*p.x;
		System.out.println(c);
		y=(int) (m*x+c);
		System.out.println(y);
		return y;
	}
	
	public int aspectratioX(Point p,Point p2,int y){
		return aspectratioY(new Point(p.y,p.x),new Point(p2.y,p2.x),y);
		
	}
	public void testastect(){
		aspectratioX(new Point(1890,550),new Point(1700,588),524);
		
	}
	public int skipPnts(BufferedImage img,Point p,Rectangle[] rect){
		if(rect!=null){
		for(Rectangle r: rect){
			if(r!=null){
			if(p.x>r.x&&p.x<r.x+r.width){
				if(p.y>r.y&&p.y<r.y+r.height){
					int nx = r.width+r.x;
					if(nx>img.getWidth()-50){
						nx=img.getWidth()-50;
					}
				return nx;
			}
			}
			}
		}
		}
		return p.x;
	}
	public boolean skipPnts( int x, int y,Rectangle[] rect){
		for(Rectangle r: rect){
			if(r.x<x&&r.y<y&&r.x+r.width>x
					&&r.y+r.height>y){
				return true;
			}
		}
		return false;
	}
 	public boolean searchBoundries(BufferedImage img,Point p){
 		//System.out.println(img.getWidth());
		return (p.x<img.getWidth()&&p.y<img.getHeight()&&p.x>10&&p.y>10);
	}
	public boolean inBounds(BufferedImage img, int x, int y) {
		searchBoundries(img,new Point(x,y));
		return false;
	}
	
}
