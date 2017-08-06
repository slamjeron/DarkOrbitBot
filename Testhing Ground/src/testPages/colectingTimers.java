package testPages;

import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

import cargoSight.boxes3;
import seeingComputer.MainObjects;

public class colectingTimers {
	protected Timer timer= new Timer();
	private boxes3 cbox=new boxes3();
	private MainObjects mObjects=new MainObjects();
public void colect(){
	mObjects.search();
	mObjects.cargo.cbox.mouse.moveCursor(mObjects.shipPet.mapPoint);
	mObjects.shipPet.moving();
	timer.scheduleAtFixedRate (
		
		    new TimerTask() {
				
				@Override
				public void run() {
					
					mObjects.cargo.findCargo();
					if(mObjects.cargo.getLooktime()>8){
						
					}
				}
		    }, 0, 1);
}
public void colectT(){
	mObjects.search();
	Point shippnt = mObjects.shipPet.findShip();
	//cbox.rightclick(new Point(shippnt.x+5,shippnt.y));
	mObjects.cargo.findCargo1();
	
}
}
