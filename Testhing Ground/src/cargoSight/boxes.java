package cargoSight;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import imglogic.GetImage;

public class boxes  {
	
	protected Point palliePoint;
	public BufferedImage pallieimg;
	public boolean playerFound=false;
	public boolean four1=false;
	private boolean pfound;
	private GetImage imgcon;
	private int ct;
	private int cargoNotClose;
	private boolean cargoFound;
	public boolean Cargoonship(int xs,int ys){
		if(cargoFound){
			if(cargoNotClose>60){
				cargoNotClose=0;
				ct=26;
				cargoFound=false;
			}
			ct++;
			cargoNotClose++;
			Point tp = new Point(imgcon.centerpt.x-130,imgcon.centerpt.y-54);
		BufferedImage img = imgcon.screanImage(tp,260,137);
		Point dp=new Point();
		int max=img.getWidth();
		for(int y= ys;y<img.getHeight()-5;y+=5){
			for(int x=xs;x<max-3;x+=5){
					if(cargo2(new Color(img.getRGB(x, y+5)))
							&&cargo2(new Color(img.getRGB(x, y)))&&
							cargo2(new Color(img.getRGB(x+1, y)))
							&&cargo2(new Color(img.getRGB(x+2, y)))){
						dp=new Point(tp.x+x,tp.y+y);
						if(ct>10){
				ct=0;
					clkpnt=dp;
					return true;
						}
						
						
				
				
					}
			}
		
		}
		
		}
		
		return false;
		
	}
	private boolean cargo2(Color c){
		return(imgcon.colMoreLess(c, new Color(160,120,60)));
				
		}
	public boxes(GetImage imgcon) {
		// TODO Auto-generated constructor stub
		this.imgcon=imgcon;
	}
	private boolean backGround(Color c){
		//colmore one first color>second color  return true
		return(imgcon.colMoreLess(new Color(130,130,130), c));
	}
	private boolean cargoC(Color c){
		return(imgcon.colMoreLess(c, new Color(240,180,90)));
				
		}
	
	public Point clkpnt;
	private int oncargo;
	public boolean click;
	public Rectangle[] skipZone;
	public boolean cargo(){
		boolean mf=false;
		if(cargoFound){
			Point dell = new Point(imgcon.centerpt.x,
					(imgcon.centerpt.y+70));
			Point dell2 = new Point(imgcon.centerpt.x,
					(imgcon.centerpt.y+73));
			Point dell3 = new Point(imgcon.centerpt.x,
					(imgcon.centerpt.y+80));
			Color cl = imgcon.pointColor(dell);
			Color cl2 = imgcon.pointColor(dell2);
			Color cl3 = imgcon.pointColor(dell3);
			if(cargoC(cl)||cargoC(cl2)||cargoC(cl3)){
				if(oncargo==1){
				click=true;
				clkpnt=new Point(imgcon.centerpt.x,imgcon.centerpt.y+80);
				}
				if(oncargo>4){
				cargoFound=false;
				oncargo=0;
				}
				oncargo++;
			}else{
				if(oncargo>0){
					cargoFound=false;
					oncargo=0;
				}
			}
		}else{
		Point[] bbPNts=new Point[20];
		//stpt=new Point(100,100);
		pallieimg = this.imgcon.screanImage();
				//aleanLoked=img.compScPxtoCol(new Point(aleanLock.x+stpt.x,aleanLock.y+stpt.y), new Color(204,0, 0));						
				int pntcnt=0;
				
				//System.out.println(rect.height/2-100);
				
					for(int y1 =150;y1<pallieimg.getHeight()-150;y1+=3){
						if(!pfound){
							y1+=10;
							
						}
						pfound=false;
					for(int x1=140; x1<pallieimg.getWidth()-140;x1++){
						x1=imgcon.skipPnts(new Point(x1,y1), skipZone);
						if(!cargoC(new Color(pallieimg.getRGB(x1, y1)))&&
						!cargoC(new Color(pallieimg.getRGB(x1+10, y1)))){
							x1+=10;
						}else{
							pfound=true;
						}
						
						
						if(!cargoC(new Color(pallieimg.getRGB(x1+10, y1+17)))&&
						!cargoC(new Color(pallieimg.getRGB(x1, y1+10)))){
							
						}else{
							pfound=true;
						}
						if(thispalie(x1,y1)){
							bbPNts[pntcnt]=new Point(x1,y1);
							 mf = true;
							 pntcnt++;
						}
						
					}
					}
					clkpnt=null;
					if(mf){
					int[] e =new int[20];
					int i=0;
					for(Point p:bbPNts){
						if(p!=null){
							e[i]=findHipotinus(imgcon.centerpt,p);
							i++;
						}else{
							break;
						}
					}
					
					int small = 6000;
					
					 for(int l=0;l<20;l++){
						//System.out.println(e[l]);
						 if(bbPNts[l]==null){
							 break;
						 }
						 if(e[l]>0){
						if(small>e[l]){
							
							small=e[l];
							clkpnt=bbPNts[l];
							cargoFound=true;
						}
						 }
						
					}
					}
		}
					return mf=true;
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
		
		return pyththeorem(x,y);
	}
	private int pyththeorem(int hp,int nownleg){
		return (int) Math.sqrt((Math.pow(hp, 2)+Math.pow(nownleg, 2)));
	}
	public boolean thispalie(int x,int y){
		
		if (cargoC(new Color(pallieimg.getRGB(x, y)))
				&&cargoC(new Color(pallieimg.getRGB(x, y+10)))
				&&cargoC(new Color(pallieimg.getRGB(x+5, y+10)))
				&&cargoC(new Color(pallieimg.getRGB(x+3, y+7)))) {
					//dFind(palliePoint);
			if(thisPaliePic(pallieimg.getSubimage(x-10, y-20, 60, 60))){
					// System.out.println(new Point(x,y));
				for(int y1=y-20;y1<y+40;y1++){
				for(int x1=x-10;x1<x+50;x1++){
				pallieimg.setRGB(x1, y1,new Color(0,0,0).getRGB());
				}
				}
					//img.colorPrint(new Color(pallieimg.getRGB(x, y)));
				
				return true;
			}
		}
		return false;
	}

	
	private boolean thisPaliePic(BufferedImage imPalie) {
		
		for (int y = 0; y < imPalie.getHeight(); y++) {
			for (int x = 0; x < imPalie.getWidth(); x++) {
				if (y == 1 || y == 2 || y == 59 || y == 60 ) {
					if (!this.backGround(new Color(imPalie.getRGB(x, y)))) {
						return false;
					}
				}
				if (x == 1 ||x == 50||x == 51) {
					if (!backGround(new Color(imPalie.getRGB(x, y)))) {
						return false;
					}
				}
				
				
			}
		}
		 //System.out.println("work");

		return true;

	}
}
