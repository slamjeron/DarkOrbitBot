package simplifyingFunctions;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class imageCon {
	private Robot rob;
	public void printPointColor(int x,int y){
		colorPrint(screenColor(new Point(x,y)));
	}
	public Boolean colmore(Color more,Color less){
		return(more.getRed()>less.getRed()&&more.getGreen()>less.getGreen()&&more.getBlue()>less.getBlue());
	}
	public Boolean compScPxtoCol(Point p,Color c){
		//System.out.println(screenColor(p));
		return screenColor(p).equals(c);
	}
	public Color screenColor(Point p){
		try {
			rob=new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return(rob.getPixelColor(p.x, p.y));
	}
	public void colorPrint(Color c){
		System.out.println(",new Color("+c.getRed()+","+c.getGreen()+","+c.getBlue()+")");
	}
	public BufferedImage screanImage(Point p, int width,int hight){
		return(screanImage(new Rectangle(p.x,p.y,width,hight)));
	}
	public BufferedImage screanImage(){
		try {
			rob=new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screanImage( new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		
	}
	public BufferedImage screanImage(Rectangle rect){
		try {
			rob=new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rob.createScreenCapture(rect);
		
	}
	public BufferedImage screanImage(int x, int y, int width, int hight) {
		// TODO Auto-generated method stub
		return(screanImage(new Rectangle(x,y,width,hight)));
		
	}
	public Color screenColor(int x, int y) {
		// TODO Auto-generated method stub
		return screenColor(new Point(x,y));
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

}