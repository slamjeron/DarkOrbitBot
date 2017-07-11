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

public class boxes4  {
	private ImgRobot imgrob=new ImgRobot();
	private Mouse mouse = new Mouse();
	 private GetImage getimage=imgrob.image;
	private searchMath imgmath=imgrob.smath;
	private Colorlogic clgc=imgrob.clogic;
	private boolean yskip;
	private Point[] bbPNts=new Point[20];
	private int pntcnt;
	private BufferedImage img;
	private int imgnum;
	private BufferedImage img2;
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
		for(int y= 100;y<img.getHeight()-50;y+=5){
			if(yskip){
				y+=13;
			}else{
				yskip=true;
			}
			for(int x=50;x<img.getWidth()-50;x+=5){
				//System.out.println(x);
				if(imgmath.inBounds(img,x+70,y+60)){
					break;
				}
				x=bonesbxpnt(img,x,y);
				
				/*if(cargoC(img,x,y)){
					for(int y1=y-6;y1<y;y1++){
						for(int x1=x-6;x1<x;x1++){
							if(cargoC(img,x1,y1)){
								y=y1;
								y=y1;
							}
						}
					}
				}*/
				if(bonesBox(x,y)){
					//mouse.rightclick(x, y);
					bbPNts[pntcnt] = new Point(x,y);
					pntcnt++;
					
				}
				
			}
		}
		imgnum++;
		try {
			ImageIO.write(img2, "BMP", new File("pallsearch"+imgnum+".bmp"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	private boolean bonesBox( int x, int y) {
			if (cargoC(img,x,y)
					&&cargoC(img,x, y+5)
					&&cargoC(img,x+5, y+6)
					||cargoC(img,x,y)
					&&cargoC(img,x, y-5)
					&&cargoC(img,x+5, y-6)) {
						//dFind(palliePoint);
				for(int x1=x-10;x1<x;x1++){
						if(cargoC(img,x1,y)){
							x=x1;
						}
				}
				for(int y1=y-10;y1<y;y1++){
					if(cargoC(img,y1,y)){
						y=y1;
					}
			}
				if(thisPaliePic(x-20,y-20,img.getSubimage(x-20, y-20, 61, 61))){
						// System.out.println(new Point(x,y));
					for(int y1=y-20;y1<y+50;y1++){
					for(int x1=x-20;x1<x+50;x1++){
						if(cargoC(img,x1,y1)){
					img.setRGB(x1, y1,new Color(0,240,0).getRGB());
						}
					}
					}
					
				}
			}
			imgCchange(x,y,255,0,255);
			return false;
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
							imgCchange(x+x1,y+y1,0,0,0);
						}else{
							//System.out.println("not in pallie");
							//System.out.println(clgc.pointColor(imPalie, x, y));
							return false;
						}
					}
					if(cargoC(imPalie,x,y)){
						imgCchange(x+x1,y+y1,0,0,0);
					}
					if (x == 1 ||x == 55) {
						//System.out.println(new Color(imPalie.getRGB(x, y)));
						if(backGround(imPalie,x,y)||
								backGround(imPalie,x+1,y)){
							imgCchange(x+x1,y+y1,0,0,0);
						}else{
							//imgCchange(x+x1,y+y1,0,0,0);
							return false;
						}
					}
					
					
				}
			}
			x1+=18;
			y1+=20;
			imgCchange(x1, y1+5,0,255,0);
			imgCchange(x1, y1,0,255,0);
			imgCchange(x1+5, y1+6,0,255,0);
			imgCchange(x1+3, y1+3,0,255,0);
			return true;

		}
	private int bonesbxpnt(BufferedImage img, int x, int y) {
		if(!cargoC(img,x,y)&& !cargoC(img,x+10,y)){
			x+=13;
		}else{
			yskip=false;
		}
		if(cargoC(img,x,y+10)&&cargoC(img,x+10,y+10)){
			yskip=false;
		}
		return x;
	}

}
