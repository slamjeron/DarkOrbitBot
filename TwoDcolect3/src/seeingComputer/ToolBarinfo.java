package seeingComputer;

import java.awt.Point;
import userControls.ImgRobot;

public class ToolBarinfo {
	
	private ImgRobot imgcon;
	private Point[] tools = new Point[11];
	
	public ToolBarinfo(ImgRobot imgcon2) {
		imgcon=imgcon2;
	}
	public boolean toolredy(int toolnum){
		if(toolnum>9){
			toolnum=9;
		}
		if(toolnum==0){
			toolnum=10;
		}
		
		//imgcon.moveCursor(tools[toolnum]);
		return imgcon.clogic.pointEcolor(tools[toolnum],44,114,140);
		
	}
	public void setToolbarPnt(Point toolbarPnt) {
		for (int i = 1; i < tools.length; i++) {
			tools [i] = new Point(toolbarPnt.x+(i-1)*40+10, (toolbarPnt.y+10)-13);			
		}
	}

}
