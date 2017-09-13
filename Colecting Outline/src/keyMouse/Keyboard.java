package keyMouse;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Keyboard {
public Keyboard(){
	try {
		rob=new Robot();
	} catch (AWTException e) {
		e.printStackTrace();
	}
}
	private Robot rob;
	public void type(int i) {
		 if (i > 0 && i < 10){
		int code=i+48;
		rob.keyPress(code);
	     rob.keyRelease(code);
		 }
	}
	public void type(String s) {
		   byte[] bytes = s.getBytes();
		   for (byte b : bytes){
		     int code = b;
		     if (code > 96 && code < 123) code -=32;
		     if (code > 96 && code < 123) code -= 32;
		     rob.keyPress(code);
		     rob.keyRelease(code);
		   
		 }
	}

}
