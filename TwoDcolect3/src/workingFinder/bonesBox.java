package workingFinder;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import mapControls.Travel.Direction;
import userControls.Colorlogic;
import userControls.GetImage;
import userControls.ImgRobot;
import userControls.Mouse;
import userControls.Rtriangle;
import userControls.searchMath;
public class bonesBox  {
	public ImgRobot imgrob=new ImgRobot();
	public Mouse mouse = new Mouse();
	private Rtriangle tryangle=new Rtriangle();
	private Rectangle[] skipZone;
	 private GetImage getimage=imgrob.image;
	private searchMath imgmath=imgrob.smath;
	private Colorlogic clgc=imgrob.clogic;
	private Point[] bbPNts;
	private int pntcnt;
	private BufferedImage img;
	private Point clickpoint;
	private int sm;
	public void rightclick(Point p){
		
		
		mouse.rightclick(p);
		
	}
	private boolean cargoC(Color c){
		return(clgc.colMoreLess(c, new Color(200,82,92)));
	}
	private boolean cargoC(BufferedImage img, int x, int y){
		
		if(imgmath.searchBoundries(img,new Point(x,y))){
			
		return cargoC(clgc.pointColor(img, x, y));
		}else{
		return false;
		}
	}
	private boolean filter1(int x,int y){
		return !(cargoC(img, x, y)&&cargoC(img, x+1, y)
							||cargoC(img, x-1, y))&&
							!clgc.pointColor(img, x, y,31,36,43)&&
							!clgc.pointColor(img, x, y,28,33,40)&&
							!clgc.pointColor(img, x, y,27,33,38)&&
							!clgc.pointColor(img, x, y,7,7,7)&&
							!clgc.pointColor(img, x, y,0,0,0)&&
							!clgc.pointColor(img, x, y,22,38,47);
		
	}
	public boolean findBonesBox3(){
		
		Point p = new Point(30,70);
	 img = getimage.screanImage(p,getimage.scwidth-60,getimage.scheight-140);
	
	 pntcnt=0;
	 bbPNts=new Point[20];
	
	 //thisPaliePic(400,400);
	 for(int y= 4;y<img.getHeight()-4;y+=60){
			for(int x=10;x<img.getWidth()-10;x+=60){
				
				if(filter1(x,y)){
					//this is a brod filter most brighter colors will set it of
					x=imgmath.skipPnts(img,new Point(x, y), skipZone);
					loop:for(int i =(-30);i<30;i+=16){
						for(int j =(-30);j<30;j+=16){
							if(filter2(x+j,y+i)){
									break loop;
							}
						}
					}
				}else{
					filter2(x,y);
				}
				
			}
		}
	 //System.out.println(bnum);
	 //System.out.println(itorations);
	 if(pntcnt!=0){
		 
				sm=0;
			rightclick(findClosePnt());
			System.out.println("hipotinose = "+hipotinose);
			return true;
			
	}
	return false;
}
	public boolean findBonesBox3(Point shipPoint,boolean moving){
		
			Point p = new Point(30,70);
		 img = getimage.screanImage(p,getimage.scwidth-60,getimage.scheight-140);
		
		 pntcnt=0;
		 bbPNts=new Point[20];
		
		 //thisPaliePic(400,400);
		 for(int y= 4;y<img.getHeight()-4;y+=60){
				for(int x=10;x<img.getWidth()-10;x+=60){
					
					if(filter1(x,y)){
						//this is a brod filter most brighter colors will set it of
						x=imgmath.skipPnts(img,new Point(x, y), skipZone);
						loop:for(int i =(-30);i<30;i+=16){
							for(int j =(-30);j<30;j+=16){
								if(filter2(x+j,y+i)){
										break loop;
								}
							}
						}
					}else{
						filter2(x,y);
					}
					
				}
			}
		 //System.out.println(bnum);
		 //System.out.println(itorations);
		 if(pntcnt!=0){
			 if(moving){
				 if(sm>4){
					sm=0;
				 }
				 if(sm==1){
					 rightclick(shipPoint);
				 }
				 sm++;
					//return true;
				}else{
					sm=0;
				rightclick(findClosePnt());
				System.out.println("hipotinose = "+hipotinose);
				return true;
				}
		}
		return false;
	}
	
	private boolean filter2(int x,int y){
		
		if(cargoC(img, x+1, y)
				||cargoC(img, x-1, y)){
				filter3(x,y);
				return true;
			}
		
		return false;
	}
	
	public int hipotinose=0;
	private void filter3(int x,int y){
		loop:for(int x1=(-17);x1<8;x1++){
			for(int y1=(-17);y1<8;y1++){
				int tempx=x+x1;
				int tempy=y+y1;
				if(cargoC(img, tempx, tempy)){
				if(filter4(tempx,tempy)){
					if(filter5(tempx-30,tempy-30)){
					bbPNts[pntcnt]=new Point(tempx+7,tempy+5);
					pntcnt++;
					break loop;
					}
				}
					}
			}
				}
	
			}
	private boolean filter4(int x, int y) {
		for(int i=0;i<3;i++){
		for(int x1=0;x1<13;x1+=1){
			if(!cargoC(img, x+x1-i, y)
					&&!cargoC(img, x+x1-i, y+7)){
				return false;
			}
			}
		for(int y1=0;y1<9;y1+=1){
			if(!cargoC(img, x, y+y1-i)
					&&!cargoC(img, x+12, y+y1-i)){
				return false;
			}
		}
		}
		return true;
	}
	private boolean filter5(int x1,int y1) {
		int fp=60;
		for (int y = 2; y < fp; y+=3) {
					if(backGround( y+x1,y1)
							&&backGround( y+x1,y1+fp)
							&&backGround(x1+fp,y+y1)
							&&backGround( x1,y+y1)){
					
					}else{
						return false;
					}
		}
		
		return true;

	}
	private boolean backGround( int x, int y) {
		// TODO Auto-generated method stub
		if(imgmath.searchBoundries(img,new Point(x,y))){
		return (clgc.colMoreLess(new Color(130,130,130), clgc.pointColor(img, x, y)));
		}else{
			return false;
		}
		}
	private boolean darkBackGround( int x, int y) {
		// TODO Auto-generated method stub
		if(imgmath.searchBoundries(img,new Point(x,y))){
		return (clgc.colMoreLess(new Color(30,30,30), clgc.pointColor(img, x, y)));
		}else{
			return false;
		}
		}
	private Point findClosePnt(){
		clickpoint=new Point(0,0);
		Point p1 = new Point(30,70);
		int[] e =new int[20];
		int i=0;
		int numpnt = 0;
		for(Point p:bbPNts){
			if(p!=null){
				e[i]=(int) tryangle.findhipotinose(getimage.centerpt,new Point(p.x,p.y-115));
				numpnt++;
				i++;
			}else{
				break;
			}
		}
		int small = 18000;
		 for(int l=0;l<numpnt;l++){
			 if(bbPNts[l]==null){
				 break;
			 }
			if(small>e[l]){
				small=e[l];
				hipotinose =e[l];
				clickpoint=new Point(p1.x+bbPNts[l].x,p1.y+bbPNts[l].y-10);
			}
		}
		 return clickpoint;
}
	public Rectangle[] getSkipZone() {
		return skipZone;
	}
	public void setSkipZone(Rectangle[] skipZone) {
		this.skipZone = skipZone;
		
	}
	public boolean findBonesBox3(boolean moving,char direct) {
		// TODO Auto-generated method stub

		Point p = new Point(30,70);
	 img = getimage.screanImage(p,getimage.scwidth-60,getimage.scheight-140);
	
	 pntcnt=0;
	 bbPNts=new Point[20];
	
	 //thisPaliePic(400,400);
	 for(int y= 4;y<img.getHeight()-4;y+=60){
			for(int x=10;x<img.getWidth()-10;x+=60){
				
				if(filter1(x,y)){
					//this is a brod filter most brighter colors will set it of
					x=imgmath.skipPnts(img,new Point(x, y), skipZone);
					loop:for(int i =(-30);i<30;i+=16){
						for(int j =(-30);j<30;j+=16){
							if(filter2(x+j,y+i)){
									break loop;
							}
						}
					}
				}else{
					filter2(x,y);
				}
				
			}
		}
	 //System.out.println(bnum);
	 //System.out.println(itorations);
	 if(pntcnt!=0){
		 
				sm=0;
				Point cp = findClosePnt();
				if(moving){
					if(direct=='r'){
					
					if(backGround(cp.x+50,cp.y)){
						cp = new Point(cp.x-30,cp.y);
						rightclick(cp);
					}else{
						rightclick(cp);
					}
					}else{
					cp = new Point(cp.x+30,cp.y);
					if(backGround(cp.x,cp.y)){
					rightclick(cp);
					}else{
						rightclick(cp);
					}
					}
					return true;
				}else{
			rightclick(cp);
				}
			System.out.println("hipotinose = "+hipotinose);
			return true;
			
	}
	return false;
	}
	public boolean findBonesBox3(boolean moving, Direction dir) {
		// TODO Auto-generated method stub

		Point p = new Point(30,70);
	 img = getimage.screanImage(p,getimage.scwidth-60,getimage.scheight-140);
	
	 pntcnt=0;
	 bbPNts=new Point[20];
	
	 //thisPaliePic(400,400);
	 for(int y= 4;y<img.getHeight()-4;y+=60){
			for(int x=10;x<img.getWidth()-10;x+=60){
				
				if(filter1(x,y)){
					//this is a brod filter most brighter colors will set it of
					x=imgmath.skipPnts(img,new Point(x, y), skipZone);
					loop:for(int i =(-30);i<30;i+=16){
						for(int j =(-30);j<30;j+=16){
							if(filter2(x+j,y+i)){
									break loop;
							}
						}
					}
				}else{
					filter2(x,y);
				}
				
			}
		}
	 //System.out.println(bnum);
	 //System.out.println(itorations);
	 if(pntcnt!=0){
		 
				sm=0;
				Point cp = findClosePnt();
				if(moving){
					if (dir == Direction.RIGHT) {
						if(darkBackGround(cp.x-50,cp.y)){
							cp = new Point(cp.x-50,cp.y);
							
						}
							rightclick(cp);
						
					}
					if (dir == Direction.LEFT) {
						if(darkBackGround(cp.x+50,cp.y)){
							cp = new Point(cp.x+50,cp.y);
						}
							rightclick(cp);
						
					}
					return true;
				}else{
			rightclick(cp);
			return true;
				}
			//System.out.println("hipotinose = "+hipotinose);
			
			
	}
	return false;
	}
}
