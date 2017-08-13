package userControls;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class panelFinder{
	
	private Rectangle screen=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	public final Point centerpt = new Point(screen.width/2,screen.height/2);
	public int scwidth=screen.width;
	public int scheight=screen.height;
	public panelSearch pnlSearch;
	public textRect text=new textRect();
	public panelRect panel=new panelRect();
	public ReadText readText=new ReadText();
 	public void findPanels(BufferedImage image){
		pnlSearch = new panelSearch();
		pnlSearch.imsearch(image);
		readText.setText(text);
		
	}
	
public class textRect{
	public Rectangle shiphpRect;
	public Rectangle shipSDRect;
	public Rectangle shipCBRect;
	public Rectangle speedRect;
	public Rectangle petHPRect;
	public Rectangle petSDRect;
	public Point petHPEndPt;
	public Point petSDEndPt;
}
	public class panelRect{
	public Rectangle shipRect;
	public Rectangle petRect;
	public Rectangle userRect;
	public Rectangle mapRect;
}
	public class panelSearch{
		public boolean userFound=false;
		public boolean petFound=false;
		public boolean shipFound=false;
		public boolean mapFound=false;
		public Point mapPnt=new Point(0,0);
		public Point shipPnt=new Point(0,0);
		public Point petPnt=new Point(0,0);
		public Point userPnt=new Point(0,0);
		public void imsearch(BufferedImage im) {
			loop:for(int y =0; y<im.getHeight();y+=100){
				for(int x=2;x<im.getWidth();x++){
					x=skipLocatedItem(x,y);
					if(edgofPanel(im, x, y))
						findCorner(im,x,y);
					
					if(allItemsFound())
						break loop;
				}
			}
			setTextLocations();
			setPanelRects();
			System.out.println(panel.mapRect);
		}
		
		public boolean allItemsFound(){
			return( userFound&& petFound&& shipFound&&mapFound);
		}
		
		private int skipLocatedItem(int x,int y){
			if((mapPnt.x-1<x&&mapPnt.x+3>x&&mapPnt.y+279>y))
				x+=400;
			if((shipPnt.x-1<x&&shipPnt.x+3>x&&shipPnt.y+110>y))
				x+=220;
			if((userPnt.x-1<x&&userPnt.x+3>x&&userPnt.y+100>y))
				x+=220;
			if((petPnt.x-1<x&&petPnt.x+3>x&&petPnt.y+190>y))
				x+=250;
			return x;
		}
		private boolean edgofPanel(BufferedImage im,int x,int y){
			return(!borderCLR(im, x-1, y+1)
					&&!borderCLR(im, x-1, y)&&borderCLR(im, x, y));
		}
		private void setTextLocations(){
			text.shiphpRect=new Rectangle(shipPnt.x+34,shipPnt.y+38,50,8);
			text.shipSDRect=new Rectangle(shipPnt.x+34,shipPnt.y+55,50,8);
			text.speedRect=new Rectangle(shipPnt.x+125,shipPnt.y+55,25,8);
			text.petHPRect=new Rectangle(petPnt.x+82,petPnt.y+49,60,8);
			text.petHPEndPt=new Point(petPnt.x+151,petPnt.y+58);
			text.petSDRect=new Rectangle(petPnt.x+82,petPnt.y+69,60,8);
			text.petSDEndPt=new Point(petPnt.x+151,petPnt.y+78);
		}
		private void setPanelRects(){
			if(allItemsFound()){
			panel.mapRect=new Rectangle(mapPnt.x,mapPnt.y,386,275);
			panel.petRect=new Rectangle(petPnt.x,petPnt.y,270,150);
			panel.shipRect=new Rectangle(shipPnt.x,shipPnt.y,224,105);
			panel.userRect=new Rectangle(userPnt.x,userPnt.y,250,190);
			}
			
		}
		
		private void findCorner(BufferedImage im, int x, int y) {
			int nint=-47;
			for(int in=50;in>1;in/=2){
				if(borderCLR(im, x, y+nint)){
					nint-=in;
				}else{
					nint+=in;
				}
				if(in<4){
					fcorner(im,x,y+nint);
				}
			}
		}
		private void fcorner(BufferedImage im, int x, int y){
			boolean up = borderCLR(im,x,y);
				for(int i =0;i<5;i++){
					int n=0;
					if(up){n=-1*i;}else{n=i;}
						int ny=y+n;
						if(corner(im ,x, ny)){
						checkItems(im,x,ny);
						}
					}
			
		}
		public void checkItems(BufferedImage im, int x, int ny){
				checkmap(im,x,ny);
				checkship(im,x,ny);
				checkpet(im, x,ny);
				checkUser(im, x, ny);
		}
		public void checkmap(BufferedImage im, int x, int y){
			if(textclr(im,x+34,y+4)&&textclr(im,x+83,y+16)){
				System.out.println("map");
				mapFound=true;
			mapPnt=new Point(x, y);
			}
		}
		public void checkship(BufferedImage im, int x, int y){
			if(textclr(im,x+50,y+4)&&textclr(im,x+57,y+13)){
				System.out.println("Ship");
				shipFound=true;
				readText.setShipFound(shipFound);
				shipPnt=new Point(x, y);
			}
		}
		public void checkpet(BufferedImage im, int x, int y){
			if(textclr(im,x+65,y+12)&&textclr(im,x+43,y+13)){
				System.out.println("pet");
				petFound=true;
				readText.setPetFound(true);
				petPnt=new Point(x, y);
			}
		}
		public void checkUser(BufferedImage im, int x, int y){
			if(cltest(im, x+16, y+32,new Color(233,226,191))){
				System.out.println("user");
				userFound=true;
			userPnt=new Point(x, y);
			}
		}
		private boolean corner(BufferedImage im, int x, int y){
			return borderCLR(im, x, y)&&borderCLR(im, x+1, y-1);
		}
		
		private boolean borderCLR(BufferedImage im, int x, int y) {
			return cltest(im,x,y,new Color(40,116,144));
		}
		private boolean textclr(BufferedImage im,int x,int y){
			
			return cltest(im,x,y,new Color(232,225,191));
			
		}
		
	}
	public boolean PointWhithinImage(BufferedImage im, int x, int y){
		return (x < im.getWidth() && y < im.getHeight() && x > 0 && y > 0);
	}
	private boolean cltest(BufferedImage im, int x, int y, Color clr){
		if (PointWhithinImage(im,x,y)) {
			Color cl = new Color(im.getRGB(x, y));
		return cl.equals(clr);
		}else{
			return false;
		}
	}
	
	
}
