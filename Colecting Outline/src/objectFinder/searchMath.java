package objectFinder;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class searchMath {
	
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
