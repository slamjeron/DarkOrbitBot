package takeAction;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
<<<<<<< HEAD
=======
import java.awt.event.KeyEvent;
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201

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
<<<<<<< HEAD
=======
	public CursorControl() {
		try {
			rob=new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
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
<<<<<<< HEAD
=======
	public void sleep(int i){
		try {
			rob.wait(i*100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
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
<<<<<<< HEAD
public void type(String string) {
	 byte[] bytes = string.getBytes();
	   for (byte b : bytes){
	     int code = b;
	     if (code > 96 && code < 123) code = code - 32;
	     rob.keyPress(code);
	     rob.keyRelease(code);
	   }
	
=======
public void typep(){
rob.keyPress(KeyEvent.VK_SHIFT);
rob.keyPress(KeyEvent.VK_QUOTE);
rob.keyRelease(KeyEvent.VK_QUOTE );
rob.keyRelease(KeyEvent.VK_SHIFT);
}
public void typepp(){

rob.keyPress(KeyEvent.VK_QUOTE);
rob.keyRelease(KeyEvent.VK_QUOTE );

}
public void typek(String st){
	rob.keyPress(KeyEvent.VK_SHIFT);
	type(st);
	rob.keyRelease(KeyEvent.VK_SHIFT);
}

	


public void typek(int i) {
	rob.keyPress(KeyEvent.VK_SHIFT);
	type(i);
	rob.keyRelease(KeyEvent.VK_SHIFT);
	try {
		Thread.sleep(200);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void type(CharSequence characters) {
    int length = characters.length();
    //System.out.println(characters);
    for (int i = 0; i < length; i++) {
        char character = characters.charAt(i);
       type(character);
        
    }
}

public void type(char character) {
    switch (character) {
    case 'a': doType(KeyEvent.VK_A); break;
    case 'b': doType(KeyEvent.VK_B); break;
    case 'c': doType(KeyEvent.VK_C); break;
    case 'd': doType(KeyEvent.VK_D); break;
    case 'e': doType(KeyEvent.VK_E); break;
    case 'f': doType(KeyEvent.VK_F); break;
    case 'g': doType(KeyEvent.VK_G); break;
    case 'h': doType(KeyEvent.VK_H); break;
    case 'i': doType(KeyEvent.VK_I); break;
    case 'j': doType(KeyEvent.VK_J); break;
    case 'k': doType(KeyEvent.VK_K); break;
    case 'l': doType(KeyEvent.VK_L); break;
    case 'm': doType(KeyEvent.VK_M); break;
    case 'n': doType(KeyEvent.VK_N); break;
    case 'o': doType(KeyEvent.VK_O); break;
    case 'p': doType(KeyEvent.VK_P); break;
    case 'q': doType(KeyEvent.VK_Q); break;
    case 'r': doType(KeyEvent.VK_R); break;
    case 's': doType(KeyEvent.VK_S); break;
    case 't': doType(KeyEvent.VK_T); break;
    case 'u': doType(KeyEvent.VK_U); break;
    case 'v': doType(KeyEvent.VK_V); break;
    case 'w': doType(KeyEvent.VK_W); break;
    case 'x': doType(KeyEvent.VK_X); break;
    case 'y': doType(KeyEvent.VK_Y); break;
    case 'z': doType(KeyEvent.VK_Z); break;
    case 'A': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_A); break;
    case 'B': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_B); break;
    case 'C': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_C); break;
    case 'D': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_D); break;
    case 'E': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_E); break;
    case 'F': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_F); break;
    case 'G': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_G); break;
    case 'H': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_H); break;
    case 'I': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_I); break;
    case 'J': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_J); break;
    case 'K': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_K); break;
    case 'L': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_L); break;
    case 'M': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_M); break;
    case 'N': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_N); break;
    case 'O': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_O); break;
    case 'P': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_P); break;
    case 'Q': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_Q); break;
    case 'R': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_R); break;
    case 'S': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_S); break;
    case 'T': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_T); break;
    case 'U': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_U); break;
    case 'V': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_V); break;
    case 'W': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_W); break;
    case 'X': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_X); break;
    case 'Y': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_Y); break;
    case 'Z': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_Z); break;
    case '`': doType(KeyEvent.VK_BACK_QUOTE); break;
    case '0': doType(KeyEvent.VK_0); break;
    case '1': doType(KeyEvent.VK_1); break;
    case '2': doType(KeyEvent.VK_2); break;
    case '3': doType(KeyEvent.VK_3); break;
    case '4': doType(KeyEvent.VK_4); break;
    case '5': doType(KeyEvent.VK_5); break;
    case '6': doType(KeyEvent.VK_6); break;
    case '7': doType(KeyEvent.VK_7); break;
    case '8': doType(KeyEvent.VK_8); break;
    case '9': doType(KeyEvent.VK_9); break;
    case '-': doType(KeyEvent.VK_MINUS); break;
    case '=': doType(KeyEvent.VK_EQUALS); break;
    case '~': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_BACK_QUOTE); break;
    case '!': doType(KeyEvent.VK_EXCLAMATION_MARK); break;
    case '@': doType(KeyEvent.VK_AT); break;
    case '#': doType(KeyEvent.VK_NUMBER_SIGN); break;
    case '$': doType(KeyEvent.VK_DOLLAR); break;
    case '%': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_5); break;
    case '^': doType(KeyEvent.VK_CIRCUMFLEX); break;
    case '&': doType(KeyEvent.VK_AMPERSAND); break;
    case '*': doType(KeyEvent.VK_ASTERISK); break;
    case '(': doType(KeyEvent.VK_LEFT_PARENTHESIS); System.out.println("tryint to print");break;
    case ')': doType(KeyEvent.VK_RIGHT_PARENTHESIS);System.out.println("tryint to print"); break;
    case '_': doType(KeyEvent.VK_UNDERSCORE); break;
    case '+': doType(KeyEvent.VK_PLUS); break;
    case '\t': doType(KeyEvent.VK_TAB); break;
    case '\n': doType(KeyEvent.VK_ENTER); break;
    case '[': doType(KeyEvent.VK_OPEN_BRACKET); break;
    case ']': doType(KeyEvent.VK_CLOSE_BRACKET); break;
    case '\\': doType(KeyEvent.VK_BACK_SLASH); break;
    case '{': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_OPEN_BRACKET); break;
    case '}': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_CLOSE_BRACKET); break;
    case '|': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_BACK_SLASH); break;
    case ';': doType(KeyEvent.VK_SEMICOLON); break;
    case ':': doType(KeyEvent.VK_COLON); break;
    case '\'': doType(KeyEvent.VK_QUOTE); break;
    case '"': doType(KeyEvent.VK_SHIFT,KeyEvent.VK_QUOTE); break;
    case ',': doType(KeyEvent.VK_COMMA); break;
    case '<': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_COMMA); break;
    case '.': doType(KeyEvent.VK_PERIOD); break;
    case '>': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_PERIOD); break;
    case '/': doType(KeyEvent.VK_SLASH); break;
    case '?': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_SLASH); break;
    case ' ': doType(KeyEvent.VK_SPACE); break;
    default:
        throw new IllegalArgumentException("Cannot type character " + character);
    }
}

private void doType(int... keyCodes) {
    doType(keyCodes, 0, keyCodes.length);
}

private void doType(int[] keyCodes, int offset, int length) {
    if (length == 0) {
        return;
    }

    rob.keyPress(keyCodes[offset]);
    doType(keyCodes, offset + 1, length - 1);
    rob.keyRelease(keyCodes[offset]);
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
}
}
