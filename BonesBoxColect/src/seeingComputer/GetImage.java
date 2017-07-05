package seeingComputer;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class GetImage {
	
	private Rectangle screen=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	public final Point centerpt = new Point(screen.width/2,screen.height/2);
	private Robot rob;
	public GetImage() {
		try {
			rob=new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
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
		return rob.getPixelColor(x, y);
	}
	protected boolean pointEcolor(BufferedImage image
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
	public Color screenColor(Point p) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean pointEcolor(int x, int y, Color color) {
		// TODO Auto-generated method stub
		return pointEcolor(new Point(x,y),color);
	}
}
