package gui;

import objectFinder.GamePanels;
import objectFinder.GamePanels.panelPoints;
import objectFinder.ImgRobot;
import time.ColectTimers;

public class ColectingBot {
public ColectingBot(){
	colectTime=new ColectTimers();
	imgR=new ImgRobot();
}
	private boolean firstClick=true;
	private ColectTimers colectTime=new ColectTimers();
	private ImgRobot imgR=new ImgRobot();
	private GamePanels panels= imgR.gamePanels;
	protected boolean started=false;
	public void start() {
		findGamePanels();
		started=panels.booleans.finishedSearch;
		colectTime.imgR=imgR;
		colectTime.setUp();
		colectTime.timerEnable=true;
		if(started)
		activateTimers();
		
		
	}

	private void findGamePanels() {
		panels.find();
		panelPoints panelPnts = panels.points;
		colectTime.panels=panelPnts;
	}

	private void activateTimers() {
		
		colectTime.start();
		
	}

	public void stop() {
		// TODO Auto-generated method stub
		colectTime.timerEnable=false;
		
	}

	

}
