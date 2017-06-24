package simplifyingFunctions;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class compControls {
private Robot rob;
public Point mp;
public void playResourcesound(String resource){
		 try {
		     URL defaultSound = getClass().getResource(resource);
		     
		     
		     AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(defaultSound);
		     Clip clip = AudioSystem.getClip();
		     clip.open(audioInputStream);
		     clip.start( );
		     Thread.sleep(clip.getMicrosecondLength()/1000);
		} catch (Exception ex) {
			
		     ex.printStackTrace();
		}
		}
public void doubleRightClk(Point p) {
	mp =MouseInfo.getPointerInfo().getLocation();
	
		moveCursor(p);
		rightClick();
		sleepm(100);
		rightClick();
		sleepm(100);
		rightClick();
		moveCursor(mp);
	
	}
public void doubleRightClk(int x,int y) {
	
	mp =MouseInfo.getPointerInfo().getLocation();
	
	moveCursor(x, y);
	rightClick();
	sleepm(100);
	rightClick();
	sleepm(100);
	rightClick();
	moveCursor(mp);
	
	}
public void rightClk(Point p) {
	mp =MouseInfo.getPointerInfo().getLocation();
	
		moveCursor(p);
		rightClick();
		moveCursor(mp);
	
	}
public void rightClk(int x,int y) {
	
	mp =MouseInfo.getPointerInfo().getLocation();
	
	moveCursor(x, y);
	rightClick();
	moveCursor(mp);
	
	}
private void rightClick() {
		try {
			rob = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		rob.mousePress(InputEvent.BUTTON1_MASK);
	    rob.mouseRelease(InputEvent.BUTTON1_MASK);
	}
public void printPoint(Point p){
	System.out.println("new Point("+p.x+","+p.y+")");
}
public void printPoint(int x,int y){
	System.out.println("new Point("+x+","+y+"),");
}
public void moveCursor(Point p) {
		try {
			rob = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		moveCursor(p.x, p.y);
}
public void moveCursor(int x,int y) {
		
		
		try {
			rob = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rob.mouseMove(x, y);
}

public void type(String s){
	 try {
		rob = new Robot();
	} catch (AWTException e) {
		e.printStackTrace();
	}
   byte[] bytes = s.getBytes();
   for (byte b : bytes){
     int code = b;
     if (code > 96 && code < 123) code = code - 32;
     rob.keyPress(code);
     rob.keyRelease(code);
   }
 }
public void type(int i){
	try {
		rob = new Robot();
	} catch (AWTException e) {
		e.printStackTrace();
	}
	switch (i){
	case 1: rob.keyPress( KeyEvent.VK_1 );
	   rob.keyRelease( KeyEvent.VK_1 ); break;
	case 2:rob.keyPress( KeyEvent.VK_2 );
	   rob.keyRelease( KeyEvent.VK_2 ); break;
	case 3:rob.keyPress( KeyEvent.VK_3 );
	   rob.keyRelease( KeyEvent.VK_3 ); break;
	case 4:rob.keyPress( KeyEvent.VK_4 );
	   rob.keyRelease( KeyEvent.VK_4 ); break;
	case 5:rob.keyPress( KeyEvent.VK_5 );
	   rob.keyRelease( KeyEvent.VK_5 ); break;
	case 6:rob.keyPress( KeyEvent.VK_6 );
	   rob.keyRelease( KeyEvent.VK_6 ); break;
	case 7:rob.keyPress( KeyEvent.VK_7 );
	   rob.keyRelease( KeyEvent.VK_7 ); break;
	case 8:rob.keyPress( KeyEvent.VK_8 );
	   rob.keyRelease( KeyEvent.VK_8 ); break;
	case 9:rob.keyPress( KeyEvent.VK_9 );
	   rob.keyRelease( KeyEvent.VK_9 ); break;
	case 0:rob.keyPress( KeyEvent.VK_0 );
	   rob.keyRelease( KeyEvent.VK_0 ); break;
	}
}
public void sleepm(int mc){
	try {
		
		Thread.sleep(mc);
	} catch (InterruptedException ex) {
		Thread.currentThread().interrupt();
	}
}
public void sleepc(int seconds){
	try {
		Thread.sleep(seconds*1000);
	} catch (InterruptedException ex) {
		Thread.currentThread().interrupt();
	}
}

}
