package cargoSight;

import java.util.Timer;
import java.util.TimerTask;

public class colectingTimers {
	protected Timer timer= new Timer();
public void colectT(){
	
	boxes3 cbox=new boxes3();
	cbox.nearShipSearch();
	timer.scheduleAtFixedRate (
		    new TimerTask() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					cbox.findBonesBox();
				}
		    }, 0, 2);
}
}
