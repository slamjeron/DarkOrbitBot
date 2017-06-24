package pointmath;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import simplifyingFunctions.comonTools;
import simplifyingFunctions.compControls;
import simplifyingFunctions.imageCon;


public class findMap1 extends comonTools {
	public Point locateAI;
	protected boolean shooting;
	public boolean AIHPhere;
	public boolean AIhasSH;
	public Point mapLocate=new Point();
	public int distFromClowd=214;
	protected Point leftColorLocation = new Point();
	protected Point rightColorLocation = new Point();
	protected Point moveleft = new Point();
	protected Point moveRight = new Point();
	protected Rectangle rect=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	protected int senterx=rect.width/2;
	protected int sentery=rect.height/2;
	protected imageCon img=new imageCon();
	protected compControls com=new compControls();
	private BufferedImage mapImg;
	public Point[] gateLocate=new Point[4];
	
	public boolean moveFinder(){
		
BufferedImage image = img.screanImage(rect);
		
			for (int y = 200; y < image.getHeight()-200 ; y++) {
				for (int x = 100; x < image.getWidth()-280; x++) {	
					if(new Color(image.getRGB(x, y)).equals(new Color(153 ,204 , 255))){
			
			mapLocate = new Point(x,y);
			setmapPoints();
          return true;
					}
				}
			}
		 return false;
	}
	public Point findPet(){
		
		BufferedImage image = img.screanImage(rect);
				
					for (int y = 200; y < image.getHeight()-200 ; y++) {
						for (int x = 0; x < image.getWidth()-100; x++) {	
							if (img.pointEcolor(image,x,y,232,225,191)&&
									img.pointEcolor(image,x+21,y,36,43,46)&&
									img.pointEcolor(image,x+11,y,51,49,46)
									) {
					          return new Point(x,y);
							}
						}
					}
				 return null;
			}
	private void setmapPoints(){
		int leftx=20;
		int rightx=340;
		
		  leftColorLocation=new Point(mapLocate.x+leftx, mapLocate.y+5);
		  rightColorLocation=new Point(mapLocate.x+rightx, mapLocate.y+5);
		  moveleft = new Point (mapLocate.x+leftx, mapLocate.y+10);
		  moveRight = new Point (mapLocate.x+rightx, mapLocate.y+10);
		  
		  //com.moveCursor(mapLocate);
		
	}
	public void findGates(){
		mapImg=img.screanImage(mapLocate, 335, 215);
		Point[] pArray=new Point[4];
		gateLocate=pArray;
		int i=0;
		for (int y = 0; y < mapImg.getHeight(); y++) {
			for (int x = 0; x < mapImg.getWidth(); x++) {	
				if(new Color(mapImg.getRGB(x, y)).equals(new Color(204 ,204 , 204))){
		gateLocate[i] = new Point(x+mapLocate.x,y+mapLocate.y);
		i++;
		setmapPoints();
				}
			}
		}
	}
}
