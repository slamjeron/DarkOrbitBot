package imglogic;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class searchMath {
	
	public int skipPnts(Point p,Rectangle[] rect){
		for(Rectangle r: rect){
			if(p.x>r.x&&p.x<r.x+r.width){
				if(p.y>r.y&&p.y<r.y+r.height){
				return r.width+r.x;
			}
			}
		}
		return p.x;
	}
	public boolean skipPnts(int x, int y,Rectangle[] rect){
		for(Rectangle r: rect){
			if(r.x<x&&r.y<y&&r.x+r.width>x
					&&r.y+r.height>y){
				return true;
			}
		}
		return false;
	}
 	public boolean searchBoundries(BufferedImage img,Point p){
 		
		return (p.x<img.getWidth()&&p.y<img.getHeight()&&p.x>0&&p.y>0);
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
	public boolean inBounds(BufferedImage img, int x, int y) {
		searchBoundries(img,new Point(x,y));
		return false;
	}
	
}
