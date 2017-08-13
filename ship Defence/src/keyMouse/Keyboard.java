package keyMouse;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Keyboard {
public Keyboard(){
	try {
		rob=new Robot();
	} catch (AWTException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	private Robot rob;
	public void type(int i) {
		 if (i > 0 && i < 9){
		int code=i+48;
		System.out.println(code);
		System.out.println(KeyEvent.VK_0);
		rob.keyPress(code);
	     rob.keyRelease(code);
		 }
	}
	public void type(String s) {
		// TODO Auto-generated method stub
		
		   byte[] bytes = s.getBytes();
		   for (byte b : bytes){
		     int code = b;
		     System.out.println(code);
		     if (code > 96 && code < 123) code -=32;
		     if (code > 96 && code < 123) code -= 32;
		     //System.out.println(Ekeykod.);
		     rob.keyPress(code);
		     rob.keyRelease(code);
		   
		 }
	}

}
