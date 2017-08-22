package objectFinder;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class toolSrch {
	public Colorlogic colLogic;
	public Point toolBarPt;
	public boolean toolBar(BufferedImage im) {
		for(int x=0;x<im.getWidth()-100;x+=73){
			
			for(int y =2; y<im.getHeight();y++){
				//if(toolborderClr(im,x,y))
					//System.out.println("tool Bar Pnt="+x+","+y);
				if(toolborderClr(im,x,y))
					if(findLeftEndPnt(im,x,y)){
						
					return true;
					}
			}
		}
		return false;
	}
	private boolean findLeftEndPnt(BufferedImage im, int x, int y) {
		for(int x1=x;x1>x-120;x1--){
			if(toolborderClr(im,x1,y)){
				if(isLeftCorner(im,x1,y)&&!toolborderClr(im,x1-5,y)){
					toolBarPt=new Point(x1,y);
				//System.out.println("tool Bar Pnt="+x1+","+y);
					return true;
				}
			}
		}
		
		return false;
	}
	public boolean toolborderClr(BufferedImage im, int x, int y){
		return(colLogic.pointEcolor(im,x,y,new Color(44,114,140))||
				colLogic.pointEcolor(im,x,y,new Color(212,195,110)));
	}
	private boolean isLeftCorner(BufferedImage im, int x1, int y) {
		// TODO Auto-generated method stub
		return (colLogic.pointEcolor(im,x1-1,y+4,new Color(200,184,104))||
				colLogic.pointEcolor(im,x1-1,y+4,new Color(41,107,132)));
	}
}
