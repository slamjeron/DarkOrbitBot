package objectFinder;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class GamePanels {

	public panelPoints points;
	public panelBool booleans;
	public Colorlogic colLogic;
	private GetImage screenCapture;
	private toolSrch tool=new toolSrch();
 	public GamePanels(Colorlogic clogic, GetImage image) {
		screenCapture=image;
		colLogic=clogic;
	}
	public void find() {
		points= new panelPoints();
		booleans=new panelBool();
		BufferedImage im = screenCapture.getScreenImage();
		imsearch(im);
		tool.colLogic=colLogic;
		tool.toolBar(im);
		if(tool.toolBarPt.x>0)
			points.toolBar=tool.toolBarPt;
	}
	private void imsearch(BufferedImage im) {
	
		loop:for(int y =2; y<im.getHeight();y+=100){
			for(int x=0;x<im.getWidth();x++){
				x=skipLocatedItem(x,y);
				if(edgofPanel(im, x, y))
					findCorner(im,x,y);
				
				if(allItemsFound()){
					booleans.finishedSearch=true;
					break loop;
				}
			}
		}
	
	}
	
	public boolean allItemsFound(){
		
		return(booleans.user&&booleans.pet&& booleans.ship&&booleans.map);
	}
	
	private int skipLocatedItem(int x,int y){
		if(ispointFound(points.map,279,x,y))
			x+=400;
		if(ispointFound(points.ship,110,x,y))
			x+=220;
		if(ispointFound(points.user,100,x,y))
			x+=190;
		if(ispointFound(points.pet,190,x,y))
			x+=260;
		return x;
	}
	private boolean ispointFound(Point p,int hight,int x,int y){
		Rectangle rct = new Rectangle(p.x-1,p.y,3,hight);
		return(rct.contains(x, y));
	}
	private boolean edgofPanel(BufferedImage im,int x,int y){
		return(!borderCLR(im, x-1, y+1)
				&&!borderCLR(im, x-1, y)&&borderCLR(im, x, y));
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
	
	private void checkItems(BufferedImage im, int x, int ny){
			checkmap(im,x,ny);
			checkship(im,x,ny);
			checkpet(im, x,ny);
			checkUser(im, x, ny);
	}
	private void checkmap(BufferedImage im, int x, int y){
		if(!booleans.map&&textclr(im,x+34,y+4)&&textclr(im,x+83,y+16)){
			System.out.println("map");
			booleans.map=true;
		points.map=new Point(x, y);
		}
	}	
	private void checkship(BufferedImage im, int x, int y){
		if(!booleans.ship&&
				borderCLR(im,x+212,y+104)){
			//colLogic.pointEcolor(im,x+10,y+16,52,82,96);
			
			
			//refPoint colLogic.pointEcolor(x+19, y+40,207,188,152);
			System.out.println("Ship");
			//colLogic.printPColer(im,x+10, y+16);
			//colLogic.printPColer(im,x+212, y+104);
			booleans.ship=true;
			points.ship=new Point(x, y);
		}
	}
	private void checkpet(BufferedImage im, int x, int y){
		if(!booleans.pet&&textclr(im,x+65,y+12)&&textclr(im,x+43,y+13)){
			System.out.println("pet");
			booleans.pet=true;
			points.pet=new Point(x, y);
		}
	}
	private void checkUser(BufferedImage im, int x, int y){
		if(!booleans.user&&borderCLR(im, x+214, y+98)){
			System.out.println("user");
			booleans.user=true;
			points.user=new Point(x, y);
		}
	}
	
	private boolean corner(BufferedImage im, int x, int y){
		return borderCLR(im, x, y)&&borderCLR(im, x+1, y-1);
	}
	
	private boolean borderCLR(BufferedImage im, int x, int y) {
		return colLogic.pointEcolor(im,x,y,new Color(40,116,144));
	}
	
	private boolean textclr(BufferedImage im,int x,int y){
		return colLogic.pointEcolor(im,x,y,new Color(232,225,191));
	}
	
	public class panelPoints{
		public Point map=new Point();
		public Point pet=new Point();
		public Point ship=new Point();
		public Point user=new Point();
		private Point toolBar=new Point();
		public Point getToolBar(){
			return toolBar;
		}
		public void setToolBar(Point p){
			//System.out.println("toolB="+p.x+","+p.y);
			toolBar=p;
		}
	}
	
	public class panelBool{
		public boolean map=false;
		public boolean pet=false;
		public boolean ship=false;
		public boolean user=false;
		public boolean finishedSearch=false;
		
	}
	
}
