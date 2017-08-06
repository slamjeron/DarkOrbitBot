package userControls;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import gui.ColectRobot;

public class GetImage {
	
	private Rectangle screen=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	public final Point centerpt = new Point(screen.width/2,screen.height/2);
	public int scwidth=screen.width;
	public int scheight=screen.height;
	private Robot rob;
	public searchMath smath;
	public GetImage(Robot rob) {
		this.rob=rob;
		
	}
	
	 public static void main(String[] args) {
		  GetImage img =new GetImage();
   }
	public GetImage() {
		readnum rn = new readnum();
		rn.numtest();
		
		readtxt rt = new readtxt();
				rt.readtest();
				Object health = rt.nim1.getSubimage(x, y, w, h);
		rn.readnum1(health);
	}
	class readnum{
		private int num;
		private String nstr="";
		private BufferedImage nim;
		
		private ArrayList<ArrayList<Point>> pArl3;
	public void numtest(){
		try{
				System.out.println("page"+6);
			BufferedImage im = (BufferedImage)
					(ImageIO.read(new File("num6.png")));
			
			readnum1(im);
			File outputfile = new File("image.png");
			ImageIO.write(nim, "png", outputfile);
	 } catch (IOException e) {
         e.printStackTrace();
     }
	}
	private void setnimcl(int x, int y, Color cl){
		if(nim.getWidth()>x&&x>0&&nim.getHeight()>y&&y>0){
			nim.setRGB(x-1, y, cl.getRGB());
		}
	}
	public void readnum1(BufferedImage im){
		
		pArl3=new ArrayList<ArrayList<Point>>();
         for(int l=2;l<im.getWidth();l++){
         		//numcl(im,l);
        	 if(!this.textcl(im, l-1, 0)){
 				if(this.textcl(im, l, 0)){
 					//numcnt++;
         		testnum(im,l);
         		nstr+=""+num;
 				}}
        	 if(!this.maptextcl(im, l-1, 0)){
  				if(this.maptextcl(im, l, 0)){
  					
  				}}
         }
        
         //System.out.println(numcnt);
        System.out.println(nstr);
        printUnekPointsAlist();
       
         
	}
	private void printUnekPointsAlist(){
		 int numct = 0;
		 for(ArrayList<Point> led:pArl3){
	        	numct++;
	        	System.out.println("fnum"+numct);
				for(Point led2:led){
					
					
					int unn = 0;
					int nml=0;
					String stri = "";
					for(ArrayList<Point> led3:pArl3){
						nml++;
						if(!led.equals(led3)){
							if(!led3.contains(led2)){
								//System.out.println((led2));
								unn++;
							}else{
								stri+="num"+nml+", ";
							}
						}
					}
					if(unn>5){
					System.out.print(stri);
					printPoint(led2);
					
					}
				}
				
				
			}
	}
	public int testnum(BufferedImage im,int x){
		if( textcl(im,x+-1,3)&& textcl(im,x+2,3)){
			num=6;
			//System.out.println(6);
			return num;
		}
		if(textcl(im,x+1, 5)){
			if(textcl(im,x+-2, 4)){
				num=4;
				//System.out.println(num);
				return num;
			}else{
				num=1;
				//System.out.println(num);
				return num;
			}
		}
		if(textcl(im,x+0, 4)){
			num=2;
			//System.out.println(num);
			return num;
		}
		if(textcl(im,x-1,5)&&!textcl(im,x+3,6)
				&&!textcl(im,x+3,3)){
			num=3;
			//System.out.println(num);
			return num;
		}
		if(textcl(im,x+0, 2)){
			num=5;
			//System.out.println(num);
			return num;
		}
		if(textcl(im,x+2, 4)){
			num=7;
			//System.out.println(7);
			return num;
		}
		if(textcl(im,x+0,3)&& textcl(im,x+2,3)){
			num=8;
			//System.out.println(8);
			return num;
		}
		if(textcl(im,x+-1,3)&&textcl(im,x+0,3)){
			num=9;
			//System.out.println(num);
			return num;
		}
		if(textcl(im,x+-1,3)&& textcl(im,x+-1,4)){
			num=0;
			//System.out.println(num);
			return num;
		}
		return 12;
	}
	private boolean textcl(BufferedImage im,int x,int y){
		if(im.getWidth()>x&&x>0){
			Color cl = new Color(im.getRGB(x, y));
		return (cl.equals(new Color(222,222,222))||
				cl.equals(new Color(254,254,254)));
		}else{
			return false;
		}
	}
	private boolean maptextcl(BufferedImage im,int x,int y){
		if(im.getWidth()>x&&x>0){
			Color cl = new Color(im.getRGB(x, y));
		return cl.equals(new Color(255,255,255));
		}else{
			return false;
		}
	}
	public int numcl(BufferedImage im,int x){
		int numWidth=0;
		if(!(textcl(im,x-1,0))){
				if(textcl(im,x,0)){
					for (int i=0;i<6;i++){
						if(!new Color(im.getRGB(x+i, 0)).equals(new Color(222,222,222)))
						break;
								numWidth++;
					}
					ArrayList<Point> pArl=new ArrayList<Point>();
					for(int y1=0;y1<8;y1++){
					for(int x1=x-1;x1<x+numWidth+1;x1++){
						if(textcl(im,x1,y1)){
							pArl.add(new Point(x1-x,y1));	
							//printPoint(new Point(x1-x,y1));
							setnimcl(x1, y1, Color.RED);
							
						}
					}
					}
					 pArl3.add(pArl);
				}
				
		}
		
		return 0;
	}
	
	}
	
	class readtxt{
		private BufferedImage nim;
		public ArrayList<ArrayList<Point>> pArl3;
		public Point mapPnt=new Point();
		public Point shipPnt=new Point();
		public Point petPnt=new Point(0,0);
		public Point userPnt=new Point(0,0);
		public BufferedImage nim1;
		public void readtest() {
			pArl3=new  ArrayList<ArrayList<Point>>() ;
			BufferedImage im;
			try {
				im = (BufferedImage)
						(ImageIO.read(new File("wordsearch.png")));
			
			
			imsearch(im);
			File outputfile = new File("imageword.png");
			ImageIO.write(nim, "png", outputfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		private void imsearch(BufferedImage im) {
			try {
				nim= (BufferedImage)
						(ImageIO.read(new File("wordsearch.png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			imgfilter();
			for(int y =0; y<im.getHeight();y+=100){
				for(int x=2;x<im.getWidth();x++){
					if((mapPnt.x-1<x&&mapPnt.x+3>x&&mapPnt.y+279>y))
						x+=400;
					if((shipPnt.x-1<x&&shipPnt.x+3>x&&shipPnt.y+110>y))
						x+=220;
					if((userPnt.x-1<x&&userPnt.x+3>x&&userPnt.y+100>y))
						x+=220;
					if((petPnt.x-1<x&&petPnt.x+3>x&&petPnt.y+190>y))
						x+=250;
					if(!borderCLR(im, x-1, y+1)
							&&!borderCLR(im, x-1, y)&&borderCLR(im, x, y)){
						
						if(!cltest(im,x+3, y,new Color(0,0,0))){
							
						findCorner(im,x,y);
						
						}
					}else{
						
					}
				}
				}
			try{
			File outputfile = new File("imageword.png");
			ImageIO.write(nim, "png", outputfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//printUnekPointsAlist();
		}
		private boolean cltest(BufferedImage im, int x, int y, Color clr) {
			if(im.getWidth()>x&&x>0&&im.getHeight()>y&&y>0){
				Color cl = new Color(im.getRGB(x, y));
			return cl.equals(clr);
			}else{
				return false;
			}
		}
		private void printColor(BufferedImage im, int x, int y){
			if(im.getWidth()>x&&x>0&&im.getHeight()>y&&y>0){
				Color cl = new Color(im.getRGB(x, y));
			System.out.println("cl("+cl.getRed()+","+cl.getGreen()
			+","+cl.getBlue()+")");
			}
		}
		private void printUnekPointsAlist(){
			 int numct = 0;
			 for(ArrayList<Point> led:pArl3){
		        	numct++;
		        	System.out.println("fnum"+numct);
					for(Point led2:led){
						
						
						int unn = 0;
						int nml=0;
						String stri = "";
						for(ArrayList<Point> led3:pArl3){
							nml++;
							if(!led.equals(led3)){
								if(!led3.contains(led2)){
									//System.out.println((led2));
									unn++;
								}else{
									stri+="num"+nml+", ";
								}
							}
						}
						if(unn>2){
						System.out.print(stri);
						printPoint(led2);
						
						}
					}
					
					
				}
		}
		private void findCorner(BufferedImage im, int x, int y) {
			setnimcl(x, y, Color.yellow);
			int nint=-47;
			for(int in=50;in>1;in/=2){
				//System.out.println(nint);
				//System.out.println(in);
				if(borderCLR(im, x, y+nint)){
					setnimcl(x, y+nint, Color.GREEN);
					nint-=in;
				}else{
					nint+=in;
					setnimcl(x, y+nint, Color.RED);
				}
				if(in<4){
				fcorner(im,x,y+nint);
				}
			}
		}
		private void fcorner(BufferedImage im, int x, int y){
			boolean up = borderCLR(im,x,y);
				for(int i =0;i<5;i++){
					//System.out.println("up"+i);
					int n=0;
					if(up){
						n=-1*i;
					}else{
						n=i;
					}
						
					if(corner(im ,x, y+n)){
						if(textclr(im,x+34,y+n+4)&&textclr(im,x+83,y+n+16)){
							System.out.println("map");
						//printPoint(new Point(x,y+n));
						mapPnt=new Point(x, y+n);
					}
						if(textclr(im,x+50,y+n+4)&&textclr(im,x+57,y+n+13)){
							System.out.println("Ship");
							shipPnt=new Point(x, y+n);
					}
						if(textclr(im,x+65,y+n+12)&&textclr(im,x+43,y+n+13)){
							System.out.println("pet");
						petPnt=new Point(x, y+n);
					}
						if(cltest(im, x+16, y+n+32,new Color(233,226,191))){
							System.out.println("user");
						userPnt=new Point(x, y+n);
						
					}
						System.out.println("foundCorner");
						setnimcl(x, y+n, Color.BLUE);
						checktype(im ,x, y+n);
						break;
					}else{
						setnimcl(x, y+n, Color.WHITE);
					}
					}
			
		}
		private void checktype(BufferedImage im, int x, int y) {
			// TODO Auto-generated method stub
			
			ArrayList<Point> pArl=new ArrayList<Point>();
						
			Point cornerpnt=new Point(x,y);
			int nx=x+34;
			int ny=y+4;
			
			for(int ty=ny;ty<ny+2;ty++){
				for(int tx=nx;tx<nx+50;tx++){
					if(textclr(im,tx,ty)){
						//printPoint(new Point(tx-x,ty-y));
						pArl.add(new Point(tx-nx,ty-ny));
						setnimcl( tx+1, ty-1, Color.RED);
					}else{
						setnimcl( tx+1, ty-1, Color.white);
					}
				}
			}
			pArl3.add(pArl);
		}
		private void setnimcl(int x, int y, Color cl){
			if(nim.getWidth()>x&&x>0&&nim.getHeight()>y&&y>0){
			nim.setRGB(x-1, y, cl.getRGB());
			}
		}
		private boolean corner(BufferedImage im, int x, int y){
			/*Color cl = new Color(im.getRGB(x, y));
			System.out.println(cl);
			 cl= new Color(im.getRGB(x, y));
				System.out.println(cl);*/
			return borderCLR(im, x, y)&&borderCLR(im, x+1, y-1);
		}
		private void imgfilter(){
			for(int y =0; y<nim.getHeight();y++){
				for(int x=0;x<nim.getWidth();x++){
					if(this.textclr(nim, x, y)||borderCLR(nim, x, y)){
						
					}else{
						setnimcl(x, y, Color.BLACK);
					}
				}
				}
		}
		private boolean borderCLR(BufferedImage im, int x, int y) {
			if(im.getWidth()>x&&x>0&&im.getHeight()>y&&y>0){
				Color cl = new Color(im.getRGB(x, y));
			return cl.equals(new Color(40,116,144));
			}else{
				return false;
			}
		}
		private boolean textclr(BufferedImage im,int x,int y){
			if(im.getWidth()>x&&x>0){
				Color cl = new Color(im.getRGB(x, y));
			return cl.equals(new Color(232,225,191));
			}else{
				return false;
			}
		}
		
	}
	private void printPoint(Point p){
		System.out.println("textcl(im,x+"+p.x+","+p.y+")");
	}


	public BufferedImage changeIngColor(BufferedImage img,int x,int y,Color color){
		if(smath.inBounds(img, x, y)){
		img.setRGB(x, y, color.getRGB());
		}
		return img; 
	}
	public BufferedImage screanImage(){
		return rob.createScreenCapture(screen);
	}
	public BufferedImage screanImage(int x,int y,int width,int hight){
		return rob.createScreenCapture(new Rectangle(x,y,width,hight));
	}
	public BufferedImage screanImage(Point p,int width,int hight){
		return rob.createScreenCapture(new Rectangle(p.x,p.y,width,hight));
	}
	public boolean pointEcolor(BufferedImage img, int x, int y, int i, int j, int k) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
