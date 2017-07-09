package cargoSight;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import imglogic.Colorlogic;
import imglogic.GetImage;
import imglogic.ImgRobot;
import imglogic.searchMath;
import userControls.Mouse;

public class boxes5  {
	private ImgRobot imgrob=new ImgRobot();
	private Mouse mouse = new Mouse();
	 private GetImage getimage=imgrob.image;
	private searchMath imgmath=imgrob.smath;
	private Colorlogic clgc=imgrob.clogic;
	private boolean yskip;
	private Point[] bbPNts;
	private int pntcnt;
	private BufferedImage img;
	private int imgnum;
	private BufferedImage img2;
	private int nlct;
	private Point clickpoint;
	private boolean backGround(Color c){
		return(clgc.colMoreLess(new Color(150,150,160),c));
	}
	private boolean backGround(BufferedImage img, int x, int y){
		return backGround(clgc.pointColor(img, x, y));
	}
	private boolean cargoC(Color c){
		return(clgc.colMoreLess(c, new Color(240,180,90)));
	}
	private boolean cargoC(BufferedImage img, int x, int y){
		return cargoC(clgc.pointColor(img, x, y));
	}
	public boolean findBonesBox(){
		 img = getimage.screanImage();
		 img2=getimage.screanImage();
		 pntcnt=0;
		 bbPNts=new Point[20];
		 nlct=0;
		 int nlct1=0;
		for(int y= 100;y<img.getHeight()-70;y+=15){
			
			for(int x=50;x<img.getWidth()-50;x+=15){
				//System.out.println(x);
				if(imgmath.inBounds(img,x+70,y+70)){
					break;
				}
				if(cargoC(img,x,y)&&cargoC(img,x+1,y)){
					nlct1=0;
					loop:for(int y1=y-4;y1<y+4;y1++){
					for(int x1=x-4;x1<x+4;x1++){
					if(bonesBox(x1,y1)){
						bbPNts[pntcnt] = new Point(x1,y1);
						//System.out.println(pntcnt);
						pntcnt++;
						
						
						break loop;
					}
					imgCchange(x1,y1,255,0,0);
					nlct1++;
					nlct++;
					}
					}
					System.out.println(nlct1);
				}
				imgCchange(x,y,0,255,255);
				nlct++;
			}
		}
		if(pntcnt!=0){
		mouse.rightclick(findClosePnt(bbPNts));
		}else{
			
		}
		System.out.println(nlct);
		imgnum++;
		try {
			ImageIO.write(img2, "BMP", new File("pallsearch"+imgnum+".bmp"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	private Point findClosePnt(Point[] bbPNts2){
		clickpoint=new Point(0,0);
		int[] e =new int[20];
		int i=0;
		int numpnt = 0;
		for(Point p:bbPNts){
			if(p!=null){
				e[i]=findHipotinus(getimage.centerpt,p);
				numpnt++;
				i++;
			
			}else{
				break;
			}
		}
		int small = 8000;
		 for(int l=0;l<numpnt;l++){
			 if(bbPNts[l]==null){
				 break;
			 }
			if(small>e[l]){
				small=e[l];
				clickpoint=new Point(bbPNts[l].x+5,bbPNts[l].y+5);
				
			}
		}
		 return clickpoint;
}
	private int findHipotinus(Point p, Point p1){
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
	private boolean bonesBox( int x, int y) {
			if (cargoC(img,x,y)
					&&cargoC(img,x, y+5)
					&&cargoC(img,x+5, y+6)) {
						//dFind(palliePoint);
				if(thisPaliePic(x-20,y-20,img.getSubimage(x-20, y-20, 61, 61))){
						// System.out.println(new Point(x,y));
					
					for(int y1=y-20;y1<y+50;y1++){
						for(int x1=x-20;x1<x+50;x1++){
							nlct++;
						if(cargoC(img,x1,y1)){
							imgCchange2(x1, y1,0,220,0);
							imgCchange(x1, y1,0,220,0);
						}
					}
					}
					return true;
				}
			}
			return false;
		}
	private void imgCchange2(int x, int y, int r, int g, int b) {
		// TODO Auto-generated method stub
			img.setRGB(x, y,new Color(r,g,b).getRGB());
	}
		private void imgCchange(int x, int y, int r, int g, int b) {
		// TODO Auto-generated method stub
			img2.setRGB(x, y,new Color(r,g,b).getRGB());
	}
		private boolean thisPaliePic(int x1,int y1,BufferedImage imPalie) {
			
			for (int y = 0; y < imPalie.getHeight(); y++) {
				for (int x = 0; x < imPalie.getWidth(); x++) {
					if (y == 1 || y == 58 ) {
						if(backGround(imPalie,x,y)||
								backGround(imPalie,x,y+1)){
							//System.out.println(clgc.pointColor(imPalie, x, y));
							imgCchange(x+x1,y+y1,200,200,200);
						}else{
							//System.out.println("not in pallie");
							//System.out.println(clgc.pointColor(imPalie, x, y));
							return false;
						}
					}else{
						if(x==3){
							x+=52;
						}
					}
					nlct++;
					if (x == 1 ||x == 55) {
						//System.out.println(new Color(imPalie.getRGB(x, y)));
						if(backGround(imPalie,x,y)||
								backGround(imPalie,x+1,y)){
							imgCchange(x+x1,y+y1,200,200,200);
						}else{
							//imgCchange(x+x1,y+y1,0,0,0);
							return false;
						}
					}
					
					
				}
			}
			
			return true;

		}
	

}
