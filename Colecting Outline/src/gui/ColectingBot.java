package gui;

import objectFinder.GamePanels;
import objectFinder.GamePanels.panelPoints;
import objectFinder.ImgRobot;
import time.ColectTimers;

public class ColectingBot {

	private boolean firstClick=true;
	private boolean enableTimer;
	private ColectTimers colectTime=new ColectTimers();
	private ImgRobot imgR=new ImgRobot();
	private GamePanels panels= imgR.gamePanels;
	private boolean fleeing;
	protected boolean started;
	public void start() {
		fleeing=colectTime.isFleeing();
		findGamePanels();
		if(fleeing)reset();
		enableTimer=true;
		started=panels.booleans.finishedSearch;
		colectTime.imgR=imgR;
		if(started)
		if(firstClick){
			firstClick=false;
			System.out.println("starting Timer");
		activateTimers();
		}
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
		enableTimer=false;
	}

	public static void reset() {
		// TODO Auto-generated method stub
		
	}

}
