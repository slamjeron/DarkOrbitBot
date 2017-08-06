package userControls;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

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
