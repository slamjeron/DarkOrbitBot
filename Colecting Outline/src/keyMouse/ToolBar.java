package keyMouse;

import java.awt.Point;
import java.awt.image.BufferedImage;

import objectFinder.Colorlogic;
import objectFinder.ImgRobot;

public class ToolBar {

	public Point pnt;
	public Colorlogic imgRead;
	public Keyboard keyB;
public void findItems(BufferedImage screenImg){
	for(int x=pnt.x+19;x<pnt.x+390;x+=40){
		for(int y=pnt.y+3;y<pnt.y+20;y++){
			imgRead.printPColer(imgRead, x, y);
		}
	}
}
}
