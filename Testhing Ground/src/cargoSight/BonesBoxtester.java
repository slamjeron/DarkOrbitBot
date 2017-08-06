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
import triangle.Rtriangle;
import userControls.Mouse;
public class BonesBoxtester  {
	private ImgRobot imgrob=new ImgRobot();
	public Mouse mouse = new Mouse();
	Rtriangle tryangle=new Rtriangle();
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
	private int itorations;
	private void rightclick(Point p){
		for(int y= p.y-2;y<p.y+2;y++){
			for(int x =p.x-2;x< p.x+2;x++){
				if(!imgmath.inBounds(img, x, y)){
		secondImg(x,y,100,0,200);
				}
			}
		}
		if(!imgmath.inBounds(img, p.x, p.y)){
		mouse.rightclick(p);
		}
	}
	private boolean cargoC(Color c){
		scount++;
		
		return(clgc.colMoreLess(c, new Color(200,82,92)));
	}
	private boolean cargoC(BufferedImage img, int x, int y){
		
		if(imgmath.searchBoundries(img,new Point(x,y))){
			
		return cargoC(clgc.pointColor(img, x, y));
		}else{
		return false;
		}
	}
	private boolean cargoC(Point p){
		return cargoC(clgc.pointColor( p.x, p.y));
	}
	private boolean backGround(Color c){
		scount++;
		return(clgc.colMoreLess(new Color(150,150,160),c));
	}
	private boolean backGround(BufferedImage img, int x, int y){
		return backGround(clgc.pointColor(img, x, y));
	}
	
	public void findBonesBox1(){
		img2 = getimage.screanImage();
		for(int y1=0;y1>-16;y1--){
			secondImg(100,100+y1,200,0,0);
			secondImg(100+y1,100,200,0,0);
		}
		
		try {
			ImageIO.write(img2, "BMP", new File("pallsearch"+imgnum+".bmp"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imgnum++;
	}
	public void findBonesBox2(){
		Point p = new Point(30,70);
		 img = getimage.screanImage(p,56,60);
		 img2=img;
		 for(int y= 0;y<img.getHeight()+50;y++){
				for(int x=0;x<img.getWidth()+50;x++){
					
				}
		 }
		 try {
				ImageIO.write(img2, "BMP", new File("pallsearch"+imgnum+".bmp"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public boolean findBonesBox(){
		if(colectseqns==0){
			Point p = new Point(30,70);
		 img = getimage.screanImage(p,getimage.scwidth-60,getimage.scheight-140);
		 img2=img;
		 pntcnt=0;
		 scount=0;
		 bbPNts=new Point[20];
		 bnum=0;
		 //thisPaliePic(400,400);
		 for(int y= 4;y<img.getHeight()-4;y+=17){
				for(int x=4;x<img.getWidth()-4;x+=17){
					if(cargoC(img, x, y)
						&&cargoC(img, x+1, y)
						||cargoC(img, x, y)
						&&cargoC(img, x-1, y)){
						findbb(x,y);
						
					}else{
					secondImg(x,y,0,255,0);
					}
				}
			}
		 System.out.println(bnum);
		try {
			ImageIO.write(img2, "BMP", new File("pallsearch"+imgnum+".bmp"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		imgnum++;
		return false;
	}
	public boolean findBonesBox3(){
		if(colectseqns==0){
			Point p = new Point(30,70);
		 img = getimage.screanImage(p,getimage.scwidth-60,getimage.scheight-140);
		 img2=img;
		 pntcnt=0;
		 scount=0;
		 bbPNts=new Point[20];
		 bnum=0;
		 itorations=0;
		 //thisPaliePic(400,400);
		 for(int y= 4;y<img.getHeight()-4;y+=60){
				for(int x=4;x<img.getWidth()-4;x+=60){
					if(!(cargoC(img, x, y)&&cargoC(img, x+1, y)
							||cargoC(img, x-1, y))&&
							!clgc.pointColor(img, x, y,31,36,43)&&
							!clgc.pointColor(img, x, y,28,33,40)&&
							!clgc.pointColor(img, x, y,27,33,38)&&
							!clgc.pointColor(img, x, y,7,7,7)&&
							!clgc.pointColor(img, x, y,0,0,0)&&
							!clgc.pointColor(img, x, y,22,38,47)){
						
						loop:for(int i =(-30);i<30;i+=16){
							for(int j =(-30);j<30;j+=16){
								itorations++;
								if(findbb2(x+j,y+i)){
									break loop;
								}
								secondImg(x+j,y+i,255,233,255);
							}
						}
					}else{
						findbb2(x,y);
						
					}
					secondImg(x,y,0,255,0);
					itorations++;
				}
			}
		 System.out.println(bnum);
		 System.out.println(itorations);
		/*try {
			ImageIO.write(img2, "BMP", new File("pallsearch"+imgnum+".bmp"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		}
		imgnum++;
		return false;
	}
	
	public boolean findBonesTest(){
		if(colectseqns==0){
			Point p = new Point(30,70);
		 img = getimage.screanImage(p,getimage.scwidth-60,getimage.scheight-140);
		 img2=img;
		 pntcnt=0;
		 scount=0;
		 bbPNts=new Point[20];
		 bnum=0;
		 itorations=0;
		 //thisPaliePic(400,400);
		 for(int y= 4;y<img.getHeight()-4;y+=60){
				for(int x=4;x<img.getWidth()-4;x+=60){
					if(!(cargoC(img, x, y)&&cargoC(img, x+1, y)
							||cargoC(img, x-1, y))&&
							!clgc.pointColor(img, x, y,31,36,43)&&
							!clgc.pointColor(img, x, y,28,33,40)&&
							!clgc.pointColor(img, x, y,27,33,38)&&
							!clgc.pointColor(img, x, y,7,7,7)&&
							!clgc.pointColor(img, x, y,0,0,0)&&
							!clgc.pointColor(img, x, y,22,38,47)){
						
						loop:for(int i =(-30);i<30;i+=14){
							for(int j =(-30);j<30;j+=14){
								itorations++;
								if(findbb2(x+j,y+i)){
									break loop;
								}
								secondImg(x+j,y+i,255,233,255);
							}
						}
					}else{
						findbb2(x,y);
						
					}
					secondImg(x,y,0,255,0);
					itorations++;
				}
			}
		 //bbPNts[pntcnt]
				if(pntcnt!=0){
						rightclick(findClosePnt());
				}
		 System.out.println(bnum);
		 System.out.println(itorations);
		try {
			ImageIO.write(img2, "BMP", new File("pallsearch"+imgnum+".bmp"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		imgnum++;
		return false;
	}
	private boolean findbb2(int x,int y){
		if(cargoC(img, x+1, y)
				||cargoC(img, x-1, y)){
				findbb(x,y);
				return true;
			}
		return false;
	}
	private int bnum=0;
	private void findbb(int x,int y){
		
		loop:for(int x1=(-17);x1<8;x1++){
			for(int y1=(-17);y1<8;y1++){
				int tempx=x+x1;
				int tempy=y+y1;
				itorations++;
				if(cargoC(img, tempx, tempy)){
				if(thisPaliePic3(tempx,tempy)){
					if(thisPaliePic(tempx-13,tempy-15)){
					dracBox(tempx-10,tempy-10);
					bnum++;
					
					bbPNts[pntcnt]=new Point(tempx+7,tempy+5);
					pntcnt++;
					//System.out.println(new Point(tempx+7,tempy+5));
					break loop;
					}
				}
					}
			}
				}
	
			}
	private boolean thisPaliePic3(int x, int y) {
		for(int i=0;i<3;i++){
		for(int x1=0;x1<13;x1+=1){
			itorations++;
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
			itorations++;
		}
		}
		return true;
	}
	private boolean thisPaliePic2(int x, int y) {
		// TODO Auto-generated method stub
		for(int x1=0;x1<12;x1+=2){
			for(int y1=0;y1<8;y1+=2){
				if(!cargoC(img, x+x1, y+y1)){
					return false;
				}
			}
		}
		
		return true;
	}
	private void dracBox(int x, int y) {
		// TODO Auto-generated method stub
		for(int y2=0;y2<46;y2++){
			for(int x2=0;x2<46;x2++){
				if(cargoC(img,x+x2,y+y2)){
				firstImg(x+x2,y+y2,0,5,255);
				secondImg(x+x2,y+y2,0,5,255);
				}
			}
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
				for(int x=(-2);x<2;x++){
					for(int y=(-2);y<2;y++){
						secondImg(p.x+x,p.y+y,255,0,0);
					}
				}
				e[i]=findHipotinus(getimage.centerpt,p);
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
				clickpoint=new Point(p1.x+bbPNts[l].x,p1.y+bbPNts[l].y);
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
		
		return (int) tryangle.findhipotinose(x, y);
	}
	private int pyththeore(int hp,int nownleg){
		return (int) Math.sqrt((Math.pow(hp, 2)+Math.pow(nownleg, 2)));
	}
private void firstImg(int x, int y, int r, int g, int b) {
		// TODO Auto-generated method stub
		if(imgmath.searchBoundries(img,new Point(x,y))){
			img.setRGB(x, y,new Color(r,g,b).getRGB());
		}
	}
		private void secondImg(int x, int y, int r, int g, int b) {
		// TODO Auto-generated method stub
			if(imgmath.searchBoundries(img2,new Point(x,y))){
			img2.setRGB(x, y,new Color(r,g,b).getRGB());
			}
			
	}
		private boolean thisPaliePic(int x1,int y1) {
			int fp=46;
			for (int y = 2; y < fp; y+=3) {
						if(!cargoC(img, y+x1,y1)
								&&!cargoC(img, y+x1,y1+fp)
								&&!cargoC(img,x1+fp,y+y1)
								&&!cargoC(img, x1,y+y1)){
						secondImg(y+x1,y1,255,5,5);
						secondImg(y+x1,y1+fp,255,5,5);
						secondImg(x1+fp,y+y1,255,5,5);
						secondImg(x1,y+y1,255,5,5);
						}else{
							return false;
						}
			}
			
			return true;

		}
	

}
