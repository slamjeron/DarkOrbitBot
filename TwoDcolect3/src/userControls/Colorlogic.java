package userControls;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Point;
import java.awt.Robot;
import java.awt.image.BufferedImage;

public class Colorlogic {
	public Colorlogic(searchMath smath) {
		// TODO Auto-generated constructor stub
		//this.smath=smath;
	}
	public Colorlogic() {
		// TODO Auto-generated constructor stub
	}
	public Color pointColor(BufferedImage img,Point p){
		return pointColor(img,p.x, p.y);
	}
	public Color pointColor(BufferedImage img,int x,int y){
		return new Color(img.getRGB(x, y));
	}
	public Color pointColor(Point p){
		return pointColor(p.x, p.y);
	}
	public Color pointColor(int x,int y){
		Robot rob;
		Color c = new Color(0,0,0);
		try {
			rob = new Robot();
			c= rob.getPixelColor(x, y);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	public boolean pointEcolor(BufferedImage image
			, int x, int y, int r, int g, int b) {
		return pointEcolor(image, x, y,new Color(r, g, b));
	}
	protected boolean pointEcolor(BufferedImage image
			, int x, int y, Color c) {
		return pointColor(image, x, y).equals(c);
	}
	public boolean pointsevinty(BufferedImage Image, int x, int y) {
		return pointEcolor(Image,x,y,70,70,70);
	}
	public boolean pointEcolor(Point point, int r, int g, int b) {
		return pointEcolor(point,new Color(r,g,b));
		
	}
	public boolean pointEcolor(Point point,Color c) {
		return pointColor(point).equals(c);
		
	}
	public boolean colMoreLess(Color more,Color less){
		return(more.getRed()>less.getRed()&&more.getGreen()>less.getGreen()&&more.getBlue()>less.getBlue());
	}
	
	public boolean pointEcolor(int x, int y, Color color) {
		// TODO Auto-generated method stub
		return pointEcolor(new Point(x,y),color);
	}
	public void printPColer(Point p) {
		// TODO Auto-generated method stub
		printColor(pointColor(p));
	}
	public void printColor(Color color) {
		// TODO Auto-generated method stub
		System.out.println("new Color("+color.getRed()+","
		+color.getGreen()+","+color.getBlue()+"),");
	}
	public void printPColer(int x, int y) {
		// TODO Auto-generated method stub
		printPColer(new Point(x,y));
	}
	public boolean pointEcolor(int x, int y, int r, int g, int b) {
		// TODO Auto-generated method stub
		return pointEcolor(x,y,new Color(r,g,b));
	}
	public boolean pointColor(BufferedImage img, int x, int y, int r, int g, int b) {
		
		return pointColor(img,x,y).equals(new Color(r,g,b));
	}
	
}
