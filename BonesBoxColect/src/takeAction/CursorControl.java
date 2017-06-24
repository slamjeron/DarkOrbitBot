package takeAction;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

import seeingComputer.StaticInfo;

public class CursorControl {
	
	private Robot rob;
	private StaticInfo stc;
	public CursorControl(StaticInfo s) {
		stc=s;
		try {
			rob=new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	public void type(int i){
		int key = 48+i;
		rob.keyPress(key);
		rob.keyRelease(key);
	}
	public void moveCursor(int x,int y){
		rob.mouseMove(x, y);
	}
	public void moveCursor(Point p){
		moveCursor(p.x, p.y);
	}
	public void rightclick(Point p){
		Point mp =MouseInfo.getPointerInfo().getLocation();
		
		moveCursor(p);
		rightClick();
		moveCursor(mp);
	}
	public void rightclick(int x,int y){
		rightclick(new Point(x,y));
	}
private void rightClick() {
		
		rob.mousePress(InputEvent.BUTTON1_MASK);
	    rob.mouseRelease(InputEvent.BUTTON1_MASK);
	}
public boolean toolredy(int i){
	return stc.toolbar.toolredy(i);
}
public void keepToolActive(int k){
	if(toolredy(k)){
		type(k);
	}
}
public void type(String string) {
	 byte[] bytes = string.getBytes();
	   for (byte b : bytes){
	     int code = b;
	     if (code > 96 && code < 123) code = code - 32;
	     rob.keyPress(code);
	     rob.keyRelease(code);
	   }
	
}
}
