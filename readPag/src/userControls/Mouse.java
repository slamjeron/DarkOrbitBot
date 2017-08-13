package userControls;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;

public class Mouse {
	private Robot rob;
	
	public Mouse() {
		
		try {
			rob=new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public void moveCursor(int x,int y){
		
			
		rob.mouseMove(x, y);
	}
	
	public boolean screenBounds(int x,int y){
		return (x < screen.width && y < screen.height && x > 0 && y > 0);
		
	}
	public void moveCursor(Point p){
		if(screenBounds(p.x,p.y)){
			moveCursor(p.x, p.y);
		}
	}
	private Rectangle screen=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	
	public void rightclick(Point p){
		Point mp =MouseInfo.getPointerInfo().getLocation();
		if(screenBounds(p.x,p.y)){
		moveCursor(p);
		rightClick();
		moveCursor(mp);
		}
	}
	public void rightclick(int x,int y){
		
		rightclick(new Point(x,y));
	}
private void rightClick() {
		rob.mousePress(InputEvent.BUTTON1_MASK);
	    rob.mouseRelease(InputEvent.BUTTON1_MASK);
	}
}
