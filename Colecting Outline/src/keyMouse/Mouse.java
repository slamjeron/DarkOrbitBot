package keyMouse;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;

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
	public void moveCursor(Point p){
		moveCursor(p.x, p.y);
	}
	private Rectangle screen=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	
	public void rightclick(Point p){
		Point mp =MouseInfo.getPointerInfo().getLocation();
		if(p.x<screen.width&&p.y<screen.height&&p.x>0&&p.y>0){
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
