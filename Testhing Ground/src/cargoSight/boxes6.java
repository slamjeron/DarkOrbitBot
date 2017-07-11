package cargoSight;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import imglogic.Colorlogic;
import imglogic.GetImage;
import imglogic.ImgRobot;
import imglogic.searchMath;
import userControls.Mouse;

public class boxes6  {
	private ImgRobot imgrob=new ImgRobot();
	public Mouse mouse = new Mouse();
	 private GetImage getimage=imgrob.image;
	private searchMath imgmath=imgrob.smath;
	private Colorlogic clgc=imgrob.clogic;
	private boolean yskip;
	private Point[] bbPNts;
	private int pntcnt;
	private BufferedImage img;
	private int imgnum=0;
	private BufferedImage img2;
	private Point clickpoint;
	private int scount;
	private int oncargo;
	private boolean goingToBox=false;
	private int colectseqns=0;
	private boolean backGround(Color c){
		scount++;
		return(clgc.colMoreLess(new Color(150,150,160),c));
	}
	private boolean backGround(BufferedImage img, int x, int y){
		return backGround(clgc.pointColor(img, x, y));
	}
	private void rightclick(Point p){
		
		for(int y= p.y-2;y<p.y+2;y++){
			for(int x =p.x-2;x< p.x+2;x++){
				if(!imgmath.inBounds(img, x, y)){
		imgCchange(x,y,100,0,200);
				}
			}
		}
		if(!imgmath.inBounds(img, p.x, p.y)){
		mouse.rightclick(p);
		}
	}
	private void onTopBobesBox(){
		if(colectseqns==2){
		Point dell = new Point(getimage.centerpt.x,
				(this.getimage.centerpt.y+70));
		Point dell2 = new Point(getimage.centerpt.x,
				(getimage.centerpt.y+73));
		Point dell3 = new Point(getimage.centerpt.x,
				(getimage.centerpt.y+80));
		
		if(cargoC(dell3)||cargoC(dell2)||cargoC(dell)){
			rightclick(dell);
			colectseqns=0;
		}
		}
	}
	private boolean cargoC(Color c){
		scount++;
		return(clgc.colMoreLess(c, new Color(199,79,90)));
	}
	private boolean cargoC(BufferedImage img, int x, int y){
		return cargoC(clgc.pointColor(img, x, y));
	}
	private boolean cargoC(Point p){
		return cargoC(clgc.pointColor( p.x, p.y));
	}
	public void clkup(){
		mouse.moveCursor(getimage.centerpt.x,getimage.centerpt.y-130);
		mouse.rightclick(getimage.centerpt.x,getimage.centerpt.y-130);
	}
	public boolean findBonesBox(){
		//System.out.println(colectseqns);
		if(colectseqns==0){
		 img = getimage.screanImage();
		 img2=img;
		 pntcnt=0;
		 scount=0;
		 bbPNts=new Point[20];
		for(int y= 100;y<img.getHeight()-70;y+=20){
			for(int x=50;x<img.getWidth()-50;x+=20){
				findbb(x,y);
			}
		}
		if(pntcnt!=0){
			Point p = findClosePnt(bbPNts);
			rightclick(p);
		imgnum++;
		System.out.println(imgnum);
		
		}
		}
		try {
			ImageIO.write(img2, "BMP", new File("pallsearch"+imgnum+".bmp"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public void nearShipSearch() {
		// TODO Auto-generated method stub
		Point sp = new Point(getimage.centerpt.x-100,
				getimage.centerpt.y-100);
		img = getimage.screanImage(sp.x,
				sp.y,200,200);
		pntcnt=0;
		for(int y= 43;y<img.getHeight()-43;y+=20){
			for(int x=43;x<img.getWidth()-43;x+=20){
				findbb(x,y);
				//System.out.println(x);
			}
		}
		
	}
	private void findbb(int x,int y){
		if(cargoC(img,x,y)&&cargoC(img,x+1,y)
				&&cargoC(img,x,y+1)){
			int sy=0;
			
			for(int y1=0;y1<16;y1++){
				if(!cargoC(img,x,y-y1)){
					sy=y1;
					
					break;
				}
				imgCchange(x,y-y1,255,0,0);
				//System.out.println(new Point(x,y1));
			}
			int sx=0;
			for(int x1=0;x1<16;x1++){
				if(!cargoC(img,x-x1,y)){
					sx=x1;
					break;
				}
				imgCchange(x-x1,y,255,0,0);
			}
			
			loop:for(int y1=(y-sy)+4;y1<y+1;y1+=2){
			for(int x1=(x-sx)+4;x1<x+1;x1+=2){
			if(bonesBox(x1,y1,x,y)){
				bbPNts[pntcnt] = new Point(x1,y1);
				pntcnt++;
				break loop;
			}
			imgCchange(x1,y1,255,0,0);
			
			
			}
			}
			//System.out.println(nlct1);
		}
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
	private boolean bonesBox( int x, int y, int x2, int y2) {
			if (cargoC(img,x,y)
					&&cargoC(img,x, y+5)
					&&cargoC(img,x+5, y+6)) {
						//dFind(palliePoint);
				if(thisPaliePic(x-20,y-20,img.getSubimage(x-20, y-20, 61, 61))){
						// System.out.println(new Point(x,y));
					
					for(int y1=y2-15;y1<y+41;y1+=15){
						for(int x1=x2-15;x1<x+41;x1+=15){
							
						if(cargoC(img,x1,y1)){
							imgCchange2(x1, y1,0,0,0);
						if(x1==x2&&y1==y2){
							imgCchange(x1, y1-1,0,0,0);
							imgCchange(x1+1, y1,0,0,0);
							
						}
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
		if(!imgmath.inBounds(img, x, y)){
			img.setRGB(x, y,new Color(r,g,b).getRGB());
		}
	}
		private void imgCchange(int x, int y, int r, int g, int b) {
		// TODO Auto-generated method stub
			if(!imgmath.inBounds(img, x, y)){
			img2.setRGB(x, y,new Color(r,g,b).getRGB());
			}
	}
		private boolean thisPaliePic(int x1,int y1,BufferedImage imPalie) {
			
			for (int y = 0; y < imPalie.getHeight(); y++) {
				for (int x = 0; x < imPalie.getWidth(); x++) {
					if (y == 1 || y == 58 ) {
						if(backGround(imPalie,x,y)||
								backGround(imPalie,x,y+1)){
							//System.out.println(clgc.pointColor(imPalie, x, y));
							//imgCchange(x+x1,y+y1,200,200,200);
						}else{
							//System.out.println("not in pallie");
							//System.out.println(clgc.pointColor(imPalie, x, y));
							return false;
						}
					}else{
						if(x==2){
							x+=54;
						}
						if(x==56){
							x+=60;
						}
					}
					
					if (x == 0 ||x == 55) {
						//System.out.println(new Color(imPalie.getRGB(x, y)));
						if(backGround(imPalie,x,y)||
								backGround(imPalie,x+1,y)){
							//imgCchange(x+x1,y+y1,200,200,200);
						}else{
							////imgCchange(x+x1,y+y1,0,0,0);
							return false;
						}
					}
					
					
				}
			}
			
			return true;

		}
	

}
